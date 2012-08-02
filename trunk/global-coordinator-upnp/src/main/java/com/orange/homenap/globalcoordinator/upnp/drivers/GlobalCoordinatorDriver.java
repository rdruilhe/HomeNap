/*--------------------------------------------------------
* Module Name : global-coordinator-upnp
* Version : 0.1-SNAPSHOT
*
* Software Name : HomeNap
* Version : 0.1-SNAPSHOT
*
* Copyright © 28/06/2012 – 28/06/2012 France Télécom
* This software is distributed under the Apache 2.0 license,
* the text of which is available at http://www.apache.org/licenses/LICENSE-2.0.html
* or see the "LICENSE-2.0.txt" file for more details.
*
*--------------------------------------------------------
* File Name   : GlobalCoordinatorDriver.java
*
* Created     : 28/06/2012
* Author(s)   : Remi Druilhe
*
* Description :
*
* generated by France Telecom UPnP Generator
*
*--------------------------------------------------------
*/

package com.orange.homenap.globalcoordinator.upnp.drivers;


import java.util.Hashtable;
import com.orange.homenap.globalcoordinator.upnp.devices.*;
import org.osgi.service.upnp.UPnPDevice;

    /**
	* This is the class representing a GlobalCoordinatorDriver
	*/
public class GlobalCoordinatorDriver {
    public Hashtable devices=new Hashtable();

    public void bindUPnPDevice(UPnPDevice dev) {
        devices.put(dev, new GlobalCoordinatorDevice(dev, Activator.bundleContext));
    }

    public void unbindUPnPDevice(UPnPDevice dev) {
    	GlobalCoordinatorDevice genDevice = (GlobalCoordinatorDevice) devices.remove(dev);
    	genDevice.dispose();
    }
}