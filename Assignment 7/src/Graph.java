import java.util.*;

public class Graph {
    private int V;
    private LinkedList<Integer>[] adj;
    private boolean pathExist;
    public Graph(int V){
        this.V = V;
        pathExist = false;
        adj = new LinkedList[V];
        for (int i = 0; i < V; ++i){
            adj[i] = new LinkedList<>();
        }
    }


    public void isDirected(){
        for (int i = 0; i < V; i++){
            for (int j = 0; j < V; j++){
                if (!Objects.equals(adj[i].get(j), adj[j].get(i))){
                    System.out.println("This Graph is Directed.");
                    return;
                }
            }
        }
        System.out.println("This Graph is Undirected.");
    }

    void addEdge(int v1, int v2) {adj[v1].add(v2);}
    private void printAllPathsUtil(int u, int w, Boolean[] visited, int[] path, int index, int budget){
        visited[u] = true;
        path[index] = u;
        index++;

        if (u == w){
            int i;
            if(!pathExist){
                System.out.println("These are the paths between " + path[0] + " and " + path[index-1] + (budget != V ? (" under a length of " + budget) : ""));
            }
            pathExist = true;
            for(i = 0; i <index-1;i++){
                System.out.print(path[i] + "->");
            }
            System.out.println(path[i]);
        } else{
            for (int i: adj[u]){
                if (!visited[i] && index < budget){
                    printAllPathsUtil(i, w, visited, path, index, budget);
                }
            }
        }
        index--;
        visited[u] = false;
    }

    public void everyPath(int u, int w){
        everyPath(u, w, V);
    }

    public void everyPath (int u, int w, int weightLimit){
        Boolean[] visited = new Boolean[V];
        Arrays.fill(visited, false);
        int[] path = new int[V];
        int index = 0;
        pathExist = false;
        printAllPathsUtil(u, w, visited, path, index, weightLimit);
        if (!pathExist){
            System.out.println("There is no path that exists between " + u + " and " + w);
        }
    }

    public void printAsList(){
        for (int i = 0; i < V; i++){
            System.out.print(i+ "->");
            for (int x  :adj[i]){
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
    public void printAsMatrix(){
        System.out.println("Here is the list as a matrix.");
        for (int i = 0; i < V; i++){
            for (int x = 0; x < V; x++){
                System.out.print((adj[i].contains(x) ? 1 : 0) + " ");
            }
            System.out.println();
        }
    }
}
