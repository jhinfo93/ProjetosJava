/* Lembrar de preencher todos vetores antes de utilizar e jogar em "addComponentes"
 * 
 * Forma correta - Megaman é uma thread e pular, correr, etc, são seus métodos
 */
package personagens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import menu.Frame;

public class Megaman extends Thread {

	private JLabel megaman = new JLabel();
	private JLabel score;
	public JLabel barraVidaMegaman;
	public JLabel rostoMegaman;
	public static int vida = 5;
	private int posMegamanX = 100;
	private int posMegamanY = Frame.chao;
	private int larguraMegaman = 60;
	private int alturaMegaman = 60;
	private int hintsMegaman = 60;
	private int monstrosDestruidosTotal = 0;
	private int monstrosDestruidosFase = 0;  //Será zerada a cada início de uma fase
	private int qtdTiroFogo = 100;
	private List<JLabel> tiroFogoDir;
	private List<JLabel> tiroFogoEsq;
	//Se for verdadeiro, toda ação do Megaman será para a direita, se não, será para esquerda
	private boolean direcaoDireita = true; 
	private int tBarraVida = 6;
	public JLabel[] barraVida = new JLabel [tBarraVida];
	
	int tmegamanIniciandoFase = 14;
	private JLabel[] megamanIniciandoFase = new JLabel[tmegamanIniciandoFase];
	
	int tmegamanFinalizandoFase = 4;
	private JLabel[] megamanFinalizandoFase = new JLabel[tmegamanFinalizandoFase];
	
	int tMegamanParado = 3;
	private JLabel[] megamanParado = new JLabel[tMegamanParado];
	
	int tMegamanAnda = 8;
	private JLabel[] megamanAndaDir = new JLabel[tMegamanAnda];
	private JLabel[] megamanAndaEsq = new JLabel[tMegamanAnda];
	
	int tMegamanPulo = 6;
	private JLabel[] megamanPuloDir = new JLabel[tMegamanPulo];
	private JLabel[] megamanPuloEsq = new JLabel[tMegamanPulo];
	
	int tMegamanDash = 3;
	private JLabel[] megamanDashDir = new JLabel[tMegamanDash];
	private JLabel[] megamanDashEsq = new JLabel[tMegamanDash];
	
	int tMegamanAtirando = 3;
	private JLabel[] megamanAtirandoDir = new JLabel[tMegamanAtirando];
	private JLabel[] megamanAtirandoEsq = new JLabel[tMegamanAtirando];
	
	int tAtaqueEspada = 2;
	private JLabel[] ataqueEspadaDir = new JLabel[tAtaqueEspada];
	private JLabel[] ataqueEspadaEsq = new JLabel[tAtaqueEspada];
	int tEspada = 5;
	private JLabel[] espadaAzulDir = new JLabel[tEspada];
	private JLabel[] espadaAzulEsq = new JLabel[tEspada];
	private JLabel[] espadaVermelhaDir = new JLabel[tEspada];
	private JLabel[] espadaVermelhaEsq = new JLabel[tEspada];
	private int qtdEspadaAzul = 100;
	private int qtdEspadaVermelha = 100;
	private List<JLabel> listaEspadaAzulDir;
	private List<JLabel> listaEspadaAzulEsq;
	private List<JLabel> listaEspadaVermelhaDir;
	private List<JLabel> listaEspadaVermelhaEsq;
	
	int tMegamanMorrendo = 8;
	private JLabel[] megamanMorrendo = new JLabel[tMegamanMorrendo];

	public Megaman() {
		preencheSpritsMegaman();
		getMegaman().setBounds(posMegamanX, posMegamanY, 100, 100);
	}

	public int getPosMegamanX() {
		return posMegamanX;
	}
	public void setPosMegamanX(int x) {
		posMegamanX = x;
	}

	public int getPosMegamanY() {
		return posMegamanY;
	}
	
	public void setPosMegamanY(int y) {
		posMegamanY = y;
	}

	public JLabel getMegaman() {
		return megaman;
	}
	
