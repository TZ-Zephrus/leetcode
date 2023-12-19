package greedy;

import java.util.Arrays;

public class buLemon860 {
    public boolean lemonadeChange(int[] bills) {
        int[] arr = new int[3];
        Arrays.fill(arr, 0);
        for (int i = 0; i < bills.length; i++) {
            switch (bills[i]) {
                case 5 -> arr[0]++;
                case 10 -> {
                    arr[1]++;
                    arr[0]--;
                }
                case 20 -> {
                    arr[2]++;
                    if (arr[1] > 0) {
                        arr[1]--;
                        arr[0]--;
                    } else {
                        arr[0]--;
                        arr[0]--;
                        arr[0]--;
                    }
                }
            }
            if (arr[0] < 0) return false;
        }
        return true;

    }
}
