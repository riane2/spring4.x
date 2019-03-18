package com.spring.mvc.config;

import org.springframework.web.SpringServletContainerInitializer;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author lixiongxiong
 * @date 2019/3/18
 * @description mvc config
 */

/**
 * 基于Java配置的实现，类似于以前的web.xml配置
 * <p>
 * <p>
 * servlet3.0中，容器会在类路径查找实现{@linkplain ServletContainerInitializer}的类，如果找到实现类，就会用它来装配servlet容器
 * <p>
 * 在Spring中{@linkplain SpringServletContainerInitializer}，此类实现接口，同时此类还会查找实现了{@linkplain WebApplicationInitializer}
 * 的接口类，并将配置任务交给这些实现类去完成。
 * <p>
 * Spring有个便利的抽象类{@linkplain AbstractAnnotationConfigDispatcherServletInitializer}也实现了上面的接口，使得它在注册dispatcherServlet时
 * 只需要指定他的servlet映射即可
 *
 * dispatcher类中的方法：{@linkplain DispatcherServlet#initStrategies(org.springframework.context.ApplicationContext)}
 * protected void initStrategies(ApplicationContext context) {
 * 		initMultipartResolver(context); //初始化上传文件的解析器
 * 		initLocaleResolver(context);//初始化本地解析器
 * 		initThemeResolver(context); //初始化主题解析器
 * 		initHandlerMappings(context); //初始化处理器路径路由
 * 		initHandlerAdapters(context); //初始化处理器适配器
 * 		initHandlerExceptionResolvers(context); //初始化处理器的异常解析器
 * 		initRequestToViewNameTranslator(context); //初始化视图名翻译器
 * 		initViewResolvers(context); //初始化视图解析器
 * 		initFlashMapManager(context); //i初始化重定向数据管理器
 *        }
 *
 *
 */
public class MyMvcConfig implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        DispatcherServlet dispatcherServlet = new DispatcherServlet();
        /*dispatcherServlet.setNamespace(""); //设置<servlet-name>-servlet
        dispatcherServlet.setContextConfigLocation("");
        dispatcherServlet.setPublishContext(true);
        dispatcherServlet.setPublishEvents(false);*/
        ServletRegistration.Dynamic servletRegistration = servletContext.addServlet("dispatcher", dispatcherServlet);
        servletRegistration.setLoadOnStartup(1);
        servletRegistration.addMapping("*.html");
    }
}
