package dynamic_programming;

import java.util.HashMap;
import java.util.HashSet;

public class robTHREE337 {

    //递归  带记忆化方法
    HashMap<TreeNode, Integer> hashMap = new HashMap<>();
    public int rob0(TreeNode root) {
        int result = recursion0(root);
        return result;
    }

    private int recursion0(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (hashMap.containsKey(node)) {
            return hashMap.get(node);
        }
        int left = recursion0(node.left);
        int right = recursion0(node.right);
        int leftleft = 0;
        int rightright = 0;
        if (node.left != null) {
            leftleft = recursion0(node.left.left) + recursion0(node.left.right);
        }
        if (node.right != null) {
            rightright = recursion0(node.right.left) + recursion0(node.right.right);
        }
        //偷该节点
        int val1 = node.val + leftleft + rightright;
        //不偷该节点
        int val2 = left + right;
        //返回当前节点偷与不偷的最大值
        //先记忆化保存
        int value = Math.max(val1, val2);
        hashMap.put(node, value);
        return value;
    }


    public int rob(TreeNode root) {
        int[] result = recursion(root);
        return Math.max(result[0], result[1]);
    }

    private int[] recursion(TreeNode node) {
        //每一个节点都有一个二维dp数组，下标0表示不偷当前节点的最大值，下标1表示偷当前节点的最大值
        int[] dp = new int[2];
        if (node == null) {
            return dp;
        }
        //偷当前节点，那么当前层的值为 当前节点值+不偷左右子节点的最大值
        int[] left = recursion(node.left);
        int[] right = recursion(node.right);
        int value1 = node.val + left[0] + right[0];
        dp[1] = value1;
        //不偷当前节点

        int value2 = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        dp[0] = value2;
        return dp;
    }
}
