import java.awt.*;
import java.awt.geom.*;
import java.util.Random;

/**
* Player
*
* Description: The class is an extension of the Entity class, which has the capacity
* to take key inputs. The user will be controlling the movement of this class across the world map.
* This code creates a Player class that extends the Entity class with the capacity to
* Authors: Michael Deekimcheng and Miguel Yapan
* ID Number: 205641, 205501
* Date: October 11, 2024
*/
public class Player extends Entity {

    private SceneCanvas sc;
    private KeyHandle keyH;

    private Random rand;

    private final int screenX;
    private final int screenY;
    private int score = 0;

    /**
    * Constructs a Player with specified SceneCanvas and KeyHandle.
    *
    * @param gc the SceneCanvas that provides the player's world and screen coordinates
    * @param keyH the KeyHandle that manages key inputs for the player's movement
    */
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
    
    /**
    * Instantiates default values for the player's default worldX and worldY values,
    * default speed and default direction. WorldX and WorldY determines where the player
    * is first drawn during game creation.
    */
    public void setDefaultValues() {
        this.setWorldX(sc.getTileSize() * 27);
        this.setWorldY(sc.getTileSize() * 23);
        this.setSpeed(4);
        this.setDirection("S");
    }

    /**
    * Updates next state of the player upon, including direction of the player's movement, collision between the player
    * and a tile, and collision between the player and an object. The code can also alter the player's 
    * capacity to move depending on its direction and tiles/object in said direction.
    */
    public void update() {
        
        if(keyH.getUpPressed() == true || keyH.getDownPressed() == true || 
        keyH.getLeftPressed() == true || keyH.getRightPressed() == true) {
            
            /*
            * Set direction of the play depending on the keys pressed
            */ 
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

            /*
            * Runs the player is not colliding with any object or tile. Updates
            * worldX and worldY depending on the direction of the player.
            */
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

    /**
    * This method determines the behaviour of the player depending on the object the player
    * has collided with. 
    *
    * @param i the index of the object with the player collided
    */
    public void pickUpObject(int i) {

        // 999 can be replace with any arbitrary number beyond the length of object list
        if(i != 999) {

            String objectName = sc.getObj()[i].getName();
            
            switch(objectName) {
            case "Dot":

                /*
                * Updates the player's score and removes object 'Dot' on collision with player
                */
                score++;
                sc.getObj()[i] = null;
                int tileNum, screenTileX, screenTileY = 0;

                /*
                * Randomly places new 'Dot' on tile whose collision is false. The terminal prints out
                * the tile row and tile size where the new 'Dot' is created.
                */
                do {
                    screenTileX = rand.nextInt(50);
                    screenTileY = rand.nextInt(50);
                    tileNum = sc.getTileManager().getMapTileNum()[screenTileX][screenTileY];
                } while (sc.getTiles()[tileNum].getCollision() != false);
                System.out.printf("A new dot appeared at %d, %d!\n", screenTileY, screenTileX);
                sc.getObj()[i] = new Dot(screenTileY * sc.getTileSize(), screenTileX * sc.getTileSize());

            }

        }
    }

    /**
    * Draws the player on the screen
    *
    * @param g2d the graphics object for drawing the player
    */
    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.RED);
        Rectangle2D.Double r1 = new Rectangle2D.Double(screenX, screenY, 32 + getSpeed(), 32 + getSpeed());
        g2d.fill(r1);
    }

    /**
    * Return's the player's screen X-coordinate
    *
    * @return X-coordinate of player's position on screen
    */
    public int getScreenX() {
        return screenX;
    }

    /**
    * Return's the player's screen Y-coordinate
    *
    * @return Y-coordinate of player's position on screen
    */
    public int getScreenY() {
        return screenY;
    }

    /**
    * Return's the player's current score
    *
    * @return the player's score
    */
    public int getScore() {
        return score;
    }

}
