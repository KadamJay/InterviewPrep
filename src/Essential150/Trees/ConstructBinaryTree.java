package Essential150.Trees;

/*
Problem    :   https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
Solutions  :   https://youtu.be/ihj4IQGZ2zc
Approaches :

| No. | Approach                             | Time Complexity      | Space Complexity |
|-----|--------------------------------------|----------------------|------------------|
|  1  | Recursive                            |          O(N)        |       O(N)       |

The time complexity of the code is O(N), where N is the number of nodes in the binary tree. 
The space complexity is also O(N) due to the hashmap used to store the indices and the recursion stack.

*/
import java.util.HashMap;
import java.util.Map;

class ConstructBinaryTree {
    private int preorderIndex;
    private Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return buildSubtree(preorder, 0, inorder.length - 1);
    }

    private TreeNode buildSubtree(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }

        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        int rootIndex = inorderIndexMap.get(rootValue);

        root.left = buildSubtree(preorder, left, rootIndex - 1);
        root.right = buildSubtree(preorder, rootIndex + 1, right);

        return root;
    }
}
