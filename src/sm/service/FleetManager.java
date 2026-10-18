package sm.service;

import java.util.List;
import sm.model.vehicle.Vehicle;

public class FleetManager {
    public void startDelivery(List<Vehicle> fleet) {
        for (Vehicle v : fleet) {
            v.move();  // полиморфный вызов
        }
    }
}