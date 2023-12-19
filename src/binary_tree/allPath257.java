package binary_tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class allPath257 {
    public static void main(String[] args) {

    }


    //递归法
    public List<String> binaryTreePaths(TreeNode root) {
        //用于记录结果
        List<String> result = new ArrayList<>();
        //用于存放路径
        ArrayList<Integer> path = new ArrayList<>();
        if (root == null) {
            return result;
        }
        postRecursion(root, result, path);
        return result;
    }

    public void postRecursion(TreeNode node, List<String> result, ArrayList<Integer> path) {
        path.add(node.val);         //中
        //这里不用常用的if(node == null)判断，因为我们想要在判断出node是叶子节点后，就将其走过的路径保存起来。
        if (node.left == null && node.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size()-1; i++) {
                sb.append(path.get(i));
                sb.append("->");
            }
            sb.append(path.get(path.size()-1));
            result.add(sb.toString());
            return;
        }
        //开始单层逻辑 按照前序
        if (node.left != null) {   //左
            postRecursion(node.left, result, path);
            path.remove(path.size()-1);  //回溯，把上一行递归中加入的node删掉
        }
        if (node.right != null) {   //右
            postRecursion(node.right, result, path);
            path.remove(path.size()-1);  //回溯，把上一行递归中加入的node删掉
        }


    }


    //迭代法
    public List<String> binaryTreePaths2(TreeNode root) {
        //用于记录结果
        List<String> result = new ArrayList<>();
        //用于模拟递归 栈
        ArrayDeque<TreeNode> arrayDeque  = new ArrayDeque<>();
        //用于存放路径
        ArrayDeque<String> path = new ArrayDeque<>();
        if (root == null) {
            return result;
        }
        arrayDeque.push(root);       //一同入栈
        path.push(root.val+"");
        while (!arrayDeque.isEmpty()) {
            TreeNode node = arrayDeque.pop();    //一同出栈
            String currPath = path.pop();
            if (node.left == null && node.right == null) {
                result.add(currPath);
            }
            if (node.right != null) {
                arrayDeque.push(node.right);      //一同入栈
                path.push(currPath+"->"+node.right.val);
            }
            if (node.left != null) {
                arrayDeque.push(node.left);
                path.push(currPath+"->"+node.left.val);
            }
        }
        return result;
    }
}
