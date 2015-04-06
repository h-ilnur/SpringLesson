package ru.khairullin.spring.day01.lab06;

import java.util.List;

/**
 * Created by ilnur on 06/04/15.
 */
public class TerminatorQuoter implements Quoter {

    public List<String> quotes;

    public void setQuotes(List<String> quotes) {
        this.quotes = quotes;
    }

    public void sayQuote() {
        System.out.println(quotes);
    }

}