import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphTraversal {

    private int numVertices;
    private List<List<Integer>> adjacencyList;

    public GraphTraversal(int numVertices) {
        this.numVertices = numVertices;
        adjacencyList = new ArrayList<>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination) {
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source); // For undirected graph
    }

    public void parallelBFS(int startVertex) {
        boolean[] visited = new boolean[numVertices];
        visited[startVertex] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            System.out.print(currentVertex + " ");

            // #pragma omp parallel for
            for (int neighbor : adjacencyList.get(currentVertex)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    public void parallelDFS(int startVertex) {
        boolean[] visited = new boolean[numVertices];
        parallelDFSUtil(startVertex, visited);
    }

    private void parallelDFSUtil(int currentVertex, boolean[] visited) {
        visited[currentVertex] = true;
        System.out.print(currentVertex + " ");

        // #pragma omp parallel for
        for (int neighbor : adjacencyList.get(currentVertex)) {
            if (!visited[neighbor]) {
                parallelDFSUtil(neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        int numVertices = 6;
        GraphTraversal graph = new GraphTraversal(numVertices);

        // Add edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);

        System.out.println("Parallel Breadth First Search (BFS):");
        graph.parallelBFS(0);
        System.out.println();

        System.out.println("Parallel Depth First Search (DFS):");
        graph.parallelDFS(0);
        System.out.println();
    }
}