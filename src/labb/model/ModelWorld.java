package labb.model;

import labb.view.CarView;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class ModelWorld {

    // A list of cars, modify if needed
    public ArrayList<Transport> transports = new ArrayList<>();
    private static int width;
    private static int height;

    public ModelWorld(int x, int y){
        this.width = x;
        this.height = y;
        addingCars();
    }

    public void addingCars(){

        transports.add(VehicleFactory.buildVolvo());
        transports.add(VehicleFactory.buildSaab());
        transports.add(VehicleFactory.buildScania());
    }

    /**
     * A method for changing the direction when the vehicle crashes into the wall
     *
     * @param vehicle
     */
    public static void changeDir(Transport vehicle) {
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
    public static boolean isOutOfFrame(Transport vehicle) {
        Point2D.Double point = vehicle.getPoint();
        double x = point.getX();
        double y = point.getY();
        double xFrame = width - 100;
        double yFrame = height - 300;

        if (x < 0 || x > xFrame) {
            return true;
        }
        if (y < 0 || y > yFrame) {
            return true;
        } else {
            return false;
        }

    }


}
