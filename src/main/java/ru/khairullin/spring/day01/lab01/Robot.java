package ru.khairullin.spring.day01.lab01;

/**
 * Created by ilnur on 06/04/15.
 */
public class Robot {

    @Override
    public String toString() {
        return "I am robot";
    }

    @RunThisMethod(repeat = 10)
    public void clean() {
        System.out.print("Cleaning");
    }

}