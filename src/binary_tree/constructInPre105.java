package binary_tree;

import java.util.Arrays;

public class constructInPre105 {
    public static void main(String[] args) {

    }

    //递归 每层都新建了数组 效率较低
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        int index = 0;
        for (index = 0; index < inorder.length; index++) {
            if (inorder[index] == root.val) {   //此时index的索引对应的是切点
                break;
            }
        }
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, index);  //左闭右开
        int[] rightInorder = Arrays.copyOfRange(inorder, index+1, inorder.length);  //左闭右开
        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, leftInorder.length);  //左闭右开
        int[] rightPreorder = Arrays.copyOfRange(preorder, leftInorder.length, preorder.length-1);  //左闭右开
        root.left = buildTree(leftPreorder, leftInorder);
        root.right = buildTree(rightPreorder, rightInorder);
        return root;
    }
}
