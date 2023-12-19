package binary_tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class modeInBST501 {
    int currTimes = 0;
    int maxTimes = 0;
    TreeNode pre = null;
    ArrayList<Integer> result = new ArrayList<>();
    public static void main(String[] args) {

    }

    //递归法
    public int[] findMode0(TreeNode root) {
        recursion(root);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public void recursion(TreeNode node) {
        if (node == null) return;
        recursion(node.left);
        if (pre == null) {
            currTimes = 1;
        } else if (pre.val == node.val) {
            currTimes++;
        } else {
            currTimes = 1;
        }
        if (currTimes == maxTimes) {
            result.add(node.val);
        } else if (currTimes > maxTimes) {
            result.clear();
            maxTimes = currTimes;
            result.add(node.val);
        }
        pre = node;
        recursion(node.right);
    }

    //迭代法
    public int[] findMode(TreeNode root) {
        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
        TreeNode node = root;
        while (!arrayDeque.isEmpty() || node != null) {
            if (node != null) {
                arrayDeque.push(node);
                node = node.left;
            } else {
                node = arrayDeque.pop();
                if (pre == null) {
                    currTimes = 1;
                } else if (pre.val == node.val) {
                    currTimes++;
                } else {
                    currTimes = 1;
                }
                if (currTimes == maxTimes) {
                    result.add(node.val);
                } else if (currTimes > maxTimes) {
                    result.clear();
                    maxTimes = currTimes;
                    result.add(node.val);
                }
                pre = node;
                node = node.right;
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
