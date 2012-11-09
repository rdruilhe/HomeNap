/**
 * LocalManagerActionProperties.java
 * 
 * generated by France Telecom UPnP Generator
 * 
 */

package com.orange.homenap.localmanager.upnp.services;


import org.osgi.service.upnp.*;
import java.util.Dictionary;
import com.orange.homenap.localmanager.upnp.holders.*;

    /**
	* This is the class representing a LocalManagerService
	*/
public class LocalManagerActionProperties {
	public static final String ACTIONSTOTAKE_NAME = "ActionsToTake";
	public static final String ACTIONSTOTAKE_ACTIONS_ARGUMENT_NAME = "Actions";
	public static final String ACTIONSTOTAKE_ACTIONS_RELATED_STATE_VARIABLE = "ARG_TYPE_Actions";

	public static UPnPAction [] createUPnPActions(final LocalManagerServiceSkel service) {
		return new UPnPAction [] {
			new UPnPGenAction(ACTIONSTOTAKE_NAME,
			service,
				new UPnPGenInArgument [] {
					new UPnPGenInArgument(
					ACTIONSTOTAKE_ACTIONS_ARGUMENT_NAME,
					ACTIONSTOTAKE_ACTIONS_RELATED_STATE_VARIABLE)
				},
				null) {
				public Dictionary invoke(Dictionary args) throws Exception {
					return LocalManagerActionHandler.actionsToTake_invoke(args, service.getImpl());
				}
			}
		};
	}
}
