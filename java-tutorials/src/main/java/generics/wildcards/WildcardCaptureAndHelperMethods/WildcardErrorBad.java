package generics.wildcards.WildcardCaptureAndHelperMethods;

import java.util.List;

/**
 * @Author heqin
 * @Date 2021/12/4 9:13
 */
public class WildcardErrorBad {
    void swapFirst(List<? extends Number> l1, List<? extends Number> l2) {
        Number temp = l1.get(0);
        //l1.set(0, l2.get(0)); // expected a CAP#1 extends Number,
        // got a CAP#2 extends Number;
        // same bound, but different types
        //l2.set(0, temp);        // expected a CAP#1 extends Number,
        // got a Number
    }
}
