package ru.khairullin.spring.day01.lab07;

/**
 * Created by ilnur on 06/04/15.
 */
public class RealSubject implements Subject {

    public void longMethod() throws InterruptedException {
        Thread.sleep(5000);
    }

}
