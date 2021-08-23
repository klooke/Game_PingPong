import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable
{	
	public static final int FRAME_SCALE = 1;
	public static final int FRAME_WIDTH = 640*FRAME_SCALE;
	public static final int FRAME_HEIGHT = 480*FRAME_SCALE;
	public static final String NAME_TITLE = "Ping Pong";
	public static final short DIR_LEFT = -1;
	public static final short DIR_RIGHT = 1;
	private static final long serialVersionUID = 1L;
	
	private BufferedImage background;
	private Player player;
	private Enemy enemy;
	private BufferStrategy buffer;
	
	public static void main(String[] args)
	{
		Game game = new Game();
		new Frame(game);
		new Thread(game).start();
	}
	
	public Game()
	{		
		setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		background = new BufferedImage(FRAME_WIDTH, FRAME_HEIGHT, BufferedImage.TYPE_INT_RGB);
		player = new Player();
		addKeyListener(player.getController());
		enemy = new Enemy();
	}
	
	public void run() 
	{
		createBuffer();
		requestFocus();
		update();
	}
	
	private void createBuffer()
	{
		createBufferStrategy(3);
		buffer = getBufferStrategy();		
	}
	
	private void update()
	{
		while(true)
			render();		
	}
	
	private void render()
	{
		Graphics graphic = background.getGraphics();		
		graphic = buffer.getDrawGraphics();
		graphic.drawImage(background, 0, 0, null);		
		player.render(graphic);
		enemy.render(graphic);
		buffer.show();
	}
}
