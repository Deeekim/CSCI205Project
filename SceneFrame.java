// idea: put button to switch maps

import javax.swing.*;

public class SceneFrame {
    private JFrame frame;
    private int width;
    private int height;
    private SceneCanvas sc;

    public SceneFrame() {
        frame = new JFrame();
        width = 800;
        height = 600;
        sc = new SceneCanvas();
    }

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