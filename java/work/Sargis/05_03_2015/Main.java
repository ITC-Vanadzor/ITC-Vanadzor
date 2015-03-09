import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Car car1 = new Car("525", "BMW","injector");
        Car car2 = new Car("325", "BMW","break");
        Car car3 = new Car("Q7", "Audi","break");
        Car car4 = new Car("E320", "Mersedec","engine");
        Car car5 = new Car("X-Trail", "Nissan","Prujin");
        Car car6 = new Car("Focus", "Ford","break");
        Car car7 = new Car("Focus", "Ford","break");
        Car car8 = new Car("X5", "BMW","injector");
        Autoservice myservice = new Autoservice();
        myservice.repair(car1);
        myservice.repair(car2);
        myservice.repair(car3);
        myservice.repair(car4);
        myservice.repair(car5);
        myservice.repair(car6);
        myservice.repair(car7);
        myservice.repair(car8);
        System.out.println(myservice.GetMaxModel());
        System.out.println(myservice.GetMaxDefect());
        System.out.print(" If you need: \n Most common defects, insert 1 \n Most common repaired models, insert 2 \n To reset, insert 3 \n To quit, insert 4 \n" );
        while(true){
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        switch(num){
            case 1: System.out.println(myservice.GetMaxDefect());
                    break;

            case 2: System.out.println(myservice.GetMaxModel());
                    break;
            case 3: myservice.resetall();
                    break;
            case 4: System.out.println("Exit");
                    System.exit(0);
            default: System.out.println("insert 1 or 2 or 3 or 4");
                     break;
        }
     }
    }
}
