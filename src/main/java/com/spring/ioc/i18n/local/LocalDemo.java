package com.spring.ioc.i18n.local;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Locale类表示一个本地化对象，它允许通过语言参数和国家/地区参数创建一个本地化对象
 */
public class LocalDemo {


    public static void main(String[] args) {
        //testResourceBundle();
        testPlaceholderProperty();
    }

    /**
     * 配置文件中含有占位符，结合MessageFormat进行转换
     */
    private static void testPlaceholderProperty() {

        Object[] params = {"riane", "Kyrie", new GregorianCalendar().getTime()};
        ResourceBundle placeholder = ResourceBundle.getBundle("placeholder");
        String myInfo = placeholder.getString("my.info");
        String myInfoMsg = MessageFormat.format(myInfo, params);
        System.out.println(myInfoMsg);

        String myMsg = placeholder.getString("my.msg");
        String myMsgMsg = MessageFormat.format(myMsg, params);
        System.out.println(myMsgMsg);


    }

    private static void testResourceBundle() {
        /**
         * <p>
         * 国际化文件的命名规范：<资源名称>_<语言代码>_<国家/地区代码>.properties。
         * 其中：语言代码以及国家/地区代码都是可选的，默认的资源文件就是<资源名称>.properties。
         * 即某个本地化类型的系统找不到对应的资源文件，就采用这个默认的资源文件。
         * 相应的如果找不到相应国家或者地区的，就退而求其次，找语言代码的，找到就用。
         * 如：resource_en_Us.properties
         * </p>
         */
        /**
         * {@linkplain ResourceBundle} 用于加载本地化资源文件。
         *
         * 加载资源的顺序：根据locale找资源文件，找不到，就根据Locale.getDefault的locale查找资源文件，
         * 再找不到就加载默认的资源文件：<资源名称>.properties，如果都不存在，则抛出异常
         */
        Locale locale = Locale.getDefault();
        ResourceBundle resourceBundle = ResourceBundle.getBundle("resourcebundle", locale);
        String bundleString = resourceBundle.getString("bundle");
        System.out.println(bundleString);

        Locale locale1 = Locale.US;
        ResourceBundle bundle = ResourceBundle.getBundle("resourcebundle", locale1);
        System.out.println(bundle.getString("bundle"));

        ResourceBundle bundle1 = ResourceBundle.getBundle("resourcebundle", Locale.CANADA);
        System.out.println(bundle1.getString("bundle"));


    }


    public static void testLocale() {
        Locale locale = new Locale("zh", "CN");
        Locale locale1 = new Locale("zh");
        //Locale.CHINA等价于new Locale("zh","CN");
        Locale locale2 = Locale.CHINA;
        //SIMPLIFIED_CHINESE == CHINA
        Locale locale3 = Locale.SIMPLIFIED_CHINESE;

        // CHINESE == new Locale("zh");
        Locale locale4 = Locale.CHINESE;

        /**
         * 获取本地系统默认的本地化对象
         * 如果希望改变系统默认的本地化对象，启动时命令参数：java -Duser.language=en -Duser.region=US MYTest
         */
        Locale locale5 = Locale.getDefault();


        /**
         * JDK 有几个支持本地化的格式化操作工具类：
         *
         * {@linkplain NumberFormat}:按本地化的方式对货币金额进行格式化转换
         * {@linkplain DateFormat}: 按本地化的方式对日期进行格式化操作
         * {@linkplain MessageFormat}：在上面两个的基础上提供了强大的占位符字符串的格式化功能，支持时间，货币，数字及
         * 对象那个属性的格式化操作
         */

        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        System.out.println(numberFormat.format(123456.789));

        Locale locale6 = new Locale("en", "US");
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, locale6);
        System.out.println(dateFormat.format(new Date()));

        //格式化信息
        String pattern1 = "{0} ,你好，你于{1}在工商银行存入{2}元";
        /**
         * 指定参数索引外，还指定了类型和样式
         * {2,number,currency}实际上引用了：NumberFormat.getCurrencyInstance
         */
        String pattern2 = "At {1,time,short} On {1,date,long} ,{0} paid {2,number,currency} .";

        //用于动态替换占位符的参数
        Object[] params = {"Json", new GregorianCalendar().getTime(), 1.0E3};

        //使用默认的本地化对象格式化对象
        String msg1 = MessageFormat.format(pattern1, params);

        MessageFormat messageFormat = new MessageFormat(pattern2, Locale.US);
        String msg2 = messageFormat.format(params);
        System.out.println(msg1);
        System.out.println(msg2);

    }
}
