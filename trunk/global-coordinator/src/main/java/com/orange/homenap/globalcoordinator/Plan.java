package com.orange.homenap.globalcoordinator;

import com.orange.homenap.utils.Device;
import com.orange.homenap.utils.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Plan implements PlanItf
{
    private List<Device> devices;
    private List<Service> services;
    private List<String> resources;


    public Plan()
    {
        devices = new ArrayList<Device>();
        services = new ArrayList<Service>();
        resources = new ArrayList<String>();
    }

    public void addDevice(Device device)
    {
        System.out.println("Adding device: " + device.getId());

        devices.add(device);

        for (Map.Entry<String,Integer> map : device.getResources().entrySet())
            if (!resources.contains(map.getKey()))
                resources.add(map.getKey());
    }

    public void addService(Service service, Device device)
    {
        System.out.println("Adding service: " + service.getName() + " on " + device.getId());

        services.add(service);

        for (Map.Entry<String,Integer> map : service.getResources().entrySet())
            if (!resources.contains(map.getKey()))
                resources.add(map.getKey());

        Iterator<Device> iterator = devices.iterator();

        while(iterator.hasNext())
        {
            Device tmp = iterator.next();

            if(tmp.getId().equals(device.getId()))
                tmp.addService(service);
        }
    }

    public void removeDevice(Device device)
    {
        System.out.println("Removing device: " + device.getId());

        Iterator<Device> iterator = devices.iterator();

        while(iterator.hasNext())
        {
            Device tmp = iterator.next();

            if(tmp.getId().equals(device.getId()))
                iterator.remove();
        }
    }

    public void removeService(Service service)
    {
        System.out.println("Removing service: " + service.getName());

        Iterator<Service> servIterator = services.iterator();

        while(servIterator.hasNext())
        {
            Service tmp = servIterator.next();

            if(tmp.getName().equals(service.getName()))
                servIterator.remove();
        }

        Iterator<Device> devIterator = devices.iterator();

        while(devIterator.hasNext())
        {
            Device device = devIterator.next();

            device.getServicesOnDevice().remove(service);
        }
    }

    public Service getService(int i)
    {
        return services.get(i);
    }

    public int getServicesSize()
    {
        return services.size();
    }

    public Device getDevice(int i)
    {
        return devices.get(i);
    }

    public int getDevicesSize()
    {
        return devices.size();
    }

    public String getResource(int i)
    {
        return resources.get(i);
    }

    public int getResourcesSize()
    {
        return resources.size();
    }

    public int[][] createPlan()
    {
        int n = devices.size();
        int m = services.size();

        int[][] plan = new int[n][m];

        for (int j = 0; j < m; j++)
            for (int i = 0; i < n; i++)
                if (devices.get(i).getServicesOnDevice().contains(services.get(j)))
                    plan[i][j] = 1;
                else
                    plan[i][j] = 0;

        return plan;
    }

    public void printPlan()
    {
        int n = devices.size();
        int m = services.size();

        int[][] plan = this.createPlan();

        for(int i = 0; i < n; i++)
            System.out.print("\t" + devices.get(i).getId());

        System.out.println();

        for (int j = 0; j < m; j++)
        {
            System.out.print(services.get(j).getName() + "\t");

            for (int i = 0; i < n; i++)
            {
                System.out.print(plan[i][j] + "\t");
            }

            System.out.println();
        }
    }

    public int getPlanConsumption()
    {
        int n = devices.size();
        int m = services.size();

        int[][] plan = this.createPlan();

        int[] sumAj = new int[n];

        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                sumAj[i] = sumAj[i] + plan[i][j];

        int[] activeDevices = new int[n];

        for(int i = 0; i < n; i++)
        {
            if(sumAj[i] == 0)
                activeDevices[i] = 0;
            else
                activeDevices[i] = 1;
        }

        int[] devicesConsumption = new int[n];

        for(int i = 0; i < n; i++)
            devicesConsumption[i] = activeDevices[i] * devices.get(i).getConsumptionOn()
                    + (1 - activeDevices[i]) * devices.get(i).getConsumptionOff();

        int consumption = 0;

        for(int i = 0; i < n; i++)
            consumption = consumption + devicesConsumption[i];

        return consumption;
    }

    public void migrateService(Service service, Device device)
    {
        Iterator<Device> devIterator = devices.iterator();

        while(devIterator.hasNext())
        {
            Device tmp = devIterator.next();

            tmp.getServicesOnDevice().remove(service);
        }

        Iterator<Device> iterator = devices.iterator();

        while(iterator.hasNext())
        {
            Device tmp = iterator.next();

            if(tmp.getId().equals(device.getId()))
                tmp.addService(service);
        }
    }
}