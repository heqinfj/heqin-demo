package chapter5generics.item26;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 对比原型类型，泛型类型的优点
 *
 * @Author heqin
 * @Date 2021/11/21 10:14
 */
public class GenericTypeAdvantageTest {

    /**
     * 测试使用原型存在的风险
     */
    @Test
    public void testRawTypeRisk() {
        // Raw collection type - don't do this!
        //原始集合类型 - 不要这样做
        // My stamp collection. Contains only Stamp instances.
        Collection stamps = new ArrayList();
        stamps.add(new Coin());

        // Raw iterator type - don't do this!
        //原始迭代类型 - 不要这样做
        for (Iterator i = stamps.iterator(); i.hasNext(); ) {
            Stamp stamp = (Stamp) i.next(); // Throws ClassCastException
            stamp.cancel();
        }
    }

    /**
     * 测试泛型的优点
     */
    @Test
    public void testGenericTypeAdvantage() {
        // My stamp collection. Contains only Stamp instances.
        Collection<Stamp> stamps = new ArrayList();
        //stamps.add(new Coin());//编译error

    }
}
