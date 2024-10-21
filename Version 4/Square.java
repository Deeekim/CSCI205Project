import java.awt.*;
import java.awt.geom.*;

/**
 * Square
 * 
 * Description: The Square class creates a square object given the user's input parameters.
 * This class is used to create shapes to add design to the tiles.
 * Authors: Michael Deekimcheng, Miguel Yapan
 * ID Number: 205641, 205501
 * Date: September 29, 2024
 */
public class Square extends DrawingObject{
    
    private Color color;
    private Rectangle2D.Double square;
    
    /**
     * Creates a Square object with the user's specifications.
     * 
     * @param x the x-coordinate of the location where the square will be drawn 
     * @param y the y-coordinate of the location where the square will be drawn
     * @param size the length of a side of the square
     * @param color the color of the square
     * @param collision a boolean parameter which determines whether the player could collide with an object (true) or not (false)
     */
    public Square(double x, double y, double size, Color color, boolean collision) {

        super(collision);
        this.color = color;
        this.square = new Rectangle2D.Double(x, y, size, size);
    
    }

    /**
     * Getter method for the square's shape
     * 
     * @return the square's shape
     */
    public Shape getShape() {
        return square;
    }

    /**
     * Getter method for the square's color
     * 
     * @return the square's color
     */    
    public Color getColor() {
        return color;
    }
}
