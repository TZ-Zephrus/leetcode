package hot100.matrix;

import java.util.ArrayList;
import java.util.List;

public class luoxuanjuzhen54 {
    //充分考虑了mn不等的情况
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        int min = Math.min(row, column);
        int i = 0;
        int j = 0;
        List<Integer> result = new ArrayList<>();
        for (int round = 0; round < min/2; round++) {
            //上
            i = round;
            for (j = round; j < column-1 -round; j++) {
                result.add(matrix[i][j]);
            }
            //右
            for (i = round; i < row-1 - round; i++) {
                result.add(matrix[i][j]);
            }
            //下
            for (j = column-1 - round; j > round; j--) {
                result.add(matrix[i][j]);
            }
            //左
            for (i = row-1 - round; i > round; i--) {
                result.add(matrix[i][j]);
            }
        }
        if (min % 2 != 0) {
//            result.add(matrix[])
            if (row > column) {
                for (int k = min / 2; k <= row -1 -min/2; k++) {
                    result.add(matrix[k][column/2]);
                }
            } else {
                for (int k = min/2; k <= column -1 -min/2; k++) {
                    result.add(matrix[row/2][k]);
                }
            }
        }
        return result;
    }
}
