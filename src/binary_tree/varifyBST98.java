package binary_tree;

import java.util.ArrayDeque;
import java.util.Stack;

public class varifyBST98 {
    TreeNode max = null;
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
//        System.out.println(isValidBST(node1));
    }

    //递归 不对 理解错题目意思了
    public static boolean isValidBST0(TreeNode root) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return true;
        if (root.left != null && root.right == null) {
            if (!(root.left.val < root.val)) {
                return false;
            } else {
                return isValidBST0(root.left);
            }
        } else if (root.left == null && root.right != null) {
            if (!(root.right.val > root.val)) {
                return false;
            } else {
                return isValidBST0(root.right);
            }
        } else {
            return root.left.val < root.val & root.right.val > root.val & isValidBST0(root.right) & isValidBST0(root.left);
        }
    }

    //递归  使用中序
    public boolean isValidBST1(TreeNode root) {
        if (root == null) return true;
        boolean left = isValidBST1(root.left);    //左
        if (max != null && max.val >= root.val) {
            return false;
        }
        max = root;
        boolean right = isValidBST1(root.right);  //右
        return left & right;
    }

    //迭代 中序
    public boolean isValidBST(TreeNode root) {
        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
        TreeNode node = root;
        TreeNode max = null;
        while (node != null || !arrayDeque.isEmpty()) {
            if (node != null) {
                arrayDeque.push(node);
                node = node.left;
            } else {
                node = arrayDeque.pop();
                if (max != null && max.val >= node.val) {
                    return false;
                }
                max = node;
                node = node.right;
            }
        }
        return true;
    }
}
