

public class Horizontal {
    int length;
    public Horizontal(int len){
        length = len;
    }
    public void print_row(){
        if (length>0){
            for (int i=0; i<length; ++i){
                System.out.print("* ");
            }
        System.out.println("");
        }
    }

}
