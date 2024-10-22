package com.sedykh.union_find;

import com.sedykh.TestUtils;
import org.junit.jupiter.api.Test;

import java.util.List;

class AccountsMergeTest {

    @Test
    void accountsMerge() {
        //given
        var expected = List.of(List.of("David", "David0@m.co",
                "David1@m.co", "David2@m.co", "David3@m.co", "David4@m.co", "David5@m.co"));
        List<List<String>> request = List.of(
                List.of("David", "David0@m.co", "David1@m.co"),
                List.of("David", "David3@m.co", "David4@m.co"),
                List.of("David", "David4@m.co", "David5@m.co"),
                List.of("David", "David2@m.co", "David3@m.co"),
                List.of("David", "David1@m.co", "David2@m.co")
        );
        //when
        List<List<String>> actual = new AccountsMerge().accountsMerge(request);
        //then
        TestUtils.equalsInAnyOrder(actual, expected);
    }

    @Test
    void accountsMerge2() {
        //given
        var request = List.of(
                List.of("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                List.of("John", "johnsmith@mail.com", "john00@mail.com"),
                List.of("Mary", "mary@mail.com"),
                List.of("John", "johnnybravo@mail.com")
        );
        var expected = List.of(
                List.of("John", "john00@mail.com", "john_newyork@mail.com", "johnsmith@mail.com"),
                List.of("Mary", "mary@mail.com"),
                List.of("John", "johnnybravo@mail.com")
        );
        //when
        List<List<String>> actual = new AccountsMerge().accountsMerge(request);
        //then
        TestUtils.equalsInAnyOrder(actual, expected);
    }

    @Test
    void accountsMerge3() {
        //given
        var request = List.of(
                List.of("Gabe", "Gabe0@m.co", "Gabe3@m.co", "Gabe1@m.co"),
                List.of("Kevin", "Kevin3@m.co", "Kevin5@m.co", "Kevin0@m.co"),
                List.of("Ethan", "Ethan5@m.co", "Ethan4@m.co", "Ethan0@m.co"),
                List.of("Hanzo", "Hanzo3@m.co", "Hanzo1@m.co", "Hanzo0@m.co"),
                List.of("Fern", "Fern5@m.co", "Fern1@m.co", "Fern0@m.co")
        );
        var expected = List.of(
                List.of("Ethan", "Ethan0@m.co", "Ethan4@m.co", "Ethan5@m.co"),
                List.of("Gabe", "Gabe0@m.co", "Gabe1@m.co", "Gabe3@m.co"),
                List.of("Hanzo", "Hanzo0@m.co", "Hanzo1@m.co", "Hanzo3@m.co"),
                List.of("Kevin", "Kevin0@m.co", "Kevin3@m.co", "Kevin5@m.co"),
                List.of("Fern", "Fern0@m.co", "Fern1@m.co", "Fern5@m.co")
        );
        //when
        List<List<String>> actual = new AccountsMerge().accountsMerge(request);
        //then
        TestUtils.equalsInAnyOrder(actual, expected);
    }
}