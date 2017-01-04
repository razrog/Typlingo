package com.rogek.typlingo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/*
This Class Handles parsing the json String into json object and then into a map
 */


public class Unicode
{
    private static Unicode unicode = null;
    HashMap<Integer,String> asciiToUnicode;

    private Unicode(){
        asciiToUnicode = new HashMap();
        jsonToMap();
    }

    public static Unicode getInstance(){
        if (unicode ==null){
            unicode = new Unicode();
        }
        return unicode;
    }

    //Returns the String Value of a certain code e.g - א will be code 128
    public String getUnicode(int primaryCode) throws Exception {
        byte[] utf8Bytes = new byte[0];
        String text = "";
        utf8Bytes = String.valueOf(asciiToUnicode.get(primaryCode)).getBytes("UTF-8");
        return new String(utf8Bytes,"UTF-8");
    }


    //Getting Keys (Hebrew letters codes from Keys)
    //Parse them into json object
    //Put them all inside the Map (replacing escaping with blank value)
    public void jsonToMap(){
        String keys = Keys.getInstance().getCodes();

        JsonParser parser = new JsonParser();
        JsonObject json = parser.parse(keys).getAsJsonObject();

        Set<Map.Entry<String, JsonElement>> entrySet = json.entrySet();

        for(Map.Entry<String,JsonElement> entry : entrySet){
            asciiToUnicode.put(Integer.parseInt(entry.getKey()),json.get(entry.getKey()).toString().replace("\"",""));
        }

    }





}
