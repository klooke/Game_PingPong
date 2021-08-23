public class Ball extends Entity
{
	public Ball()
	{
		width = 10;
		height = 10;
		posX = (Game.FRAME_WIDTH / 2) - (width / 2);
		posY = (Game.FRAME_HEIGHT / 2) - (height /2);
		speed = 10;
	}
}
