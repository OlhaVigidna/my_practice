package com.example.demo.controllers;

import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DateCustomerEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        System.out.println(text);

        try {
            Date parse = new SimpleDateFormat("yyyy/mm/dd").parse(text);
        } catch (ParseException e) {
            System.out.println("date exception");
        }

    }
}
