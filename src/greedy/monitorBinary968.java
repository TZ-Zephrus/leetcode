package greedy;

public class monitorBinary968 {
    int num = 0;
    public int minCameraCover(TreeNode root) {
        //无覆盖：0
        //有摄像头：1
        //有覆盖：2
        int value = postRecursion(root);
        if (value == 0) {
            num++;
        }
        return num;
    }

    private int postRecursion(TreeNode root) {
        if (root == null) {
            return 2;
        }
        int left = postRecursion(root.left);
        int right = postRecursion(root.right);
        if (left == 0 || right == 0) {
            num++;
            return 1;
        } else if (left == 2 && right == 2) {
            return 0;
        } else {
            return 2;
        }
    }


}
