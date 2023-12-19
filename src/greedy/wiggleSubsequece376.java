package greedy;

import java.beans.PropertyEditorSupport;

public class wiggleSubsequece376 {
    //代码随想录 波峰波谷
    public int wiggleMaxLength0(int[] nums) {
        if (nums == null) return 0;
        if (nums.length < 2) return nums.length;
        //当前差值
        int curDiff = 0;
        //上一个差值
        int preDiff = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            curDiff = nums[i] - nums[i-1];
            if ((preDiff <= 0 && curDiff > 0) || (preDiff >=0 && curDiff < 0)) {
                count++;
                preDiff = curDiff;
            }
        }
        return count;
    }

    //别的方法
    public int wiggleMaxLength(int[] nums) {
        if (nums == null) return 0;
        if (nums.length < 2) return nums.length;
        Boolean isUp = null;
        int result = 1; //从1开始 代表着第一个数字纳入统计
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) continue;
            if (nums[i] - nums[i-1] > 0) {
                if (isUp != null && isUp) {
                    continue;
                }
                isUp = true;
            } else {
                if (isUp != null && !isUp) {
                    continue;
                }
                isUp = false;
            }
            result++;
        }
        return result;
    }
}
