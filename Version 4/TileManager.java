import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
* TileManager
*
* Description: This class is responsible for storing information on the game's world map,
* including which tile is assigned to which x and y coordinates. The class also ensures that 
* tiles are loaded correctly, specifically tiles that fit within the frame size. This helps reduce
* issues in rendering too much game elements at once.
* Authors: Michael Deekimcheng, Miguel Yapan
* ID Number: 205641, 205501
* Date: October 6, 2024
*/
public class TileManager {

    private SceneCanvas sc;
    private DrawingObject[] tiles; 
    private int[][] mapTileNum; 

    /**
    * Constructs a TileManager for the given SceneCavas
    *
    * @param sc the SceneCanvas which the map will be drawn on
    */
    public TileManager(SceneCanvas sc) {
        this.sc = sc;
        
        // Create an array of tiles
        tiles = new DrawingObject[10];
        loadTiles();

        // Create a 2D array of integers for tiles to reference
        mapTileNum = new int[sc.getMaxWorldCol()][sc.getMaxWorldRow()];
        loadMap("map1.txt");
    }

    /**
    * Instantiates and assigns an integer to each possible tile type in the game
    */
    public void loadTiles() {

        tiles[0] = new SandTile();  // Tile type 0: sand
        tiles[1] = new WallTile(); // Tile type 1: wall
        tiles[2] = new WaterTile(); // Tile type 2: water
        tiles[3] = new DogTile(); // Tile type 3: dog
        tiles[4] = new PalmTreeTile(); // Tile type 4: palm tree
        tiles[5] = new PathTile(); // Tile type 5: path

    }

    /**
    * Instantiates a map with tiles given an .txt input file of length 50 integers by 50 integers containing 
    * white-spaced separated integers ranging from 0 to the number of tiles loaded. The number of integers
    * depends on the maximum number of world columns and maximum number of world rows given by variables
    * maxWorldCol and maxWorldRow, repsectively.
    * 
    * @param map_name the name of the .txt file storing integers
    */
    public void loadMap(String map_name) {
 
        try {
            InputStream is = getClass().getResourceAsStream(map_name);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;
            
            while(col < sc.getMaxWorldCol() && row < sc.getMaxWorldRow()) {
                
                String line = br.readLine();

                while(col < sc.getMaxWorldCol()) {

                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[row][col] = num;
                    col++;
                    
                }
                if(col == sc.getMaxWorldCol()) {
                    col = 0;
                    row++;
                }

            }
            br.close();
        } catch(Exception e) {

        }
    }

    /**
    * Draws the tiles on the screen that fit within the player's screen
    * 
    * @param g2d the Graphics2D object used for drawing the tiles
    */
    public void draw(Graphics2D g2d) {
        
        int worldCol = 0;
        int worldRow = 0;

        while(worldCol < sc.getMaxWorldCol() && worldRow < sc.getMaxWorldRow()) {
            int tileNum = mapTileNum[worldRow][worldCol];
            DrawingObject tile = tiles[tileNum];

            int worldX = worldCol * sc.getTileSize();
            int worldY = worldRow * sc.getTileSize();
            int screenX = worldX - sc.getPlayer().getWorldX() + sc.getPlayer().getScreenX();
            int screenY = worldY - sc.getPlayer().getWorldY() + sc.getPlayer().getScreenY();

            if (worldX > sc.getPlayer().getWorldX() - sc.getPlayer().getScreenX() - sc.getTileSize() && 
                worldX < sc.getPlayer().getWorldX() + sc.getPlayer().getScreenX() + sc.getTileSize() &&
                worldY > sc.getPlayer().getWorldY() - sc.getPlayer().getScreenY() - sc.getTileSize() && 
                worldY < sc.getPlayer().getWorldY() + sc.getPlayer().getScreenY() + sc.getTileSize()) {
                        g2d.translate(screenX, screenY);
                        tile.drawTile(g2d);
                        g2d.translate(-screenX, -screenY);
                    }

            // Move the tile to its correct position and draw it
            worldCol++;
            
            if (worldCol == sc.getMaxWorldCol()) {
                worldCol = 0;
                worldRow++;
            }
        }
    
    }

    /**
    * Returns the array of different tile types
    *
    * @return array of tiles
    */
    public DrawingObject[] getTiles() {
        return tiles;
    }

    /**
    * Returns the 2D array of integers corresponding to tile number
    *
    * @return 2D array of integers 
    */
    public int[][] getMapTileNum() {
        return mapTileNum;
    }

}

