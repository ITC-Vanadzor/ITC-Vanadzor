import java.util.*;
import java.lang.Math.*;

public class Triangle {

    public double perimeter;
    public double area;

    public double Perimeter(double a, double b, double c) {
        double perimeter = a + b + c;
        return perimeter; 
    }
    
    public double Area(double a, double b, double c, double perimeter) {
        area = (Math.sqrt(perimeter/2*(perimeter/2-a)*(perimeter/2-b)*(perimeter/2-c)));  
        return area;  
    }
}
