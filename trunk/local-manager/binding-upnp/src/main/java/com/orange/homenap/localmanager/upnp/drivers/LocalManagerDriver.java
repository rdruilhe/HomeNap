/*
 * --------------------------------------------------------
 * Module Name : binding-upnp
 * Version : 0.1-SNAPSHOT
 *
 * Software Name : HomeNap
 * Version : 0.1-SNAPSHOT
 *
 * Copyright © 28/06/2012 – 31/12/2013 France Télécom
 * This software is distributed under the Apache 2.0 license,
 * the text of which is available at http://www.apache.org/licenses/LICENSE-2.0.html
 * or see the "LICENSE-2.0.txt" file for more details.
 *
 * --------------------------------------------------------
 * File Name   : ${NAME}
 *
 * Created     :
 * Author(s)   : Remi Druilhe
 *
 * Description :
 *
 * --------------------------------------------------------
 */

package com.orange.homenap.localmanager.upnp.drivers;


import java.util.Hashtable;
import com.orange.homenap.localmanager.upnp.devices.*;
import org.osgi.service.upnp.UPnPDevice;

    public class LocalManagerDriver {
    public Hashtable devices=new Hashtable();

    public void bindUPnPDevice(UPnPDevice dev) {
        devices.put(dev, new LocalManagerDevice(dev, Activator.bundleContext));
    }

    public void unbindUPnPDevice(UPnPDevice dev) {
    	LocalManagerDevice genDevice = (LocalManagerDevice) devices.remove(dev);
    	genDevice.dispose();
    }
}
