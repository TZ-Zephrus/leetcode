package binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class symmetry_tree101 {
    public static void main(String[] args) {

    }

    public static boolean isSymmetric(TreeNode root) {
        return recursion(root.left, root.right);
    }

    public static boolean recursion(TreeNode left, TreeNode right) {
        //给出停止条件
        if (left == null && right == null) {
            return true;
        } else if (left != null && right == null) {
            return false;
        } else if (left == null && right != null) {
            return false;
        } else if (left.val != right.val){    //先进行了空判断，最后这里才进行数值的比较
            return false;
        }

        //进行判断
        //判断外侧
        boolean outside = recursion(left.left, right.right);
        //判断内侧
        boolean inside = recursion(left.right, right.left);
        boolean isSame = outside & inside;
        return isSame;
    }


    public static boolean iteration(TreeNode root) {
        if (root == null) {
            return true;
        }
        //链表可以添加null
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null) {
                continue;
            } else if ((left == null && right != null) || (left != null && right == null) || (left.val != right.val)) {
                return false;
            }
            queue.add(left.left);    //添加外侧
            queue.add(right.right);
            queue.add(left.right);   //添加内测
            queue.add(right.left);
        }
        return true;
    }
}
