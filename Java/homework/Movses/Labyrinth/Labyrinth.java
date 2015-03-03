/*public class Labyrinth {
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
}*/
public class Labyrinth {
    public static int [][] pole = {
            { 5, 1, 1, 0, 0 },
            { 0, 1, 0, 0, 1 },
            { 0, 0, 1, 0, 1 },
            { 0, 0, 0, 0, 0 },
            { 1, 1, 0, 1, 8 }
         };
    public static void main(String[] args) {
        boolean stop;
        int dx[] = {1,0,-1,0};
        int dy[] = {0,1,0,-1};
        int d = 0;
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){ 
                pole[i][j]=-2;
                pole[0][j]=-1;
                pole[4][j]=-1;
            }
            pole[i][0]=-1;
            pole[i][4]=-1;
        }
        pole[1][1]=0;
        do{
            stop=true;
            for(int y = 0; y<5;++y)
                for(int x = 0; x<5;++x)
                    if (pole[y][x]==d)
                    {
                        for (int k = 0; k<4; ++k)
                            if (pole[y+dy[k]][x+dx[k]]==-2){
                                stop=false;
                                pole[y+dy[k]][x+dx[k]] = d+1;
                            }
                    }
            d++;
        } while (!stop && pole[4][4]==-2);
        for(int i=0; i<5; i++){      
            for(int j=0; j<5; j++)
                System.out.print(pole[i][j]);
            System.out.println();
        }
    }
}

