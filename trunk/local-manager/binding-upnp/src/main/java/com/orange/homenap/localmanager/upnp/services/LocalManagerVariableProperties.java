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

package com.orange.homenap.localmanager.upnp.services;


import org.osgi.service.upnp.*;
import com.orange.homenap.localmanager.upnp.holders.*;

    public class LocalManagerVariableProperties {
	public static final String ARG_TYPE_ACTIONS_NAME = "ARG_TYPE_Actions";
	public static final boolean ARG_TYPE_ACTIONS_SENDS_EVENTS     = false;
	public static final Class ARG_TYPE_ACTIONS_JAVA_DATA_TYPE     = String.class;
	public static final String ARG_TYPE_ACTIONS_UPNP_DATA_TYPE    = "string";
	public static final String [] ARG_TYPE_ACTIONS_ALLOWED_VALUES = null;
	public static final Object ARG_TYPE_ACTIONS_DEFAULT_VALUE     = null;
	public static final Number ARG_TYPE_ACTIONS_MINIMUM = null;
	public static final Number ARG_TYPE_ACTIONS_MAXIMUM = null;
	public static final Number ARG_TYPE_ACTIONS_STEP = null;

	public static UPnPStateVariable [] createUPnPStateVariables() {
		return new UPnPStateVariable [] {
			new UPnPGenStateVariable(ARG_TYPE_ACTIONS_NAME,
			ARG_TYPE_ACTIONS_SENDS_EVENTS,
			ARG_TYPE_ACTIONS_JAVA_DATA_TYPE,
			ARG_TYPE_ACTIONS_UPNP_DATA_TYPE,
			ARG_TYPE_ACTIONS_ALLOWED_VALUES,
			ARG_TYPE_ACTIONS_DEFAULT_VALUE,
			ARG_TYPE_ACTIONS_MINIMUM,
			ARG_TYPE_ACTIONS_MAXIMUM,
			ARG_TYPE_ACTIONS_STEP)
		};
	}
}
