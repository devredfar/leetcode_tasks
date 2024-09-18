package com.sedykh.recuresion;

public class Fibonacci {
    int first = 0;
    int second = 1;

    public int fibOpt(int n) {
        if (n == 0) {
            return first;
        }
        if (n == 1) {
            return second;
        }
        for (int i = 1; i < n; i++) {
            var temp = first + second;
            first = second;
            second = temp;
        }
        return second;
    }


    public int fib(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
