package com.dodevjutsu.kata.yatzee.test;

import com.dodevjutsu.kata.yatzee.Die;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DiceReader {
    private final String representation;
    private static final Map<String, Die> dieByToken = initializeDice();

    private static Map<String, Die> initializeDice() {
        Map<String, Die> diceTokens = new HashMap<>();
        diceTokens.put("D1", Die.FIRST);
        diceTokens.put("D2", Die.SECOND);
        diceTokens.put("D3", Die.THIRD);
        diceTokens.put("D4", Die.FOURTH);
        diceTokens.put("D5", Die.FIFTH);
        return Collections.unmodifiableMap(diceTokens);
    }

    public DiceReader(String representation) {
        this.representation = representation;
    }

    public List<Die> extract() {
        if ("".equals(representation)) {
            return Collections.emptyList();
        }

        final String[] tokens = representation.split(" ");
        return Stream.of(tokens)
                .map(this::tokenToDie)
                .collect(Collectors.toList());
    }

    /**
     * This level of indirection used as a seam to convert Die Representation to Die Object
     */
    private Die tokenToDie(String token) {
        return dieByToken.get(token);
    }

}
