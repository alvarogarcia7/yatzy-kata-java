package com.dodevjutsu.kata.yatzee;

public class CliYatzi {
    private final Console console;

    public CliYatzi (final Console console) {
        this.console = console;
    }

    public void run () {
        console.print("Category: Ones");
    }
}
