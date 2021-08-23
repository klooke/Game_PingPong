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
		if (e.getKeyCode() == KeyEvent.VK_LEFT) 
			player.moveX(Game.DIR_LEFT);
		
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			player.moveX(Game.DIR_RIGHT);		
	}

	public void keyReleased(KeyEvent e){}	
	public void keyTyped(KeyEvent e){}
}
