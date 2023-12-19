package binary_tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class layerTraversal_RightNode116 {
    public static void main(String[] args) {

    }

    public Node116 connect(Node116 root) {
        List<Integer> result = new ArrayList<>();
        Queue<Node116> arrayDeque = new ArrayDeque<>();
        if (root == null){
            return root;
        }
        arrayDeque.add(root);
        while (!arrayDeque.isEmpty()) {
            int len = arrayDeque.size();
            for (int i = 0; i < len; i++) {
                Node116 node = arrayDeque.poll();
                if (node.left != null) arrayDeque.add(node.left);
                if (node.right != null) arrayDeque.add(node.right);
                if (i != len-1) {
                    node.next = arrayDeque.peek();
                } else {
                    node.next = null;
                }
            }
        }
        return root;
    }
}
