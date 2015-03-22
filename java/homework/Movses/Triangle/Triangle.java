import java.util.*;

public class Triangle {
    
    private Point A;
    private Point B;
    private Point C;

    public int a; 
    public int b; 
    public int c; 
    public int P;
    public int S;

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

    Triangle(int x1, int y1, int x2,int y2,int x3, int y3) {
        A = new Point(x1,y1);
        B = new Point(x2,y2);
        C = new Point(x3,y3);    
    
        a=(sqrt((sqr(x2-x1)+sqr(y2-y1))));
        b=(sqrt((sqr(x3-x1)+sqr(y3-y1))));
        c=(sqrt((sqr(x3-x2)+sqr(y3-y2))));
    }   

    public int Perimeter() {
        P = a+b+c;
        return P; 
    }
    
    public int Area() {
        S = (sqrt(P/2*(P/2-a)*(P/2-b)*(P/2-c)));  
        return S;  
    }
}
