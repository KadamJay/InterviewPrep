package Trees;

/**
 * @author jakadam on 2019-12-20
 */

/**
 *
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the
 * root node down to
 * the nearest leaf node.
 *
 * NOTE : The path has to end on a leaf node.
 */

// min depth is is the distance of the root node to nearest leaf node
// so the task boils down to finding the nearest leaf node
// 1. using DFS
// 2. using BSF, use level order traversal and explore nodes levelwise,
// stop as soon as we find leaf node, return the level number

public class MinDepth {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        System.out.println("\n\nMinDepth");
        System.out.println(minDepth(tree.getRoot()));
    }

    public static int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        if (root.left == null)
            return 1 + minDepth(root.right);
        if (root.right == null)
            return 1 + minDepth(root.left);
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}

/**
 * https://www.interviewbit.com/problems/min-depth-of-binary-tree/
 * https://www.youtube.com/watch?v=QaaclTlZqEU
 * Refer Evernote for theory
 */
