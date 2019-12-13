package labb.model;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Volvo240 is a class that extends the superclass car.
 * It has a unique speedFactor method
 */
public class Volvo240 extends Car {

    double trimFactor; // How much the engine is trimmed

    public Volvo240() {
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        stopEngine();
        trimFactor = 1.25;
        point = new Point2D.Double(0, 0);
        direction = 'W';
        state = StateEngine.STOPPED;
        type = CarType.VOLVO;
    }

    @Override
    protected double speedFactor() {
        return enginePower * 0.01 * trimFactor;
    }



}
