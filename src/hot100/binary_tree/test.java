package hot100.binary_tree;

/**
 * @author WangTianze
 * @description
 * @date 2024-03-05
 */
public class test {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        TreeMaxPathSum124 treeMaxPathSum124 = new TreeMaxPathSum124();
        treeMaxPathSum124.maxPathSum(node1);
    }
}
