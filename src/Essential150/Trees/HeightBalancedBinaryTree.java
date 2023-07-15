package Essential150.Trees;

/*
    Problem    :   https://leetcode.com/problems/balanced-binary-tree/
    Solutions  :   https://www.youtube.com/watch?v=Yt50Jfbd8Po&ab_channel=takeUforward
    Approaches :

    | No. | Approach                             | Time Complexity | Space Complexity |
    |-----|--------------------------------------|-----------------|------------------|
    |  1  | Recursive                            |     O(n)        |       O(h)       |

    The space complexity is O(H), where H is the height of the tree, due to the recursive calls on the stack.
    The time complexity of the solution is O(N), where N is the number of nodes in the tree, as each node is visited once. 

 
 
 */
// O(N) solution
class HeightBalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return checkBalance(root) != -1;
    }

    // this is nothing but a modified maxDepth method, added 2 additional ifs
    private int checkBalance(TreeNode root) {
        if (root == null)
            return 0;

        int left = checkBalance(root.left);
        int right = checkBalance(root.right);

        if (left == -1 || right == -1)
            return -1;
        if (Math.abs(right - left) > 1)
            return -1;

        return 1 + Math.max(left, right);
    }
}

// O(N^2) solution
class HeightBalancedBinaryTreeRepetitive {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        if (Math.abs(leftDepth - rightDepth) <= 1)
            return isBalanced(root.left) && isBalanced(root.right);

        return false;

    }

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return 1 + Math.max(leftDepth, rightDepth);
    }
}
/*
 * The time complexity of the above solution is O(N^2), where N is the number of
 * nodes in the tree.
 * 
 * The space complexity of the above solution is O(H), where H is the height of
 * the tree.
 * This is due to the recursive calls on the stack. In the worst case, where the
 * tree is skewed and has a
 * height of N, the space complexity becomes O(N). However, in a balanced tree,
 * the height is logarithmic,
 * resulting in a space complexity of O(log N).
 */