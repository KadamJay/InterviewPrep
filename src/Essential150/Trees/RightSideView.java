package Essential150.Trees;

/*
    Problem    :    https://leetcode.com/problems/binary-tree-right-side-view/
    Solutions  :    https://www.youtube.com/watch?v=KV4mRzTjlAk&ab_channel=takeUforward
    Approaches :

    | No. | Approach                             | Time Complexity | Space Complexity |
    |-----|--------------------------------------|-----------------|------------------|
    |  1  | Recursive                            |     O(n)        |       O(h)       |
    |-----|--------------------------------------|-----------------|------------------|
    |  2  | Iterative                            |     O(n)        |       O(m)       |

    h = height of tree
    m = max number of nodes at any level of tree
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class RightSideView {
    public List<Integer> getRightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        int level = 0;
        getRightSideViewHelper(root, result, level);
        return result;
    }

    private void getRightSideViewHelper(TreeNode root, List<Integer> result, int level) {
        if (root == null) {
            return;
        }

        // since right side is being visited first, only the rightmost node
        // of each level will be added to result
        if (result.size() == level) {
            result.add(root.val);
        }

        // visiting in RRL order, for left side view just swap next two lines
        getRightSideViewHelper(root.right, result, level + 1);
        getRightSideViewHelper(root.left, result, level + 1);
    }

    // iterative solution
    public List<Integer> getRightSideViewIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (i == size - 1) { // this line will change for left side view
                    result.add(node.val);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Create a sample tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);

        RightSideView rightSideView = new RightSideView();
        List<Integer> result = rightSideView.getRightSideView(root);

        // Test the result
        if (result.equals(List.of(1, 3, 5))) {
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed!");
        }
    }
}
