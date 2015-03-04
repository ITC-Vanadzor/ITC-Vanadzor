import java.lang.Math;
import java.util.Random;

// AREG: Pls change class names to start with capital letters
// AREG: better to have a setter function for graph weight matrix like this
// void setVerticesWeight(int i, int j, int weight) {
//  weights[i][j] = weight;
//  weights[j][i] = weight;
// }
public class Labyrinth{
	/*
		 public void labirintMatrix(){
	//TODO
    // AREG: pls put explicit descriptions in comments and TODOs
	} 
	 */
    // AREG: use "final" for constants
    // AREG: follow up on :fields initialization" email
	Random rand = new Random();
	int n 			= 4;
    // AREG: rename to something better
	int size 		= n*n;
    // AREG: rename to something better
	int max 		= n*n*n*n;
    // AREG: rename to something better
	int[][] d 	= new int[size][size];
	int end;
	int start;

    // AREG: use maxInt for "wall" edges cnd reflect it in the comments
	//Set 10 for empty values,and 0 in diagonal
    // AREG: change the name to somethign like "initializeGraphMatrix"
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
		for(int i = 0; i < Math.floor(size/1); i++ ){
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
			if((i%n != (n-1)) && ((i + 1) < size)){
				d[i][i+1] = 1;
			}
		}
	}

	public void algorithmFloyd(){
		matrixMakeSymmetrical();
		for(int i = 0; i < size; i++ ){
			for(int u = 0; u < size; u++ ){
				for(int v = 0; v < size; v++ ){
					if(((d[u][i] + d[i][v]) < d[u][v]) && (d[u][v] != max))
						d[u][v] = d[u][i] + d[i][v];
				}
			}
		}
	}

	//Get start and end random
    // AREG: better to hprovide start and end frpom the outside 
	void getStartAndEnd(){
		do{
			start	= rand.nextInt(size-1);
			end	= rand.nextInt(size-1);
		}
		while((start >= end) || (d[start][end] == max));
	}

	//print matrix
	public void printLabirintMatrix(){
		for(int i = 0; i < size; i++ ){
			for(int j = 0; j < size; j++ ){
				System.out.print(d[i][j]+"\t");
			}
			System.out.println();
		}
	}

	public void matrixMakeSymmetrical(){
		for(int i = 0; i < size; i++ ){
			for(int j = i; j < size; j++ ){
				d[j][i] = d[i][j];
			}
		}
	}

	//print Labirint
    // AREG: separate labyrinth creation and printing
	public void printLabirint(){
		int[][] labirint = new int[n][n];
		int i = -1;
		System.out.println();
		for(int j = 0; j < size; j++ ){
			if((j % n) == 0 ){
				System.out.println();
				i++;
			}
			labirint[i][j%n] = d[start][j];
			System.out.print(d[start][j]+"("+j+")"+"\t");
		}
		
		for(i = 0; i < n; i++ ){
			for(int j = i; j < n; j++ ){
				//labirint[][]
			}
		}

		System.out.println();
		System.out.println("Start = " + start);
		System.out.println("End = " + end);
	}
}
