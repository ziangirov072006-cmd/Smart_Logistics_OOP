package sm.model.vehicle;

public class Truck extends Vehicle {
    private boolean hasTrailer;

    public Truck(String id, boolean hasTrailer){
        super(id, 5000 + (hasTrailer ? 5000 : 0));
        this.hasTrailer = hasTrailer;
    }

    public boolean isHasTrailer() { return hasTrailer; }

    @Override 
    public void move(){
        System.out.println("Грузовик " + getId() + " едет по трассе со скоростью 70 км/ч");
    }
}
