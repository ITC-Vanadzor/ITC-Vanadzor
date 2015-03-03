
public class labPath {
    public static void main(String[] args){
        labTable pen = new labTable();
        pen.printHorizBorders(53);
        for (int i=0; i<10; ++i) {
            pen.printVertBorders(14);
            pen.printVertHorizBorders(13);
        }
    }
}

