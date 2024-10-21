import java.awt.*;
import java.awt.geom.*;

/** 
 * Star
 * 
 * Description: The star class creates a star object given the user's input parameters.
 * This class is created by combining four triangles.
 * This class is used to create shapes to add design to the tiles.
 * Authors: Michael Deekimcheng, Miguel Yapan
 * ID Number: 205641, 205501
 * Date: September 29, 2024
 */
public class Star extends DrawingObject{
    
    private Color color;
    private double x;
    private double y;
    private double size;
    private Path2D.Double star;

    /**
     * Creates a Star object with the user's specifications
     * 
     * @param x the x-coordinate of the leftmost point of the star.
     * @param y the y-coordinate of the leftmost point of the star.
     * @param size the length from one endpoint of the star to the other endpoint
     * @param color the color of the star
     * @param collision a boolean parameter which determines whether the player could collide with an object (false) or not (true)
     */
    public Star(double x, double y, double size, Color color, boolean collision){
        super(collision);
        this.color = color;
        this.x = x;
        this.y = y;
        this.size = size;
        this.star = createStar();
    }

    /**
     * This method creates the shape of the star.
     * 
     * @return the star shape
     */
    private Path2D.Double createStar() {
        Path2D.Double star1 = new Path2D.Double();
        star1.moveTo(x, y);
        star1.lineTo(x + size/2, y - size/4);
        star1.lineTo(x + size, y);
        star1.lineTo(x + size/2, y + size/4);
        star1.closePath();

        Path2D.Double star2 = new Path2D.Double();
        star2.moveTo(x + size/4, y);
        star2.lineTo(x + size/2, y - size/2);
        star2.lineTo(x + 3*size/4, y);
        star2.lineTo(x + size/2, y + size/2);
        star2.closePath();

        Path2D.Double star = new Path2D.Double();
        star.append(star1, false);
        star.append(star2, false);

        return star;
    }

    /**
     * Getter method for the star's shape
     * 
     * @return the star shape
     */
    public Shape getShape() {
        return star;
    }

    /**
     * Getter method for the star's color
     * @return
     */
    public Color getColor() {
        return color;
    }
}
