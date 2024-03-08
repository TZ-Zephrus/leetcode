package hot100.binary_tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author WangTianze
 * @description
 * @date 2024-03-04
 */
public class KthSmallestInBST230 {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode curr = root;
        int count = 0;
        while (!deque.isEmpty() || curr != null) {
            if (curr != null) {
                deque.push(curr);
                curr = curr.left;
            } else {
                curr = deque.pop();
                count++;
                if (count == k) {
                    break;
                }
                curr = curr.right;
            }
        }
        return curr.val;
    }
}
