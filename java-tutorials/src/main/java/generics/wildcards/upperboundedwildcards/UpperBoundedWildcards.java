package generics.wildcards.upperboundedwildcards;

import java.util.List;

/**
 * @Author heqin
 * @Date 2021/12/3 20:31
 */
public class UpperBoundedWildcards {
    /**
     * returns the sum of the numbers in a list
     *
     * @param list
     * @return
     */
    public static double sumOfList(List<? extends Number> list) {
        double s = 0.0;
        for (Number n : list) {
            s += n.doubleValue();
        }
        return s;
    }
}
