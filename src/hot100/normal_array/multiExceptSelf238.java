package hot100.normal_array;

public class multiExceptSelf238 {
    public int[] productExceptSelf(int[] nums) {
        int[] leftMulti = new int[nums.length];
        int[] rightMulti = new int[nums.length];
        int[] result = new int[nums.length];
        leftMulti[0] = 1;
        rightMulti[nums.length-1] = 1;
        for (int i = 1; i < nums.length; i++) {
            leftMulti[i] = leftMulti[i-1] * nums[i-1];
        }
        for (int i = nums.length-2; i >= 0; i--) {
            rightMulti[i] = rightMulti[i+1] * nums[i+1];
        }
        for (int i = 0; i < nums.length; i++) {
            result[i] = leftMulti[i] * rightMulti[i];
        }
        return result;
    }
}
