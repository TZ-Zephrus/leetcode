package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class nonOverlapping435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, ((o1, o2) -> o1[0] - o2[0]));
        int minRange = intervals[0][1];
        int num = 1;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < minRange) {
                minRange = Math.min(minRange, intervals[i][1]);
            } else {
                num++;
                minRange = intervals[i][1];
            }
        }
        //此时num为，有多少组重叠区间。而每组区间减去重叠段之后只会剩下不与任何段重叠的一条段
        return intervals.length - num;
    }

}
