import java.util.*;

public class Graph {
    public int[] Vertexes;
    public int[][] distance;
    public Graph(int numVertex) {
        Vertexes = new int[numVertex];
        distance = new int[numVertex][numVertex];
    }
    public void initializeGraph() {
        Vertexes[0] = 0;
        Random random = new Random();
        for ( int i = 1; i < Vertexes.length; ++i ) {
            Vertexes[i] = Integer.MAX_VALUE;
        }

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

    public void printGraph() {
        for( int[] a : distance ) { 
            System.out.println( Arrays.toString( a ));
        }
    }

}











