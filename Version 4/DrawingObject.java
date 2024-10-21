import java.awt.*;
import java.util.ArrayList;

/**
 * DrawingObject
 * 
 * Description: An abstract class that will be used as the superclass for static visual elements in the program.  
 * In general, there are two main subclasses - tile subclasses that span the whole map and general visuals that could be placed anywhere.
 * Authors: Michael Deekimcheng, Miguel Yapan
 * ID Number: 205641, 205501
 * Date: September 29, 2024
 */
public abstract class DrawingObject {
    
    private ArrayList<Shape> shapes;
    private ArrayList<Color> colors;
    private ArrayList<Shape> tileShapes;
    private ArrayList<Color> tileColors;

    private String name;
    private boolean collision;
    private int worldX, worldY;
    private Rectangle solidArea = new Rectangle(0,0,48,48);
    
    private int solidAreaDefaultX = 0;
    private int solidAreaDefaultY = 0;

    /**
     * Constructs a DrawingObject class by instantiating arrays.
     * The shapes and colors arrays are used for creating general visual elements.
     * The tileShapes and tileColors arrays are used for creating tiles.
     * 
     * @param collision is set to determine if the Player should be able to collide with the object or not (true if the player cannot collide)
     */
    public DrawingObject(boolean collision) {
        shapes = new ArrayList<>();
        colors = new ArrayList<>();
        tileShapes = new ArrayList<>();
        tileColors = new ArrayList<>();
        this.collision = collision;
    }

    /**
     * Adds a specific shape and color in the shapes and colors arrays, which will be used in the general draw method.
     * 
     * @param shape the shape to be added to the shapes array
     * @param color the color to be added to the colors array
     */
    public void addShape(Shape shape, Color color) {
        shapes.add(shape);
        colors.add(color);
    }

    /**
     * The draw method for general visual elements that should be seen in the screen.
     * The method reads the shapes array and fills it with its corresponding color from the colors array.
     * 
     * @param g2d the Graphics2D object used for drawing the shapes.
     * @param sc the SceneCanvas in which the shapes will be drawn.
     */
    public void draw(Graphics2D g2d, SceneCanvas sc) {

        // Only draw the object if it is within the player's visible screen
        int screenX = worldX - sc.getPlayer().getWorldX() + sc.getPlayer().getScreenX();
        int screenY = worldY - sc.getPlayer().getWorldY() + sc.getPlayer().getScreenY();

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

            // Resets translation
            g2d.translate(-screenX, -screenY); 
        }
    }

    /**
     * Adds a specific shape and color in the tileShapes and tileColors arrays, which will be used in the drawTile method.
     * 
     * @param shape the shape to be added to the tileShapes array
     * @param color the color to be added to the tileColors array
     */
    public void addTile(Shape shape, Color color) {
        tileShapes.add(shape);
        tileColors.add(color);
    }

    /**
     * The draw method for tiles that will span the whole map.
     * All tiles will already be rendered regardless of the Player's visible area.
     * The method reads the tileShapes array and fills it with its corresponding color from the tileColors array.
     * 
     * @param g2d the Graphics2D object used for drawing the shapes.
     */
    public void drawTile(Graphics2D g2d) {

        int i;

        for (i = 0; i < tileShapes.size(); i++) {
            g2d.setColor(tileColors.get(i));
            g2d.fill(tileShapes.get(i));
        }

    }

    /**
     * Getter method for the shapes array
     * 
     * @return the shapes array
     */
    public ArrayList<Shape> getShapes() {
        return shapes;
    }

    /**
     * Getter method for the colors array
     * 
     * @return the colors array
     */
    public ArrayList<Color> getColors() {
        return colors;
    }

    /**
     * Getter method for the name variable
     * 
     * @return the name variable
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for the name variable
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for the collision variable
     * 
     * @return the collision variable
     */
    public boolean getCollision() {
        return collision;
    }

    /**
     * Setter method for the collision variable
     */
    public void setCollision(boolean collision) {
        this.collision = collision;
    }

    /**
     * Getter method for the worldX variable
     * 
     * @return the worldX variable
     */
    public int getWorldX() {
        return worldX;
    }

    /**
     * Setter method for the worldX variable
     */
    public void setWorldX(int worldX) {
        this.worldX = worldX;
    }

    /**
     * Getter method for the worldY variable
     * 
     * @return the worldY variable
     */
    public int getWorldY() {
        return worldY;
    }

    /**
     * Setter method for the worldY variable
     */
    public void setWorldY(int worldY) {
        this.worldY = worldY;
    }

    /**
     * Getter method for the solidArea variable
     * 
     * @return the solidArea variable
     */
    public Rectangle getSolidArea() {
        return solidArea;
    }

    /**
     * Getter method for the x-coordinate of the solidArea variable
     * 
     * @return solidArea.x
     */
    public int getSolidAreaX() {
        return solidArea.x;
    }

    /**
     * Getter method for the y-coordinate of the solidArea variable
     * 
     * @return solidArea.y
     */
    public int getSolidAreaY() {
        return solidArea.y;
    }

    /**
     * Getter method for the width of the solidArea variable
     * 
     * @return solidArea.width
     */
    public int getSolidAreaWidth() {
        return solidArea.width;
    }

    /**
     * Getter method for the height of the solidArea variable
     * 
     * @return solidArea.height
     */
    public int getSolidAreaHeight() {
        return solidArea.height;
    }
    
    /**
     * Setter method for the x-coordinate of the solidArea variable
     */
    public void setSolidAreaX (int x) {
        this.solidArea.x = x;
    }

    /**
     * Setter method for the y-coordinate of the solidArea variable
     */
    public void setSolidAreaY (int y) {
        this.solidArea.y = y;
    }

    /**
     * Setter method for the width of the solidArea variable
     */
    public void setSolidAreaWidth (int width) {
        this.solidArea.width = width;
    }

    /**
     * Setter method for the height of the solidArea variable
     */
    public void setSolidAreaHeight (int height) {
        this.solidArea.height = height;
    }

    /**
     * Getter method for the solidAreaDefaultX variable
     * 
     * @return the solidAreaDefaultX variable
     */
    public int getSolidAreaDefaultX() {
        return solidAreaDefaultX;
    }

    /**
     * Getter method for the solidAreaDefaultY variable
     * 
     * @return the solidAreaDefaultY variable
     */
    public int getSolidAreaDefaultY() {
        return solidAreaDefaultY;
    }
    
}
