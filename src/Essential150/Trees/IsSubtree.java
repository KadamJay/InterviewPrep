package Essential150.Trees;

/*
    Problem    :   https://leetcode.com/problems/subtree-of-another-tree/
    Solutions  :   https://youtu.be/E36O5SWp-LE
    Approaches :

    | No. | Approach                             | Time Complexity | Space Complexity |
    |-----|--------------------------------------|-----------------|------------------|
    |  1  | Recursive                            |    O(m*n)       |   O(max(m,n))    |
    
    Time complexity:O(m*n),where m and n are the number of nodes in the main tree and the sub tree,respectively.
    Space complexity:O(max(m,n)),the maximum depth of the recursion stack.
 */

public class IsSubtree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null)
            return false;
        if (subRoot == null)
            return true;

        if (isIdenticalTree(root, subRoot))
            return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean isIdenticalTree(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null)
            return true;

        if (node1 == null || node2 == null)
            return false;

        if (node1.val == node2.val) {
            return isIdenticalTree(node1.left, node2.left) && isIdenticalTree(node1.right, node2.right);
        }

        return false;
    }

}
