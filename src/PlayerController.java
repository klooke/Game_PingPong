import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerController implements KeyListener
{
	private Player player;
	
	public PlayerController(Player player)
	{
		this.player = player;
	}
	
	public void keyPressed(KeyEvent e)
	{
		switch (e.getKeyCode())
		{
			case KeyEvent.VK_LEFT:
			case KeyEvent.VK_A:
				player.directionX = Entity.DIR_LEFT;
				return;
			case KeyEvent.VK_RIGHT:
			case KeyEvent.VK_D:
				player.directionX = Entity.DIR_RIGHT;
				return;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch (e.getKeyCode())
		{
			case KeyEvent.VK_LEFT:
			case KeyEvent.VK_A:
			case KeyEvent.VK_RIGHT:
			case KeyEvent.VK_D:
				player.directionX = 0;
				return;
		}
	}
	public void keyTyped(KeyEvent e){}
}
