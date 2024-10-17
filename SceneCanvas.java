import java.awt.*;
import javax.swing.*;

public class SceneCanvas extends JComponent implements Runnable {

    // PIXEL SETTINGS
    private final int originalTileSize = 16;
    private final int scale = 3;

    // SCREEN SETTINGS
    private final int tileSize = originalTileSize * scale;
    private final int maxScreenCol = 18;
    private final int maxScreenRow = 14;
    private final int screenWidth = tileSize * maxScreenCol;
    private final int screenHeight = tileSize * maxScreenRow;

    // WORLD SETTINGS
    private final int maxWorldCol = 50;
    private final int maxWorldRow = 50;
    // private final int worldWidth = tileSize * maxWorldCol;
    // private final int worldHeight = tileSize * maxWorldRow;

    // FPS SETTINGS
    private int FPS = 60;

    private TileManager tileManager = new TileManager(this);
    private KeyHandle keyH = new KeyHandle();
    private Thread gameThread;
    private CollisionChecker cChecker = new CollisionChecker(this);
    private AssetSetter aSetter = new AssetSetter(this);
    private UI ui = new UI(this);

    private Player player = new Player(this, keyH);
    private DrawingObject[] obj = new DrawingObject[10];
    

    public SceneCanvas() {
        this.setPreferredSize(new Dimension(800, 600));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        // need to populate arrays here
        //trees[0] = new Tree(this, 100, 150);  // First tree
        //trees[1] = new Tree(this, 200, 250);  // Second tree
        //trees[2] = new Tree(this, 300, 100);  // Third tree
    }

    public void setUpGame() {
        aSetter.setObject();
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

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

    public void update() {
        player.update();
    }

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

    public int getTileSize() {
        return tileSize;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public int getMaxWorldCol() {
        return maxWorldCol;
    }

    public int getMaxWorldRow() {
        return maxWorldRow;
    }

    public TileManager getTileManager() {
        return tileManager;
    }

    public CollisionChecker getCChecker() {
        return cChecker;
    }

    public Player getPlayer() {
        return player;
    }

    public DrawingObject[] getObj() {
        return obj;
    }

}
