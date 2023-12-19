package binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class finLeftDown513 {
    static int maxDepth = 0;
    static int result;
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;
        node5.left = node7;
        findBottomLeftValue(node1);
        System.out.println(result);
    }

    //层序遍历
    public int findBottomLeftValue1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int result = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                if (i == 0) {
                    result = node.val;   //存储每一层最左边的值，每次迭代替换
                }
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return result;
    }

    //递归法
    public static int findBottomLeftValue(TreeNode root) {
        recursion(root, 1);
        return result;
    }

    //自己的递归
    public static void recursion(TreeNode node, int depth) {   //因为要先往左下角走，所以用中序后序都可以
        if (node == null) {
            return;
        }
        if (depth > maxDepth) { //这里depth大于maxDepth说明是第一次探索到这个深度。而我们一直是有限遍历左子节点，因此此时探索到的就是该层最左边的顶点
            maxDepth = depth;
            result = node.val;
        }
        //单层逻辑
        depth++;
        recursion(node.left, depth);
        depth--;

        depth++;
        recursion(node.right, depth);
        depth--;
        return;
    }
}
