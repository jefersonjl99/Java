package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoard implements KeyListener {

    private boolean[] keys = new boolean[256];

    public static boolean UP, LEFT, RIGHT, DOWN;

    public KeyBoard() {
        UP = false;
        LEFT = false;
        RIGHT = false;
        DOWN = false;
    }

    public void update() {
        UP = keys[KeyEvent.VK_W];
        LEFT = keys[KeyEvent.VK_A];
        RIGHT = keys[KeyEvent.VK_D];
        DOWN = keys[KeyEvent.VK_S];
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

}
