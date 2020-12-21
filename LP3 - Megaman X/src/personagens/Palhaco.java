package personagens;

import java.awt.Rectangle;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import controlador.ControladorPalhaco;
//import controlador.ControladorPalhaco;
import menu.Frame;

public class Palhaco extends Thread{

	private JLabel palhaco = new JLabel();
	private Megaman megaman;				//Para poder capturar a localização do megaman
	private int posPalhacoX = 800;
	private int posPalhacoY = Frame.chao;	
	private int posPalhacoLargura = 60;
	private int posPalhacoAltura = 60;
	private int larguraPalhaco = 60;
	private int alturaPalhaco = 60;
	private int hintsPalhaco = 60;
	public static int vida = 3;
	private int qtdBola = 50;
	private JLabel[] bola;					//Ataque da bola
	private List<JLabel[]> listaBola;

	private int tPalhacoAndando = 2;
	private JLabel[] palhacoAndandoEsq = new JLabel[tPalhacoAndando];
	private JLabel[] palhacoAndandoDir = new JLabel[tPalhacoAndando];
	
	private int tPalhacoCorrendo = 2;
	private JLabel[] palhacoCorrendoEsq = new JLabel[tPalhacoCorrendo];
	private JLabel[] palhacoCorrendoDir = new JLabel[tPalhacoCorrendo];
	
	private int tPalhacoParado = 1;
	private JLabel[] palhacoParadoEsq = new JLabel[tPalhacoParado];
	private JLabel[] palhacoParadoDir = new JLabel[tPalhacoParado];

	private int tMovimentoAtaque = 6;
	private JLabel[] movimentoAtaqueEsq  = new JLabel[tMovimentoAtaque];
	private JLabel[] movimentoAtaqueDir  = new JLabel[tMovimentoAtaque];
	
	private int tBola = 4;
	private JLabel[] bolaEsq  = new JLabel[tBola];
	private JLabel[] bolaDir  = new JLabel[tBola];
	
	private int tPalhacoPulo = 5;
	private JLabel[] palhacoPuloEsq = new JLabel[tPalhacoPulo];
	private JLabel[] palhacoPuloDir = new JLabel[tPalhacoPulo];
	
	private int tPalhacoExplosao = 5;
	private JLabel[] palhacoExplosao = new JLabel[tPalhacoExplosao];
	
	private File somBola = new File("Sons/Palhaco - Katon Goukakyuu no Jutsu.wav");
	
	public Palhaco(Megaman megaman) {
		this.megaman = megaman;
		
		preencheSpritsPalhaco();
		getPalhaco().setBounds(posPalhacoX, posPalhacoY, posPalhacoLargura, posPalhacoAltura);
		getPalhaco().setVisible(false);
	}
	
	public int getPosPalhacoX() {
		return posPalhacoX;
	}

	public void setPosPalhacoX(int posPalhacoX) {
		this.posPalhacoX = posPalhacoX;
	}

	public int getPosPalhacoY() {
		return posPalhacoY;
	}

	public void setPosPalhacoY(int posPalhacoY) {
		this.posPalhacoY = posPalhacoY;
	}
	
	public JLabel getPalhaco() {
		return palhaco;
	}

	public int getQtdBola() {
		return qtdBola;
	}

	public void setQtdBola(int qtdBola) {
		this.qtdBola = qtdBola;
	}
	
	public JLabel[] getBola() {
		return bola;
	}
	
	public List<JLabel[]> getListaBolas() {
		return listaBola;
	}
	
	//Preenchendo todos os vetores com os sprites para os movimentos
	public void preencheSpritsPalhaco() {
		andandoPreenche();
		correndoPreenche();
		paradoPreenche();
		movimentoAtaquePreenche();
		bolaPreenche();
		puloPreenche();
		explosaoPreeche();
	}
	
