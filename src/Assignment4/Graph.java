package Assignment4;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private int V, E;
     LinkedList<Vertex>[] adj;

     public Graph(int nodes){
         this.V = nodes;
         this.adj = new LinkedList[V];
         for(int v = 0; v<V; v++){
             adj[v] = new LinkedList<>();
         }
     }

    public void addVertex(int id) {
        if (id >= adj.length) return; // Prevent OutOfBounds
        if (adj[id] == null) {
            adj[id] = new LinkedList<>();
        }
    }

     public void addEdge(int s, int d){
         for(Vertex n : adj[s]){
             if(n.getId() == d){
                 return;
             }
         }

         adj[s].add(new Vertex(d));
         adj[d].add(new Vertex(s));
     }

     public void printGraph(){
         for(int i = 0; i<V; i++){
             System.out.print("Vertex " + i + ": ");
             for(Vertex n : adj[i]){
                 System.out.print(n.getId() + " ");
             }
             System.out.println();
         }
     }

     public void bfs(int start){
         boolean[] visited = new boolean[V];
         Queue<Integer> q = new LinkedList<>();
        System.out.print("BFS: ");
         q.add(start);

         while (!q.isEmpty()){
             int u = q.poll();
             visited[u] = true;
             System.out.print(u + " ");
             for (int w = 0; w < adj[u].size(); w++){
                 if(!visited[adj[u].get(w).getId()]){
                     visited[adj[u].get(w).getId()] = true;
                     q.add(adj[u].get(w).getId());
                 }
             }
         }

     }

    public void dfs(int start) {
        boolean[] visited = new boolean[adj.length];
        System.out.print("DFS: ");
        visitNode(start, visited);
    }

    public void visitNode(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");
        for (Vertex n : adj[v]) {
            if (!visited[n.getId()]) {
                visitNode(n.getId(), visited);
            }
        }
    }
}
