package binary_tree;

import jdk.swing.interop.DispatcherWrapper;

import java.util.LinkedList;
import java.util.Queue;

public class constructBBST108 {
    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        TreeNode node = sortedArrayToBST(nums);
        System.out.println(node);
    }

    //递归
    public static TreeNode sortedArrayToBST0(int[] nums) {
        return recursion(nums, 0, nums.length);
    }
    public static TreeNode recursion(int[] nums, int start, int end) {
        if (end == start) {
            return null;
        }
        int middleIndex = (int) (end - start)/2+start;
        TreeNode node = new TreeNode(nums[middleIndex]);
        node.left = recursion(nums, start, middleIndex);
        node.right = recursion(nums, middleIndex+1, end);
        return node;
    }


    //迭代法
    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        TreeNode root = new TreeNode();
        int left = 0;
        int right = nums.length;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> leftQueue = new LinkedList<>();
        Queue<Integer> rightQueue = new LinkedList<>();
        nodeQueue.add(root);
        leftQueue.add(left);
        rightQueue.add(right);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int leftIndex = leftQueue.poll();
            int rightIndex = rightQueue.poll();
            int middleIndex = leftIndex + (rightIndex-leftIndex)/2;
            node.val = nums[middleIndex];
            if (leftIndex < middleIndex) {
                TreeNode leftNode = new TreeNode();
                node.left = leftNode;
                nodeQueue.add(leftNode);
                leftQueue.add(leftIndex);
                rightQueue.add(middleIndex);
            }
            if (rightIndex > middleIndex) {
                TreeNode rightNode = new TreeNode();
                node.right = rightNode;
                nodeQueue.add(rightNode);
                leftQueue.add(middleIndex+1);
                rightQueue.add(rightIndex);
            }
        }
        return root;
    }
}
