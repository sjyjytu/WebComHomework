package com.ketianya.cal.service;

public class tokenStream {
    public String line;

    public tokenStream(String l) {
        line = l;
    }

    public Token get() {
        while (line.length() > 0 && line.charAt(0) == ' ') {
            //略过空格
            line = line.substring(1);
        }
        int type = 0;
        if (line.length() > 0) {
            char c = line.charAt(0);
            if (Character.isDigit(c) || c == '.') {
                type = 1;
            } else if (c == '(' || c == ')') {
                type = 3;
            } else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '%') {
                type = 2;
            } else {
                type = 8;
            }
            Token t = new Token(c, type);
            line = line.substring(1);
            return t;
        } else {
            //为空
            return new Token(' ', type);
        }
    }

    public void unget(Token t) {
        line = t.value + line;
    }
}
