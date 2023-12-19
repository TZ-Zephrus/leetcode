package binary_tree;

public class insertBST701 {
    public static void main(String[] args) {

    }

    //递归
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            TreeNode node = new TreeNode(val);
            return node;
        }
        if (root.val > val) root.left = insertIntoBST(root.left,val);
        if (root.val < val) root.right = insertIntoBST(root.right,val);
        return root;
    }

    //迭代
    public TreeNode insertIntoBST0(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        TreeNode node = root;
        TreeNode pre = null;
        while (node != null) {
            pre = node;
            if (node.val > val) {
                node = node.left;
                continue;
            }
            if (node.val < val) {
                node = node.right;
                continue;
            }
        }
        if (pre.val > val) {
            pre.left = new TreeNode(val);
        } else if (pre.val < val) {
            pre.right = new TreeNode(val);
        }
        return root;
    }
}
