package binary_tree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class reverse_tree226 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        System.out.println(invertTree(node1).toString());
    }
    public static TreeNode invertTree(TreeNode root) {
//        recursionFindNode(root);
//        iterationFindNode(root);
        layerFindNode(root);
        return root;


    }

    //递归法
    public static void recursionFindNode(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode temp = node.left;    //中
        node.left =node.right;
        node.right = temp;
        recursionFindNode(node.left);          //左
        recursionFindNode(node.right);         //右
    }

    //迭代法 前序
    public static void iterationFindNode(TreeNode root) {
        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
        if (root == null) {
            return;
        }
        arrayDeque.push(root);
        while (!arrayDeque.isEmpty()) {
            TreeNode node = arrayDeque.pop();
            TreeNode temp = node.left;             //中
            node.left = node.right;
            node.right = temp;
            if (node.left != null) arrayDeque.push(node.left);       //左
            if (node.right != null) arrayDeque.push(node.right);     //右
        }
    }

    //层序遍历
    public static void layerFindNode(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        if (root == null) {
            return;
        }
        Integer len = 0;
        que.add(root);
        while (!que.isEmpty()) {
            len = que.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = que.poll();
                TreeNode temp = node.left;                    //中
                node.left = node.right;
                node.right = temp;
                if (node.left != null) que.add(node.left);       //左
                if (node.right != null) que.add(node.right);     //右
            }
        }
    }
}
