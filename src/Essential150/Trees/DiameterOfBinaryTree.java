package Essential150.Trees;

/*
    Problem    :   https://leetcode.com/problems/diameter-of-binary-tree/
    Solutions  :   https://youtu.be/bkxqA8Rfv04 | https://www.youtube.com/watch?v=ey7DYc9OANo&t=872s
    Approaches :

    | No. | Approach                             | Time Complexity | Space Complexity |
    |-----|--------------------------------------|-----------------|------------------|
    |  1  | Recursive                            |     O(n)        |       O(n)       |

    Time complexity: O(N), where N is the number of nodes in the tree.
    Space complexity: O(N), where N is the maximum depth of the recursion stack.
 */

// O(n) solution
public class DiameterOfBinaryTree {

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDiameterHelper(root);
        return max;
    }

    public int maxDiameterHelper(TreeNode root) {
        if (root == null)
            return 0;

        int leftDepth = maxDiameterHelper(root.left);
        int rightDepth = maxDiameterHelper(root.right);

        max = Math.max(max, (leftDepth + rightDepth));

        return 1 + Math.max(leftDepth, rightDepth);

    }
}

// O(n^2) solution
class DiameterOfBinaryTreeInefficient {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        int diameterThroughRoot = maxDepth(root.left) + maxDepth(root.right);
        int diameterNotThroughRoot = Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right));
        return Math.max(diameterThroughRoot, diameterNotThroughRoot);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}

/*
 * The time complexity of the `diameterOfBinaryTree` method in the
 * `DiameterOfBinaryTree` class is O(N^2),
 * where N is the number of nodes in the binary tree. This is because for each
 * node, the `maxDepth` function
 * is called recursively, resulting in a nested recursive call for each node. As
 * a result, the time complexity
 * is proportional to the number of nodes squared.
 * 
 * The space complexity of the `diameterOfBinaryTree` method is O(N), where N is
 * the number of nodes in the binary tree.
 * This is because the space used by the recursive calls in the call stack is
 * proportional to the height of the tree,
 * which can be at most N in the worst case for a skewed tree. Additionally, the
 * recursive `maxDepth` function also
 * contributes to the space complexity. However, since the space used by the
 * recursive calls is proportional to the height of
 * the tree, the space complexity is dominated by O(N) in the worst case.
 */
