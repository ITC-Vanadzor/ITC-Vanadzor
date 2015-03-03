import java.lang.Math;
import java.util.Random;

public class labirintMatrix{
	/*
		 public void labirintMatrix(){
	//TODO
	} 
	 */
	public int n = 3;
	public int size = n*n;
	public int max = n*n*n*n;
	public int[][] d = new int[size][size];
	public String[][] away = new String[size][size];
	int startI = 0;
	int startJ = 0;
	int endI = 2;
	int endJ = 2;
	Random rand = new Random();

	//Set 10 for empty values,and 0 in diagonal
	public void getStartMatrix(){
		for(int i = 0; i < size; i++ ){
			for(int j = 0; j < size; j++ ){
				if(i != j){
					d[i][j] = n*n*n;
				}else{
					d[i][j] = 0;
				}
			}
		}
	}

	//Set walls for Labirint in random coordinates
	public void setRandomWalls(){
		for(int i = 0; i < Math.floor(size/2); i++ ){
			int  numJ = rand.nextInt(size);
			int  numI = rand.nextInt(size);
			if(numI != numJ){
				d[numI][numJ] = max;
			}
		}
	}

	public void setMatrixWeight(){
		for(int i = 0; i < size; i++ ){
			if(((i + n) < size)){
				d[i][i+n] = 1;
			}
		}
		for(int i = 0; i < size; i++ ){
			if((i%n != 2) && ((i + 1) < size)){
				d[i][i+1] = 1;
			}
		}
	}

	public void algorithmFloyd(){
		for(int i = 0; i < size; i++ ){
			for(int u = 0; u < size; u++ ){
				for(int v = 0; v < size; v++ ){
					if(((d[u][i] + d[i][v]) < d[u][v]) && (d[u][v] != max))
						d[u][v] = d[u][i] + d[i][v];
				}
			}
		}
	}

	//print matrix
	public void printLabirint(){
		for(int i = 0; i < size; i++ ){
			for(int j = 0; j < size; j++ ){
				System.out.print(d[i][j]+"\t");
			}
			System.out.println();
		}
		//System.out.print(away[0][8]);
		int myI = startI * n;
		System.out.println();
		for(int j = 0; j < size; j++ ){
			if((j % n) == 0 ){
				System.out.println();
			}
			System.out.print(d[myI][j]+"\t");
		}
		System.out.println();
	}
}
