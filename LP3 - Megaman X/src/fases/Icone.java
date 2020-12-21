package fases;

import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import menu.Frame;
import menu.Som;
import personagens.Megaman;

public class Icone {

	private JLabel vida;
	private JLabel vidaLvl2;
	private JLabel vidaMaxima;
	private JLabel iconeEspecial;
	private Megaman megaman;		//O objeto megaman � usado para verificar se pegou algum item
	//Vari�veis para pegar o posicionamento do inimigo relacionado com algum �cone
	private int inimigoPosX = 10;
	private int inimigoPosY = 10;
	
	public Icone(Megaman megaman) {
		this.megaman = megaman;
		preencheIconeVida();
		preencheIconeVidaLvl2();
		preencheIconeVidaMaxima();
		preencheIconeEspecial();
	}
	
	public JLabel getVida() {
		return vida;
	}
	
	public JLabel getVidaLvl2() {
		return vidaLvl2;
	}
	
	public JLabel getVidaMaxima() {
		return vidaMaxima;
	}
	
	public JLabel getIconeEspecial() {
		return iconeEspecial;
	}

	public int getInimigoPosX() {
		return inimigoPosX;
	}

	public void setInimigoPosX(int inimigoPosX) {
		this.inimigoPosX = inimigoPosX;
	}

	public int getInimigoPosY() {
		return inimigoPosY;
	}

	public void setInimigoPosY(int inimigoPosY) {
		this.inimigoPosY = inimigoPosY;
	}

	public void preencheIconeVida() {
		ImageIcon img;
		img = new ImageIcon(getClass().getResource("./Icones/Vida.png"));
		img.setImage((img).getImage().getScaledInstance(30, 30, 30));
		vida = new JLabel(img);
		vida.setBounds(50, -10, 30, 30);
		vida.setBounds(30, 30, 30, 30);  	//Rectangle
		vida.setVisible(true);
	}
	
	public void preencheIconeVidaLvl2() {
		ImageIcon img;
		img = new ImageIcon(getClass().getResource("./Icones/Vida lvl 2.png"));
		img.setImage((img).getImage().getScaledInstance(30, 30, 30));
		vidaLvl2 = new JLabel(img);
		vidaLvl2.setBounds(80, -10, 30, 30);
		vidaLvl2.setBounds(30, 30, 30, 30);  	//Rectangle
		vidaLvl2.setVisible(true);
	}
	
	public void preencheIconeVidaMaxima() {
		ImageIcon img;
		img = new ImageIcon(getClass().getResource("./Icones/VidaMaxima.png"));
		img.setImage((img).getImage().getScaledInstance(30, 30, 30));
		vidaMaxima = new JLabel(img);
		vidaMaxima.setBounds(80, -10, 30, 30);
		vidaMaxima.setBounds(30, 30, 30, 30);  	//Rectangle
		vidaMaxima.setVisible(false);
	}
	
	public void preencheIconeEspecial() {
		ImageIcon img;
		img = new ImageIcon(getClass().getResource("./Icones/Poder.png"));
		img.setImage((img).getImage().getScaledInstance(30, 30, 30));
		iconeEspecial = new JLabel(img);
		iconeEspecial.setBounds(80, -10, 30, 30);
		iconeEspecial.setBounds(30, 30, 30, 30);  	//Rectangle
		iconeEspecial.setVisible(false);
	}
	
	
	//Verificando se o Megaman est� pegando algum �cone de vida
	public void colisaoIconeVida () {
		Rectangle formaMegaman = megaman.getBounds();
		Rectangle formaIconeVida = vida.getBounds();
		
		System.out.println();			//M�todo est� com algum bug
		if (formaMegaman.intersects(formaIconeVida) && vida.isVisible()) {
			vida.setVisible(false);
			new Som(Som.coinPontos).start();
		}
	}
	
	//Verificando se o Megaman est� pegando algum �cone de vida
	public void colisaoIconeVidaLvl2 () {
		Rectangle formaMegaman = megaman.getBounds();
		Rectangle formaIconeVida = vidaLvl2.getBounds();
		
		System.out.println();			//M�todo est� com algum bug
		if (formaMegaman.intersects(formaIconeVida) && vidaLvl2.isVisible()) {
			vidaLvl2.setVisible(false);
			new Som(Som.coinPontos).start();
		}
	}
	
	//Verificando se o Megaman est� pegando algum �cone de vida
	public void colisaoIconeVidaMaxima() {
		Rectangle formaMegaman = megaman.getBounds();
		Rectangle formaIconeVidaMaxima = vidaMaxima.getBounds();
		
		System.out.println();
		if (formaMegaman.intersects(formaIconeVidaMaxima) && vidaMaxima.isVisible()) {
			vidaMaxima.setVisible(false);
			new Som(Som.coinPontos).start();
		}
	}
	
