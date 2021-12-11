package generics.wildcards.lowerboundedwildcards;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Lower Bounded Wildcards
 * 下界通配符
 *
 * @Author heqin
 * @Date 2021/12/3 22:14
 */
public class LowerBoundedWildcards {

    /**
     * The following code adds the numbers 1 through 10 to the end of a list:
     * <p>
     * 假设你要编写一个将 Integer 对象放入列表的方法。为了最大限度地提高灵活性，
     * 你希望该方法能够处理 List<Integer>，List<Number> 和 List<Object> - 任何可以保存 Integer 值的列表。
     * <p>
     * 要编写适用于 Integer 列表和 Integer 的超类型（例如 Integer，Number，和 Object）列表的方法，你可以指定 List<? super Integer>。
     * 术语 List<Integer> 比 List<? super Integer> 更具限制性，因为前者仅匹配类型 Integer 的列表，而后者匹配任何 Integer 的超类型的列表。
     *
     * @param list
     */
    public static void addNumber(List<? super Integer> list) {
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
    }

    @Test
    public void testAddNumber() {
        List<Integer> integerList = new ArrayList<>();
        LowerBoundedWildcards.addNumber(integerList);
        System.out.println(integerList);

        List<Number> numberList = new ArrayList<>();
        LowerBoundedWildcards.addNumber(numberList);
        System.out.println(numberList);

        List<Object> objectList = new ArrayList<>();
        LowerBoundedWildcards.addNumber(objectList);
        System.out.println(objectList);
    }
}
