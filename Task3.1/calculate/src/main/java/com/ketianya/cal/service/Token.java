package com.ketianya.cal.service;

public class Token {
    public int type;
    public char value;
    public Token(char v, int t) {
        value = v;
        type = t;
    }
}