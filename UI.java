import java.awt.*;
import java.awt.geom.*;

/**
* Michael Deekimcheng and Miguel Yapan
* 205641 and 205501
* Date created: October 14, 2024
*
* The class is responsible for printing the current player's score and 
* the tile's column and row which the player would be on.
*/
public class UI {
    
    private SceneCanvas gc;
    private Font defaultFont;
    private Color BROWN;

    /**
    * Constructs a UI with the specified SceneCanvas
    *
    * @param gc where the UI will be drawn on
    */
    public UI(SceneCanvas gc) {

        this.gc = gc;
        defaultFont = new Font("Arial", Font.PLAIN, 40); 
        BROWN = new Color(153,51,0);

    }

    /**
    * Draws the player's score and coordinates on screen
    *
    * @param g2d the Graphics2D utilised for drawing the objects
    */ 
    public void draw(Graphics2D g2d) {

        g2d.setFont(defaultFont);

        /* 
        * draw a visual representation of dot so the player knows what object is being kept track of
        */
        Ellipse2D.Double d1 = new Ellipse2D.Double(24, 24, 36, 36);
        g2d.setColor(Color.ORANGE);
        g2d.fill(d1);
        Ellipse2D.Double d2 = new Ellipse2D.Double(28.5, 28.5, 27, 27);
        g2d.setColor(Color.YELLOW);
        g2d.fill(d2);
        Ellipse2D.Double d3 = new Ellipse2D.Double(40, 30, 12, 12);
        g2d.setColor(Color.WHITE);
        g2d.fill(d3);

        g2d.setColor(BROWN);
        // displays the player's score
        g2d.drawString("x " + gc.getPlayer().getScore(), 69, 56);

        // displays player's current Tile's column and row
        g2d.drawString("x:"+ gc.getPlayer().getWorldX()/gc.getTileSize()+" y:" + gc.getPlayer().getWorldY()/gc.getTileSize(),620,56);

    }

}
