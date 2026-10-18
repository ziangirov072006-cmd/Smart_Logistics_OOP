package sm.model.cargo;

public class RefrigeratedContainer extends BaseCargo {
    private double targetTemperature;
    
    public RefrigeratedContainer(String id, String name, double weight, double targetTemperature){
        super(id, name, weight);
        this.targetTemperature = targetTemperature;
    }

    public double getTargetTemperature() { return targetTemperature; }

    @Override 
    public String getType(){
        return "Температурный режим";
    }
}
