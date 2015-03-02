
public class topBottomBorder{
    public int columns = 0;
    public topBottomBorder(int col){
        columns = col; 
    }
    public void printBorder(){
        String line = ""; 
        for(int i = 0;i < columns;i++){
            line += "*";
        }
        System.out.println(line);
    }
}

