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
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) 
			player.moveX(Game.DIR_LEFT);
		
		if(key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D)
			player.moveX(Game.DIR_RIGHT);		
	}

	public void keyReleased(KeyEvent e){}	
	public void keyTyped(KeyEvent e){}
}
