package com.dx.leetcode;

import java.util.ArrayList;
import java.util.List;

public class lee120 {

    public static int minimumTotal(List<List<Integer>> triangle) {
        int dp[][] = new int[triangle.size()][triangle.size()];
        dp[0][0] =triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size() ; j++) {
                if(j==0){
                    dp[i][j] = dp[i-1][j] + triangle.get(i).get(j);
                }
                else if(j== triangle.get(i).size() - 1){
                    dp[i][j] = dp[i-1][j-1] + triangle.get(i).get(j);
                }
                else {
                    dp[i][j] = Math.min(dp[i-1][j-1],dp[i-1][j]) + triangle.get(i).get(j);
                }
            }
        }
        int min = dp[triangle.size()-1][0];

        for (int i = 1; i < dp.length; i++) {
            if(dp[triangle.size()-1][i] < min){
                min = dp[triangle.size()-1][i];
            }
        }

        return min;
    }

    /**
     * 自底向上dp
     *  错误：我一开始从上到底遍历，用一维数组记录，导致前面的记录被抹除
     *  正解：自底向上dp
     * @param triangle
     * @return
     */
    public int minimumTotal2(List<List<Integer>> triangle) {
        int row = triangle.size();
        int[] minlen = new int[row+1];
        for (int level = row-1;level>=0;level--){
            for (int i = 0;i<=level;i++){   //第i行有i+1个数字
                minlen[i] = Math.min(minlen[i], minlen[i+1]) + triangle.get(level).get(i);
            }
        }

        return minlen[0];
    }


}
