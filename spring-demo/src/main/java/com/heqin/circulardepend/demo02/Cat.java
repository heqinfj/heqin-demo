package com.heqin.circulardepend.demo02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author heqin
 */
@Component
public class Cat {

    @Autowired
    private Person person;

    public String desc = "This is a cat !";

    public void makeSound(){
        System.out.println("喵喵。。。");
    }

    public void printPerson(){
        System.out.println(person);
    }
}
