class Execute{
    public static void main (String[] args) {
        Car car = new Car("BMW", "engine");
        Autoservice autoservice = new Autoservice();
        autoservice.addRepAuto(car);
        autoservice.printHistory();
    }
}
