import java.awt.*;

public class Entity {
    
    private int worldX, worldY;
    private int speed;
    private String direction;
    private boolean collisionOn = false;
    private Rectangle solidArea;
    private int solidAreaDefaultX, solidAreaDefaultY;

    public Entity() {
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

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public boolean getCollisionOn() {
        return collisionOn;
    }

    public void setCollisionOn(boolean collisionOn) {
        this.collisionOn = collisionOn;
    }

    public Rectangle getSolidArea() {
        return solidArea;
    }

    public void setSolidArea(Rectangle solidArea) {
        this.solidArea = solidArea;
    }

    public int getSolidAreaDefaultX() {
        return solidAreaDefaultX;
    }

    public void setSolidAreaDefaultX(int solidAreaDefaultX) {
        this.solidAreaDefaultX = solidAreaDefaultX;
    }

    public int getSolidAreaDefaultY() {
        return solidAreaDefaultY;
    }

    public void setSolidAreaDefaultY(int solidAreaDefaultY) {
        this.solidAreaDefaultY = solidAreaDefaultY;
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

    public void setSolidAreaX(int x) {
        this.solidArea.x = x;
    }

    public void setSolidAreaY(int y) {
        this.solidArea.y = y;
    }

    public void setSolidAreaWidth(int width) {
        this.solidArea.width = width;
    }

    public void setSolidAreaHeight(int height) {
        this.solidArea.height = height;
    }

}
