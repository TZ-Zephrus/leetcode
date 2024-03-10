package hot100.back_track;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens51 {
    List<List<String>> result = new ArrayList<>();
    char[][] board;
    public List<List<String>> solveNQueens(int n) {
        board = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(board[i], '.');
        }
        backtrack(n, 0);
        return result;
    }
    public void backtrack(int n, int row) {
        if (row == n) {
            result.add(array2List());
            return;
        }
        for (int i = 0; i < n; i++) {
            board[row][i] = 'Q';
            if (isValid(n, row, i)) {
                backtrack(n, row+1);
            }
            board[row][i] = '.';
        }
    }

    public List<String> array2List() {
        List<String> path = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            path.add(String.valueOf(board[i]));
        }
        return path;
    }

    private boolean isValid(int n, int x, int y) {
        // 纵向
        for (int i = 0; i < x; i++) {
            if (board[i][y] == 'Q') {
                return false;
            }
        }

        // 45度
        for (int i = x-1, j = y+1; i >= 0 && j < board[0].length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // 135度
        for (int i = x-1, j = y-1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
}
