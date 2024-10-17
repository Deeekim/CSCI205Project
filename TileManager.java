import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {

    private SceneCanvas gc;
    private DrawingObject[] tiles; // Array of tile objects
    private int[][] mapTileNum; // Store which tile to use at each position

    public TileManager(SceneCanvas gc) {
        this.gc = gc;
        
        // Create an array of tiles
        tiles = new DrawingObject[10];
        loadTiles();

        // Example map: create a 2D array representing a grid of tile types
        mapTileNum = new int[gc.getMaxWorldCol()][gc.getMaxWorldRow()];
        loadMap();
    }

    public void loadTiles() {

        tiles[0] = new SandTile();  // Tile type 0: sand
        tiles[1] = new WallTile(); // Tile type 1: wall
        tiles[2] = new WaterTile(); // Tile type 2: water
        tiles[3] = new DogTile(); // Tile type 3: dog
        tiles[4] = new PalmTreeTile(); // Tile type 4: palm tree
        tiles[5] = new PathTile(); // Tile type 5: path

    }

    public void loadMap() {
 
        try {
            String map_name = "map1.txt";
            InputStream is = getClass().getResourceAsStream(map_name);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;
            
            while(col < gc.getMaxWorldCol() && row < gc.getMaxWorldRow()) {
                
                String line = br.readLine();

                while(col < gc.getMaxWorldCol()) {

                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[row][col] = num;
                    col++;
                    
                }
                if(col == gc.getMaxWorldCol()) {
                    col = 0;
                    row++;
                }

            }
            br.close();
        } catch(Exception e) {

        }
    }

    public void draw(Graphics2D g2d) {
        
        int worldCol = 0;
        int worldRow = 0;

        while(worldCol < gc.getMaxWorldCol() && worldRow < gc.getMaxWorldRow()) {
            int tileNum = mapTileNum[worldRow][worldCol];
            DrawingObject tile = tiles[tileNum];

            int worldX = worldCol * gc.getTileSize();
            int worldY = worldRow * gc.getTileSize();
            int screenX = worldX - gc.getPlayer().getWorldX() + gc.getPlayer().getScreenX();
            int screenY = worldY - gc.getPlayer().getWorldY() + gc.getPlayer().getScreenY();

            if (worldX > gc.getPlayer().getWorldX() - gc.getPlayer().getScreenX() - gc.getTileSize() && 
                worldX < gc.getPlayer().getWorldX() + gc.getPlayer().getScreenX() + gc.getTileSize() &&
                worldY > gc.getPlayer().getWorldY() - gc.getPlayer().getScreenY() - gc.getTileSize() && 
                worldY < gc.getPlayer().getWorldY() + gc.getPlayer().getScreenY() + gc.getTileSize()) {
                        g2d.translate(screenX, screenY);
                        tile.drawTile(g2d);
                        g2d.translate(-screenX, -screenY);
                    }

            // Move the tile to its correct position and draw it
            worldCol++;
            
            if (worldCol == gc.getMaxWorldCol()) {
                worldCol = 0;
                worldRow++;
            }
        }
    
    }

    public DrawingObject[] getTiles() {
        return tiles;
    }

    public int[][] getMapTileNum() {
        return mapTileNum;
    }

}

