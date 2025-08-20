import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
// keylistner interface is for recieving keyboard events
public class KeyHandler implements KeyListener{
public boolean upPressed, downPressed, leftPressed, rightPressed;

    @Override
    public void keyTyped(KeyEvent e) { 
        int code = e.getKeyCode(); // this method is not used in this example
        if(code == KeyEvent.VK_W){
            upPressed = true;
        }
        if(code == KeyEvent.VK_S){
            downPressed = true;
        }
        if(code == KeyEvent.VK_A){
            leftPressed = true;
        }
        if(code == KeyEvent.VK_D){
            rightPressed = true;
        }

    }

	@Override
	public void keyReleased(KeyEvent e) {
		 int code = e.getKeyCode(); // returns the integer keycode associated with the key in the event
        
        if(code == KeyEvent.VK_W){
            upPressed = false;
        }
        if(code == KeyEvent.VK_S){
            downPressed = false;
        }
        if(code == KeyEvent.VK_A){
            leftPressed = false;
        }
        if(code == KeyEvent.VK_D){
            rightPressed = false;
        }
    }

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
	}
}
