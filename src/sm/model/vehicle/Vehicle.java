package sm.model.vehicle;

import java.util.List;
import java.util.ArrayList;
import sm.model.cargo.CargoItem;

public abstract class Vehicle{
    private String id;
    private double maxCapacityKg;
    private double currentLoadKg;
    private List<CargoItem> cargoList = new ArrayList<>();

    public Vehicle (String id, double maxCapacityKg){
        this.id=id;
        if (maxCapacityKg <= 0){
            throw new IllegalArgumentException("Грузоподъемность должна быть > 0");
        }
        this.maxCapacityKg = maxCapacityKg;
    }

    public String getId() { return id; }
    public double getMaxCapacityKg() { return maxCapacityKg; }
    public double getCurrentLoadKg() {return currentLoadKg; }

    public abstract void move();

    public void load(double weight){
        if (currentLoadKg + weight <= maxCapacityKg){
            currentLoadKg += weight;
        }
        else{
            System.out.println("Превышен лимит нагрузки " + id);
        }
    }

    public void load(CargoItem item){
        if (currentLoadKg + item.getWeight() <= maxCapacityKg){
            currentLoadKg += item.getWeight();
            cargoList.add(item);
        }
        else{
            System.out.println("Превышен лимит нагрузки "+ id);
        }
    }

    public void load(List<CargoItem> items){
        for (CargoItem item : items){
            load(item);
        }
    }
}