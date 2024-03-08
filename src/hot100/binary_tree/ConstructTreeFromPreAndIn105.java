package hot100.binary_tree;

/**
 * @author WangTianze
 * @description
 * @date 2024-03-05
 */
public class ConstructTreeFromPreAndIn105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode node = recursion(preorder, 0, preorder.length, inorder, 0, inorder.length);
        return node;
    }
    // 前闭后开
    public TreeNode recursion(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart == preEnd) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[preStart]);
        int leftPreStart = preStart+1;
        int leftPreEnd = 0;
        int leftInStart = inStart;
        int leftInEnd = 0;
        int rightPreStart = 0;
        int rightPreEnd = preEnd;
        int rightInStart = 0;
        int rightInEnd = inEnd;
        // 用前序的中间节点来切中序
        for (int i = inStart; i < inEnd; i++) {
            if (node.val == inorder[i]) {
                leftInEnd = i;
                rightInStart = i+1;
                break;
            }
        }
        leftPreEnd = leftInEnd - leftInStart + leftPreStart;
        rightPreStart = leftPreEnd;
        TreeNode left = recursion(preorder, leftPreStart, leftPreEnd, inorder, leftInStart, leftInEnd);
        TreeNode right = recursion(preorder, rightPreStart, rightPreEnd, inorder, rightInStart, rightInEnd);
        node.left = left;
        node.right = right;
        return node;
    }
}
