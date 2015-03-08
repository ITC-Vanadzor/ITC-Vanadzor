
public class Vertical {
    int width;
    public Vertical(int wid){
        width = wid;
    }
    public void print_col(){
        if (width>0){
            for (int i=0; i<width; ++i){
                System.out.print("*");
                System.out.println("");
            }
        System.out.println("");
        }
    }

}
