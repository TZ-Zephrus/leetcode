package binary_tree;

import java.util.*;

public class layerTraversal_Bottom107 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> arrayDeque = new ArrayDeque<>();
        if (root == null){
            return result;
        }
        arrayDeque.add(root);
        while (!arrayDeque.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int len = arrayDeque.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = arrayDeque.poll();
                temp.add(node.val);
                if (node.left != null) arrayDeque.add(node.left);
                if (node.right != null) arrayDeque.add(node.right);
            }
            result.add(temp);
        }
        Collections.reverse(result);
        return result;
    }
}
