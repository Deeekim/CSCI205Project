import java.awt.*;
import java.awt.geom.*;

public class Square extends DrawingObject{
    
    private Color color;
    private Rectangle2D.Double square;

    public Square(double x, double y, double size, Color color, boolean collision) {

        super(collision);
        this.color = color;
        this.square = new Rectangle2D.Double(x, y, size, size);
    
    }

    public void draw(Graphics2D g2d) {
        
        g2d.setColor(color);
        g2d.fill(square);

    }

    public Shape getShape() {
        return square;
    }

    public Color getColor() {
        return color;
    }
}
