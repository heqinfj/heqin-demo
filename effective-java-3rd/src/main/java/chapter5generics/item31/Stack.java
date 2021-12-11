package chapter5generics.item31;

import chapter5generics.item29.EmptyStackException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * Object-based collection - a prime candidate for generics
 *
 * @Author heqin
 * @Date 2021/11/22 16:19
 *//**/
public class Stack<E> {
    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    @SuppressWarnings("unchecked")
    public Stack() {
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if (size == 0)
            throw new EmptyStackException();
        E result = elements[--size];
        elements[size] = null; // Eliminate obsolete reference
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }

    // pushAll method without wildcard type - deficient!
    // 没有通配符类型的 pushAll 方法 - 有缺陷！
    public void pushAllWithoutWildcardType(Iterable<E> src) {
        for (E e : src) {
            push(e);
        }
    }

    //pushAll method with wildcard type
    public void pushAllWithWildcardType(Iterable<? extends E> src) {
        for (E e : src) {
            push(e);
        }
    }

    // popAll method without wildcard type - deficient!
    public void popAllWithoutWildcardType(Collection<E> dst) {
        while (!isEmpty()) {
            dst.add(pop());
        }
    }

    // popAll method with wildcard type
    public void popAllWithWildcardType(Collection<? super E> dst) {
        while (!isEmpty()) {
            dst.add(pop());
        }
    }

    // Little program to exercise our generic Stack
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        if (args == null || args.length == 0) {
            args = new String[]{"a", "b"};
        }
        for (String arg : args)
            stack.push(arg);
        while (!stack.isEmpty())
            System.out.println(stack.pop().toUpperCase());
    }

    @Test
    public void testPushAllWithoutWildcardType() {
        Stack<Number> stack = new Stack<>();
        Iterable<Long> src = new ArrayList<>();
        //stack.pushAllWithoutWildcardType(src);//compile error
        //'pushAllWithoutWildcardType(java.lang.Iterable<java.lang.Number>)' in 'chapter5generics.item31.Stack' cannot be applied to '(java.lang.Iterable<java.lang.Long>)'
        //because parameterized types are invariant - 因为参数化类型是不可变的；
    }

    @Test
    public void testPushAllWithWildcardType() {
        Stack<Number> stack = new Stack<>();
        Iterable<Long> src = new ArrayList<>();
        stack.pushAllWithWildcardType(src);
    }

    @Test
    public void testPopAllWithoutWildcardType() {
        Stack<Number> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        Collection<Object> dst = new ArrayList<>();
        //stack.popAllWithoutWildcardType(dst);//compile error
        //'popAllWithoutWildcardType(java.util.Collection<java.lang.Number>)' in 'chapter5generics.item31.Stack' cannot be applied to '(java.util.Collection<java.lang.Object>)'
        System.out.println(dst);
    }

    @Test
    public void testPopAllWithWildcardType() {
        Stack<Number> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        Collection<Object> dst = new ArrayList<>();
        stack.popAllWithWildcardType(dst);
        System.out.println(dst);
    }
}

