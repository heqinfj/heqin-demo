package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Generic version of the Box class.
 *
 * @param <T> the type of the value being boxed
 */
public class Box<T> {

    // T stands for "Type"
    private T t;

    private List<T> list = new ArrayList<>();

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public void add(T t) {
        list.add(t);
    }

    public void boxTest(Box<T> box) {
        System.out.println(box.getClass());
    }
}