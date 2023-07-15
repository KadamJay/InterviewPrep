package Essential150.Trees;
/*
    Problem    :   https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
    Solutions  :   https://youtu.be/gs2LMfuOR9k
    Approaches :

    | No. | Approach                             | Time Complexity | Space Complexity |
    |-----|--------------------------------------|-----------------|------------------|
    |  1  | Recursive                            |     O(n)        |       O(n)       |

    Time complexity: O(N), where N is the number of nodes in the tree.
    Space complexity: O(N), where N is the maximum depth of the recursion stack.
 */

public class LowestCommonAncestor {
    public static void main(String[] args) {
        /*
         * Test cases:
         * 1. Both nodes are present in the tree
         * 2. One of the nodes is missing in the tree
         * 3. The tree is empty (root is null)
         */

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        TreeNode p = root.left;
        TreeNode q = root.right;

        TreeNode result = lowestCommonAncestor(root, p, q);
        if (result != null) {
            System.out.println("Lowest Common Ancestor: " + result.val);
        } else {
            System.out.println("Lowest Common Ancestor not found.");
        }
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        if (root.val == p.val || root.val == q.val)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null)
            return root;

        return left != null ? left : right;
    }
}
