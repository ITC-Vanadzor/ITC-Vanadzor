import java.lang.Math;

public class Labyrinth {

    static int[ ][ ] matrix = new int[8][12];
    final static int rows = 8;
    final static int columns = 12;
    final static int xStart = 1;		//starting x coordinate
    final static int yStart = 1;		//starting y coordinate
    final static int xEnd = 5;
    final static int yEnd = 9;

    public static void main(String[] args) {
        creatingLabyrinth();
        searchWithTide(xStart, yStart);
    }

    public static void creatingLabyrinth() {
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
                System.out.print("     ");
            }

            System.out.println();
        }
    }    


    //----------------------Verevi kod@ ashxatoxa------------------------------------------------------------	

    public static searchWithTide(int x, int y) {
        if (matrix[x][y] != 1000) {
            if (matrix[x][y - 1] != 666 && Math.abs(matrix[x][y] - matrix[x][y - 1]) != 1 && matrix[x][y - 1] != 1000 ) { 		//go to the left

                matrix[x][y - 1] = matrix[x][y] + 1;
                y = y - 1;
                x = x;
                return searchWithTide(a,y);
            }


            if (matrix[x][y + 1] != 666 && Math.abs(matrix[x][y] - matrix[x][y + 1]) != 1 && matrix[x][y + 1] != 1000) {		//go to the right
                matrix[x][y + 1] = matrix[x][y] + 1;
                y = y + 1;
                x = x;
                return searchWithTide(x,y);
            } 			
            if (matrix[x + 1][y] != 666 && Math.abs(matrix[x][y] - matrix[x + 1][y]) != 1 && matrix[x + 1][y] != 1000) {		//go to up
                matrix[x + 1][y] = matrix[x][y] + 1;
                x = x +1;
                y = y;
                return searchWithTide(x,y);
            } 			
            if (matrix[x - 1][y] != 666 && Math.abs(matrix[x][y] - matrix[x - 1][y]) != 1 && matrix[x - 1][y] != 1000) {		//go to down
                matrix[x - 1][y] = matrix[x][y] + 1;
                x = x - 1;
                y = y;
                return searchWithTide(a,y);
            } 
        } else {
            return System.out.println("EXAVVVVV");
        }
        //---------------verevi mas@ indz tvuma fsyo tki algoritms sxal kashxati, aranc nerqevi kodi vor compile em anum mihat errora talis chem tenum vonca ashxatum---

        public static backWay(int xEnd, int yEnd) {
            if (matrix[xEnd][yEnd] != 0) {
                if (matrix[xEnd][yEnd] - matrix[xEnd][yEnd + 1] == 1) {
                    matrix[xEnd][yEnd] = 0;
                    return backWay(xEnd, yEnd + 1);
                } else 
                    if (matrix[xEnd][yEnd] - matrix[xEnd][yEnd - 1] == 1) {
                        matrix[xEnd][yEnd] = 0;
                        return backWay(xEnd, yEnd - 1);
                    } else 
                        if (matrix[xEnd][yEnd] - matrix[xEnd + 1][yEnd] == 1) {
                            matrix[xEnd][yEnd] = 0;
                            return backWay(xEnd + 1, yEnd);
                        } else 
                            if (matrix[xEnd][yEnd] - matrix[xEnd - 1][yEnd] == 1) {
                                matrix[xEnd][yEnd] = 0;
                                return backWay(xEnd - 1, yEnd);
                            }
            }  else {
                return "Path successfully founded";
            }


        }
    } 
