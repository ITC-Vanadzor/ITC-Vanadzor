/*
20 - wall;
19 - way;
18 - end point;
0 - start point;
-1 - shortest path;
*/
class labirint {
	static int c = 4;//columns
	static int r = 5;//rows
	static int si, sj;//start point
	static int ei, ej;//end point
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
		array[0][0] = 19;
		array[0][1] = 20;
		array[0][2] = 19;
		array[0][3] = 19;
		array[1][0] = 19;
		array[1][1] = 0;
		si = 1;
		sj = 2;
		array[1][2] = 19;
		array[1][3] = 20;
		array[2][0] = 19;
		array[2][1] = 19;
		array[2][2] = 19;
		array[2][3] = 20;
		array[3][0] = 19;
		array[3][1] = 19;
		array[3][2] = 19;
		array[3][3] = 20;
		array[4][0] = 19;
		array[4][1] = 19;
		array[4][2] = 18;
		ei = 4;
		ej = 2;
		array[4][3] = 19;
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
		while (k < 20) {
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (array[i][j]==k){
						if (i-1 > -1) {
							if (array[i-1][j] == 18) {
								return;
							} else if (array[i-1][j] == 19) {
								array[i-1][j] = k+1;
							}
						}

						if (j-1 > -1) {
							if (array[i][j-1] == 18) {
								return;
							} else if (array[i][j-1] == 19) {
								array[i][j-1] = k+1;
							}
						}

						if (i+1 < r) {
							if (array[i+1][j] == 18) {
								return;
							} else if (array[i+1][j] == 19) {
								array[i+1][j] = k+1;
							}
						}

						if (j+1 < c) {
							if (array[i][j+1] == 18) {
								return;
							} else if (array[i][j+1] == 19) {
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
		while (k>0) {
			if (i-1 > -1 && array[i-1][j] == k) {
				array[i-1][j] = -1;
				i--;
			} else if (j-1 > -1 && array[i][j-1] == k) {
				array[i][j-1] = -1;
				j--;
			} else if (i+1 < r && array[i+1][j] == k) {
				array[i+1][j] = -1;
				i++;
			} else if (j+1 < c && array[i][j+1] == k) {
				array[i][j+1] = -1;
				j++;
			}
		k--;
		}

		for (i = 0; i < r; i++) {
			for (j = 0; j < c; j++) {
				if(array[i][j] > 0 && array[i][j] < 18) {
					array[i][j] = 19;
				}
			}
		}
	}
}
