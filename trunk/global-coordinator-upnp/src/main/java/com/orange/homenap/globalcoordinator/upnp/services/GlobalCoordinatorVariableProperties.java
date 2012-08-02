/*
 * --------------------------------------------------------
 *  Module Name : global-coordinator-upnp
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
 *  File Name   : GlobalCoordinatorVariableProperties.java
 *
 *  Created     : 28/06/2012
 *  Author(s)   : Remi Druilhe
 *
 *  Description :
 *
 *  generated by France Telecom UPnP Generator
 *
 * --------------------------------------------------------
 */

package com.orange.homenap.globalcoordinator.upnp.services;


import org.osgi.service.upnp.*;
import com.orange.homenap.globalcoordinator.upnp.holders.*;

    /**
	* This is the class representing a GlobalCoordinatorService
	*/
public class GlobalCoordinatorVariableProperties {
	public static final String ARG_TYPE_SUCCESS_NAME = "ARG_TYPE_Success";
	public static final boolean ARG_TYPE_SUCCESS_SENDS_EVENTS     = false;
	public static final Class ARG_TYPE_SUCCESS_JAVA_DATA_TYPE     = boolean.class;
	public static final String ARG_TYPE_SUCCESS_UPNP_DATA_TYPE    = "boolean";
	public static final String [] ARG_TYPE_SUCCESS_ALLOWED_VALUES = null;
	public static final Object ARG_TYPE_SUCCESS_DEFAULT_VALUE     = null;
	public static final Number ARG_TYPE_SUCCESS_MINIMUM = null;
	public static final Number ARG_TYPE_SUCCESS_MAXIMUM = null;
	public static final Number ARG_TYPE_SUCCESS_STEP = null;

	public static final String ARG_TYPE_DEVICEINFO_NAME = "ARG_TYPE_DeviceInfo";
	public static final boolean ARG_TYPE_DEVICEINFO_SENDS_EVENTS     = false;
	public static final Class ARG_TYPE_DEVICEINFO_JAVA_DATA_TYPE     = java.lang.String.class;
	public static final String ARG_TYPE_DEVICEINFO_UPNP_DATA_TYPE    = "string";
	public static final String [] ARG_TYPE_DEVICEINFO_ALLOWED_VALUES = null;
	public static final Object ARG_TYPE_DEVICEINFO_DEFAULT_VALUE     = null;
	public static final Number ARG_TYPE_DEVICEINFO_MINIMUM = null;
	public static final Number ARG_TYPE_DEVICEINFO_MAXIMUM = null;
	public static final Number ARG_TYPE_DEVICEINFO_STEP = null;

	public static final String ARG_TYPE_STATE_NAME = "ARG_TYPE_State";
	public static final boolean ARG_TYPE_STATE_SENDS_EVENTS     = false;
	public static final Class ARG_TYPE_STATE_JAVA_DATA_TYPE     = java.lang.String.class;
	public static final String ARG_TYPE_STATE_UPNP_DATA_TYPE    = "string";
	public static final String [] ARG_TYPE_STATE_ALLOWED_VALUES = null;
	public static final Object ARG_TYPE_STATE_DEFAULT_VALUE     = new java.lang.String("off");
	public static final Number ARG_TYPE_STATE_MINIMUM = null;
	public static final Number ARG_TYPE_STATE_MAXIMUM = null;
	public static final Number ARG_TYPE_STATE_STEP = null;

	public static final String ARG_TYPE_DEVICEID_NAME = "ARG_TYPE_DeviceId";
	public static final boolean ARG_TYPE_DEVICEID_SENDS_EVENTS     = false;
	public static final Class ARG_TYPE_DEVICEID_JAVA_DATA_TYPE     = java.lang.String.class;
	public static final String ARG_TYPE_DEVICEID_UPNP_DATA_TYPE    = "uuid";
	public static final String [] ARG_TYPE_DEVICEID_ALLOWED_VALUES = null;
	public static final Object ARG_TYPE_DEVICEID_DEFAULT_VALUE     = null;
	public static final Number ARG_TYPE_DEVICEID_MINIMUM = null;
	public static final Number ARG_TYPE_DEVICEID_MAXIMUM = null;
	public static final Number ARG_TYPE_DEVICEID_STEP = null;

