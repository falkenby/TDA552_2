package labb.view;

import labb.controller.CarController;
import labb.model.Transport;

import javax.swing.*;
import java.awt.*;

public class SpeedPanel extends JPanel {

    String modelName;
    double modelSpeed;
    JLabel car;


    public SpeedPanel(int x, int y, CarController carC) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setOpaque(false);
        newLabels(carC);
    }

    public void newLabels(CarController carC) {
        for (Transport v : carC.transports) {

            modelName = v.getModelName();
            modelSpeed = v.getCurrentSpeed();

            car = new JLabel(modelName + " " + modelSpeed);
            this.add(car);
            this.revalidate();
        }
        this.repaint();
    }

}
