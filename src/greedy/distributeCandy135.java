package greedy;

import java.util.Arrays;

public class distributeCandy135 {
    public int candy(int[] ratings) {
        if (ratings.length == 0) return 0;
        int[] candy = new int[ratings.length];
        candy[0] = 1;
        //从前向后
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            } else {
                candy[i] = 1;
            }
        }
        //从后向前
        for (int i = ratings.length-2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candy[i] = Math.max(candy[i + 1] + 1, candy[i]);
            }
        }
        int ans = 0;
        for (int num : candy) {
            ans += num;
        }
        return ans;
    }


    //有错误
    public int candy0(int[] ratings) {
        if (ratings.length == 0) return 0;
        int[] candy = new int[ratings.length];
        candy[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i-1]) {
                candy[i] = candy[i-1] + 1;
            }else if (ratings[i] < ratings[i-1]) {
                candy[i] = candy[i-1] - 1;
            }else {
                candy[i] = candy[i-1];
            }
        }
        int minValue = Arrays.stream(candy).min().getAsInt();
        int[] array = Arrays.stream(candy).map(num -> num - (minValue - 1)).toArray();
        System.out.println(Arrays.toString(array));
        return Arrays.stream(array).sum();
    }
}
