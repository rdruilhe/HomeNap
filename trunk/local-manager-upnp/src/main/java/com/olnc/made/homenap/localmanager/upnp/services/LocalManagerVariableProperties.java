/*
 * --------------------------------------------------------
 *  Module Name : local-manager-upnp
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
 *  File Name   : LocalManagerVariableProperties.java
 *
 *  Created     : 28/06/2012
 *  Author(s)   : Remi Druilhe
 *
 *  Description :
 *
 * --------------------------------------------------------
 */

/**
 * LocalManagerVariableProperties.java
 * 
 * generated by France Telecom UPnP Generator
 * 
 */

package com.olnc.made.homenap.localmanager.upnp.services;


import org.osgi.service.upnp.*;
import com.olnc.made.homenap.localmanager.upnp.holders.*;

    /**
	* This is the class representing a LocalManagerService
	*/
public class LocalManagerVariableProperties {
	public static final String ARG_TYPE_SERVICEID_NAME = "ARG_TYPE_ServiceId";
	public static final boolean ARG_TYPE_SERVICEID_SENDS_EVENTS     = false;
	public static final Class ARG_TYPE_SERVICEID_JAVA_DATA_TYPE     = java.lang.String.class;
	public static final String ARG_TYPE_SERVICEID_UPNP_DATA_TYPE    = "string";
	public static final String [] ARG_TYPE_SERVICEID_ALLOWED_VALUES = null;
	public static final Object ARG_TYPE_SERVICEID_DEFAULT_VALUE     = null;
	public static final Number ARG_TYPE_SERVICEID_MINIMUM = null;
	public static final Number ARG_TYPE_SERVICEID_MAXIMUM = null;
	public static final Number ARG_TYPE_SERVICEID_STEP = null;

	public static final String ARG_TYPE_WAKEUPADDRESS_NAME = "ARG_TYPE_WakeUpAddress";
	public static final boolean ARG_TYPE_WAKEUPADDRESS_SENDS_EVENTS     = false;
	public static final Class ARG_TYPE_WAKEUPADDRESS_JAVA_DATA_TYPE     = java.lang.String.class;
	public static final String ARG_TYPE_WAKEUPADDRESS_UPNP_DATA_TYPE    = "string";
	public static final String [] ARG_TYPE_WAKEUPADDRESS_ALLOWED_VALUES = null;
	public static final Object ARG_TYPE_WAKEUPADDRESS_DEFAULT_VALUE     = null;
	public static final Number ARG_TYPE_WAKEUPADDRESS_MINIMUM = null;
	public static final Number ARG_TYPE_WAKEUPADDRESS_MAXIMUM = null;
	public static final Number ARG_TYPE_WAKEUPADDRESS_STEP = null;

	public static final String ARG_TYPE_TODEVICEID_NAME = "ARG_TYPE_ToDeviceId";
	public static final boolean ARG_TYPE_TODEVICEID_SENDS_EVENTS     = false;
	public static final Class ARG_TYPE_TODEVICEID_JAVA_DATA_TYPE     = java.lang.String.class;
	public static final String ARG_TYPE_TODEVICEID_UPNP_DATA_TYPE    = "uuid";
	public static final String [] ARG_TYPE_TODEVICEID_ALLOWED_VALUES = null;
	public static final Object ARG_TYPE_TODEVICEID_DEFAULT_VALUE     = null;
	public static final Number ARG_TYPE_TODEVICEID_MINIMUM = null;
	public static final Number ARG_TYPE_TODEVICEID_MAXIMUM = null;
	public static final Number ARG_TYPE_TODEVICEID_STEP = null;

	public static UPnPStateVariable [] createUPnPStateVariables() {
		return new UPnPStateVariable [] {
			new UPnPGenStateVariable(ARG_TYPE_SERVICEID_NAME,
			ARG_TYPE_SERVICEID_SENDS_EVENTS,
			ARG_TYPE_SERVICEID_JAVA_DATA_TYPE,
			ARG_TYPE_SERVICEID_UPNP_DATA_TYPE,
			ARG_TYPE_SERVICEID_ALLOWED_VALUES,
			ARG_TYPE_SERVICEID_DEFAULT_VALUE,
			ARG_TYPE_SERVICEID_MINIMUM,
			ARG_TYPE_SERVICEID_MAXIMUM,
			ARG_TYPE_SERVICEID_STEP),
			new UPnPGenStateVariable(ARG_TYPE_WAKEUPADDRESS_NAME,
			ARG_TYPE_WAKEUPADDRESS_SENDS_EVENTS,
			ARG_TYPE_WAKEUPADDRESS_JAVA_DATA_TYPE,
			ARG_TYPE_WAKEUPADDRESS_UPNP_DATA_TYPE,
			ARG_TYPE_WAKEUPADDRESS_ALLOWED_VALUES,
			ARG_TYPE_WAKEUPADDRESS_DEFAULT_VALUE,
			ARG_TYPE_WAKEUPADDRESS_MINIMUM,
			ARG_TYPE_WAKEUPADDRESS_MAXIMUM,
			ARG_TYPE_WAKEUPADDRESS_STEP),
			new UPnPGenStateVariable(ARG_TYPE_TODEVICEID_NAME,
			ARG_TYPE_TODEVICEID_SENDS_EVENTS,
			ARG_TYPE_TODEVICEID_JAVA_DATA_TYPE,
			ARG_TYPE_TODEVICEID_UPNP_DATA_TYPE,
			ARG_TYPE_TODEVICEID_ALLOWED_VALUES,
			ARG_TYPE_TODEVICEID_DEFAULT_VALUE,
			ARG_TYPE_TODEVICEID_MINIMUM,
			ARG_TYPE_TODEVICEID_MAXIMUM,
			ARG_TYPE_TODEVICEID_STEP)
		};
	}
}
