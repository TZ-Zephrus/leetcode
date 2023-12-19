package binary_tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class layerTraversal_NTree  {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> arrayDeque = new ArrayDeque<>();
        if (root == null){
            return result;
        }
        arrayDeque.add(root);
        while (!arrayDeque.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int len = arrayDeque.size();
            for (int i = 0; i < len; i++) {
                Node node = arrayDeque.poll();
                temp.add(node.val);
                if (!node.children.isEmpty()){
                    arrayDeque.addAll(node.children);
                }
            }
            result.add(temp);
        }
        return result;
    }
}
