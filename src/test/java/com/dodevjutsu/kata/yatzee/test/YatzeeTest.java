package com.dodevjutsu.kata.yatzee.test;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

public class YatzeeTest {

    Mockery context = new Mockery();

    @Test
    public void produces_game_output() throws Exception {

        Console console = context.mock(Console.class);
        final Yatzee yatzee = new Yatzee(console);

        context.checking(new Expectations() {{
            oneOf(console).print("Category: Ones");
        }});

        yatzee.play();

        context.assertIsSatisfied();
    }
}
