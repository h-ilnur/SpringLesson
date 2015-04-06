package ru.khairullin.spring.day01.lab06;

import java.util.List;

/**
 * Created by ilnur on 06/04/15.
 */
public class TalkRobot implements Robot {

    private List<Quoter> quoters;

    @InjectRandomInt(min = 1, max = 3)
    public void talk() {
        for (Quoter quoter : quoters) {
            quoter.sayQuote();
        }
    }

    public void setQuoters(List quoters) {
        this.quoters = quoters;
    }

}