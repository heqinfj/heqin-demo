package com.heqin.abstractdemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author heqin
 */
public class AppMain {
    public static void main(String[] args) throws JsonProcessingException {
        Man man = new Man("football");
        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = mapper.writeValueAsString(man);
        System.out.println(jsonStr);
    }
}
