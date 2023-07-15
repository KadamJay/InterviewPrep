package Trees;

/**
 * @author jakadam on 2019-12-20
 */

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric
 * around its center).
 *
 * Example :
 *
 * 1
 * / \
 * 2 2
 * / \ / \
 * 3 4 4 3
 * The above binary tree is symmetric.
 * But the following is not:
 *
 * 1
 * / \
 * 2 2
 * \ \
 * 3 3
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */

public class SymmetricalTree {

    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();

        System.out.println("\n\nIdentical Tree");
        System.out.println(isSymmetric(tree.getRoot()));
        System.out.println(isSymmetric(null));
    }

    public static int isSymmetric(TreeNode A) {

        // null tree is symmetrical
        if (A == null)
            return 1;

        return checkSym(A.left, A.right) == true ? 1 : 0;
    }

    public static boolean checkSym(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null)
            return true;

        if (n1 == null || n2 == null) {
            return false;
        }

        if (n1.val == n2.val) {

            if (checkSym(n1.left, n2.right) && checkSym(n1.right, n2.left))
                return true;
        }

        return false;
    }
}

// This function is very similar to IdenticalBinaryTrees.isSameTree(TreeNode A,
// TreeNode B)

/**
 * https://www.youtube.com/watch?v=XV7Sg2hJO3Q
 * 
 * https://www.youtube.com/watch?v=8t4KCaDB108
 * 
 * https://www.youtube.com/watch?v=9jH2L2Ysxko
 * 
 */