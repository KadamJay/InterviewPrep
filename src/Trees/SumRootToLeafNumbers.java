package Trees;

/**
 * @author jakadam on 2019-12-20
 */

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path
 * could represent a number.
 *
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 *
 * Find the total sum of all root-to-leaf numbers % 1003.
 *
 * Example :
 *
 * 1
 * / \
 * 2 3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 *
 * Return the sum = (12 + 13) % 1003 = 25 % 1003 = 25
 */

public class SumRootToLeafNumbers {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        System.out.println("\n\nSumRootToLeafNumbers");
        System.out.println(sumTree(tree.getRoot(), 0));

    }

    public static int sumTree(TreeNode node, int sum) {
        if (node == null)
            return 0;

        sum = (sum * 10 + node.val) % 1003;

        if (node.right == null && node.left == null)
            return sum;

        return sumTree(node.left, sum) +
                sumTree(node.right, sum);
    }
}

/**
 * This problem can also be solved by using the approach used in PathSumII,
 * generating a list of all the
 * possible paths from root to all the leaf nodes and then when have all the
 * paths as arrayLists, just calculate
 * the sum, forming the numbers.
 *
 * Following approach is an optimized approach.
 */

/**
 * https://www.interviewbit.com/problems/sum-root-to-leaf-numbers/
 * http://www.programcreek.com/2014/05/leetcode-sum-root-to-leaf-numbers-java/
 *
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/#/solutions
 */