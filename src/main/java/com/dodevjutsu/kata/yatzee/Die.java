package com.dodevjutsu.kata.yatzee;

public enum Die {
    FIRST(1),SECOND(2);


    private final int value;

    Die(int value) {
        this.value = value;
    }

    public Integer value() {
        return this.value;
    }
}
