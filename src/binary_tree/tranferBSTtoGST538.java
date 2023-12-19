package binary_tree;

public class tranferBSTtoGST538 {
    int val = 0;
    public TreeNode convertBST(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            node.right = convertBST(node.right);
        }
        val = val + node.val;
        node.val = val;
        if (node.left != null) {
            node.left = convertBST(node.left);
        }
        return node;
    }
}
