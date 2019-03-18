Spring提供的自动代理机制，可以让容器自动生成代理。
主要利用spring的后置处理器完成的，主要分为一下三类：
```text
1、BeanNameAutoProxyCreator:根据bean的配置名，
   自动创建代理实例的代理创建器
2、DefaultAdvisorAutoProxyCreator:对容器中所有的Advisor进行
   扫描，自动将这些切面应用到匹配的Bean中（为目标Bean
   创建代理实例）
3、AnnotationAwareAspectJAutoProxyCreator:
   基于Bean中的AspectJ注解标签的自动代理创建器：
   即为包含AspectJ注解的Bean自动创建代理实例
```

