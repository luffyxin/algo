package com.dx.unionfind;

import java.util.Calendar;

public class UF130 {

    public static void main(String[] args) {

        char[][]  board= {{'x','x','x','x'},
                {'x','o','o','x'},
                {'x','x','o','x'},
                {'x','o','x','x'}

        };

        UF130 uf130 = new UF130();
        uf130.solve(board);
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                System.out.print(board[i][j] + " ");

            }
            System.out.println();
        }


    }

    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;


        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    if (i == 0 || j == 0 || i == row - 1 || j == col - 1) {
                        dfs(i, j, board);
                    }
                }
            }
        }

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }

            }
        }
    }

    private void dfs(int i, int j, char[][] board) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == 'X' || board[i][j] == '#') {
            return;
        }
        board[i][j] = '#';
        dfs(i+1,j,board);
        dfs(i-1,j,board);
        dfs(i,j-1,board);
        dfs(i,j+1,board);
    }


}
