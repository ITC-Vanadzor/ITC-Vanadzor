import java.util.Stack;

public class Main
{
    public static int findpath(int[][] maze, Coord pos_start, Coord pos_fin){
        Stack <Coord> pos = new Stack<>();
        

    }
    public static void main(String[] args){
        int[][] maze= { {0,0,1,0,0},
                        {0,1,1,1,1},
                        {0,1,0,0,0},
                        {0,1,0,1,0},
                        {0,0,0,1,0}};
        for(int i=0;i<maze.length;i++){
            for(int j=0; j<maze.length; j++){
                System.out.print(maze[i][j]+"|");
            }
            System.out.println();
        }
       System.out.println("path start is matrix's (0,0) posision");
       System.out.println("path end is matrix's (4,4) posision");
    }
    findpath(maze, maze[0][0],maze[4][4]);
}
