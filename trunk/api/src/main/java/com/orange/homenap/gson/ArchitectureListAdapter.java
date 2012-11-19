/*
 * --------------------------------------------------------
 * Module Name : api
 * Version : 0.1-SNAPSHOT
 *
 * Software Name : $projectName
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

package com.orange.homenap.gson;

import com.google.gson.*;
import com.orange.homenap.utils.Architecture;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ArchitectureListAdapter implements JsonSerializer<List<Architecture>>, JsonDeserializer<List<Architecture>>
{
    private static final String CLASSNAME = "CLASSNAME";
    private static final String INSTANCE  = "INSTANCE";

    @Override
    public List<Architecture> deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException
    {
        JsonArray array = jsonElement.getAsJsonArray();
        List<Architecture> architectureList = new ArrayList<Architecture>();

        for(int i = 0; i < array.size(); i++)
        {
            JsonElement element = array.get(i);
            JsonObject jsonObject = element.getAsJsonObject();
            JsonPrimitive prim = (JsonPrimitive) jsonObject.get(CLASSNAME);
            String className = prim.getAsString();

            Class<?> klass = null;

            try {
                klass = Class.forName(className);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                throw new JsonParseException(e.getMessage());
            }

            Architecture architecture = context.deserialize(jsonObject.get(INSTANCE), klass);

            architectureList.add(architecture);
        }

        return architectureList;
    }

    @Override
    public JsonElement serialize(List<Architecture> architectureList, Type type, JsonSerializationContext context)
    {
        JsonArray array = new JsonArray();

        for(Architecture architecture : architectureList)
        {
            JsonObject jsonObject = new JsonObject();
            String className = architecture.getClass().getCanonicalName();
            jsonObject.addProperty(CLASSNAME, className);
            JsonElement element = context.serialize(architecture);
            jsonObject.add(INSTANCE, element);
            array.add(jsonObject);
        }

        return array;
    }
}