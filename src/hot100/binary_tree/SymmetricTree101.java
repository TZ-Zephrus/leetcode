package hot100.binary_tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author WangTianze
 * @description
 * @date 2024-03-01
 */
public class SymmetricTree101 {
    // 递归 只能后序
    public boolean isSymmetric(TreeNode root) {
        boolean result = postRecursion(root.left, root.right);
        return result;
    }
    public boolean postRecursion(TreeNode left, TreeNode right) {
        if ((left == null && right != null) || (left != null && right == null)) {
            return false;
        }
        if (left == null && right == null) {
            return true;
        }
        boolean inside = postRecursion(left.right, right.left);
        boolean outside = postRecursion(left.left, right.right);
        boolean result = inside & outside & (left.val == right.val);
        return result;
    }

    // 迭代法 模拟递归
    public boolean isSymmetric2(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        if ((root.left != null && root.right == null) || (root.left == null && root.right != null)) {
            return false;
        }
        deque.push(root.left);
        deque.push(root.right);
        // 这里用栈，而栈不能存null，就会搞得很麻烦。
        while (!deque.isEmpty()) {
            TreeNode right = deque.pop();
            TreeNode left = deque.pop();
            if ((left.left == null && right.right != null) || (left.left != null && right.right == null)
            || (left.right == null && right.left != null) || left.right != null && right.left == null
            || (left.val != right.val)) {
                return false;
            }
            if (left.left != null && right.right != null) {
                deque.push(left.left);
                deque.push(right.right);
            }
            if (left.right != null && right.left != null) {
                deque.push(left.right);
                deque.push(right.left);
            }
        }
        return true;
    }
}
