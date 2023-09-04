package com.zjud.config;

import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Component;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/9/1 16:09
 * @description 日期格式配置
 */
@Component
public class JacksonCustomizer implements Jackson2ObjectMapperBuilderCustomizer {

    @Override
    public void customize(Jackson2ObjectMapperBuilder builder) {
        builder.simpleDateFormat("yyyy-MM-dd HH:mm:ss");
        builder.serializers(new DateSerializer());
    }


}