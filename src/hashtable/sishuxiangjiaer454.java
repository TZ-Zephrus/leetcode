package hashtable;


//给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
//
//0 <= i, j, k, l < n
//nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
//
//
//示例 1：
//
//输入：nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
//输出：2
//解释：
//两个元组如下：
//1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
//2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
//示例 2：
//
//输入：nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
//输出：1

import java.util.HashMap;

public class sishuxiangjiaer454 {
    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {-2,-1};
        int[] nums3 = {-1,2};
        int[] nums4 = {0,2};
        System.out.println(fourSumCount(nums1,nums2,nums3,nums4));
    }

    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;  //用于记录次数
        HashMap<Integer, Integer> hm1 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (hm1.containsKey(nums1[i]+nums2[j])) {
                    int value = hm1.get(nums1[i]+nums2[j]);
                    hm1.put(nums1[i]+nums2[j], value+1);
                } else {
                    hm1.put(nums1[i]+nums2[j], 1);
                }
            }
        }
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                if (hm1.containsKey(-(nums3[i]+nums4[j]))) {
                    count = count + hm1.get(-(nums3[i]+nums4[j]));
                }
            }
        }
        return count;
    }
}
