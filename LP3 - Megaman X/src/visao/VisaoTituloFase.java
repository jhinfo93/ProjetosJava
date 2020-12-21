package visao;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VisaoTituloFase extends JPanel {
	
	private JLabel imgMegamanMenu;
	private JLabel imgLogoMegaman;
	private JLabel fase;
	
	public VisaoTituloFase(String numeroFase) {
		setBackground(Color.BLACK);
		setLayout(null);
		add(getJLabelLogoMegaman());
		add(getJLabelMegamanMenu());
		
		if (numeroFase.equalsIgnoreCase("Jogo concluido")) {
			add(getJogoConcluido());
		}
		else {
			add(getJLabelfase(numeroFase));
		}
	}

	public JLabel getJLabelMegamanMenu() {
		if (imgMegamanMenu == null) {
			ImageIcon img;
			img = new ImageIcon(getClass().getResource("./Menu Principal/MegamanTrio.png"));
			img.setImage((img).getImage().getScaledInstance(300, 300, 100));
			imgMegamanMenu = new JLabel(img);
			imgMegamanMenu.setBounds(50, 0, 500, 500);
		}
		return imgMegamanMenu;
	}		
	
	public JLabel getJLabelLogoMegaman() {
		if (imgLogoMegaman == null) {
			ImageIcon img;
			img = new ImageIcon(getClass().getResource("./Menu Principal/LogoMegaman.png"));
			img.setImage((img).getImage().getScaledInstance(300, 150, 100));
			imgLogoMegaman = new JLabel(img);
			imgLogoMegaman.setBounds(500, -150, 500, 596);
		}
		return imgLogoMegaman;
	}
	
	public JLabel getJLabelfase(String numeroFase) {
		if (fase == null) {
			fase = new JLabel("Fase " + numeroFase);
			fase.setForeground(Color.BLUE);
			fase.setFont(new Font("Algerian", Font.PLAIN, 62));
			fase.setBounds(600, 250, 318, 100);
		}
		return fase;
	}
	
	public JLabel getJogoConcluido() {
		String texto = "PARABÉNS!! Jogo concluído!";
		
		if (fase == null) {
			fase = new JLabel(texto);
			fase.setForeground(new Color(131, 193, 137));
			fase.setFont(new Font("Algerian", Font.PLAIN, 20));
			fase.setBounds(600, 250, 318, 100);
		}
		return fase;
	}
}
