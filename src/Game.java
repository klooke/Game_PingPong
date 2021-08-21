import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable
{	
	private static final long serialVersionUID = 1L; // Auto create by java.awt.Canvas:
	
	private final int SCALE = 1; // Escala da resolu��o (aqui aumenta a escala dos objetos sem alterar a resolu��o).
	private final int WIDTH = 640 * SCALE; // Largura da janela.
	private final int HEIGHT = 480 * SCALE; // Altura da janela.
	
	private BufferedImage background = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB); // Imagem de fundo
	private Player player = new Player(250, HEIGHT-20); // Instancia do player
	
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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Essa janela ser� fechada corretamente
		
		// Inicia o loop run().
		new Thread(game).start();
	}
	
	// Renderiza imagens no canvas
	public void render()
	{
		if (getBufferStrategy() == null) createBufferStrategy(3); // Cria 3 buffers, caso n�o haja.
		
		// Renderiza a imagem de fundo
		Graphics gp = background.getGraphics();		
		gp = getBufferStrategy().getDrawGraphics();
		gp.drawImage(background, 0, 0, WIDTH, HEIGHT, null);
		
		// Renderiza o player
		player.render(gp);
		
		// Mostra o que foi renderizado
		getBufferStrategy().show();
	}
	
	public void run() 
	{
		// Looping do game
		while(true)
		{
			render(); // Renderizar
		}
	}
}
