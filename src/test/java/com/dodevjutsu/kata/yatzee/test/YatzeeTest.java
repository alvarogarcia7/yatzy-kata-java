package com.dodevjutsu.kata.yatzee.test;

import com.dodevjutsu.kata.yatzee.ConsoleInputReader;
import com.dodevjutsu.kata.yatzee.Die;
import com.dodevjutsu.kata.yatzee.DieRoller;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import static com.dodevjutsu.kata.yatzee.Die.*;

public class YatzeeTest {

    Mockery context = new Mockery();

    @Test
    public void produces_game_output() throws Exception {

        Console console = context.mock(Console.class);
        DieRoller dieRoller = context.mock(DieRoller.class);
        final Yatzee yatzee = new Yatzee(console, dieRoller, new ConsoleInputReader(console));

        context.checking(new Expectations() {{
            atLeast(1).of(dieRoller).roll();
            will(onConsecutiveCalls(
                    returnValue(2), returnValue(4), returnValue(1), returnValue(6), returnValue(1),
                    returnValue(1), returnValue(5), returnValue(2)));


            oneOf(console).print("Category: Ones");
            oneOf(console).print("Dice: D1:2 D2:4 D3:1 D4:6 D5:1");
            oneOf(console).print("[1] Dice to re-run:");
            oneOf(console).read();
            will(returnValue("D1 D2 D4"));
            oneOf(console).print("Dice: D1:1 D2:5 D3:1 D4:2 D5:1");
        }});

        yatzee.play();

        context.assertIsSatisfied();
    }
}
