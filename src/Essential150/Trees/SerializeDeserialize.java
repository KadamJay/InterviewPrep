package Essential150.Trees;

/*
    Problem    :    https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
    Solutions  :    https://youtu.be/u4JAi2JJhI8 | https://youtu.be/WlZ7d4ZfQYw
    Approaches :

    | No. | Approach                             | Time Complexity | Space Complexity |
    |-----|--------------------------------------|-----------------|------------------|
    |  1  | Recursive                            |     O(N)        |       O(N)       |


    Overall, the time complexity of both serialization and deserialization is O(N), where N is the number of nodes in the binary tree.
    Overall, the space complexity of the code is O(N), where N is the number of nodes in the binary tree.
 */

import java.util.*;

public class SerializeDeserialize {
    private static final String SPLITTER = ",";
    private static final String NULL_NODE = "X";

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NULL_NODE).append(SPLITTER);
            return;
        }

        sb.append(node.val).append(SPLITTER);
        buildString(node.left, sb);
        buildString(node.right, sb);
    }

    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>(Arrays.asList(data.split(SPLITTER)));
        return buildTree(nodes);
    }

    private TreeNode buildTree(Deque<String> nodes) {
        String val = nodes.remove();
        if (val.equals(NULL_NODE)) {
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
}
