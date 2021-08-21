import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Game extends Canvas
{	
	private static final long serialVersionUID = 1L; // Auto create by java.awt.Canvas:
	
	private final int SCALE = 1; // Escala da resolu��o (aqui aumenta o tamanho da janela sem alterar a resolu��o).
	private final int WIDTH = 640 * SCALE; // Largura da resolu��o.
	private final int HEIGHT = 480 * SCALE; // Altura da resolu��o.
	
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
		frame.setResizable(false); // Essa janela n�o pode ser rendimensionada pelo usu�rio.
		frame.setVisible(true); // Essa janela � visivel.
	}
}
