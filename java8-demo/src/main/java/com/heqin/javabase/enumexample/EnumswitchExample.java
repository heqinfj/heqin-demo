package com.heqin.javabase.enumexample;

/**
 * 枚举在switch中的用法
 *
 * @Author heqin
 * @Date 2021/10/7 9:21
 */
public class EnumswitchExample {
    public static void main(String[] args) {
        Weekday day = Weekday.SUN;
        switch (day) {
            case MON:
            case TUE:
            case WED:
            case THU:
            case FRI:
                System.out.println("Today is " + day + ". Work at office!");
                break;
            case SAT:
            case SUN:
                System.out.println("Today is " + day + ". Work at home!");
                break;
            default:
                throw new RuntimeException("cannot process " + day);
        }
    }
}

