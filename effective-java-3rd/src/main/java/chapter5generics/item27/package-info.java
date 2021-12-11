/**
 * Item 27: Eliminate unchecked warnings（消除 unchecked 警告）
 * <p>
 * https://github.com/clxering/Effective-Java-3rd-edition-Chinese-English-bilingual/blob/dev/Chapter-5/Chapter-5-Item-27-Eliminate-unchecked-warnings.md
 *
 * @Author heqin
 * @Date 2021/11/21 13:20
 * <p>
 * When you program with generics, you will see many compiler warnings: unchecked cast warnings, unchecked method invocation warnings,
 * unchecked parameterized vararg type warnings, and unchecked conversion warnings. The more experience you acquire with generics,
 * the fewer warnings you’ll get, but don’t expect newly written code to compile cleanly.
 * <p>
 * 当你使用泛型编程时，你将看到许多编译器警告：unchecked 强制转换警告、unchecked 方法调用警告、unchecked 可变参数类型警告和 unchecked 自动转换警告。
 * 使用泛型的经验越丰富，遇到的警告就越少，但是不要期望新编写的代码能够完全正确地编译。
 */
package chapter5generics.item27;