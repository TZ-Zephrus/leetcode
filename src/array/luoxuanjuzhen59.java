package array;


import java.util.Arrays;

//给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
//
//
//
//
//        输入：n = 3
//        输出：[[1,2,3],[8,9,4],[7,6,5]]
//        示例 2：
//
//        输入：n = 1
//        输出：[[1]]
public class luoxuanjuzhen59 {
    public static void main(String[] args) {
        int n = 5;
        String[] arr = new String[n];
        for (int i = 0; i < n; i++){
            arr[i] = Arrays.toString(generateMatrix(n)[i]);
            System.out.println(arr[i]);
        }
        System.out.println(Arrays.toString(arr));
    }

    public static int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int num = 1;
        int i = 0;
        int j = 0;
        for (int round = 0; round < n/2; round++){
            //上
            i = round;
            for (j = round; j < (n-1)-round; j++){       //n-1表示总序号
                arr[i][j] = num;
                num++;
            }
            //右
            for (i = round; i < (n-1)-round; i++){       //n-1表示总序号
                arr[i][j] = num;
                num++;
            }
            //下
            for (j = (n-1)-round; j > round; j--){       //n-1表示每行的总序号
                arr[i][j] = num;
                num++;
            }
            //左
            for (i = (n-1)-round; i > round; i--){       //n-1表示总序号
                arr[i][j] = num;
                num++;
            }
        }
        if (n%2 != 0){
            arr[n/2][n/2] = num;
        }
        return arr;
    }
}
