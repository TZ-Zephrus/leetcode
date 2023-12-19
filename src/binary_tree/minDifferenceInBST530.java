package binary_tree;

import java.util.ArrayDeque;

public class minDifferenceInBST530 {
    Integer result = null;
    TreeNode pre = null;
    public static void main(String[] args) {

    }

    //递归
    public int getMinimumDifference0(TreeNode root) {
        recursion(root);
        return result;
    }

    public void recursion(TreeNode node) {
        if (node == null) {
            return;
        }
        recursion(node.left);
        if (result != null && pre != null) {
            result = Math.min(result, node.val-pre.val);
        } else if (result == null && pre != null) {
            result = node.val - pre.val;
        }
        pre = node;
        recursion(node.right);
    }

    //迭代
    public int getMinimumDifference(TreeNode root) {
        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
        TreeNode node = root;
        while (!arrayDeque.isEmpty() || node != null) {
            if (node != null) {
                arrayDeque.push(node);
                node = node.left;
            } else {
                node = arrayDeque.pop();
                if (result != null && pre != null) {
                    result = Math.min(result, node.val-pre.val);
                } else if (result == null && pre != null) {
                    result = node.val - pre.val;
                }
                pre = node;
                node = node.right;
            }
        }
        return result;
    }
}
