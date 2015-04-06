package ru.khairullin.spring.day01.lab04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ilnur on 06/04/15.
 */
public class RobotTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context_lab04.xml");
    }

}