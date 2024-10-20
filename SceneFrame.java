import javax.swing.*;

/**
 * SceneFrame
 * 
 * Description: This class is responsible for setting up the parameters of the animation.
 * A JFrame will be instantiated and the visual elements will be added from the SceneCanvas class.
 * Authors: Michael Deekimcheng, Miguel Yapan
 * ID Number: 205641, 205501
 * Date: September 29, 2024
 */
public class SceneFrame {

    private JFrame frame;
    private int width;
    private int height;
    private SceneCanvas sc;

    /**
     * Constructor instantiates a new SceneCanvas and SceneFrame.
     */
    public SceneFrame() {
        frame = new JFrame();
        width = 800;
        height = 600;
        sc = new SceneCanvas();
    }

    /**
     * Sets the parameters of the JFrame according to specifications. 
     * The setUpGame and startGameThread method from the SceneCanvas are also called.
     */ 
    public void setUpGUI() {

        frame.setResizable(false);
        frame.setSize(width, height);
        frame.setTitle("Project 1 - Deekimcheng - Yapan");
        frame.add(sc);
        frame.pack();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        sc.setUpGame();
        sc.startGameThread();

    }
}
