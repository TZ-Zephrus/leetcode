package binary_tree;

public class balanceTree110 {
    boolean flag = true;
    public static void main(String[] args) {

    }

    public boolean isBalanced(TreeNode root) {
        postRecursion(root);
        return flag;
    }

    public int postRecursion(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (!flag) {
            return 0;
        }
        int leftDepth = postRecursion(node.left);
        int rightDepth = postRecursion(node.right);
        int depth = Math.max(leftDepth, rightDepth) + 1;
        if (Math.abs(leftDepth - rightDepth) > 1) {
            flag = false;
        }
        return depth;
    }
}
