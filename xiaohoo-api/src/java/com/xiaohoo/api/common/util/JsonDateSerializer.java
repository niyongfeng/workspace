package com.xiaohoo.api.common.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wanghuan on 18/03/2017.
 */
public class JsonDateSerializer implements JsonSerializer<Date> {
    private SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public JsonElement serialize(Date date, Type type, JsonSerializationContext jsonSerializationContext) {
        return jsonSerializationContext.serialize(dataFormat.format(date), type);
    }
}
