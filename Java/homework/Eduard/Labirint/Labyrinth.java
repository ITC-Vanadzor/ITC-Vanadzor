import java.lang.Math;

public class Labyrinth {

    public static void main(String[] args) {
        int[ ][ ] matrix = new int[8][12];
        int rows = 8;
        int columns = 12;
        public static int xStart = 1;		//starting x coordinate
        public static int yStart = 1;		//starting y coordinate
        public static int xEnd = 5;
        public static int yEnd = 9;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++){
                matrix[0][4] = 666;			//all 666 are barriers
                matrix[1][4] = 666;
                matrix[3][4] = 666;
                matrix[4][4] = 666;
                matrix[4][5] = 666;	
                matrix[5][1] = 666;	
                matrix[4][7] = 666;	
                matrix[5][7] = 666;	
                matrix[3][9] = 666;	
                matrix[xEnd][yEnd] = 1000;		//end coordinate
                System.out.print(matrix[i][j]);
            }

            System.out.println();
        }

    }
    public static void tide(int x, int y) {
        if (matrix[x][y - 1] != 666 && Math.abs(matrix[x][y] - matrix[x][y - 1]) != 1) { 		//go to the left
            if (matrix[x][y - 1] != 1000) {
                matrix[x][y - 1] = matrix[x][y] + 1;
            } else {
                backWay(x,y - 1);
            }
        } 			
        if (matrix[x][y + 1] != 666 && Math.abs(matrix[x][y] - matrix[x][y + 1]) != 1) {		//go to the right
            if (matrix[x][y + 1] != 1000) {
                matrix[x][y + 1] = matrix[x][y] + 1;
            } else {
                backWay(x,y + 1);
            }
        } 			
        if (matrix[x + 1][y] != 666 && Math.abs(matrix[x][y] - matrix[x + 1][y]) != 1) {		//go to up
            if (matrix[x + 1][y] != 1000) {
                matrix[x + 1][y] = matrix[x][y] + 1;
            } else {
                backWay(x + 1,y);
            }
        } 			
        if (matrix[x - 1][y] != 666 && Math.abs(matrix[x][y] - matrix[x - 1][y]) != 1) {		//go to down
            if (matrix[x - 1][y] != 1000) {
                matrix[x - 1][y] = matrix[x][y] + 1;
            } else {
                backWay(x - 1,y);
            }
        } 			

    }
    public static backWay(xEnd, yEnd) {
        if (matrix[xEnd][yEnd] != 0) {
            if (matrix[xEnd][yEnd] - matrix[xEnd][yEnd + 1] == 1) {
                return backWay(xEnd, yEnd + 1);
            } else 
                if (matrix[xEnd][yEnd] - matrix[xEnd][yEnd - 1] == 1) {
                    return backWay(xEnd, yEnd - 1);
                } else 
                    if (matrix[xEnd][yEnd] - matrix[xEnd + 1][yEnd] == 1) {
                        return backWay(xEnd + 1, yEnd);
                    } else 
                        if (matrix[xEnd][yEnd] - matrix[xEnd - 1][yEnd] == 1) {
                            return backWay(xEnd - 1, yEnd);
                        }
        }  else {
            return "Path successfully founded";
        }

    }	

} 
