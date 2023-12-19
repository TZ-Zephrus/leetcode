package binary_tree;

import java.util.*;

public class nTreeMaxDepth599 {
    public static void main(String[] args) {

    }

    //迭代法
    public int maxDepth1(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> que = new LinkedList<>();
        que.add(root);
        int len = 0;
        int depth = 0;
        while (!que.isEmpty()) {
            len = que.size();
            depth++;
            for (int i = 0; i < len; i++) {
                Node temp = que.poll();
                if (!temp.children.isEmpty()) {
                    que.addAll(temp.children);
                }
            }
        }
        return depth;
    }

    //递归法
    public int maxDepth(Node root) {
        return recursion(root);
    }

    public int recursion (Node node) {
        if (node == null) {
            return 0;
        }
        int depth = 0;
        if (!node.children.isEmpty()) {
            for (Node child : node.children) {
                depth = Math.max(depth, recursion(child));
            }
        }
        depth++;
        return depth;
    }
}
