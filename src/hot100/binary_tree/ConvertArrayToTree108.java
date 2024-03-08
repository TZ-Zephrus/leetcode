package hot100.binary_tree;

/**
 * @author WangTianze
 * @description
 * @date 2024-03-04
 */
public class ConvertArrayToTree108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return recursion(nums, 0, nums.length-1);
    }
    public TreeNode recursion(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (end-start)/2 + start;
        TreeNode node = new TreeNode(nums[mid]);
        TreeNode left = recursion(nums, start, mid-1);
        TreeNode right = recursion(nums, mid+1, end);
        node.left = left;
        node.right = right;
        return node;
    }
}
