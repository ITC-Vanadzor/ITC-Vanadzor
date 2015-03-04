import java.lang.Math;
import java.util.Random;

// AREG: Pls change class names to start with capital letters
// AREG: better to have a setter function for graph weight matrix like this

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
	int n 			= 5;
    // AREG: rename to something better
	int size 		= n*n;
    // AREG: rename to something better
	int max 		= Integer.MAX_VALUE/2;
	int startValue  = Integer.MAX_VALUE/3;
    // AREG: rename to something better
	int[][] labyrinthGrafWeights 	= new int[size][size];
	int[][] labyrinth 	= new int[n][n];
	int end;
	int start;

    // AREG: use maxInt for "wall" edges cnd reflect it in the comments
	//Set 10 for empty values,and 0 in diagonal
    // AREG: change the name to somethign like "initializeGraphMatrix"
	public void getStartMatrix(){
		for(int i = 0; i < size; ++i ){
			for(int j = 0; j < size; ++j ){
				if(i != j){
					labyrinthGrafWeights[i][j] = startValue;
				}else{
					labyrinthGrafWeights[i][j] = 0;
				}
			}
		}
	}

	//Set walls for Labirint in random coordinates
	public void setRandomWalls(){
		for(int i = 0; i < Math.floor(size/3); ++i ){
			int  wallNumber = rand.nextInt(size);
			for(int k = 0; k < size; ++k){
				setVerticesWeight(k, wallNumber, max);
			}
		}
	}

	public void setMatrixWeight(){
		for(int i = 0; i < size; ++i ){
			if(((i + n) < size)){
				setVerticesWeight(i, i + n, 1 );
			}
		}
		for(int i = 0; i < size; ++i ){
			if((i%n != (n-1)) && ((i + 1) < size)){
				setVerticesWeight(i, i + 1, 1 );
			}
		}
	}

	public void algorithmFloyd(){
		for(int i = 0; i < size; ++i ){
			for(int u = 0; u < size; u++ ){
				for(int v = 0; v < size; v++ ){
					if(((labyrinthGrafWeights[u][i] + labyrinthGrafWeights[i][v]) < labyrinthGrafWeights[u][v]) && (labyrinthGrafWeights[u][v] != max))
						labyrinthGrafWeights[u][v] = labyrinthGrafWeights[u][i] + labyrinthGrafWeights[i][v];
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
		while((start >= end) || (labyrinthGrafWeights[start][end] == max));
	}

	void setVerticesWeight(int i, int j, int weight) {
		labyrinthGrafWeights[i][j] = weight;
		labyrinthGrafWeights[j][i] = weight;
	}

	//print matrix
	public void printLabirintMatrix(){
		for(int i = 0; i < size; ++i ){
			for(int j = 0; j < size; ++j ){
				System.out.print(labyrinthGrafWeights[i][j]+"\t");
			}
			System.out.println();
		}
	}

	//print Labirint
	public void printLabirint(){
		computeLabyrinthWays();
		String[][] newLabyrinth = getLabyrinthFinished();
		
		System.out.println("Start = " + start);
		System.out.println("End = " + end);

		for(int i = 0; i < n; ++i ){
			for(int j = 0; j < n; ++j ){
				System.out.print(newLabyrinth[i][j] + "-" + (i * n + j)  + "\t");
			}
			System.out.println();
		}

		for(int i = 0; i < n; ++i ){
			for(int j = 0; j < n; ++j ){
				System.out.print(newLabyrinth[i][j]);
			}
			System.out.println();
		}
	}

	String[][] getLabyrinthFinished(){
		String[][] newLabyrinth = new String[n][n];
		int endI = end/n;
		int endJ = end % n;
		int startI = start/n;
		int startJ = start % n;
		newLabyrinth[endI][endJ] = Integer.toString(labyrinth[endI][endJ]);
		int loopStep = 0;

		do{
			int[] neighbour = getMinNeighbour(endI, endJ);
			endI = neighbour[0];
			endJ = neighbour[1];
			newLabyrinth[endI][endJ] = Integer.toString(labyrinth[endI][endJ]);
			if(loopStep > size ){
				System.out.println("NOT away from " + start + " to " + end + "!!!");
				break;
			}
			++loopStep;
		}while(labyrinth[endI][endJ] > 0);

		for(int i = 0; i < n; ++i ){
			for(int j = 0; j < n; ++j ){
				if(labyrinth[i][j] == max){
					newLabyrinth[i][j] = "#";
				}else if((newLabyrinth[i][j] == null) || ( labyrinth[i][j] == startValue)){
					newLabyrinth[i][j] = "*";
				}
			}
		}
		return newLabyrinth;
	}

	void computeLabyrinthWays(){
		int i = -1;
		for(int j = 0; j < size; ++j ){
			if((j % n) == 0 ){
				++i;
			}
			labyrinth[i][j % n] = labyrinthGrafWeights[start][j];
		}
	}

	int[] getMinNeighbour(int i, int j){
		int [] minNeighbour = new int [3];
		int minimum = max;
		if((i > 0) && (labyrinth[i - 1][j] < minimum)){
			minimum = labyrinth[i - 1][j];
			minNeighbour[0] = i - 1;
			minNeighbour[1] = j;
		}
		if((j > 0) && (labyrinth[i][j - 1] < minimum)){
			minimum = labyrinth[i][j - 1];
			minNeighbour[0] = i;
			minNeighbour[1] = j - 1;
		}
		if(((i + 1) < n) && (labyrinth[i + 1][j] < minimum)){
			minimum = labyrinth[i + 1][j];
			minNeighbour[0] = i + 1;
			minNeighbour[1] = j;
		}
		if((j + 1 < n) && (labyrinth[i][j + 1] < minimum)){
			minimum = labyrinth[i][j + 1];
			minNeighbour[0] = i;
			minNeighbour[1] = j + 1;
		}
		minNeighbour[2] = minimum;
		return minNeighbour;
	}
}
