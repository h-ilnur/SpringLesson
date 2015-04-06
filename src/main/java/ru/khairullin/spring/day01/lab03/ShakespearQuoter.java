package ru.khairullin.spring.day01.lab03;

/**
 * Created by ilnur on 06/04/15.
 */
public class ShakespearQuoter implements Quoter {

    public String quote;

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public void sayQuote() {
        System.out.println(quote);
    }

}