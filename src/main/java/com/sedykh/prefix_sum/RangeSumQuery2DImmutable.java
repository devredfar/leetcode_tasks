package com.sedykh.prefix_sum;

/**
 * Given a 2D matrix, handle multiple queries of the following type:
 * <p>
 * Calculate the sum of the elements of matrix inside the rectangle
 * defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 * Implement the NumMatrix class:
 * <p>
 * NumMatrix(int[][] matrix) Initializes the object with the integer matrix matrix.
 * int sumRegion(int row1, int col1, int row2, int col2) Returns the sum of the
 * elements of matrix inside the rectangle defined by its upper
 * left corner (row1, col1) and lower right corner (row2, col2).
 * You must design an algorithm where sumRegion works on O(1) time complexity.
 */
public class RangeSumQuery2DImmutable {
    public static class NumMatrix {

        int[][] prefixSumArray;

        public NumMatrix(int[][] matrix) {
            prefixSumArray = new int[matrix.length + 1][matrix[0].length + 1];
            for (int i = 1; i < prefixSumArray.length; i++) {
                for (int j = 1; j < prefixSumArray[0].length; j++) {
                    prefixSumArray[i][j] =
                            prefixSumArray[i - 1][j]
                                    - prefixSumArray[i - 1][j - 1]
                                    + prefixSumArray[i][j - 1]
                                    + matrix[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int newRow2 = row2 + 1;
            int newCol2 = col2 + 1;
            if (row1 == 0 && col1 == 0) {
                return prefixSumArray[newRow2][newCol2];
            }
            return prefixSumArray[newRow2][newCol2]
                    - prefixSumArray[row1][newCol2]
                    - prefixSumArray[newRow2][col1]
                    + prefixSumArray[row1][col1];
        }
    }
}
