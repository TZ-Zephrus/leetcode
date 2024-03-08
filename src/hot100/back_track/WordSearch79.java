package hot100.back_track;

/**
 * @author WangTianze
 * @description
 * @date 2024-03-08
 */
public class WordSearch79 {
    boolean[][] visited;
    StringBuilder sb;
    int[][] dir = {
            {1,0},
            {0,1},
            {-1,0},
            {0,-1}
    };
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    sb.append(board[i][j]);
                    if (dfs(board, word, 1, i, j)) {
                        return true;
                    }
                    sb.deleteCharAt(sb.length()-1);
                }
            }
        }
        return false;

    }
    public boolean dfs(char[][] board, String word, int wordIndex, int x, int y) {
        if (visited[x][y]) {
            return false;
        }
        if (sb.length() == word.length() && !sb.toString().equals(word)) {
            return false;
        }
        if (sb.toString().equals(word)) {
            return true;
        }
        visited[x][y] = true;
        for (int i = 0; i < dir.length; i++) {
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];
            if (nextX < 0 || nextX >= board.length || nextY < 0 || nextY >= board[0].length) {
                continue;
            }
            sb.append(board[nextX][nextY]);
            System.out.println(sb.toString());
            if (board[nextX][nextY] == word.charAt(wordIndex)) {
                if (dfs(board, word, wordIndex+1, nextX, nextY)) {
                    return true;
                }
            }
            sb.deleteCharAt(sb.length()-1);
        }
        visited[x][y] = false;
        return false;
    }
}
