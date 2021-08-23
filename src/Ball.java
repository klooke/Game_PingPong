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
		speed = 0.1;		
		directionAngle = new Random().nextInt(359);
		directionX = Math.cos(Math.toRadians(directionAngle));
		directionY = Math.sin(Math.toRadians(directionAngle));
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
			return true;
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
