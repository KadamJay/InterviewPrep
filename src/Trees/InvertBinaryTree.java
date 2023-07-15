package Trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jakadam on 2019-12-21
 */

/**
 * Given a binary tree, invert the binary tree and return it.
 * Look at the example for more details.
 *
 * Example :
 * Given binary tree
 *
 * 1
 * / \
 * 2 3
 * / \ / \
 * 4 5 6 7
 * invert and return
 *
 * 1
 * / \
 * 3 2
 * / \ / \
 * 7 6 5 4
 */
public class InvertBinaryTree {
    public TreeNode invertTreeDFS(TreeNode root) {
        if (root == null)
            return null;

        TreeNode tempLeft = root.left;
        TreeNode tempRight = root.right;

        root.left = invertTreeDFS(tempRight);
        root.right = invertTreeDFS(tempLeft);

        return root;
    }

    public TreeNode invertTreeBFS(TreeNode root) {
        if (root == null)
            return null;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (queue.isEmpty() == false) {
            TreeNode node = queue.poll();

            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.left != null)
                queue.add(node.left);

            if (node.right != null)
                queue.add(node.right);
        }

        return root;
    }
}

/**
 * Both the solutions are tested on InterviewBit
 * https://www.interviewbit.com/problems/invert-the-binary-tree/
 */