package com.heqin.java8guide.maps;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author heqin
 * @Date 2021/9/15 7:44
 */
public class MapsExample {

    @Test
    public void doCommonTask() {
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "val" + i);
        }
        map.forEach((id, val) -> System.out.println(id + ": " + val));
    }

    /**
     * The default implementation is equivalent to, for this map:
     * 对于此map ，默认实现等效于：
     * <p>
     * V v = map.get(key);
     * if (v == null)
     * v = map.put(key, value);
     * <p>
     * return v;
     * <p>
     *
     * 好处：putIfAbsent阻止我们编写额外if null 检查
     */
    @Test
    public void putIfAbsent() {
        Map<Integer, String> map = new HashMap<>();
        String v = map.putIfAbsent(0, "one");
        //The above code should be self-explaining: putIfAbsent prevents us from writing additional if null checks;
        //上面代码应该是不言自明的，putIfAbsent阻止我们编写额外if null 检查
        System.out.println(v);
        v = map.putIfAbsent(0, "one");
        System.out.println(v);
    }

    /**
     * 测试put与putIfAbsent的区别 --> 返回都是与指定键（key）关联的先前值
     * put：
     * 将指定值与此映射中的指定键相关联（可选操作）。 如果映射先前包含键的映射，则旧值将替换为指定值。 （当且仅当m.containsKey(k)返回true时，才称映射m包含键k的映射。）
     * 参数：
     *  key – 与指定值关联的键
     *  value – 要与指定键关联的值
     * 返回：与key关联的先前值，如果没有key 的映射，则为null 。 （如果实现支持null值，则返回null还可以指示映射先前将null与key关联。）
     *
     * putIfAbsent：
     * 如果指定的键尚未与值关联（或映射到null ）将其与给定值关联并返回null ，否则返回当前值。
     * 返回：与指定键关联的前一个值，如果没有该键的映射，则为null
     * 实施要求：
     * 对于此map ，默认实现等效于：
     *
     *  V v = map.get(key);
     *  if (v == null)
     *      v = map.put(key, value);
     *
     *  return v;
     *
     * 默认实现不保证此方法的同步或原子性属性。 任何提供原子性保证的实现都必须覆盖此方法并记录其并发属性。
     */
    @Test
    public void putAndputIfAbsent() {
        System.out.println("***put的测试****");
        Map<Integer, String> map = new HashMap<>();
        String s = null;
        s = map.put(1, "xiaomi");
        System.out.println(s); // null
        s = map.put(1, "xiaohong");
        System.out.println(s);//xiaomi
        System.out.println(map.get(1));//xiaohong

        System.out.println("***putIfAbsent的测试****");
        map = new HashMap<>();
        s = map.putIfAbsent(1, "xiaomi");
        System.out.println(s);//null
        s = map.putIfAbsent(1, "xiaohong");
        System.out.println(s);//xiaomi
        System.out.println(map.get(1));//xiaomi
    }

    /**
     * computeIfPresent：
     * 如果指定键的值存在且非空，则尝试计算给定键及其当前映射值的新映射。
     * 如果函数返回null ，则删除映射。 如果函数本身抛出（未经检查的）异常，则重新抛出异常，并且当前映射保持不变。
     * 参数：
     *  key – 与指定值关联的键
     *  remappingFunction – 计算值的函数
     * 返回：与指定键关联的新值，如果没有，则为 null
     * 实施要求：
     * 默认实现相当于为此map执行以下步骤，然后返回当前值或null如果现在不存在：
     *
     *  if (map.get(key) != null) {
     *      V oldValue = map.get(key);
     *      V newValue = remappingFunction.apply(key, oldValue);
     *      if (newValue != null)
     *          map.put(key, newValue);
     *      else
     *          map.remove(key);
     *  }
     *
     * 默认实现不保证此方法的同步或原子性属性。 任何提供原子性保证的实现都必须覆盖此方法并记录其并发属性。
     * 特别是，子接口java.util.concurrent.ConcurrentMap所有实现都必须记录该函数是否仅在该值不存在时以原子方式应用一次。
     */
    @Test
    public void computeIfPresent() {
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "val" + i);
        }

        String s = map.computeIfPresent(3, (num, val) -> val + num);
        System.out.println(s);
        System.out.println(map.get(3)); // val33


        System.out.println("---------------------------");
        map.computeIfPresent(9, (num, val) -> null);
        System.out.println(map.containsKey(9));// false
        System.out.println(map.keySet());


        System.out.println("---------------------------");
        System.err.println(map.keySet());
        s = map.computeIfAbsent(23, num -> "val" + num);
        System.out.println(s);
        System.out.println(map.containsKey(23));// true
        System.err.println(map.keySet());


        System.out.println("---------------------------");
        map.computeIfAbsent(3, num -> "bam");
        System.out.println(map.get(3));// val33
    }
}
