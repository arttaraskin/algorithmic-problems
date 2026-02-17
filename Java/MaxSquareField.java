package com.task;

class MaxSquareField {
    public static void main(String[] args) {
        int[][] field = new int[][]{
            {0, 1, 1},
            {0, 1, 1},
            {1, 0, 1}};
        System.out.println(maxSquare(field));
    }

    public static int maxSquare(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        int maxLength = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    // If it's in the first row or first column, it can only form a 1x1 square
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        // If the current cell is 1, the side length of the square ending here
                        // is 1 plus the minimum of the side lengths of the squares ending at
                        // its top, left, and top-left diagonal neighbors.
                        int left = dp[i - 1][j];
                        int top = dp[i][j - 1];
                        int diagonal = dp[i - 1][j - 1];
                        dp[i][j] = 1 + Math.min(left, Math.min(top, diagonal));
                    }
                } else {
                    dp[i][j] = 0; // If the current cell is 0, no square can end here
                }
                maxLength = Math.max(maxLength, dp[i][j]);
            }
        }

        // The result is the area of the largest square, which is maxLength * maxLength
        return maxLength * maxLength;
    }
}
