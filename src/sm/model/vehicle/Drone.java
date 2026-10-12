package sm.model.vehicle;

public class Drone extends Vehicle {
    private double batteryLevel;

    public Drone (String id, double batteryLevel){
        super(id, 5);
        if (batteryLevel <= 0 || batteryLevel > 100){
            throw new IllegalArgumentException("Заряд не может быть < 0% или > 100%");
        }
        this.batteryLevel = batteryLevel;
    }

    public double getBatteryLevel() { return batteryLevel; }

    @Override
    public void move(){
        batteryLevel-=5;
        if (batteryLevel < 0){
            throw new IllegalArgumentException("О нет, мой дрон, все пропало.\nЗаряд на нуле :(");
        }
        System.out.println("Дрон " + getId() + " летит по воздуху, заряд батареи: " + batteryLevel + "%");
    }

}
