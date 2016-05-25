package com.dodevjutsu.kata.yatzee.test;

import com.dodevjutsu.kata.yatzee.CliYatzi;
import com.dodevjutsu.kata.yatzee.Console;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

public class AcceptanceTest {

    private Mockery context;
    private CliYatzi cli;

    @Before
    public void setUp () {
        context = new Mockery();
    }

    @Test
    public void happy_path () {
        final Console console = context.mock(Console.class);
        cli = new CliYatzi(console);

        context.checking(new Expectations() {{
            oneOf(console).print("Category: Ones");
        }});

        cli.run();

        context.assertIsSatisfied();
    }
}
