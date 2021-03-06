package com.dodevjutsu.kata.yatzee.test;

import com.dodevjutsu.kata.yatzee.CliYatzi;
import com.dodevjutsu.kata.yatzee.Console;
import com.dodevjutsu.kata.yatzee.DiceRoller;
import com.dodevjutsu.kata.yatzee.UserInput;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class AcceptanceTest {

    private Mockery context;
    private CliYatzi cli;
    private UserInput userInput;
    private Console console;
    private DiceRoller diceRoller;

    @Before
    public void setUp () {
        context = new Mockery();
        userInput = context.mock(UserInput.class);
        console = context.mock(Console.class);
        diceRoller = context.mock(DiceRoller.class);
    }

    @Test
    public void happy_path () {
        cli = new CliYatzi(console, userInput, diceRoller);

        context.checking(new Expectations() {{
            oneOf(console).print("Category: Ones");
            oneOf(diceRoller).rollAll(); will(returnValue(Arrays.asList(2,4,1,6,1)));
            oneOf(console).print("Dice: D1:2 D2:4 D3:1 D4:6 D5:1");
            oneOf(console).print("[1] Dice to re-run:");

            oneOf(userInput).read(); will(returnValue("D1 D2 D4"));
            oneOf(diceRoller).roll(3); will(returnValue(Arrays.asList(1,5,2)));
            oneOf(console).print("Dice: D1:1 D2:5 D3:1 D4:2 D5:1");

            oneOf(userInput).read(); will(returnValue("D2 D4"));
            oneOf(diceRoller).roll(2); will(returnValue(Arrays.asList(1,5)));
            oneOf(console).print("Dice: D1:1 D2:1 D3:1 D4:5 D5:1");

            oneOf(console).print("Category Ones score: 4");
        }});

        cli.run();

        context.assertIsSatisfied();
    }

}
