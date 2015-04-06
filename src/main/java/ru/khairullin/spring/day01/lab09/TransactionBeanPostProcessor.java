package ru.khairullin.spring.day01.lab09;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ilnur on 06/04/15.
 */
public class TransactionBeanPostProcessor implements BeanPostProcessor {

    private List<String> namesToInstrument = new ArrayList<String>();

    public Object postProcessBeforeInitialization(final Object bean, String beanName) throws BeansException {
        if (bean.getClass().getAnnotation(Transactional.class) != null) {
            namesToInstrument.add(beanName);
        }
        return bean;
    }

    public Object postProcessAfterInitialization(final Object bean, String beanName) throws BeansException {
        if (namesToInstrument.contains(beanName)) {
            return Proxy.newProxyInstance(bean.getClass().getClassLoader(),
                    bean.getClass().getInterfaces(), new InvocationHandler() {
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                            System.out.println("Transactional start");
                            Object returnValue = method.invoke(bean, args);
                            System.out.println("Transactional commit");
                            return returnValue;
                        }
                    });
        } else {
            return bean;
        }
    }

}
