/**
* Michael Deekimcheng and Miguel Yapan
* 205641 and 205501
* Date created: October 4, 2024
* 
* This class is responsible for detecting collisions between entities (like players) 
* and objects / tiles within the game. It assumes that each player, object, and tile possesses
* a regtangular hitbox. It uses the size and coordinates of each hitbox to determine whether
* intersections are disallowed, and adjusts the entity's state accordingly.
*/
public class CollisionChecker {

    private SceneCanvas sc;

    /**
    * Constructs a CollisionChecker with the specified SceneCanvas
    *
    * @param sc the SceneCanvas used for the game to call map and tile information
    */
    public CollisionChecker(SceneCanvas sc) {
        this.sc = sc;
    }

    /**
    * Checks whether a given entity is colliding with a tile in game. This method
    * relies on the entity's movement direction and tile properties to detect collision.
    *
    * @param entity the entity for which the collision is checked
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
            if (sc.getTileManager().getTiles()[tileNum1].getCollision() == true || sc.getTileManager().getTiles()[tileNum2].getCollision() == true) {
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
            if (sc.getTileManager().getTiles()[tileNum1].getCollision() == true || sc.getTileManager().getTiles()[tileNum2].getCollision() == true
            || sc.getTileManager().getTiles()[tileNum3].getCollision() == true || sc.getTileManager().getTiles()[tileNum4].getCollision() == true) {
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
            if (sc.getTileManager().getTiles()[tileNum1].getCollision() == true || sc.getTileManager().getTiles()[tileNum2].getCollision() == true
            || sc.getTileManager().getTiles()[tileNum3].getCollision() == true || sc.getTileManager().getTiles()[tileNum4].getCollision() == true) {
                entity.setCollisionOn(true);
            }
            break;
        case "S":
            entityBottomRow = (entityBottomWorldY + entity.getSpeed())/sc.getTileSize();
            tileNum1 = sc.getTileManager().getMapTileNum()[entityBottomRow][entityLeftCol];
            tileNum2 = sc.getTileManager().getMapTileNum()[entityBottomRow][entityRightCol];
            if (sc.getTileManager().getTiles()[tileNum1].getCollision() == true || sc.getTileManager().getTiles()[tileNum2].getCollision() == true) {
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
            if (sc.getTileManager().getTiles()[tileNum1].getCollision() == true || sc.getTileManager().getTiles()[tileNum2].getCollision() == true
            || sc.getTileManager().getTiles()[tileNum3].getCollision() == true || sc.getTileManager().getTiles()[tileNum4].getCollision() == true) {
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
            if (sc.getTileManager().getTiles()[tileNum1].getCollision() == true || sc.getTileManager().getTiles()[tileNum2].getCollision() == true
            || sc.getTileManager().getTiles()[tileNum3].getCollision() == true || sc.getTileManager().getTiles()[tileNum4].getCollision() == true) {
                entity.setCollisionOn(true);
            }
            break;
        case "W":
            entityLeftCol = (entityLeftWorldX - entity.getSpeed())/sc.getTileSize();
            tileNum1 = sc.getTileManager().getMapTileNum()[entityTopRow][entityLeftCol];
            tileNum2 = sc.getTileManager().getMapTileNum()[entityBottomRow][entityLeftCol];
            if (sc.getTileManager().getTiles()[tileNum1].getCollision() == true || sc.getTileManager().getTiles()[tileNum2].getCollision() == true) {
                entity.setCollisionOn(true);
            }
            break;
        case "E":
            entityRightCol = (entityRightWorldX + entity.getSpeed())/sc.getTileSize();
            tileNum1 = sc.getTileManager().getMapTileNum()[entityTopRow][entityRightCol];
            tileNum2 = sc.getTileManager().getMapTileNum()[entityBottomRow][entityRightCol];
            if (sc.getTileManager().getTiles()[tileNum1].getCollision() == true || sc.getTileManager().getTiles()[tileNum2].getCollision() == true) {
                entity.setCollisionOn(true);
            }
            break;
        }

        
    }

    /**
    * Checks for collisions between the entity an objects within the game world. We want only players to 
    * interact with objects, that is disallowing other entities such as monsters or NPCs to interact with objects.
    * This method will check if the object collision is done by the player or another entity. If collision is
    * detected, the method adjusts the entity's collision state and returns the index of the object collided with.
    * 
    * @param entity the entity for which the collision is checked
    * @param player a flag indicated whether the entity is the player or otherwise
    * @return the index of the object the entity collided with, or 999 (arbitrary) number if no collision occurs.
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
                // Reset solid area positions after checking.
                entity.setSolidAreaX(entity.getSolidAreaDefaultX());
                entity.setSolidAreaY(entity.getSolidAreaDefaultY());
                sc.getObj()[i].setSolidAreaX(sc.getObj()[i].getSolidAreaDefaultX());
                sc.getObj()[i].setSolidAreaY(sc.getObj()[i].getSolidAreaDefaultY());
            }
        }

        return index;
    }
}
