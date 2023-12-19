package binary_tree;

import java.util.Arrays;

public class constructInPost106 {
    public static void main(String[] args) {

    }

    //递归 每层都新建了数组 效率较低
    public TreeNode buildTree0(int[] inorder, int[] postorder) {
        if (postorder.length == 0) return null;
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        int index = 0;
        for (index = 0; index < inorder.length; index++) {
            if (inorder[index] == root.val) {   //此时index的索引对应的是切点
                break;
            }
        }
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, index);  //左闭右开
        int[] rightInorder = Arrays.copyOfRange(inorder, index+1, inorder.length);  //左闭右开
        int[] leftPostorder = Arrays.copyOfRange(postorder, 0, leftInorder.length);  //左闭右开
        int[] rightPostorder = Arrays.copyOfRange(postorder, leftInorder.length, postorder.length-1);  //左闭右开
        root.left = buildTree(leftInorder, leftPostorder);
        root.right = buildTree(rightInorder, rightPostorder);
        return root;
    }

    //递归 没有新建数组而是用索引代替，效率较高
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return recursion(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }
    public TreeNode recursion(int[] inorder, int inorderStart, int inorderEnd, int[] postorder, int postorderStart, int postorderEnd) {
        if (postorderEnd == postorderStart) return null;
        TreeNode root = new TreeNode(postorder[postorderEnd-1]);
        int index = inorderStart;
        for (index = inorderStart; index < inorderEnd; index++) {
            if (inorder[index] == root.val) {   //此时index的索引对应的是切点
                break;
            }
        }
        root.left = recursion(inorder, inorderStart, index, postorder, postorderStart, postorderStart+index-inorderStart);
        root.right = recursion(inorder, index+1, inorderEnd, postorder, postorderStart+index-inorderStart, postorderEnd-1);
        return root;
    }
}
