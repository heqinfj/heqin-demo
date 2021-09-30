package com.heqin.javabase.innerclass;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Desc 通过内部类实现多重继承
 * @Author heqin
 * @Date 2021/9/28 14:55
 */
public class MultiInheritanceByInnerClassExample {

    private static final Logger logger = LoggerFactory.getLogger(MultiInheritanceByInnerClassExample.class);

    @Test
    public void instantiateSon(){
        Son son = new Son();
        logger.info("strong:{}",son.strong());
        logger.info("kind:{}",son.kind());
    }
}
class Father{
    /**
     * 强壮指数
     * @return
     */
    public int strong(){
        return 10;
    }
}
class Mother{
    /**
     * 友善指数
     * @return
     */
    public int kind(){
        return 10;
    }
}
class Son{
    /**
     * 内部类一个很重要的特性：内部类可以继承一个与外部类无关的类，从而保证内部类的独立性。正是基于这一点，多重继承才会成为可能。
     */
    class FatherPlus extends Father{
        @Override
        public int strong() {
            return super.strong() - 1;
        }
    }

    class MotherPlus extends Mother{
        @Override
        public int kind() {
            return super.kind() - 2;
        }
    }

    public int strong(){
        return new FatherPlus().strong();
    }

    public int kind(){
        return new MotherPlus().kind();
    }
}
