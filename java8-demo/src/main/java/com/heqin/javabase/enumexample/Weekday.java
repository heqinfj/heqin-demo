package com.heqin.javabase.enumexample;

/**
 * Weekday枚举类
 *
 * @Author heqin
 * @Date 2021/10/20 23:15
 */
public enum Weekday {

    MON(1), TUE(2), WED(3), THU(4), FRI(5), SAT(6), SUN(110);

    public final int dayValue;

    //Modifier 'private' is redundant for enum constructors
    //修饰符“private”对于枚举构造函数是多余的
    private Weekday(int dayValue) {
        this.dayValue = dayValue;
    }
}

/*
    Weekday.java -> Weekday.class -> Weekday.jad
    上面枚举类 Weekday 经过jad反编译的jad内容如下：
    final class Weekday extends Enum {

        public static Weekday[] values() {
            return (Weekday[]) $VALUES.clone();
        }

        public static Weekday valueOf(String name) {
            return (Weekday) Enum.valueOf(com / heqin / javabase / enumexample / Weekday, name);
        }

        private Weekday(String name, int ordinal, int j) {
            super(name, ordinal);
            dayValue = j;
        }

        public static final Weekday MON;
        public static final Weekday TUE;
        public static final Weekday WED;
        public static final Weekday THU;
        public static final Weekday FRI;
        public static final Weekday SAT;
        public static final Weekday SUN;
        public final int dayValue;
        private static final Weekday $VALUES[];

        static {
            MON = new Weekday("MON", 0, 1);
            TUE = new Weekday("TUE", 1, 2);
            WED = new Weekday("WED", 2, 3);
            THU = new Weekday("THU", 3, 4);
            FRI = new Weekday("FRI", 4, 5);
            SAT = new Weekday("SAT", 5, 6);
            SUN = new Weekday("SUN", 6, 110);
            $VALUES = (new Weekday[]{
                    MON, TUE, WED, THU, FRI, SAT, SUN
            });
        }
    }

 */
