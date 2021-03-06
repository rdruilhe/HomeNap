/**
 * UPnPGenNotifier.java
 *
 * generated by UPNPGEN ( by Marius TANKEU)
 * tankeudekuigwa@yahoo.fr
 */

package com.orange.homenap.globalcoordinator.upnp.holders;


import org.osgi.service.upnp.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Iterator;
import java.util.Properties;
import java.util.Vector;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.Filter;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceListener;

    /**
	* null
	*/
public class UPnPGenNotifier implements PropertyChangeListener, ServiceListener{
	private Vector eventListeners;
	private BundleContext context;
	private String deviceId;
	private UPnPService service;
	private Properties properties;
	private String serviceId;
	public UPnPGenNotifier(String newDeviceId, UPnPService newService,BundleContext context) {
		eventListeners = new Vector(10);
		deviceId  = newDeviceId;
		service   = newService;
		serviceId = service.getId();
		this.context = context;
		createNotifier(deviceId);
	}
	private void createNotifier(String deviceId) {		
		ServiceReference[] serviceListeners = null;
		ServiceReference serviceReference   = null;
		Filter filter                       = null;
		String eventListenerFilter = "("+Constants.OBJECTCLASS+"="+UPnPEventListener.class.getName()+")";
		properties = new Properties();
		properties.put(UPnPDevice.ID,deviceId);
		properties.put(UPnPService.ID,serviceId);
		try {
			serviceListeners = context.getServiceReferences(UPnPEventListener.class.getName(), null);
			if (serviceListeners != null && serviceListeners.length > 0){
				for (int i = 0;i<serviceListeners.length;i++) {
					serviceReference = serviceListeners[i];
					filter = (Filter) serviceReference.getProperty(UPnPEventListener.UPNP_FILTER);
					if (filter == null) {
						eventListeners.add(serviceReference);
					}
					else if (filter.match(properties)) {
						addNewListener(serviceReference);
					}
				}
			}
		}
		catch (Exception e) {
		}
    	try {
    		String filterString = eventListenerFilter;
			context.addServiceListener(this, filterString);
		}
    	catch (Exception e) {
		}
	}
	public void propertyChange(PropertyChangeEvent event) {
		String property = event.getPropertyName();
		Object value = event.getNewValue();
		String valueString = value.toString();
		Iterator iterator = eventListeners.iterator();
		final Properties eventProperties = new Properties();
		eventProperties.put(property,value);
		//eventProperties.put(property,valueString);
		while (iterator.hasNext()){
			final ServiceReference serviceReference = (ServiceReference)iterator.next();
			String [] properties = serviceReference.getPropertyKeys();
			new Thread(null, null, "EventNotifier") {
				public void run(){
					try {
						UPnPEventListener listener = (UPnPEventListener) context.getService(serviceReference);
						listener.notifyUPnPEvent(deviceId,serviceId,eventProperties);
						context.ungetService(serviceReference);
					}
					catch (Exception ex){
					}
				}
			}.start();
		}
	}
	public void serviceChanged(ServiceEvent serviceEvent) {
		int serviceEventType = serviceEvent.getType();
		switch(serviceEventType){
			case ServiceEvent.REGISTERED:{
				ServiceReference serviceReference = serviceEvent.getServiceReference();
				Filter filter = (Filter) serviceReference.getProperty(UPnPEventListener.UPNP_FILTER);
				if (filter == null) {
					addNewListener(serviceReference);
				}
				else if (filter.match(properties)) {
						addNewListener(serviceReference);
				}
			};
			break;
			case ServiceEvent.MODIFIED:{
			};
			break;
			case ServiceEvent.UNREGISTERING:{
				removeListener(serviceEvent.getServiceReference());
			};
			break;
		}
	}
	private void removeListener(ServiceReference reference) {
		eventListeners.remove(reference);
	}
	private void addNewListener(ServiceReference reference) {
		eventListeners.add(reference);
	}
	public void destroy(){
		context.removeServiceListener(this);
		eventListeners.removeAllElements();
	}
}

