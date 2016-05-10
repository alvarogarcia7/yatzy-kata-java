package com.dodevjutsu.kata.yatzee.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DiceReader  {
    private final String representation;

    public DiceReader(String representation) {
        this.representation = representation;
    }

    public List<Integer> extract() {
        if ("".equals(representation)) {
            return Collections.emptyList();
        }

        final String[] tokens = representation.split(" ");
        List<Integer> result = new ArrayList<>();
        for (String token : tokens) {
            final String number = token.substring(1);
            result.add(Integer.parseInt(number));
        }

        return result;
    }
}
