/*
 * Copyright (C) 2018. Uangel Corp. All rights reserved.
 *
 */

package util;

import com.google.gson.JsonElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonParser {
    static final Logger log = LoggerFactory.getLogger(JsonParser.class);

    private JsonParser() {
    }

    public static String parseJson(JsonElement json, String memberName) {
        String value = "";
        try {
            if (json.getAsJsonObject().get(memberName) != null) {
                value = json.getAsJsonObject().get(memberName).getAsString();
            }
        } catch (Exception e) {
            log.error("JsonParser.parseJson.Exception ", e);
        }
        return value;
    }
}
