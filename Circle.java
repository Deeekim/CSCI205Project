import java.awt.*;
import java.awt.geom.*;

public class Circle extends DrawingObject {
    
    private Color color;
    private Ellipse2D.Double circle; 

    public Circle(double x, double y, double size, Color color, boolean collision) {

        super(collision);
        this.color = color;
        this.circle = new Ellipse2D.Double(x, y, size, size);
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(color);
        g2d.fill(circle); 
    }

    public Shape getShape() {
        return circle;
    }

    public Color getColor() {
        return color;
    }
}
