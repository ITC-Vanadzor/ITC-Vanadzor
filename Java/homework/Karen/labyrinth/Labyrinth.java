import java.lang.Math;
import java.util.Random;
import java.util.Scanner;

public class Labyrinth{

	Random rand = new Random();
	Scanner in = new Scanner(System.in);
	final int labyrinthSize = 7;
	final int grafMatrixSize = labyrinthSize * labyrinthSize;
	final int maxInt = Integer.MAX_VALUE/2;
	final int startValue = Integer.MAX_VALUE/3;
	int[][] labyrinthGrafWeights = new int[grafMatrixSize][grafMatrixSize];
	int[][] labyrinth = new int[labyrinthSize][labyrinthSize];
	int end;
	int start;

	/*
	 public Labyrinth(){
		 readLabyrinthSize();
	 } 
	
	public void readLabyrinthSize(){
		System.out.println("Please set labyrinth size like this: 3 < labyrinthSize < 10 ");
		labyrinthSize = in.nextInt();
	}
	*/

	//Set startValue for empty values,and 0 in diagonal
	void initializeGraphMatrix(){
		for(int i = 0; i < grafMatrixSize; ++i ){
			for(int j = 0; j < grafMatrixSize; ++j ){
				if(i != j){
					labyrinthGrafWeights[i][j] = startValue;
				}else{
					labyrinthGrafWeights[i][j] = 0;
				}
			}
		}
	}

	//Set walls for Labyrinth in random coordinates
	void generateRandomWalls(){
		for(int i = 0; i < Math.floor(grafMatrixSize/3); ++i ){
			int  wallNumber = rand.nextInt(grafMatrixSize);
			for(int k = 0; k < grafMatrixSize; ++k){
				setVerticesWeight(k, wallNumber, maxInt);
			}
		}
	}

	void insertNeighbourEdgeWeights(){
		for(int i = 0; i < grafMatrixSize; ++i ){
			if(((i + labyrinthSize) < grafMatrixSize)){
				setVerticesWeight(i, i + labyrinthSize, 1 );
			}
			if((i%labyrinthSize != (labyrinthSize - 1)) && ((i + 1) < grafMatrixSize)){
				setVerticesWeight(i, i + 1, 1 );
			}
		}
	}

	void applyAlgorithmFloyd(){
		for(int i = 0; i < grafMatrixSize; ++i ){
			for(int u = 0; u < grafMatrixSize; u++ ){
				for(int v = 0; v < grafMatrixSize; v++ ){
					if(((labyrinthGrafWeights[u][i] + labyrinthGrafWeights[i][v]) < labyrinthGrafWeights[u][v]) && (labyrinthGrafWeights[u][v] != maxInt))
						labyrinthGrafWeights[u][v] = labyrinthGrafWeights[u][i] + labyrinthGrafWeights[i][v];
				}
			}
		}
	}

	//Get start and end random
	void generateRandomStartAndEnd(){
		do{
			start	= rand.nextInt(grafMatrixSize - 1);
			end	= rand.nextInt(grafMatrixSize - 1);
		}
		while((start == end) || (labyrinthGrafWeights[start][end] == maxInt));
	}

	void setVerticesWeight(int i, int j, int weight) {
		labyrinthGrafWeights[i][j] = weight;
		labyrinthGrafWeights[j][i] = weight;
	}

	public void computePaths(){
		initializeGraphMatrix();
		insertNeighbourEdgeWeights();
		generateRandomWalls();
		generateRandomStartAndEnd();
		applyAlgorithmFloyd();
	}

	//print matrix
	public void printLabyrinthMatrix(){
		for(int i = 0; i < grafMatrixSize; ++i ){
			for(int j = 0; j < grafMatrixSize; ++j ){
				System.out.print(labyrinthGrafWeights[i][j] + "\t");
			}
			System.out.println();
		}
	}

	//print Labyrinth
	public void printLabyrinth(){
		computeLabyrinthWays();
		String[][] showPath = getLabyrinthFinished();

		for(int i = 0; i < labyrinthSize; ++i ){
			for(int j = 0; j < labyrinthSize; ++j ){
				System.out.print(showPath[i][j] + " - " + (i * labyrinthSize + j)  + "\t");
			}
			System.out.println();
		}

		System.out.println();
		for(int i = 0; i < labyrinthSize; ++i ){
			for(int j = 0; j < labyrinthSize; ++j ){
				System.out.print(showPath[i][j]);
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println("Start = " + start);
		System.out.println("End = " + end);
		System.out.println("* - possible ways ");
		System.out.println("# - walls ");
	}

	String[][] getLabyrinthFinished(){
		String[][] showPath = new String[labyrinthSize][labyrinthSize];
		int endI = end/labyrinthSize;
		int endJ = end % labyrinthSize;
		int startI = start/labyrinthSize;
		int startJ = start % labyrinthSize;
		int loopStep = 0;
		showPath[endI][endJ] = Integer.toString(labyrinth[endI][endJ]) + " ";

		do{
			int[] neighbourEdge = getMinNeighbourEdge(endI, endJ);
			endI = neighbourEdge[0];
			endJ = neighbourEdge[1];
			showPath[endI][endJ] = Integer.toString(labyrinth[endI][endJ]) + " ";
			if(loopStep > grafMatrixSize ){
				System.out.println("NOT away from " + start + " to " + end + "!!!");
				break;
			}
			++loopStep;
		}while(labyrinth[endI][endJ] > 0);

		for(int i = 0; i < labyrinthSize; ++i ){
			for(int j = 0; j < labyrinthSize; ++j ){
				if(labyrinth[i][j] == maxInt){
					showPath[i][j] = "# ";
				}else if((showPath[i][j] == null) || ( labyrinth[i][j] == startValue)){
					showPath[i][j] = "* ";
				}
			}
		}
		return showPath;
	}

	void computeLabyrinthWays(){
		int i =  - 1;
		for(int j = 0; j < grafMatrixSize; ++j ){
			if((j % labyrinthSize) == 0 ){
				++i;
			}
			labyrinth[i][j % labyrinthSize] = labyrinthGrafWeights[start][j];
		}
	}

	int[] getMinNeighbourEdge(int i, int j){
		int [] minNeighbourEdge = new int [3];
		int minimum = maxInt;
		if((i > 0) && (labyrinth[i - 1][j] < minimum)){
			minimum = labyrinth[i - 1][j];
			minNeighbourEdge[0] = i - 1;
			minNeighbourEdge[1] = j;
		}
		if((j > 0) && (labyrinth[i][j - 1] < minimum)){
			minimum = labyrinth[i][j - 1];
			minNeighbourEdge[0] = i;
			minNeighbourEdge[1] = j - 1;
		}
		if(((i + 1) < labyrinthSize) && (labyrinth[i + 1][j] < minimum)){
			minimum = labyrinth[i + 1][j];
			minNeighbourEdge[0] = i + 1;
			minNeighbourEdge[1] = j;
		}
		if((j + 1 < labyrinthSize) && (labyrinth[i][j + 1] < minimum)){
			minimum = labyrinth[i][j + 1];
			minNeighbourEdge[0] = i;
			minNeighbourEdge[1] = j + 1;
		}
		minNeighbourEdge[2] = minimum;
		return minNeighbourEdge;
	}
}
