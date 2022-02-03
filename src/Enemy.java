public class Enemy extends Entity
{	
	public Enemy()
	{
		width = 10;
		height = Frame.HEIGHT / 5;
		posX = Frame.WIDTH - 15;
		posY = Frame.HEIGHT / 2;
		speed = 3;
	}
	
	public void update()
	{
		if (bounds == null) return;
		
		moveToBall();
	}
	private void moveToBall()
	{
		directionBall();

		if (isCollideToWall())
			posY += directionY * speed;
	}
	
	private void directionBall()
	{		
		if (bounds.getCenterY() < Game.getBall().posY && Game.getBall().directionY > 0)
			directionY = DIR_DOWN;
		else if (bounds.getCenterY() > Game.getBall().posY && Game.getBall().directionY < 0)
			directionY = DIR_UP;
		else
			directionY = 0;
	}
}
