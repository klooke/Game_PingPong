import java.util.Random;

public class Ball extends Entity
{
	private int directionAngle;
	private double directionX;	
	private long collideTime;
	
	public Ball()
	{
		width = 10;
		height = 10;
		posX = (Frame.WIDTH / 2) - (width / 2);
		posY = (Frame.HEIGHT / 2) - (height /2);
		speed = 6;

		randomDirection();
	}
	
	private void randomDirection()
	{
		directionAngle = new Random().nextInt(80) + 41;
		directionY = Math.cos(Math.toRadians(directionAngle));
		
		if (directionX >= 0)
			directionX = Math.sin(Math.toRadians(directionAngle));
		else
			directionX = Math.sin(Math.toRadians(-directionAngle));
	}
	
	public void update()
	{
		collision();
		move();
	}
	
	private void collision()
	{
		if (isCollideToWall()) 
			directionY *= -1;
		
		if (isCollideToEntities())
			directionX *= -1;
		
		if (isOutLimits())
			Game.resetBall();
	}
	
	private boolean isCollideToEntities()
	{
		if(bounds.intersects(Game.getPlayer().bounds) || bounds.intersects(Game.getEnemy().bounds))
		{
			long oldCollideTime = collideTime;
			collideTime = System.currentTimeMillis();
			
			if (oldCollideTime > 0)
				return false;
			
			randomDirection();

			return true;
		}		
		collideTime = 0;
		
		return false;
	}
	
	private boolean isOutLimits()
	{
		if(bounds.getCenterX() >= Frame.WIDTH)
		{
			Game.getEnemy().score++;

			return true;
		}
		else if(bounds.getCenterX() <= 0)
		{
			Game.getPlayer().score++;

			return true;
		}
		
		return false;
	}
	
	private void move()
	{
		posX += directionX * speed;
		posY += directionY * speed;
	}
}
