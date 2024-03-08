package hot100.binary_tree;

import javax.lang.model.util.Elements;

/**
 * @author WangTianze
 * @description
 * @date 2024-03-05
 */
public class FlattenTreeToList114 {
    public void flatten(TreeNode root) {
        recursion(root);
    }
    TreeNode curr;
    public TreeNode recursion(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode left = recursion(node.left);
        TreeNode right = recursion(node.right);
        curr = left;
        if (curr == null) {
            return node;
        } else {
            while (curr.right != null) {
                curr = curr.right;
            }
            curr.right = right;
            node.right = left;
            node.left = null;
            return node;
        }
    }

    // 更简洁的方法
    // 反前序，每次处理最后一个节点
    TreeNode preNode;
    public void recursion2(TreeNode node) {
        if (node == null) {
            return;
        }
        recursion2(node.right);
        recursion2(node.left);
        node.left = null;
        node.right = preNode;
        preNode = node;
    }
}
