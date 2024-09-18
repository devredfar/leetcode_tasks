package com.sedykh.arrays;

/**
 * 682. Baseball Game
 * <p>
 * You are keeping the scores for a baseball game with strange rules. At the beginning of the game,
 * you start with an empty record.
 * <p>
 * You are given a list of strings operations, where operations[i] is the ith operation you must apply to the record and
 * is one of the following:
 * <p>
 * An integer x. Record a new score of x. '+'. Record a new score that is the sum of the previous two scores. 'D'.
 * Record a new score that is the double of the previous score. 'C'. Invalidate the previous score, removing it from the
 * record. Return the sum of all the scores on the record after applying all the operations.
 * <p>
 * The test cases are generated such that the answer and all intermediate calculations fit in a 32-bit integer and that
 * all operations are valid.
 */

public class CalPoints {
    public int calPoints(String[] operations) {
        int[] stack = new int[1024];
        int pointer = 0;
        for (String operation : operations) {
            switch (operation) {
                case "+" -> {
                    stack[pointer] = stack[pointer - 1] + stack[pointer - 2];
                    pointer++;
                }
                case "D" -> {
                    stack[pointer] = stack[pointer - 1] * 2;
                    pointer++;
                }
                case "C" -> pointer--;
                default -> {
                    stack[pointer] = Integer.parseInt(operation);
                    pointer++;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < pointer; i++) {
            sum += stack[i];
        }
        return sum;
    }
}
