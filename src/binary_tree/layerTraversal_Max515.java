package binary_tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class layerTraversal_Max515 {
    public static void main(String[] args) {

    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> arrayDeque = new ArrayDeque<>();
        if (root == null){
            return result;
        }
        arrayDeque.add(root);
        while (!arrayDeque.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int len = arrayDeque.size();
            int max = arrayDeque.peek().val;   //这里要注意max初始值的设定
            for (int i = 0; i < len; i++) {
                TreeNode node = arrayDeque.poll();
                if (node.val > max) max = node.val;
                if (node.left != null) arrayDeque.add(node.left);
                if (node.right != null) arrayDeque.add(node.right);
            }
            result.add(max);
        }
        return result;
    }
}
