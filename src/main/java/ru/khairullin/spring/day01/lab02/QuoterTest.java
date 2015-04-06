package ru.khairullin.spring.day01.lab02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ilnur on 06/04/15.
 */
public class QuoterTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context_lab02.xml");
        // Get bean by TerminatorQuoter class
        Quoter quoter = (Quoter) context.getBean("TerminatorQuoter", Quoter.class);
        // Get bean by interface Quoter
        //Quoter quoter = context.getBean(Quoter.class);
        quoter.sayQuote();
    }

}