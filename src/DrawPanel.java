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
    Point point = new Point();
    ArrayList<Transport> vehiclesToDraw;

    // TODO: Make this genereal for all cars
    void moveit(int x, int y){
        this.point.x = x;
        this.point.y = y;
    }

    public ArrayList<Transport> getVehiclesToDraw() {
        return vehiclesToDraw;
    }

    public void setVehiclesToDraw(ArrayList<Transport> toDraw) {
        this.vehiclesToDraw = toDraw;
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            volvoImage = ImageIO.read(DrawPanel.class.getResource("pics/Volvo240.jpg"));
            saabImage = ImageIO.read(DrawPanel.class.getResource("pics/Saab95.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResource("pics/Scania.jpg"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Transport v : vehiclesToDraw) {
            switch (v.getType()) {
                case SAAB:
                    g.drawImage(saabImage, (int) Math.round(v.getPoint().x), (int) Math.round(v.getPoint().y) + 100, null); // see javadoc for more info on the parameters
                    break;
                case VOLVO:
                    g.drawImage(volvoImage, (int) Math.round(v.getPoint().x), (int) Math.round(v.getPoint().y), null); // see javadoc for more info on the parameters
                    break;
                case SCANIA:
                    g.drawImage(scaniaImage, (int) Math.round(v.getPoint().x), (int) Math.round(v.getPoint().y) + 200, null); // see javadoc for more info on the parameters
                    break;
            }
        }

    }
}
