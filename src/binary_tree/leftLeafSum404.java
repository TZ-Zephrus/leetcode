package binary_tree;

import java.util.ArrayDeque;

public class leftLeafSum404 {
    int sum = 0;
    public static void main(String[] args) {

    }

    //递归法
    public int sumOfLeftLeaves(TreeNode root) {
        recursion(root);
        return sum;
    }

    public void recursion(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null && node.left.left == null && node.left.right == null) {
            sum += node.left.val;
        }
        recursion(node.left);
        recursion(node.right);
    }


    //迭代法
    public int sumOfLeftLeaves2(TreeNode root) {
        //用中序来迭代遍历
        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
        TreeNode curr = root;
        while (curr != null || !arrayDeque.isEmpty()) {
            if (curr != null && curr.left != null && curr.left.left == null && curr.left.right == null) {
                sum += curr.left.val;
            }
            if (curr != null) {
                arrayDeque.push(curr);
                curr = curr.left;
            } else {
                curr = arrayDeque.pop();
                curr = curr.right;
            }
        }
        return sum;
    }
}
