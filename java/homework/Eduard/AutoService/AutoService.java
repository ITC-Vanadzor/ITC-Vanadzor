
public class AutoService {
    
/*    AutoService () {
        
    }
*/
    public static void repairedCars(String repairedModel, String repairedDefect) { 
        Car car1 = new Car(repairedModel, repairedDefect);
        System.out.println("Repaired the " + repairedModel + "one car");
    }
    
    public static void main(String[] args) {
        System.out.print("Enter car model:");
        String modelName = System.console().readLine();
//        if (modelName.equals("BMW")) {System.out.println("BMW is exist");}
        System.out.print("Enter defect:");
        String defectName = System.console().readLine();
        repairedCars(modelName, defectName);
    }
}
