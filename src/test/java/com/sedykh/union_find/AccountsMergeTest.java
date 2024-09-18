package com.sedykh.union_find;

import java.util.List;
import org.junit.jupiter.api.Test;

class AccountsMergeTest {

    @Test
    void accountsMerge() {
        List<List<String>> lists = new AccountsMerge().accountsMerge(List.of(
                List.of("David", "David0@m.co", "David1@m.co"),
                List.of("David", "David3@m.co", "David4@m.co"),
                List.of("David", "David4@m.co", "David5@m.co"),
                List.of("David", "David2@m.co", "David3@m.co"),
                List.of("David", "David1@m.co", "David2@m.co")
        ));
    }
}