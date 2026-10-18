package sm.model.vehicle;

import sm.interfaces.ITrackable;

public class Drone extends Vehicle implements ITrackable {
    private double batteryLevel;
    private double latitude = 35.75;
    private double longitude = 27.65;
    private double altitude = 100;

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
        if (batteryLevel < 0){
            throw new IllegalArgumentException("О нет, мой дрон, все пропало.\nЗаряд на нуле :(");
        }
        batteryLevel -= 5;
        latitude += 0.01;
        longitude += 0.01;
        altitude += 0.05;
        System.out.println("Дрон " + getId() + " летит по воздуху, заряд батареи: " + batteryLevel + "%");
    }

    @Override 
    public String getCurrentCoordinates() {
        return "Широта: " + latitude + ", Долгота: " + longitude + ", Высота полета: " + altitude;
    }

    @Override 
    public void sendStatusUpdate(){
        System.out.println("Дрон " + getId() + ": статус отправлен, координаты: " + getCurrentCoordinates());
    }

}
