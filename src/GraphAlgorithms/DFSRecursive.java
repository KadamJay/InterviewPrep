package GraphAlgorithms;


import java.util.ArrayList;
import java.util.List;

/**
 * Depth-First Search (DFS) algorithm for graph traversal using recursion.
 */
public class DFSRecursive {
    private int numVertices;
    private List<List<Integer>> adjacencyList;
    private boolean[] visited;

    /**
     * Initializes the DFSRecursive object with the specified number of vertices.
     *
     * @param numVertices the number of vertices in the graph
     */
    public DFSRecursive(int numVertices) {
        this.numVertices = numVertices;
        adjacencyList = new ArrayList<>(numVertices);
        visited = new boolean[numVertices];

        for (int i = 0; i < numVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    /**
     * Adds an edge between the source and destination vertices.
     *
     * @param source      the source vertex
     * @param destination the destination vertex
     */
    public void addEdge(int source, int destination) {
        adjacencyList.get(source).add(destination);
    }

    /**
     * Performs Depth-First Search (DFS) traversal starting from the specified vertex.
     *
     * @param startVertex the starting vertex for DFS traversal
     */
    public void dfs(int startVertex) {
        visited[startVertex] = true;
        System.out.print(startVertex + " ");

        List<Integer> neighbors = adjacencyList.get(startVertex);
        for (int neighbor : neighbors) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }

    /**
     * Unit test cases for DFSRecursive class.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        DFSRecursive dfs = new DFSRecursive(6);
        dfs.addEdge(0, 1);
        dfs.addEdge(0, 2);
        dfs.addEdge(1, 3);
        dfs.addEdge(2, 4);
        dfs.addEdge(2, 5);

        System.out.println("Depth-First Traversal (starting from vertex 0):");
        dfs.dfs(0);
        System.out.println();
    }
}
