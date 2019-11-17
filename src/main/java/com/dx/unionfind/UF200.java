package com.dx.unionfind;


public class UF200 {
    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'},

        };

        int i = numIslands(grid);
        System.out.println(i);


    }

    public static int numIslands(char[][] grid) {

        if(grid.length == 0){
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    bfs(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }

    private static void bfs(int i, int j, char[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        bfs(i + 1, j, grid);
        bfs(i, j + 1, grid);
        bfs(i - 1, j, grid);
        bfs(i, j - 1, grid);
    }


}
