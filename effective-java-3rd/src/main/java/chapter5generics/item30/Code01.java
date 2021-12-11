package chapter5generics.item30;

import java.util.HashSet;
import java.util.Set;

/**
 * 1. Unchecked call to 'HashSet(Collection<? extends E>)' as a member of raw type 'java.util.HashSet'
 * <p>
 * 2. Unchecked call to 'addAll(Collection<? extends E>)' as a member of raw type 'java.util.Set'
 *
 * @Author heqin
 * @Date 2021/11/26 22:13
 */
public class Code01 {
    // Uses raw types - unacceptable! (Item 26)
    public static Set union(Set s1, Set s2) {
        Set result = new HashSet(s1);
        result.addAll(s2);
        return result;
    }
}
