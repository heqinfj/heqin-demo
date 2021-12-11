package chapter5generics.item27;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author heqin
 * @Date 2021/11/21 11:48
 */
public class Code01 {
    /**
     * Eliminate unchecked warnings 消除未检查警告
     */
    public void testEliminateUncheckedWarnings() {
        //Raw use of parameterized class 'HashSet'
        //Unchecked assignment: 'java.util.HashSet' to 'java.util.Set<chapter5generics.item27.Lark>'
        //Set<Lark> exaltation = new HashSet();
        Set<Lark> exaltation = new HashSet<>();
    }
}