	public static final String ARG_TYPE_SERVICESSTATE_NAME = "ARG_TYPE_ServicesState";
	public static final boolean ARG_TYPE_SERVICESSTATE_SENDS_EVENTS     = false;
	public static final Class ARG_TYPE_SERVICESSTATE_JAVA_DATA_TYPE     = java.lang.String.class;
	public static final String ARG_TYPE_SERVICESSTATE_UPNP_DATA_TYPE    = "string";
	public static final String [] ARG_TYPE_SERVICESSTATE_ALLOWED_VALUES = null;
	public static final Object ARG_TYPE_SERVICESSTATE_DEFAULT_VALUE     = new java.lang.String("null");
	public static final Number ARG_TYPE_SERVICESSTATE_MINIMUM = null;
	public static final Number ARG_TYPE_SERVICESSTATE_MAXIMUM = null;
	public static final Number ARG_TYPE_SERVICESSTATE_STEP = null;

	public static UPnPStateVariable [] createUPnPStateVariables() {
		return new UPnPStateVariable [] {
			new UPnPGenStateVariable(ARG_TYPE_SUCCESS_NAME,
			ARG_TYPE_SUCCESS_SENDS_EVENTS,
			ARG_TYPE_SUCCESS_JAVA_DATA_TYPE,
			ARG_TYPE_SUCCESS_UPNP_DATA_TYPE,
			ARG_TYPE_SUCCESS_ALLOWED_VALUES,
			ARG_TYPE_SUCCESS_DEFAULT_VALUE,
			ARG_TYPE_SUCCESS_MINIMUM,
			ARG_TYPE_SUCCESS_MAXIMUM,
			ARG_TYPE_SUCCESS_STEP),
			new UPnPGenStateVariable(ARG_TYPE_DEVICEINFO_NAME,
			ARG_TYPE_DEVICEINFO_SENDS_EVENTS,
			ARG_TYPE_DEVICEINFO_JAVA_DATA_TYPE,
			ARG_TYPE_DEVICEINFO_UPNP_DATA_TYPE,
			ARG_TYPE_DEVICEINFO_ALLOWED_VALUES,
			ARG_TYPE_DEVICEINFO_DEFAULT_VALUE,
			ARG_TYPE_DEVICEINFO_MINIMUM,
			ARG_TYPE_DEVICEINFO_MAXIMUM,
			ARG_TYPE_DEVICEINFO_STEP),
			new UPnPGenStateVariable(ARG_TYPE_STATE_NAME,
			ARG_TYPE_STATE_SENDS_EVENTS,
			ARG_TYPE_STATE_JAVA_DATA_TYPE,
			ARG_TYPE_STATE_UPNP_DATA_TYPE,
			ARG_TYPE_STATE_ALLOWED_VALUES,
			ARG_TYPE_STATE_DEFAULT_VALUE,
			ARG_TYPE_STATE_MINIMUM,
			ARG_TYPE_STATE_MAXIMUM,
			ARG_TYPE_STATE_STEP),
			new UPnPGenStateVariable(ARG_TYPE_DEVICEID_NAME,
			ARG_TYPE_DEVICEID_SENDS_EVENTS,
			ARG_TYPE_DEVICEID_JAVA_DATA_TYPE,
			ARG_TYPE_DEVICEID_UPNP_DATA_TYPE,
			ARG_TYPE_DEVICEID_ALLOWED_VALUES,
			ARG_TYPE_DEVICEID_DEFAULT_VALUE,
			ARG_TYPE_DEVICEID_MINIMUM,
			ARG_TYPE_DEVICEID_MAXIMUM,
			ARG_TYPE_DEVICEID_STEP),
			new UPnPGenStateVariable(ARG_TYPE_SERVICESSTATE_NAME,
			ARG_TYPE_SERVICESSTATE_SENDS_EVENTS,
			ARG_TYPE_SERVICESSTATE_JAVA_DATA_TYPE,
			ARG_TYPE_SERVICESSTATE_UPNP_DATA_TYPE,
			ARG_TYPE_SERVICESSTATE_ALLOWED_VALUES,
			ARG_TYPE_SERVICESSTATE_DEFAULT_VALUE,
			ARG_TYPE_SERVICESSTATE_MINIMUM,
			ARG_TYPE_SERVICESSTATE_MAXIMUM,
			ARG_TYPE_SERVICESSTATE_STEP)
		};
	}
}
