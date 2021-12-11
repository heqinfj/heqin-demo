package chapter5generics.item29;

/**
 * @Author heqin
 * @Date 2021/11/22 16:20
 */
public class EmptyStackException extends RuntimeException{
    public EmptyStackException() {
        super("stack is empty!");
    }
}
