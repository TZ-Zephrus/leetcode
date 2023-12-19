package some;

import java.util.Arrays;

public class Maopao {
    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 3, 1};
        bubble(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void bubble(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
