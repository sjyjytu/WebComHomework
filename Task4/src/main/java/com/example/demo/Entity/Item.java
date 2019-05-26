package com.example.demo.Entity;

import java.util.Date;

public class Item {
    private Date addTime;
    private int value;

    public Date getAddTime() {
        return addTime;
    }

    public int getValue() {
        return value;
    }

    public Item(Date date, int value) {
        this.addTime = date;
        this.value = value;
    }
}
