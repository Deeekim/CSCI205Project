import java.awt.*;
import java.util.ArrayList;

public abstract class DrawingObject {
    
    private ArrayList<Shape> shapes;
    private ArrayList<Color> colors;
    private String name;
    private boolean collision;
    private int worldX, worldY;
    private Rectangle solidArea = new Rectangle(0,0,48,48);

    private ArrayList<Shape> tileShapes;
    private ArrayList<Color> tileColors;

    // solidAreaDefaultX and solidAreaDefaultY needed for CollisionChecker
    private int solidAreaDefaultX = 0;
    private int solidAreaDefaultY = 0;

    public DrawingObject(boolean collision) {
        shapes = new ArrayList<>();
        colors = new ArrayList<>();
        tileShapes = new ArrayList<>();
        tileColors = new ArrayList<>();
        this.collision = collision;
    }

    /**
     * draw method for tiles and entities
     * @param g2d
     * @param sc
     */
    public void draw(Graphics2D g2d, SceneCanvas sc) {
        int screenX = worldX - sc.getPlayer().getWorldX() + sc.getPlayer().getScreenX();
        int screenY = worldY - sc.getPlayer().getWorldY() + sc.getPlayer().getScreenY();

        // Only draw the object if it is within the player's visible screen
        if (worldX > sc.getPlayer().getWorldX() - sc.getPlayer().getScreenX() - sc.getTileSize() && 
            worldX < sc.getPlayer().getWorldX() + sc.getPlayer().getScreenX() + sc.getTileSize() &&
            worldY > sc.getPlayer().getWorldY() - sc.getPlayer().getScreenY() - sc.getTileSize() && 
            worldY < sc.getPlayer().getWorldY() + sc.getPlayer().getScreenY() + sc.getTileSize()) {

            // Translate to world position and draw the shapes
            g2d.translate(screenX, screenY);
            for (int i = 0; i < shapes.size(); i++) {
                g2d.setColor(colors.get(i));
                g2d.fill(shapes.get(i));
            }
            g2d.translate(-screenX, -screenY); // Reset translation
        }
    }

    public void addTile(Shape shape, Color color) {
        tileShapes.add(shape);
        tileColors.add(color);
    }

    public void drawTile(Graphics2D g2d) {

        int i;

        for (i = 0; i < tileShapes.size(); i++) {
            g2d.setColor(tileColors.get(i));
            g2d.fill(tileShapes.get(i));
        }

    }

    public ArrayList<Shape> getShapes() {
        return shapes;
    }

    public ArrayList<Color> getColors() {
        return colors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getCollision() {
        return collision;
    }

    public void setCollision(boolean collision) {
        this.collision = collision;
    }

    public int getWorldX() {
        return worldX;
    }

    public void setWorldX(int worldX) {
        this.worldX = worldX;
    }

    public int getWorldY() {
        return worldY;
    }

    public void setWorldY(int worldY) {
        this.worldY = worldY;
    }

    public Rectangle getSolidArea() {
        return solidArea;
    }

    public int getSolidAreaX() {
        return solidArea.x;
    }

    public int getSolidAreaY() {
        return solidArea.y;
    }

    public int getSolidAreaWidth() {
        return solidArea.width;
    }

    public int getSolidAreaHeight() {
        return solidArea.height;
    }

    public void setSolidAreaX (int x) {
        this.solidArea.x = x;
    }

    public void setSolidAreaY (int y) {
        this.solidArea.y = y;
    }

    public void setSolidAreaWidth (int width) {
        this.solidArea.width = width;
    }

    public void setSolidAreaHeight (int height) {
        this.solidArea.height = height;
    }

    public int getSolidAreaDefaultX() {
        return solidAreaDefaultX;
    }

    public int getSolidAreaDefaultY() {
        return solidAreaDefaultY;
    }
    
}
