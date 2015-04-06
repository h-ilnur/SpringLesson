package ru.khairullin.spring.day01.lab07;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ilnur on 06/04/15.
 */
public class ProxyTest {

    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context_lab07.xml");
        Subject subject = context.getBean(Subject.class);
        subject.longMethod();
    }

}
