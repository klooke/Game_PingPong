import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerController implements KeyListener
{
	public void keyPressed(KeyEvent e)
	{
		switch (e.getKeyCode())
		{
			case KeyEvent.VK_UP:
			case KeyEvent.VK_W:
				Game.getPlayer().directionY = Entity.DIR_UP;
				return;
			case KeyEvent.VK_DOWN:
			case KeyEvent.VK_S:
				Game.getPlayer().directionY = Entity.DIR_DOWN;
				return;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch (e.getKeyCode())
		{
			case KeyEvent.VK_UP:
			case KeyEvent.VK_W:
			case KeyEvent.VK_DOWN:
			case KeyEvent.VK_S:
				Game.getPlayer().directionY = 0;
				return;
		}
	}
	public void keyTyped(KeyEvent e){}
}
