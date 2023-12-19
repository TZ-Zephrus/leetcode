package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class mergeInterval56 {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (o1, o2) -> o1[0]-o2[0]);
        int startRange = intervals[0][0];
        int maxRange = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= maxRange) {
                maxRange = Math.max(maxRange, intervals[i][1]);
            } else {
                result.add(new int[]{startRange, maxRange});
                startRange = intervals[i][0];
                maxRange = intervals[i][1];
            }
        }
        result.add(new int[]{startRange, maxRange});
        return result.toArray(new int[result.size()][]);
    }
}
