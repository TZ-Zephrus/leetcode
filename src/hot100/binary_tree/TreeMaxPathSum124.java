package hot100.binary_tree;

/**
 * @author WangTianze
 * @description
 * @date 2024-03-06
 */
public class TreeMaxPathSum124 {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        recursion(root);
        return max;
    }
    public int recursion(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = recursion(node.left);
        int right = recursion(node.right);
        int currMax = Math.max(left+node.val, Math.max(right+ node.val, Math.max(left+right+node.val, node.val)));
        if (currMax > max) {
            max = currMax;
        }
        return Math.max(left+node.val, Math.max(right+node.val, node.val));
    }
}
