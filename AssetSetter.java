/**
 * The class is responsible for initializing and setting 
 * various objects on the frame. In this project, it places 
 * `Dot` objects on the game scene at specified tiles.
 */
public class AssetSetter {
    
    /** The object used for drawing the tiles, objects, and entities */
    private SceneCanvas gc;

    /**
     * Constructs an {@code AssetSetter} with the specified {@code SceneCanvas}.
     * 
     * @param gc the {@code SceneCanvas} instance that this {@code AssetSetter} will manage
     */
    public AssetSetter(SceneCanvas gc) {
        this.gc = gc;
    }

    /**
     * Sets the objects on the scene by placing `Dot` objects at predefined 
     * positions. These initial positions are calculated by multiplying the tile size  
     * to a coder-identified column and row indices.
     */
    public void setObject() {
        // Add more dots here depending on size of obj list
        gc.getObj()[0] = new Dot(25 * gc.getTileSize(), 23 * gc.getTileSize());
        gc.getObj()[1] = new Dot(26 * gc.getTileSize(), 24 * gc.getTileSize());
        gc.getObj()[2] = new Dot(26 * gc.getTileSize(), 22 * gc.getTileSize());
    }

}
