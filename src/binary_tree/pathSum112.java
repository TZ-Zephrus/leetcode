package binary_tree;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class pathSum112 {
    boolean flag = false;
    public static void main(String[] args) {

    }

    //递归 前序
    public boolean hasPathSum0(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        recursion(root, targetSum, 0);
        return flag;
    }

    public void recursion0(TreeNode node, int targetSum, int sum) {
        if (flag) {
            return;
        }
        sum += node.val;                                  //中
        if (node.left == null && node.right == null) {    //判断是否为叶子节点。
            if (sum == targetSum) {
                flag = true;
                return;
            } else {
                return;
            }
        }
        if (node.left != null) recursion(node.left, targetSum, sum);    //左
        if (node.right != null) recursion(node.right, targetSum, sum);  //右
    }

    //递归 有返回值的写法
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return  recursion(root, targetSum, 0);
    }

    public boolean recursion(TreeNode node, int targetSum, int sum) {
        sum += node.val;                                  //中
        if (node.left == null && node.right == null) {    //判断是否为叶子节点。
            if (sum == targetSum) {
                return true;
            } else {
                return false;
            }
        }
        if (node.left != null) {
            if (recursion(node.left, targetSum, sum)) {
                return true;
            }    //左
        }
        if (node.right != null) {
            if (recursion(node.right, targetSum, sum)) {
                return true;
            }    //右边
        }
        return false;
    }

    //迭代
    public boolean hasPathSum1(TreeNode root, int targetSum) {
        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
        ArrayDeque<Integer> sumList = new ArrayDeque<>();
        if (root == null) {
            return false;
        }
        arrayDeque.push(root);
        sumList.push(root.val);
        while (!arrayDeque.isEmpty()) {
            TreeNode node = arrayDeque.pop();
            Integer sum = sumList.pop();
            if (node.left == null && node.right == null && sum == targetSum) {
                return true;
            }
            if (node.left != null) {          //左
                arrayDeque.push(node.left);
                sumList.push(sum+node.left.val);
            }
            if (node.right != null) {          //右
                arrayDeque.push(node.right);
                sumList.push(sum+node.right.val);
            }
        }
        return false;
    }
}
