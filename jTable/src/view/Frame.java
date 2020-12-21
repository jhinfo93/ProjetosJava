package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(713, 490);
		setVisible(true);
		setResizable(false);
	}
	
	public void trocarTela(JPanel panel) {
		setContentPane(panel);
		repaint();
		validate();
	}

}
