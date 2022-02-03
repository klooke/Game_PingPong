import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable
{		
	private BufferedImage background = new BufferedImage(Frame.WIDTH, Frame.HEIGHT, BufferedImage.TYPE_INT_RGB);
	private static Player player = new Player();
	private static Enemy enemy = new Enemy();
	private static Ball ball = new Ball();
	private BufferStrategy buffer;
	private static Graphics graphic;
	
	public static void main(String[] args)
	{
		Game game = new Game();
		new Frame(game);
		new Thread(game).start();
	}
	
	public Game()
	{		
		setPreferredSize(new Dimension(Frame.WIDTH, Frame.HEIGHT));
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
		if (buffer != null) return;

		createBufferStrategy(3);		
		buffer = getBufferStrategy();		
	}
	
	private void update()
	{
		while (true)
		{
			render();
			enemy.update();
			ball.update();

			try { Thread.sleep(1000/60); } 
			catch (InterruptedException e) { e.printStackTrace(); }
		}	
	}
	
	private void render()
	{		
		renderBackground();
		renderEntities();
		renderScore();

		graphic.dispose();
		buffer.show();
	}
	
	private void renderBackground()
	{
		graphic = buffer.getDrawGraphics();
		graphic.drawImage(background, 0, 0, null);
		graphic.drawLine(0, (Frame.HEIGHT / 2), Frame.WIDTH, (Frame.HEIGHT / 2));
	}
	
	private void renderEntities()
	{
		player.render();
		enemy.render();
		ball.render();		
	}
	
	private void renderScore()
	{
		int sizeFont = 128 * Frame.SCALE;
		int posXScoreHigh = 10;
		int posXScore = sizeFont - (85 * Frame.SCALE);
		int posYPlayerScore = sizeFont + (128 * Frame.SCALE);
		int posYEnemyScore= sizeFont - 50;

		graphic.setColor(new Color(255,255,255, 50));
		graphic.setFont(new Font("Arial", Font.BOLD, sizeFont));
		
		if (enemy.score > 9)
			graphic.drawString(Integer.toString(enemy.score), posXScoreHigh, posYEnemyScore);
		else
			graphic.drawString(Integer.toString(enemy.score), posXScore, posYEnemyScore);
		
		if (player.score > 9)
			graphic.drawString(Integer.toString(player.score), posXScoreHigh, posYPlayerScore);
		else
			graphic.drawString(Integer.toString(player.score), posXScore, posYPlayerScore);
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
