package generics.typeerasure.erasureofgenerictypes;

/**
 * Erasure of Generic Types
 * <p>
 * 泛型的擦除
 *
 * @Author heqin
 * @Date 2021/12/3 11:15
 */
public class ErasureOfGenericTypes {

}

class Node1<T> {

    private T data;
    private Node1<T> next;

    public Node1(T data, Node1<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }
}

class Node2<T extends Comparable<T>> {

    private T data;
    private Node2<T> next;

    public Node2(T data, Node2<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }
}

