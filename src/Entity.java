import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Entity
{
	protected double posX;
	protected double posY;
	protected int width;
	protected int height;
	protected double speed;	
	protected Rectangle bounds;
	protected int direction;
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
			boolean isCollideRight = (direction == Game.DIR_RIGHT) && (bounds.getMaxX() < (Game.FRAME_WIDTH - 10));
			boolean isCollideLeft = (direction == Game.DIR_LEFT) && (bounds.getMinX() > 10);
			return isCollideRight || isCollideLeft;
		}
		else if (this instanceof Ball)
		{
			if(bounds.getMinX() <= 0 || bounds.getMaxX() >= Game.FRAME_WIDTH)
				return true;
			
			return false;
		}
		
		return false;
	}
}
