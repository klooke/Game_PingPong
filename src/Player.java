public class Player extends Entity
{	
	private PlayerController controller;
	private int contactLeft;
	private int contactRight;
	private int direction;
	
	public Player()
	{
		width = 100;
		height = 10;
		speed = 10;
		posX = (Game.FRAME_WIDTH / 2) - 50;
		posY = Game.FRAME_HEIGHT - 20;
		controller = new PlayerController(this);
	}
	
	public PlayerController getController()
	{
		return controller;
	}
	
	public void moveX(short direction)
	{
		this.direction = direction;
		if (onLimits())
			posX += (direction * speed);
	}
	
	private boolean onLimits()
	{
		updateLimits();
		boolean limitRight = direction == Game.DIR_RIGHT && contactRight < Game.FRAME_WIDTH;
		boolean limitLeft = direction == Game.DIR_LEFT && contactLeft > 0;
		return limitRight || limitLeft;
	}
	
	public void updateLimits()
	{
		contactLeft = posX - 10;
		contactRight = posX + (width + 10);
	}
}
