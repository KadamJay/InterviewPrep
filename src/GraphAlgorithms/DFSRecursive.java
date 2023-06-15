package GraphAlgorithms;

import java.util.ArrayList;
import java.util.List;

public class DFSRecursive {
    private int numVertices;
    private List<List<Integer>> adjacencyList;
    private boolean[] visited;

    public DFSRecursive(int numVertices) {
        this.numVertices = numVertices;
        adjacencyList = new ArrayList<>(numVertices);
        visited = new boolean[numVertices];

        for (int i = 0; i < numVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination) {
        adjacencyList.get(source).add(destination);
    }

    public List<Integer> dfs(int startVertex) {
        List<Integer> traversal = new ArrayList<>();
        dfsRecursive(startVertex, traversal);
        return traversal;
    }

    private void dfsRecursive(int vertex, List<Integer> traversal) {
        visited[vertex] = true;
        traversal.add(vertex);

        List<Integer> neighbors = adjacencyList.get(vertex);
        for (int neighbor : neighbors) {
            if (!visited[neighbor]) {
                dfsRecursive(neighbor, traversal);
            }
        }
    }

    public static void main(String[] args) {
        DFSRecursive dfs = new DFSRecursive(6);
        dfs.addEdge(0, 1);
        dfs.addEdge(0, 2);
        dfs.addEdge(1, 3);
        dfs.addEdge(2, 4);
        dfs.addEdge(2, 5);

        System.out.println("Depth-First Traversal (starting from vertex 0):");
        List<Integer> traversal = dfs.dfs(0);
        for (int vertex : traversal) {
            System.out.print(vertex + " ");
        }
        System.out.println();
    }
}
