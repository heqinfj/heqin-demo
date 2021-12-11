/**
 * https://github.com/clxering/Effective-Java-3rd-edition-Chinese-English-bilingual
 *
 * @Author heqin
 * @Date 2021/11/21 10:10
 * <p>
 * https://github.com/clxering/Effective-Java-3rd-edition-Chinese-English-bilingual/blob/dev/Chapter-5/Chapter-5-Item-26-Do-not-use-raw-types.md
 * <p>
 * 术语总结如下：
 * Parameterized type（参数化类型）     -      List<String>
 * Actual type parameter（实际类型参数） - String
 * Generic type（泛型） - List<E>
 * Formal type parameter（形式类型参数） - E
 * Unbounded wildcard type（无界通配符类型） - List<?>
 * Raw type（原始类型） - List
 * Bounded type parameter（有界类型参数） - <E extends Number>
 * Recursive type bound（递归类型绑定） - <T extends Comparable<T>>
 * Bounded wildcard type（有界通配符类型） - List<? extends Number>
 * Generic method（泛型方法） - static <E> List<E> asList<E[] a)
 * Type token（类型字面量） - String.class
 */
package chapter5generics;