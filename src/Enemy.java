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
		double distance = Game.getBall().posX - bounds.getCenterX();
		
		if(distance > 0)
			directionX = DIR_RIGHT;
		else if(distance < 0)
			directionX = DIR_LEFT;
		else
			directionX = 0;
	}
}
