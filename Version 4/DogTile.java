import java.awt.*;
import java.awt.geom.*;

public class DogTile extends DrawingObject {

    private Color grassColor = new Color(19, 133, 16);
    private Color dogColor = new Color(255, 204, 102);

    public DogTile() {
        super(false); // Assuming no collision for dog
        setCollision(false);
        createTile();
    }

    private void createTile() {
        
        addTile(new Rectangle2D.Double(0, 0, 48, 48), grassColor);

        addTile(new Rectangle2D.Double(15, 20, 18, 10), dogColor);
        addTile(new Ellipse2D.Double(12, 18, 24, 16), dogColor);

        addTile(new Ellipse2D.Double(22, 8, 10, 10), dogColor);

        addTile(new Ellipse2D.Double(18, 10, 6, 8), dogColor);
        addTile(new Ellipse2D.Double(28, 10, 6, 8), dogColor);

        addTile(new Rectangle2D.Double(17, 28, 4, 8), dogColor);
        addTile(new Rectangle2D.Double(27, 28, 4, 8), dogColor);

        addTile(new Rectangle2D.Double(31, 22, 6, 3), dogColor);

        addTile(new Ellipse2D.Double(24, 11, 2, 2), Color.BLACK);
        addTile(new Ellipse2D.Double(28, 11, 2, 2), Color.BLACK);
        addTile(new Rectangle2D.Double(26, 14, 2, 2), Color.BLACK);
        addTile(new Rectangle2D.Double(26, 16, 1, 1), Color.BLACK);
    }
}