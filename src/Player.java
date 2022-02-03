public class Player extends Entity
{	
	private PlayerController controller;
	
	public Player()
	{
		width = (Frame.WIDTH / 5);
		height = 10;
		posX = (Frame.WIDTH / 2) - (width / 2);
		posY = Frame.HEIGHT - (height*2);
		speed = 4;
		controller = new PlayerController(this);
	}
	
	public PlayerController getController()
	{
		return controller;
	}

	public void update()
	{
		moveX();
	}
	
	private void moveX()
	{		
		if (isCollideToWall())
			posX += directionX * speed;
	}
}
