
public class Edge {
    private final String id;
    private final Vertex dest;
    private final Vertex target;
    private final int weight;

    public Edge(String id, Vertex vertex1, Vertex vertex2, int weight) {
        this.id = id;
        this.dest = vertex1;
        this.target = vertex2;
        this.weight = weight;
    }

    public String getId() {
        return this.id;
    }

    public Vertex getDest() {
        return this.dest;
    }

    public Vertex getTarget() {
        return this.target;
    }
    public int getWeight() {
        return this.weight;
    }
}
