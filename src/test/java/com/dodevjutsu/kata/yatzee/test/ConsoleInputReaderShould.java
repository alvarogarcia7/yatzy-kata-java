package com.dodevjutsu.kata.yatzee.test;

import com.dodevjutsu.kata.yatzee.ConsoleInputReader;
import com.dodevjutsu.kata.yatzee.Die;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ConsoleInputReaderShould {


    Mockery context = new Mockery();

    @Test
    public void get_dice_to_rerun() throws Exception {

        final Console console = context.mock(Console.class);

        context.checking(new Expectations() {{
            oneOf(console).read();
            will(returnValue("D1 D2 D4"));
        }});

        assertThat(new ConsoleInputReader(console).getDiceToReRun(),
                is(Arrays.asList(Die.FIRST, Die.SECOND, Die.FOURTH)));
    }
}