	public boolean isDirecaoDireita() {
		return direcaoDireita;
	}

	public void setDirecaoDireita(boolean direcaoDireita) {
		this.direcaoDireita = direcaoDireita;
	}

	public int getVida() {
		return vida;
	}
	
	public JLabel getBarraVidaMegaman() {
		return barraVidaMegaman;
	}

	public void setBarraVidaMegaman(JLabel barraVidaMegaman) {
		this.barraVidaMegaman = barraVidaMegaman;
	}

	public JLabel[] getBarraVida() {
		return barraVida;
	}
	
	public JLabel getRostoMegaman() {
		return rostoMegaman;
	}

	public int getTmegamanIniciandoFase() {
		return tmegamanIniciandoFase;
	}

	public JLabel[] getMegamanIniciandoFase() {
		return megamanIniciandoFase;
	}
	
	public int getTmegamanFinalizandoFase() {
		return tmegamanFinalizandoFase;
	}

	public JLabel[] getMegamanFinalizandoFase() {
		return megamanFinalizandoFase;
	}

	public int gettMegamanParado() {
		return tMegamanParado;
	}

	public JLabel[] getMegamanParado() {
		return megamanParado;
	}

	public int gettMegamanAnda() {
		return tMegamanAnda;
	}

	public JLabel[] getMegamanAndaDir() {
		return megamanAndaDir;
	}
	
	public JLabel[] getMegamanAndaEsq() {
		return megamanAndaEsq;
	}

	public int getTAtaqueEspada() {
		return tAtaqueEspada;
	}

	public JLabel[] getAtaqueEspadaDir() {
		return ataqueEspadaDir;
	}
	
	public JLabel[] getAtaqueEspadaEsq() {
		return ataqueEspadaEsq;
	}
	
	public int getTEspada() {
		return tEspada;
	}

	public JLabel[] getEspadaAzulDir() {
		return espadaAzulDir;
	}
	
	public JLabel[] getEspadaAzulEsq() {
		return espadaAzulEsq;
	}
	
	public JLabel[] getEspadaVermelhaDir() {
		return espadaVermelhaDir;
	}
	
	public JLabel[] getEspadaVermelhaEsq() {
		return espadaVermelhaEsq;
	}
	
	public int gettMegamanPulo() {
		return tMegamanPulo;
	}

	public JLabel[] getMegamanPuloDir() {
		return megamanPuloDir;
	}
	
	public JLabel[] getMegamanPuloEsq() {
		return megamanPuloEsq;
	}

	public int gettMegamanDash() {
		return tMegamanDash;
	}

	public JLabel[] getMegamanDashDir() {
		return megamanDashDir;
	}
	
	public JLabel[] getMegamanDashEsq() {
		return megamanDashEsq;
	}
	
	public int getTMegamanAtirando() {
		return tMegamanAtirando;
	}

	public JLabel[] getMegamanAtirandoDir() {
		return megamanAtirandoDir;
	}
	
	public JLabel[] getMegamanAtirandoEsq() {
		return megamanAtirandoEsq;
	}

	public int gettMegamanMorrendo() {
		return tMegamanMorrendo;
	}

	public JLabel[] getMegamanMorrendo() {
		return megamanMorrendo;
	}
	
	public List<JLabel> getTiroFogoDir() {
		return tiroFogoDir;
	}
	
	public List<JLabel> getTiroFogoEsq() {
		return tiroFogoEsq;
	}
	
	public List<JLabel> getListaEspadaAzulDir() {
		return listaEspadaAzulDir;
	}
	
	public List<JLabel> getListaEspadaAzulEsq() {
		return listaEspadaAzulEsq;
	}
	
	public List<JLabel> getListaEspadaVermelhaDir() {
		return listaEspadaVermelhaDir;
	}
	
	public List<JLabel> getListaEspadaVermelhaEsq() {
		return listaEspadaVermelhaEsq;
	}
	
	public int getMonstrosDestruidosFase() {
		return monstrosDestruidosFase;
	}

