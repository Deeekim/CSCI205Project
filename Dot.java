import java.awt.*;
import java.awt.geom.*;

public class Dot extends DrawingObject {

    // Constructor to initialize a dot (circle) at a given world position
    public Dot(int worldX, int worldY) {
        super(false);
        this.setName("Dot");
        this.setWorldX(worldX);
        this.setWorldY(worldY);
        this.setCollision(false);
        this.setSolidAreaX(12);
        this.setSolidAreaY(12);
        this.setSolidAreaWidth(24);
        this.setSolidAreaHeight(24);

        // // Initialize shapes and colors arrays
        // this.shapes = new ArrayList<>();
        // this.colors = new ArrayList<>();

        // Add shapes and colors for the Dot object
        addShape(new Ellipse2D.Double(12, 12, 24, 24), Color.ORANGE);
        addShape(new Ellipse2D.Double(15, 15, 18, 18), Color.YELLOW);
        addShape(new Ellipse2D.Double(24, 18, 6, 6), Color.WHITE);
    }
}
