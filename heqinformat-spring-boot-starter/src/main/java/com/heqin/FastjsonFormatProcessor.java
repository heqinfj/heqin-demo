package com.heqin;

import com.alibaba.fastjson.JSON;

public class FastjsonFormatProcessor implements FormatProcessor{
    @Override
    public <T> String format(T obj) {
        return "FastjsonFormatProcessor: " + JSON.toJSON(obj);
    }
}
