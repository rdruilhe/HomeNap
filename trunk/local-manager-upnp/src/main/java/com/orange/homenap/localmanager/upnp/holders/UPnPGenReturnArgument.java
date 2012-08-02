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
 *  File Name   : UPnPGenReturnArgument.java
 *
 *  Created     : 28/06/2012
 *  Author(s)   : Remi Druilhe
 *
 *  Description :
 *
 * --------------------------------------------------------
 */

package com.orange.homenap.localmanager.upnp.holders;

/**
 * This class represent a return argument when in the desciption whe have the tag <retval/>
 * @author Marius Legros TANKEU DE KUIGWA
 *
 */
public class UPnPGenReturnArgument extends UPnPGenOutArgument {

	public UPnPGenReturnArgument(String name, String relatedStateVariable) {
		super(name, relatedStateVariable);
	}
}

