import java.util.*;

<<<<<<< HEAD:Java/homework/Vahan/Labirynth/Graph.java
/*    public int[][] distance;
=======
public class Graph {
    // AREG: start variables with lower case
    public int[] Vertexes;
    public int[][] distance;
>>>>>>> ec2aec8fa75298c8d8b2aa0aaf3299773c64093a:java/homework/Vahan/Labirynth/Graph.java
    public Graph(int numVertex) {
        distance = new int[numVertex][numVertex];
    }
    public void initializeGraph() {
        Random random = new Random();

        for( int i = 0 ; i < distance.length ; ++i ) { 
            for ( int j = 0 ; j < distance[i].length ; ++j ) {
                if (i == j){
                    distance[i][j] = 0;
                }
                else {
                distance[i][j] = random.nextInt(101);
                }
            }
        }   
    }

    public void addVertex() {
        
    }

    public void addEdge() {
        
    }    

    public void printGraph() {
        for( int[] a : distance ) { 
            System.out.println( Arrays.toString( a ));
        }
    }
*/
public class Graph {
    private final List<Vertex> vertexes;
    private final List<Edge> edges;

    public Graph(){
        
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











