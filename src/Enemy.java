public class Enemy extends Entity
{	
	public Enemy()
	{
		width = 100;
		height = 10;
		posX = (Game.FRAME_WIDTH / 2) - (width / 2);
		posY = height;
		speed = 10;
	
	public void update()
	{
		moveToBall();
	}
	
	private void moveToBall()
	{
		directionBall();
		if(isCollideToWall())
			posX += direction*speed;
	}
	
	private void directionBall()
	{
		double distance = Game.getBall().posX - bounds.getCenterX();		
		if(distance > 0)
			direction = Game.DIR_RIGHT;
		else if(distance < 0)
			direction = Game.DIR_LEFT;
	}
}
