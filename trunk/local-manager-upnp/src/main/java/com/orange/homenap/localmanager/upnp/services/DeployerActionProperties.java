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
 *  File Name   : DeployerActionProperties.java
 *
 *  Created     : 28/06/2012
 *  Author(s)   : Remi Druilhe
 *
 *  Description :
 *
 * --------------------------------------------------------
 */

/**
 * DeployerActionProperties.java
 * 
 * generated by France Telecom UPnP Generator
 * 
 */

package com.orange.homenap.localmanager.upnp.services;


import org.osgi.service.upnp.*;
import java.util.Dictionary;
import com.orange.homenap.localmanager.upnp.holders.*;

    /**
	* This is the class representing a DeployerService
	*/
public class DeployerActionProperties {
	public static final String START_NAME = "Start";
	public static final String START_BUNDLEURL_ARGUMENT_NAME = "BundleUrl";
	public static final String START_BUNDLEURL_RELATED_STATE_VARIABLE = "ARG_TYPE_BundleUrl";
	public static final String START_MIGRATIONSTATE_ARGUMENT_NAME = "MigrationState";
	public static final String START_MIGRATIONSTATE_RELATED_STATE_VARIABLE = "ARG_TYPE_MigrationState";

	public static UPnPAction [] createUPnPActions(final DeployerServiceSkel service) {
		return new UPnPAction [] {
			new UPnPGenAction(START_NAME,
			service,
				new UPnPGenInArgument [] {
					new UPnPGenInArgument(
					START_BUNDLEURL_ARGUMENT_NAME,
					START_BUNDLEURL_RELATED_STATE_VARIABLE),
					new UPnPGenInArgument(
					START_MIGRATIONSTATE_ARGUMENT_NAME,
					START_MIGRATIONSTATE_RELATED_STATE_VARIABLE)
				},
				null) {
				public Dictionary invoke(Dictionary args) throws Exception {
					return DeployerActionHandler.start_invoke(args, service.getImpl());
				}
			}
		};
	}
}
