package binary_tree;

import java.util.*;

public class layerTraversal102 {


    public static void main(String[] args) {

    }

    //BFS 用队列实现
    public List<List<Integer>> levelOrder(TreeNode root) {
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
        return result;
    }

    //DFS 用递归实现
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfsTraversal(result, root, 0);
        return result;
    }

    public void dfsTraversal(List<List<Integer>> result, TreeNode node, int deep) {
        if (node == null) {
            return;
        }
        deep++;
        if (result.size() < deep) {
            List<Integer> list = new ArrayList<>();
            result.add(list);
        }
        result.get(deep - 1).add(node.val);
        dfsTraversal(result, node.left, deep);
        dfsTraversal(result, node.right, deep);
    }
}
