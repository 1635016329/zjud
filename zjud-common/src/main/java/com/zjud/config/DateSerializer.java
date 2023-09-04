package com.zjud.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/9/1 16:09
 * @description
 */
public class DateSerializer extends JsonSerializer<Date> {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        String formattedDate = DATE_FORMAT.format(date);
        jsonGenerator.writeString(formattedDate);
    }
}