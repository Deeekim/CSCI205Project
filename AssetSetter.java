public class AssetSetter {
    
    private SceneCanvas gc;

    public AssetSetter(SceneCanvas gc) {
        
        this.gc = gc;

    }

    public void setObject() {

        // Add more dots here depending on size of obj list
        gc.getObj()[0] = new Dot(25 * gc.getTileSize(), 23 * gc.getTileSize());
        gc.getObj()[1] = new Dot(26 * gc.getTileSize(), 24 * gc.getTileSize());
        gc.getObj()[2] = new Dot(26 * gc.getTileSize(), 22 * gc.getTileSize());

    }

}
