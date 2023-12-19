package binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class layerTraversal_Avg637 {
    public static void main(String[] args) {

    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        if (root == null) return result;
        que.add(root);
        while (!que.isEmpty()) {
            int len = que.size();
            double sum = 0;
            for (int i = 0; i < len; i++) {
                TreeNode node = que.poll();
                if (node.left != null) que.add(node.left);
                if (node.right != null) que.add(node.right);
                sum += node.val;
            }
            result.add(sum/len);
        }
        return result;
    }
}