	public void setMonstrosDestruidosFase(int monstrosDestruidosFase) {
		this.monstrosDestruidosFase = monstrosDestruidosFase;
	}
	
	public int getMonstrosDestruidosTotal() {
		return monstrosDestruidosTotal;
	}

	public void setMonstrosDestruidosTotal(int monstrosDestruidosTotal) {
		this.monstrosDestruidosTotal = monstrosDestruidosTotal;
	}

	public int getQtdTiroFogo() {
		return qtdTiroFogo;
	}

	public void setQtdTiroFogo(int qtdTiroFogo) {
		this.qtdTiroFogo = qtdTiroFogo;
	}
	
	public int getQtdEspadaAzul() {
		return qtdEspadaAzul;
	}

	public void setQtdEspadaAzul(int qtdEspadaAzul) {
		this.qtdEspadaAzul = qtdEspadaAzul;
	}
	
	public int getQtdEspadaVermelha() {
		return qtdEspadaVermelha;
	}

	public void setQtdEspadaVermelha(int qtdEspadaVermelha) {
		this.qtdEspadaVermelha = qtdEspadaVermelha;
	}
	
	//Método para pegar o tamanho da dimensão do personagem
	public Rectangle getBounds() {
		return new Rectangle(posMegamanX, posMegamanY, larguraMegaman, alturaMegaman);
	}

	public void preencheSpritsMegaman() {
		barraVidaPreenche();
		iniciandoFasePreenche();
		finalizandoFasePreenche();
		paradoPreenche();
		andarPreenche();
		puloPreenche();
		dashPreenche();
		atirarFogoPreenche();
		tiroFogoPreenche();
		ataqueEspadaPreenche();
		espadaPreenche();
		morrendoPreenche();
	}
	
	public void barraVidaPreenche() {
		ImageIcon img;
		
		img =  new ImageIcon(getClass().getResource("./Megaman/RostoMegaman.png"));
		img.setImage((img).getImage().getScaledInstance(40, 50, 100));
		rostoMegaman = new JLabel(img);
		rostoMegaman.setBounds(20, 0, 50, 80);

		
		for (int i = 0; i < barraVida.length; i++) {
			img =  new ImageIcon(getClass().getResource("./Megaman/Vida/Barra_Vida_" + i +".png"));
			img.setImage((img).getImage().getScaledInstance(150, 10, 100));
			barraVida[i] = new JLabel(img);
			barraVida[i].setBounds(70, 30, 150, 10);
		}
		//A barra de vida começa completa
		barraVidaMegaman = new JLabel();
		barraVidaMegaman.setIcon(barraVida[vida].getIcon());
		barraVidaMegaman.setBounds(70, 30, 150, 10);
	}
	
	public void iniciandoFasePreenche() {
		ImageIcon img;

		for (int i = 0; i < megamanIniciandoFase.length; i++) {
			img = new ImageIcon(
					getClass().getResource("./Megaman/IniciandoFase/MegamanIniciandoFase_" + (i + 1) + ".png"));
			img.setImage((img).getImage().getScaledInstance(larguraMegaman, alturaMegaman, hintsMegaman));
			megamanIniciandoFase[i] = new JLabel(img);
		}
	}
	
	public void finalizandoFasePreenche() {
		ImageIcon img;

		for (int i = 0; i < megamanFinalizandoFase.length; i++) {
			img = new ImageIcon(
					getClass().getResource("./Megaman/FinalizandoFase/MegamanFinalizandoFase_" + (i + 1) + ".png"));
			img.setImage((img).getImage().getScaledInstance(larguraMegaman, alturaMegaman, hintsMegaman));
			megamanFinalizandoFase[i] = new JLabel(img);
		}
	}

	public void paradoPreenche() {
		ImageIcon img;

		for (int i = 0; i < megamanParado.length; i++) {
			img = new ImageIcon(getClass().getResource("./Megaman/Parado/MegamanParado_" + (i + 1) + ".png"));
			img.setImage((img).getImage().getScaledInstance(larguraMegaman, alturaMegaman, hintsMegaman));
			megamanParado[i] = new JLabel(img);
		}
	}

