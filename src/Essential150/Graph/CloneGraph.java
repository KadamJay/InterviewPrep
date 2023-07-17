package Essential150.Graph;

/*
Problem    :    https://leetcode.com/problems/clone-graph/
Solutions  :    https://youtu.be/mQeF6bN8hMk
Approaches :

| No. | Approach                             | Time Complexity      | Space Complexity |
|-----|--------------------------------------|----------------------|------------------|
|  1  | DFS                                  |       O(V+E)         |     O(V+E)       |
|-----|--------------------------------------|----------------------|------------------|
|  2  | BFS                                  |       O(V+E)         |     O(V+E)       |

O(V+E)  because we have to clone the vertices along with the edges and store them as well.

*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class CloneGraph {
    public Node cloneGraph(Node node) {
        if (node == null)
            return node;

        Map<Node, Node> map = new HashMap<>(); // Stores the mapping of original nodes to cloned nodes
        Queue<Node> queue = new LinkedList<>(); // Queue for BFS traversal

        Node copyNode = new Node(node.val); // Create a clone of the starting node
        map.put(node, copyNode); // Add the mapping of original node to cloned node
        queue.offer(node);

        while (!queue.isEmpty()) {
            Node oldNode = queue.poll();

            for (Node oldNeighbor : oldNode.neighbors) {
                if (!map.containsKey(oldNeighbor)) {
                    Node clonedNeighbor = new Node(oldNeighbor.val);
                    map.put(oldNeighbor, clonedNeighbor);
                    queue.offer(oldNeighbor);
                }
                map.get(oldNode).neighbors.add(map.get(oldNeighbor));
            }
        }

        return copyNode;
    }
}

// DFS solution

class CloneGraphDFS {
    Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null)
            return null;

        if (map.containsKey(node))
            return map.get(node);

        Node copyNode = new Node(node.val, new ArrayList<>());
        map.put(node, copyNode);

        for (Node oldNeighbor : node.neighbors) {
            Node copyNeighbor = cloneGraph(oldNeighbor);
            copyNode.neighbors.add(copyNeighbor);
        }

        return copyNode;
    }
}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
