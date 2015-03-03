public class labTable{
    public void printHorizBorders(int size) {
        String border = ""; 
        for (int i=0; i<size; ++i) {
            border += "_";
        }
        System.out.println(border);
    }
    public void printVertHorizBorders(int size) {
        String border = "";
        for (int i=0; i<size; ++i){
            border += "|___";
        }
        border += "|";
        System.out.println(border);
    }
    public void printVertBorders(int size) {
        String border = "";
        for (int i=0; i<size; ++i){
            border += "|   ";
        }
        System.out.println(border);
    }
}
