public class Player extends Entity
{	
	public Player()
	{
		width = (Frame.WIDTH / 5);
		height = 10;
		posX = (Frame.WIDTH / 2) - (width / 2);
		posY = Frame.HEIGHT - (height*2);
		speed = 4;
	}

	public void update()
	{
		if (bounds == null) return;

		moveX();
	}
	
	private void moveX()
	{		
		if (isCollideToWall())
			posX += directionX * speed;
	}
}
