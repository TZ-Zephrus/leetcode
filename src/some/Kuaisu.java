package some;

import java.util.Arrays;

public class Kuaisu {
    public static void main(String[] args) {
        int[] arr = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        arrange(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void arrange(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int i = start;
        int j = end;
        int basic = arr[i];
        while (true) {
            if (start == end) break;

            while (true) {
                if (arr[end] < basic || start >= end) {
                    break;
                }
                end--;
            }

            while (true) {
                if (arr[start] > basic || start >= end) {
                    break;
                }
                start++;
            }

            //把end和start指向的元素进行交换
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }

        int temp = arr[i];
        arr[i] = arr[start];
        arr[start] = temp;

        arrange(arr,i,start - 1);
        arrange(arr,start + 1,j);
    }

}
