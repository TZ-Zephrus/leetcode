package hot100.binary_tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author WangTianze
 * @description
 * @date 2024-03-04
 */
public class TreeRightSight199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if (root == null) {
            return result;
        }
        TreeNode curr = root;
        deque.add(curr);
        int len = 0;
        while (!deque.isEmpty()) {
            len = deque.size();
            for (int i = 0; i < len; i++) {
                curr = deque.poll();
                if (i == len-1) {
                    result.add(curr.val);
                }
                if (curr.left != null) {
                    deque.add(curr.left);
                }
                if (curr.right != null) {
                    deque.add(curr.right);
                }
            }
        }
        return result;
    }
}
