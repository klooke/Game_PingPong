import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable
{	
	public static final int FRAME_SCALE = 2;
	public static final int FRAME_WIDTH = 152*FRAME_SCALE;
	public static final int FRAME_HEIGHT = 274*FRAME_SCALE;
	public static final String FRAME_TITLE = "Ping Pong";
	public static final short DIR_LEFT = -1;
	public static final short DIR_RIGHT = 1;
	private static final long serialVersionUID = 1L;
	
	private BufferedImage background;
	private static Player player;
	private static Enemy enemy;
	private static Ball ball;
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
		setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		background = new BufferedImage(FRAME_WIDTH, FRAME_HEIGHT, BufferedImage.TYPE_INT_RGB);
		player = new Player();
		addKeyListener(player.getController());
		enemy = new Enemy();
		ball = new Ball();
	}
	
	public void run() 
	{
		createBuffer();
		requestFocus();
		loop();
	}
	
	private void createBuffer()
	{
		createBufferStrategy(3);
		buffer = getBufferStrategy();		
	}
	
	private void loop()
	{
		while(true)
		{
			render();
			ball.update();
			enemy.update();
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
		graphic = background.getGraphics();
		graphic = buffer.getDrawGraphics();
		graphic.drawImage(background, 0, 0, null);
		graphic.drawLine(0, (FRAME_HEIGHT / 2), FRAME_WIDTH, (FRAME_HEIGHT / 2));
	}
	
	private void renderEntities()
	{
		player.render();
		enemy.render();
		ball.render();		
	}
	
	private void renderScore()
	{
		int sizeFont = 128*FRAME_SCALE;
		int posXScoreHigh = 10;
		int posXScore = sizeFont - (85*FRAME_SCALE);
		int posYPlayerScore = sizeFont + (128*FRAME_SCALE);
		int posYEnemyScore= sizeFont - 50;
		graphic.setColor(new Color(255,255,255, 50));
		graphic.setFont(new Font("Arial", Font.BOLD, sizeFont));
		
		if(enemy.score > 9)
			graphic.drawString(Integer.toString(enemy.score), posXScoreHigh, posYEnemyScore);
		else
			graphic.drawString(Integer.toString(enemy.score), posXScore, posYEnemyScore);
		
		if(player.score > 9)
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
