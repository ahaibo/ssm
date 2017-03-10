package com.hai.converter;


import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by as on 2017/3/9.
 */
public class DateConverter implements Converter<String, Date> {

    public DateConverter() {
        System.out.println(this.getClass().getName());
    }

    public Date convert(String source) {
        System.out.println(this.getClass().getName() + ".convert. source: " + source);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        try {
            return dateFormat.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
