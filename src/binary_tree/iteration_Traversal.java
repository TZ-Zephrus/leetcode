package binary_tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class iteration_Traversal {
    public static void main(String[] args) {

    }

    public List<Integer> Traversal(TreeNode root) {
        ArrayList<Integer> al = new ArrayList<>();
        //注意这里！空节点null不能入栈
        if (root == null) {
            return al;
        }
        preorder(root, al);
        return al;
    }


    public void preorder(TreeNode root, ArrayList<Integer> al) {
        ArrayDeque<TreeNode> ad = new ArrayDeque<>();
        ad.push(root);
        while (!ad.isEmpty()) {
            TreeNode node = ad.pop();
            al.add(node.val);
            if (node.right != null) {
                ad.push(node.right);
            }
            if (node.left != null) {
                ad.push(node.left);
            }
        }
    }




    private void inorder(TreeNode root, ArrayList<Integer> al) {
        ArrayDeque<TreeNode> ad = new ArrayDeque<>();
        TreeNode curr = root;
        while (!ad.isEmpty() || curr != null) {
            //指针curr一直往左边走，把走过的元素入栈
            if (curr != null) {
                ad.push(curr);
                curr = curr.left;
            //当curr为空时，弹出，并往右走；
            } else {
                curr = ad.pop();
                al.add(curr.val);
                curr = curr.right;
            }
        }
    }

        private void postorder(TreeNode root, ArrayList<Integer> al) {
            ArrayDeque<TreeNode> ad = new ArrayDeque<>();
            ad.push(root);
            while (!ad.isEmpty()) {
                TreeNode node = ad.pop();
                al.add(node.val);
                if (node.left != null) {
                    ad.push(node.right);
                }
                if (node.right != null) {
                    ad.push(node.left);
                }
            }
            Collections.reverse(al);
        }
}
