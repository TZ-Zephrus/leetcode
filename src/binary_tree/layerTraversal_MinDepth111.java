package binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class layerTraversal_MinDepth111 {
    int min = -1;
    public static void main(String[] args) {

    }

    public int minDepth1(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        int depth = 0;
        if (root == null) return depth;
        que.add(root);
        while (!que.isEmpty()) {
            int len = que.size();
            depth++;
            for (int i = 0; i < len; i++) {
                TreeNode node = que.poll();
                if (node.left == null && node.right == null) return depth;   //这里直接返回最小深度即可
                if (node.left != null) que.add(node.left);
                if (node.right != null) que.add(node.right);
            }
        }
        return depth;
    }


    //递归法
    public int minDepth2(TreeNode root) {
        return postRecursion(root);
    }
    //后序
    public int postRecursion(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = postRecursion(node.left);      //左
        int rightDepth = postRecursion(node.right);    //右

        //左空
        if (node.left == null && node.right != null) {  //中
            return rightDepth + 1;
        }
        //右空
        if (node.left != null && node.right == null) {
            return leftDepth + 1;
        }
        //左右空
        int depth = Math.min(leftDepth,rightDepth) + 1;
        return depth;
    }


    //前序
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        preRecursion(root, 0);
        return min;
    }

    public void preRecursion(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        depth++;             //中
        if (node.left == null && node.right == null) {
            if (min == -1) {
                min = depth;
            } else {
                min = Math.min(min, depth);
            }
        }
        preRecursion(node.left, depth);     //左
        preRecursion(node.right, depth);    //右
    }
}

