import java.util.Random;
import java.lang.Object;

public class Maze {
    int[][] maze;
    public Maze(){
        maze = new int[10][10];
        for(int i=0;i<maze.length;i++){
            for(int j=0; j<maze.length; j++){
                maze[i][j] = -2;
            }
        }
        Random rand =new Random();
        for (int k=0; k<maze.length; ++k){
            int a = rand.nextInt(maze.length);
            int b = rand.nextInt(maze.length);        
            maze[a][b] = -1;
            a = rand.nextInt(maze.length);
            b = rand.nextInt(maze.length);        
            maze[a][b] = -1;
        }
    }
    public void setElement(int i, int j, int value){ maze[i][j]=value;}

    public void printMaze(){
        for(int i=0;i<maze.length;i++){
            System.out.print("   |");
            for(int j=0; j<maze[0].length; j++){
                if (maze[i][j]!=-1){
                    System.out.print(" "+"|");
                }
                else{
                    System.out.print("H"+"|");
                }
            }
            System.out.println();
        }
    }
    public void printMazeAfter(){
        for(int i=0;i<maze.length;i++){
            System.out.print("   |");
            for(int j=0; j<maze[0].length; j++){
                if (maze[i][j] !=-1 && (maze[i][j] ==-2)){
                    System.out.print("  |");
                }
                else if (maze[i][j] ==-1 ){
                    System.out.print("H "+"|");
                }
                else {
                    if (maze[i][j]/10 == 0){
                        System.out.print(maze[i][j]+" |");
                    }
                    else{
                        System.out.print(maze[i][j]+"|");
                    }
                }
            }
            System.out.println();
        }
    }
    public int[][] getMaze(){return maze;}
    
    private  boolean hasFreeNeighbour(Coord counter){
        int j=counter.getY();//right and left directions
        int i=counter.getX();//up and down directions
        if (i+1<10 && maze[i+1][j] == -2){
            return true;
        }else if((i-1) > -1 && maze[i-1][j] == -2){
            return true;
        }else if ((j+1)<10 && maze[i][j+1] == -2){
            return true;
        }else if ((j-1)>-1 && maze[i][j-1] == -2){
            return true;
        }
        return false;
    }

    public int findShortPath(Coord start, Coord end,int level){
        int i = start.getX();
        int j = start.getY();

        level +=1;
        if ((j+1)<10 && maze[i][j+1] == -2){
            maze[i][j+1]=level;
            Coord newStart = new Coord(i, j+1, level);
            findShortPath(newStart,end, level);
        }else
        if (i+1<10 && maze[i+1][j] == -2){
            maze[i+1][j]=level;
            Coord newStart = new Coord(i+1, j, level);
            findShortPath(newStart,end, level);
        }else 
        if ((j-1)>-1 && maze[i][j-1] == -2){
            maze[i][j-1]=level;
            Coord newStart = new Coord(i, j-1, level);
            findShortPath(newStart,end, level);
        }else 
        if((i-1) > -1 && maze[i-1][j] == -2){
            maze[i-1][j]=level;
            Coord newStart = new Coord(i-1, j, level);
            findShortPath(newStart,end, level);
        }
        if(i==end.getX() && j == end.getY()){
            return maze[end.getX()][end.getY()];
        }
        return level;
    }
       /*// else if(end.getLevel() == -2 && (!hasFreeNeighbour(start))){
         //  return 0;
       // }
        else{
            level +=1;
            Coord newStart;
            if (i+1<10 && maze[i+1][j] == -2){
                maze[i+1][j]=level;
                newStart = new Coord(i+1, j, level);
                findShortPath(newStart,end, level);
            }else if((i-1) > -1 && maze[i-1][j] == -2){
                maze[i-1][j]=level;
                newStart = new Coord(i-1, j, level);
                findShortPath(newStart,end, level);
            }else if ((j+1)<10 && maze[i][j+1] == -2){
                maze[i][j+1]=level;
                newStart = new Coord(i, j+1, level);
                findShortPath(newStart,end, level);
            }else if ((j-1)>-1 && maze[i][j-1] == -2){
                maze[i][j-1]=level;
                newStart = new Coord(i, j-1, level);
                findShortPath(newStart,end, level);
            }
            //else {
              //  System.out.println("unpredicted error, should be handled ");
               // return 0;
           // }
        return findShortPath(newStart,end, level);    
        }         
    }*/
}

