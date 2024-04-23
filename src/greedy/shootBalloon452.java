package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class shootBalloon452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] > o2[0]) {
                    return 1;
                } else if (o1[0] < o2[0]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        int count = 1;  //用来射爆第一个气球
        int minRange = points[0][1];   //从第一个气球开始计算边界
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > minRange) {
                count++;
                minRange = points[i][1];
            } else {
                minRange = Math.min(minRange, points[i][1]);
            }
        }
        return count;

    }

    public int findMinArrowShots2(int[][] points) {
        Arrays.sort(points, (o1,o2)->o1[0]-o2[0]);
        int min = points[0][1];
        int num = 0;
        for(int i = 1; i < points.length; i++) {
            if (points[i][0] > min) {
                min = points[i][1];
                num++;
            } else {
                if (points[i][1] < min) {
                    min = points[i][1];
                }
            }
        }
        num++;
        return num;
    }
}
