package Essential150.Trees;
/*
    Problem    :   https://leetcode.com/problems/validate-binary-search-tree/
    Solutions  :   https://youtu.be/s6ATEkipzow
    Approaches :

    | No. | Approach                             | Time Complexity | Space Complexity |
    |-----|--------------------------------------|-----------------|------------------|
    |  1  | Recursive                            |     O(n)        |       O(n)       |
    |-----|--------------------------------------|-----------------|------------------|
    |  2  | Iterative                            |     O(n)        |       O(n)       |
    
    Time complexity: O(N), where N is the number of nodes in the tree.
    Space complexity: O(N), where N is the maximum depth of the recursion stack.
 */

import java.util.*;

// Recursive solution
class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        return checkBST(root, null, null);
    }

    public boolean checkBST(TreeNode root, Integer min, Integer max) {
        if (root == null)
            return true;

        if ((min != null && root.val <= min) || (max != null && root.val >= max))
            return false;

        return checkBST(root.left, min, root.val) &&
                checkBST(root.right, root.val, max);
    }
}

// Inorder traversal of BST is a ascending sorted list
class ValidateBSTIterative {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        Integer prev = null;

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (prev != null && root.val <= prev) {
                return false;
            }
            prev = root.val;
            root = root.right;
        }

        return true;

    }
}
