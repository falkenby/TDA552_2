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
    Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;

    ModelWorld model;

    public CarController(ModelWorld model){
        this.model = model;
    }




    //methods:

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Transport t : model.transports) {


                if (ModelWorld.isOutOfFrame(t)) {

                    double speed = t.getCurrentSpeed();
                    t.stopEngine();
                    ModelWorld.changeDir(t);
                    t.startEngine();
                    t.setCurrentSpeed(speed);
                }

                t.move();

                frame.drawPanel.repaint();
            }
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
        for (Transport v : model.transports
        ) {
            v.gas(gas);
        }
    }


    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Transport v : model.transports
        ) {
            v.brake(brake);
        }
    }

    public void liftTruckBed(double angle) {
        for (Transport t : model.transports) {
            if (t instanceof Scania) {
                ((Scania) t).raiseTruckBed(70);
            }
        }
    }

    public void turboOn() {
        for (Transport t : model.transports) {
            if (t instanceof Saab95) {
                ((Saab95) t).turnTurboOn();
            }
        }
    }

    public void turboOff() {
        for (Transport t : model.transports) {
            if (t instanceof Saab95) {
                ((Saab95) t).turnTurboOff();
            }
        }
    }

    public void lowerTruckBed(double angle) {
        for (Transport t : model.transports) {
            if (t instanceof Scania) {
                Scania s = (Scania) t;
                s.lowerTruckBed(angle);
            }
        }
    }

    public void stopAllCarsEngine() {
        for (Transport c : model.transports)
            c.stopEngine();
    }

    public void startAllCarsEngine() {
        for (Transport c : model.transports)
            c.startEngine();
    }

    public void turnRight() {
        for (Transport t : model.transports) {
            t.turnRight();
        }
    }

    public void turnLeft() {
        for (Transport t : model.transports) {
            t.turnLeft();
        }
    }

}
