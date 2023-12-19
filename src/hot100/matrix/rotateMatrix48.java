package hot100.matrix;

public class rotateMatrix48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int i = 0;
        int j = 0;
        int p = 0; //用于辅助被替换的数组 的索引
        int k = 0;//辅助数组的索引

        for (int round = 0; round < n/2; round++) {
            int num = n-2*round-1;  //每次要交换的数量
            int[] arr = new int[num];  //辅助中介数组


            //这里的for循环里面的顺序，其实都可以直接替换成次数
            //上右换
            i = round;
            p = round;
            k = 0;
            for (j = round; j < n-round-1; j++) {
                arr[k] = matrix[p][n-round-1];
                matrix[p][n-round-1] = matrix[i][j];
                k++;
                p++;
            }
            //右下换
            p = n-round-1;
            k = 0;
            for (i = round; i < n-round-1; i++) {
                int temp = matrix[n-round-1][p];
                matrix[n-round-1][p] = arr[k];
                arr[k] = temp;
                k++;
                p--;
            }
            //下左换
            p = n-round-1;
            k = 0;
            for (j = n-round-1; j > round; j--) {
                int temp = matrix[p][round];
                matrix[p][round] = arr[k];
                arr[k] = temp;
                k++;
                p--;
            }
            //左上换
            p = round;
            k = 0;
            for (i = n-round-1; i > round; i--) {
                matrix[round][p] = arr[k];
                k++;
                p++;
            }
        }
    }
}
