package labb.model;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public abstract class Transport implements Movable {

    int nrDoors; // Number of doors on the car
    double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    Color color; // Color of the car
    String modelName; // The car model name
    Point2D.Double point; // Coordinate system in a 2D coordinate system
    char direction; // direction of the turning
    StateEngine state;
    CarType type;

    public Point2D getPosition() {
        return point;
    }



    /* Getters and Setters*/

    public int getNrDoors() {
        return this.nrDoors;
    }

    public double getEnginePower() {
        return this.enginePower;
    }

    public double getCurrentSpeed() {
        return this.currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    public String getModelName() {
        return this.modelName;
    }

    public CarType getType() {
        return type;
    }

    public void setCurrentSpeed(double speed) {
        this.currentSpeed = speed;
    }

    public void setDirection(char dir) {
        this.direction = dir;
    }

    public void startEngine() {
        this.currentSpeed = 0.1;
        this.state = StateEngine.STARTED;
    }

    public void stopEngine() {
        this.currentSpeed = 0;
        this.state = StateEngine.STOPPED;
    }

    public Point2D.Double getPoint() {
        return this.point;
    }

    public char getDirection() {
        return this.direction;
    }

    /**
     * Abstract method for speedFactor, because the speedFactor is unique for each car
     */
    protected abstract double speedFactor();

    /**
     * Incrementing the speed, is called by gas()
     */

    public void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    /**
     * Decrementing the speed, is called by brake()
     */

    public void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

    /**
     * Slowing down the car, amount must be between 0 and 1
     */

    public void brake(double amount) {
        if (amount < 0.0 || amount > 1.0) {
            throw new RuntimeException("The brake can't go above 1 nor below 0");
        }
        decrementSpeed(amount);

    }

    /**
     * Speeding up the car, amount must be between 0 and 1.
     * This method is abstract because it changes a little in car and truck
     */

    public abstract void gas(double amount);


    /**
     * Movable methods call, uses the Point2D system with a double x and a double y
     * Changes speed depending on direction
     */


    @Override
    public void move() {

        if (this.state == StateEngine.TRANSPORTING) {
            throw new RuntimeException("Cannot move car when its transporting");
        }

        switch (this.direction) {
            case 'N':
                this.point.setLocation(this.point.getX(), (this.point.getY() + this.currentSpeed));
                break;
            case 'W':
                this.point.setLocation((this.point.getX() + this.currentSpeed), this.point.getY());
                break;
            case 'E':
                this.point.setLocation((this.point.getX() - this.currentSpeed), this.point.getY());
                break;
            case 'S':
                this.point.setLocation(point.getX(), (point.getY() - currentSpeed));
                break;

        }

    }

    /**
     * Rotates the car 90 degrees to the right
     */
    @Override
    public void turnRight() {

        switch (this.direction) {
            case 'N':
                this.direction = 'E';
                break;
            case 'W':
                this.direction = 'N';
                break;
            case 'E':
                this.direction = 'S';
                break;
            case 'S':
                this.direction = 'W';
                break;

        }


    }

    /**
     * Rotates the car 90 degrees to the left
     */
    @Override
    public void turnLeft() {

        switch (this.direction) {
            case 'N':
                this.direction = 'W';
                break;
            case 'W':
                this.direction = 'S';
                break;
            case 'E':
                this.direction = 'N';
                break;
            case 'S':
                this.direction = 'E';
                break;

        }

    }

}
