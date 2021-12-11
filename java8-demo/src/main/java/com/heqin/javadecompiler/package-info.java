/**
 * java decompiler
 * java 反编译
 *
 * Java语法糖-泛型-类型擦除
 *   特别说明：在使用intelliJ IDEA或者JD-GUI等反编译图形工具，查看泛型类字节码时，依然可以看到泛型信息，这于大家所熟悉的“编译之后泛型擦除”的说法相悖。
 *   可以用javap -verbose查看class文件的虚拟机指令。以代码清单generic-type-erasure1的Node类为例，运行javap之后的输出如下所示（仅截取方法描述）：
 * https://leesir.github.io/2019/07/java-sugar-generic-type-erasure
 *
 * Java代码的编译与反编译那些事儿
 * https://www.hollischuang.com/archives/58
 *
 * 浅析java常见语法糖
 * http://www.4k8k.xyz/article/caohao1210/107213516
 *
 * @Author heqin
 * @Date 2021/10/4 17:10
 */
package com.heqin.javadecompiler;