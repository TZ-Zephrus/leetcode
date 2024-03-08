package hot100.binary_tree;

/**
 * @author WangTianze
 * @description
 * @date 2024-02-29
 */
public class MaximumDepth104 {
    public int maxDepth(TreeNode root) {
        int result = postRecursion(root);
        return result;
    }

    // 后序
    public int postRecursion(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = postRecursion(root.left);
        int right = postRecursion(root.right);
        int depth = Math.max(left, right) + 1;
        return depth;
    }

    // 前序 用两个全局变量；
    int maxDepth;
    int depth;
    public void preRecursion(TreeNode root) {
        if (root == null) {
            return;
        }
        depth++;
        if (depth > maxDepth) {
            maxDepth = depth;
        }
        preRecursion(root.left);
        preRecursion(root.right);
        depth--;
    }

}
