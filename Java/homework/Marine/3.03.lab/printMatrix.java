class printMatrix { 
	public static void main(String args[]) {
		int lab[] []= new int[6] [6] ;
		int i, j; 
		for(i=0; i<6; i++) { 
			for(j=0; j<6; j++) {
				lab[i] [j] = 0;  
				System.out.print(lab[i][j] + " ");
		 	}
			System.out.println() ; 
		} 
	}	 
}
