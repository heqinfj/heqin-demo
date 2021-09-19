package com.heqin.mergedbeandefinition.spring3x;

import org.springframework.beans.Mergeable;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.ManagedProperties;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Properties;

/**
 * @Author heqin
 * @Date 2021/9/13 17:30
 */
public class CustomerComplexObjectBeanDefinition implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        //ImportBeanDefinitionRegistrar.super.registerBeanDefinitions(importingClassMetadata, registry);
        BeanDefinition parent = new RootBeanDefinition(ComplexObject.class);
        Properties adminEmails = new Properties();
        adminEmails.put("administrator","administrator@example.com");
        adminEmails.put("support","support@example.com");
        parent.getPropertyValues().add("adminEmails",adminEmails);
        registry.registerBeanDefinition("parent",parent);

        GenericBeanDefinition child = new GenericBeanDefinition();
        child.setBeanClass(ComplexObject.class);
        child.setParentName("parent");
        //Properties anotherAdminEmails = new Properties();
        Properties anotherAdminEmails = new ManagedProperties();//implements Mergeable
        anotherAdminEmails.put("sales","sales@example.com");
        anotherAdminEmails.put("support","support@example.co.uk");
        if(anotherAdminEmails instanceof ManagedProperties){
            ManagedProperties anotherAdminEmails2Mp = (ManagedProperties)anotherAdminEmails;
            anotherAdminEmails2Mp.setMergeEnabled(true);//设置为此集合启用合并
        }

        child.getPropertyValues().add("adminEmails",anotherAdminEmails);
        //PropertyValue propertyValue = new PropertyValue("adminEmails",anotherAdminEmails);
        //child.getPropertyValues().addPropertyValue(propertyValue);

        registry.registerBeanDefinition("child",child);
    }

    class MyProperties extends Properties implements Mergeable{

        @Override
        public boolean isMergeEnabled() {
            return false;
        }

        @Override
        public Object merge(Object parent) {
            return null;
        }
    }
}
