package Trees;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author jakadam on 2019-12-20
 */

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path’s
 * sum equals the given sum.
 *
 * For example:
 * Given the below binary tree and sum = 22,
 *
 * 5
 * / \
 * 4 8
 * / / \
 * 11 13 4
 * / \ / \
 * 7 2 5 1
 * return
 *
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 *
 */

public class PathSumII {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
        ArrayList<Integer> curPath = new ArrayList<>();

        System.out.println("\n\nHasPathSum");
        hasPathSum(tree.getRoot(), 6, paths, new ArrayList<Integer>(curPath));
        System.out.println(Arrays.toString(paths.toArray()));
    }

    public static void hasPathSum(TreeNode root, int sum, ArrayList<ArrayList<Integer>> paths,
            ArrayList<Integer> curPath) {
        if (root == null)
            return;

        curPath.add(root.val);

        if (root.left == null && root.right == null && sum - root.val == 0) {
            paths.add(curPath);
            return;
        }

        hasPathSum(root.left, sum - root.val, paths, new ArrayList<>(curPath));
        hasPathSum(root.right, sum - root.val, paths, new ArrayList<>(curPath));
    }
}

/**
 * check out SumRootToLeafNumbers, it is very similar to this one
 *
 * https://leetcode.com/problems/path-sum-ii/
 * https://www.youtube.com/watch?v=3B5gnrwRmOA
 */
