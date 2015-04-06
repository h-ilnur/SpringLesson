package ru.khairullin.spring.day01.lab07;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by ilnur on 06/04/15.
 */
public class DynamicProxyTest {

    public static void main(String[] args) throws InterruptedException {
        Subject subject = (Subject) Proxy.newProxyInstance(Subject.class.getClassLoader(),
                new Class[]{Subject.class}, new InvocationHandler() {
                    private RealSubject realSubject = new RealSubject();

                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        long startTime = System.currentTimeMillis();
                        Object returnValue = method.invoke(realSubject);
                        System.out.println("Invocation time " + (System.currentTimeMillis() - startTime));
                        return returnValue;
                    }
                });
        subject.longMethod();
    }

}
