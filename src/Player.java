import java.awt.Color;
import java.awt.Graphics;

public class Player
{
	private final int WIDTH = 100;
	private final int HEIGHT = 10;
	private final int SPEED = 10;

	private int posX;
	private int posY;
	private PlayerController controller;
	private int contactLeft;
	private int contactRight;
	private int direction;
	
	public Player()
	{
		posX = 250;
		posY = Game.HEIGHT - 20;
		controller = new PlayerController(this);
	}
	
	public PlayerController getController()
	{
		return controller;
	}
	
	public void render(Graphics graphic)
	{
		graphic.setColor(Color.WHITE);
		graphic.fillRect(posX, posY, WIDTH, HEIGHT);
		contactLeft = posX - 10;
		contactRight = posX + (WIDTH + 10);
	}
	
	public void moveX(short direction)
	{
		this.direction = direction;
		if (onLimits())
			posX += (direction * SPEED);
	}
	
	private boolean onLimits()
	{
		boolean limitRight = direction == Game.DIR_RIGHT && contactRight < Game.WIDTH;
		boolean limitLeft = direction == Game.DIR_LEFT && contactLeft > 0;
		return limitRight || limitLeft;
	}
}
