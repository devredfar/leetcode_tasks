package com.sedykh.recuresion;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FibonacciTest {

    @Test
    void fib12() {
        assertEquals(0, new Fibonacci().fib(0));
    }

    @Test
    void fib123() {
        assertEquals(1, new Fibonacci().fib(1));
    }

    @Test
    void fib2() {
        assertEquals(1, new Fibonacci().fib(2));
    }


    @Test
    void fib() {
        assertEquals(2, new Fibonacci().fib(3));
    }


    @Test
    void fib3() {
        assertEquals(3, new Fibonacci().fib(4));
    }
}