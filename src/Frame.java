import java.awt.Canvas;

import javax.swing.JFrame;

public class Frame extends JFrame 
{
	private static final long serialVersionUID = 1L;
	
	public Frame(Canvas canvas)
	{
		this.setTitle(Game.NAME_TITLE);
		this.add(canvas);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();	
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
