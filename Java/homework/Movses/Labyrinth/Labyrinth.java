// AREG -> write yourself ;)
// AREG: split the code into separate classes
public class Labyrinth {
    // AREG: use constants for 20, 19
    public static int matrix[][] = {
            { 0, 20, 20, 19, 19 },
            { 19, 19, 20, 19, 20 },
            { 20, 19, 20, 19, 20 },
            { 19, 19, 19, 19, 19 },
            { 20, 20, 19, 20, 18 }
         };
    public static void main(String[] args) {
        boolean stop;
        int dx[] = {1,0,-1,0};
        int dy[] = {0,1,0,-1};
        int d = 0;
        // AREG: find the matrix widht / height dynamically
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){ 
                matrix[i][j]=-3;
                matrix[0][j]=-1;
                matrix[4][j]=-1;
            }
            matrix[i][0]=-1;
            matrix[i][4]=-1;
        } 

        
        matrix[1][1]=0;
        do{
            stop=true;
            for(int y = 0; y<5;++y)
                for(int x = 0; x<5;++x)
                    if (matrix[y][x]==d)
                    {
                        for (int k = 0; k<4; k++)
                            if (matrix[y+dy[k]][x+dx[k]]==-3){
                                stop=false;
                                matrix[y+dy[k]][x+dx[k]] = d+1;
                            }
                    }
            d++;
        } while (!stop && matrix[3][3]==-3);
        for(int i=0; i<5; i++){      
            for(int j=0; j<5; j++)
                System.out.print(matrix[i][j]);
            System.out.println();
        }
    }
}

