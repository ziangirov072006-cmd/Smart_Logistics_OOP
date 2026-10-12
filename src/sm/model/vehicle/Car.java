package sm.model.vehicle;

public class Car extends Vehicle {
    private int passengerCount;

    public Car(String id, int passengerCount) {
        super(id, 500);
        this.passengerCount = passengerCount;
    }

    public int getPassengerCount() { return passengerCount; }

    @Override
    public void move(){
        System.out.println("Легковой автомобиль " + getId() + " едет по дороге со скоростью 90 км/ч" );
    }
}
