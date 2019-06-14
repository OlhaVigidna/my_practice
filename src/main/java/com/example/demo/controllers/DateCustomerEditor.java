package com.example.demo.controllers;

import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DateCustomerEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        System.out.println(text);
        Date date = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
             date = simpleDateFormat.parse(text);
        } catch (ParseException e) {
            System.out.println("Parse exception");
        }

        setValue(date);
    }
}
