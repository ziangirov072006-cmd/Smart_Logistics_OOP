package sm.model.vehicle;

import sm.interfaces.ITrackable;

public class Truck extends Vehicle implements ITrackable {
    private boolean hasTrailer;
    private double latitude = 55.75;
    private double longitude = 37.65;

    public Truck(String id, boolean hasTrailer){
        super(id, 5000 + (hasTrailer ? 5000 : 0));
        this.hasTrailer = hasTrailer;
    }

    public boolean isHasTrailer() { return hasTrailer; }

    @Override 
    public void move(){
        longitude +=0.01;
        latitude +=0.01;
        System.out.println("Грузовик " + getId() + " едет по трассе со скоростью 70 км/ч");
    }

    @Override 
    public String getCurrentCoordinates() {
        return "Широта: " + latitude + ", Долгота: " + longitude;
    }

    @Override 
    public void sendStatusUpdate(){
        System.out.println("Грузовик " + getId() + ": статус отправлен, координаты: " + getCurrentCoordinates());
    }
}
