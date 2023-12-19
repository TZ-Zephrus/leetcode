package backtrack;

import java.util.ArrayList;
import java.util.List;

public class solveSudoku37 {
    public void solveSudoku(char[][] board) {
        List<Integer[]> space = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    space.add(new Integer[]{i, j});
                }
            }
        }
        backtrack(board, space, 0);
    }

    private boolean backtrack(char[][] board, List<Integer[]> space, int n) {
        if (n == space.size()) {
            return true;
        }
        Integer[] curr = space.get(n);
        for (int i = 1; i <= 9; i++) {
            if (!isValid(board, curr, i)) continue;
            board[curr[0]][curr[1]] = (char) (i + '0');
            if (backtrack(board, space, n+1)) {
                return true;
            }
            board[curr[0]][curr[1]] = '.';
        }
        return false;
    }

    private boolean isValid(char[][] board, Integer[] curr, int number) {
        int row = curr[0];
        int col = curr[1];
        //判断横向
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == (char) (number + '0')) return false;
        }
        //判断纵向
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == (char) (number + '0')) return false;
        }
        //判断3x3
        int rowStart = (row)/3 *3;
        int colStart = (col)/3 *3;
        for (int i = rowStart; i < rowStart+3; i++) {
            for (int j = colStart; j < colStart+3; j++) {
                if (board[i][j] == (char) (number + '0')) return false;
            }
        }
        return true;
    }
}
