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
	
	public void render(Graphics graphic)
	{
		graphic.setColor(Color.WHITE);
		graphic.fillRect((int)posX, (int)posY, width, height);
		bounds = new Rectangle((int)posX, (int)posY, width, height);
	}
}
