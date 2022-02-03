import java.awt.Canvas;

import javax.swing.JFrame;

public class Frame extends JFrame 
{		
	public static final int SCALE = 2;
	public static final int WIDTH = 274 * SCALE,  HEIGHT = 152 * SCALE;
	public static final String TITLE = "Ping Pong";
	
	public Frame(Canvas canvas)
	{
		this.setTitle(TITLE);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(canvas);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
