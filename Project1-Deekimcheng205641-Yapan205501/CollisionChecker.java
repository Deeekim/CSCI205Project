
/**
 * CollisionChecker
 * 
 * Description: A class that checks if the entity is colliding with any object
 * Authors: Michael Deekimcheng, Miguel Yapan
 * ID Number: 205641, 205501
 * Date: October 2, 2024
 */
public class CollisionChecker {

    private SceneCanvas sc;

    /**
     * Constructs a CollisionChecker class with the SceneCanvas variable 
     * 
     * @param sc the SceneCanvas variable
     */
    public CollisionChecker(SceneCanvas sc) {
        this.sc = sc;
    }

    /**
     * Checks if the Entity object is colliding with other tiles.
     * If the entity is colliding, the Collision variable of the Entity will be set to true.
     * 
     * @param entity the Entity object that is being checked on.
     */
    public void checkTile(Entity entity) {

        int entityLeftWorldX = entity.getWorldX() + entity.getSolidAreaX();
        int entityRightWorldX = entity.getWorldX() + entity.getSolidAreaX() + entity.getSolidAreaWidth();
        int entityTopWorldY = entity.getWorldY() + entity.getSolidAreaY();
        int entityBottomWorldY = entity.getWorldY() + entity.getSolidAreaY() + entity.getSolidAreaHeight();
        
        int entityLeftCol = entityLeftWorldX/sc.getTileSize();
        int entityRightCol = entityRightWorldX/sc.getTileSize();
        int entityTopRow = entityTopWorldY/sc.getTileSize();
        int entityBottomRow = entityBottomWorldY/sc.getTileSize();

        int tileNum1, tileNum2, tileNum3, tileNum4;
        switch(entity.getDirection()) {
        case "N":
            entityTopRow = (entityTopWorldY - entity.getSpeed())/sc.getTileSize();
            tileNum1 = sc.getTileManager().getMapTileNum()[entityTopRow][entityLeftCol];
            tileNum2 = sc.getTileManager().getMapTileNum()[entityTopRow][entityRightCol];
            if (sc.getTiles()[tileNum1].getCollision() == true || sc.getTiles()[tileNum2].getCollision() == true) {
                entity.setCollisionOn(true);
            }
            break;
        case "NW":
            entityTopRow = (entityTopWorldY - entity.getSpeed())/sc.getTileSize();
            entityLeftCol = (entityLeftWorldX - entity.getSpeed())/sc.getTileSize();
            tileNum1 = sc.getTileManager().getMapTileNum()[entityTopRow][entityLeftCol];
            tileNum2 = sc.getTileManager().getMapTileNum()[entityTopRow][entityRightCol];
            tileNum3 = sc.getTileManager().getMapTileNum()[entityTopRow][entityLeftCol];
            tileNum4 = sc.getTileManager().getMapTileNum()[entityBottomRow][entityLeftCol];
            if (sc.getTiles()[tileNum1].getCollision() == true || sc.getTiles()[tileNum2].getCollision() == true
            || sc.getTiles()[tileNum3].getCollision() == true || sc.getTiles()[tileNum4].getCollision() == true) {
                entity.setCollisionOn(true);
            }
            break;
        case "NE":
            entityTopRow = (entityTopWorldY - entity.getSpeed())/sc.getTileSize();
            entityRightCol = (entityRightWorldX + entity.getSpeed())/sc.getTileSize();
            tileNum1 = sc.getTileManager().getMapTileNum()[entityTopRow][entityLeftCol];
            tileNum2 = sc.getTileManager().getMapTileNum()[entityTopRow][entityRightCol];
            tileNum3 = sc.getTileManager().getMapTileNum()[entityTopRow][entityRightCol];
            tileNum4 = sc.getTileManager().getMapTileNum()[entityBottomRow][entityRightCol];
            if (sc.getTiles()[tileNum1].getCollision() == true || sc.getTiles()[tileNum2].getCollision() == true
            || sc.getTiles()[tileNum3].getCollision() == true || sc.getTiles()[tileNum4].getCollision() == true) {
                entity.setCollisionOn(true);
            }
            break;
        case "S":
            entityBottomRow = (entityBottomWorldY + entity.getSpeed())/sc.getTileSize();
            tileNum1 = sc.getTileManager().getMapTileNum()[entityBottomRow][entityLeftCol];
            tileNum2 = sc.getTileManager().getMapTileNum()[entityBottomRow][entityRightCol];
            if (sc.getTiles()[tileNum1].getCollision() == true || sc.getTiles()[tileNum2].getCollision() == true) {
                entity.setCollisionOn(true);
            }
            break;
        case "SW":
            entityBottomRow = (entityBottomWorldY + entity.getSpeed())/sc.getTileSize();
            entityLeftCol = (entityLeftWorldX - entity.getSpeed())/sc.getTileSize();
            tileNum1 = sc.getTileManager().getMapTileNum()[entityBottomRow][entityLeftCol];
            tileNum2 = sc.getTileManager().getMapTileNum()[entityBottomRow][entityRightCol];
            tileNum3 = sc.getTileManager().getMapTileNum()[entityTopRow][entityLeftCol];
            tileNum4 = sc.getTileManager().getMapTileNum()[entityBottomRow][entityLeftCol];
            if (sc.getTiles()[tileNum1].getCollision() == true || sc.getTiles()[tileNum2].getCollision() == true
            || sc.getTiles()[tileNum3].getCollision() == true || sc.getTiles()[tileNum4].getCollision() == true) {
                entity.setCollisionOn(true);
            }
            break; 
        case "SE":
            entityBottomRow = (entityBottomWorldY + entity.getSpeed())/sc.getTileSize();
            entityRightCol = (entityRightWorldX + entity.getSpeed())/sc.getTileSize();
            tileNum1 = sc.getTileManager().getMapTileNum()[entityBottomRow][entityLeftCol];
            tileNum2 = sc.getTileManager().getMapTileNum()[entityBottomRow][entityRightCol];
            tileNum3 = sc.getTileManager().getMapTileNum()[entityTopRow][entityRightCol];
            tileNum4 = sc.getTileManager().getMapTileNum()[entityBottomRow][entityRightCol];
            if (sc.getTiles()[tileNum1].getCollision() == true || sc.getTiles()[tileNum2].getCollision() == true
            || sc.getTiles()[tileNum3].getCollision() == true || sc.getTiles()[tileNum4].getCollision() == true) {
                entity.setCollisionOn(true);
            }
            break;
        case "W":
            entityLeftCol = (entityLeftWorldX - entity.getSpeed())/sc.getTileSize();
            tileNum1 = sc.getTileManager().getMapTileNum()[entityTopRow][entityLeftCol];
            tileNum2 = sc.getTileManager().getMapTileNum()[entityBottomRow][entityLeftCol];
            if (sc.getTiles()[tileNum1].getCollision() == true || sc.getTiles()[tileNum2].getCollision() == true) {
                entity.setCollisionOn(true);
            }
            break;
        case "E":
            entityRightCol = (entityRightWorldX + entity.getSpeed())/sc.getTileSize();
            tileNum1 = sc.getTileManager().getMapTileNum()[entityTopRow][entityRightCol];
            tileNum2 = sc.getTileManager().getMapTileNum()[entityBottomRow][entityRightCol];
            if (sc.getTiles()[tileNum1].getCollision() == true || sc.getTiles()[tileNum2].getCollision() == true) {
                entity.setCollisionOn(true);
            }
            break;
        }

        
    }

