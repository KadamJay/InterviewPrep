package Trees;

public class DiameterOfBinaryTree {

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int dia = depth(root.left) + depth(root.right);
        int ldia = diameterOfBinaryTree(root.left);
        int rdia = diameterOfBinaryTree(root.right);
        return Math.max(dia, Math.max(ldia, rdia));

    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(depth(root.left), depth(root.right));
    }
}

class EfficientSolution {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    private int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        max = Math.max(max, left + right);

        return Math.max(left, right) + 1;
    }
}

/**
 * Complexity Analysis
 *
 * Time Complexity: O(N)O(N). We visit every node once.
 *
 * Space Complexity: O(N)O(N), the size of our implicit call stack during our
 * depth-first search.
 */

/**
 * https://leetcode.com/problems/diameter-of-binary-tree/
 * https://www.youtube.com/watch?v=ey7DYc9OANo&t=872s
 */