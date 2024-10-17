import java.awt.*;
import java.awt.geom.*;

public class WallTile extends DrawingObject{

    private Color baseColor = new Color(125, 84, 71);
    private Color topBrickColor = new Color(251, 186, 115);
    private Color midBrickColor = new Color(242, 157, 67);
    private Color bottomBrickColor = new Color(213, 117, 36);

    private Square background = new Square(0, 0, 48, baseColor, true);

    public WallTile(){
        super(true);
        createTile();
    }

    public void createTile(){  
        addTile(background.getShape(), background.getColor());      
        addTile(new Rectangle2D.Double(0, 4, 13, 6), topBrickColor);
        addTile(new Rectangle2D.Double(0, 10, 13, 8), midBrickColor);
        addTile(new Rectangle2D.Double(0, 18, 13, 3), bottomBrickColor);
        addTile(new Rectangle2D.Double(19, 4, 15, 6), topBrickColor);
        addTile(new Rectangle2D.Double(19, 10, 15, 8), midBrickColor);
        addTile(new Rectangle2D.Double(19, 18, 15, 3), bottomBrickColor);
        addTile(new Rectangle2D.Double(40, 4, 8, 6), topBrickColor);
        addTile(new Rectangle2D.Double(40, 10, 8, 8), midBrickColor);
        addTile(new Rectangle2D.Double(40, 18, 8, 3), bottomBrickColor);

        addTile(new Rectangle2D.Double(0, 28, 18, 6), topBrickColor);
        addTile(new Rectangle2D.Double(0, 34, 18, 7), midBrickColor);
        addTile(new Rectangle2D.Double(0, 41, 18, 3), bottomBrickColor);
        addTile(new Rectangle2D.Double(24, 28, 24, 6), topBrickColor);
        addTile(new Rectangle2D.Double(24, 34, 24, 7), midBrickColor);
        addTile(new Rectangle2D.Double(24, 41, 24, 3), bottomBrickColor);
    }


}
