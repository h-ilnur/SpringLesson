package ru.khairullin.spring.day01.lab09;

/**
 * Created by ilnur on 06/04/15.
 */
@Transactional
public class RealSubject implements Subject {

    @Benchmark
    public void longMethod() throws InterruptedException {
        Thread.sleep(5000);
    }

}
