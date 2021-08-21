import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable, KeyListener
{	
	private static final long serialVersionUID = 1L; // Auto create by java.awt.Canvas:
	
	// Constantes
	public final static int SCALE = 1; // Escala da resolução (aqui aumenta a escala dos objetos sem alterar a resolução).
	public final static int WIDTH = 640 * SCALE; // Largura da janela.
	public final static int HEIGHT = 480 * SCALE; // Altura da janela.
	
	// Variáveis globais
	private BufferedImage background; // Imagem de fundo
	private Player player; // Instancia do player
	
	public Game()
	{
		setPreferredSize(new Dimension(WIDTH,HEIGHT)); // Altera o tamanho do canvas (Largura, Altura).
		addKeyListener(this); // Conecta o keylistener a classe.
		
		//Inicializa as variáveis globais
		background = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
		player = new Player(250, HEIGHT-20);
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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Essa janela será fechada corretamente
		
		// Inicia o loop run().
		new Thread(game).start();
	}
	
	// Renderiza imagens no canvas
	public void render()
	{
		if (getBufferStrategy() == null) createBufferStrategy(3); // Cria 3 buffers, caso não haja.
		
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
		requestFocus();
		// Looping do game
		while(true)
		{
			render(); // Renderizar
		}
	}

	// Quando uma tecla é pressionada
	public void keyPressed(KeyEvent e) 
	{		
		// Se for a seta direita, move o player pra direita
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) player.moveRight();
		
		// Se for a seta esquerda, move o player pra esquerda
		if (e.getKeyCode() == KeyEvent.VK_LEFT) player.moveLeft();
	}

	public void keyReleased(KeyEvent e) {}

	public void keyTyped(KeyEvent e) {}
}
