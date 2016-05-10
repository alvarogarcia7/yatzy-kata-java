package com.dodevjutsu.kata.yatzee.test;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.is;

public class DiceReaderShould {

    @Test
    public void extract_no_dice_to_rerun() throws Exception {
        assertThat(extract_dice(""), is(Arrays.asList()));
    }

    @Test
    public void extract_a_single_dice_to_rerun() throws Exception {
        assertThat(extract_dice("D5"), is(Arrays.asList(5)));
    }

    @Test
    public void extract_several_die_to_rerun() throws Exception {
        assertThat(extract_dice("D1 D2 D3"), is(Arrays.asList(1, 2, 3)));
    }

    private List<Integer> extract_dice(String representation) {
        return new DiceReader(representation).extract();
    }

}