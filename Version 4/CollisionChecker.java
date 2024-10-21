
public class CollisionChecker {

    private SceneCanvas gc;

    public CollisionChecker(SceneCanvas gc) {
        this.gc = gc;
    }

    // Check collision between player and tree objects
    public void checkTile(Entity entity) {

        int entityLeftWorldX = entity.getWorldX() + entity.getSolidAreaX();
        int entityRightWorldX = entity.getWorldX() + entity.getSolidAreaX() + entity.getSolidAreaWidth();
        int entityTopWorldY = entity.getWorldY() + entity.getSolidAreaY();
        int entityBottomWorldY = entity.getWorldY() + entity.getSolidAreaY() + entity.getSolidAreaHeight();
        
        int entityLeftCol = entityLeftWorldX/gc.getTileSize();
        int entityRightCol = entityRightWorldX/gc.getTileSize();
        int entityTopRow = entityTopWorldY/gc.getTileSize();
        int entityBottomRow = entityBottomWorldY/gc.getTileSize();

        int tileNum1, tileNum2, tileNum3, tileNum4;
        switch(entity.getDirection()) {
        case "N":
            entityTopRow = (entityTopWorldY - entity.getSpeed())/gc.getTileSize();
            tileNum1 = gc.getTileManager().getMapTileNum()[entityTopRow][entityLeftCol];
            tileNum2 = gc.getTileManager().getMapTileNum()[entityTopRow][entityRightCol];
            if (gc.getTileManager().getTiles()[tileNum1].getCollision() == true || gc.getTileManager().getTiles()[tileNum2].getCollision() == true) {
                entity.setCollisionOn(true);
            }
            break;
        case "NW":
            entityTopRow = (entityTopWorldY - entity.getSpeed())/gc.getTileSize();
            entityLeftCol = (entityLeftWorldX - entity.getSpeed())/gc.getTileSize();
            tileNum1 = gc.getTileManager().getMapTileNum()[entityTopRow][entityLeftCol];
            tileNum2 = gc.getTileManager().getMapTileNum()[entityTopRow][entityRightCol];
            tileNum3 = gc.getTileManager().getMapTileNum()[entityTopRow][entityLeftCol];
            tileNum4 = gc.getTileManager().getMapTileNum()[entityBottomRow][entityLeftCol];
            if (gc.getTileManager().getTiles()[tileNum1].getCollision() == true || gc.getTileManager().getTiles()[tileNum2].getCollision() == true
            || gc.getTileManager().getTiles()[tileNum3].getCollision() == true || gc.getTileManager().getTiles()[tileNum4].getCollision() == true) {
                entity.setCollisionOn(true);
            }
            break;
        case "NE":
            entityTopRow = (entityTopWorldY - entity.getSpeed())/gc.getTileSize();
            entityRightCol = (entityRightWorldX + entity.getSpeed())/gc.getTileSize();
            tileNum1 = gc.getTileManager().getMapTileNum()[entityTopRow][entityLeftCol];
            tileNum2 = gc.getTileManager().getMapTileNum()[entityTopRow][entityRightCol];
            tileNum3 = gc.getTileManager().getMapTileNum()[entityTopRow][entityRightCol];
            tileNum4 = gc.getTileManager().getMapTileNum()[entityBottomRow][entityRightCol];
            if (gc.getTileManager().getTiles()[tileNum1].getCollision() == true || gc.getTileManager().getTiles()[tileNum2].getCollision() == true
            || gc.getTileManager().getTiles()[tileNum3].getCollision() == true || gc.getTileManager().getTiles()[tileNum4].getCollision() == true) {
                entity.setCollisionOn(true);
            }
            break;
        case "S":
            entityBottomRow = (entityBottomWorldY + entity.getSpeed())/gc.getTileSize();
            tileNum1 = gc.getTileManager().getMapTileNum()[entityBottomRow][entityLeftCol];
            tileNum2 = gc.getTileManager().getMapTileNum()[entityBottomRow][entityRightCol];
            if (gc.getTileManager().getTiles()[tileNum1].getCollision() == true || gc.getTileManager().getTiles()[tileNum2].getCollision() == true) {
                entity.setCollisionOn(true);
            }
            break;
        case "SW":
            entityBottomRow = (entityBottomWorldY + entity.getSpeed())/gc.getTileSize();
            entityLeftCol = (entityLeftWorldX - entity.getSpeed())/gc.getTileSize();
            tileNum1 = gc.getTileManager().getMapTileNum()[entityBottomRow][entityLeftCol];
            tileNum2 = gc.getTileManager().getMapTileNum()[entityBottomRow][entityRightCol];
            tileNum3 = gc.getTileManager().getMapTileNum()[entityTopRow][entityLeftCol];
            tileNum4 = gc.getTileManager().getMapTileNum()[entityBottomRow][entityLeftCol];
            if (gc.getTileManager().getTiles()[tileNum1].getCollision() == true || gc.getTileManager().getTiles()[tileNum2].getCollision() == true
            || gc.getTileManager().getTiles()[tileNum3].getCollision() == true || gc.getTileManager().getTiles()[tileNum4].getCollision() == true) {
                entity.setCollisionOn(true);
            }
            break; 
        case "SE":
            entityBottomRow = (entityBottomWorldY + entity.getSpeed())/gc.getTileSize();
            entityRightCol = (entityRightWorldX + entity.getSpeed())/gc.getTileSize();
            tileNum1 = gc.getTileManager().getMapTileNum()[entityBottomRow][entityLeftCol];
            tileNum2 = gc.getTileManager().getMapTileNum()[entityBottomRow][entityRightCol];
            tileNum3 = gc.getTileManager().getMapTileNum()[entityTopRow][entityRightCol];
            tileNum4 = gc.getTileManager().getMapTileNum()[entityBottomRow][entityRightCol];
            if (gc.getTileManager().getTiles()[tileNum1].getCollision() == true || gc.getTileManager().getTiles()[tileNum2].getCollision() == true
            || gc.getTileManager().getTiles()[tileNum3].getCollision() == true || gc.getTileManager().getTiles()[tileNum4].getCollision() == true) {
                entity.setCollisionOn(true);
            }
            break;
        case "W":
            entityLeftCol = (entityLeftWorldX - entity.getSpeed())/gc.getTileSize();
            tileNum1 = gc.getTileManager().getMapTileNum()[entityTopRow][entityLeftCol];
            tileNum2 = gc.getTileManager().getMapTileNum()[entityBottomRow][entityLeftCol];
            if (gc.getTileManager().getTiles()[tileNum1].getCollision() == true || gc.getTileManager().getTiles()[tileNum2].getCollision() == true) {
                entity.setCollisionOn(true);
            }
            break;
        case "E":
            entityRightCol = (entityRightWorldX + entity.getSpeed())/gc.getTileSize();
            tileNum1 = gc.getTileManager().getMapTileNum()[entityTopRow][entityRightCol];
            tileNum2 = gc.getTileManager().getMapTileNum()[entityBottomRow][entityRightCol];
            if (gc.getTileManager().getTiles()[tileNum1].getCollision() == true || gc.getTileManager().getTiles()[tileNum2].getCollision() == true) {
                entity.setCollisionOn(true);
            }
            break;
        }

        
    }

