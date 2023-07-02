package Essential150.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
    Problem    :   https://leetcode.com/problems/binary-tree-level-order-traversal/
    Solutions  :   https://youtu.be/6ZnyEApgFYg
    Approaches :


    Space complexity: O(n), where n is the number of nodes in the tree.
    Time complexity: O(n), where n is the number of nodes in the tree, as we visit each node once.
 */
class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }

            result.add(level);
        }

        return result;
    }

    // Unit test
    public static void main(String[] args) {
        LevelOrderTraversal solution = new LevelOrderTraversal();

        // Test case 1
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);

        List<List<Integer>> result1 = solution.levelOrder(root1);
        System.out.println(result1.equals(List.of(
                List.of(3),
                List.of(9, 20),
                List.of(15, 7))) ? "Test case 1 passed" : "Test case 1 failed");

        // Test case 2: Empty tree
        TreeNode root2 = null;

        List<List<Integer>> result2 = solution.levelOrder(root2);
        System.out.println(result2.equals(List.of()) ? "Test case 2 passed" : "Test case 2 failed");
    }
}

// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}