    /**
     * Checks if the Entity object is colliding with other objects in general.
     * 
     * @param entity the Entity object that is being checked on
     * @param player a boolean parameter that is set to true if the Entity is a Player class
     * @return the index of the object that the entity is colliding with
     */
    public int checkObject(Entity entity, boolean player) {

        int index = 999;

        for(int i = 0; i < sc.getObj().length; i++) {
            if(sc.getObj()[i] != null) {

                // Get entity's solid area position
                entity.setSolidAreaX(entity.getWorldX() + entity.getSolidAreaX());
                entity.setSolidAreaY(entity.getWorldY() + entity.getSolidAreaY());
                // Get the object's solid area position
                sc.getObj()[i].setSolidAreaX(sc.getObj()[i].getWorldX() + sc.getObj()[i].getSolidAreaX());
                sc.getObj()[i].setSolidAreaY(sc.getObj()[i].getWorldY() + sc.getObj()[i].getSolidAreaY());

                switch(entity.getDirection()) {
                case "N":
                case "NE":
                case "NW":
                    entity.setSolidAreaY(entity.getSolidAreaY() - entity.getSpeed());
                    if(entity.getSolidArea().intersects(sc.getObj()[i].getSolidArea())) {
                        if(sc.getObj()[i].getCollision() == true) {
                            entity.setCollisionOn(true);
                        }
                        if(player == true) {
                            index = i;
                        }
                    }
                    break;
                case "S":
                case "SE":
                case "SW":
                    entity.setSolidAreaY(entity.getSolidAreaY() + entity.getSpeed());
                    if(entity.getSolidArea().intersects(sc.getObj()[i].getSolidArea())) {
                        if(sc.getObj()[i].getCollision() == true) {
                            entity.setCollisionOn(true);
                        }
                        if(player == true) {
                            index = i;
                        }
                    }
                    break;
                case "W":
                    entity.setSolidAreaX(entity.getSolidAreaX() - entity.getSpeed());
                    if(entity.getSolidArea().intersects(sc.getObj()[i].getSolidArea())) {
                        if(sc.getObj()[i].getCollision() == true) {
                            entity.setCollisionOn(true);
                        }
                        if(player == true) {
                            index = i;
                        }
                    }
                    break;
                case "E":
                    entity.setSolidAreaX(entity.getSolidAreaX() + entity.getSpeed());
                    if(entity.getSolidArea().intersects(sc.getObj()[i].getSolidArea())) {
                        if(sc.getObj()[i].getCollision() == true) {
                            entity.setCollisionOn(true);
                        }
                        if(player == true) {
                            index = i;
                        }
                    }
                    break;
                }
                entity.setSolidAreaX(entity.getSolidAreaDefaultX());
                entity.setSolidAreaY(entity.getSolidAreaDefaultY());
                sc.getObj()[i].setSolidAreaX(sc.getObj()[i].getSolidAreaDefaultX());
                sc.getObj()[i].setSolidAreaY(sc.getObj()[i].getSolidAreaDefaultY());
            }
        }

        return index;
    }
}
