package chapter5generics.item29;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author heqin
 * @Date 2021/11/22 15:55
 */
public class Code {
    public void test(){
        Stack stack = new Stack();
    }

    @Test
    public void test01(){
        List<Object> objectList = new ArrayList<>();
        List<String> stringList = new ArrayList<>();
        //Incompatible types 不兼容的类型
        //objectList = stringList;//compile error

        Object[] objectArrays;
        String[] stringArrays = new String[1];
        objectArrays = stringArrays;
        //可以理解String[]是Object[]的子类型
        System.out.println(stringArrays instanceof Object[]);//true
    }
}
