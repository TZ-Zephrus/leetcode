package binary_tree;

public class deleteBST450 {
    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node6 = new TreeNode(6);
        TreeNode node5 = new TreeNode(5);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        node4.right = node7;
        node7.left = node6;
        node6.left = node5;
        node7.right = node8;
        node8.right = node9;
        deleteNode0(node4, 7);
        System.out.println(node4);
    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            //没找到
            return null;
        }
        //找到时
        if (root.val == key) {
            //情况1 左右都为空
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left != null && root.right == null) {   //情况2 左不为空
                return root.left;
            } else if (root.left == null && root.right != null) {   //情况3 右不为空
                return root.right;
            } else {                 //情况4 左右均不为空
                TreeNode pre = null;
                TreeNode node = root.right;
                while (node != null) {
                    pre = node;
                    node = node.left;
                }
                pre.left = root.left;
                return root.right;
            }
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    public static TreeNode deleteNode0(TreeNode root, int key) {
       if (root == null) return null;
       TreeNode node = root;
       TreeNode pre = null;
       while (node != null) {
           if (node.val == key) {
               //情况1 左右都为空
               if (node.left == null && node.right == null) {
                    if (pre == null) {
                        return null;
                    } else {
                        if (pre.left != null && pre.left.val == key) {
                            pre.left = null;
                            return root;
                        } else if (pre.right != null && pre.right.val == key) {
                            pre.right = null;
                            return root;
                        }
                    }
               } else if (node.left != null && node.right == null) {   //情况2 左不为空
                   if (pre == null) {
                       return node.left;
                   } else {
                       if (pre.left != null && pre.left.val == key) {
                           pre.left = node.left;
                           return root;
                       } else if (pre.right != null && pre.right.val == key) {
                           pre.right = node.left;
                           return root;
                       }
                   }
               } else if (node.left == null && node.right != null) {   //情况3 右不为空
                   if (pre == null) {
                       return node.right;
                   } else {
                       if (pre.left != null && pre.left.val == key) {
                           pre.left = node.right;
                           return root;
                       } else if (pre.right != null && pre.right.val == key) {
                           pre.right = node.right;
                           return root;
                       }
                   }
               } else {                 //情况4 左右均不为空
                   if (pre == null) {
                       TreeNode curr = node.right;
                       while (curr.left != null) {
                           curr = curr.left;
                       }
                       curr.left = node.left;
                       return root.right;
                   } else {
                       TreeNode curr = node.right;
                       while (curr.left != null) {
                           curr = curr.left;
                       }
                       curr.left = node.left;
                       if (pre.left != null && pre.left.val == key) {
                           pre.left = node.right;
                           return root;
                       } else if (pre.right != null && pre.right.val == key) {
                           pre.right = node.right;
                           return root;
                       }
                   }
               }
           }
           pre = node;
           if (node.val > key) {node = node.left; continue;}
           if (node.val < key) {node = node.right; continue;}
       }
       return root;
    }
}
