package Assignment4;

import java.util.Random;

public class Experiment {
    private Random random = new Random();


    public void runTraversals(Graph g, int startNode, String sizeLabel) {
        System.out.println("\n--- Results for " + sizeLabel + " Graph ---");


        long bfsStart = System.nanoTime();
        g.bfs(startNode);
        long bfsEnd = System.nanoTime();
        long bfsDuration = bfsEnd - bfsStart;


        System.out.println();
        long dfsStart = System.nanoTime();
        g.dfs(startNode);
        long dfsEnd = System.nanoTime();
        long dfsDuration = dfsEnd - dfsStart;

        System.out.println("\nExecution Times:");
        System.out.println("BFS: " + bfsDuration + " ns");
        System.out.println("DFS: " + dfsDuration + " ns");
    }


    public void runMultipleTests() {
        int[] sizes = {10, 30, 100};

        for (int size : sizes) {
            Graph g = new Graph(size);


            for (int i = 0; i < size; i++) {
                g.addVertex(i);
            }


            for (int i = 0; i < size; i++) {

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


    public void printResults() {
        System.out.println("\n==========================================");
        System.out.println("Experimentation and Analysis Complete.");
        System.out.println("Use the 'ns' values above for your README table.");
        System.out.println("==========================================");
    }
}