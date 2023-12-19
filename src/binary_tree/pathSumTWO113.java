package binary_tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class pathSumTWO113 {
    public static void main(String[] args) {

    }

    //递归
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list =new ArrayList<>();
        if (root == null) {
            return result;
        }
        recursion(root, targetSum, result, list, 0);
        return result;
    }

    public void recursion(TreeNode node, int targetSum, List<List<Integer>> result, List<Integer> list, int sum) {
        sum += node.val;
        list.add(node.val);                                //中
        if (node.left == null && node.right == null) {    //判断是否为叶子节点。
            if (sum == targetSum) {
                result.add(new ArrayList<>(list));
            } else {
                return;
            }
        }
        if (node.left != null) {
            recursion(node.left, targetSum, result, list, sum);   //左
            list.remove(list.size()-1);
        }
        if (node.right != null) {
            recursion(node.right, targetSum, result, list, sum);    //右
            list.remove(list.size()-1);
        }
    }

    //迭代
//    public List<List<Integer>> pathSum0(TreeNode root, int targetSum) {
//        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
//        ArrayDeque<Integer> sumList = new ArrayDeque<>();
//        if (root == null) {
//            return false;
//        }
//        arrayDeque.push(root);
//        sumList.push(root.val);
//        while (!arrayDeque.isEmpty()) {
//            TreeNode node = arrayDeque.pop();
//            Integer sum = sumList.pop();
//            if (node.left == null && node.right == null && sum == targetSum) {
//                return true;
//            }
//            if (node.left != null) {          //左
//                arrayDeque.push(node.left);
//                sumList.push(sum+node.left.val);
//            }
//            if (node.right != null) {          //右
//                arrayDeque.push(node.right);
//                sumList.push(sum+node.right.val);
//            }
//        }
//        return false;
//    }
}
