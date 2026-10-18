package sm;

import java.util.List;
import java.util.ArrayList;

import sm.model.vehicle.Vehicle;
import sm.model.vehicle.Car;
import sm.model.vehicle.Truck;
import sm.model.vehicle.Drone;

import sm.model.cargo.FragileItem;
import sm.model.cargo.RefrigeratedContainer;
import sm.model.cargo.StandardBox;

import sm.interfaces.ITrackable;

import sm.service.LogisticsCenter;
import sm.service.FleetManager;

public class Main{
    public static void main(String[] args){
        // 1. Создаём флот
        List<Vehicle> fleet = new ArrayList<>();
        fleet.add(new Car("CAR-001", 4));
        fleet.add(new Truck("TRUCK-001", true));
        fleet.add(new Drone("DRONE-001", 100));

        // 2. Создаём грузы (Задача 3)
        StandardBox box1 = new StandardBox("BOX-001", "Коробка с документами", 10);
        FragileItem box2 = new FragileItem("FRAG-001", "Хрустальная ваза", 5, true);
        RefrigeratedContainer box3 = new RefrigeratedContainer("REFCON-001", "Холодильник с колбасой", 15, -15);
        
        // 3. Загружаем грузы ДО отправки
        Car car = (Car) fleet.get(0);
        car.load(box1);
        car.load(box2);
        car.load(box3);
        System.out.println("Загружено в машину: " + car.getCurrentLoadKg() + " кг");

        // 4. Отправляем флот в доставку (Задача 2)
        FleetManager manager = new FleetManager();
        manager.startDelivery(fleet);

        // 5. Демонстрация отслеживания (Задача 3)
        List<ITrackable> trackable = new ArrayList<>();
        trackable.add(new Truck("TRUCK-001", true));
        trackable.add(new Drone("DRONE-001", 100));
        // trackable.add(new Car("CAR-002", 4)); // Ошибка компиляции: Car не реализует ITrackable

        LogisticsCenter center = new LogisticsCenter();
        center.dispatch(trackable);
        center.monitorFleet(trackable);

        System.out.println("Загружено в машину: " + car.getCurrentLoadKg() + " кг");
    }
}