package com.sedykh.bits_manipulation;

import java.util.ArrayList;

/**
 * 338. Counting Bits
 * <p>
 * Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n),
 * ans[i] is the number of 1's in the binary representation of i.
 */
public class CountBits {

    public static class Optimal {

        private static int unsetLeastSignificantBit(int i) {
            return i & (i - 1);
        }

        public int[] countBits(int n) {
            int[] res = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                int oldInt = unsetLeastSignificantBit(i);
                res[i] = 1 + res[oldInt];
            }
            return res;
        }
    }

    static class Naive {
        public int[] countBits(int n) {
            var bits = new ArrayList<Integer>();
            int mask = 1;
            for (int i = 0; i <= n; i++) {
                int result = 0;
                int value = i;
                while (value != 0) {
                    var bit = value & mask;
                    if (bit == 1) {
                        result++;
                    }
                    value >>= 1;
                }
                bits.add(result);
            }
            int[] bitsArray = new int[bits.size()];
            for (int i = 0; i < bitsArray.length; i++) {
                bitsArray[i] = bits.get(i);
            }
            return bitsArray;
        }
    }
}
