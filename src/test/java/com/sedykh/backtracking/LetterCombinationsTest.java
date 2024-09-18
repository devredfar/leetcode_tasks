package com.sedykh.backtracking;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

class LetterCombinationsTest {

    @Test
    void letterCombinations() {
        List<String> actual = new LetterCombinations().letterCombinations("23");
        List<String> expected = List.of("ad","ae","af","bd","be","bf","cd","ce","cf");
        assertThat("List equality without order",
                actual, containsInAnyOrder(expected.toArray()));
    }
}