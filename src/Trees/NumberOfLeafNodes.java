package Trees;

public class NumberOfLeafNodes {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        System.out.println("\n\nLeaf Node Count: ");
        System.out.println(countLeafNodes(tree.getRoot()));
    }

    public static int countLeafNodes(TreeNode A) {
        if (A == null)
            return 0;

        if (A.left == null && A.right == null)
            return 1;

        return countLeafNodes(A.left) + countLeafNodes(A.right);
    }
}

/**
 * https://www.youtube.com/watch?v=PArGIFNfIDk
 * https://www.geeksforgeeks.org/write-a-c-program-to-get-count-of-leaf-nodes-in-a-binary-tree/
 */