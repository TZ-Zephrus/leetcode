package binary_tree;

import java.util.*;

public class sharedParent236 {
    static ArrayList<ArrayList<TreeNode>> result = new ArrayList<>();
    static ArrayList<TreeNode> path = new ArrayList<>();
    public static void main(String[] args) {
        TreeNode node0 = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);

        node3.left = node5;
        node3.right = node1;
        node5.left = node6;
        node5.right = node2;
        node2.left = node7;
        node2.right = node4;
        node1.left = node0;
        node1.right = node8;
//        System.out.println(lowestCommonAncestor(node3, node5, node1));

    }

    //自己想的垃圾方法
    public static TreeNode lowestCommonAncestor0(TreeNode root, TreeNode p, TreeNode q) {
        path.add(root);
        recursion(root, p, q);
        ArrayList<TreeNode> list1 = result.get(0);
        ArrayList<TreeNode> list2 = result.get(1);
//        for (int i = list1.size()-1; i >= 0; i--) {
//            for (int j = list2.size()-1; j >= 0; j--) {
//                if (Objects.equals(list1.get(i), list2.get(j))) {
//                    return list1.get(i);
//                }
//            }
//        }
        return findCommonElement(list1,list2);
//        return null;
    }
    public static void recursion(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return;
        }
        if (node.val == p.val || node.val == q.val) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (node.left != null) {
            path.add(node.left);
            recursion(node.left, p, q);
            path.remove(path.size()-1);
        }
        if (node.right != null) {
            path.add(node.right);
            recursion(node.right, p, q);
            path.remove(path.size()-1);
        }
    }
    public static TreeNode findCommonElement(List<TreeNode> list1, List<TreeNode> list2) {
        // 将一个列表转换为集合
        Set<TreeNode> set = new HashSet<>(list1);

        for (int i = list2.size() - 1; i >= 0; i--) {
            if (set.contains(list2.get(i))) {
                return list2.get(i);
            }
        }
        return null; // 如果没有相同元素
    }

    //直接递归  后序
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {   //左右不为空，表示当前点就是公共祖先
            return root;
        } else if (left != null && right == null) {    //左空右不空，表示右子树找到了点，继续返回
            return left;
        } else if (left == null && right != null) {
            return right;
        } else {
            return null;
        }
    }
}
