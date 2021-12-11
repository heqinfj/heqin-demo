package com.heqin.javabase.stackexample;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 一个Stack的用途：对整数进行进制的转换就可以利用栈。
 * <p>
 * Stack只有入栈和出栈的操作：
 * <p>
 * 把元素压栈：push(E)；
 * 把栈顶的元素“弹出”：pop()；
 * 取栈顶元素但不弹出：peek()。
 * 在Java中，我们用Deque可以实现Stack的功能：
 * <p>
 * 把元素压栈：push(E)/addFirst(E)；
 * 把栈顶的元素“弹出”：pop()/removeFirst()；
 * 取栈顶元素但不弹出：peek()/peekFirst()。
 * 为什么Java的集合类没有单独的Stack接口呢？因为有个遗留类名字就叫Stack，出于兼容性考虑，所以没办法创建Stack接口，只能用Deque接口来“模拟”一个Stack了。
 * <p>
 * 当我们把Deque作为Stack使用时，注意只调用push()/pop()/peek()方法，不要调用addFirst()/removeFirst()/peekFirst()方法，这样代码更加清晰。
 *
 * @Author heqin
 * @Date 2021/10/8 11:34
 */
public class IntToHexStringByStack {

    public static void main(String[] args) {
        Deque<String> stack = new ArrayDeque<String>();
        int targetInt = 12500;
        int dividend = targetInt;//被除数
        int divisor = 16;//除数
        //Integer.digits
        //被除数、除数、商、余数
        int quotient = 0;//商
        int remainder = 0;//余数
        //当商是0的时候，计算结束，我们把栈的所有元素依次弹出，组成字符串30D4，这就是十进制整数12500的十六进制表示的字符串。
        while (true) {
            quotient = dividend / divisor;
            remainder = dividend % divisor;
            System.out.println(String.format("商:%s,余数:%s", quotient, remainder));
            stack.push(String.valueOf(remainder));
            if (quotient == 0) {
                break;
            }
            dividend = quotient;
        }
        StringBuffer sb = new StringBuffer();
        int total = stack.size();
        for (int i = 0; i < total; i++) {
            sb.append(digits[Integer.valueOf(stack.pop())]);
        }
        System.out.println(String.format("%s的16进制为%s", targetInt, sb.toString().toUpperCase()));
    }


    /**
     * All possible chars for representing a number as a String
     */
    final static char[] digits = {
            '0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b',
            'c', 'd', 'e', 'f', 'g', 'h',
            'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z'
    };
}
