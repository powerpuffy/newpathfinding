import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    GridPanel gp;

    public KeyHandler(GridPanel gp) {
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_ENTER){
            gp.samSearch();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}