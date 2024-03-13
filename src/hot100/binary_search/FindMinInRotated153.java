package hot100.binary_search;

/**
 * @author WangTianze
 * @description
 * @date 2024-03-11
 */
public class FindMinInRotated153 {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int mid = (left+right)/2;
        int min = 0;
        while (left < right) {
            mid = (left+right)/2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return mid;
    }
}
