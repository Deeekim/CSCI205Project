import java.awt.*;

/**
 * PathTile
 * 
 * Created by:
 * Name: Michael Deekimcheng, Miguel Yapan
 * ID: 205641, 205501
 * Date: September 29, 2024
 * 
 * Description: The PathTile is a composite shape DrawingObject subclass that is used to render the paths on the map.
 * 
 * @author Michael Deekimcheng, Miguel Yapan
 */
public class PathTile extends DrawingObject {

    /**
     * The dirtColor and particleColor variables are used as parameters to create the shape.
     */
    private Color dirtColor = new Color(155, 118, 83);
    private Color particleColor = new Color(125, 98, 63);

    /**
     * Square and Circle classes are created to form a path shape that will be added to the list of tiles in the createTile method.
     */
    private Square dirt = new Square(0, 0, 48, dirtColor, false);
    private Circle particle1 = new Circle(6, 5, 3, particleColor, false);
    private Circle particle2 = new Circle(24, 15, 3, particleColor, false);
    private Circle particle3 = new Circle(37, 9, 3, particleColor, false);
    private Circle particle4 = new Circle(10, 21, 3, particleColor, false);
    private Circle particle5 = new Circle(21, 26, 3, particleColor, false);
    private Circle particle6 = new Circle(42, 18, 3, particleColor, false);
    private Circle particle7 = new Circle(7, 39, 3, particleColor, false);
    private Circle particle8 = new Circle(27, 35, 3, particleColor, false);
    private Circle particle9 = new Circle(35, 41, 3, particleColor, false);

    /**
     * Creates a PathTile object using the createTile method described below.
     * Since the PathTile object represents the paths on the map, the Player object should not collide with this class.
     * Thus, the collision parameter from the DrawingObject class is set to false.
     */
    public PathTile() {
        super(false); // Assuming no collision for path
        createTile();
    }

    /**
     * Creates a tile by adding the shape and color of the instantiated Square and Circle objects to the array of tiles.
     * The shapes and colors are added using the addTile method from the DrawingObject class.
     */
    private void createTile() {
        
        addTile(dirt.getShape(), dirt.getColor());
        addTile(particle1.getShape(), particle1.getColor());
        addTile(particle2.getShape(), particle2.getColor());
        addTile(particle3.getShape(), particle3.getColor());
        addTile(particle4.getShape(), particle4.getColor());
        addTile(particle5.getShape(), particle5.getColor());
        addTile(particle6.getShape(), particle6.getColor());
        addTile(particle7.getShape(), particle7.getColor());
        addTile(particle8.getShape(), particle8.getColor());
        addTile(particle9.getShape(), particle9.getColor());

    }
}
