package hot100.binary_search;

public class FindPosition34 {
    // 整两次二分查找
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        int mid = (left+right)/2;
        int first = -1;
        int last = -1;

        // 找第一个
        while (left < right) {
            mid = (left+right)/2;
            if (nums[mid] == target) {
                first = mid;
                right = mid;
            } else if (nums[mid] < target) {
                left = mid+1;
            } else {
                right = mid;
            }
        }

        // 找最后一个
        left = 0;
        right = nums.length-1;
        mid = (left+right)/2;
        while (left < right) {
            mid = (left+right)/2;
            if (nums[mid] == target) {
                last = mid;
                left = mid+1;
            } else if (nums[mid] < target) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return new int[]{first, last};
    }
}
