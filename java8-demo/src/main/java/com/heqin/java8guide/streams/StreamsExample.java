package com.heqin.java8guide.streams;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The type Streams example.
 *
 * @Author heqin
 * @Date 2021 /9/14 21:47
 */
public class StreamsExample {
    private List<String> stringList;

    /**
     * Initialize.
     */
    @Before
    public void initialize() {
        stringList = new ArrayList<>();
        stringList.add("ddd2");
        stringList.add("aaa2");
        stringList.add("bbb1");
        stringList.add("aaa1");
        stringList.add("bbb3");
        stringList.add("ccc");
        stringList.add("bbb2");
        stringList.add("ddd1");
    }

    /**
     * Filter accepts a predicate to filter all elements of the stream. This operation is intermediate which enables us to call another stream operation (forEach) on the result.
     * ForEach accepts a consumer to be executed for each element in the filtered stream.
     * ForEach is a terminal operation. It's void, so we cannot call another stream operation.
     * 过滤通过一个predicate接口来过滤并只保留符合条件的元素，该操作属于中间操作，所以我们可以在过滤后的结果来应用其他Stream操作（比如forEach）。
     * forEach需要一个函数来对过滤后的元素依次执行。forEach是一个最终操作，所以我们不能在forEach之后来执行其他Stream操作
     */
    @Test
    public void filter() {
        // 测试 Filter(过滤)
        stringList
                .stream()
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);//aaa2 aaa1
    }

    /**
     * Sorted is an intermediate operation which returns a sorted view of the stream. The elements are sorted in natural order unless you pass a custom Comparator.
     * <p>
     * 排序是一个 中间操作，返回的是排序好后的 Stream。如果你不指定一个自定义的 Comparator 则会使用默认排序。
     */
    @Test
    public void sorted() {
        List<String> sortedCollection = stringList.stream().sorted().filter(s -> s.startsWith("a")).collect(Collectors.toList());
        System.out.println(sortedCollection);

        //需要注意的是，排序只创建了一个排列好后的Stream，而不会影响原有的数据源，排序之后原数据stringList是不会被修改的：
        System.out.println(stringList);
    }

    /**
     * The intermediate operation map converts each element into another object via the given function.
     * The following example converts each string into an upper-cased string. But you can also use map to transform each object into another type.
     * The generic type of the resulting stream depends on the generic type of the function you pass to map.
     * <p>
     * 中间操作 map 会将元素根据指定的 Function 接口来依次将元素转成另外的对象。
     * 下面的示例展示了将字符串转换为大写字符串。你也可以通过map来将对象转换成其他类型，map返回的Stream类型是根据你map传递进去的函数的返回值决定的。
     */
    @Test
    public void map() {
        stringList.stream().map(String::toUpperCase).sorted((a, b) -> b.compareTo(a)).forEach(System.out::println);
    }

    /**
     * Various matching operations can be used to check whether a certain predicate matches the stream.
     * All of those operations are terminal and return a boolean result.
     * <p>
     * 可以使用各种匹配操作来检查某个谓词是否与流匹配。 所有这些操作都是终端操作并返回一个布尔结果。
     */
    @Test
    public void match() {
        // 测试 Match (匹配)操作
        boolean anyStartsWithA =
                stringList
                        .stream()
                        .anyMatch((s) -> s.startsWith("a"));
        System.out.println(anyStartsWithA);      // true

        boolean allStartsWithA =
                stringList
                        .stream()
                        .allMatch((s) -> s.startsWith("a"));

        System.out.println(allStartsWithA);      // false

        boolean noneStartsWithZ =
                stringList
                        .stream()
                        .noneMatch((s) -> s.startsWith("z"));

        System.out.println(noneStartsWithZ);      // true
    }

    /**
     * Count is a terminal operation returning the number of elements in the stream as a long.
     * Count 是一个终端操作，以 long 形式返回流中的元素数
     */
    @Test
    public void count() {
        long startsWithB = stringList.stream().filter(s -> s.startsWith("b")).count();
        System.out.println(startsWithB); // 3
    }

    /**
     * This terminal operation performs a reduction on the elements of the stream with the given function. The result is an Optional holding the reduced value.
     * 此终端操作使用给定函数对流的元素执行归约。 结果是一个 Optional 持有减少的值。
     */
    @Test
    public void reduce() {
        Optional<String> reduced = stringList.stream().sorted((a, b) -> a.compareTo(b)).reduce((s1, s2) -> s1 + "#" + s2);
        reduced.ifPresent(System.out::println);
    }

    /**
     * 译者补充
     * 译者注： 这个方法的主要作用是把 Stream 元素组合起来。它提供一个起始值（种子），然后依照运算规则（BinaryOperator），和前面 Stream 的第一个、第二个、第 n 个元素组合。
     * 从这个意义上说，字符串拼接、数值的 sum、min、max、average 都是特殊的 reduce。例如 Stream 的 sum 就相当于Integer sum = integers.reduce(0, (a, b) -> a+b);
     * 也有没有起始值的情况，这时会把 Stream 的前面两个元素组合起来，返回的是 Optional。
     */
    @Test
    public void translatorsSupplement() {
        // 字符串连接，concat = "ABCD"
        String concat = Stream.of("A", "B", "C", "D").reduce("", String::concat);
        System.out.println(concat);

        // 求最小值，minValue = -3.0
        double minValue = Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min);
        System.out.println(minValue);

        // 求和，sumValue = 10, 有起始值
        int sumValue = Stream.of(1, 2, 3, 4).reduce(0, Integer::sum);
        System.out.println(sumValue);

        // 求和，sumValue = 10, 无起始值
        sumValue = Stream.of(1, 2, 3, 4).reduce(Integer::sum).get();
        System.out.println(sumValue);

        // 过滤，字符串连接，concat = "ace"
        concat = Stream.of("a", "B", "c", "D", "e", "F").
                filter(x -> x.compareTo("Z") > 0).
                reduce("", String::concat);
        System.out.println(concat);

        /**
         * 上面代码例如第一个示例的 reduce()，第一个参数（空白字符）即为起始值，第二个参数（String::concat）为 BinaryOperator。
         * 这类有起始值的 reduce() 都返回具体的对象。而对于第四个示例没有起始值的 reduce()，由于可能没有足够的元素，返回的是 Optional，请留意这个区别。
         * 更多内容查看： IBM：Java 8 中的 Streams API 详解
         */
    }
}


