package com.heqin.mergedbeandefinition.spring5x.annotation;

import com.heqin.mergedbeandefinition.spring5x.beans.DerivedTestBean;
import com.heqin.mergedbeandefinition.spring5x.beans.TestBean;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.ChildBeanDefinition;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * The type Test import bean definiton.
 *
 * @Author heqin
 * @Date 2021 /9/13 21:43
 */
public class TestImportBeanDefiniton implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        //demo01(registry);
        demo02(registry);
    }

    /**
     * 方式一
     * @param registry
     */
    private void demo01(BeanDefinitionRegistry registry){
        //父 BeanDefintion
        GenericBeanDefinition parentBeanDefinition = new GenericBeanDefinition();
        parentBeanDefinition.setBeanClass(TestBean.class);
        parentBeanDefinition.getPropertyValues().add("name","parent").add("age",1).add("desc","测试ing...");
        registry.registerBeanDefinition("inheritedTestBean",parentBeanDefinition);

        //子 BeanDefintion
        GenericBeanDefinition childBeanDefinition = new GenericBeanDefinition();
        childBeanDefinition.setBeanClass(DerivedTestBean.class);
        childBeanDefinition.getPropertyValues().add("name","override");
        childBeanDefinition.setParentName("inheritedTestBean");
        registry.registerBeanDefinition("inheritsWithDifferentClass",childBeanDefinition);
    }

    /**
     * 方式二
     * @param registry
     */
    private void demo02(BeanDefinitionRegistry registry){
        //父 BeanDefintion
        //观察 当使用 RootBeanDefinition 与 使用 GenericBeanDefinition 时，beanFactory.getBeanDefinition("parent") 输出的不同
        //RootBeanDefinition parentBeanDefinition = new RootBeanDefinition();//使用 RootBeanDefinition
        GenericBeanDefinition parentBeanDefinition = new GenericBeanDefinition();//使用 GenericBeanDefinition
        parentBeanDefinition.setBeanClass(TestBean.class);
        parentBeanDefinition.getPropertyValues().add("name","parent")
                .add("age",1)
                .add("desc","测试ing...");
        //上面getPropertyValues.add("xxx","yyy");xxx属性需要有相应的setter方法，否则会有异常：
        //Caused by: org.springframework.beans.NotWritablePropertyException: Invalid property 'desc' of bean class [com.heqin.mergedbeandefinition.spring5x.beans.TestBean]:
        //Bean property 'desc' is not writable or has an invalid setter method. Does the parameter type of the setter match the return type of the getter?
        registry.registerBeanDefinition("inheritedTestBean",parentBeanDefinition);

        //子 BeanDefintion
        ChildBeanDefinition childBeanDefinition = new ChildBeanDefinition("inheritedTestBean");
        childBeanDefinition.setBeanClass(DerivedTestBean.class);
        childBeanDefinition.getPropertyValues().add("name","override");
        registry.registerBeanDefinition("inheritsWithDifferentClass",childBeanDefinition);
    }
}
