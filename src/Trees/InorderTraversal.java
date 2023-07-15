package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        System.out.println("InorderIterative");
        inorderIterative(tree.getRoot());
        System.out.println("\n\nInorderRecursive");
        inorderRecursive(tree.getRoot());
    }

    public static void inorderIterative(TreeNode A) {
        TreeNode cur = A;
        Stack<TreeNode> stack = new Stack<>();

        while (cur != null || stack.isEmpty() == false) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            System.out.print(cur.val + " ");
            cur = cur.right;
        }
    }

    public static void inorderRecursive(TreeNode root) {
        if (root == null)
            return;

        inorderRecursive(root.left);
        System.out.print(root.val + " ");
        inorderRecursive(root.right);
    }
}

class InorderTraversalRecursive {
    List<Integer> inOrd = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        helper(inOrd, root);
        return inOrd;
    }

    public void helper(List<Integer> list, TreeNode root) {
        if (root != null) {
            helper(inOrd, root.left);
            inOrd.add(root.val);
            helper(inOrd, root.right);
        }
    }
}

/*
 * https://www.interviewbit.com/problems/inorder-traversal/
 * https://www.youtube.com/watch?v=gm8DUJJhmY4&list=
 * PL2_aWCzGMAwI3W_JlcBbtYTwiQSsOTa6P&index=35&t=0s
 */