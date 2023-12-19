package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class nQueen51 {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] chars : board) {
            Arrays.fill(chars, '.');
        }
        backtrack(n, 0, board);
        return result;
    }

    public void backtrack(int n, int row, char[][] board) {
        if (row == n) {
            result.add(array2list(board));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!isValid(i, row, board, n)) continue;
            board[row][i] = 'Q';
            backtrack(n, row+1, board);
            board[row][i] = '.';
        }
    }

    private List<String> array2list(char[][] board) {
        List<String> path = new ArrayList<>();
        for (char[] chars : board) {
            path.add(String.copyValueOf(chars));
        }
        return path;
    }

    private boolean isValid(int col, int row, char[][] board, int n) {
        //判断纵向
        for (int i = row; i >= 0; i--) {
            if ('Q' == board[i][col]) {
                return false;
            }
        }

        //判断135度
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if ('Q' == board[i][j]) {
                return false;
            }
        }

        //判断45度
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if ('Q' == board[i][j]) {
                return false;
            }
        }

        return true;
    }
}
