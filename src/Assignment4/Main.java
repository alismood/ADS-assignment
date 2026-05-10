package Assignment4;

public class Main {
    public static void main(String[] args){
        Graph g  = new Graph(8);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(0, 4);
        g.addEdge(1, 7);
        g.addEdge(1, 7);
        g.addEdge(1, 6);
        g.addEdge(2, 5);
        g.addEdge(5,2);
        g.printGraph();
        g.bfs(0);

        g.dfs(0);

        Experiment e = new Experiment();
        e.runMultipleTests();
        e.printResults();

    }
}
