package com.dodevjutsu.kata.yatzee.test;

public class Yatzee {
    private final Console console;

    public Yatzee(Console console) {
        this.console = console;
    }

    public void play() {
        console.print("Category: Ones");
    }
}
