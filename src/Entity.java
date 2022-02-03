import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Entity
{
	protected static final short DIR_LEFT = -1, DIR_RIGHT = 1;

	protected double posX, posY;
	protected int width, height;
	protected Rectangle bounds;
	protected double speed, directionX;
	protected int score;
	
	public void render()
	{
		Graphics graphic = Game.getGraphic();

		graphic.setColor(Color.WHITE);
		graphic.fillRect((int)posX, (int)posY, width, height);
		bounds = new Rectangle((int)posX, (int)posY, width, height);
	}
	
	protected boolean isCollideToWall()
	{
		if (this instanceof Player || this instanceof Enemy)
		{
			boolean isCollideRight = (directionX == DIR_RIGHT) && (bounds.getMaxX() < (Frame.WIDTH - 10));
			boolean isCollideLeft = (directionX == DIR_LEFT) && (bounds.getMinX() > 10);
			
			return isCollideRight || isCollideLeft;
		}
		else if (this instanceof Ball)
		{
			if (bounds.getMinX() <= 0 || bounds.getMaxX() >= Frame.WIDTH)
				return true;
		}
		
		return false;
	}
}
