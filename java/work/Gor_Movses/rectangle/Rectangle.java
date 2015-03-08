import java.util.*;
import rows.Rows;

public class Rectangle {
    public static void main(String[] args) {
       int rows;
       int colums;
       Scanner in = new Scanner(System.in);
       System.out.print("Enter your rows count: ");
       rows=in.nextInt();
       System.out.print("Enter your colums count: ");
       colums=in.nextInt();
       Rows.rowsFunc();
    }
}
