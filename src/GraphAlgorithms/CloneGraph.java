package GraphAlgorithms;

/**

 Given a reference of a node in a connected undirected graph.

 Return a deep copy (clone) of the graph.

 Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.


 class Vertex {
 public int val;
 public List<Vertex> neighbors;
 }

 Test case format:

 For simplicity, each node's value is the same as the node's index (1-indexed). For example, the first node with
 val == 1, the second node with val == 2, and so on. The graph is represented in the test case using an adjacency list.

 An adjacency list is a collection of unordered lists used to represent a finite graph. Each list describes the set of
 neighbors of a node in the graph.

 The given node will always be the first node with val = 1. You must return the copy of the given node as a reference to
 the cloned graph.


 LC: https://leetcode.com/problems/clone-graph/description/


 */


import java.util.*;

// Definition for a Vertex.
class Vertex {
    public int val;
    public List<Vertex> neighbors;

    public Vertex(int val, List<Vertex> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }

    public Vertex(int val) {
        this.val = val;
        this.neighbors = new ArrayList<>();
    }

    public Vertex() {
        this.val = 0;
        this.neighbors = new ArrayList<>();
    }
}

class CloneGraph {
    public Vertex cloneGraph(Vertex node) {
        if (node == null)
            return null;

        Vertex copy = new Vertex(node.val);
        Vertex[] visited = new Vertex[101];
        Arrays.fill(visited, null);

        dfs(node, copy, visited);

        return copy;
    }

    private void dfs(Vertex node, Vertex copy, Vertex[] visited) {
        visited[copy.val] = copy;

        for (Vertex neighbor : node.neighbors) {
            if (visited[neighbor.val] == null) {
                Vertex newNeighbor = new Vertex(neighbor.val);
                copy.neighbors.add(newNeighbor);
                dfs(neighbor, newNeighbor, visited);
            } else {
                copy.neighbors.add(visited[neighbor.val]);
            }
        }
    }
}

class CloneGraphTest {
    public static void main(String[] args) {
        CloneGraph solution = new CloneGraph();

        // Create the graph: 1 -- 2
        //                   |    |
        //                   4 -- 3
        Vertex node1 = new Vertex(1);
        Vertex node2 = new Vertex(2);
        Vertex node3 = new Vertex(3);
        Vertex node4 = new Vertex(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        Vertex clonedGraph = solution.cloneGraph(node1);

        // Verify the cloned graph
        System.out.println("Original Graph:");
        printGraph(node1);

        System.out.println("Cloned Graph:");
        printGraph(clonedGraph);
    }

    private static void printGraph(Vertex node) {
        Set<Vertex> visited = new HashSet<>();
        Queue<Vertex> queue = new LinkedList<>();
        queue.offer(node);
        visited.add(node);

        while (!queue.isEmpty()) {
            Vertex currNode = queue.poll();
            System.out.print(currNode.val + " Neighbors: ");

            for (Vertex neighbor : currNode.neighbors) {
                System.out.print(neighbor.val + " ");
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
            System.out.println();
        }
    }
}
