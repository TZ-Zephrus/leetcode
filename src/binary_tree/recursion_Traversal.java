package binary_tree;

import java.util.ArrayList;
import java.util.List;

public class recursion_Traversal {
    public static void main(String[] args) {

    }
    public List<Integer> Traversal(TreeNode root) {
        ArrayList<Integer> al = new ArrayList<>();
        preorder(root, al);
        inorder(root, al);
        postorder(root, al);
        return al;
    }


    public void preorder(TreeNode root, ArrayList<Integer> al) {
        if (root == null) {
            return;
        }
        al.add(root.val);
        preorder(root.left, al);
        preorder(root.right, al);
    }

    private void inorder(TreeNode root, ArrayList<Integer> al) {
        if (root == null) {
            return;
        }
        inorder(root.left, al);
        al.add(root.val);
        inorder(root.right, al);
    }

    private void postorder(TreeNode root, ArrayList<Integer> al) {
        if (root == null) {
            return;
        }
        postorder(root.left, al);
        postorder(root.right, al);
        al.add(root.val);
    }
}
