import java.util.*;

/*    private final int numVertex = 30;
    public int[] vertexes = new int[numVertex];
    public int[] unvisited = new int[numVertex];
    public int[] visited = new int[numVertex];
    vertexes[0] = 0;
    visited.add(vertexes[0]);
    for ( int i = 1; i < vertexes.length; ++i ) {
        vertexes[i] = Integer.MAX_VALUE;
        unvisited.add(vertexes[i])
    }

    Graph labyrinth = new Graph(numVertex);
    labyrinth.initializeGraph();

    int start = vertexes[0];
    int current_vertex = start;
*/    
public class DijkstraAlg {
   // Graph labyrinth = new Graph();
    private final List <Vertex> vertexes;
    private final List <Edge> edges;
    private Set <Vertex> unvisited;
    private Set <Vertex> visited;
   
    public DijkstraAlg(Graph graph) {
        this.vertexes = new ArrayList<Vertex>(graph.getVertexes());
        this.edges = new ArrayList<Edge>(graph.getEdges());
    }
    //evaluate vertex: start=0, other=maxvalue;
    private void evalGraph() {
        for (Vertex v : vertexes) {
            v.setVal(Integer.MAX_VALUE)
        }
    }
    
    private int getMinDist(Vertex v) {
        //TODO
    }

    private List<Vertex> getNeighbors(Vertex v) {
        //TODO
    }

    private void evalNeighbors(Vertex v) {
        List<Vertex> neighbors = getNeighbors(v);
        for (Vertex n : neighbors) {
            n.setVal( edge(v, n).getWeight() + v.getVal() )
        }

    }

    private boolean is_visited(Vertex v) {
        return this.vertexes.contains(v);
    }

    private Vertex getNearVertex(Vertex v){
        //TODO
    }
    public void execAlg(Vertex start, Vertex end) {
        unvisited = new HashSet<Vertex>();
        visited = new HashSet<Vertex>();
        evalGraph();
        start.setVal(0);
        Vertex current = new Vertex(start);
        for(Vertex v : vertexes) {
            unvisited.add(v)
        }
        while ( !is_visited(end) ) {
       // unvisited.remove(start);

            evalNeighbors(current);

            visited.add(current);
            unvisited.remove(current);
            current = new Vertex( getNearVertex(current) );
        }
    }





    }


}
