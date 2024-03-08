package hot100.binary_tree;

/**
 * @author WangTianze
 * @description
 * @date 2024-03-05
 */
public class LowestAncestor236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = recursion(root, p, q);
        return node;
    }
    public TreeNode recursion(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = recursion(root.left, p, q);
        TreeNode right = recursion(root.right, p, q);
        if (left == null && right == null ) {
            return null;
        } else if (left != null && right == null) {
            return left;
        } else if (left == null && right != null) {
            return right;
        } else {
            return root;
        }
    }
}
