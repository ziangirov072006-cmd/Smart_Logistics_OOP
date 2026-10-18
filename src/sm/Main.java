package sm;

import java.util.List;
import java.util.ArrayList;

import sm.model.vehicle.Vehicle;
import sm.model.vehicle.Car;
import sm.model.vehicle.Truck;
import sm.model.vehicle.Drone;

import sm.model.cargo.CargoItem;

import sm.service.FleetManager;

public class Main{
    public static void main(String[] args){
        List<Vehicle> fleet = new ArrayList<>();

        fleet.add(new Car("CAR-001", 4));
        fleet.add(new Truck("TRUCK-001", true));
        fleet.add(new Drone("DRONE-001", 100));

        CargoItem box1 = new CargoItem("Коробка с документами", 10);
        CargoItem box2 = new CargoItem("Коробка с оборудованием", 50);

        FleetManager manager = new FleetManager();
        manager.startDelivery(fleet);

        // Загрузи в машину
        Car car = (Car) fleet.get(0);
        car.load(box1);
        car.load(box2);

        System.out.println("Загружено в машину: " + car.getCurrentLoadKg() + " кг");
    }
}