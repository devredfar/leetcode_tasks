package com.sedykh.linked_lists;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BrowserHistoryTest {

    @Test
    public void test() {
        BrowserHistory history = new BrowserHistory("start");
        history.visit("1");
        history.visit("2");
        history.visit("3");
        assertEquals("2", history.back(1));
        assertEquals("3", history.forward(1));
    }

    @Test
    public void test2() {
        BrowserHistory history = new BrowserHistory("start");
        history.visit("1");
        history.visit("2");
        history.visit("3");
        assertEquals("2", history.back(1));
        history.visit("4");
        assertEquals("4", history.forward(1));
        assertEquals("4", history.forward(5));
        assertEquals("start", history.back(10));
    }

}