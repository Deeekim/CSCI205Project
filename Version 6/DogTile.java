import java.awt.*;
import java.awt.geom.*;

/**
 * DogTile
 * 
 * Description: The DogTile is a composite shape DrawingObject subclass that is used to render dog visuals in the map.
 * Authors: Michael Deekimcheng, Miguel Yapan
 * ID Number: 205641, 205501
 * Date: September 29, 2024
 */
public class DogTile extends DrawingObject {

    private Color sandColor = new Color(253, 211, 137);
    private Color dogColor = new Color(204, 102, 0);
    private Color earColor = new Color(101, 67, 33);

    private Square background = new Square(0, 0, 48, sandColor, true);
    private Circle head = new Circle(26, 8, 22, dogColor, true);
    private Circle ear1 = new Circle(26, 8, 8, earColor, true);
    private Circle ear2 = new Circle(40, 8, 8, earColor, true);
    private Star eyeStar1 = new Star(30, 17, 8, Color.BLACK, true);
    private Star eyeStar2 = new Star(38, 17, 8, Color.BLACK, true);
    private Triangle nose = new Triangle(35, 24, 6, 3, Color.BLACK, true);

    /**
     * Creates a DogTile object using the createTile method described below.
     * The Player object should not collide with this class.
     * Thus, the collision parameter from the DrawingObject class is set to true.
     */
    public DogTile() {
        super(true); 
        createTile();
    }

    /**
     * Creates a tile by adding the shape and color of the instantiated DrawingObject objects to the array of tiles.
     * The shapes and colors are added using the addTile method from the DrawingObject class.
     */
    private void createTile() {
        
        addTile(background.getShape(), background.getColor());

        addTile(new Ellipse2D.Double(8, 24, 40, 16), dogColor);
        addTile(new Ellipse2D.Double(10, 30, 8, 14), dogColor);
        addTile(new Ellipse2D.Double(18, 28, 8, 14), dogColor);
        addTile(new Ellipse2D.Double(30, 30, 8, 14), dogColor);
        addTile(new Ellipse2D.Double(38, 28, 8, 14), dogColor);
        addTile(head.getShape(), head.getColor());
        addTile(ear1.getShape(), ear1.getColor());
        addTile(ear2.getShape(), ear2.getColor());
        addTile(eyeStar1.getShape(), eyeStar1.getColor());
        addTile(eyeStar2.getShape(), eyeStar2.getColor());
        addTile(nose.getShape(), nose.getColor());
    }
}