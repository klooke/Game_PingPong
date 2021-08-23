import java.util.Random;

public class Ball extends Entity
{
	private int directionAngle;
	private double directionX;
	private double directionY;
	
	public Ball()
	{
		width = 10;
		height = 10;
		posX = (Game.FRAME_WIDTH / 2) - (width / 2);
		posY = (Game.FRAME_HEIGHT / 2) - (height /2);
		speed = 0.07;
		randomDirection();
	}
	
	private void randomDirection()
	{
		directionAngle = new Random().nextInt(80) + 40;
		directionX = Math.cos(Math.toRadians(directionAngle));
		
		if (directionY >= 0)
			directionY = Math.sin(Math.toRadians(directionAngle));
		else
			directionY = Math.sin(Math.toRadians(-directionAngle));
	}
	
	public void update()
	{
		collision();
		move();
	}
	
	private void collision()
	{
		if(isCollideToWall()) 
			directionX *= -1;
		
		if(isCollideToEntities())
			directionY *= -1;
		
		if(isOutLimits())
			Game.resetBall();
	}
	
	private boolean isCollideToEntities()
	{
		if(bounds.intersects(Game.getPlayer().bounds) || bounds.intersects(Game.getEnemy().bounds))
		{
			randomDirection();
			return true;
		}
		
		return false;
	}
	
	private boolean isOutLimits()
	{
		if(bounds.getCenterY() >= Game.FRAME_HEIGHT)
		{
			System.out.println("Ponto do inimigo!");
			return true;
		}
		else if(bounds.getCenterY() <= 0)
		{
			System.out.println("Ponto do jogador!");
			return true;
		}
		
		return false;
	}
	
	private void move()
	{
		posX += directionX*speed;
		posY += directionY*speed;
	}
}
