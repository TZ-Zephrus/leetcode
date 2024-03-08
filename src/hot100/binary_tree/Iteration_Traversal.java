package hot100.binary_tree;

import java.util.*;

/**
 * @author WangTianze
 * @description
 * @date 2024-02-28
 */
public class Iteration_Traversal {

    // 迭代法

    // 前序
    public List<Integer> preorderTraversal(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        TreeNode curr = root;
        deque.push(curr);
        while (!deque.isEmpty()) {
            TreeNode node = deque.pop();
            list.add(node.val);
            if (node.right != null) {
                deque.push(node.right);
            }
            if (node.left != null) {
                deque.push(node.left);
            }
        }
        return list;
    }

    // 中序
    public List<Integer> inorderTraversal(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        TreeNode curr = root;
        while (curr != null || !deque.isEmpty()) {
            if (curr != null) {
                deque.push(curr);
                curr = curr.left;
            } else {
                curr = deque.pop();
                curr = curr.right;
                list.add(curr.val);    // 左
            }
        }
        return list;
    }

    // 后序
    public List<Integer> postorderTraversal(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        TreeNode curr = root;
        deque.push(curr);
        while (deque != null) {
            TreeNode node = deque.pop();
            list.add(node.val);
            if (node.left != null) {
                deque.push(node.left);
            }
            if (node.right != null) {
                deque.push(node.right);
            }
        }
        Collections.reverse(list);
        return list;
    }
}
