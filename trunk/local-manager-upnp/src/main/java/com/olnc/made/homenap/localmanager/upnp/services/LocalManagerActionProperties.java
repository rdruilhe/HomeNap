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
 *  File Name   : LocalManagerActionProperties.java
 *
 *  Created     : 28/06/2012
 *  Author(s)   : Remi Druilhe
 *
 *  Description :
 *
 * --------------------------------------------------------
 */

/**
 * LocalManagerActionProperties.java
 * 
 * generated by France Telecom UPnP Generator
 * 
 */

package com.olnc.made.homenap.localmanager.upnp.services;


import org.osgi.service.upnp.*;
import java.util.Dictionary;
import com.olnc.made.homenap.localmanager.upnp.holders.*;

    /**
	* This is the class representing a LocalManagerService
	*/
public class LocalManagerActionProperties {
	public static final String MIGRATESERVICE_NAME = "MigrateService";
	public static final String MIGRATESERVICE_SERVICEID_ARGUMENT_NAME = "ServiceId";
	public static final String MIGRATESERVICE_SERVICEID_RELATED_STATE_VARIABLE = "ARG_TYPE_ServiceId";
	public static final String MIGRATESERVICE_TODEVICEID_ARGUMENT_NAME = "ToDeviceId";
	public static final String MIGRATESERVICE_TODEVICEID_RELATED_STATE_VARIABLE = "ARG_TYPE_ToDeviceId";
	public static final String MIGRATESERVICE_WAKEUPADDRESS_ARGUMENT_NAME = "WakeUpAddress";
	public static final String MIGRATESERVICE_WAKEUPADDRESS_RELATED_STATE_VARIABLE = "ARG_TYPE_WakeUpAddress";

	public static UPnPAction [] createUPnPActions(final LocalManagerServiceSkel service) {
		return new UPnPAction [] {
			new UPnPGenAction(MIGRATESERVICE_NAME,
			service,
				new UPnPGenInArgument [] {
					new UPnPGenInArgument(
					MIGRATESERVICE_SERVICEID_ARGUMENT_NAME,
					MIGRATESERVICE_SERVICEID_RELATED_STATE_VARIABLE),
					new UPnPGenInArgument(
					MIGRATESERVICE_TODEVICEID_ARGUMENT_NAME,
					MIGRATESERVICE_TODEVICEID_RELATED_STATE_VARIABLE),
					new UPnPGenInArgument(
					MIGRATESERVICE_WAKEUPADDRESS_ARGUMENT_NAME,
					MIGRATESERVICE_WAKEUPADDRESS_RELATED_STATE_VARIABLE)
				},
				null) {
				public Dictionary invoke(Dictionary args) throws Exception {
					return LocalManagerActionHandler.migrateService_invoke(args, service.getImpl());
				}
			}
		};
	}
}
