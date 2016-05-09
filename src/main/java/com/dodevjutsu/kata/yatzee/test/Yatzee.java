package com.dodevjutsu.kata.yatzee.test;

import java.util.Arrays;
import java.util.List;

public class Yatzee {
    private final Console console;
    private final DiceThrower diceThrower;
    private Sides sides;
    private List<Throw> throws_;

    public Yatzee(Console console, DiceThrower diceThrower) {
        this.console = console;
        this.diceThrower = diceThrower;
        sides = new Sides();
        this.throws_ = Arrays.asList(new Ones(), new Twos(), new Threes());
    }

    public void configureThrows(List<Throw> throws_) {
        this.throws_ = throws_;
    }

    public void play() {
        for (Throw current : throws_) {
            current.play(console, sides, diceThrower);
        }
    }
}
