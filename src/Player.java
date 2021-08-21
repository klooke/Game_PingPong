import java.awt.Color;
import java.awt.Graphics;

public class Player 
{
	private final int WIDTH = 100; // Largura da linha
	private final int HEIGHT = 10; // Altura da linha
	
	private int posX = 0; // Posi��o X da linha
	private int posY = 0; // Posi��o Y da linha
	
	// Construtor para iniciar o player em uma posi��o especifica
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
}
