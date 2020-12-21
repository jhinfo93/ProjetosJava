package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;

public class Frame extends JFrame {
	private JLabel lblNewLabel;

	public Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("Singular");
		setSize(500, 450);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		setVisible(true);
	}

	public void TrocarTela(JPanel f) {
		setContentPane(f);
		validate();
		repaint();

	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setBounds(0, 0, 494, 422);
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Jackson\\Desktop\\Laubertino\\fase.png"));
		}
		return lblNewLabel;
	}
}
