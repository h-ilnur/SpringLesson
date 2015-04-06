package ru.khairullin.spring.day01.lab08;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by ilnur on 06/04/15.
 */
public class BenchmarkBeanPostProcessor implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(final Object bean, String beanName) throws BeansException {
        return bean;
    }

    public Object postProcessAfterInitialization(final Object bean, String beanName) throws BeansException {
        return Proxy.newProxyInstance(bean.getClass().getClassLoader(),
                bean.getClass().getInterfaces(), new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if (bean.getClass().getMethod(method.getName(), method.getParameterTypes())
                                .getAnnotation(Benchmark.class) != null) {
                            long startTime = System.currentTimeMillis();
                            Object returnValue = method.invoke(bean, args);
                            System.out.println("Invocation time " + (System.currentTimeMillis() - startTime));
                            return returnValue;
                        }

                        return method.invoke(bean, args);
                    }
                });
    }

}
