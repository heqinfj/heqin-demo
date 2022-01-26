package com.heqin.validatedemo.argstojar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Properties;

//import static com.heqin.validatedemo.argstojar.Utils.*;

/**
 * @Author heqin
 * @Date 2021/9/21 7:32
 */
@SpringBootApplication
public class ArgsToJarApplication {

    public static void main(String[] args) {

        printArguments(args);
        printSystemProperties();
        printEnvironmentVariables();

        SpringApplication.run(ArgsToJarApplication.class, args);
    }

    /**
     * Environment Variables
     */
    static void printEnvironmentVariables() {
        Utils.printH("Environment Variables");
        System.getenv().forEach((k, v) -> Utils.print(k + " " + Utils.filter(v)));
    }

    /**
     * System Properties
     */
    static void printSystemProperties() {
        Utils.printH("System Properties");
        Properties properties = System.getProperties();
        properties.forEach((k, v) -> Utils.print(k + " " + Utils.filter(v)));
    }

    /**
     * Arguments
     *
     * @param args
     */
    static void printArguments(String[] args) {
        Utils.printH("Arguments");
        for (String arg : args) {
            Utils.print(Utils.filter(arg));
        }
    }

}
