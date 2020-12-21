package visao;

import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class VisaoMenuPrincipal extends JPanel {
	
	private JLabel imgMegamanMenu;
	private JLabel imgLogoMegaman;
	private JLabel novoJogo;
	private JLabel creditos;
	private JLabel sair;
	private JLabel imgIconeMegaman;
	private int posX = 258;
	private int novoJogoY = 206;
	private int creditosY = 246;
	private int sairY = 286;
	
	public int getPosX() {
		return posX;
	}

	public int getNovoJogoY() {
		return novoJogoY;
	}

	public int getCreditosY() {
		return creditosY;
	}

	public int getSairY() {
		return sairY;
	}

	public VisaoMenuPrincipal() {
		setBackground(Color.BLACK);
		setLayout(null);
		add(getJLabelIconeMegaman());
		add(getJLabelLogoMegaman());
		add(getJLabelMegamanMenu());
		add(getJLabelNovoJogo());
		add(getJLabelCreditos());
		add(getJLabelSair());
	}

	public JLabel getJLabelMegamanMenu() {
		if (imgMegamanMenu == null) {
			ImageIcon img;
			img = new ImageIcon(getClass().getResource("./Menu Principal/MegamanTrio.png"));
			img.setImage((img).getImage().getScaledInstance(300, 300, 100));
			imgMegamanMenu = new JLabel(img);
			imgMegamanMenu.setBounds(300, 0, 500, 500);
		}
		return imgMegamanMenu;
	}		
	
	public JLabel getJLabelLogoMegaman() {
		if (imgLogoMegaman == null) {
			ImageIcon img;
			img = new ImageIcon(getClass().getResource("./Menu Principal/LogoMegaman.png"));
			img.setImage((img).getImage().getScaledInstance(300, 150, 100));
			imgLogoMegaman = new JLabel(img);
			imgLogoMegaman.setBounds(100, -150, 500, 500);
		}
		return imgLogoMegaman;
	}	
	
	public JLabel getJLabelIconeMegaman() {
		if (imgIconeMegaman == null) {
			ImageIcon img;
			img = new ImageIcon(getClass().getResource("./Menu Principal/IconeMgaman.png"));
			img.setImage((img).getImage().getScaledInstance(30, 50, 100));
			imgIconeMegaman = new JLabel(img);
			imgIconeMegaman.setBounds((posX-50), novoJogoY, 50, 50);
		}
		return imgIconeMegaman;
	}
	
	public JLabel getJLabelNovoJogo() {
		if (novoJogo == null) {
			novoJogo = new JLabel("Novo Jogo");
			novoJogo.setVerticalAlignment(SwingConstants.TOP);
			novoJogo.setHorizontalAlignment(SwingConstants.RIGHT);
			novoJogo.setFont(new Font("EngraversGothic BT", Font.BOLD, 25));
			novoJogo.setForeground(Color.LIGHT_GRAY);
			novoJogo.setBounds(posX, novoJogoY, 134, 43);
		}
		return novoJogo;
	}
	public JLabel getJLabelCreditos() {
		if (creditos == null) {
			creditos = new JLabel("Cr\u00E9ditos");
			creditos.setVerticalAlignment(SwingConstants.TOP);
			creditos.setHorizontalAlignment(SwingConstants.RIGHT);
			creditos.setFont(new Font("EngraversGothic BT", Font.BOLD, 25));
			creditos.setForeground(Color.LIGHT_GRAY);
			creditos.setBounds(posX, creditosY, 105, 28);
		}
		return creditos;
	}
	public JLabel getJLabelSair() {
		if (sair == null) {
			sair = new JLabel("Sair");
			sair.setVerticalAlignment(SwingConstants.TOP);
			sair.setHorizontalAlignment(SwingConstants.RIGHT);
			sair.setFont(new Font("EngraversGothic BT", Font.BOLD, 25));
			sair.setForeground(Color.LIGHT_GRAY);
			sair.setBounds(posX, sairY, 53, 28);//  49, 28
		}
		return sair;
	}
}
