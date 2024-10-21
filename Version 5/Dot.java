import java.awt.*;

/**
 * Dot
 *
 * Description: The class creates dots that the Player can interact with, increasing their score.
 * The dot class will first be instantiated at specific points. Once the player picks up these initial dots,
 * additional dots will be generated randomly in the map.
 * Authors: Michael Deekimcheng, Miguel Yapan
 * ID Number: 205641, 205501
 * Date: September 29, 2024
 */
public class Dot extends DrawingObject {

    private Circle dotOuter = new Circle(12, 12, 24, Color.ORANGE, false);
    private Circle dotMiddle = new Circle(15, 15, 18, Color.YELLOW, false);
    private Circle dotInner = new Circle(24, 18, 6, Color.WHITE, false);

    /** Creates a Dot object at a specified position in the world.
     * Initial dots will also be created under the constructor
     *
     * @param worldX the x-coordinate position of the dot.
     * @param worldY the y-coordinate position of the dot.
     */
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

        // Add shapes and colors for the Dot object
        addShape(dotOuter.getShape(), dotOuter.getColor());
        addShape(dotMiddle.getShape(), dotMiddle.getColor());
        addShape(dotInner.getShape(), dotInner.getColor());
    }
}
