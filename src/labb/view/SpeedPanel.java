package labb.view;

import labb.controller.CarController;
import labb.model.Transport;

import javax.swing.*;
import java.awt.*;

public class SpeedPanel extends JPanel {

    String modelName;
    double modelSpeed;
    //JLabel car = new JLabel(modelName + " " + modelSpeed);
    GridBagConstraints gc = new GridBagConstraints();

    public void newLabels(CarController carC, DrawPanel drawPanel) {
        for (Transport v : carC.transports) {
            System.out.println("hej");
            modelName = v.getModelName();
            modelSpeed = v.getCurrentSpeed();

            JLabel car = new JLabel(modelName + " " + modelSpeed);
           // this.getComponents();
            this.add(car);

        }
        drawPanel.repaint();
    }
}
