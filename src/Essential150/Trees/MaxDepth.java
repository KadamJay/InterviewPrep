package Essential150.Trees;

/*
    Problem    :   https://leetcode.com/problems/maximum-depth-of-binary-tree/
    Solutions  :   https://youtu.be/hTM3phVI6YQ
    Approaches :

    | No. | Approach                             | Time Complexity | Space Complexity |
    |-----|--------------------------------------|-----------------|------------------|
    |  1  | Recursive                            |     O(n)        |       O(h)       |


    The time complexity of the maxDepth method is O(n), where n is the number of nodes in the binary tree.

    The space complexity of the maxDepth method is O(h), where h is the height of the binary tree. 
    In the worst case, where the tree is skewed and has a height of n, the space complexity becomes O(n). 
    However, in a balanced tree, the height is logarithmic, resulting in a space complexity of O(log n).

 */
class MaxDepth {

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return 1 + Math.max(leftDepth, rightDepth);
    }

    public static void main(String[] args) {
        // Test case 1: Empty tree
        TreeNode root1 = null;
        MaxDepth maxDepthObj = new MaxDepth();
        System.out.println("Max depth of tree 1: " + maxDepthObj.maxDepth(root1)); // Expected output: 0

        // Test case 2: Single node tree
        TreeNode root2 = new TreeNode(1);
        System.out.println("Max depth of tree 2: " + maxDepthObj.maxDepth(root2)); // Expected output: 1

        // Test case 3: Tree with three nodes
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        root3.right = new TreeNode(3);
        System.out.println("Max depth of tree 3: " + maxDepthObj.maxDepth(root3)); // Expected output: 2

        // Test case 4: Tree with multiple levels
        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(2);
        root4.right = new TreeNode(3);
        root4.left.left = new TreeNode(4);
        root4.left.right = new TreeNode(5);
        root4.right.left = new TreeNode(6);
        System.out.println("Max depth of tree 4: " + maxDepthObj.maxDepth(root4)); // Expected output: 3
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}
