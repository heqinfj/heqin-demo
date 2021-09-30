package com.heqin.argstojar;

import java.util.Collections;

/**
 * @Author heqin
 * @Date 2021/9/21 7:33
 */
public class Utils {

    public static void printH(String s) {
        System.out.println("\n" + s);
        //Java 11及更高版本
        //System.out.println("-".repeat(s.length()));

        //Java 8及更高版本
        System.out.println(String.join("", Collections.nCopies(s.length(), "-")));
    }

    public static void print(String s) {
        System.out.println(s);
    }

    public static String filter(Object o) {
        return o.toString();
//        String s = o.toString();
//        if (s == null || s.length() == 0) {
//            return "";
//        }
//
//        if (s.contains("CODERGRAMMER")) {
//            return s;
//        }
//        return "**";
    }

}