	public void andandoPreenche() {
		ImageIcon img;
		
		for (int i = 0; i < palhacoAndandoEsq.length; i++) {
			img = new ImageIcon(getClass().getResource("./Inimigos/Palhaco/Andando Esq/palhaco_" + (i + 1) + ".png"));
			img.setImage((img).getImage().getScaledInstance(larguraPalhaco, alturaPalhaco, hintsPalhaco));
			palhacoAndandoEsq[i] = new JLabel(img);
		}
		
		for (int i = 0; i < palhacoAndandoDir.length; i++) {
			img = new ImageIcon(getClass().getResource("./Inimigos/Palhaco/Andando Dir/palhaco_" + (i + 1) + ".png"));
			img.setImage((img).getImage().getScaledInstance(larguraPalhaco, alturaPalhaco, hintsPalhaco));
			palhacoAndandoDir[i] = new JLabel(img);
		}
	}
	
	public void correndoPreenche() {
		ImageIcon img;
		
		for (int i = 0; i < palhacoCorrendoEsq.length; i++) {
			img = new ImageIcon(getClass().getResource("./Inimigos/Palhaco/Correndo Esq/palhaco_" + (i + 1) + ".png"));
			img.setImage((img).getImage().getScaledInstance(larguraPalhaco, alturaPalhaco, hintsPalhaco));
			palhacoCorrendoEsq[i] = new JLabel(img);
		}
		
		for (int i = 0; i < palhacoCorrendoDir.length; i++) {
			img = new ImageIcon(getClass().getResource("./Inimigos/Palhaco/Correndo Dir/palhaco_" + (i + 1) + ".png"));
			img.setImage((img).getImage().getScaledInstance(larguraPalhaco, alturaPalhaco, hintsPalhaco));
			palhacoCorrendoDir[i] = new JLabel(img);
		}
	}
	
	public void paradoPreenche() {
		ImageIcon img;
		
		for (int i = 0; i < palhacoParadoEsq.length; i++) {
			img = new ImageIcon(getClass().getResource("./Inimigos/Palhaco/Parado Esq/palhaco_" + (i + 1) + ".png"));
			img.setImage((img).getImage().getScaledInstance(larguraPalhaco, alturaPalhaco, hintsPalhaco));
			palhacoParadoEsq[i] = new JLabel(img);
		}
		
		for (int i = 0; i < palhacoParadoDir.length; i++) {
			img = new ImageIcon(getClass().getResource("./Inimigos/Palhaco/Parado Dir/palhaco_" + (i + 1) + ".png"));
			img.setImage((img).getImage().getScaledInstance(larguraPalhaco, alturaPalhaco, hintsPalhaco));
			palhacoParadoDir[i] = new JLabel(img);
		}
	}
	
	//Movimento do Palhaço para jogar a bola
	public void movimentoAtaquePreenche() {
		ImageIcon img;
		
		for (int i = 0; i < movimentoAtaqueEsq.length; i++) {
			img = new ImageIcon(getClass().getResource("./Inimigos/Palhaco/Ataque Esq/palhaco_" + (i + 1) + ".png"));
			img.setImage((img).getImage().getScaledInstance(larguraPalhaco, alturaPalhaco, hintsPalhaco));
			movimentoAtaqueEsq[i] = new JLabel(img);
		}
		
		for (int i = 0; i < movimentoAtaqueDir.length; i++) {
			img = new ImageIcon(getClass().getResource("./Inimigos/Palhaco/Ataque Dir/palhaco_" + (i + 1) + ".png"));
			img.setImage((img).getImage().getScaledInstance(larguraPalhaco, alturaPalhaco, hintsPalhaco));
			movimentoAtaqueDir[i] = new JLabel(img);
		}
	}
	
	//Adicionando os ataques de furacões em uma ArrayList de JLabel.
	public void bolaPreenche() {
		listaBola = new ArrayList<JLabel[]>();
		ImageIcon img;
		
		for (int i = 0; i < bolaEsq.length; i++) {
			img = new ImageIcon(getClass().getResource("./Inimigos/Palhaco/Ataque Esq/bola_" + (i + 1) + ".png"));
			img.setImage((img).getImage().getScaledInstance(50, 50, 50));
			bolaEsq[i] = new JLabel(img);
			bolaEsq[i].setBounds(50, 50, 50, 50);
			bolaEsq[i].setBounds(50, 50, 50, 50);	//Rectangle
			bolaEsq[i].setVisible(false);
		}

		for (int i = 0; i < bolaDir.length; i++) {
			img = new ImageIcon(getClass().getResource("./Inimigos/Palhaco/Ataque Dir/bola_" + (i + 1) + ".png"));
			img.setImage((img).getImage().getScaledInstance(50, 50, 50));
			bolaDir[i] = new JLabel(img);
			bolaDir[i].setBounds(50, 50, 50, 50);
			bolaDir[i].setBounds(50, 50, 50, 50);	//Rectangle
			bolaDir[i].setVisible(false);
		}
		
		//Adicionando vetores na lista
		for (int i = 0; i < qtdBola; i++) {
			listaBola.add(bolaEsq);
			listaBola.add(bolaDir);
		}
	}
	
