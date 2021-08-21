import java.awt.Color;
import java.awt.Graphics;

public class Player 
{
	private final int WIDTH = 100; // Largura da linha
	private final int HEIGHT = 10; // Altura da linha
	
	private int posX = 0; // Posição X da linha
	private int posY = 0; // Posição Y da linha
	private int speed = 10; // Velocidade da movimentação
	
	// Construtor para iniciar o player em uma posição especifica
	public Player(int x, int y)
	{
		posX = x;
		posY = y;
	}
	
	// Comando para renderizar o player, recebe o graphics da janela principal
	public void render(Graphics gp)
	{
		gp.setColor(Color.WHITE); // Cor branca
		gp.fillRect(posX, posY, WIDTH, HEIGHT); // Linha horizontal
	}
	
	// Comando para movimentar o player a direita.
	public void moveRight()
	{
		int x = posX + (WIDTH + 10); // Posição final do lado direito da linha
		
		if (x < Game.WIDTH) // Verifica se chegou ao limite
		{
			posX += (1 * speed); // Multiplica a direção com a velocidade da movimentação			
		}
	}
	
	// Comando para movimentar o player a esquerda.
	public void moveLeft()
	{
		int x = posX - 10; // Posição final do lado esquerdo da linha
		
		if (x > 0) // Verifica se chegou ao limite
		{
			posX -= (1 * speed); // Multiplica a direção com a velocidade da movimentação			
		}
	}
}