	//Verificando se o Megaman est� pegando algum �cone de especial
	public void colisaoIconeEspecial () {
		Rectangle formaMegaman = megaman.getBounds();
		Rectangle formaIconeEspecial = iconeEspecial.getBounds();
		
			//M�todo est� com algum bug (ainda n�o testado)
		if (formaMegaman.intersects(formaIconeEspecial) && iconeEspecial.isVisible()) {
			iconeEspecial.setVisible(false);
			new Som(Som.coinPontos).start();
		}
	}

	//O �cone aumenta 1 barrinha de vida do Megaman
	public class IconeVida extends Thread {
		
		@Override
		public void run() {

			int x = vida.getX();
			int y = vida.getY();
			
			while (y < Frame.chao+50) {
				
				colisaoIconeVida();  //Vai testar a colis�o a cada momento
				x+=20; 
				y+=20;
				vida.setBounds(x, y, 30, 30);
				
				try {
					sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			//Enquanto o Megaman n�o pegar o �cone, ele ser� vis�vel
			while (vida.isVisible()) {
				colisaoIconeVida();
			}
			//Aumentando a vida do Megaman
			if (Megaman.vida < 5) {
				Megaman.vida++;
				megaman.getBarraVidaMegaman().setIcon(megaman.getBarraVida()[Megaman.vida].getIcon());
			}
			interrupt();
		}
	}
	
	//O �cone aumenta 2 barrinhas de vida do Megaman
	public class IconeVidaLvl2 extends Thread {
		
		@Override
		public void run() {

			int x = vidaLvl2.getX();
			int y = vidaLvl2.getY();
			
			while (y < Frame.chao+50) {
				
				colisaoIconeVida();  //Vai testar a colis�o a cada momento
				x+=40; 
				y+=20;
				vidaLvl2.setBounds(x, y, 30, 30);
				
				try {
					sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			//Enquanto o Megaman n�o pegar o �cone, ele ser� vis�vel
			while (vidaLvl2.isVisible()) {
				colisaoIconeVidaLvl2();
			}

//Aumentando a vida do Megaman - O megaman tem no m�ximo 5 barrinhas de vida
			if ((Megaman.vida + 2) <= 5) {
				Megaman.vida+=2;
				megaman.getBarraVidaMegaman().setIcon(megaman.getBarraVida()[Megaman.vida].getIcon());
			}
//Caso o �cone de vida lvl 2 fa�a a vida ser 6, ser� adicionada apenas uma barrinha
			else if (Megaman.vida < 5) {
				Megaman.vida++;		
				megaman.getBarraVidaMegaman().setIcon(megaman.getBarraVida()[Megaman.vida].getIcon());
			}
			interrupt();
		}
	}
	
	//O �cone faz com que o Megaman tenha a vida restaurada 100%
	public class IconeVidaMaxima extends Thread {
		
		@Override
		public void run() {

			//Pega a posi��o do monstro que foi destru�do
			int x = inimigoPosX;
			int y =	inimigoPosY;
			vidaMaxima.setBounds(x, y, 30, 30);	//Consertar, d� algum erro de ponteiro
			vidaMaxima.setVisible(true);
			
			while (y < Frame.chao+50) {
				
				colisaoIconeVidaMaxima();  //Vai testar a colis�o a cada momento
				y+=20;
				vidaMaxima.setBounds(x, y, 30, 30);
				
				try {
					sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			//Enquanto o Megaman n�o pegar o �cone, ele ser� vis�vel
			while (vidaMaxima.isVisible()) {
				colisaoIconeVidaMaxima();
			}
			Megaman.vida = 5;
			megaman.getBarraVidaMegaman().setIcon(megaman.getBarraVida()[Megaman.vida].getIcon());
			interrupt();
		}
	}
	
	//O �cone d� algum tipo de poder para o Megaman ap�s detruir um monstro
	public class IconeEspecialMonstro extends Thread {
		
		@Override
		public void run() {

			//Pega a posi��o do monstro que foi destru�do
			int x = inimigoPosX;
			int y =	inimigoPosY;
			iconeEspecial.setBounds(x, y, 30, 30);
			iconeEspecial.setVisible(true);
			
			while (y < Frame.chao+50) {
				
				colisaoIconeVida();  //Vai testar a colis�o a cada momento
				y+=20;
				iconeEspecial.setBounds(x, y, 30, 30);
				
				try {
					sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			//Enquanto o Megaman n�o pegar o �cone, ele ser� vis�vel
			while (iconeEspecial.isVisible()) {
				colisaoIconeEspecial();
			}
			//O megaman ganha o poder relacionado ao �cone obtido
			interrupt();
		}
	}
}