	public void andarPreenche() {
		ImageIcon img;

		for (int i = 0; i < megamanAndaDir.length; i++) {
			img = new ImageIcon(getClass().getResource("./Megaman/MovimentoDir/MegamanMovimento_" + (i + 1) + ".png"));
			img.setImage((img).getImage().getScaledInstance(larguraMegaman, alturaMegaman, hintsMegaman));
			megamanAndaDir[i] = new JLabel(img);
		}
		
		for (int i = 0; i < megamanAndaEsq.length; i++) {
			img = new ImageIcon(getClass().getResource("./Megaman/MovimentoEsq/MegamanMovimento_" + (i + 1) + ".png"));
			img.setImage((img).getImage().getScaledInstance(larguraMegaman, alturaMegaman, hintsMegaman));
			megamanAndaEsq[i] = new JLabel(img);
		}
	}

	public void puloPreenche() {
		ImageIcon img;

		for (int i = 0; i < megamanPuloDir.length; i++) {
			img = new ImageIcon(getClass().getResource("./Megaman/PulandoDir/MegamanPulando_" + (i + 1) + ".png"));
			img.setImage((img).getImage().getScaledInstance(larguraMegaman, alturaMegaman, hintsMegaman));
			megamanPuloDir[i] = new JLabel(img);
		}
		
		for (int i = 0; i < megamanPuloEsq.length; i++) {
			img = new ImageIcon(getClass().getResource("./Megaman/PulandoEsq/MegamanPulando_" + (i + 1) + ".png"));
			img.setImage((img).getImage().getScaledInstance(larguraMegaman, alturaMegaman, hintsMegaman));
			megamanPuloEsq[i] = new JLabel(img);
		}
	}

	public void dashPreenche() {
		ImageIcon img;

		for (int i = 0; i < megamanDashDir.length; i++) {
			img = new ImageIcon(getClass().getResource("./Megaman/DashDir/MegamanDash_" + (i + 1) + ".png"));
			img.setImage((img).getImage().getScaledInstance(larguraMegaman, alturaMegaman, hintsMegaman));
			megamanDashDir[i] = new JLabel(img);
		}
		
		for (int i = 0; i < megamanDashEsq.length; i++) {
			img = new ImageIcon(getClass().getResource("./Megaman/DashEsq/MegamanDash_" + (i + 1) + ".png"));
			img.setImage((img).getImage().getScaledInstance(larguraMegaman, alturaMegaman, hintsMegaman));
			megamanDashEsq[i] = new JLabel(img);
		}
	}
	
	public void atirarFogoPreenche() {
		ImageIcon img;

		for (int i = 0; i < megamanAtirandoDir.length; i++) {
			img = new ImageIcon(getClass().getResource("./Megaman/AtirandoDir/MegamanAtirando_" + (i + 1) + ".png"));
			img.setImage((img).getImage().getScaledInstance(larguraMegaman, alturaMegaman, hintsMegaman));
			megamanAtirandoDir[i] = new JLabel(img);
		}
		
		for (int i = 0; i < megamanAtirandoEsq.length; i++) {
			img = new ImageIcon(getClass().getResource("./Megaman/AtirandoEsq/MegamanAtirando_" + (i + 1) + ".png"));
			img.setImage((img).getImage().getScaledInstance(larguraMegaman, alturaMegaman, hintsMegaman));
			megamanAtirandoEsq[i] = new JLabel(img);
		}
	}
	
