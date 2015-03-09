package Car;

public class Car {
    private String model;

    private String defect;

    public Car(String model, String defect) {
        this.model = model;
        this.defect = defect;
    }

    public String getModel() {
        return model;
    }

    public String getDefect() {
        return defect;
    }
}
