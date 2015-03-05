import java.util.Scanner;

public class Example {

    public static void main(String[] args) {
        input();
    }

    public static void input() {
        Scanner in = new Scanner(System.in);
        System.out.println("0  Exit");
        System.out.println("1  Repair");
        System.out.println("2  Show max repaired model");
        System.out.println("3  Show max repaired defect");
        int input = in.nextInt();
        switch (input) {
            case 0:
                System.out.println("Bye");
                break;
            case 1:
                System.out.println("Insert car model");
                String model = in.next();
                System.out.println("Insert car defect");
                String defect = in.next();
                Car car = new Car(model, defect);
                Autoservice autoservice = new Autoservice();
                autoservice.addRepairHistory(car);
                input();
                break;
            case 2:
                autoservice.getMaxRepairModel();
                input();
                break;
            case 3:
                autoservice.getMaxRepairDefect();
                input();
                break;
        }
    }

}

