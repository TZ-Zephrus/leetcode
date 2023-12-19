package binary_tree;

public class searchBST700 {
    public static void main(String[] args) {

    }

    //递归
    public TreeNode searchBST0(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        TreeNode node = null;
        if (root.val < val) {
            node = searchBST0(root.right, val);
        }
        if (root.val > val) {
            node = searchBST0(root.left, val);
        }
        return node;
    }

    //迭代
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode node = root;
        while (true) {
            if (node == null) return null;
            if (node.val == val) return node;
            if (node.val < val) {
                node = node.right;
                continue;
            }
            if (node.val > val) {
                node = node.left;
                continue;
            }
        }
    }
}
