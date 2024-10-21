/**
 * AssetSetter
 * 
 * Description: The class is responsible for initializing and setting various objects on the frame. 
 * In this project, it places `Dot` objects on the game scene at specified tiles.
 * Authors: Michael Deekimcheng, Miguel Yapan
 * ID Number: 205641, 205501
 * Date: October 15, 2024
 */
public class AssetSetter {
    
    private SceneCanvas sc;

    /**
     * Constructs an AssetSetter with the specified SceneCanvas sc.
     * 
     * @param gc the SceneCanvas instance that this AssetSetter will manage.
     */
    public AssetSetter(SceneCanvas sc) {
        this.sc = sc;
    }

    /**
     * Sets the objects on the scene by placing `Dot` objects at predefined 
     * positions. These initial positions are calculated by multiplying the tile size  
     * to a coder-identified column and row indices.
     * We can add more Dot objects by increasing the size of the object list.
     */
    public void setObject() {
        sc.getObj()[0] = new Dot(25 * sc.getTileSize(), 23 * sc.getTileSize());
        sc.getObj()[1] = new Dot(26 * sc.getTileSize(), 24 * sc.getTileSize());
        sc.getObj()[2] = new Dot(26 * sc.getTileSize(), 22 * sc.getTileSize());
    }

}
