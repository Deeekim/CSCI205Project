import java.awt.*;
import java.awt.geom.*;

/**
 * Triangle
 * 
 * Description: The Triangle class creates a triangle object given the user's input parameters.
 * The triangle's height will always be in the middle of the base.
 * This class is used to create shapes to add design to the tiles.
 * Authors: Michael Deekimcheng, Miguel Yapan
 * ID Number: 205641, 205501
 * Date: October 6, 2024
 */

public class Triangle extends DrawingObject {
   
    private Color color;
    private double x;
    private double y;
    private double base;
    private double height;
    private Path2D.Double triangle;

    /**
     * Creates a Triangle object with the user's specifications
     * 
     * @param x the x-coordinate of the left endpoint of the triangle
     * @param y the y-coordinate of the left endpoint of the triangle
     * @param base the length of the base of the triangle
     * @param height the length of the height of the triangle
     * @param color the color of the triangle
     * @param collision a boolean parameter which determines whether the player could collide with an object (false) or not (true)
     */
    public Triangle(double x, double y, double base, double height, Color color, boolean collision) {
        super(collision);
        this.color = color;
        this.x = x;
        this.y = y;
        this.base = base;
        this.height = height;
        this.triangle = createTriangle();
    }

    /**
     * This method creates the shape of the triangle.
     * 
     * @return the triangle shape
     */    
    private Path2D.Double createTriangle() {
        Path2D.Double tri = new Path2D.Double();
        tri.moveTo(x, y);
        tri.lineTo(x + base, y);
        tri.lineTo(x + (base/2), y - height);
        tri.closePath();
        return tri;
    }

    /**
     * Getter method for the triangle's shape
     * 
     * @return the triangle shape
     */
    public Shape getShape() {
        return triangle;
    }

    /**
     * Getter method for the triangle's color
     * 
     * @return the triangle color
     */
    public Color getColor() {
        return color;
    }



}
