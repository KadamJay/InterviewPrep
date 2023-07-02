package Essential150.Trees;

/*
    Problem    :    https://leetcode.com/problems/same-tree/
    Solutions  :    https://youtu.be/vRbbcKXCxOw
    Approaches :

    | No. | Approach                             | Time Complexity | Space Complexity |
    |-----|--------------------------------------|-----------------|------------------|
    |  1  | Recursive                            |     O(n)        |       O(h)       |

The time complexity of the isSameTree method is O(n), where n is the number of nodes in the tree. 
The method visits each node exactly once.

The space complexity of the isSameTree method is O(h), where h is the height of the tree. 
In the worst case, where the tree is skewed and has a height of n, the space complexity becomes O(n). 
However, in a balanced tree, the height is logarithmic, resulting in a space complexity of O(log n).
 */

class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }

        return false;
    }

    public static void main(String[] args) {
        SameTree sameTree = new SameTree();

        // Test Case 1: Same trees with values 1, 2, 3
        TreeNode p1 = new TreeNode(1);
        p1.left = new TreeNode(2);
        p1.right = new TreeNode(3);

        TreeNode q1 = new TreeNode(1);
        q1.left = new TreeNode(2);
        q1.right = new TreeNode(3);

        boolean result1 = sameTree.isSameTree(p1, q1);
        System.out.println("Test Case 1: " + result1); // Expected output: true

        // Test Case 2: Different trees with values 1, null, 2
        TreeNode p2 = new TreeNode(1);
        p2.right = new TreeNode(2);

        TreeNode q2 = new TreeNode(1);
        q2.left = new TreeNode(2);

        boolean result2 = sameTree.isSameTree(p2, q2);
        System.out.println("Test Case 2: " + result2); // Expected output: false

        // Test Case 3: Different trees with values 1, 2, 1
        TreeNode p3 = new TreeNode(1);
        p3.left = new TreeNode(2);
        p3.right = new TreeNode(1);

        TreeNode q3 = new TreeNode(1);
        q3.left = new TreeNode(1);
        q3.right = new TreeNode(2);

        boolean result3 = sameTree.isSameTree(p3, q3);
        System.out.println("Test Case 3: " + result3); // Expected output: false
    }

    // TreeNode class definition
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
