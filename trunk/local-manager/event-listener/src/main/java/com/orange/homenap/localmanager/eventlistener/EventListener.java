/*
 * --------------------------------------------------------
 *  Module Name : event-listener
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
 *  File Name   : EventListener.java
 *
 *  Created     : 28/06/2012
 *  Author(s)   : Remi Druilhe
 *
 *  Description :
 *
 * --------------------------------------------------------
 */

package com.orange.homenap.localmanager.eventlistener;

import com.orange.homenap.localmanager.deviceinfo.DeviceInfoItf;
import com.orange.homenap.localmanager.globalcoordinatorcp.GlobalCoordinatorControlPointItf;
import com.orange.homenap.localmanager.localdatabase.LocalDatabaseItf;
import com.orange.homenap.localmanager.localexecuter.LocalExecuterItf;
import com.orange.homenap.localmanager.powerstate.PowerStateManagerItf;
import com.orange.homenap.utils.*;
import org.osgi.service.event.Event;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class EventListener implements ActionsEvent, ArchitectureEvent, GlobalCoordinatorEvent
{
    // iPOJO requires
    private PowerStateManagerItf powerStateManagerItf;
    private DeviceInfoItf deviceInfoItf;
    private GlobalCoordinatorControlPointItf globalCoordinatorControlPointItf;
    private LocalDatabaseItf localDatabaseItf;
    private LocalExecuterItf localExecuterItf;

    private List<Architecture> architectures;

    public void start()
    {
        try {
            java.util.logging.LogManager.getLogManager().readConfiguration(new ByteArrayInputStream((".level=SEVERE").getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.setProperty("ipojo.log.level", "info");

        architectures = new CopyOnWriteArrayList<Architecture>();
    }

    public void stop() {}

    public void startArchitecture(Architecture architecture, List<Component> componentList)
    {
        boolean success = globalCoordinatorControlPointItf.startArchitecture(architecture, componentList);

        if(!success)
        {
            architectures.add(architecture);

            List<Action> actions = new ArrayList<Action>();

            for(Component component : componentList)
            {
                Action action = new Action();

                action.setActionName(Action.ActionName.START);
                action.setComponent(component);

                actions.add(action);
            }

            localExecuterItf.start(actions);
        }
    }

    public void stopArchitecture(String name)
    {
        globalCoordinatorControlPointItf.stopArchitecture(name);

        //localDatabaseItf.remove(architectureName);

/*        Iterator<Component> it = architecture.getComponents().iterator();

        boolean success = true;

        while(it.hasNext())
            success = success & bundleManagerItf.stop(it.next().getName());

        if(success)
        {
            architecture.setStatus(Architecture.Status.STOPPED);

            architectureEvent.architectureStopped(architecture);
        }*/
    }

    public void architectureStarted(Architecture architecture)
    {
        //globalCoordinatorControlPointItf.startArchitecture(architecture);
    }

    public void architectureStopped(Architecture architecture)
    {

    }

    public void globalCoordinatorAppear()
    {
        globalCoordinatorControlPointItf.register();

        // Sending architecture because LM was offline

        if(!architectures.isEmpty())
        {
            synchronized (architectures)
            {
                for(Architecture architecture : architectures)
                {
                    List<Component> componentsFromArchitecture = new ArrayList<Component>();

                    for(String str : architecture.getComponents())
                        if(localDatabaseItf.get(str) != null)
                            componentsFromArchitecture.add(localDatabaseItf.get(str));

                    globalCoordinatorControlPointItf.startArchitecture(architecture, componentsFromArchitecture);

                    architectures.remove(architecture);
                }
            }
        }
    }

    public void globalCoordinatorDisappear()
    {
        //TODO
    }

    public void actionsToTake(List<Action> actions)
    {
        List<Action> migrateAction = new ArrayList<Action>();
        List<Action> startAction = new ArrayList<Action>();
        List<Action> stopAction = new ArrayList<Action>();

        for(Action action : actions)
        {
            switch (action.getActionName())
            {
                case MIGRATE:
                    migrateAction.add(action);
                    break;
                case START:
                    startAction.add(action);
                    break;
                case STOP:
                    stopAction.add(action);
                    break;
                case REGISTER:
                    globalCoordinatorControlPointItf.register();
                    break;
                case UNREGISTER:
                    globalCoordinatorControlPointItf.unRegister();
                default:
                    break;
            }
        }

        if(!migrateAction.isEmpty())
            localExecuterItf.migrate(migrateAction);

        if(!startAction.isEmpty())
            localExecuterItf.start(startAction);

        if(!stopAction.isEmpty())
            localExecuterItf.stop(stopAction);
    }

    public void notifyPowerStateChange(Event event)
    {
        System.out.println("Sending state change");

        deviceInfoItf.getDevice().setDeviceState(Device.DeviceState.SLEEP);

        globalCoordinatorControlPointItf.updateDeviceState();
    }
}
