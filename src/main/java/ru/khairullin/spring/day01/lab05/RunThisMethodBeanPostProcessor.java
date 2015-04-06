package ru.khairullin.spring.day01.lab05;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by ilnur on 06/04/15.
 */
public class RunThisMethodBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BBP before " + beanName);
        Method[] methods = bean.getClass().getMethods();
        for (Method method : methods) {
            RunThisMethod runThisMethod = method.getAnnotation(RunThisMethod.class);
            if (runThisMethod != null) {
                int repeat = runThisMethod.repeat();
                for (int i = 0; i < repeat; i++) {
                    try {
                        method.invoke(bean);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BBP after " + beanName);
        return bean;
    }

}
