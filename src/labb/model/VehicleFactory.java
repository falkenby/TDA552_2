package labb.model;

public class VehicleFactory {
    public static Transport buildCar(CarType model) {
        Transport vehicle = null;
        switch (model) {
            case VOLVO:
                vehicle = new Volvo240();
                break;

            case SAAB:
                vehicle = new Saab95();
                vehicle.getPoint().y += 100;
                break;

            case SCANIA:
                vehicle = new Scania();
                vehicle.getPoint().y += 200;
                break;

            default:
                // throw some exception
                break;
        }
        return vehicle;
    }
}
