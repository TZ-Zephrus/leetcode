package hot100.binary_tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author WangTianze
 * @description
 * @date 2024-03-05
 */
public class PathSumTHREE437 {
    long target;
    int result;
    public int pathSum(TreeNode root, int targetSum) {
        target = targetSum;
        dfs1(root);
        return result;
    }
    // 每次以dfs1中的node为开头
    public void dfs1(TreeNode node) {
        if (node == null) {
            return;
        }
        int val = 0;
        dfs2(node, val);
        dfs1(node.left);
        dfs1(node.right);
    }
    public void dfs2(TreeNode node, int val) {
        if (node == null) {
            return;
        }
        if (node.val + val == target) {
            result++;
        }
        dfs2(node.left, node.val + val);
        dfs2(node.right, node.val + val);
    }


    // 树遍历+前缀和
    Map<Long, Integer> map = new HashMap<>();
    public int pathSum2(TreeNode root, int targetSum) {
        target = targetSum;
        long val = 0L;
        map.put(0L, 1);
        dfs3(root, val);
        return result;
    }
    public void dfs3(TreeNode node, long val) {
        if (node == null) {
            return;
        }

        if (map.containsKey(node.val+val - target)) {
            result = result + map.get(node.val+val - target);
        }
        map.put(node.val + val, map.getOrDefault(node.val + val, 0)+1);
        dfs3(node.left, node.val+val);
        dfs3(node.right, node.val+val);
        // 这里需要回溯，免得混淆左路和右路
        map.put(node.val + val, map.getOrDefault(node.val + val, 0)-1);
    }
}