	//Adicionando os tiros de fogo em uma ArrayList de JLabel.
	public void tiroFogoPreenche() {
		tiroFogoDir = new ArrayList<JLabel>();
		tiroFogoEsq = new ArrayList<JLabel>();
		ImageIcon img;
		JLabel tiro;

		for (int i = 0; i < qtdTiroFogo; i++) {
			img = new ImageIcon(getClass().getResource("./Megaman/AtirandoDir/MegamanAtirando_3.png"));
			img.setImage((img).getImage().getScaledInstance(40, 40, hintsMegaman));
			tiro = new JLabel(img);
			tiro.setBounds(posMegamanX, posMegamanY, 40, 40);
			tiro.setBounds(40, 40, 40, 40);		//Rectangle
			tiro.setVisible(false);
			tiroFogoDir.add(tiro);
		}
		
		for (int i = 0; i < qtdTiroFogo; i++) {
			img = new ImageIcon(getClass().getResource("./Megaman/AtirandoEsq/MegamanAtirando_3.png"));
			img.setImage((img).getImage().getScaledInstance(40, 40, hintsMegaman));
			tiro = new JLabel(img);
			tiro.setBounds(posMegamanX, posMegamanY, 40, 40);
			tiro.setBounds(40, 40, 40, 40);		//Rectangle
			tiro.setVisible(false);
			tiroFogoEsq.add(tiro);
		}
	}
	
	//Movimento do Megaman jogando a espada
	public void ataqueEspadaPreenche() {
		ImageIcon img;

		for (int i = 0; i < ataqueEspadaDir.length; i++) {
			img = new ImageIcon(getClass().getResource("./Megaman/AtaqueEspadaDir/AtaqueEspadaAzulDir/AtaqueEspadaDir_" + (i + 1) + ".png"));
			img.setImage((img).getImage().getScaledInstance(larguraMegaman, alturaMegaman, hintsMegaman));
			ataqueEspadaDir[i] = new JLabel(img);
		}
		
		for (int i = 0; i < ataqueEspadaEsq.length; i++) {
			img = new ImageIcon(getClass().getResource("./Megaman/AtaqueEspadaEsq/AtaqueEspadaAzulEsq/AtaqueEspadaEsq_" + (i + 1) + ".png"));
			img.setImage((img).getImage().getScaledInstance(larguraMegaman, alturaMegaman, hintsMegaman));
			ataqueEspadaEsq[i] = new JLabel(img);
		}
	}
	
	//Adicionando as espadas em uma ArrayList de JLabel.
	public void espadaPreenche() {
		listaEspadaAzulDir = new ArrayList<JLabel>();
		listaEspadaAzulEsq = new ArrayList<JLabel>();
		listaEspadaVermelhaDir = new ArrayList<JLabel>();
		listaEspadaVermelhaEsq = new ArrayList<JLabel>();
		ImageIcon img;
		JLabel espada;

		for (int i = 0; i < qtdEspadaAzul; i++) {
			img = new ImageIcon(getClass().getResource("./Megaman/AtaqueEspadaDir/AtaqueEspadaAzulDir/EspadaDir_2.png"));
			img.setImage((img).getImage().getScaledInstance(40, 40, hintsMegaman));
			espada = new JLabel(img);
			espada.setBounds(posMegamanX, posMegamanY, 40, 40);
			espada.setBounds(40, 40, 40, 40);		//Rectangle
			espada.setVisible(false);
			listaEspadaAzulDir.add(espada);
		}
		
		for (int i = 0; i < qtdEspadaAzul; i++) {
			img = new ImageIcon(getClass().getResource("./Megaman/AtaqueEspadaEsq/AtaqueEspadaAzulEsq/EspadaEsq_2.png"));
			img.setImage((img).getImage().getScaledInstance(40, 40, hintsMegaman));
			espada = new JLabel(img);
			espada.setBounds(posMegamanX, posMegamanY, 40, 40);
			espada.setBounds(40, 40, 40, 40);		//Rectangle
			espada.setVisible(false);
			listaEspadaAzulEsq.add(espada);
		}
		
		for (int i = 0; i < qtdEspadaVermelha; i++) {
			img = new ImageIcon(getClass().getResource("./Megaman/AtaqueEspadaDir/AtaqueEspadaVermelhaDir/EspadaDir_2.png"));
			img.setImage((img).getImage().getScaledInstance(40, 40, hintsMegaman));
			espada = new JLabel(img);
			espada.setBounds(posMegamanX, posMegamanY, 40, 40);
			espada.setBounds(40, 40, 40, 40);		//Rectangle
			espada.setVisible(false);
			listaEspadaVermelhaDir.add(espada);
		}
		
		for (int i = 0; i < qtdEspadaVermelha; i++) {
			img = new ImageIcon(getClass().getResource("./Megaman/AtaqueEspadaEsq/AtaqueEspadaVermelhaEsq/EspadaEsq_2.png"));
			img.setImage((img).getImage().getScaledInstance(40, 40, hintsMegaman));
			espada = new JLabel(img);
			espada.setBounds(posMegamanX, posMegamanY, 40, 40);
			espada.setBounds(40, 40, 40, 40);		//Rectangle
			espada.setVisible(false);
			listaEspadaVermelhaEsq.add(espada);
		}
	}

