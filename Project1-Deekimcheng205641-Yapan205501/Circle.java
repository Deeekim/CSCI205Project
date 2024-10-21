import java.awt.*;
import java.awt.geom.*;

/**
 * Circle
 * 
 * Description: The Circle class creates a circle object given the user's input parameters.
 * This class is used to create shapes to add design to the tiles.
 * Authors: Michael Deekimcheng, Miguel Yapan
 * ID Number: 205641, 205501
 * Date: October 6, 2024
 */
public class Circle extends DrawingObject {
    
    private Color color;
    private Ellipse2D.Double circle; 

    /**
     * Creates a Circle object with the user's specifications
     * 
     * @param x the x-coordinate of the location where the circle will be drawn 
     * @param y the y-coordinate of the location where the circle will be drawn
     * @param size the diameter of the circle
     * @param color the color of the circle
     * @param collision a boolean parameter which determines whether the player could collide with an object (false) or not (true)
     */
    public Circle(double x, double y, double size, Color color, boolean collision) {
        super(collision);
        this.color = color;
        this.circle = new Ellipse2D.Double(x, y, size, size);
    }

    /**
     * Getter method for the circle's shape
     * 
     * @return the circle's shape
     */
    public Shape getShape() {
        return circle;
    }

    /**
     * Getter method for the circle's color
     * 
     * @return the circle's color
     */    
    public Color getColor() {
        return color;
    }
}
