public class printLabirint{

	public static void main(String[] args){
		labirintMatrix obj = new labirintMatrix();
		obj.getStartMatrix();
		obj.setMatrixWeight();
		obj.setRandomWalls();
		obj.algorithmFloyd();
		obj.printLabirint();
	}
}
