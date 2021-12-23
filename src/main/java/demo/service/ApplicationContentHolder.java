package demo.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ApplicationContentHolder implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        applicationContext = ctx;
    }

    /**
     * Get application context from everywhere
     *
     * @return
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * Get bean by class
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> clazz) {

        Map<String, T> beansOfType = applicationContext.getBeansOfType(clazz);
        beansOfType.forEach((k,v)->{
            System.out.println("获取bean");
            System.out.println(k);
            System.out.println(v);
        });
        return applicationContext.getBean(clazz);
    }

    /**
     * Get bean by class name
     *
     * @param name
     * @param <T>
     * @return
     */

    public static <T> T getBean(String name) {

        return (T) applicationContext.getBean(name);
    }
}
