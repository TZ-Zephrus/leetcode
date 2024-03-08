package hot100.binary_tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author WangTianze
 * @description
 * @date 2024-03-04
 */
public class ValidateBST98 {
    public boolean isValidBST(TreeNode root) {
        return recursion(root);
    }

    // 错误
    public boolean recursion(TreeNode node) {
        if (node == null) {
            return true;
        }
        if (node.left == null && node.right == null) {
            return true;
        }
        boolean left = recursion(node.left);
        boolean right = recursion(node.right);
        if (node.left == null) {
            return left & right & node.val < node.right.val;
        } else if (node.right == null) {
            return left & right & node.val > node.left.val;
        } else {
            return left & right & node.val < node.right.val & node.val > node.left.val;
        }
    }

    // 递归法
    TreeNode max = null;
    public boolean recursion1(TreeNode node) {
        if (node == null) {
            return true;
        }
        boolean left = recursion1(node.left);
        if (max != null && max.val >= node.val) {
            return false;
        }
        max = node;
        boolean right = recursion1(node.right);
        return left & right;
    }

    // 中序迭代
    public boolean isValidBST1(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode curr = root;
        TreeNode max = null;
        while (!deque.isEmpty() || curr != null) {
            if (curr != null) {
                deque.push(curr);               // 左
                curr = curr.left;
            } else {
                curr = deque.pop();
                if (max != null && curr.val <= max.val) {
                    return false;
                }
                max = curr;
                curr = curr.right;
            }
        }
        return true;
    }
}
