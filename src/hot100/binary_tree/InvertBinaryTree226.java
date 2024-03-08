package hot100.binary_tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author WangTianze
 * @description
 * @date 2024-02-29
 */
public class InvertBinaryTree226 {

    // 层序遍历 对于每个节点都交换其左右节点
    public TreeNode invertTree(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        if (root == null) {
            return root;
        }
        deque.add(root);
        while (!deque.isEmpty()) {
            int len = deque.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = deque.poll();

                // 在这里交换左右节点
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;

                if (node.left != null) {
                    deque.add(node.left);
                }
                if (node.right != null) {
                    deque.add(node.right);
                }
            }
        }
        return root;
    }

    // 递归法 前序
    public TreeNode invertTree2(TreeNode root) {
        preRecursion(root);
        return root;
    }
    public void preRecursion(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        preRecursion(node.left);
        preRecursion(node.right);
    }

    // 迭代法 前序
    public TreeNode invertTree3(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        if (root == null) {
            return root;
        }
        deque.push(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.pop();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.right != null) {
                deque.push(node.right);
            }
            if (node.left != null) {
                deque.push(node.left);
            }
        }
        return root;
    }
}
