package com.heqin.javabase;

//import javafx.beans.property.adapter.JavaBeanObjectProperty;
//import javafx.beans.property.adapter.JavaBeanObjectPropertyBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 学习 JavaBeanLongPropertyBuilder 类
 *
 * @Author heqin
 * @Date 2021/9/30 16:26
 */
public class JavaBeanObjectPropertyBuilderExample {

    private static Logger logger = LoggerFactory.getLogger(JavaBeanObjectPropertyBuilderExample.class);

    @Test
    public void test_01() throws NoSuchMethodException {
        User user = new User();
        user.setUserName("xiaomi");
        //JavaBeanObjectProperty javaBeanObjectProperty = JavaBeanObjectPropertyBuilder.create().beanClass(User.class).name("userName").build();
        //logger.info("{}",javaBeanObjectProperty);
    }

    public class User{

        private String userName;

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }
}
