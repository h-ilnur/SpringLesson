package ru.khairullin.spring.day01.lab01;

import java.lang.reflect.Method;


/**
 * Created by ilnur on 06/04/15.
 */
public class ObjectFactory {

    public static void main(String[] args) throws Exception {
        Class clazzToInstantiate = Class.forName(args[0]);
        Object newInstance = clazzToInstantiate.newInstance();
        System.out.println(newInstance);
        Method[] methods = clazzToInstantiate.getMethods();
        for (Method method : methods) {
            RunThisMethod annotation = method.getAnnotation(RunThisMethod.class);
            if (annotation != null) {
                int repeat = annotation.repeat();
                for (int i = 0; i < repeat; i++) {
                    method.invoke(newInstance);
                }
            }
        }
    }

}