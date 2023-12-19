package binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class layerTraversal_rightSight199 {
    public static void main(String[] args) {

    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        if (root == null) return result;
        que.add(root);
        while (!que.isEmpty()) {
            int len = que.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = que.poll();
                if (node.left != null) {
                    que.add(node.left);
                }
                if (node.right != null) {
                    que.add(node.right);
                }
                if (i == len-1) {
                    result.add(node.val);
                }
            }
        }
        return result;
    }
}
