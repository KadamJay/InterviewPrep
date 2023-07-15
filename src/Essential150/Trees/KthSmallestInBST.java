package Essential150.Trees;

/*
    Problem    :   https://leetcode.com/problems/kth-smallest-element-in-a-bst/
    Solutions  :   https://youtu.be/5LUXSvjmGCw
    Approaches :

    | No. | Approach                             | Time Complexity | Space Complexity |
    |-----|--------------------------------------|-----------------|------------------|
    |  1  | Recursive                            |     O(n)        |       O(n)       |

    Time complexity: O(N), where N is the number of nodes in the tree.
    Space complexity: O(N), where N is the maximum depth of the recursion stack.
 */

import java.util.Stack;

public class KthSmallestInBST {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();

        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0)
                return root.val;
            root = root.right;
        }
    }
}
