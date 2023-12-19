package hashtable;


//给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
//
//0 <= a, b, c, d < n
//a、b、c 和 d 互不相同
//nums[a] + nums[b] + nums[c] + nums[d] == target
//你可以按 任意顺序 返回答案 。
//
//
//
//示例 1：
//
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
//示例 2：
//
//输入：nums = [2,2,2,2,2], target = 8
//输出：[[2,2,2,2]]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class sishuzhihe18 {
    public static void main(String[] args) {
        int[] nums = {0,0,0,0};
        int target = 1;
        System.out.println(fourSum(nums,target));
    }



    //双指针
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int j = 0; j < nums.length; j++) {
            //剪枝
            if (nums[j] > target && nums[j] > 0) {
                return result;
            }
            //对j去重
            if (j > 0 && nums[j] == nums[j - 1]) {
                continue;
            }
            for (int i = j+1; i < nums.length; i++) {
                //对i去重
                if (i > j+1 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    if (nums[j] + nums[i] + nums[left] + nums[right] == target) {
                        result.add(Arrays.asList(nums[j], nums[i], nums[left], nums[right]));
                        //对left和right去重
                        while (right > left && nums[left] == nums[left + 1]) {   //这里记得要加上right > left!不然会导致索引越界异常
                            left++;
                        }
                        while (right > left && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (nums[j] + nums[i] + nums[left] + nums[right] > target) {
                        right--;
                    } else if (nums[j] + nums[i] + nums[left] + nums[right] < target) {
                        left++;
                    }

                }
            }
        }
        return result;
    }
}