	public void morrendoPreenche() {
		ImageIcon img;

		for (int i = 0; i < megamanMorrendo.length; i++) {
			img = new ImageIcon(getClass().getResource("./Megaman/Morrendo/MegamanMorrendo_" + (i + 1) + ".png"));
			img.setImage((img).getImage().getScaledInstance(larguraMegaman, alturaMegaman, hintsMegaman));
			megamanMorrendo[i] = new JLabel(img);
		}
	}
	
	public JLabel getScore() {
		score = new JLabel("Score: " + monstrosDestruidosFase);
		score.setForeground(Color.WHITE);
		score.setFont(new Font("Arial", Font.PLAIN, 25));
		score.setBounds(900, 20, 200, 100);
		return score;
	}
	
	public void setScore(int monstrosDestruidosFase) {
		score.setText("Score: " + monstrosDestruidosFase);
	}

	public class IniciandoFase extends Thread {

		@Override
		public void run() {

			for (int i = 0; i < megamanIniciandoFase.length; i++) {
				megaman.setIcon(megamanIniciandoFase[i].getIcon());

				try {
					megaman.setBounds(posMegamanX, posMegamanY, 100, 100);
					sleep(80);
				} catch (Exception e) {
				}
			}
			megaman.setIcon(megamanPuloDir[0].getIcon());
			interrupt();
		}
	}
	
	public class FinalizandoFase extends Thread {

		@Override
		public void run() {

			for (int i = 0; i < megamanFinalizandoFase.length; i++) {
				megaman.setIcon(megamanFinalizandoFase[i].getIcon());

				try {
					megaman.setBounds(posMegamanX, posMegamanY, 100, 100);
					sleep(160);
				} catch (Exception e) {
				}
			}
			megaman.setVisible(false);
			interrupt();
		}
	}

	public class MovimentoDireita extends Thread {

		@Override
		public void run() {

			for (int i = 0; i < megamanAndaDir.length; i++) {
				megaman.setIcon(megamanAndaDir[i].getIcon());
				posMegamanX += 1;
				
				if (posMegamanX > Frame.larguraPanel-90) {	//Não pode passar do limite direito da tela
					posMegamanX = Frame.larguraPanel-90;
					megaman.setBounds(posMegamanX, posMegamanY, 100, 100);
					break;
				}
				else {
					megaman.setBounds(posMegamanX, posMegamanY, 100, 100);
				}
				
				try {
					sleep(150);
				} catch (Exception e) {
				}
			}
			interrupt();
		}
	}
	
	public class MovimentoEsquerda extends Thread {

		@Override
		public void run() {

			for (int i = 0; i < megamanAndaEsq.length; i++) {
				megaman.setIcon(megamanAndaEsq[i].getIcon());
				posMegamanX -= 1;
				
				if (posMegamanX < 0) {	//Não pode passar do limite esquerdo da tela
					posMegamanX = 0;
					megaman.setBounds(posMegamanX, posMegamanY, 100, 100);
					break;
				}
				else {
					megaman.setBounds(posMegamanX, posMegamanY, 100, 100);
				}
				
				try {
					sleep(150);
				} catch (Exception e) {
				}
			}
			interrupt();
		}
	}

