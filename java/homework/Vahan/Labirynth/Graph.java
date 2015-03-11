import java.util.*;

public class Graph {
    private final List<Vertex> vertexes;
    private final List<Edge> edges;

    public Graph(List<Vertex> vertexes, List<Edge> edges) {
        this.vertexes = new ArrayList<Vertex> vertexes;
        this.edges = new ArrayList<Edge> edges;
    }
    
    public List<Vertex> getVertexes() {
        return this.vertexes;
    }

    public List<Edge> getEdges() {
        return this.edges;
    }
    public void addEdge(Vertex v1, Vertex v2, int weight) {
       //TODO 
    }
}











