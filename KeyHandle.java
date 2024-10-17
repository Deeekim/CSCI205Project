import java.awt.event.*;

/**
* Michael Deekimcheng and Miguel Yapan
* 205641 and 205501
* Date created: October 05, 2024
* 
* The KeyHandle class implements the KeyListener interface to handle
* keyboard inputs for movement controls in the game. It detects whether combinations
* of specific keys (W, A, S, D) are pressed to control movement.
*/ 
public class KeyHandle implements KeyListener {
    
    private boolean upPressed, downPressed, leftPressed, rightPressed;

    /**
    * This method is invoked on key press. It updates the state of directional 
    * keys to true when they are pressed.
    *
    * @param e the KeyEvent triggered when a key is pressed
    */
    @Override
    public void keyPressed(KeyEvent e) { 
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W) {
            upPressed = true;
        }
        if(code == KeyEvent.VK_S) {
            downPressed = true;
        }
        if(code == KeyEvent.VK_A) {
            leftPressed = true;
        }
        if(code == KeyEvent.VK_D) {
            rightPressed = true;
        }
    } 

    /**
    * This method is invoked on key release. It updates the state of directional 
    * keys to false when they are released.
    *
    * @param e the KeyEvent triggered when a key is pressed
    */
    @Override
    public void keyReleased(KeyEvent e) { 
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W) {
            upPressed = false;
        }
        if(code == KeyEvent.VK_S) {
            downPressed = false;
        }
        if(code == KeyEvent.VK_A) {
            leftPressed = false;
        }
        if(code == KeyEvent.VK_D) {
            rightPressed = false;
        }
    } 

    /**
    * This method is invoked on key typed (used for character input). 
    * It is currently empty because the program did not need this input type.
    *
    * @param e the KeyEvent triggered when a key is pressed
    */
    @Override
    public void keyTyped(KeyEvent e) { 
        // No action required.
    }

    /**
    * Returns the current state of the up key (W).
    *
    * @return true if key W was pressed, false otherwise
    */
    public boolean getUpPressed() {
        return upPressed;
    }

    /**
    * Returns the current state of the down key (S).
    *
    * @return true if key S was pressed, false otherwise
    */
    public boolean getDownPressed() {
        return downPressed;
    }

    /**
    * Returns the current state of the left key (A).
    *
    * @return true if key A was pressed, false otherwise
    */
    public boolean getRightPressed() {
        return rightPressed;
    }

    /**
    * Returns the current state of the right key (D).
    *
    * @return true if key D was pressed, false otherwise
    */
    public boolean getLeftPressed() {
        return leftPressed;
    }


}

