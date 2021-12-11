package chapter5generics.item30;

/**
 * @Author heqin
 * @Date 2021/11/27 9:30
 */
@FunctionalInterface
public interface UnaryOperator<T> {
    T apply(T t);
}
