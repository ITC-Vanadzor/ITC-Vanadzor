public class Labyrinth {
    public static final int N = 5;
    public static void main(String[] args) {
        String [][] matrix = {
            { "S", "#", "#", ".", "F" },
            { ".", "#", ".", ".", "#" },
            { ".", ".", "#", ".", "#" },
            { ".", ".", ".", ".", "#" },
            { "#", "#", ".", "#", "." }
        };
        int i; 
        int j;

        for(i=0; i<N; i++) {
            for(j=0; j<N; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }
}
