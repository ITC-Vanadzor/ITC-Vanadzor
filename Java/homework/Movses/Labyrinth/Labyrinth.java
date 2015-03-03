public class Labyrinth {
    public static final int N = 4;
    public static void main(String[] args) {
        String [][] m = {
            { ".", "#", ".", "." },
            { ".", "#", ".", "#" },
            { ".", ".", ".", "#" },
            { "#", "#", ".", "." }
        };
        int i, j;

        for(i=0; i<N; i++) {
            for(j=0; j<N; j++)
                System.out.print(m[i][j] + " ");
            System.out.println();
        }
