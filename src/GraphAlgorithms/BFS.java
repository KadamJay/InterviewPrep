package GraphAlgorithms;

/**
 * @author jakadam on 2019-12-26
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    private int numVertices;
    private List<List<Integer>> adjacencyList;

    public BFS(int numVertices) {
        this.numVertices = numVertices;
        adjacencyList = new ArrayList<>(numVertices);

        for (int i = 0; i < numVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination) {
        adjacencyList.get(source).add(destination);
    }

    public List<Integer> bfs(int startVertex) {
        List<Integer> traversal = new ArrayList<>();
        boolean[] visited = new boolean[numVertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[startVertex] = true;
        queue.offer(startVertex);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            traversal.add(currentVertex);

            List<Integer> neighbors = adjacencyList.get(currentVertex);
            for (int neighbor : neighbors) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }

        return traversal;
    }

    public static void main(String[] args) {
        BFS bfs = new BFS(6);
        bfs.addEdge(0, 1);
        bfs.addEdge(0, 2);
        bfs.addEdge(1, 3);
        bfs.addEdge(2, 4);
        bfs.addEdge(2, 5);

        System.out.println("Breadth-First Traversal (starting from vertex 0):");
        List<Integer> traversal = bfs.bfs(0);
        for (int vertex : traversal) {
            System.out.print(vertex + " ");
        }
        System.out.println();
    }
}

/**
 * https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
 * https://algorithms.tutorialhorizon.com/breadth-first-searchtraversal-in-a-graph/
 */