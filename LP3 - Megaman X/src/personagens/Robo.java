package personagens;

import java.awt.Rectangle;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import controlador.ControladorRobo;
import menu.Frame;
import menu.Som;

public class Robo extends Thread{

	private JLabel robo = new JLabel();
	private Megaman megaman;		//Para poder capturar a localização do megaman
	private int posRoboX = 800;
	private int posRoboY = Frame.chao;	
	private int posRoboLargura = 100;
	private int posRoboAltura = 160;
	private int larguraRobo = 100;
	private int alturaRobo = 160;
	private int hintsRobo = 100;
	public static int vida = 10;
	private boolean vivo = true;
	private boolean direcaoAtaque = true;    //Se for verdadeiro, ataca para esquerda
	private boolean iconeEspecial = false;
	private int velocidadeSalto = 100;
	private int qtdFuracaoGrande = 40;
	private int qtdFuracaoPequeno = 40;
	private List<JLabel[]> disparoFuracaoGrande;
	private List<JLabel[]> disparoFuracaoPequeno;

	private int tRoboAtaque1 = 7;
	private JLabel[] roboAtaque1Esq = new JLabel[tRoboAtaque1];
	private JLabel[] roboAtaque1Dir = new JLabel[tRoboAtaque1];
	
	private int tFuracao = 8;
	private JLabel[] furacao = new JLabel[tFuracao];
	
	private int tAtaqueFuracao = 4;
	private JLabel[] ataqueFuracaoEsq  = new JLabel[tAtaqueFuracao];
	private JLabel[] ataqueFuracaoDir  = new JLabel[tAtaqueFuracao];
	
	private int tFuracaoPequeno = 3;
	private JLabel[] ataqueFuracaoPequeno = new JLabel[tFuracaoPequeno];
	
	private int tRoboPulo = 8;
	private JLabel[] roboPuloEsq = new JLabel[tRoboPulo];
	private JLabel[] roboPuloDir = new JLabel[tRoboPulo];
	
	private int tRoboMorrendo = 4;
	private JLabel[] roboMorrendoEsq = new JLabel[tRoboMorrendo];
	private JLabel[] roboMorrendoDir = new JLabel[tRoboMorrendo];
	
	private int tRoboExplosao = 5;
	private JLabel[] roboExplosao = new JLabel[tRoboExplosao];
	
	private File tornado = new File("Sons/Sacred Sword Janna Skin Spotlight.wav");
	
	public Robo(Megaman megaman) {
		this.megaman = megaman;
		
		preencheSpritsRobo();
		getRobo().setBounds(posRoboX, posRoboY, posRoboLargura, posRoboAltura);
		getRobo().setVisible(false);
	}

	public int getPosRoboX() {
		return posRoboX;
	}

	public void setPosRoboX(int posRoboX) {
		this.posRoboX = posRoboX;
	}

	public int getPosRoboY() {
		return posRoboY;
	}

	public void setPosRoboY(int posRoboY) {
		this.posRoboY = posRoboY;
	}
	
	public JLabel getRobo() {
		return robo;
	}

