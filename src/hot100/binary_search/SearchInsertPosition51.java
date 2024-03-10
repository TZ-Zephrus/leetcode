package hot100.binary_search;

public class SearchInsertPosition51 {
    public int searchInsert(int[] nums, int target) {
        // 二分查找
        return binarySearch(nums, target);
    }
    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        int mid = (right-left)/2 + left;
        int index = 0;
        while (left < right) {
            if (target == nums[mid]) {
                index = mid;
                break;
            } else if (target < nums[mid]) {
                 right = mid;
                 mid = (right-left)/2 + left;
             } else {
                 left = mid+1;
                 mid = (right-left)/2 + left;
             }
        }
        if (nums[index] == target) {
            return index;
        } else {
            index = left;
            return index;
        }
    }
}
