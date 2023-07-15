package Trees;

/**
 * @author jakadam on 2019-12-20
 */

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path
 * such that adding up all the values along the path equals the given sum.
 */

public class PathSum {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        System.out.println("\n\nHasPathSum");
        System.out.println(hasPathSum(tree.getRoot(), 6));
        System.out.println(hasPathSum(tree.getRoot(), 5));
        System.out.println(hasPathSum(tree.getRoot(), 100));
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;

        if (root.left == null && root.right == null && sum - root.val == 0)
            return true;

        return (hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val));
    }
}

/**
 * https://www.interviewbit.com/problems/path-sum/
 * https://www.youtube.com/watch?v=Hg82DzMemMI
 * https://leetcode.com/problems/path-sum/#/solutions
 */