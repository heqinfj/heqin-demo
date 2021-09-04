# 配置类需要标注@Configuration却不知原因？那这次就不能给你涨薪喽
https://yourbatman.cn/x2y/8e3281a7.html

ConfigurationClassUtils 工具类
checkConfigurationClassCandidate()
它是一个public static工具方法，用于判断某个Bean定义是否是@Configuration配置。

# AnnotationConfigApplicationContext的启动分析
```java
new AnnotationConfigApplicationContext(AppConfig.class);
```
- AnnotationConfigApplicationContext的类图

  AnnotationConfigApplicationContext 继承 GenericApplicationContext 类，实现 AnnotationConfigRegistry 接口；

分析过程
new AnnotationConfigApplicationContext(AppConfig.class);

&rArr;

public AnnotationConfigApplicationContext(Class<?>... componentClasses) {
    this();
    register(componentClasses);
    refresh();
}

&rArr;

this();//实例化AnnotationConfigApplicationContext

&rArr;

//实例化AnnotationConfigApplicationContext前，会先实例化父类GenericApplicationContext；

public GenericApplicationContext() {
    this.beanFactory = new DefaultListableBeanFactory();
}

&rArr;

public AnnotationConfigApplicationContext() {
    this.reader = new AnnotatedBeanDefinitionReader(this);
    this.scanner = new ClassPathBeanDefinitionScanner(this);
}


