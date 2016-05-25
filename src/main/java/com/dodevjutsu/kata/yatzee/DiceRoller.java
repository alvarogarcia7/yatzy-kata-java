package com.dodevjutsu.kata.yatzee;

import java.util.List;

public interface DiceRoller {
    List<Integer> rollAll ();

    List<Integer> roll (int number);
}
