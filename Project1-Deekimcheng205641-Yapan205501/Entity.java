import java.awt.*;

/**
 * Entity
 *
 * Description: The class is used to store information about objects that move in the map.
 * Authors: Michael Deekimcheng, Miguel Yapan
 * ID Numbers: 205641, 205501
 * Date: September 29, 2024
 */
public class Entity {
    
    private int worldX, worldY;
    private int speed;
    private String direction;
    private boolean collisionOn = false;
    private Rectangle solidArea;
    private int solidAreaDefaultX, solidAreaDefaultY;

    /** The constructor is empty as the class is used just to store information about the entity subclasses. */
    public Entity() {
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
     * Getter method for the speed variable
     * 
     * @return the speed variable
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Setter method for the speed variable
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * Getter method for the direction variable
     * 
     * @return the direction variable
     */
    public String getDirection() {
        return direction;
    }

    /**
     * Setter method for the direction variable
     */
    public void setDirection(String direction) {
        this.direction = direction;
    }

    /**
     * Getter method for the collisionOn variable
     * 
     * @return the collisionOn variable
     */
    public boolean getCollisionOn() {
        return collisionOn;
    }

    /**
     * Setter method for the collisionOn variable
     */
    public void setCollisionOn(boolean collisionOn) {
        this.collisionOn = collisionOn;
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
     * Setter method for the solidArea variable
     */
    public void setSolidArea(Rectangle solidArea) {
        this.solidArea = solidArea;
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
     * Setter method for the solidAreaDefaultX variable
     */
    public void setSolidAreaDefaultX(int solidAreaDefaultX) {
        this.solidAreaDefaultX = solidAreaDefaultX;
    }

    /**
     * Getter method for the solidAreaDefaultY variable
     * 
     * @return the solidAreaDefaultY variable
     */
    public int getSolidAreaDefaultY() {
        return solidAreaDefaultY;
    }

    /**
     * Setter method for the solidAreaDefaultY variable
     */
    public void setSolidAreaDefaultY(int solidAreaDefaultY) {
        this.solidAreaDefaultY = solidAreaDefaultY;
    }

    /**
     * Getter method for the x parameter of the solidArea variable
     * 
     * @return solidArea.x
     */
    public int getSolidAreaX() {
        return solidArea.x;
    }

    /**
     * Getter method for the y parameter of the solidArea variable
     * 
     * @return solidArea.y
     */
    public int getSolidAreaY() {
        return solidArea.y;
    }

    /**
     * Getter method for the width parameter of the solidArea variable
     * 
     * @return solidArea.width
     */
    public int getSolidAreaWidth() {
        return solidArea.width;
    }

    /**
     * Getter method for the height parameter of the solidArea variable
     * 
     * @return solidArea.height
     */
    public int getSolidAreaHeight() {
        return solidArea.height;
    }

    /**
     * Setter method for the x parameter of the solidArea variable
     */
    public void setSolidAreaX(int x) {
        this.solidArea.x = x;
    }

    /**
     * Setter method for the y parameter of the solidArea variable
     */
    public void setSolidAreaY(int y) {
        this.solidArea.y = y;
    }

    /**
     * Setter method for the width parameter of the solidArea variable
     */
    public void setSolidAreaWidth(int width) {
        this.solidArea.width = width;
    }

    /**
     * Setter method for the height parameter of the solidArea variable
     */
    public void setSolidAreaHeight(int height) {
        this.solidArea.height = height;
    }

}
