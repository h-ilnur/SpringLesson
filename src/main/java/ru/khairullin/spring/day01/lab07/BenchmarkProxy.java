package ru.khairullin.spring.day01.lab07;

/**
 * Created by ilnur on 06/04/15.
 */
public class BenchmarkProxy implements Subject {

    private RealSubject subject;

    public BenchmarkProxy() {
        this.subject = new RealSubject();
    }

    public void longMethod() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        subject.longMethod();
        System.out.println("Time: " + (System.currentTimeMillis() - startTime));
    }

}
