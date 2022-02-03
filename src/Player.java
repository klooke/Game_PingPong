public class Player extends Entity
{	
	public Player()
	{
		width = 10;
		height = Frame.HEIGHT / 5;
		posX = 5;
		posY = Frame.HEIGHT / 2;
		speed = 4;
	}

	public void update()
	{
		moveY();
	}
	
	private void moveY()
	{		
		if (isCollideToWall())
			posY += directionY * speed;
	}
}
