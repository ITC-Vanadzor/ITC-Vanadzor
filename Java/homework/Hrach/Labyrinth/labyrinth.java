/*
20 - wall;
19 - way;
18 - end point;
0 - start point;
-1 - shortest path;
*/
class Labyrinth {
	final static int c = 4;//columns
	final static int r = 5;//rows
	static int si, sj;//start point
	static int ei, ej;//end point
	final static int wall = r*c;
	final static int way = wall-1;
	final static int end = wall-2;
	final static int start = 0;
	final static int shortestWay = -1;
	static int[ ][ ] array = new int[r][c];
	static int k = 0;//counter for steps

	public static void main(String args[]) {
		arrayElements();
		printLabirint();
		System.out.println();
		applyLeeAlgorithm();
		labirintNormalization();
		printLabirint();
	}

	public static void arrayElements () {
		array[0][0] = way;
		array[0][1] = wall;
		array[0][2] = way;
		array[0][3] = way;
		array[1][0] = way;
		array[1][1] = start;
		si = 1;
		sj = 2;
		array[1][2] = way;
		array[1][3] = wall;
		array[2][0] = way;
		array[2][1] = wall;
		array[2][2] = wall;
		array[2][3] = way;
		array[3][0] = way;
		array[3][1] = way;
		array[3][2] = way;
		array[3][3] = wall;
		array[4][0] = way;
		array[4][1] = way;
		array[4][2] = end;
		ei = 4;
		ej = 2;
		array[4][3] = way;
	}

	public static void printLabirint () {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void applyLeeAlgorithm () {
		while (true) {
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (array[i][j]==k){
						if (i-1 > -1) {
							if (array[i-1][j] == end) {
								return;
							} else if (array[i-1][j] == way) {
								array[i-1][j] = k+1;
							}
						}

						if (j-1 > -1) {
							if (array[i][j-1] == end) {
								return;
							} else if (array[i][j-1] == way) {
								array[i][j-1] = k+1;
							}
						}

						if (i+1 < r) {
							if (array[i+1][j] == end) {
								return;
							} else if (array[i+1][j] == way) {
								array[i+1][j] = k+1;
							}
						}

						if (j+1 < c) {
							if (array[i][j+1] == end) {
								return;
							} else if (array[i][j+1] == way) {
								array[i][j+1] = k+1;
							}
						}
					}
				}
			}
			k++;
		}
	}

	public static void labirintNormalization () {//transform labirint to orogonal form and indicates the shortest path
		int i = ei;
		int j = ej;
		while (k > start) {
			if (i-1 > -1 && array[i-1][j] == k) {
				array[i-1][j] = shortestWay;
				i--;
			} else if (j-1 > -1 && array[i][j-1] == k) {
				array[i][j-1] = shortestWay;
				j--;
			} else if (i+1 < r && array[i+1][j] == k) {
				array[i+1][j] = shortestWay;
				i++;
			} else if (j+1 < c && array[i][j+1] == k) {
				array[i][j+1] = shortestWay;
				j++;
			}
		k--;
		}

		for (i = 0; i < r; i++) {
			for (j = 0; j < c; j++) {
				if(array[i][j] > start && array[i][j] < end) {
					array[i][j] = way;
				}
			}
		}
	}
}
