public class Player extends Entity
{	
	private PlayerController controller;
	
	public Player()
	{
		width = (Frame.WIDTH / 5);
		height = 10;
		speed = 15;
		posX = (Frame.WIDTH / 2) - (width / 2);
		posY = Frame.HEIGHT - (height*2);
		controller = new PlayerController(this);
	}
	
	public PlayerController getController()
	{
		return controller;
	}
	
	public void moveX(short direction)
	{
		directionX = direction;
		
		if(isCollideToWall())
			posX += (direction * speed);
	}
}