	public class PuloDir extends Thread {
		
		@Override
		public void run() {
			
			for (int i = 0; i < megamanPuloDir.length; i++) {
				getMegaman().setIcon(megamanPuloDir[i].getIcon());

				try {
					if (i < 3) {
						posMegamanY -= 20;
					} else {
						posMegamanY += 20;
					}

					megaman.setBounds(posMegamanX, posMegamanY, 100, 100);
					sleep(150);
				} catch (Exception e) {
				}
			}
			megaman.setIcon(megamanPuloDir[0].getIcon());
			interrupt();
		}
	}
	
	public class PuloEsq extends Thread {
		
		@Override
		public void run() {
			
			for (int i = 0; i < megamanPuloEsq.length; i++) {
				getMegaman().setIcon(megamanPuloEsq[i].getIcon());

				try {
					if (i < 3) {
						posMegamanY -= 20;
					} else {
						posMegamanY += 20;
					}

					megaman.setBounds(posMegamanX, posMegamanY, 100, 100);
					sleep(150);
				} catch (Exception e) {
				}
			}
			megaman.setIcon(megamanPuloEsq[0].getIcon());
			interrupt();
		}
	}
	
	public class Parado extends Thread {
		
		@Override
		public void run() {
			
			while (true) {
				for (int i = 0; i < megamanParado.length; i++) {
					megaman.setIcon(megamanParado[i].getIcon());
					try {
						megaman.setBounds(posMegamanX, posMegamanY, 100, 100);
						sleep(500);
					} catch (Exception e) {
					}
				}
				megaman.setIcon(megamanPuloDir[0].getIcon());
				interrupt();
			}
		}
	}

	//Dash com direção para a direita
	public class DashDir extends Thread {

		@Override
		public void run() {

			for (int i = 0; i < megamanDashDir.length; i++) {
				megaman.setIcon(megamanDashDir[i].getIcon());
				
				if ((posMegamanX + 30) > (Frame.larguraPanel-90)) {
					posMegamanX = Frame.larguraPanel-90;
				}
				else {
					posMegamanX += 30;
				}
				
				try {
					megaman.setBounds(posMegamanX, posMegamanY, 100, 100);
					sleep(200);
				} catch (Exception e) {
				}
				//Não pode passar do limite direito da tela
				if (posMegamanX  > Frame.larguraPanel-90) {	
					megaman.setBounds(Frame.larguraPanel-90, posMegamanY, 100, 100);
					break;
				}
			}
			megaman.setIcon(megamanPuloDir[0].getIcon());
			interrupt();
		}
	}
	
	//Dash com direção para a esquerda
	public class DashEsq extends Thread {

		@Override
		public void run() {

			for (int i = 0; i < megamanDashEsq.length; i++) {
				megaman.setIcon(megamanDashEsq[i].getIcon());
				
				if ((posMegamanX - 30) < -10) {
					posMegamanX = -10;
				}
				else {
					posMegamanX -= 30;
				}
				
				try {
					megaman.setBounds(posMegamanX, posMegamanY, 100, 100);
					sleep(200);
				} catch (Exception e) {
				}
				//Não pode passar do limite direito da tela
				if (posMegamanX  < -10) {	
					megaman.setBounds(0, posMegamanY, 100, 100);
					break;
				}
			}
			megaman.setIcon(megamanPuloEsq[0].getIcon());
			interrupt();
		}
	}
	
/*O tiro sai como uma label aleatória para ser disparada, isso evita que uma msmo label 
seja disparada ao mesmo tempo, o que ocasiona conflito de posições na thread*/
	//O tiro é direcionado para a direita
	public class AtirarFogoDir implements Runnable{
		int pos=0; 
		 
		public AtirarFogoDir(int pos) {
			this.pos = pos;
		}
		
