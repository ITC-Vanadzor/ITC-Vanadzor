
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

    }
}
