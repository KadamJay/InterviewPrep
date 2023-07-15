package Trees;

public class IdenticalBinaryTrees {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        System.out.println("\n\nIdentical Tree");
        System.out.println(isSameTree(tree.getRoot(), tree.getRoot()));
        System.out.println(isSameTree(tree.getRoot(), null));
    }

    public static boolean isSameTree(TreeNode A, TreeNode B) {
        if (A == null && B == null)
            return true;

        if (A == null || B == null)
            return false;

        if (A.val == B.val) {
            return isSameTree(A.left, B.left) && isSameTree(A.right, B.right);
        }
        return false;
    }
}

/**
 * https://www.interviewbit.com/problems/identical-binary-trees/
 * https://www.youtube.com/watch?v=kL5Gs1YTwMM
 */
