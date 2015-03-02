public class CreatingLabirint {

		public static void main(String[] args) {
				int[ ][ ] aryNumbers = new int[6][5];
				int rows = 6;
				int columns = 5;
				int i,j;
				for (i = 0; i < rows; i++) {
						for (j = 0; j < columns; j++){
								aryNumbers[i][j] = 0;
								aryNumbers[0][0] = 1;
								aryNumbers[3][1] = 1;
								aryNumbers[2][4] = 1;
								aryNumbers[0][3] = 1;
								aryNumbers[4][1] = 1;
								aryNumbers[1][4] = 2;	
								aryNumbers[5][0] = 2;	
								System.out.print(aryNumbers[i][j]);
						}

						System.out.println();
				}

		}
} 
