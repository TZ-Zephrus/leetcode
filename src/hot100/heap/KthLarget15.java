package hot100.heap;

import java.util.Arrays;

/**
 * @author WangTianze
 * @description
 * @date 2024-03-13
 */
public class KthLarget15 {
    // 堆排序
    public int findKthLargest(int[] nums, int k) {
        int[] buckets = new int[20001];
        for (int i = 0; i < nums.length; i++) {
            buckets[nums[i] + 10000]++;
        }
        for (int i = 20000; i >= 0; i--) {
            k = k - buckets[i];
            if (k <= 0) {
                return i - 10000;
            }
        }
        return 0;
    }

    // 快速排序
    int val = 0;
    boolean flag = false;
    public int findKthLargest2(int[] nums, int k) {
        quickSort(nums, 0, nums.length, k);
        System.out.println(Arrays.toString(nums));
        return 0;
    }
    // 遵循前闭后开
    public boolean quickSort(int[] nums, int start, int end, int k) {
        if (start >= end) {
            return false;
        }
        int base = nums[start];
        int left = start;
        int right = end - 1;
        while (left < right) {
            while (right > left && nums[right] >= base) {
                right--;
            }
            while (right > left && nums[left] <= base) {
                left++;
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        int temp = nums[start];
        nums[start] = nums[left];
        nums[left] = temp;
        if (left == nums.length-k) {
            val = nums[left];
            return true;
        }
        boolean leftB = quickSort(nums, start, left, k);
        boolean rightB = quickSort(nums, left + 1, end, k);
        return leftB | rightB;
    }

    // 快速排序改进版，只递归一半
    public int findKthLargest3(int[] nums, int k) {
        quickSort2(nums, 0, nums.length, k);
        System.out.println(Arrays.toString(nums));
        return 0;
    }
    // 遵循前闭后开
    public int quickSort2(int[] nums, int start, int end, int k) {
        if (start == nums.length-k) {
            return nums[start];
        }
        int base = nums[start];
        int left = start;
        int right = end - 1;
        while (left < right) {
            while (right > left && nums[right] >= base) {
                right--;
            }
            while (right > left && nums[left] <= base) {
                left++;
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        int temp = nums[start];
        nums[start] = nums[left];
        nums[left] = temp;
        if (left < nums.length-k) {
            return quickSort2(nums, left + 1, end, k);
        } else {
            return quickSort2(nums, start, left, k);
        }
    }
}
