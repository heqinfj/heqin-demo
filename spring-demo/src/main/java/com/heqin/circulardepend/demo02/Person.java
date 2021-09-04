package com.heqin.circulardepend.demo02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author heqin
 */
@Component
public class Person {

    @Autowired
    private Cat cat;

    public void makeSound(){
        System.out.println("Hello ...");
    }
}
