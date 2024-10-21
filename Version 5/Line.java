import java.awt.*;
import java.awt.geom.*;

/**
 * Line
 * 
 * Description: The Line class creates a line given the user's input parameters.
 * This class is used to create shapes to add design to the tiles.
 * Authors: Michael Deekimcheng, Miguel Yapan
 * ID Number: 205641, 205501
 * Date: September 29, 2024
 */
public class Line extends DrawingObject{
    
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private float thickness;
    private Color color;
    private Path2D.Double line;

    /**
     * Creates a line object with the user's specifications.
     * 
     * @param x1 the x-coordinate of the location of the first endpoint of the line
     * @param y1 the y-coordinate of the location of the first endpoint of the line
     * @param x2 the x-coordinate of the location of the second endpoint of the line
     * @param y2 the y-coordinate of the location of the second endpoint of the line
     * @param thickness the thickness of the line
     * @param color the color of the line
     * @param collision a boolean parameter which determines whether the player could collide with an object (false) or not (true) 
     */
    public Line(double x1, double y1, double x2, double y2, float thickness, Color color, boolean collision) {

        super(collision);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.thickness = thickness;
        this.color = color;
        this.line = createLine();

    }

    /**
     * This method creates the shape of the line using the two endpoint parameters.
     * 
     * @return the line shape
     */
    private Path2D.Double createLine() {
        Path2D.Double p = new Path2D.Double();
        p.moveTo(x1, y1);
        p.lineTo(x2, y2);
        return p;
    }

    /**
     * Getter method for the line's shape
     * 
     * @return the line shape
     */
    public Shape getShape() {
        return line;
    }

    /**
     * Getter method for the line's color
     * 
     * @return the line color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Getter method for the line's thickness
     * 
     * @return the line's thickness
     */
    public BasicStroke getThickness() {
        return new BasicStroke(thickness);
    }
}
