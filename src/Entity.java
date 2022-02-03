import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Entity
{
	protected static final short DIR_UP = -1, DIR_DOWN = 1;

	protected double posX, posY;
	protected int width, height;
	protected Rectangle bounds;
	protected double speed, directionY;
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
			boolean isColliderDown = (directionY == DIR_DOWN) && (bounds.getMaxY() < (Frame.HEIGHT - 10));
			boolean isColliderUP = (directionY == DIR_UP) && (bounds.getMinY() > 10);
			
			return isColliderDown || isColliderUP;
		}
		else if (this instanceof Ball)
		{
			if (bounds.getMinY() <= 0 || bounds.getMaxY() >= Frame.HEIGHT)
				return true;
		}
		
		return false;
	}
}
