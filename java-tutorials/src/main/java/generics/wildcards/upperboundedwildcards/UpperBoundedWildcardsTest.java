package generics.wildcards.upperboundedwildcards;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Author heqin
 * @Date 2021/12/3 20:36
 */
public class UpperBoundedWildcardsTest {

    @Test
    public void testSumOfList() {
        List<Integer> integerList = Arrays.asList(1, 2, 3);
        System.out.println(UpperBoundedWildcards.sumOfList(integerList));

        List<Double> doubleList = Arrays.asList(1.2, 2.1, 3.3);
        System.out.println(UpperBoundedWildcards.sumOfList(doubleList));

    }
}
