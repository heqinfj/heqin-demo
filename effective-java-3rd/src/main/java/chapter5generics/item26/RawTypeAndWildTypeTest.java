package chapter5generics.item26;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author heqin
 * @Date 2021/11/21 11:14
 */
public class RawTypeAndWildTypeTest {
    public void testRawType() {
        // Raw collection type - don't do this!
        Collection collection = new HashSet();//Unchecked call to 'add(E)' as a member of raw type 'java.util.Collection'
        collection.add(1);
        collection.add("a");
        collection.add(new Object());
    }

    public void testWildType() {
        Collection<?> collection = new HashSet<>();
        //collection.add(1);//error
        //collection.add("a");//error
        collection.add(null);
    }

    public void testInstanceof(Object o) {
        if (o instanceof Set) {//Raw type
            //不要使用raw type（原始类型）
            //Set set = (Set)o;//Raw use of parameterized class 'Set' 参数化类Set的原始使用
            //注意，一旦确定 o 是一个 Set，就必须将其强制转换为通配符类型 Set<?>，而不是原始类型 Set。这是一个经过检查的强制类型转换，所以不会引发编译器警告。
            Set<?> set = (Set<?>) o;//Wildcard type
        }
    }
}
