import java.awt.*;
import java.awt.geom.*;

public class Line extends DrawingObject{
    
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private float thickness;
    private Color color;
    private Path2D.Double line;

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

    private Path2D.Double createLine() {
        Path2D.Double p = new Path2D.Double();
        p.moveTo(x1, y1);
        p.lineTo(x2, y2);
        return p;
    }

    public void draw(Graphics2D g2d) {
        g2d.setStroke(new BasicStroke(thickness));
        g2d.setColor(color);
        g2d.draw(line); 
    }

    public Shape getShape() {
        return line;
    }

    public Color getColor() {
        return color;
    }

    // http://www.java2s.com/Code/JavaAPI/java.awt/Graphics2DsetStrokeStrokes.htm
}