	public void puloPreenche() {
		ImageIcon img;

		for (int i = 0; i < palhacoPuloEsq.length; i++) {
			img = new ImageIcon(getClass().getResource("./Inimigos/Palhaco/Pulando Esq/palhaco_" + (i + 1) + ".png"));
			img.setImage((img).getImage().getScaledInstance(larguraPalhaco, alturaPalhaco, hintsPalhaco));
			palhacoPuloEsq[i] = new JLabel(img);
		}
		
		for (int i = 0; i < palhacoPuloDir.length; i++) {
			img = new ImageIcon(getClass().getResource("./Inimigos/Palhaco/Pulando Dir/palhaco_" + (i + 1) + ".png"));
			img.setImage((img).getImage().getScaledInstance(larguraPalhaco, alturaPalhaco, hintsPalhaco));
			palhacoPuloDir[i] = new JLabel(img);
		}
	}
	
	public void explosaoPreeche() {
		ImageIcon img;

		for (int i = 0; i < palhacoExplosao.length; i++) {
			img = new ImageIcon(getClass().getResource("./Explosão/Explosao_" + (i + 1) + ".png"));
			img.setImage((img).getImage().getScaledInstance(larguraPalhaco, alturaPalhaco, hintsPalhaco));
			palhacoExplosao[i] = new JLabel(img);
		}
	}
	
	//Se Palhaco tiver do lado direito do megaman, ele ataca para esquerda
	public boolean direcaoAtaque() {
		if (posPalhacoX >= megaman.getPosMegamanX()) {
			return true;
		}
		return false;			//Se não, ataca para a direita
	}
	
	//Método para pegar o tamanho da dimensão do personagem
	public Rectangle getBounds() {
		return new Rectangle(posPalhacoX, posPalhacoY, posPalhacoLargura, posPalhacoAltura);
	}
	
	public File getSomBola() {
		return somBola;
	}
	
