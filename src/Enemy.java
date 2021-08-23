public class Enemy extends Entity
{	
	public Enemy()
	{
		width = 100;
		height = 10;
		posX = (Game.FRAME_WIDTH / 2) - (width / 2);
		posY = height;
		speed = 10;
	}
}
