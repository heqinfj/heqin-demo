package chapter5generics.item29;

import java.util.Arrays;

/**
 * Object-based collection - a prime candidate for generics
 *
 * @Author heqin
 * @Date 2021/11/22 16:19
 *//**/
public class StackG2<E> {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public StackG2() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if (size == 0)
            throw new EmptyStackException();
        /**
         * 因为 E 是不可具体化的类型，编译器无法在运行时检查强制转换。同样，你可以很容易地向自己证明 unchecked 的强制转换是安全的，
         * 因此可以适当地抑制警告。根据 Item-27 的建议，我们仅对包含 unchecked 强制转换的赋值禁用警告，而不是对整个 pop 方法禁用警告：
         */
        @SuppressWarnings("unchecked")
        E result = (E) elements[--size];
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

    // Little program to exercise our generic Stack
    public static void main(String[] args) {
        StackG2<String> stack = new StackG2<>();
        if(args == null || args.length == 0){
            args = new String[]{"a","b"};
        }
        for (String arg : args)
            stack.push(arg);
        while (!stack.isEmpty())
            System.out.println(stack.pop().toUpperCase());
    }
}

