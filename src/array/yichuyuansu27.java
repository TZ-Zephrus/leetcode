package array;


//给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
//
//不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
//
//元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

//示例 1：
//
//输入：nums = [3,2,2,3], val = 3
//输出：2, nums = [2,2]
//解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
//示例 2：
//
//输入：nums = [0,1,2,2,3,0,4,2], val = 2
//输出：5, nums = [0,1,4,0,3]
//解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。

public class yichuyuansu27 {
    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int val = 3;
//        System.out.println(removeElement(nums, val));
        System.out.println(removeElement2(nums, val));
        for (int i = 0; i < nums.length; i++) {
            if (i == 0){
                System.out.print("[");
            }
            if (i != nums.length-1) {
                System.out.print(nums[i] + ",");
            } else {
                System.out.println(nums[i] + "]");
            }
        }
    }

    public static int removeElement(int[] nums, int val){
        //核心：如果出现val，就和列表最后面的非val交换
        int number = 0;
        int mark = nums.length-1;
        for (int i = 0; i < nums.length-number; i++) {
            if (nums[i] == val){
                //这里j >= i, 等于号用的很巧妙。用了等于号，即使出现无法交换位置的情况（如后面全是val），也能把自身统计上（相当于自己和自己交换）
                for (int j = nums.length-1-number; j >= i; j--){
                    if (nums[j] != val) {
                        int tmp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = tmp;
                        number++;
                        break;
                    }
                    number++;
                }
            }
        }
        return nums.length-number;
    }

    public static int removeElement2(int[] nums, int val) {
        //快慢指针法：核心思想，两个指针一快一慢
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++){
            if(nums[fastIndex] != val){
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }

}
