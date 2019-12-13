package labb.controller;

import labb.model.ModelWorld;
import labb.model.VehicleFactory;
import labb.view.CarView;

public class MainApplication {

    public static void main(String[] args) {

        // Adding the cars
        ModelWorld model = new ModelWorld(800, 800);
        // Instance of this class
        CarController cc = new labb.controller.CarController(model);

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc, model);

        // Start the timer
        cc.timer.start();
    }

}
