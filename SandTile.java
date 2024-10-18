import java.awt.*;

/**
 * SandTile
 * 
 * Created by:
 * Name: Michael Deekimcheng, Miguel Yapan
 * ID: 205641, 205501
 * Date: September 29, 2024
 * 
 * Description: The SandTile is a composite shape DrawingObject subclass that is used to render the parts of the map made of sand.
 * 
 * @author Michael Deekimcheng, Miguel Yapan
 */
public class SandTile extends DrawingObject{

    /**
     * The sandColor and dustColor variables are used as parameters to create the shape.
     */
    private Color sandColor = new Color(253, 211, 137);
    private Color dustColor = new Color(234, 185, 119);

    /**
     * Square and Circle classes are created to form a sand shape that will be added to the list of tiles in the createTile method.
     */
    private Square background = new Square(0, 0, 48, sandColor, false);
    private Circle particle1 = new Circle(3, 4, 3, dustColor, false);
    private Circle particle2 = new Circle(41, 23, 3, dustColor, false);
    private Circle particle3 = new Circle(22, 41, 3, dustColor, false);
    private Circle particle4 = new Circle(2, 37, 3, dustColor, false);
    private Circle particle5 = new Circle(16, 1, 5, dustColor, false);
    private Circle particle6 = new Circle(35, 25, 5, dustColor, false);
    private Circle particle7 = new Circle(29, 13, 5, dustColor, false);
    private Circle particle8 = new Circle(8, 19, 7, dustColor, false);
    private Circle particle9 = new Circle(37, 28, 7, dustColor, false);

    /**
     * Creates a SandTile object using the createTile method described below.
     * Since the SandTile object represents ground that is made of sand, the Player object should not collide with this class.
     * Thus, the collision parameter from the DrawingObject class is set to false.
     */
    public SandTile(){
        super(false);
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
    }


}
