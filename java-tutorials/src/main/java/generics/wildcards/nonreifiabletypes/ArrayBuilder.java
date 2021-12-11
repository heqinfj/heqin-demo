package generics.wildcards.nonreifiabletypes;

import java.util.Arrays;
import java.util.List;

/**
 * @Author heqin
 * @Date 2021/12/4 8:47
 */
public class ArrayBuilder {

    @SafeVarargs //避免编译器为这些类型的 varargs 方法生成警告
    public static <T> void addToList(List<T> listArg, T... elements) {
        for (T x : elements) {
            listArg.add(x);
        }
    }

    /**
     * 错误的方法
     *
     * @param l
     */
    @SafeVarargs //避免编译器为这些类型的 varargs 方法生成警告
    public static void faultyMethod(List<String>... l) {
        Object[] objectArray = l;     // Valid
        objectArray[0] = Arrays.asList(42);
        String s = l[0].get(0);       // ClassCastException thrown here
    }

}
