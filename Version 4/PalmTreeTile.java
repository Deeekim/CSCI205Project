import java.awt.*;
import java.awt.geom.*;

/**
 * PalmTreeTile
 * 
 * Description: The PalmTreeTile is a composite shape DrawingObject subclass that is used to render the trees in the map.
 * Authors: Michael Deekimcheng, Miguel Yapan
 * ID Number: 205641, 205501
 * Date: September 29, 2024
 */
public class PalmTreeTile extends DrawingObject {

    private Color sandColor = new Color(253, 211, 137);
    private Color palmLeafColor1 = new Color(134, 204, 96);
    private Color palmLeafColor2 = new Color(124,214,76);
    private Color palmLeafColor3 = new Color(234, 185, 119);
    private Color trunkColor = new Color(147, 119, 71);
    private Color coconutColor = new Color(113,75,57);
    
    private Square background = new Square(0, 0, 48, sandColor, true);
    private Circle particle1 = new Circle(3,4,3, palmLeafColor3, true);
    private Circle particle2 = new Circle(41, 23, 3, palmLeafColor3, true);
    private Circle particle3 = new Circle(35, 25, 5, palmLeafColor3, true);
    private Circle particle4 = new Circle(29, 13, 5, palmLeafColor3, true);
    private Circle particle5 = new Circle(37, 28, 7, palmLeafColor3, true);
    private Circle coconut1 = new Circle(22, 8, 8, coconutColor, true);
    private Circle coconut2 = new Circle(18, 12, 8, coconutColor, true);

    /**
     * Creates a PalmTreeTile object using the createTile method described below.
     * Since the PalmTreeTile object represents trees, the Player object should not be able to collide with this class.
     * Thus, the collision parameter from the DrawingObject class is set to true.
     */
    public PalmTreeTile() {
        super(true); // Assuming collision is true for palm tree
        createTile();
    }

    /**
     * Creates a tile by adding the shape and color of the instantiated Square and Circle objects to the array of tiles.
     * Additional shapes (for the leaves and trunk) are also drawn using the Path2D object.
     * The shapes and colors are added using the addTile method from the DrawingObject class.
     */
    private void createTile() {

        addTile(background.getShape(), background.getColor());

        addTile(particle1.getShape(), particle1.getColor());
        addTile(particle2.getShape(), particle2.getColor());
        addTile(particle3.getShape(), particle3.getColor());
        addTile(particle4.getShape(), particle4.getColor());
        addTile(particle5.getShape(), particle5.getColor());

        Path2D.Double leaf1 = new Path2D.Double();
        leaf1.moveTo(22, 4);
        leaf1.curveTo(1.4,10,12.4,2.5, 0,20);
        leaf1.curveTo(10,20,21,12.5,22,4);
        leaf1.curveTo(31.7,5,44.2,14.6,47,24);
        leaf1.curveTo(35,24.5,22.5,15,22,4);
        leaf1.closePath();
        addTile(leaf1, palmLeafColor1);

        Path2D.Double leaf2 = new Path2D.Double();
        leaf2.moveTo(22, 4);
        leaf2.curveTo(9,15,15,5, 10,25);
        leaf2.curveTo(18,21,24,11,22,4);
        leaf2.curveTo(30,2.1,43,3.6,48,8);
        leaf2.curveTo(40.7,12.5,27.7,11,22,4);
        leaf2.closePath();
        addTile(leaf2, palmLeafColor2);

        Path2D.Double trunk = new Path2D.Double();
        trunk.moveTo(22,4);
        trunk.curveTo(25,14.8,26,35.3,24,46);
        trunk.lineTo(30,46);
        trunk.curveTo(30, 27.5, 26,7,22,4);
        trunk.closePath();
        addTile(trunk, trunkColor);

        addTile(coconut1.getShape(), coconut1.getColor());
        addTile(coconut2.getShape(), coconut2.getColor());
    }
}
