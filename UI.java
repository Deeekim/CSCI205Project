import java.awt.*;
import java.awt.geom.*;

public class UI {
    
    private SceneCanvas gc;
    private Font defaultFont;
    private Color BROWN;
    
    public UI(SceneCanvas gc) {

        this.gc = gc;
        defaultFont = new Font("Arial", Font.PLAIN, 40); 
        BROWN = new Color(153,51,0);

    }

    public void draw(Graphics2D g2d) {

        g2d.setFont(defaultFont);

        // Draw UI DOT
        Ellipse2D.Double d1 = new Ellipse2D.Double(24, 24, 36, 36);
        g2d.setColor(Color.ORANGE);
        g2d.fill(d1);
        Ellipse2D.Double d2 = new Ellipse2D.Double(28.5, 28.5, 27, 27);
        g2d.setColor(Color.YELLOW);
        g2d.fill(d2);
        Ellipse2D.Double d3 = new Ellipse2D.Double(40, 30, 12, 12);
        g2d.setColor(Color.WHITE);
        g2d.fill(d3);

        // Draw UI Counter
        g2d.setColor(BROWN);
        g2d.drawString("x " + gc.getPlayer().getScore(), 69, 56);
        g2d.drawString("x:"+ gc.getPlayer().getWorldX()/gc.getTileSize()+" y:" + gc.getPlayer().getWorldY()/gc.getTileSize(),620,56);

    }

}
