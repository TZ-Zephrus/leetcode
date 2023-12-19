package binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class layerTraversal_MaxDepth104 {
    int max = 0;
    public static void main(String[] args) {

    }

    //层序遍历 迭代法
    public int maxDepth1(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        int depth = 0;
        if (root == null) return depth;
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
            depth++;
        }
        return depth;
    }


    //迭代法
    public int maxDepth(TreeNode root) {
        int depth = postRecursion(root);
        return depth;
    }

    public int postRecursion(TreeNode node) {  //后序
        //终止条件
        if (node == null) {
            return 0;
        }
        //确定单层递归的逻辑  分别判断左子树和右子树的高度  然后取较大的值
        int leftDepth = postRecursion(node.left);                 //左
        int rightDepth = postRecursion(node.right);               //右
        int depth = Math.max(leftDepth, rightDepth)+1;            //中
        return depth;
    }

    public void preRecursion(TreeNode node, int depth) {  //前序
        //终止条件
        if (node == null) {
            return;
        }
        depth++;
        max = Math.max(max, depth);
        preRecursion(node.left, depth);
        preRecursion(node.right, depth);
    }
}