		@Override
		public void run() {
			int x = getPosMegamanX()+15;	//O tiro é lançado na direção da arma do Megaman
			int y = getPosMegamanY()+25;
			
			tiroFogoDir.get(pos).setVisible(true);
			megaman.setIcon(getMegamanAtirandoDir()[0].getIcon());
			
			while (x < Frame.larguraPanel) {
				x+=10;
				tiroFogoDir.get(pos).setBounds(x, y, tiroFogoDir.get(pos).getWidth(), tiroFogoDir.get(pos).getHeight());
	
				try {
					sleep(30);
				} catch (Exception e) {
				}
			}
			tiroFogoDir.get(pos).setVisible(false);
			interrupt();
		}
	}

	//O tiro é direcionado para a esquerda
	public class AtirarFogoEsq implements Runnable {
		int pos=0; 
		 
		public AtirarFogoEsq(int pos) {
			this.pos = pos;
		}

		@Override
		public void run() {
			
			int x = getPosMegamanX()-15;	//O tiro é lançado na direção da arma do Megaman
			int y = getPosMegamanY()+25;
			int pos = (int)(Math.random() * qtdTiroFogo);
			
			tiroFogoEsq.get(pos).setVisible(true);
			megaman.setIcon(getMegamanAtirandoEsq()[0].getIcon());
			
			while (x > -10) {
				x-=10;
				tiroFogoEsq.get(pos).setBounds(x, y, tiroFogoEsq.get(pos).getWidth(), tiroFogoEsq.get(pos).getHeight());
				
				try {
					sleep(30);
				} catch (Exception e) {
				}
			}
			tiroFogoEsq.get(pos).setVisible(false);
			interrupt();
		}
	}
	
/*A espada sai como uma label aleatória para ser disparada, isso evita que uma msmo label 
seja disparada ao mesmo tempo, o que ocasiona conflito de posições na thread*/
	//A espada é direcionada para a direita
	public class EspadaAzulDir implements Runnable{
		int pos=0; 
		 
		public EspadaAzulDir(int pos) {
			this.pos = pos;
		}
		
		@Override
		public void run() {
			int x = getPosMegamanX()+15;
			int y = getPosMegamanY()+25;
			
			listaEspadaAzulDir.get(pos).setVisible(true);
			megaman.setIcon(getMegamanAtirandoDir()[0].getIcon());
			
			while (x < Frame.larguraPanel) {
				x+=10;
				listaEspadaAzulDir.get(pos).setBounds(x, y, listaEspadaAzulDir.get(pos).getWidth(), listaEspadaAzulDir.get(pos).getHeight());
	
				try {
					sleep(25);
				} catch (Exception e) {
				}
			}
			listaEspadaAzulDir.get(pos).setVisible(false);
			interrupt();
		}
	}
	
	//A espada é direcionada para a esquerda
	public class EspadaAzulEsq implements Runnable {
		int pos=0; 
		 
		public EspadaAzulEsq(int pos) {
			this.pos = pos;
		}

		@Override
		public void run() {
			
			int x = getPosMegamanX()-15;
			int y = getPosMegamanY()+25;
			int pos = (int)(Math.random() * qtdEspadaAzul);
			
			listaEspadaAzulEsq.get(pos).setVisible(true);
			megaman.setIcon(getMegamanAtirandoEsq()[0].getIcon());
			
			while (x > -10) {
				x-=10;
				listaEspadaAzulEsq.get(pos).setBounds(x, y, listaEspadaAzulEsq.get(pos).getWidth(), listaEspadaAzulEsq.get(pos).getHeight());
				
				try {
					sleep(25);
				} catch (Exception e) {
				}
			}
			listaEspadaAzulEsq.get(pos).setVisible(false);
			interrupt();
		}
	}

	public class Morrendo extends Thread {

		@Override
		public void run() {

			for (int i = 0; i < megamanMorrendo.length; i++) {
				megaman.setIcon(megamanMorrendo[i].getIcon());
				try {
					megaman.setBounds(posMegamanX, posMegamanY, 100, 100);
					Thread.sleep(150);
				} catch (Exception e) {
				}
			}
			if (vida > 0) {
				megaman.setIcon(megamanAndaDir[7].getIcon());
			}
			interrupt();
		}
	}
}
