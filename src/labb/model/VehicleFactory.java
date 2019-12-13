package labb.model;

public class VehicleFactory {

    public static Transport buildVolvo(){
        Transport vehicle = new Volvo240();
        return vehicle;
    }

    public static Transport buildSaab(){
        Transport vehicle = new Saab95();
        vehicle.getPoint().y += 100;
        return vehicle;
    }

    public static Transport buildScania(){
        Transport vehicle = new Scania();
        vehicle.getPoint().y += 200;
        return vehicle;
    }

}
