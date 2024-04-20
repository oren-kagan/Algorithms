import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.ui.view.Viewer;
import org.graphstream.ui.spriteManager.*;

public class GraphDrawing {
    public static void main(String[] args) {
        GraphDrawing gd = new GraphDrawing();
        gd.drawGraph("[ (I, 2) , (A, 5) , (E, 4) , (F,1) , (T, 2) , (S, 3) ]");
    }

    public void drawGraph (String s){
        System.setProperty("org.graphstream.debug", "true");
        System.setProperty("org.graphstream.ui", "javafx");
        MultiGraph g = new MultiGraph("Where do I see this??");
        String sNoBrackets = s.substring(2, s.length() -2);
        String[] arr = sNoBrackets.split(" , ");
        for (String temp: arr){
            Node n = g.addNode("" + temp.charAt(1));
            n.setAttribute("ui.style", "fill-color: rgb(0,100,255);");
            n.setAttribute("ui.label",temp.charAt(1));
            n.setAttribute("ui.antialias");
            n.setAttribute("ui.quality");
//            n.setAttribute("xyz", 300, 300, 0);

        }
        String current = "";
        for (int i = 0; i < arr.length; i++){
            current = arr[i];
            g.addEdge("" + current.charAt(1) + arr[(i + (int)current.charAt(4)) % arr.length].charAt(1), "" + current.charAt(1), "" + arr[(i + (int)current.charAt(4)) % arr.length].charAt(1), true);
            if (((i + (int)current.charAt(4)) % arr.length) != ((i - (int)current.charAt(4)) % arr.length + arr.length)){
                g.addEdge("" + current.charAt(1) + arr[(i - (int) current.charAt(4)) % arr.length + arr.length].charAt(1), "" + current.charAt(1), "" + arr[(i - (int) current.charAt(4)) % arr.length + arr.length].charAt(1), true);
            }
        }
        Viewer viewer = g.display(true);
    }
}
