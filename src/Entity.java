import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Entity
{
	protected int posX;
	protected int posY;
	protected int width;
	protected int height;
	protected int speed;	
	protected Rectangle bounds;
	
	public void render(Graphics graphic)
	{
		graphic.setColor(Color.WHITE);
		graphic.fillRect(posX, posY, width, height);
		bounds = new Rectangle(posX, posY, width, height);
	}
}
