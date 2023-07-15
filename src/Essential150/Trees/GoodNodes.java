package Essential150.Trees;
/*
    Problem    :   https://leetcode.com/problems/count-good-nodes-in-binary-tree/
    Solutions  :   https://youtu.be/7cp5imvDzl4
    Approaches :

    | No. | Approach                             | Time Complexity | Space Complexity |
    |-----|--------------------------------------|-----------------|------------------|
    |  1  | Recursive                            |     O(n)        |       O(n)       |

    Time complexity: O(N), where N is the number of nodes in the tree.
    Space complexity: O(N), where N is the maximum depth of the recursion stack.
 */

class GoodNodes {
    public int count = 0;

    public int goodNodes(TreeNode root) {
        dfs(root, root.val);
        return count;
    }

    public void dfs(TreeNode root, int max) {
        if (root == null)
            return;

        if (root.val >= max) {
            count++;
            max = root.val;
        }
        dfs(root.left, max);
        dfs(root.right, max);
    }
}