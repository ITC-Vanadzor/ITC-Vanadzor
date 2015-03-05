import java.util.*;
//import car.Car;

public class Autoservice {
    public static void main(String[] args) {
        int num;
        Scanner in = new Scanner(System.in);
        System.out.print(" For repair car input 1: \n If you want to show max reapired model input 2: \n If you want to show max repaired defect input 3: ");
        num = in.nextInt();
        if(num == 1) {
            repairCar();
        }
        if(num == 2) {
            showMaxRepModel();
        }
        if(num == 3) {
            showMaxRepDefects();
        }
    }
    public static void repairCar() {
        System.out.println("ok");
    } 
    public static void showMaxRepModel() {
        System.out.println("ok");
    }
    public static void showMaxRepDefects() {
        System.out.println("ok");    
    }
}




