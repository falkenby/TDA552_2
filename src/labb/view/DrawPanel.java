package labb.view;

import labb.controller.CarController;
import labb.model.ModelWorld;
import labb.model.Transport;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel {

    // Just a single image, TODO: Generalize
    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;
    // To keep track of a single cars position
    ArrayList<Transport> vehiclesToDraw;


    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, ModelWorld model) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.vehiclesToDraw = model.transports;
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            volvoImage = ImageIO.read(new File("./src/labb/pics/Volvo240.jpg"));
            saabImage = ImageIO.read(new File("./src/labb/pics/Saab95.jpg"));
            scaniaImage = ImageIO.read(new File("./src/labb/pics/Scania.jpg"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Transport v : vehiclesToDraw) {
            switch (v.getModelName()) {
                case "Saab95":
                    g.drawImage(saabImage, (int) Math.round(v.getPoint().x), (int) Math.round(v.getPoint().y), null); // see javadoc for more info on the parameters

                    break;
                case "Volvo240":
                    g.drawImage(volvoImage, (int) Math.round(v.getPoint().x), (int) Math.round(v.getPoint().y), null); // see javadoc for more info on the parameters
                    break;
                case "Scania":
                    g.drawImage(scaniaImage, (int) Math.round(v.getPoint().x), (int) Math.round(v.getPoint().y), null); // see javadoc for more info on the parameters
                    break;
            }
        }
    }
}