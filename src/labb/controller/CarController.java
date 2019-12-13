package labb.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import labb.model.*;
import labb.view.CarView;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    public ArrayList<Transport> transports = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.transports.add(VehicleFactory.buildVolvo());
        cc.transports.add(VehicleFactory.buildSaab());
        cc.transports.add(VehicleFactory.buildScania());


        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Transport t : transports) {


                if (isOutOfFrame(t)) {

                    double speed = t.getCurrentSpeed();
                    t.stopEngine();
                    changeDir(t);
                    t.startEngine();
                    t.setCurrentSpeed(speed);
                }

                t.move();

                frame.drawPanel.repaint();
            }
        }
    }

    /**
     * A method for changing the direction when the vehicle crashes into the wall
     *
     * @param vehicle
     */
    private void changeDir(Transport vehicle) {
        switch (vehicle.getDirection()) {
            case 'N':
                vehicle.setDirection('S');
                break;
            case 'S':
                vehicle.setDirection('N');
                break;
            case 'E':
                vehicle.setDirection('W');
                break;
            case 'W':
                vehicle.setDirection('E');
                break;

        }
    }


    /**
     * Checking if a car is out of frame
     *
     * @param vehicle
     * @return
     */
    private boolean isOutOfFrame(Transport vehicle) {
        Point2D.Double point = vehicle.getPoint();
        double x = point.getX();
        double y = point.getY();
        double xFrame = frame.getDrawPanel().getSize().getWidth() - 100;
        double yFrame = frame.getDrawPanel().getSize().getHeight() - 60;

        if (x < 0 || x > xFrame) {
            return true;
        }
        if (y < 0 || y > yFrame) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * Each of the methods below go through the all vehicles once and calls for the respective method
     * The different methods are:
     * gas, brake, liftTruckBed, lowerTruckBed, turnTurboOn, turnTurboOff,
     * startAllCars, stopAllCars, turnRight, turnLeft
     */
    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Transport v : transports
        ) {
            v.gas(gas);
        }
    }


    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Transport v : transports
        ) {
            v.brake(brake);
        }
    }

    public void liftTruckBed(double angle) {
        for (Transport t : transports) {
            if (t instanceof Scania) {
                ((Scania) t).raiseTruckBed(70);
            }
        }
    }

    public void turboOn() {
        for (Transport t : transports) {
            if (t instanceof Saab95) {
                ((Saab95) t).turnTurboOn();
            }
        }
    }

    public void turboOff() {
        for (Transport t : transports) {
            if (t instanceof Saab95) {
                ((Saab95) t).turnTurboOff();
            }
        }
    }

    public void lowerTruckBed(double angle) {
        for (Transport t : transports) {
            if (t instanceof Scania) {
                Scania s = (Scania) t;
                s.lowerTruckBed(angle);
            }
        }
    }

    public void stopAllCarsEngine() {
        for (Transport c : transports)
            c.stopEngine();
    }

    public void startAllCarsEngine() {
        for (Transport c : transports)
            c.startEngine();
    }

    public void turnRight() {
        for (Transport t : transports) {
            t.turnRight();
        }
    }

    public void turnLeft() {
        for (Transport t : transports) {
            t.turnLeft();
        }
    }

}
