import java.util.Stack;
import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args){
        Maze mymaze = new Maze();
        mymaze.printMaze();
        Coord start = setStartCoord(mymaze.getMaze());
        Coord end  = setEndCoord(mymaze.getMaze());
        System.out.println("aaaaa  "+start.getX());
        mymaze.setElement(start.getX(),start.getY(),0);
        Stack <Coord> path = new Stack<>();
        if(mymaze.findShortPath(start, end,0) != 0){
           int dist = mymaze.findShortPath(start,end,0);
           System.out.println(dist);
           mymaze.printMazeAfter();
        }
        else {
            System.out.println("there is no path between the points you entered");
            System.exit(0);
        }
        mymaze.printMazeAfter();
        //mymaze.printPath(path);
    }

    public static Coord setStartCoord(int[][] somemaze){
        System.out.println("Please insert path's start co-ordinates");
        System.out.println("Row number: ");
        Scanner scan= new Scanner(System.in);
        int startRow= scan.nextInt();
        System.out.println("Column number: ");
        int startCol= scan.nextInt();               //TODO throw exception if input is out of bounds
        if (somemaze[startRow][startCol]==-1){
            System.out.println("["+startRow+"]["+startCol+"] is wall !!! The next time be attentive");
            System.exit(0);
        }
        Coord start = new Coord(startRow,startCol);
        return start;
    }
    public static Coord setEndCoord(int[][] somemaze){
        System.out.println("Please insert path's end  co-ordinates");
        System.out.println("Row number: ");
        Scanner scan= new Scanner(System.in);
        int endRow= scan.nextInt();
        System.out.println("Column number: ");
        int endCol= scan.nextInt();
        if (somemaze[endRow][endCol]==-1){
            System.out.println("["+endRow+"]["+endCol+"] is wall !!! The next time be attentive");
            System.exit(0);
        }
        Coord end = new Coord(endRow,endCol);
        return end;
    }
}


