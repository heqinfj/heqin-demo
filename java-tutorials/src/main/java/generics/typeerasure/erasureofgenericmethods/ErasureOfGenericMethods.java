package generics.typeerasure.erasureofgenericmethods;

import org.junit.Test;

/**
 * Erasure of Generic Methods
 * 泛型方法的擦除
 *
 * @Author heqin
 * @Date 2021/12/3 10:05
 */
public class ErasureOfGenericMethods {

    /**
     * Counts the number of occurrences of elem in anArray.
     *
     * @param anArray
     * @param elem
     * @param <T>
     * @return
     */
    public static <T> int count(T[] anArray, T elem) {
        int cnt = 0;
        for (T e : anArray) {
            if (e.equals(elem)) {
                ++cnt;
            }
        }
        return cnt;
    }

    /**
     * write a generic method to draw different shapes.
     * <p>
     * 编写一个泛型方法来绘制不同的形状。
     *
     * @param shape
     * @param <T>
     */
    public static <T extends Shape> void draw(T shape) {
        shape.draw();
    }

    public static void draw2(Shape shape) {
        shape.draw();
    }

    @Test
    public void testDraw() {
        ErasureOfGenericMethods.draw(new Shape());
        ErasureOfGenericMethods.draw(new Circle());
        ErasureOfGenericMethods.draw(new Rectangle());
    }
}

class Shape {
    void draw() {
        System.out.println(this.getClass());
    }
}

class Circle extends Shape {
    void draw() {
        System.out.println(this.getClass());
    }
}

class Rectangle extends Shape {
    void draw() {
        System.out.println(this.getClass());
    }
}
