public class Player extends Entity
{	
	private PlayerController controller;
	private int direction;
	
	public Player()
	{
		width = 100;
		height = 10;
		posX = (Game.FRAME_WIDTH / 2) - (width / 2);
		posY = Game.FRAME_HEIGHT - (height*2);
		speed = 15;
		controller = new PlayerController(this);
	}
	
	public PlayerController getController()
	{
		return controller;
	}
	
	public void moveX(short direction)
	{
		this.direction = direction;
		if(isCollideToWall())
			posX += (direction * speed);
	}
}
