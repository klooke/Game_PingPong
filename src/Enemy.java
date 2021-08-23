import java.util.Random;

public class Enemy extends Entity
{	
	public Enemy()
	{
		width = (Game.FRAME_WIDTH / 5);
		height = 10;
		posX = (Game.FRAME_WIDTH / 2) - (width / 2);
		posY = height;
	}
	
	public void update()
	{
		randomSpeed();
		moveToBall();
	}
	
	private void randomSpeed()
	{
		speed = new Random().nextInt(100) + 1;
		if(speed > 50) 
			speed = 0.07;
		else
			speed = 0.01;
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
