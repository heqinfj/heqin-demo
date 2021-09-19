package com.heqin.javabase;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

/**
 * @Author heqin
 * @Date 2021/9/17 10:46
 */
public class AbstractExample {

    @Test
    public void test01() throws JsonProcessingException {
        Man man = new Man("football");
        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = mapper.writeValueAsString(man);
        System.out.println(jsonStr);
        //{"name":"This is a person.","privateVal":null,"defaultVal":null,"protectedVal":null,"publicVal":null,"ballType":"football"}
    }

    abstract class AbstractPerson {

        private String name = "This is a person.";

        private String privateVal;

        String defaultVal;

        protected String protectedVal;

        public String publicVal;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPrivateVal() {
            return privateVal;
        }

        public void setPrivateVal(String privateVal) {
            this.privateVal = privateVal;
        }

        public String getDefaultVal() {
            return defaultVal;
        }

        public void setDefaultVal(String defaultVal) {
            this.defaultVal = defaultVal;
        }

        public String getProtectedVal() {
            return protectedVal;
        }

        public void setProtectedVal(String protectedVal) {
            this.protectedVal = protectedVal;
        }

        public String getPublicVal() {
            return publicVal;
        }

        public void setPublicVal(String publicVal) {
            this.publicVal = publicVal;
        }
    }

    class Man extends AbstractPerson {

        private String ballType;

        public Man() {
        }

        public Man(String ballType) {
            this.ballType = ballType;
        }

        public String getBallType() {
            return ballType;
        }

        public void setBallType(String ballType) {
            this.ballType = ballType;
        }
    }
}
