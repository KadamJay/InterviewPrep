package Trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class PostOrderTraversal {

    // recursive
    List<Integer> inOrd = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {

        helper(inOrd, root);
        return inOrd;
    }

    public void helper(List<Integer> list, TreeNode root) {
        if (root != null) {
            helper(inOrd, root.left);
            helper(inOrd, root.right);
            inOrd.add(root.val);
        }
    }
}

/**
 * https://leetcode.com/problems/binary-tree-postorder-traversal/#/solutions
 * 
 * https://discuss.leetcode.com/topic/6478/iterative-solution-in-java-simple-and-readable
 * 
 * http://www.java67.com/2015/01/how-to-reverse-arraylist-in-java-with.html
 * 
 * https://leetcode.com/problems/binary-tree-postorder-traversal/#/solutions
 * 
 * 
 * using 2 stacks(easy)
 * https://www.youtube.com/watch?v=G7tvjUGMBJ4
 */
