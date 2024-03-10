package hot100.binary_search;

public class SearchRotatedArray33 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        int mid = (left + right)/2;
        int index = -1;
        while (left < right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                index = mid;
                break;
                // 左边是否为有序数组
            } else if (nums[0] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right - 1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }
        return index;
    }
}
