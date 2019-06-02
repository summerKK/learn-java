package com.summer.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String source) {
        if (source == null) {
            throw new RuntimeException("数据不能为空");
        }

        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
            return dateFormat.parse(source);
        } catch (Exception e) {
            throw new RuntimeException("类型转换异常");
        }
    }
}
