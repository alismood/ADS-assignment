package Assignment4;

import java.util.Random;

public class Experiment {
    private Random random = new Random();

    // Requirement: runTraversals(Graph g) [cite: 48]
    public void runTraversals(Graph g, int startNode, String sizeLabel) {
        System.out.println("\n--- Results for " + sizeLabel + " Graph ---");

        // Measure BFS execution time using nanoTime [cite: 67, 150]
        long bfsStart = System.nanoTime();
        g.bfs(startNode);
        long bfsEnd = System.nanoTime();
        long bfsDuration = bfsEnd - bfsStart;

        // Measure DFS execution time [cite: 150]
        System.out.println(); // Formatting
        long dfsStart = System.nanoTime();
        g.dfs(startNode);
        long dfsEnd = System.nanoTime();
        long dfsDuration = dfsEnd - dfsStart;

        System.out.println("\nExecution Times:");
        System.out.println("BFS: " + bfsDuration + " ns");
        System.out.println("DFS: " + dfsDuration + " ns");
    }

    // Requirement: runMultipleTests() for sizes 10, 30, 100 [cite: 49, 74]
    public void runMultipleTests() {
        int[] sizes = {10, 30, 100};

        for (int size : sizes) {
            Graph g = new Graph(size);

            // Add vertices based on size [cite: 60]
            for (int i = 0; i < size; i++) {
                g.addVertex(i);
            }

            // Create a connected structure with random edges [cite: 63]
            for (int i = 0; i < size; i++) {
                // Ensure each node has at least 2 connections for a real graph feel
                for (int j = 0; j < 2; j++) {
                    int target = random.nextInt(size);
                    if (i != target) {
                        g.addEdge(i, target);
                    }
                }
            }

            String label = (size == 10) ? "Small" : (size == 30) ? "Medium" : "Large";
            runTraversals(g, 0, label);
        }
    }

    // Requirement: printResults() [cite: 49]
    public void printResults() {
        System.out.println("\n==========================================");
        System.out.println("Experimentation and Analysis Complete.");
        System.out.println("Use the 'ns' values above for your README table.");
        System.out.println("==========================================");
    }
}