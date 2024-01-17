package hot100.matrix;

public class searchMatrixTWO240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int column = matrix[0].length;
        int row = matrix.length;
        int i = 0;
        int j = column-1;
        int curr;
        while (i < row && j >= 0) {
            curr = matrix[i][j];
            if (curr == target) {
                return true;
            } else if (curr > target) {
                j--;
            } else if (curr < target) {
                i++;
            }
        }
        return false;
    }
}