    public int checkObject(Entity entity, boolean player) {

        int index = 999;

        for(int i = 0; i < gc.getObj().length; i++) {
            if(gc.getObj()[i] != null) {

                // Get entity's solid area position
                entity.setSolidAreaX(entity.getWorldX() + entity.getSolidAreaX());
                entity.setSolidAreaY(entity.getWorldY() + entity.getSolidAreaY());
                // Get the object's solid area position
                gc.getObj()[i].setSolidAreaX(gc.getObj()[i].getWorldX() + gc.getObj()[i].getSolidAreaX());
                gc.getObj()[i].setSolidAreaY(gc.getObj()[i].getWorldY() + gc.getObj()[i].getSolidAreaY());

                switch(entity.getDirection()) {
                case "N":
                case "NE":
                case "NW":
                    entity.setSolidAreaY(entity.getSolidAreaY() - entity.getSpeed());
                    if(entity.getSolidArea().intersects(gc.getObj()[i].getSolidArea())) {
                        if(gc.getObj()[i].getCollision() == true) {
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
                    if(entity.getSolidArea().intersects(gc.getObj()[i].getSolidArea())) {
                        if(gc.getObj()[i].getCollision() == true) {
                            entity.setCollisionOn(true);
                        }
                        if(player == true) {
                            index = i;
                        }
                    }
                    break;
                case "W":
                    entity.setSolidAreaX(entity.getSolidAreaX() - entity.getSpeed());
                    if(entity.getSolidArea().intersects(gc.getObj()[i].getSolidArea())) {
                        if(gc.getObj()[i].getCollision() == true) {
                            entity.setCollisionOn(true);
                        }
                        if(player == true) {
                            index = i;
                        }
                    }
                    break;
                case "E":
                    entity.setSolidAreaX(entity.getSolidAreaX() + entity.getSpeed());
                    if(entity.getSolidArea().intersects(gc.getObj()[i].getSolidArea())) {
                        if(gc.getObj()[i].getCollision() == true) {
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
                gc.getObj()[i].setSolidAreaX(gc.getObj()[i].getSolidAreaDefaultX());
                gc.getObj()[i].setSolidAreaY(gc.getObj()[i].getSolidAreaDefaultY());
            }
        }

        return index;
    }
}
