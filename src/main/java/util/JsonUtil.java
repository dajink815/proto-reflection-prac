/*
 * Copyright (C) 2019. Uangel Corp. All rights reserved.
 *
 */

package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.lang.reflect.Type;

/**
 * @author dajin kim
 */
public class JsonUtil {

    private JsonUtil() {
        // nothing
    }

    // JSON -> ClassType Object
    public static <T> T parse(String json, Type classType) {
        Gson gson = new Gson();
        return gson.fromJson(json, classType);
    }

    // JsonElement -> ClassType Object
    public static <T> T parse(JsonElement json, Class<T> classType) {
        Gson gson = new Gson();
        return gson.fromJson(json, classType);
    }

    // Object -> JSON
    public static String build(Object obj) {
        Gson gson = new Gson();
        return gson.toJson(obj);
    }

    // Object -> Pretty JSON
    public static String buildPretty(Object obj) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(obj);
    }

    // String -> Pretty JSON
    public static String buildPretty(String json) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(JsonParser.parseString(json));
    }

    // String -> JsonElement
    public static JsonElement build(String json) {
        Gson gson = new Gson();
        return gson.toJsonTree(json);
    }

    // Object -> JsonElement
    public static JsonElement build(Object obj, Type objType) {
        Gson gson = new GsonBuilder().create();
        return gson.toJsonTree(obj, objType);
    }


}
