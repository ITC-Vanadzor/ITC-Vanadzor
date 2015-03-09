
public class Edge {
    private final String id;
    private final Vertex v1;
    private final Vertex v2;
    private final int weight;

    public Edge(String id, Vertex vertex1, Vertex vertex2, int weight) {
        this.id = id;
        this.v1 = vertex1;
        this.v2 = vertex2;
        this.weight = weight;
    }

    public Edge(Vertex vertex1, Vertex vertex2) {
        this.v1 = vertex1;
        this.v2 = vertex2;
    }
    

    public int getWeight() {
        return this.weight;
    }
}
