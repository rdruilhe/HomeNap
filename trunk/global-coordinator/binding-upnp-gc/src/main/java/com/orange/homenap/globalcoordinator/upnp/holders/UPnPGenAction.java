/**
##############################################################################
# Copyright (C) 2004-2007 France Telecom R&D
#
# This library is free software; you can redistribute it and/or
# modify it under the terms of the GNU Lesser General Public
# License as published by the Free Software Foundation; either
# version 2 of the License, or (at your option) any later version.
#
# This library is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
# Lesser General Public License for more details.
#
# You should have received a copy of the GNU Lesser General Public
# License along with this library; if not, write to the Free Software
# Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
##############################################################################
 * 
 */
package com.orange.homenap.globalcoordinator.upnp.holders;

import java.util.Dictionary;

import org.osgi.service.upnp.UPnPAction;
import org.osgi.service.upnp.UPnPService;
import org.osgi.service.upnp.UPnPStateVariable;

/**
 * This class represents a service action in a XML UPnP device description File
 * @author   Marius Legros TANKEU DE KUIGWA
 */
public abstract class UPnPGenAction implements UPnPAction{
	
	public static final String endReturnClassName="RetValues";
	
	/**
	 * the Action Name
	 * @uml.property  name="name"
	 */
	private String              name; 
	/**
	 * In arguments
	 * @uml.property  name="inArguments"
	 * @uml.associationEnd  multiplicity="(0 -1)"
	 */
    private UPnPGenInArgument  [] inArguments;
    /**
	 * Out arguments
	 * @uml.property  name="outArguments"
	 * @uml.associationEnd  multiplicity="(0 -1)"
	 */
    private UPnPGenOutArgument [] outArguments;
    /**
     * The service containing the action
     */
    private UPnPGenService         service;
    /**
	 * The name of the return class of this action
	 * @uml.property  name="retClassName"
	 */
    private String retClassName="void";

	public UPnPGenAction(String name, UPnPService service, 
			UPnPGenInArgument [] inArguments, UPnPGenOutArgument [] outArguments) { 
		this.name    = name;
		this.service = (UPnPGenService) service;
		this.inArguments  = inArguments;
		this.outArguments = outArguments;
		if(outArguments!=null) {
			if(outArguments.length==1) retClassName=getStateVariable(outArguments[0].getName()).getJavaDataType().getName(); 
			else if(outArguments.length>1) retClassName=Utilities.upperFirstCase(this.name)+ endReturnClassName;
		}
	}

	/**
	 * @return  Returns the name.
	 * @uml.property  name="name"
	 */
	public String getName() { 
		return name;
	}

	/**
	 * @return  Returns the service.
	 * @uml.property  name="service"
	 */
	public UPnPGenService getService() { 
		return service;
	}

	public String getReturnArgumentName() { 
		if(outArguments==null) return null;
		for(int i=0; i<outArguments.length; i++) { 
			if (outArguments[i] instanceof UPnPGenReturnArgument) { 
				return outArguments[i].getName();
			}
		}

		return null;
	}

	public String[] getInputArgumentNames() {
		if (inArguments == null)
			return null;

		String [] names = new String[inArguments.length];

		for(int i=0; i<inArguments.length; i++) {
			names[i] = inArguments[i].getName();
		}

		return names;
	}

	public String[] getOutputArgumentNames() {
		if (outArguments == null)
			return null;

		String [] names = new String[outArguments.length];

		for(int i=0; i<outArguments.length; i++) {
			names[i] = outArguments[i].getName();
		}

		return names;
	}

	public UPnPStateVariable getStateVariable(String argumentName) {
		if(argumentName == null)
        	return null;

    	String stateVariableName;

    	if (inArguments != null) {
    		for(int i=0; i<inArguments.length; i++) {
    			if(inArguments[i].getName().equals(argumentName)) {
    				stateVariableName = inArguments[i].getRelatedStateVariable();
    				return service.getStateVariable(stateVariableName);
    			}
    		}
    	}

    	if (outArguments != null) {
    		for(int i=0; i<outArguments.length; i++) {
    			if(outArguments[i].getName().equals(argumentName)) {
    				stateVariableName = outArguments[i].getRelatedStateVariable();
    				return service.getStateVariable(stateVariableName);
    			}
    		}
    	}

    	return null;
	}

	/**
	 * @return  Returns the inArguments.
	 * @uml.property  name="inArguments"
	 */
	public UPnPGenInArgument[] getInArguments() {
		return inArguments;
	}

	/**
	 * @param inArguments  The inArguments to set.
	 * @uml.property  name="inArguments"
	 */
	public void setInArguments(UPnPGenInArgument[] inArguments) {
		this.inArguments = inArguments;
	}

	/**
	 * @return  Returns the outArguments.
	 * @uml.property  name="outArguments"
	 */
	public UPnPGenOutArgument[] getOutArguments() {
		return outArguments;
	}

	/**
	 * @param outArguments  The outArguments to set.
	 * @uml.property  name="outArguments"
	 */
	public void setOutArguments(UPnPGenOutArgument[] outArguments) {
		this.outArguments = outArguments;
		if(outArguments!=null) {
		if(outArguments.length==1) retClassName=service.getStateVariable(outArguments[0].getRelatedStateVariable()).getJavaDataType().getName(); 
		else if(outArguments.length>1) retClassName=Utilities.upperFirstCase(this.name)+endReturnClassName;
		}
	}

	/**
	 * @param name  The name to set.
	 * @uml.property  name="name"
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param service  The service to set.
	 * @uml.property  name="service"
	 */
	public void setService(UPnPGenService service) {
		this.service = service;
	}

	/**
	 * @return  Returns the retClassName.
	 * @uml.property  name="retClassName"
	 */
	public String getRetClassName() {
		return retClassName;
	}

	/**
	 * @param retClassName  The retClassName to set.
	 * @uml.property  name="retClassName"
	 */
	public void setRetClassName(String retClassName) {
		this.retClassName = retClassName;
	}

	public abstract Dictionary invoke(Dictionary args) throws Exception;

}