	@Override
	public void run() {
		while (vida > 0) {

			int t = megaman.getQtdTiroFogo();
			Rectangle formaPalhaco = palhaco.getBounds();
			Rectangle[] formaTirosDirMegaman = new Rectangle[t];
			Rectangle[] formaTirosEsqMegaman = new Rectangle[t];
			
			//Pegando os formatos de retângulo das labels
			for (int i = 0; i < t; i++) {
				formaTirosDirMegaman[i] = megaman.getTiroFogoDir().get(i).getBounds();
				formaTirosEsqMegaman[i] = megaman.getTiroFogoEsq().get(i).getBounds();
			}
			
			//Verificando as interseções dos tiros do Megaman à direita e à esquerda de Palhaco
			for (int i = 0; i < t; i++) {
				
				if (formaPalhaco.intersects(formaTirosEsqMegaman[i].getBounds()) && megaman.getTiroFogoEsq().get(i).isVisible() && palhaco.isVisible()){
					vida--;
					megaman.getTiroFogoEsq().get(i).setVisible(false);
					break;
				}
				else if (formaPalhaco.intersects(formaTirosDirMegaman[i].getBounds()) && megaman.getTiroFogoDir().get(i).isVisible() && palhaco.isVisible()){
					vida--;
					megaman.getTiroFogoDir().get(i).setVisible(false);
					break;
				}
			}
		}
		
		ControladorPalhaco.currentThread().interrupt();
		new Explosao().start();
		
		try {			
			sleep(4000);						
			megaman.new FinalizandoFase().start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		interrupt();
	}
	
	public class AndandoEsq extends Thread{
		@Override
		public void run() {
			
			for (int i = 0; i < palhacoAndandoEsq.length; i++) {
				
				palhaco.setIcon(palhacoAndandoEsq[i].getIcon());
				palhaco.setBounds(posPalhacoX, posPalhacoY, palhaco.getWidth(), palhaco.getHeight());
				
				try {
					sleep(300);
				} catch (Exception e) {
				}
			}
			interrupt();
		}
	}
		
	public class AndandoDir extends Thread{
		@Override
		public void run() {
			
			for (int i = 0; i < palhacoAndandoDir.length; i++) {
				
				palhaco.setIcon(palhacoAndandoDir[i].getIcon());
				palhaco.setBounds(posPalhacoX, posPalhacoY, palhaco.getWidth(), palhaco.getHeight());
				
				try {
					sleep(300);
				} catch (Exception e) {
				}
			}
			interrupt();
		}
	}
	
	public class CorrendoEsq extends Thread {

		@Override
		public void run() {

			for (int i = 0; i < palhacoCorrendoEsq.length; i++) {
				palhaco.setIcon(palhacoCorrendoEsq[i].getIcon());
				posPalhacoX -= 25;
				
				if (posPalhacoX < 0) {	//Não pode passar do limite esquerdo da tela
					posPalhacoX = 0;
					palhaco.setBounds(posPalhacoX, posPalhacoY, 100, 100);
					break;
				}
				else {
					palhaco.setBounds(posPalhacoX, posPalhacoY, 100, 100);
				}
				
				try {
					sleep(150);
				} catch (Exception e) {
				}
			}
			palhaco.setIcon(palhacoParadoEsq[0].getIcon());
			interrupt();
		}
	}
	
	public class CorrendoDir extends Thread {

		@Override
		public void run() {

			for (int i = 0; i < palhacoCorrendoDir.length; i++) {
				palhaco.setIcon(palhacoCorrendoDir[i].getIcon());
				posPalhacoX += 25;
				
				if (posPalhacoX > Frame.larguraPanel-90) {	//Não pode passar do limite direito da tela
					posPalhacoX = Frame.larguraPanel-90;
					palhaco.setBounds(posPalhacoX, posPalhacoY, 100, 100);
					break;
				}
				else {
					palhaco.setBounds(posPalhacoX, posPalhacoY, 100, 100);
				}
				
				try {
					sleep(150);
				} catch (Exception e) {
				}
			}
			palhaco.setIcon(palhacoParadoDir[0].getIcon());
			interrupt();
		}
	}
	
	public class PuloEsq extends Thread {
		
		@Override
		public void run() {
			
			for (int i = 0; i < palhacoPuloEsq.length; i++) {
				palhaco.setIcon(palhacoPuloEsq[i].getIcon());

				try {
					if (i < 3) {
						posPalhacoY -= 20;
						posPalhacoX -= 20;
					} else {
						posPalhacoY += 20;
						posPalhacoX -= 20;
					}

					palhaco.setBounds(posPalhacoX, posPalhacoY, 100, 100);
					sleep(150);
				} catch (Exception e) {
				}
			}
			posPalhacoX -= 20;
			posPalhacoY += 20;
			palhaco.setBounds(posPalhacoX, posPalhacoY, 100, 100);
			palhaco.setIcon(palhacoParadoEsq[0].getIcon());
			interrupt();
		}
	}

	public class PuloDir extends Thread {
		
		@Override
		public void run() {
			
			for (int i = 0; i < palhacoPuloDir.length; i++) {
				palhaco.setIcon(palhacoPuloDir[i].getIcon());

				try {
					if (i < 3) {
						posPalhacoY -= 20;
						posPalhacoX += 20;
					} else {
						posPalhacoY += 20;
						posPalhacoX += 20;
					}

					palhaco.setBounds(posPalhacoX, posPalhacoY, 100, 100);
					sleep(150);
				} catch (Exception e) {
				}
			}
			posPalhacoX += 20;
			posPalhacoY += 20;
			palhaco.setBounds(posPalhacoX, posPalhacoY, 100, 100);
			palhaco.setIcon(palhacoParadoDir[0].getIcon());
			interrupt();
		}
	}
	
	//Ataque da bola para o lado esquerdo
	public class AtaqueBolaEsq extends Thread {

		@Override
		public void run() {
			
			int x = posPalhacoX-15;
			int y = posPalhacoY+45;
			int pos = (int)(Math.random() * qtdBola);
			
			boolean dano = false;	 	//Um ataque não pode causar mais de um dano ao Megaman
			
			for (int i = 0; i < movimentoAtaqueEsq.length; i++) {
				
				palhaco.setIcon(movimentoAtaqueEsq[i].getIcon());
				palhaco.setBounds(posPalhacoX, posPalhacoY, palhaco.getWidth(), palhaco.getHeight());
				
				try {
					sleep(200);
				} catch (Exception e) {
				}
			}
	//		new Som(tornado).start();

			for (JLabel ataque: listaBola.get(pos)) {
				ataque.setVisible(true);
			}
			
			while (x > -10) {
				x-=10;
				dano = colisaoAtaqueBola(pos, dano);

				if (dano) {			//Se ocorreu a colisão, tira uma vida do Megaman
					Megaman.vida--;
					megaman.getBarraVidaMegaman().setIcon(megaman.getBarraVida()[megaman.vida].getIcon());
					break;
				}
				
				for (JLabel ataque: listaBola.get(pos)) {
					ataque.setBounds(x, y, ataque.getWidth(), ataque.getHeight());
					try {
						sleep(5);
					} catch (Exception e) {
					}
				}
			}
			
			//Dando Visible(false) para o vetor de label que apareceu na panel
			for (JLabel ataque: listaBola.get(pos)) {
				ataque.setVisible(false);
			}
			interrupt();
		}
	}
	
	//Ataque da bola para o lado direito
	public class AtaqueBolaDir extends Thread {
		
		@Override
		public void run() {
			
			int x = posPalhacoX-15;
			int y = posPalhacoY+45;
			int pos = (int)(Math.random() * qtdBola);
			
			boolean dano = false;	 	//Um ataque não pode causar mais de um dano ao Megaman
			
			for (int i = 0; i < movimentoAtaqueEsq.length; i++) {
				
				palhaco.setIcon(movimentoAtaqueDir[i].getIcon());
				palhaco.setBounds(posPalhacoX, posPalhacoY, palhaco.getWidth(), palhaco.getHeight());
				
				try {
					sleep(200);
				} catch (Exception e) {
				}
			}
			//new Som(tornado).start();
			
			for (JLabel ataque: listaBola.get(pos)) {
				ataque.setVisible(true);
			}
			
			while (x > -10) {
				x+=10;
				dano = colisaoAtaqueBola(pos, dano);
				
				if (dano) {				//Se ocorreu a colisão, tira uma vida do Megaman
					Megaman.vida--;
					megaman.getBarraVidaMegaman().setIcon(megaman.getBarraVida()[megaman.vida].getIcon());
					break;
				}
				
				for (JLabel ataque: listaBola.get(pos)) {
					ataque.setBounds(x, y, ataque.getWidth(), ataque.getHeight());
					try {
						sleep(5);
					} catch (Exception e) {
					}
				}
			}
			
			//Dando Visible(false) para o vetor de label que apareceu na panel
			for (JLabel ataque: listaBola.get(pos)) {
				ataque.setVisible(false);
			}
			interrupt();
		}
	}
	
	public boolean colisaoAtaqueBola(int pos, boolean dano) {
		
		int t = listaBola.get(pos).length;
		Rectangle formaMegaman = megaman.getBounds();
		Rectangle[] formaBola = new Rectangle[t];
		
		//Pegando os formatos de retângulo das labels
		for (int i = 0; i < t; i++) {
			formaBola[i] = listaBola.get(pos)[i].getBounds();
		}
		
		//Verificando as interseções
		for (int i = 0; i < t; i++) {
			if (formaMegaman.intersects(formaBola[i].getBounds()) && !dano && megaman.vida > 0) {
				return true;
			}
		}
		return false;
	}
	
	public class Explosao extends Thread{
		@Override
		public void run() {
			
			for (int i = 0; i < palhacoExplosao.length; i++) {
				palhaco.setIcon(palhacoExplosao[i].getIcon());

				try {
					sleep(300);
				} catch (Exception e) {
				}
			}
			
			//Quando o Palhaço é destruído, ele deixa de ser visível na panel
			palhaco.setVisible(false);
			interrupt();
		}
	}
}