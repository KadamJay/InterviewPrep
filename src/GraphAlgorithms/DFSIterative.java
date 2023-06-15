package GraphAlgorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFSIterative {
    private int numVertices;
    private List<List<Integer>> adjacencyList;

    public DFSIterative(int numVertices) {
        this.numVertices = numVertices;
        adjacencyList = new ArrayList<>(numVertices);

        for (int i = 0; i < numVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination) {
        adjacencyList.get(source).add(destination);
    }

    public List<Integer> dfs(int startVertex) {
        List<Integer> traversal = new ArrayList<>();
        boolean[] visited = new boolean[numVertices];
        Stack<Integer> stack = new Stack<>();

        stack.push(startVertex);

        while (!stack.isEmpty()) {
            int currentVertex = stack.pop();

            if (!visited[currentVertex]) {
                visited[currentVertex] = true;
                traversal.add(currentVertex);

                List<Integer> neighbors = adjacencyList.get(currentVertex);
                for (int neighbor : neighbors) {
                    if (!visited[neighbor]) {
                        stack.push(neighbor);
                    }
                }
            }
        }

        return traversal;
    }

    public static void main(String[] args) {
        DFSIterative dfs = new DFSIterative(6);

        dfs.addEdge(0, 1);
        dfs.addEdge(0, 2);
        dfs.addEdge(1, 3);
        dfs.addEdge(2, 4);
        dfs.addEdge(2, 5);

        /*
                0
               / \
              1   2
             /   / \
            3   4   5

        */


        System.out.println("Depth-First Traversal (starting from vertex 0):");
        List<Integer> traversal = dfs.dfs(0);
        for (int vertex : traversal) {
            System.out.print(vertex + " ");
        }
        System.out.println();
    }
}
