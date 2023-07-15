package Trees;

import java.util.Stack;

public class FlattenBinaryTree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        System.out.println("\n\n Before flattenBinaryTree: ");
        preorderRecursive(tree.getRoot());
        System.out.println("\n\n After flattenBinaryTree: ");
        preorderRecursive(flattenBinaryTree(tree.getRoot()));
    }

    public static void preorderRecursive(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.val + " ");
        preorderRecursive(root.left);
        preorderRecursive(root.right);
    }

    public static TreeNode flattenBinaryTree(TreeNode root) {
        if (root == null)
            return null;

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (stack.isEmpty() == false) {
            TreeNode node = stack.pop();

            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);

            if (stack.isEmpty() == false)
                node.right = stack.peek();

            node.left = null;
        }

        return root;
    }
}

/**
 * Tested on InterviewBit
 * https://www.interviewbit.com/problems/flatten-binary-tree-to-linked-list/
 */
