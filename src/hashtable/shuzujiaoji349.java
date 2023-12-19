package hashtable;


//给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
//
//
//
//示例 1：
//
//输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
//示例 2：
//
//输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4]
//解释：[4,9] 也是可通过的


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class shuzujiaoji349 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] result = intersection(nums1,nums2);
        System.out.println(Arrays.toString(intersection(nums1,nums2)));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hs = new HashSet<>();
        HashSet<Integer> reshs = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            hs.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (hs.contains(nums2[i])) {
                reshs.add(nums2[i]);
            }
        }
        int[] result = new int[reshs.size()];
        int j = 0;
        for (Integer resh : reshs) {
            result[j] = resh;
            j++;
        }
        return result;
    }
}
