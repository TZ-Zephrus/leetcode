package binary_tree;

public class compeleteTreeNodeNum222 {
    int number = 0;
    public static void main(String[] args) {

    }

    public int countNodes(TreeNode root) {
        return postRecursion(root);
    }

    //递归法
    //后序
    public int postRecursion(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftNum = postRecursion(node.left);
        int rightNum = postRecursion(node.right);
        int num = leftNum + rightNum + 1;
        return num;
    }

    //前序
    public void preRecursion(TreeNode node) {
        if (node == null) {
            return;
        }
        number++;
        preRecursion(node.left);
        preRecursion(node.right);
    }


    //针对完全二叉树的递归方法
    //先判断其是不是完全二叉树，如果是就直接计算，如果不是则用之前的递归方法
    public static int postRecursionComplete(TreeNode node) {
        if (node == null) {
            return 0;
        }
        TreeNode left = node.left;
        TreeNode right = node.right;
        int leftdepth = 0;
        int rightdepth = 0;
        //判断是否为完全二叉树
        while (left != null) {
            leftdepth++;
            left = left.left;
        }
        while (right != null) {
            rightdepth++;
            right = right.right;
        }
        if (leftdepth == rightdepth) {
            return (int) Math.pow(2, leftdepth+1) - 1;
        }
        //常规的单层递归
        int leftNum = postRecursionComplete(node.left);
        int rightNum = postRecursionComplete(node.right);
        int num = leftNum + rightNum + 1;
        return num;
    }
}
