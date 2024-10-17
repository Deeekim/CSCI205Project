import java.awt.*;
import java.awt.geom.*;
import java.util.Random;

public class Player extends Entity {

    private SceneCanvas sc;
    private KeyHandle keyH;

    private Random rand;

    private final int screenX;
    private final int screenY;
    private int score = 0;
    
    public Player(SceneCanvas sc, KeyHandle keyH) {
        this.sc = sc;
        this.keyH = keyH;
        this.rand = new Random();

        screenX = sc.getScreenWidth()/2 - (sc.getTileSize()/2);
        screenY = sc.getScreenHeight()/2 - (sc.getTileSize()/2);

        this.setSolidArea(new Rectangle(0,0,32,32));
        this.setSolidAreaDefaultX(this.getSolidAreaX());
        this.setSolidAreaDefaultY(this.getSolidAreaY());
        setDefaultValues();

    }

    public void setDefaultValues() {
        this.setWorldX(sc.getTileSize() * 27);
        this.setWorldY(sc.getTileSize() * 23);
        this.setSpeed(4);
        this.setDirection("S");
    }

    public void update() {

        if(keyH.getUpPressed() == true || keyH.getDownPressed() == true || 
        keyH.getLeftPressed() == true || keyH.getRightPressed() == true) {

            if (keyH.getUpPressed()) {
                if (keyH.getRightPressed()) {
                    this.setDirection("NE");
                } else if (keyH.getLeftPressed()) {
                    this.setDirection("NW");
                } else {
                    this.setDirection("N");
                }
            } else if (keyH.getDownPressed()) {
                if (keyH.getRightPressed()) {
                    this.setDirection("SE");
                } else if (keyH.getLeftPressed()) {
                    this.setDirection("SW");
                } else {
                    this.setDirection("S");
                }                
            } else if (keyH.getLeftPressed()) {
                this.setDirection("W");
                
            } else if (keyH.getRightPressed()) {
                this.setDirection("E");
                
            } 
        
            // Check Tile Collision
            this.setCollisionOn(false);
            sc.getCChecker().checkTile(this);

            // Check Object Collision
            int objIndex = sc.getCChecker().checkObject(this, true);
            pickUpObject(objIndex);

            // If Collision is False, player can move
            if (getCollisionOn() == false) {
                switch(getDirection()) {
                case "N": this.setWorldY(this.getWorldY() - this.getSpeed()); break;
                case "NE": this.setWorldY(this.getWorldY() - this.getSpeed()); this.setWorldX(this.getWorldX() + this.getSpeed()); break;
                case "NW": this.setWorldY(this.getWorldY() - this.getSpeed()); this.setWorldX(this.getWorldX() - this.getSpeed()); break;
                case "S": this.setWorldY(this.getWorldY() + this.getSpeed()); break;
                case "SE": this.setWorldY(this.getWorldY() + this.getSpeed()); this.setWorldX(this.getWorldX() + this.getSpeed()); break;
                case "SW": this.setWorldY(this.getWorldY() + this.getSpeed()); this.setWorldX(this.getWorldX() - this.getSpeed()); break;
                case "W": this.setWorldX(this.getWorldX() - this.getSpeed()); break;
                case "E": this.setWorldX(this.getWorldX() + this.getSpeed()); break;
                }
            }
            
        }
    
    }
    
    public void pickUpObject(int i) {

        if(i != 999) {

            String objectName = sc.getObj()[i].getName();
            
            switch(objectName) {
            case "Dot":
                score++;
                sc.getObj()[i] = null;
                int tileNum, screenTileX, screenTileY = 0;

                do {
                    screenTileX = rand.nextInt(50);
                    screenTileY = rand.nextInt(50);
                    tileNum = sc.getTileManager().getMapTileNum()[screenTileX][screenTileY];
                } while (sc.getTileManager().getTiles()[tileNum].getCollision() != false);
                
                System.out.printf("A new dot appeared at %d, %d!\n", screenTileY, screenTileX);
                sc.getObj()[i] = new Dot(screenTileY * sc.getTileSize(), screenTileX * sc.getTileSize());

            }

        }
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.RED);
        Rectangle2D.Double r1 = new Rectangle2D.Double(screenX, screenY, 32 + getSpeed(), 32 + getSpeed());
        g2d.fill(r1);
    }

    public int getScreenX() {
        return screenX;
    }

    public int getScreenY() {
        return screenY;
    }

    public int getScore() {
        return score;
    }

}
