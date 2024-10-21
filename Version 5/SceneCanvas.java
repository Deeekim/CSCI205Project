import java.awt.*;
import javax.swing.*;

/** 
 * SceneCanvas
 * 
 * Description: The SceneCanvas contains all the visual elements or components of the program.
 * The DrawingObject assets, DrawingObject tiles, Entity Player, and the UI will all be put together in this class.
 * Authors: Michael Deekimcheng, Miguel Yapan
 * ID Number: 205641, 205501
 * Date: September 29, 2024
 */
public class SceneCanvas extends JComponent implements Runnable {

    // Pixel Settings
    private final int originalTileSize = 16;
    private final int scale = 3;

    // Screen Settings
    private final int tileSize = originalTileSize * scale;
    private final int maxScreenCol = 18;
    private final int maxScreenRow = 14;
    private final int screenWidth = tileSize * maxScreenCol;
    private final int screenHeight = tileSize * maxScreenRow;

    // World Settings
    private final int maxWorldCol = 50;
    private final int maxWorldRow = 50;

    // FPS Settings
    private int FPS = 60;

    private TileManager tileManager = new TileManager(this);
    private KeyHandle keyH = new KeyHandle();
    private Thread gameThread;
    private CollisionChecker cChecker = new CollisionChecker(this);
    private AssetSetter aSetter = new AssetSetter(this);
    private UI ui = new UI(this);

    private Player player = new Player(this, keyH);
    private DrawingObject[] obj = new DrawingObject[10];
    
    /**
     * Creates a SceneCanvas object with the user's parameters.
     */
    public SceneCanvas() {
        this.setPreferredSize(new Dimension(800, 600));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        // need to populate arrays here
    }

    /**
     * Calls the setObject method from the AssetSetter class to 
     * create the initial assets (Dots) in the map
     */
    public void setUpGame() {
        aSetter.setObject();
    }

    /**
     * Creates a new Thread object in order to keep iterating and running
     * the program within the device's capabilities. 
     * The thread is also started here.
     */
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    /**
     * Method that is called with the startGameThread method.
     * This method describes the game loop that updates the state of the program.
     */
    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                // System.out.println("FPS: 60");
                delta--;
            }
        }
    }

    /**
     * Method that updates the position of the player in the map.
     */
    public void update() {
        player.update();
    }

    /**
     * Method that draws the visual elements of the program.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        // Draw the tiles
        tileManager.draw(g2d);

        // Draw the object
        for(int i = 0; i < obj.length; i++) {
            if (obj[i] != null) {
                obj[i].draw(g2d, this);
            }
        }

        // Draw the player
        player.draw(g2d);

        // Draw UI
        ui.draw(g2d);

        g2d.dispose();
    }

    /**
     * Getter method for the tileSize variable
     * 
     * @return the tileSize variable
     */
    public int getTileSize() {
        return tileSize;
    }

    /**
     * Getter method for the screenWidth variable
     * 
     * @return the screenWidth variable
     */
    public int getScreenWidth() {
        return screenWidth;
    }

    /**
     * Getter method for the screenHeight variable
     * 
     * @return the screenHeight variable
     */
    public int getScreenHeight() {
        return screenHeight;
    }

    /**
     * Getter method for the maxWorldCol variable
     * 
     * @return the maxWorldCol variable
     */
    public int getMaxWorldCol() {
        return maxWorldCol;
    }

    /**
     * Getter method for the maxWorldRow variable
     * 
     * @return the maxWorldRow variable
     */
    public int getMaxWorldRow() {
        return maxWorldRow;
    }

    /**
     * Getter method for the tileManager variable
     * 
     * @return the tileManager variable
     */
    public TileManager getTileManager() {
        return tileManager;
    }

    /**
     * Getter method for the cChecker variable
     * 
     * @return the cChecker variable
     */
    public CollisionChecker getCChecker() {
        return cChecker;
    }

    /**
     * Getter method for the player variable
     * 
     * @return the player variable
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Getter method for the obj variable
     * 
     * @return the obj variable
     */
    public DrawingObject[] getObj() {
        return obj;
    }

}
