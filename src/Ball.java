import java.util.Random;

public class Ball extends Entity
{
	private int directionAngle;
	private double directionY;	
	private long collideTime;
	
	public Ball()
	{
		width = 10;
		height = 10;
		posX = (Frame.WIDTH / 2) - (width / 2);
		posY = (Frame.HEIGHT / 2) - (height /2);
		speed = 4;

		randomDirection();
	}
	
	private void randomDirection()
	{
		directionAngle = new Random().nextInt(80) + 41;
		directionX = Math.cos(Math.toRadians(directionAngle));
		
		if (directionY >= 0)
			directionY = Math.sin(Math.toRadians(directionAngle));
		else
			directionY = Math.sin(Math.toRadians(-directionAngle));
	}
	
	public void update()
	{
		if (bounds == null) return;

		collision();
		move();
	}
	
	private void collision()
	{
		if (isCollideToWall()) 
			directionX *= -1;
		
		if (isCollideToEntities())
			directionY *= -1;
		
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
		if(bounds.getCenterY() >= Frame.HEIGHT)
		{
			Game.getEnemy().score++;

			return true;
		}
		else if(bounds.getCenterY() <= 0)
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
