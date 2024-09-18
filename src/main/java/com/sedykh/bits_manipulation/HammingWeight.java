package com.sedykh.bits_manipulation;

/**
 * 191. Number of 1 Bits
 * <p>
 * Write a function that takes the binary representation of a positive integer and returns the
 * number of set bits it has (also known as the Hamming weight).
 */
public class HammingWeight {

    public static class Optimal {

        public int hammingWeight(int n) {
            int count = 0;
            int mask = 1;
            for (int i = 0; i < 32; i++) {
                if ((n & mask) != 0) {
                    count++;
                }
                n >>= 1;
            }
            return count;
        }
    }

    public static class SubOptimal {

        public int hammingWeight(int n) {
            var accum = 0;
            while (n != 0) {
                if (n % 2 == 1) accum++;
                n = n / 2;
            }
            return accum;
        }
    }

    public static class NiceWay {

        public int hammingWeight(int n) {
            int count = 0;
            while (n != 0) {
                n = n & (n - 1);
                count++;
            }
            return count;
        }
    }
}
