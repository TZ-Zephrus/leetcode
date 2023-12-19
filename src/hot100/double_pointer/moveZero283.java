package hot100.double_pointer;

public class moveZero283 {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length && j < nums.length; i++) {
            while (j < nums.length-1 && nums[j] == 0) {
                j++;
            }
            if (nums[i] == 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
            j++;
        }
    }
}
