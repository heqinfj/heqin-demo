package chapter5generics.item30;

import java.util.Collections;

/**
 * @Author heqin
 * @Date 2021/11/27 9:27
 */
public class Code03 {

    public void testCollections(){
        Collections.reverseOrder();
        Collections.emptySet();

    }

    // Generic singleton factory pattern
    private static UnaryOperator<Object> IDENTITY_FN = t -> t;

    @SuppressWarnings("unchecked")
    public static <T> UnaryOperator<T> identityFunction() {
        return (UnaryOperator<T>) IDENTITY_FN;
    }

    // Sample program to exercise generic singleton
    public static void main(String[] args) {
        String[] strings = { "jute", "hemp", "nylon" };
        UnaryOperator<String> sameString = identityFunction();

        for (String s : strings)
            System.out.println(sameString.apply(s));

        Number[] numbers = { 1, 2.0, 3L };
        UnaryOperator<Number> sameNumber = identityFunction();

        for (Number n : numbers)
            System.out.println(sameNumber.apply(n));
    }

}
