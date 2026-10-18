package sm.model.cargo;

public class FragileItem extends BaseCargo {
    private boolean requiresSpecialHandling;

    public FragileItem (String id, String name, double weight, boolean requiresSpecialHandling){
        super(id, name, weight);
        this.requiresSpecialHandling = requiresSpecialHandling;
    }

    public boolean isRequiresSpecialHandling() { return requiresSpecialHandling; }

    public String getType(){
        return "Хрупкий груз";
    }
}
