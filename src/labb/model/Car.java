package labb.model;

/**
 * An abstract superclass Car that is extended by the carmodels Volvo240 and Saab95.
 * It also implements Movable, which is used to turn the car.
 * It is an abstract class so that
 */

public abstract class Car extends Transport {

    /* Used protected due to it being used in Volvo240 and Saab95*/
    double trimFactor; // How much the engine is trimmed
    boolean turboOn; // Turbo-switch

    public void gas(double amount) {
        if (amount < 0.0 || amount > 1.0) {
            throw new RuntimeException("The gas can't go above 1 nor below 0");
        }
        if(this.state == StateEngine.TRANSPORTING){
            throw new RuntimeException("Cannot speed up the car when its transporting");
        }
        incrementSpeed(amount);

    }



}
