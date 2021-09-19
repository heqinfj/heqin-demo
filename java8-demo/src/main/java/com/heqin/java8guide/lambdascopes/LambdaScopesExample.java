package com.heqin.java8guide.lambdascopes;

import com.heqin.java8guide.defaultmethodsforinterfaces.Formula;
import com.heqin.java8guide.functionalinterfaces.Converter;
import org.junit.Test;

/**
 * @Author heqin
 * @Date 2021/9/15 0:27
 */
public class LambdaScopesExample {

    /**
     * We can read final local variables from the outer scope of lambda expressions:
     * 我们可以直接在 lambda 表达式中访问外部的局部变量：
     */
    @Test
    public void accessingLocalVariables(){
        int num = 1;
        Converter<Integer, String> stringConverter = (from) -> String.valueOf(from + num);
        System.out.println(stringConverter.convert(2));
    }

    /**
     * Accessing fields and static variables
     * 访问字段和静态变量
     */
    @Test
    public void accessingFieldsAndStaticVariables(){
        Lambda4 lambda4 = new Lambda4();
        lambda4.testScopes();
    }

    /**
     * Accessing Default Interface Methods
     * 访问接口默认方法
     */
    @Test
    public void accessingDefaultInterfaceMethods(){
        //还记得第一节中的 formula 示例吗？ Formula 接口定义了一个默认方法sqrt，
        // 可以从包含匿名对象的每个 formula 实例访问该方法。 这不适用于lambda表达式。
        //Formula formula = (a) -> sqrt(a * 100);//无法从 lambda 表达式中访问默认方法,故以下代码无法编译：
    }

}
