public class printRect{
    public static int columns = 15;
    public static int rows = 8;
    public static void main(String[] args){
        topBottomBorder obj1 = new topBottomBorder(columns);
        leftRightBorder obj2 = new leftRightBorder(columns,rows);
        for(int i = 1;i <= rows;i++){
            if((i == 1) || (i == rows) ){
                obj1.printBorder();
            }else{
                obj2.printBorder();
            }
        }

    }
}

