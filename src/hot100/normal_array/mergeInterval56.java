package hot100.normal_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class mergeInterval56 {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, ((o1, o2) -> o1[0] - o2[0]));
        int maxLen = intervals[0][1];
        int start = intervals[0][0];
        for (int i = 1; i < intervals.length; i++) {
            if (maxLen < intervals[i][0]) {
                result.add(new int[]{start, maxLen});
                start = intervals[i][0];
                maxLen = intervals[i][1];
            }
            maxLen = Math.max(maxLen, intervals[i][1]);
        }
        return result.toArray(new int[result.size()][2]);
    }
}
