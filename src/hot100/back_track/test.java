package hot100.back_track;

/**
 * @author WangTianze
 * @description
 * @date 2024-03-08
 */
public class test {
    public static void main(String[] args) {
        WordSearch79 wordSearch79 = new WordSearch79();
        char[][] board = new char[][] {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        wordSearch79.exist(board, "ABCCED");
    }
}
