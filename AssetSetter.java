/**
* Michael Deekimcheng and Miguel Yapan
* 205641 and 205501
* Date created: October 12, 2024
*
* The class is responsible for initializing and setting 
* various objects on the frame. In this project, it places 
* `Dot` objects on the game scene at specified tiles.
*/
public class AssetSetter {
    
    private SceneCanvas gc;

    /**
    * Constructs an AssetSetter with the specified SceneCanvas.
    * 
    * @param gc the SceneCanvas instance that this AssetSetter will manage
    */
    public AssetSetter(SceneCanvas gc) {
        this.gc = gc;
    }

    /**
     * Sets the objects on the scene by placing `Dot` objects at predefined 
     * positions. These initial positions are identified by multiplying the tile size  
     * to any column and row indices. The dots must be placed on a non-collision tile.
     * Otherwise, there is no way for the player to access the object in game.
     */
    public void setObject() {
        // Add more dots here depending on size of obj list
        gc.getObj()[0] = new Dot(25 * gc.getTileSize(), 23 * gc.getTileSize());
        gc.getObj()[1] = new Dot(26 * gc.getTileSize(), 24 * gc.getTileSize());
        gc.getObj()[2] = new Dot(26 * gc.getTileSize(), 22 * gc.getTileSize());
    }

}
