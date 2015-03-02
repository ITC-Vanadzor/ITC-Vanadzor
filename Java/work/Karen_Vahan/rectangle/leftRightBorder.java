public class leftRightBorder{
    public int columns = 0;
    public int rows = 0;
    public leftRightBorder(int col, int row){
        columns = col;
        rows = row;
    }
    public void printBorder(){
        String line = "";
        for(int i = 1;i <= columns;i++){
            if((i == 1) || (i == columns) ){
                line += "*";
            }else{
                line += " ";
            }
        }
        System.out.println(line);
    }
}

