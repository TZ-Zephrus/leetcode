package binary_tree;

import java.util.Arrays;

public class constructMaxTree654 {
    public static void main(String[] args) {

    }

    //递归法 新建了数组，效率较低
    public TreeNode constructMaximumBinaryTree0(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        int maxValue = nums[0];
        int maxIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
                maxIndex = i;
            }
        }
        int[] newLeft = Arrays.copyOfRange(nums, 0, maxIndex);
        int[] newRight = Arrays.copyOfRange(nums, maxIndex+1, nums.length);
        TreeNode node = new TreeNode(maxValue);
        node.left = constructMaximumBinaryTree0(newLeft);
        node.right = constructMaximumBinaryTree0(newRight);
        return node;
    }

    //递归法 不新建数组
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return recursion(nums, 0, nums.length);
    }

    public TreeNode recursion(int nums[], int leftIndex, int rightIndex) {
        if (leftIndex == rightIndex) {
            return null;
        }
        int maxValue = nums[leftIndex];
        int maxIndex = leftIndex;
        for (int i = leftIndex+1; i < rightIndex; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
                maxIndex = i;
            }
        }
        int leftStart = leftIndex;
        int leftEnd = maxIndex;
        int rightStart = maxIndex + 1;
        int rightEnd = rightIndex;
        TreeNode node = new TreeNode(maxValue);
        node.left = recursion(nums, leftStart, leftEnd);
        node.right = recursion(nums, rightStart, rightEnd);
        return node;
    }
}
