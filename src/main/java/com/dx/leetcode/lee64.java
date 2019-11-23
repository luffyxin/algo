package com.dx.leetcode;

public class lee64 {
    public static int minPathSum(int[][] grid) {
        int [][] temp =   new int[grid.length][grid[0].length];
        return dp(grid.length-1, grid[0].length-1, grid, temp);
    }

    private static   int dp(int i,int j,int[][] grid,int[][] temp) {

            if(temp[i][j] != 0){
                return temp[i][j];
            }

            if (i == 0 && j == 0) {
                temp[i][j] = grid[i][j];
            } else if (i == 0) {

                temp[i][j] = dp(i, j - 1, grid,temp) + grid[i][j];
            } else if (j == 0) {
                temp[i][j] = dp(i - 1, j, grid,temp) + grid[i][j];
            } else {
                temp[i][j] = Math.min(dp(i - 1, j, grid,temp), dp(i, j - 1, grid,temp)) + grid[i][j];
            }
            return temp[i][j];

    }

    public static void main(String[] args) {

        int arr[][] = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        int i = minPathSum(arr);
        System.out.println(i);

    }



}
