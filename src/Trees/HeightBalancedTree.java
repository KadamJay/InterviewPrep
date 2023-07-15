package Trees;

public class HeightBalancedTree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        System.out.println("\n\nHeight Balanced Tree: ");
        System.out.println(checkBalance(tree.getRoot()));
    }

    public static int checkBalance(TreeNode root) {
        if (root == null)
            return 1;

        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);

        if (Math.abs(leftHeight - rightHeight) <= 1)
            return (checkBalance(root.left) & checkBalance(root.right));

        return 0;
    }

    public static int maxDepth(TreeNode A) {
        if (A == null)
            return 0;

        return (1 + Math.min(maxDepth(A.left), maxDepth(A.right)));
    }
}

/**
 * Tested on InterviewBit
 * https://www.interviewbit.com/problems/balanced-binary-tree/
 *
 * https://www.youtube.com/watch?v=TWDigbwxuB4
 */
