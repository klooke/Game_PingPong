import java.awt.Color;
import java.awt.Graphics;

public class Entity
{
	protected int width;
	protected int height;
	protected int speed;
	protected int posX;
	protected int posY;
	
	public void render(Graphics graphic)
	{
		graphic.setColor(Color.WHITE);
		graphic.fillRect(posX, posY, width, height);
	}
}
