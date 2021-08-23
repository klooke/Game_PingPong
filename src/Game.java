import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable
{	
	public static final int SCALE = 1;
	public static final int WIDTH = 640*SCALE;
	public static final int HEIGHT = 480*SCALE;
	public static final String NAME_TITLE = "Ping Pong";
	public static final short DIR_LEFT = -1;
	public static final short DIR_RIGHT = 1;
	private static final long serialVersionUID = 1L;
	
	private BufferedImage background;
	private Player player;
	private BufferStrategy buffer;
	
	public static void main(String[] args)
	{
		Game game = new Game();
		new Frame(game);
		new Thread(game).start();
	}
	
	public Game()
	{		
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		background = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		player = new Player();
		addKeyListener(player.getController());
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
		buffer.show();
	}
}
