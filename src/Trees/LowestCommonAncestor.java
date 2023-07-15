package Trees;

/*
Algorithms cover a list of possibilities that can occur at the current node:

1.  If the node is null, return null as we have reached a leaf node and did not find what we were looking for.
2.  If the node is either A or B, return the node to the calling node, indicating that one of the nodes has been discovered.
3.  If cases 1 and 2 do not apply, we need to call the child nodes and ask them to see if they can find A and B.
    Calling the child nodes recursively, the following cases can occur at the calling node:
4.  The node receives null values from both children, indicating that both did not find A and B. Return null.
5.  The node receives non-null values from both children, indicating that both A and B were found, and the current node is the LCA. Return the node.
6.  The node receives a non-null value from one of the nodes, indicating that only one of A and B has been found. This node is not the LCA. 
    Return the child node which returned non-null.
*/

public class LowestCommonAncestor {
    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();

        System.out.println("\n\nLCA");

        System.out.println(lcaHelper(tree.getRoot(), 4, 5) == -1 ? "Nodes Not Found" : lcaHelper(tree.getRoot(), 4, 5));
        System.out.println(lcaHelper(tree.getRoot(), 2, 3) == -1 ? "Nodes Not Found" : lcaHelper(tree.getRoot(), 2, 3));
        System.out.println(lcaHelper(tree.getRoot(), 6, 7) == -1 ? "Nodes Not Found" : lcaHelper(tree.getRoot(), 6, 7));
        System.out.println(lcaHelper(tree.getRoot(), 6, 5) == -1 ? "Nodes Not Found" : lcaHelper(tree.getRoot(), 6, 5));

    }

    // There is a possibility that both nodes are not present in the tree make sure
    // both node exist by doing a DFS for each node instead
    // of calling DFS 2 times, you can populate node list and one call and check the
    // list for both nodes
    public static int lcaHelper(TreeNode root, int n1, int n2) {

        boolean n1Exists = dfs(root, n1);
        boolean n2Exists = dfs(root, n2);

        if (n1Exists && n2Exists) {

            TreeNode node = lca(root, n1, n2);
            if (node == null)
                return -1;
            else
                return node.val;
        } else // nodes not present in the tree
            return -1;

    }

    public static boolean dfs(TreeNode root, int key) {
        // implementing preOrder traversal for search

        if (root == null)
            return false;
        if (root.val == key)
            return true;

        return dfs(root.left, key) || dfs(root.right, key);

    }

    public static TreeNode lca(TreeNode root, int A, int B) {

        if (root == null)
            return null;

        if (root.val == A || root.val == B)
            return root;

        TreeNode leftSearch = lca(root.left, A, B);
        TreeNode rightSearch = lca(root.right, A, B);

        if (leftSearch == null && rightSearch == null)
            return null;

        if (leftSearch != null && rightSearch != null)
            return root;

        if (leftSearch != null)
            return leftSearch;
        else
            return rightSearch;

    }

}

/**
 * https://www.interviewbit.com/problems/least-common-ancestor/
 * https://www.youtube.com/watch?v=NBcqBddFbZw
 *
 * Best Explainations
 * LCA-https://www.youtube.com/watch?v=13m9ZCB8gjw
 *
 * DFS-https://www.geeksforgeeks.org/search-a-node-in-binary-tree/
 *
 */