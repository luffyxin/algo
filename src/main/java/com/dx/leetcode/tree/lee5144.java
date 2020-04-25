package com.dx.leetcode.tree;

public class lee5144 {

    public int[][] matrixBlockSum(int[][] mat, int K) {
        int answer[][] = new int[mat.length][mat[0].length];

        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[i].length; j++) {
                int sum = 0;
                for (int r = 0; r < mat.length; r++) {
                    for (int c = 0; c < mat[r].length; c++) {
                        boolean rtrue = i - K <= r && r <= i + K;
                        boolean ctrue = j - K <= c && c <= j + K;

                        if (rtrue && ctrue) {
                            sum += mat[r][c];
                        }

                    }
                }
                answer[i][j] = sum;

            }
        }

        return answer;
    }

}
