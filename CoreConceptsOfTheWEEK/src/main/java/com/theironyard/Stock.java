package com.theironyard;

import java.time.LocalDate;

/**
 * Created by JamesHartanto on 4/20/17.
 */
public class Stock {
    private String name;
    private String symbol;
    private int value;
    private LocalDate date;

    public Stock() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
