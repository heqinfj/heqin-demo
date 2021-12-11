package chapter5generics.item27;

import java.util.Arrays;

/**
 * @Author heqin
 * @Date 2021/11/21 12:52
 */
public class Code02 {

    //@SafeVarargs
    @SuppressWarnings("unchecked")
    public static <T> T[] newArray(T... a) {
        //T[] arr = (T[]) new Object[a.length];
        T[] arr = a;
        return arr;
    }

    public static void main(String[] args) {
        String[] strings = Code02.newArray("a", "b");
        System.out.println(Arrays.toString(strings));
    }
}
