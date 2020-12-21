package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Toolkit;

public class Frame extends JFrame {

	public Frame() {
		setTitle("SisCad");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Frame.class.getResource("/res/ruby_gemstone_100px.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(730, 466);
		setVisible(true);
	}
	
	public void trocar_tela(JPanel painel) {
		setContentPane(painel);
		repaint();
		validate();
	}
}
