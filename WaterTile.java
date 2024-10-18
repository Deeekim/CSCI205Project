import java.awt.*;

/**
 * WaterTile
 * 
 * Created by:
 * Name: Michael Deekimcheng, Miguel Yapan
 * ID: 205641, 205501
 * Date: September 29, 2024
 * 
 * Description: The WaterTile is a composite shape DrawingObject subclass that is used to render parts of the map that are made of water.
 * 
 * @author Michael Deekimcheng, Miguel Yapan
 */
public class WaterTile extends DrawingObject{

    /**
     * The waterColor and particleColor variables are used as parameters to create the shape.
     */
    private Color waterColor = new Color(28, 163, 236);
    private Color particleColor = new Color(203, 241, 247);

    /**
     * Square and Circle classes are created to form a water shape that will be added to the list of tiles in the createTile method.
     */
    private Square background = new Square(0, 0, 48, waterColor, true);
    private Circle particle1 = new Circle(3, 4, 3, particleColor, false);
    private Circle particle2 = new Circle(38, 23, 3, particleColor, false);
    private Circle particle3 = new Circle(22, 41, 3, particleColor, false);
    private Circle particle4 = new Circle(31, 37, 5, particleColor, false);
    private Circle particle5 = new Circle(16, 2, 3, particleColor, false);
    private Circle particle6 = new Circle(35, 21, 5, particleColor, false);
    private Circle particle7 = new Circle(29, 13, 3, particleColor, false);
    private Circle particle8 = new Circle(39, 34, 3, particleColor, false);
    private Circle particle9 = new Circle(22, 29, 3, particleColor, false);
    private Circle particle10 = new Circle(15, 15, 5, particleColor, false);
    private Circle particle11 = new Circle(39, 8, 3, particleColor, false);
    private Circle particle12 = new Circle(6, 32, 3, particleColor, false);

    /**
     * Creates a WaterTile object using the createTile method described below.
     * Since the WaterTile object represents the parts of the map that are made of water, the Player object should collide with this class.
     * Thus, the collision parameter from the DrawingObject class is set to true.
     */
    public WaterTile(){
        super(true);
        createTile();
    }

    /**
     * Creates a tile by adding the shape and color of the instantiated Square and Circle objects to the array of tiles.
     * The shapes and colors are added using the addTile method from the DrawingObject class.
     */
    public void createTile(){  
        addTile(background.getShape(), background.getColor());
        addTile(particle1.getShape(), particle1.getColor());
        addTile(particle2.getShape(), particle2.getColor());
        addTile(particle3.getShape(), particle3.getColor());
        addTile(particle4.getShape(), particle4.getColor());
        addTile(particle5.getShape(), particle5.getColor());
        addTile(particle6.getShape(), particle6.getColor());
        addTile(particle7.getShape(), particle7.getColor());
        addTile(particle8.getShape(), particle8.getColor());
        addTile(particle9.getShape(), particle9.getColor());
        addTile(particle10.getShape(), particle10.getColor());
        addTile(particle11.getShape(), particle11.getColor());
        addTile(particle12.getShape(), particle12.getColor());
    }


}
