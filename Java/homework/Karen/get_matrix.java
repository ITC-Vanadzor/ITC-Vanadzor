public class get_matrix{
	public int n = 3;
	public int size = n*n;
	public int max = 1000;
	public int[][] d = new int[size][size];

	public int[][] get_start_matrix(){
		for(int i = 0; i < size; i++ ){
			for(int j = 0; j < size; j++ ){
				d[i][j] = 10;
			}
		}
		return d;
	}

	public int[][] set_random_walls(int number){
		d = get_start_matrix();
        /*
		for(int i = 0; i < math.floor(number/2); i++ ){
			int  numJ = rand.nextInt(number);
			int  numI = rand.nextInt(number);
			d[numI][numJ] = max;
		}
        */
		return d;
	}
/*
	public int[][] set_matrix_weight(){
		for(int i = 0; i < size; i++ ){
			for(int j = 0; j < size; j++ ){
				if(((i + n) < size))
				d[i][j];
			}
		}
		return d;
	}
*/
	//print matrix
	public void print_matrix(){
		d = set_random_walls(n-1);
		String strMatr = "";
		for(int i = 0; i < size; i++ ){
			for(int j = 0; j < size; j++ ){
				strMatr += d[i][j] + "\t";
			}
			strMatr += "\n";
		}
		System.out.println(strMatr);
	}
}
