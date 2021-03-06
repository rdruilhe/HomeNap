/*
 * --------------------------------------------------------
 * Module Name : service1
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
 * File Name   : Service1.java
 *
 * Created     : 28/11/2012
 * Author(s)   : Remi Druilhe
 *
 * Description :
 *
 * --------------------------------------------------------
 */

package com.orange.homenap.services.service1;

public class Service1 implements Service1Itf
{
    public static final String text = "Hello World";

    public void print()
    {
        System.out.println(text);
    }
}