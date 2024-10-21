import java.awt.*;
import java.awt.geom.*;

/**
 * HutTile
 * 
 * Description: The HutTile is a composite shape DrawingObject subclass that is used to render the huts in the map.
 * Authors: Michael Deekimcheng, Miguel Yapan
 * ID Number: 205641, 205501
 * Date: October 6, 2024
 */
public class HutTile extends DrawingObject {

    private Color hutColor = new Color(204, 102, 0);
    private Color sandColor = new Color(253, 211, 127);
    private Color starColor = new Color(255, 255, 0);

    private Square background = new Square(0, 0, 48, sandColor, true);
    private Triangle roof = new Triangle(2, 16, 44, 15, hutColor, true);
    private Square house = new Square(9, 16, 30, hutColor, true);
    private Circle houseCircle = new Circle(19, 3, 10, Color.BLACK, true);
    private Star houseStar = new Star(19, 8, 10, starColor, true);
    private Square window1 = new Square(14, 20, 6, Color.BLACK, true);
    private Square window2 = new Square(28, 20, 6, Color.BLACK, true);
    private Circle knob = new Circle(26, 38, 2.5, starColor, true);
    private Line woodLine1 = new Line(20, 30, 20, 46, 1, Color.WHITE, true);

    /**
     * Creates a HutTile object using the createTile method described below.
     * The Player object should not collide with this class.
     * Thus, the collision parameter from the DrawingObject class is set to true.
     */
    public HutTile() {
        super(true);
        createTile();
    }

    /**
     * Creates a tile by adding the shape and color of the instantiated Square and Circle objects to the array of tiles.
     * The shapes and colors are added using the addTile method from the DrawingObject class.
     */
    public void createTile() {
        addTile(background.getShape(), background.getColor());
        addTile(roof.getShape(), roof.getColor());
        addTile(house.getShape(), house.getColor());
        addTile(houseCircle.getShape(), houseCircle.getColor());
        addTile(houseStar.getShape(), houseStar.getColor());
        addTile(new Rectangle2D.Double(19, 30, 10, 16), Color.BLACK);
        addTile(window1.getShape(), window1.getColor());
        addTile(window2.getShape(), window2.getColor());
        addTile(knob.getShape(), knob.getColor());
        addTile(woodLine1.getShape(), woodLine1.getColor(), woodLine1.getThickness());
    }
    
}
