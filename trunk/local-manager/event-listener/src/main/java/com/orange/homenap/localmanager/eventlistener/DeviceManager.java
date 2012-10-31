/*
 * --------------------------------------------------------
 *  Module Name : local-manager
 *  Version : 0.1-SNAPSHOT
 *
 *  Software Name : HomeNap
 *  Version : 0.1-SNAPSHOT
 *
 *  Copyright © 28/06/2012 – 28/06/2012 France Télécom
 *  This software is distributed under the Apache 2.0 license,
 *  the text of which is available at http://www.apache.org/licenses/LICENSE-2.0.html
 *  or see the "LICENSE-2.0.txt" file for more details.
 *
 * --------------------------------------------------------
 *  File Name   : DeviceManager.java
 *
 *  Created     : 28/06/2012
 *  Author(s)   : Remi Druilhe
 *
 *  Description :
 *
 * --------------------------------------------------------
 */

package com.orange.homenap.localmanager.eventlistener;

import com.orange.homenap.localmanager.bundlemanager.BundleManagerItf;
import com.orange.homenap.localmanager.deviceinfo.DeviceInfoItf;
import com.orange.homenap.localmanager.json.GsonServiceItf;
import com.orange.homenap.localmanager.powerstate.PowerStateManagerItf;
import com.orange.homenap.localmanager.upnpcpmanager.ControlPointManagerItf;
import com.orange.homenap.localmanager.upnpcpmanager.DeployerControlPointItf;
import com.orange.homenap.localmanager.upnpcpmanager.GlobalCoordinatorControlPointItf;
import com.orange.homenap.utils.Device;
import com.orange.homenap.utils.Service;
import org.osgi.service.event.Event;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class DeviceManager implements LocalManagerEvent
{
    // iPOJO requires
    private BundleManagerItf bundleManagerItf;
    private PowerStateManagerItf powerStateManagerItf;
    private DeviceInfoItf deviceInfoItf;
    private GlobalCoordinatorControlPointItf globalCoordinatorControlPointItf;
    private ControlPointManagerItf controlPointManagerItf;
    private GsonServiceItf gsonServiceItf;

    public void start()
    {
        try {
            java.util.logging.LogManager.getLogManager().readConfiguration(new ByteArrayInputStream((".level=SEVERE").getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.setProperty("ipojo.log.level", "info");
    }

    public void stop() {}

    public void migrateService(String serviceName, String toDeviceId, String wakeUpAddress)
    {
        System.out.println("Migration action");

        powerStateManagerItf.suspendStateChange();

        DeployerControlPointItf deployerControlPointItf = controlPointManagerItf.createCP(toDeviceId, wakeUpAddress);

        Service service = bundleManagerItf.stop(serviceName);

        deployerControlPointItf.start(service.getBundleUrl(), gsonServiceItf.toJson(service.getComponents()));

        powerStateManagerItf.releaseStateChange();

        //TODO: take into account capabilities of the DeviceManager (number of services, ...)
    }

    public void notifyPowerStateChange(Event event)
    {
        System.out.println("Sending state change");

        deviceInfoItf.getDevice().setDeviceState(Device.DeviceState.SLEEP);

        globalCoordinatorControlPointItf.updateDeviceState(
                deviceInfoItf.getDevice().getId(),
                deviceInfoItf.getDevice().getDeviceState());
    }
}