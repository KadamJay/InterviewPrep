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

 The given node will always be the first node with val = 1. You must return the clonedVertex of the given node as a reference to
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
    public Vertex cloneGraph(Vertex root) {
        if (root == null)
            return null;

        Vertex clonedGraph = new Vertex(root.val);
        
        // create an array of Node(not boolean) to add all the adjacent nodes of particular vertex, 
        // whether it's visited or not, so in the Vertex[] initially null is stored, if that node is visited, 
        // we will store the respective node at the index, and can retrieve that easily.
        Vertex[] visited = new Vertex[101];
        
        Arrays.fill(visited, null);

        dfs(root, clonedGraph, visited);

        return clonedGraph;
    }

    private void dfs(Vertex originalNode, Vertex clonedNode, Vertex[] visited) {
        visited[clonedNode.val] = clonedNode;

        for (Vertex neighbor : originalNode.neighbors) {
            if (visited[neighbor.val] == null) {
                Vertex newNeighbor = new Vertex(neighbor.val);
                clonedNode.neighbors.add(newNeighbor);
                dfs(neighbor, newNeighbor, visited);
            } else {
                // node already visited, retrieve it from visited array and add it as adjacent node of cloned node
                // This is the point why we used vertex[] instead of boolean[] array
                clonedNode.neighbors.add(visited[neighbor.val]);
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

        Vertex clonedVertex = solution.cloneGraph(node1);

        // Verify the cloned graph
        System.out.println("Original Graph:");
        printGraph(node1);

        System.out.println("Cloned Graph:");
        printGraph(clonedVertex);
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
