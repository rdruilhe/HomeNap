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
package com.orange.homenap.localmanager.upnp.holders;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.StringTokenizer;


public class Utilities {
	
	/** Toknens in a namespace that are treated as package name part separators. */
    private static final char[] pkgSeparators = {'.', ':'};
    
	public static String[] realSplit(String source, char splitCharacter)
	{
		if (source.length() > 0)
			if (source.indexOf(splitCharacter) != -1)
				return Utilities.kSplit(source,splitCharacter);
			else
				return new String[] { source };
		else
			return null;
	}
	
	public static String getVersion(String serviceId)
	{
		String[] s=kSplit(serviceId,'.');		
		return s[s.length-1];
	}
	
	public static String concat(String source, char c)
	{
		String ret="";
		String[] s=kSplit(source,c);
		for (int i = 0; i < s.length; i++) {
			ret+=s[i];
		}
		return ret;
	}
	public static String[] kSplit(String source, char splitCharacter)
	{
		if (source.length() > 0)
			if (source.indexOf(splitCharacter) != -1) {				
				StringTokenizer stoken=new StringTokenizer(source,new Character(splitCharacter).toString());
				String[] s= new String [stoken.countTokens()];
				int i=0;
				while(stoken.hasMoreElements())
				{
					String token=stoken.nextToken();
					s[i++]=token;				
				}
				return s;
			}
//		return source.split(Character.toString(splitCharacter));
			else
				return new String[] { source };
		else
			return null;
	}
	public static String removeLast(String [] source, char splitCharacter)
	{
		String ret="";
		for(int i=0;i<source.length-1;i++) {
			if(i!=source.length-2) {
				ret+=source[i]+new Character(splitCharacter).toString();
			} else ret+=source[i];
		}
		return ret;
	}
	
	public static String upperFirstCase(String name) {
		String c=new String(Character.toString(name.charAt(0))).toUpperCase();
		String last=name.substring(1,name.length());		
		return c+last;
	}
	
	public static String lowerFirstCase(String name) {
		String c=new String(Character.toString(name.charAt(0))).toLowerCase();
		String last=name.substring(1,name.length());		
		return c+last;
	}
	
	/**
     * Return the given package name in directory format (dots replaced by slashes).  If pkg is null,
     * "" is returned.
     * 
     * @param pkg 
     * @return 
     */
    public static String toDir(String pkg) {

        String dir = null;

        if (pkg != null) {
            pkg = normalizePackageName(pkg, File.separatorChar);
        }       
            dir = pkg;

        return dir;
    }    // toDir
    
    /**
     * Method normalizePackageName
     * 
     * @param pkg       
     * @param separator 
     * @return 
     */
    private static String normalizePackageName(String pkg, char separator) {

        for (int i = 0; i < pkgSeparators.length; i++) {
            pkg = pkg.replace(pkgSeparators[i], separator);
        }

        return pkg;
    }
    
	public static String readFile(String filename){
		File f=new File(filename);
		InputStream stream=null;
		try {
			stream = new FileInputStream(f);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		int ch = 0;
		StringBuffer buffer = new StringBuffer();
		int len;
		try {
			len = stream.available();
			if ( len != -1) {
				for (int i =0 ; i < len ; i++ )
					if ((ch = stream.read()) != -1)
						buffer.append((char) ch);
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		String xmlFile =buffer.toString();
		return xmlFile;
	}
	
	public static String getNameFromType(String type){
		String [] s=kSplit(type,':');
		return s[s.length-2];
	}
	
	public static String getNameFromSType(String type){
		String [] s=kSplit(type,':');
		return concat(s[s.length-1],'.');
	}
	public static void main(String[] args) {
		System.out.println(getNameFromSType("urn:upnp-org:serviceId:Dimming.1"));
	}
	/**
	 * Utilitary Class for modifying a WSDL File
	 * @param wsdlFil  the original WSDL File
	 * @param serviceLocation   The Service location
	 * @param nameSpace     The service namespace
	 * @return             The updated WSDL File.
	 */
	public static String setBuildFile(String wsdlFileName,String deviceName){
				
		//serviceLocation : 
		// http:// host: portNumber/ .../service 
		
		
		
		InputStream stream =Utilities.class.getResourceAsStream ("/"+wsdlFileName.replace('.','/')+".wsdl");
		
		
		int ch = 0;
		StringBuffer buffer = new StringBuffer();
		int len;
		try {
			len = stream.available();
			if ( len != -1) {
				for (int i =0 ; i < len ; i++ )
					if ((ch = stream.read()) != -1)
						buffer.append((char) ch);
				}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		String wsdlFile =buffer.toString();				

		if(deviceName !=null ||deviceName!=""){
			wsdlFile =wsdlFile.replaceAll("DEVICE_NAME",deviceName);
		}
		return wsdlFile;
	}
}

