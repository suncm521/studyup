package java1.util;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
  * Context 工具类
  */

public class CacheContextUtil{
    /**
     *  Spring应用上下文环境
     */
    private static ApplicationContext commonApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");


 /**
      * 根据提供的bean名称得到相应的服务类
      * @param beanId bean的id
      * @return 返回bean的实例对象
      */
    public static Object getBean(String beanId) {
        return commonApplicationContext.getBean(beanId);
     }


    /**
      * 根据提供的bean名称得到对应于指定类型的服务类
      * @param beanId bean的id
      * @param clazz bean的类类型
      * @return 返回的bean类型,若类型不匹配,将抛出异常
      */
         public static <T> T getBean(String beanId, Class<T> clazz) {
        return commonApplicationContext.getBean(beanId, clazz);
    }

}
