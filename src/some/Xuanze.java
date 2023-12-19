package some;

import java.util.Arrays;

public class Xuanze {
    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 3, 1};
        arrange(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void arrange(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }
}
