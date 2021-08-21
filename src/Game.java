import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Game extends Canvas
{	
	private static final long serialVersionUID = 1L; // Auto create by java.awt.Canvas:
	
	private final int SCALE = 1; // Escala da resolução (aqui aumenta o tamanho da janela sem alterar a resolução).
	private final int WIDTH = 640 * SCALE; // Largura da resolução.
	private final int HEIGHT = 480 * SCALE; // Altura da resolução.
	
	public Game()
	{
		setPreferredSize(new Dimension(WIDTH,HEIGHT)); // Altera o tamanho do canvas (Largura, Altura).
	}
	
	public static void main(String[] args)
	{
		// Instancias
		Game game = new Game();	// Canvas.		
		JFrame frame = new JFrame("Ping Pong"); // Janela
		
		// Propriedades da janela
		frame.add(game);
		frame.pack();
		frame.setLocationRelativeTo(null); // Centraliza a janela.
		frame.setResizable(false); // Essa janela não pode ser rendimensionada pelo usuário.
		frame.setVisible(true); // Essa janela é visivel.
	}
}