	public boolean getVivo() {
		return vivo;
	}

	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}
	
	public int getQtdFuracaoGrande() {
		return qtdFuracaoGrande;
	}

	public void setQtdFuracaoGrande(int qtdFuracaoGrande) {
		this.qtdFuracaoGrande = qtdFuracaoGrande;
	}

	public int getQtdFuracaoPequeno() {
		return qtdFuracaoPequeno;
	}

	public void setQtdFuracaoPequeno(int qtdFuracaoPequeno) {
		this.qtdFuracaoPequeno = qtdFuracaoPequeno;
	}
	
	public JLabel[] getFuracao() {
		return furacao;
	}

	public JLabel[] getAtaqueFuracaoPequeno() {
		return ataqueFuracaoPequeno;
	}

	public List<JLabel[]> getDisparoFuracaoGrande() {
		return disparoFuracaoGrande;
	}

	public List<JLabel[]> getDisparoFuracaoPequeno() {
		return disparoFuracaoPequeno;
	}

	public boolean isIconeEspecial() {
		return iconeEspecial;
	}

	public void setIconeEspecial(boolean iconeEspecial) {
		this.iconeEspecial = iconeEspecial;
	}

	//Preenchendo todos os vetores com os sprites para os movimentos
	public void preencheSpritsRobo() {
		ataque1Preenche();
		ataqueFuracaoGrandePreenche();
		ataqueFuracaoPreenche();
		ataqueFuracaoPequenoPreenche();
		puloPreenche();
		morrendoPreeche();
		explosaoPreeche();
	}
	
	//Ataque que dispara furacão grande
	public void ataque1Preenche() {
		ImageIcon img;

		for (int i = 0; i < roboAtaque1Esq.length; i++) {
			img = new ImageIcon(getClass().getResource("./Inimigos/Robô/Ataque 1 Esq/AtaqueFuracão_" + (i + 1) + ".png"));
			img.setImage((img).getImage().getScaledInstance(larguraRobo, alturaRobo, hintsRobo));
			roboAtaque1Esq[i] = new JLabel(img);
		}
		
		for (int i = 0; i < roboAtaque1Dir.length; i++) {
			img = new ImageIcon(getClass().getResource("./Inimigos/Robô/Ataque 1 Dir/AtaqueFuracão_" + (i + 1) + ".png"));
			img.setImage((img).getImage().getScaledInstance(larguraRobo, alturaRobo, hintsRobo));
			roboAtaque1Dir[i] = new JLabel(img);
		}
	}
	
	//Adicionando os ataques de furacões em uma ArrayList de JLabel.
	public void ataqueFuracaoGrandePreenche() {
		disparoFuracaoGrande = new ArrayList<JLabel[]>();
		ImageIcon img;

		for (int i = 0; i < furacao.length; i++) {
			img = new ImageIcon(getClass().getResource("./Inimigos/Robô/Ataque 1 Esq/Furacão_" + (i + 1) + ".png"));
			img.setImage((img).getImage().getScaledInstance(90, 150, 100));
			furacao[i] = new JLabel(img);
			furacao[i].setBounds(posRoboX, posRoboY, 90, 150);
			furacao[i].setBounds(50, 50, 90, 150);		//Rectangle
			furacao[i].setVisible(false);
		}
		
		//Adicionando vetores na lista
		for (int i = 0; i < qtdFuracaoGrande; i++) {
			disparoFuracaoGrande.add(furacao);
		}
	}
	
	//Ataque que dispara furacão menor
	public void ataqueFuracaoPreenche() {
		ImageIcon img;
		
		for (int i = 0; i < ataqueFuracaoEsq.length; i++) {
			img = new ImageIcon(getClass().getResource("./Inimigos/Robô/Ataque Furacão Esq/AtaqueFuracão_" + (i + 1) + ".png"));
			img.setImage((img).getImage().getScaledInstance(larguraRobo, alturaRobo, hintsRobo));
			ataqueFuracaoEsq[i] = new JLabel(img);
		}
		
		for (int i = 0; i < ataqueFuracaoDir.length; i++) {
			img = new ImageIcon(getClass().getResource("./Inimigos/Robô/Ataque Furacão Dir/AtaqueFuracão_" + (i + 1) + ".png"));
			img.setImage((img).getImage().getScaledInstance(larguraRobo, alturaRobo, hintsRobo));
			ataqueFuracaoDir[i] = new JLabel(img);
		}
	}
	
	//Adicionando os ataques de furacões em uma ArrayList de JLabel.
	public void ataqueFuracaoPequenoPreenche() {
		disparoFuracaoPequeno = new ArrayList<JLabel[]>();
		ImageIcon img;

		for (int i = 0; i < ataqueFuracaoPequeno.length; i++) {
			img = new ImageIcon(getClass().getResource("./Inimigos/Robô/Ataque Furacão Esq/FuracaoPequeno_" + (i + 1) + ".png"));
			img.setImage((img).getImage().getScaledInstance(40, 40, 40));
			ataqueFuracaoPequeno[i] = new JLabel(img);
			ataqueFuracaoPequeno[i].setBounds(40, 40, 40, 40);
			ataqueFuracaoPequeno[i].setBounds(40, 40, 40, 40);	//Rectangle
			ataqueFuracaoPequeno[i].setVisible(false);
		}
		
		//Adicionando vetores na lista
		for (int i = 0; i < qtdFuracaoPequeno; i++) {
			disparoFuracaoPequeno.add(ataqueFuracaoPequeno);
		}
	}
	
	public void puloPreenche() {
		ImageIcon img;

		for (int i = 0; i < roboPuloEsq.length; i++) {
			img = new ImageIcon(getClass().getResource("./Inimigos/Robô/Pulando Esq/RobôPulando_" + (i + 1) + ".png"));
			img.setImage((img).getImage().getScaledInstance(larguraRobo, alturaRobo, hintsRobo));
			roboPuloEsq[i] = new JLabel(img);
		}
		
		for (int i = 0; i < roboPuloDir.length; i++) {
			img = new ImageIcon(getClass().getResource("./Inimigos/Robô/Pulando Dir/RobôPulando_" + (i + 1) + ".png"));
			img.setImage((img).getImage().getScaledInstance(larguraRobo, alturaRobo, hintsRobo));
			roboPuloDir[i] = new JLabel(img);
		}
	}
	
	public void morrendoPreeche() {
		ImageIcon img;

		for (int i = 0; i < roboMorrendoEsq.length; i++) {
			img = new ImageIcon(getClass().getResource("./Inimigos/Robô/Morrendo Esq/RoboMorrendo_" + (i + 1) + ".png"));
			img.setImage((img).getImage().getScaledInstance(larguraRobo, alturaRobo, hintsRobo));
			roboMorrendoEsq[i] = new JLabel(img);
		}
		
		for (int i = 0; i < roboMorrendoDir.length; i++) {
			img = new ImageIcon(getClass().getResource("./Inimigos/Robô/Morrendo Dir/RoboMorrendo_" + (i + 1) + ".png"));
			img.setImage((img).getImage().getScaledInstance(larguraRobo, alturaRobo, hintsRobo));
			roboMorrendoDir[i] = new JLabel(img);
		}
	}
	
	public void explosaoPreeche() {
		ImageIcon img;

		for (int i = 0; i < roboExplosao.length; i++) {
			img = new ImageIcon(getClass().getResource("./Explosão/Explosao_" + (i + 1) + ".png"));
			img.setImage((img).getImage().getScaledInstance(larguraRobo, alturaRobo, hintsRobo));
			roboExplosao[i] = new JLabel(img);
		}
	}

	//Se o Robô tiver do lado direito do megaman, ele ataca para esquerda
	public boolean direcaoAtaque() {
		if (posRoboX >= megaman.getPosMegamanX()) {
			return true;
		}
		return false;	//Se não, ataca para a direita
	}
	
	//Método para pegar o tamanho da dimensão do personagem
	public Rectangle getBounds() {
		return new Rectangle(posRoboX, posRoboY, posRoboLargura, posRoboAltura);
	}
	
	@Override
	public void run() {

		while (vida > 0) {

			int t = megaman.getQtdTiroFogo();
			Rectangle formaRobo = robo.getBounds();
			Rectangle[] formaTirosDirMegaman = new Rectangle[t];
			Rectangle[] formaTirosEsqMegaman = new Rectangle[t];
			
			//Pegando os formatos de retângulo das labels
			for (int i = 0; i < t; i++) {
				formaTirosDirMegaman[i] = megaman.getTiroFogoDir().get(i).getBounds();
				formaTirosEsqMegaman[i] = megaman.getTiroFogoEsq().get(i).getBounds();
			}
			
			//Verificando as interseções dos tiros à direita e à esquerda do Robô
			for (int i = 0; i < t; i++) {
				
				if (formaRobo.intersects(formaTirosEsqMegaman[i].getBounds()) && megaman.getTiroFogoEsq().get(i).isVisible() && robo.isVisible()){
					vida--;
					megaman.getTiroFogoEsq().get(i).setVisible(false);
					break;
				}
				else if (formaRobo.intersects(formaTirosDirMegaman[i].getBounds()) && megaman.getTiroFogoDir().get(i).isVisible() && robo.isVisible()){
					vida--;
					megaman.getTiroFogoDir().get(i).setVisible(false);
					break;
				}
			}
		}
		if (direcaoAtaque) {
			new MorrendoDir().start();
			ControladorRobo.currentThread().interrupt();
		}
		else {
			new MorrendoEsq().start();
			ControladorRobo.currentThread().interrupt();
		}
		
		try {
			megaman.new FinalizandoFase().start();
			sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		interrupt();
	}
	
	//Pulo de frente
	public class PuloEsquerdaFrente extends Thread {
		
		@Override
		public void run() {
			
			//Robô subindo após um pulo
			for (int i = 0; i < roboPuloEsq.length; i++) {
				robo.setIcon(roboPuloEsq[i].getIcon());

				try {
					if (i > 3) {
						posRoboX -= 5;
						posRoboY -= 20;
						//Não pode passar do limite esquerdo da tela
						if (posRoboX < 0) {
							posRoboX = 0;  
						}
					} 
					
					robo.setBounds(posRoboX, posRoboY, posRoboLargura, posRoboAltura);
					Thread.sleep(50);
				} catch (Exception e) {
				}
			}
			//Robô descendo do pulo
			for (int i = roboPuloEsq.length-1; i > 0; i--) {
				robo.setIcon(roboPuloEsq[i].getIcon());

				try {
					if (i > 3) {
						posRoboX -= 5;
						posRoboY += 20;
						
						if (posRoboX < 0) {
							posRoboX = 0;  
						}
					} 
					
					robo.setBounds(posRoboX, posRoboY, posRoboLargura, posRoboAltura);
					Thread.sleep(50);
				} catch (Exception e) {
				}
			}
			robo.setIcon(roboPuloEsq[0].getIcon());
			interrupt();
		}
	}
	
	//Pulo de frente
	public class PuloDireitaFrente extends Thread {
		
		@Override
		public void run() {
			
			//Robô subindo após um pulo
			for (int i = 0; i < roboPuloDir.length; i++) {
				robo.setIcon(roboPuloDir[i].getIcon());

				try {
					if (i > 3) {
						posRoboX += 5;
						posRoboY -= 20;
						//Não pode passar do limite Direito da tela
						if (posRoboX > Frame.larguraPanel-90) {
							posRoboX = Frame.larguraPanel-90;  
						}
					} 
					
					robo.setBounds(posRoboX, posRoboY, posRoboLargura, posRoboAltura);
					Thread.sleep(50);
				} catch (Exception e) {
				}
			}
			//Robô descendo do pulo
			for (int i = roboPuloDir.length-1; i > 0; i--) {
				robo.setIcon(roboPuloDir[i].getIcon());

				try {
					if (i > 3) {
						posRoboX += 5;
						posRoboY += 20;
						
						if (posRoboX > Frame.larguraPanel-90) {
							posRoboX = Frame.larguraPanel-90;  
						}
					} 
					
					robo.setBounds(posRoboX, posRoboY, posRoboLargura, posRoboAltura);
					Thread.sleep(50);
				} catch (Exception e) {
				}
			}
			robo.setIcon(roboPuloDir[0].getIcon());
			interrupt();
		}
	}
	
	//Pulo de costas
	public class PuloEsquerdaCostas extends Thread {
		
		@Override
		public void run() {
			
			//Robô subindo após um pulo
			for (int i = 0; i < roboPuloEsq.length; i++) {
				robo.setIcon(roboPuloEsq[i].getIcon());

				try {
					if (i > 3) {
						posRoboX += 5;
						posRoboY -= 20;
						//Não pode passar do limite direito da tela
						if (posRoboX > Frame.larguraPanel-90) {
							posRoboX = Frame.larguraPanel-90;  
						}
					} 
					
					robo.setBounds(posRoboX, posRoboY, posRoboLargura, posRoboAltura);
					Thread.sleep(50);
				} catch (Exception e) {
				}
			}
			//Robô descendo do pulo
			for (int i = roboPuloEsq.length-1; i > 0; i--) {
				robo.setIcon(roboPuloEsq[i].getIcon());

				try {
					if (i > 3) {
						posRoboX += 5;
						posRoboY += 20;
						
						if (posRoboX > Frame.larguraPanel-90) {
							posRoboX = Frame.larguraPanel-90;  
						}
					} 
					
					robo.setBounds(posRoboX, posRoboY, posRoboLargura, posRoboAltura);
					Thread.sleep(50);
				} catch (Exception e) {
				}
			}
			robo.setIcon(roboPuloEsq[0].getIcon());
			interrupt();
		}
	}
	
	//Pulo de costas
	public class PuloDireitaCostas extends Thread {
		
		@Override
		public void run() {
			
			//Robô subindo após um pulo
			for (int i = 0; i < roboPuloDir.length; i++) {
				robo.setIcon(roboPuloDir[i].getIcon());

				try {
					if (i > 3) {
						posRoboX -= 5;
						posRoboY -= 20;
						//Não pode passar do limite esquerdo da tela
						if (posRoboX < 0) {
							posRoboX = 0;  
						}
					} 
					
					robo.setBounds(posRoboX, posRoboY, posRoboLargura, posRoboAltura);
					Thread.sleep(50);
				} catch (Exception e) {
				}
			}
			//Robô descendo do pulo
			for (int i = roboPuloDir.length-1; i > 0; i--) {
				robo.setIcon(roboPuloDir[i].getIcon());

				try {
					if (i > 3) {
						posRoboX -= 5;
						posRoboY += 20;
						
						if (posRoboX < 0) {
							posRoboX = 0;  
						}
					} 
					
					robo.setBounds(posRoboX, posRoboY, posRoboLargura, posRoboAltura);
					Thread.sleep(50);
				} catch (Exception e) {
				}
			}
			robo.setIcon(roboPuloDir[0].getIcon());
			interrupt();
		}
	}
	
	//O Robô pula e cai na direção do megaman, caso acerte, tira 100% de vida.
	public class AtaquePuloEsquerda extends Thread {
		
		@Override
		public void run() {
			
			int x = megaman.getPosMegamanX();
			//Calculando o movimento para que o robô caia em cima do Megaman
			int movimento = (posRoboX - x)/ roboPuloEsq.length;
			
			//Robô subindo após um pulo
			for (int i = 0; i < roboPuloEsq.length; i++) {
				robo.setIcon(roboPuloEsq[i].getIcon());

				try {
					if (i > 3) {
						posRoboX -= movimento;
						posRoboY -= 75;
						
						if (posRoboX < 0) {
							posRoboX = 0;  
						}
					} 
					
					robo.setBounds(posRoboX, posRoboY, posRoboLargura, posRoboAltura);
					Thread.sleep(velocidadeSalto);
				} catch (Exception e) {
				}
			}
			//Robô descendo do pulo
			for (int i = roboPuloEsq.length-1; i > 0; i--) {
				robo.setIcon(roboPuloEsq[i].getIcon());

				try {
					if (i > 3) {
						posRoboX -= movimento;
						posRoboY += 75;
						
						if (posRoboX < 0) {
							posRoboX = 0;  
						}
						
						if (colisaoAtaquePulo()) {
							Megaman.vida = 0;
							megaman.getBarraVidaMegaman().setIcon(megaman.getBarraVida()[0].getIcon());
							megaman.new Morrendo().start();
						}
					} 
					
					robo.setBounds(posRoboX, posRoboY, posRoboLargura, posRoboAltura);
					Thread.sleep(velocidadeSalto);
				} catch (Exception e) {
				}
			}
			robo.setIcon(roboPuloEsq[0].getIcon());
			interrupt();
		}
	}
	
	//O Robô pula e cai na direção do megaman, caso acerte, tira 100% de vida.
	public class AtaquePuloDireita extends Thread {
		
		@Override
		public void run() {
			
			int x = megaman.getPosMegamanX();
			//Calculando o movimento para que o robô caia em cima do Megaman
			int movimento = (x - posRoboX)/ roboPuloDir.length;
			
			//Robô subindo após um pulo
			for (int i = 0; i < roboPuloDir.length; i++) {
				robo.setIcon(roboPuloDir[i].getIcon());

				try {
					if (i > 3) {
						posRoboX += movimento;
						posRoboY -= 75;
						
						if (posRoboX > Frame.larguraPanel-90) {
							posRoboX = Frame.larguraPanel-90;  
						}
					} 
					
					robo.setBounds(posRoboX, posRoboY, posRoboLargura, posRoboAltura);
					Thread.sleep(velocidadeSalto);
				} catch (Exception e) {
				}
			}
			//Robô descendo do pulo
			for (int i = roboPuloDir.length-1; i > 0; i--) {
				robo.setIcon(roboPuloDir[i].getIcon());

				try {
					if (i > 3) {
						posRoboX += movimento;
						posRoboY += 75;
						
						if (posRoboX > Frame.larguraPanel-90) {
							posRoboX = Frame.larguraPanel-90;  
						}
						
						if (colisaoAtaquePulo()) {
							Megaman.vida = 0;
							megaman.getBarraVidaMegaman().setIcon(megaman.getBarraVida()[0].getIcon());
							megaman.new Morrendo().start();
						}
					} 
					
					robo.setBounds(posRoboX, posRoboY, posRoboLargura, posRoboAltura);
					Thread.sleep(velocidadeSalto);
				} catch (Exception e) {
				}
			}
			robo.setIcon(roboPuloDir[0].getIcon());
			interrupt();
		}
	}
	
	//Ataque de furação para o lado esquerdo
	public class FuracaoGrandeEsquerda extends Thread {

		@Override
		public void run() {
			
			int x = posRoboX-15;
			int y = posRoboY;
			int pos = (int)(Math.random() * qtdFuracaoGrande);
			boolean dano = false;
			
			for (int i = 0; i < roboAtaque1Esq.length; i++) {
				try {
					robo.setIcon(roboAtaque1Esq[i].getIcon());
					sleep(50);
				} catch (Exception e) {
				}
			}
			robo.setIcon(roboPuloEsq[0].getIcon());
			new Som(tornado).start();

			for (JLabel ataque: disparoFuracaoGrande.get(pos)) {
				ataque.setVisible(true);
			}
			
			while (x > -40) {
				x-=40;
				dano = colisaoFuracaoGrande(pos, dano);
				
				if (dano) {
					Megaman.vida--;
					megaman.getBarraVidaMegaman().setIcon(megaman.getBarraVida()[megaman.vida].getIcon());
					break;
				}
				
				for (JLabel ataque: disparoFuracaoGrande.get(pos)) {
					ataque.setBounds(x, y, ataque.getWidth(), ataque.getHeight());
					try {
						sleep(35);
					} catch (Exception e) {
					}
				}
			}
			//Dando Visible(false) para o vetor de label que apareceu na panel
			for (JLabel ataque: disparoFuracaoGrande.get(pos)) {
				ataque.setVisible(false);
			}
			interrupt();
		}
	}
	
	//Ataque de furação para o lado direito
	public class FuracaoGrandeDireita extends Thread {

		@Override
		public void run() {
			
			int x = posRoboX+15;
			int y = posRoboY;
			int pos = (int)(Math.random() * qtdFuracaoGrande);
			boolean dano = false;
			
			for (int i = 0; i < roboAtaque1Dir.length; i++) {
				try {
					robo.setIcon(roboAtaque1Dir[i].getIcon());
					sleep(50);
				} catch (Exception e) {
				}
			}
			robo.setIcon(roboPuloDir[0].getIcon());
			new Som(tornado).start();
			
			for (JLabel ataque: disparoFuracaoGrande.get(pos)) {
				ataque.setVisible(true);
			}
			
			while (x < Frame.larguraPanel+40) {
				x+=40;
				dano = colisaoFuracaoGrande(pos, dano);
				
				if (dano) {
					Megaman.vida--;
					megaman.getBarraVidaMegaman().setIcon(megaman.getBarraVida()[megaman.vida].getIcon());
					break;
				}
				
				for (JLabel ataque: disparoFuracaoGrande.get(pos)) {
					ataque.setBounds(x, y, ataque.getWidth(), ataque.getHeight());
					try {
						sleep(35);
					} catch (Exception e) {
					}
				}
			}
			//Dando Visible(false) para o vetor de label que apareceu na panel
			for (JLabel ataque: disparoFuracaoGrande.get(pos)) {
				ataque.setVisible(false);
			}
			interrupt();
		}
	}
	
	//Ataque de furação para o lado esquerdo
	public class FuracaoPequenoEsquerda extends Thread {

		@Override
		public void run() {
			
			int x = posRoboX-15;
			int y = posRoboY+45;
			int pos = (int)(Math.random() * qtdFuracaoPequeno);
			
			boolean dano = false;	 //Um ataque de furacão não pode causar mais de um dano ao Megaman
			
			for (int i = 0; i < ataqueFuracaoEsq.length; i++) {
				try {
					robo.setIcon(ataqueFuracaoEsq[i].getIcon());
					sleep(50);
				} catch (Exception e) {
				}
			}
			robo.setIcon(roboPuloEsq[0].getIcon());
			new Som(tornado).start();

			for (JLabel ataque: disparoFuracaoPequeno.get(pos)) {
				ataque.setVisible(true);
			}
			
			while (x > -10) {
				x-=40;
				dano = colisaoFuracaoPequeno(pos, dano);

				if (dano) {				//Se ocorreu a colisão, tira uma vida do Megaman
					Megaman.vida--;
					megaman.getBarraVidaMegaman().setIcon(megaman.getBarraVida()[megaman.vida].getIcon());
					break;
				}
				
				for (JLabel ataque: disparoFuracaoPequeno.get(pos)) {
					ataque.setBounds(x, y, ataque.getWidth(), ataque.getHeight());
					try {
						sleep(35);
					} catch (Exception e) {
					}
				}
			}
			
			//Dando Visible(false) para o vetor de label que apareceu na panel
			for (JLabel ataque: disparoFuracaoPequeno.get(pos)) {
				ataque.setVisible(false);
			}
			interrupt();
		}
	}
	
	//Ataque de furação para o lado direito
	public class FuracaoPequenoDireita extends Thread {

		@Override
		public void run() {
			
			int x = posRoboX-15;
			int y = posRoboY+45;
			int pos = (int)(Math.random() * qtdFuracaoPequeno);
			
			boolean dano = false;
			
			for (int i = 0; i < ataqueFuracaoDir.length; i++) {
				try {
					robo.setIcon(ataqueFuracaoDir[i].getIcon());
					sleep(50);
				} catch (Exception e) {
				}
			}
			robo.setIcon(roboPuloDir[0].getIcon());
			new Som(tornado).start();

			for (JLabel ataque: disparoFuracaoPequeno.get(pos)) {
				ataque.setVisible(true);
			}
			
			while (x < Frame.larguraPanel+40) {
				x+=40;
				dano = colisaoFuracaoPequeno(pos, dano);
				
				if (dano) {			//Se ocorreu a colisão, tira uma vida do Megaman
					Megaman.vida--;
					megaman.getBarraVidaMegaman().setIcon(megaman.getBarraVida()[megaman.vida].getIcon());
					break;
				}
				
				for (JLabel ataque: disparoFuracaoPequeno.get(pos)) {
					ataque.setBounds(x, y, ataque.getWidth(), ataque.getHeight());
					try {
						sleep(35);
					} catch (Exception e) {
					}
				}
			}
			
			//Dando Visible(false) para o vetor de label que apareceu na panel
			for (JLabel ataque: disparoFuracaoPequeno.get(pos)) {
				ataque.setVisible(false);
			}
			interrupt();
		}
	}
	
	public class Explosao extends Thread{
		@Override
		public void run() {
			
			for (int i = 0; i < roboExplosao.length; i++) {
				robo.setIcon(roboExplosao[i].getIcon());

				try {
					sleep(300);
				} catch (Exception e) {
				}
			}
			
			//Quando o Robô é destruído, ele deixa de ser visível na panel
			robo.setVisible(false);
			interrupt();
		}
	}
	
	//O robô cai para a esquerda
	public class MorrendoEsq extends Thread{
		@Override
		public void run() {
			
			int x = posRoboX;
			
			for (int i = 0; i < roboMorrendoEsq.length; i++) {
				
				x+=60;
				robo.setIcon(roboMorrendoEsq[i].getIcon());
				robo.setBounds(x, posRoboY, robo.getWidth(), robo.getHeight());
				
				try {
					sleep(100);
				} catch (Exception e) {
				}
			}
			setVivo(false);
			interrupt();
			Robo.currentThread().interrupt();	//Encerrando a thread do Robô
		}
	}
	
	//O robô cai para a direita
	public class MorrendoDir extends Thread{
		@Override
		public void run() {
			
			int x = posRoboX;
			
			for (int i = 0; i < roboMorrendoDir.length; i++) {
				
				x-=60;
				robo.setIcon(roboMorrendoDir[i].getIcon());
				robo.setBounds(x, posRoboY, robo.getWidth(), robo.getHeight());
				
				try {
					sleep(100);
				} catch (Exception e) {
				}
			}
			setVivo(false);
			interrupt();
			Robo.currentThread().interrupt();	//Encerrando a thread do Robô
		}
	}
	
	public boolean colisaoFuracaoPequeno(int pos, boolean dano) {
		
		int t = disparoFuracaoPequeno.get(pos).length;
		Rectangle formaMegaman = megaman.getBounds();
		Rectangle[] formaFuracaoPequeno = new Rectangle[t];
		
		//Pegando os formatos de retângulo das labels
		for (int i = 0; i < t; i++) {
			formaFuracaoPequeno[i] = disparoFuracaoPequeno.get(pos)[i].getBounds();
		}
		
		//Verificando as interseções
		for (int i = 0; i < t; i++) {
			if (formaMegaman.intersects(formaFuracaoPequeno[i].getBounds()) && !dano && megaman.vida > 0) {
				return true;
			}
		}
		return false;
	}
	
	public boolean colisaoFuracaoGrande(int pos, boolean dano) {
		
		int t = disparoFuracaoGrande.get(pos).length;
		Rectangle formaMegaman = megaman.getBounds();
		Rectangle[] formaFuracaoGrande = new Rectangle[t];
		
		//Pegando os formatos de retângulo das labels
		for (int i = 0; i < t; i++) {
			formaFuracaoGrande[i] = disparoFuracaoGrande.get(pos)[i].getBounds();
		}
		
		//Verificando as interseções
		for (int i = 0; i < t; i++) {
			if (formaMegaman.intersects(formaFuracaoGrande[i].getBounds()) && !dano && megaman.vida > 0) {
				return true;
			}
		}
		return false;
	}
	
	public boolean colisaoAtaquePulo() {
		Rectangle formaMegaman = megaman.getBounds();
		Rectangle formaRobo = robo.getBounds();
		
		if (formaMegaman.intersects(formaRobo) && megaman.vida > 0) {
			return true;
		}
		return false;
	}
}
