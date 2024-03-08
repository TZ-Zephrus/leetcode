package hot100.binary_tree;

/**
 * @author WangTianze
 * @description
 * @date 2024-03-01
 */
public class DiameterOfTree543 {
    int max;
    public int diameterOfBinaryTree(TreeNode root) {
        int rootVal = postRecursion(root);
        return max;
    }

    // 可以有两种表现形式，返回0的和返回-1的
    public int postRecursion(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = postRecursion(node.left);
        int right = postRecursion(node.right);
        int result = Math.max(left, right) + 1;
        if (left + right > max) {
            max = left + right;
        }
        return result;
    }
}
