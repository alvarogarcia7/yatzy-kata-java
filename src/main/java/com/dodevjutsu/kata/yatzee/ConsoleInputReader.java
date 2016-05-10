package com.dodevjutsu.kata.yatzee;

import com.dodevjutsu.kata.yatzee.test.Console;
import com.dodevjutsu.kata.yatzee.test.DiceReader;

import java.util.List;

public class ConsoleInputReader implements InputReader {
    private final Console console;

    public ConsoleInputReader(Console console) {
        this.console = console;
    }

    @Override
    public List<Integer> getDiceToReRun() {
        return new DiceReader(console.read()).extract();
    }
}
