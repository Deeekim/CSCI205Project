import java.awt.*;
import java.awt.geom.*;

/**
 * WallTile
 * 
 * Description: The WallTile is a composite shape DrawingObject subclass that is used to render walls in the map.
 * Name: Michael Deekimcheng, Miguel Yapan
 * ID: 205641, 205501
 * Date: September 29, 2024
 */
public class WallTile extends DrawingObject{

    private Color baseColor = new Color(125, 84, 71);
    private Color topBrickColor = new Color(251, 186, 115);
    private Color midBrickColor = new Color(242, 157, 67);
    private Color bottomBrickColor = new Color(213, 117, 36);
    private Square background = new Square(0, 0, 48, baseColor, true);

    /**
     * Creates a WallTile object using the createTile method described below.
     * Since the WallTile object represents walls in the map, the Player object should collide with this class.
     * Thus, the collision parameter from the DrawingObject class is set to false.
     */
    public WallTile(){
        super(true);
        createTile();
    }

    /**
     * Creates a tile by adding the shape and color of the background object to the array of tiles followed by new Rectangle2D shapes.
     * The shapes and colors are added using the addTile method from the DrawingObject class.
     */
    public void createTile(){  
        addTile(background.getShape(), background.getColor());      
        addTile(new Rectangle2D.Double(0, 4, 13, 6), topBrickColor);
        addTile(new Rectangle2D.Double(0, 10, 13, 8), midBrickColor);
        addTile(new Rectangle2D.Double(0, 18, 13, 3), bottomBrickColor);
        addTile(new Rectangle2D.Double(19, 4, 15, 6), topBrickColor);
        addTile(new Rectangle2D.Double(19, 10, 15, 8), midBrickColor);
        addTile(new Rectangle2D.Double(19, 18, 15, 3), bottomBrickColor);
        addTile(new Rectangle2D.Double(40, 4, 8, 6), topBrickColor);
        addTile(new Rectangle2D.Double(40, 10, 8, 8), midBrickColor);
        addTile(new Rectangle2D.Double(40, 18, 8, 3), bottomBrickColor);

        addTile(new Rectangle2D.Double(0, 28, 18, 6), topBrickColor);
        addTile(new Rectangle2D.Double(0, 34, 18, 7), midBrickColor);
        addTile(new Rectangle2D.Double(0, 41, 18, 3), bottomBrickColor);
        addTile(new Rectangle2D.Double(24, 28, 24, 6), topBrickColor);
        addTile(new Rectangle2D.Double(24, 34, 24, 7), midBrickColor);
        addTile(new Rectangle2D.Double(24, 41, 24, 3), bottomBrickColor);
    }


}
