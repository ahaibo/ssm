package com.hai.converter;


import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 此实现无法注入到 FormattingConversionServiceFactoryBean 中
 * Created by as on 2017/3/9.
 */
public class DateConverter2 implements WebBindingInitializer {

    public DateConverter2() {
        System.out.println(this.getClass().getName());
    }

    public void initBinder(WebDataBinder binder, WebRequest request) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}
