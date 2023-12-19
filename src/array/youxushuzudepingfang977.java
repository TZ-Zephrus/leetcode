package array;


import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

//给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
//
//
//
//示例 1：
//
//输入：nums = [-4,-1,0,3,10]
//输出：[0,1,9,16,100]
//解释：平方后，数组变为 [16,1,0,9,100]
//排序后，数组变为 [0,1,9,16,100]
//示例 2：
//
//输入：nums = [-7,-3,2,3,11]
//输出：[4,9,9,49,121]
public class youxushuzudepingfang977 {
    public static void main(String[] args) {
        int[] nums = {-7,-3,2,3,11};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }


    //双指针法
    public static int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int[] result = new int[nums.length];
        int index = result.length-1;
        while (left <= right) {
            if (nums[left] * nums[left] >= nums[right] * nums[right]){
                result[index] = nums[left] * nums[left];
                left++;
                index--;
            } else {
                result[index] = nums[right] * nums[right];
                right--;
                index--;
            }
        }
        return result;
    }



    //暴力法，先平方后排序
    public static int[] sortedSquares2(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        //bubbleSort(nums);
        quickSort(nums, 0, nums.length-1);
        return nums;
    }
    
    public static void bubbleSort(int[] nums) {
        int tmp = 0;
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = 0; j < nums.length-i-1; j++) {
                if (nums[j] > nums[j+1]){
                    tmp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
    }

    public static void quickSort(int[] nums, int i, int j) {
        int start = i;
        int end = j;

        if (start > end){
            return;
        }
        //这里basenum要放到return的下面，否则有可能会导致start索引越界
        int basenum = nums[start];
        while (true) {
            if (start == end) {
                break;
            }
            //注意 这里要限制不能让end小于start
            while (true) {
                if ((nums[end] < basenum) || (end <= start)) {
                    break;
                }
                end--;
            }
            //注意 这里要限制不能让start大于end, 其实主要是限制这个
            while (true) {
                if (nums[start] > basenum || (end <= start)) {
                    break;
                }
                start++;
            }
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
        }

        int temp = nums[i];
        nums[i] = nums[start];
        nums[start] = temp;

        quickSort(nums, i, start-1);
        quickSort(nums, start+1, j);
    }
}
