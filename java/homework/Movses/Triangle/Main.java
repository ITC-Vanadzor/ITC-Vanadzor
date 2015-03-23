import java.util.*;
import java.lang.Math.*;

public class Main {
    
    public static double a;
    public static double b;
    public static double c;

    public static void main (String[] args) {

        Scanner in=new Scanner(System.in);
        System.out.print("nermuceq A gagati x koordinaty: ");
        int x1=in.nextInt();
        System.out.print("nermuceq A gagati y koordinaty: ");
        int y1=in.nextInt();
        System.out.print("nermuceq B gagati x koordinaty: ");
        int x2=in.nextInt();
        System.out.print("nermuceq B gagati y koordinaty: ");
        int y2=in.nextInt();
        System.out.print("nermuceq C gagati x koordinaty: ");
        int x3=in.nextInt();
        System.out.print("nermuceq C gagati y koordinaty: ");
        int y3=in.nextInt();

        if ((x1==x2 && x2==x3 && x3==x1) || (y1==y2 && y2==y3 && y1==y3)) {
            System.out.println("Sxal tvyalneri nermucum");    

        }
        
        a=(Math.sqrt((Math.pow((x2-x1),2)+Math.pow((y2-y1),2))));
        b=(Math.sqrt((Math.pow((x3-x1),2)+Math.pow((y3-y1),2))));
        c=(Math.sqrt((Math.pow((x3-x2),2)+Math.pow((y3-y2),2))));
        
        Triangle myTri = new Triangle();
        System.out.println(myTri.Perimeter(a,b,c));
    }    
}
