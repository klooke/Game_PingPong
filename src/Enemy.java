public class Enemy extends Entity
{	
	public Enemy()
	{
		width = (Frame.WIDTH / 5);
		height = 10;
		posX = (Frame.WIDTH / 2) - (width / 2);
		posY = height;
		speed = 1;
	}
	
	public void update()
	{
		moveToBall();
	}
	private void moveToBall()
	{
		directionBall();

		if (isCollideToWall())
			posX += directionX * speed;
	}
	
	private void directionBall()
	{		
		if (bounds.getCenterX() < Game.getBall().posX && Game.getBall().directionX > 0)
			directionX = DIR_RIGHT;
		else if (bounds.getCenterX() > Game.getBall().posX && Game.getBall().directionX < 0)
			directionX = DIR_LEFT;
		else
			directionX = 0;
	}
}
