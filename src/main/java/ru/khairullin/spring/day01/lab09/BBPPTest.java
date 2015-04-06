package ru.khairullin.spring.day01.lab09;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ilnur on 06/04/15.
 */
public class BBPPTest {

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = new ClassPathXmlApplicationContext("context_lab09.xml");
        context.getBean(Subject.class).longMethod();
    }

}
