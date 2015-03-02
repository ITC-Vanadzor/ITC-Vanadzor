

public class Rectangle {
    int width;
    int length;
    public Rectangle (int wid, int len){
        width = wid;
        length = len;
    }
    public void print_rect(){
        if (width>0 && length>0){
            for (int j=0;  j < length; ++j){
                 for (int i=0; i < width; ++i){
                    System.out.print("*");
            }
            System.out.println("");
            }
        }
    }

}
