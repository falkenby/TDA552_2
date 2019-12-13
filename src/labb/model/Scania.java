package labb.model;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Scania is a class that extends the superclass truck.
 * It has a unique speedFactor method
 * and also a lower and raise truckbed
 */
public class Scania extends Truck {

    public Scania() {
        nrDoors = 2;
        color = Color.blue;
        enginePower = 0.8;
        modelName = "Scania";
        stopEngine();
        point = new Point2D.Double(0, 0);
        direction = 'W';
        truckAngle = 0;
        state = StateEngine.STOPPED;
        stateRamp = StateRamp.DOWN;
        type = CarType.SCANIA;

    }

    @Override
    public double speedFactor() {
        return enginePower;
    }

    /**
     * A method for raising the truckbed on Scania
     *
     * @param angle
     */

    @Override
    public void raiseTruckBed(double angle) {
        if (this.getCurrentSpeed() > 0 || (truckAngle + angle) > 70 || (truckAngle + angle) < 0) {
            throw new RuntimeException("Cannot raise truckbed when truck is moving!");
        }

        truckAngle += angle;
        stateRamp = StateRamp.UP;

    }

    /**
     * A method for lowering the truckbed on Scania
     *
     * @param angle
     */

    @Override
    public void lowerTruckBed(double angle) {
        if (this.getCurrentSpeed() > 0 || (truckAngle - angle) > 70 || (truckAngle - angle) < 0) {
            throw new RuntimeException("Cannot lower truckbed when truck is moving!");
        }

        truckAngle -= angle;
        stateRamp = StateRamp.DOWN;
    }

}
