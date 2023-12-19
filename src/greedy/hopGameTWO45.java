package greedy;

public class hopGameTWO45 {
    public int jump(int[] nums) {
        int result = 0;
        int currCover = 0;
        int nextCover = 0;
        for (int i = 0; i <= currCover && i < nums.length; i++) {
            nextCover = Math.max(nextCover, nums[i] + i);
            if (i == nums.length-1) {
                return result;
            }
            if (i == currCover) {
                result++;
                currCover = nextCover;
            }
        }
        //如果返回-1了 说明走不到终点
        return -1;
    }
}
