/**
 * Activator.java
 * 
 * generated by France Telecom UPnP Generator
 * 
 */

package com.orange.homenap.globalcoordinator.upnp.drivers;


import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

    /**
	* This is the generated Activator used to store the BundleContext.
	*/
public class Activator implements BundleActivator{
   static BundleContext bundleContext = null;

   public void start(BundleContext ctxt) throws Exception {
            bundleContext = ctxt;
   }

   public void stop(BundleContext arg0) throws Exception {

   }
}
