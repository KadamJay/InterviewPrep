package Essential150.Trees;

import java.util.LinkedList;
import java.util.Queue;

class InvertBinaryTree {
    public TreeNode invertTreeRecursive(TreeNode root) {
        if (root == null)
            return null;

        // using post-order L-R-N
        // Swap left and right subtrees recursively
        TreeNode left = invertTreeRecursive(root.left);
        TreeNode right = invertTreeRecursive(root.right);

        // process root
        root.left = right;
        root.right = left;

        return root;
    }

    public TreeNode invertTreeIterative(TreeNode root) {
        if (root == null)
            return null;

        // Using level-order traversal (BFS) with a queue
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            // Swap left and right child nodes
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            // Enqueue the left and right child nodes if they exist
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
        }

        return root;
    }

    // Unit tests
    public static void main(String[] args) {
        InvertBinaryTree solution = new InvertBinaryTree();

        // Test case 1
        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(3);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(9);

        TreeNode result1Recursive = solution.invertTreeRecursive(root1);
        TreeNode result1Iterative = solution.invertTreeIterative(root1);
        System.out.println(
                isTreeInverted(result1Recursive) ? "Test case 1 (recursive) passed" : "Test case 1 (recursive) failed");
        System.out.println(
                isTreeInverted(result1Iterative) ? "Test case 1 (iterative) passed" : "Test case 1 (iterative) failed");

        // Test case 2: Empty tree
        TreeNode root2 = null;

        TreeNode result2Recursive = solution.invertTreeRecursive(root2);
        TreeNode result2Iterative = solution.invertTreeIterative(root2);
        System.out.println(
                isTreeInverted(result2Recursive) ? "Test case 2 (recursive) passed" : "Test case 2 (recursive) failed");
        System.out.println(
                isTreeInverted(result2Iterative) ? "Test case 2 (iterative) passed" : "Test case 2 (iterative) failed");
    }

    // Helper method to check if a binary tree is inverted
    public static boolean isTreeInverted(TreeNode root) {
        if (root == null)
            return true;

        // Check if the left and right subtrees are inverted
        boolean leftInverted = isTreeInverted(root.left);
        boolean rightInverted = isTreeInverted(root.right);

        // Check if the current node's left child is equal to the inverted right child
        // and the current node's right child is equal to the inverted left child
        return leftInverted && rightInverted && root.left == null && root.right == null;
    }
}

// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}
