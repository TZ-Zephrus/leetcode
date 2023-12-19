package binary_tree;

import java.util.ArrayDeque;

public class combineTree617 {
    public static void main(String[] args) {

    }

    //递归 新建了一棵树
    public TreeNode mergeTrees0(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return null;
        TreeNode node = new TreeNode();
        if (root1 != null && root2 != null) {
            node.val = root1.val+root2.val;
            node.left = mergeTrees0(root1.left, root2.left);
            node.right = mergeTrees0(root1.right, root2.right);
        }
        if (root1 != null && root2 == null) {
            node.val = root1.val;
            node.left = mergeTrees0(root1.left, null);
            node.right = mergeTrees0(root1.right, null);
        }
        if (root1 == null && root2 != null) {
            node.val = root2.val;
            node.left = mergeTrees0(null, root2.left);
            node.right = mergeTrees0(null, root2.right);
        }
        return node;
    }

    //递归 不新建树
    public TreeNode mergeTrees1(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        root1.val += root2.val;
        root1.left = mergeTrees1(root1.left,root2.left);
        root1.right = mergeTrees1(root1.right,root2.right);
        return root1;
    }

    //迭代 最好别新建树
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
        arrayDeque.push(root2);
        arrayDeque.push(root1);
        while (!arrayDeque.isEmpty()) {
            TreeNode node1 = arrayDeque.poll();
            TreeNode node2 = arrayDeque.poll();
            node1.val += node2.val;
            if (node1.left != null && node2.left != null) {
                arrayDeque.push(node2.left);
                arrayDeque.push(node1.left);
            } else if (node1.left == null) {     //只考虑node1.left == null的情况。node2.left若为零，就不考虑了
                node1.left = node2.left;
            }
            if (node1.right != null && node2.right != null) {
                arrayDeque.push(node2.right);
                arrayDeque.push(node1.right);
            } else if (node1.right == null) {
                node1.right = node2.right;
            }
        }
        return root1;
    }
}
