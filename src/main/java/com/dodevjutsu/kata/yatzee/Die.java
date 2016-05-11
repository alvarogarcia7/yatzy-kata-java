package com.dodevjutsu.kata.yatzee;

public enum Die {
    FIRST,SECOND,THIRD, FOURTH, FIFTH;
    public static Die nth(int index) {
        return values()[index];
    }

    public String asString() {
        return "D" + (ordinal()+1);
    }
}
