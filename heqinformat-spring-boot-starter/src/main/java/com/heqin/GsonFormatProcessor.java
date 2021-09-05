package com.heqin;

import com.google.gson.Gson;

public class GsonFormatProcessor implements FormatProcessor{
    @Override
    public <T> String format(T obj) {
        return "GsonFormatProcessor: " + new Gson().toJson(obj);
    }
}
