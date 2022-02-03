import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable
{
	private boolean isRunning = true;
	private BufferedImage background = new BufferedImage(Frame.WIDTH, Frame.HEIGHT, BufferedImage.TYPE_INT_RGB);
	private static Player player = new Player();
	private static PlayerController playerController = new PlayerController();
	private static Enemy enemy = new Enemy();
	private static Ball ball = new Ball();
	private BufferStrategy buffer;
	private static Graphics graphic;
	
	public Game()
	{		
		setPreferredSize(new Dimension(Frame.WIDTH, Frame.HEIGHT));
		addKeyListener(playerController);
	}

	public static void main(String[] args)
	{
		Game game = new Game();
		new Frame(game);
		new Thread(game).start();
	}
	
	private void renderBackground()
	{
		graphic = buffer.getDrawGraphics();
		graphic.drawImage(background, 0, 0, null);
		graphic.drawLine(Frame.WIDTH / 2, 0, Frame.WIDTH / 2, Frame.HEIGHT); 
	}
	
	private void renderEntities()
	{
		player.render();
		enemy.render();
		ball.render();		
	}
	
	private void renderScore()
	{
		int sizeFont = 14 * Frame.SCALE;
		int posYScore = 5 + sizeFont;
		int posXPlayerScore = (Frame.WIDTH / 2) - sizeFont;
		int posXEnemyScore= (Frame.WIDTH / 2) + 20;

		graphic.setColor(Color.WHITE);
		graphic.setFont(new Font("Arial", Font.BOLD, sizeFont));
		
		graphic.drawString(Integer.toString(enemy.score), posXPlayerScore, posYScore);	
		graphic.drawString(Integer.toString(player.score), posXEnemyScore, posYScore);			
	}
	
	private void update()
	{
		player.update();
		enemy.update();
		ball.update();
	}
	
	private void render()
	{		
		renderBackground();
		renderEntities();
		renderScore();

		graphic.dispose();
		buffer.show();
	}
		
	private void createBuffer()
	{
		createBufferStrategy(3);		
		buffer = getBufferStrategy();		
	}
		
	private void loop()
	{
		while (isRunning)
		{
			update();
			render();

			try { Thread.sleep(1000/60); } 
			catch (InterruptedException e) { e.printStackTrace(); }
		}	
	}

	public void run() 
	{
		createBuffer();
		requestFocus();
		render();
		loop();
	}

	public static Player getPlayer()
	{
		return player;
	}
	
	public static Enemy getEnemy()
	{
		return enemy;
	}
	
	public static Ball getBall()
	{
		return ball;
	}
	
	public static Graphics getGraphic()
	{
		return graphic;
	}
	
	public static void resetBall()
	{
		ball = new Ball();
	}
}
