package Essential150.Trees;

/*
    Problem    :   https://leetcode.com/problems/binary-tree-maximum-path-sum/
    Solutions  :   https://youtu.be/Hr5cWUld4vU
    Approaches :

    | No. | Approach                             | Time Complexity | Space Complexity |
    |-----|--------------------------------------|-----------------|------------------|
    |  1  | Recursive                            |      O(n)       |        O(n)      |
    
 */

class MaxPathSum {
    int maxPathSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxPathSum;
    }

    public int dfs(TreeNode root) {
        if (root == null)
            return 0;

        int leftSum = Math.max(0, dfs(root.left));
        int rightSum = Math.max(0, dfs(root.right));

        maxPathSum = Math.max(maxPathSum, root.val + leftSum + rightSum);

        return Math.max(leftSum, rightSum) + root.val;
    }

}