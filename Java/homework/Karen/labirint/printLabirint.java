public class printLabirint{

	public static void main(String[] args){
		labirintMatrix obj = new labirintMatrix();
		obj.getStartMatrix();
		obj.setMatrixWeight();
		obj.setRandomWalls();
		obj.getStartAndEnd();
		obj.algorithmFloyd();
		obj.printLabirintMatrix();
		obj.printLabirint();

        // AREG: pls change the public interface to something like this
        /*
        Labyrinth labyrinth = new Labyrinth(10, 10);
        labyrinth.computePaths();
        labyrinth.showPath(4, 5);
        */
	}
}
