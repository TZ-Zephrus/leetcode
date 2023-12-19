package hot100.matrix;

import java.util.ArrayList;
import java.util.List;

public class matrixToZero73 {
    public void setZeroes(int[][] matrix) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    list.add(new int[]{i, j});
                }
            }
        }
        for (int[] ints : list) {
            putZero(matrix, ints[0], ints[1]);
        }
    }

    private void putZero(int[][] matrix, int i, int j) {
        for (int k = 0; k < matrix[0].length; k++) {
            matrix[i][k] = 0;
        }
        for (int k = 0; k < matrix.length; k++) {
            matrix[k][j] = 0;
        }
    }
}
