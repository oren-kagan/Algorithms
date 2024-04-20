

public class Main {
    public static void main(String[] args) {
        Graph g = new Graph(8);
        g.addEdge(0, 1);
        g.addEdge(1, 3);
        g.addEdge(2, 1);
        g.addEdge(3, 2);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(6, 4);
        g.addEdge(5, 7);
        g.addEdge(7, 6);
        g.addEdge(0, 2);
        g.addEdge(2, 6);
        g.printAsMatrix();
        int u=1, w=7;
        g.isDirected();
        g.everyPath(u, w, 5);
        g.everyPath(u, w);
    }
}