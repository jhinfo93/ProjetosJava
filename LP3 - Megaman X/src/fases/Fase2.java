package fases;

import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controlador.ControladorMegaman;
import controlador.ControladorMenuPrincipal;
import controlador.ControladorRobo;
import menu.Frame;
import menu.Som;
import personagens.Megaman;
import personagens.Morcego;
import personagens.PassaroRobo;
import personagens.Robo;
import visao.VisaoMenuPrincipal;

public class Fase2 extends JPanel {

	private Megaman megaman;
	private ControladorMegaman controladorMegaman;
	private VisaoMenuPrincipal visaoMenuPrincipal;
	private TecladoFase tecladoFase;
	private Som somCenario;
	private JLabel imagemCenario;
	private int largura = 1100;
	private int altura = 600;
	private int hints = 100;
	private Icone icone;

	private Robo robo;
	private ControladorRobo controladorRobo;

	private List<Morcego> morcegos;
	private int qtdMorcegos = 30;
	private List<PassaroRobo> passaros;
	private int qtdPassaros = 20;
	private int totalMonstrosFase2 = qtdMorcegos + qtdPassaros;

	private ColisaoTiro colisaoTiro;

	public Fase2(VisaoMenuPrincipal visaoMenuPrincipal, Megaman megaman, ControladorMegaman controladorMegaman) {
		this.visaoMenuPrincipal = visaoMenuPrincipal;
		this.megaman = megaman;
		this.controladorMegaman = controladorMegaman;

		somCenario = new Som(Som.narutoShippuden); // Muda a música da fase
		icone = new Icone(megaman);
		robo = new Robo(megaman);
		controladorRobo = new ControladorRobo(robo);
		tecladoFase = new TecladoFase();
		Frame.frame.addKeyListener(tecladoFase);
		ControladorMenuPrincipal.totalMonstrosFase = totalMonstrosFase2;

		setLayout(null);
		inicializarCenario();
		inicializarMegaman();
		inicializarMorcego();
		inicializarPassaroRobo();
		inicializarTirosFogoMengaman();
		inicializarEspadasMengaman();
		inicializarAtaque1Robo();
		inicializarAtaqueFuracaoPequenoRobo();
		
		add(robo.getRobo());
		add(icone.getVida());
		add(icone.getVidaLvl2());
		add(icone.getVidaMaxima());

		// IconePoder
		add(imagemCenario);
		somCenario.start();
		somCenario.continuousSound();
		megaman.new IniciandoFase().start();

		colisaoTiro = new ColisaoTiro();
		colisaoTiro.start();
	}

	//Teclado para movimentos do megaman
	public class TecladoFase extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			controladorMegaman.keyPressed(e);
		}

		public void keyReleased(KeyEvent e) {
			controladorMegaman.keyReleased(e);
		}
	}

	//Thread que trabalha com as coliões dos tiros com os inimigos
	public class ColisaoTiro extends Thread {
		@Override
		public void run() {
			Rectangle formaTiroDir;
			Rectangle formaTiroEsq;
			Rectangle formaMorcego;
			Rectangle formaPassaro;
			boolean inicializaBoss = false;

			while (Megaman.vida > 0) {

				// Se um tiro for visível, compara ele com caga morcego que ainda está vivo
				if (ControladorMenuPrincipal.totalMonstrosFase > 0) {
					// Se um tiro for visível, compara ele com cada inimigo que ainda está vivo
					for (int i = 0; i < megaman.getQtdTiroFogo(); i++) {
						if (megaman.getTiroFogoDir().get(i).isVisible()
								|| megaman.getTiroFogoEsq().get(i).isVisible()) {

							formaTiroDir = megaman.getTiroFogoDir().get(i).getBounds();
							formaTiroEsq = megaman.getTiroFogoEsq().get(i).getBounds();

							// A quantidade vai diminuindo a cada morcego que é morto
							for (int j = 0; j < morcegos.size(); j++) {
								Morcego morcegoColisao = morcegos.get(j);
								formaMorcego = morcegoColisao.getBounds();

								// Interseção dos tiros que vão para a direita e para a esquerda
								if ((formaTiroDir.intersects(formaMorcego) || formaTiroEsq.intersects(formaMorcego))
										&& morcegoColisao.getVivo() && (megaman.getTiroFogoDir().get(i).isVisible()
												|| megaman.getTiroFogoEsq().get(i).isVisible())) {

									morcegos.get(j).new Explosao().start();
									morcegoColisao.setVivo(false);
									// Um tiro não pode matar mais de um monstro
									megaman.getTiroFogoDir().get(i).setVisible(false);
									megaman.getTiroFogoEsq().get(i).setVisible(false);
									megaman.setMonstrosDestruidosFase(megaman.getMonstrosDestruidosFase() + 1);
									megaman.setMonstrosDestruidosTotal(megaman.getMonstrosDestruidosTotal() + 1);
									megaman.setScore(megaman.getMonstrosDestruidosFase());

									if (morcegoColisao.isIconeEspecial()) {
										icone.setInimigoPosX(morcegos.get(j).getPosMorcegoX());
										icone.setInimigoPosY(morcegos.get(j).getPosMorcegoY());
										icone.new IconeVidaMaxima().start();
									}
									removerMorcego(j);
									break;
								}
							}

							//Verificando o tirp com os passáros
							for (int j = 0; j < passaros.size(); j++) {
								PassaroRobo passaroColisao = passaros.get(j);
								formaPassaro = passaroColisao.getBounds();

								// Interseção dos tiros que vão para a direita e para a esquerda
								if ((formaTiroDir.intersects(formaPassaro) || formaTiroEsq.intersects(formaPassaro))
										&& passaroColisao.isVivo() && (megaman.getTiroFogoDir().get(i).isVisible()
												|| megaman.getTiroFogoEsq().get(i).isVisible())) {

									morcegos.get(j).new Explosao().start();
									passaroColisao.setVivo(false);
									// Um tiro não pode matar mais de um monstro
									megaman.getTiroFogoDir().get(i).setVisible(false);
									megaman.getTiroFogoEsq().get(i).setVisible(false);
									megaman.setMonstrosDestruidosFase(megaman.getMonstrosDestruidosFase() + 1);
									megaman.setMonstrosDestruidosTotal(megaman.getMonstrosDestruidosTotal() + 1);
									megaman.setScore(megaman.getMonstrosDestruidosFase());

									removerPassaro(j);
									break;
								}
							}
						}
					}
				} 
				else if(!inicializaBoss ){		// O Boss é inicializado quando todas os inimigos passarem pelo cenário
					inicializaBoss  = true;
					robo.start();
					robo.getRobo().setVisible(true);
					controladorRobo.start();
				}
				else if(Robo.vida == 0){		//Quando o boss é derrotado, encerra o loop
					break;
				}
				System.out.println();
			}
			robo.interrupt();
			controladorRobo.interrupt();
			
			if (megaman.vida > 0) {
				faseConcluida();
			}
			else {
				morreMegaman();
			}
			interrupt();
		}
	}

	public void inicializarCenario() {
		ImageIcon imgCenario = new ImageIcon(getClass().getResource("./Cenario/The Last Blade II.gif"));
		imgCenario.setImage((imgCenario).getImage().getScaledInstance(largura, altura, hints));
		imagemCenario = new JLabel();
		imagemCenario.setIcon(imgCenario);
		imagemCenario.setBounds(0, 0, largura, altura);
	}

	public void inicializarMegaman() {
		megaman.getMegaman().setVisible(true);
		Megaman.vida = 5;
		megaman.getBarraVidaMegaman().setIcon(megaman.getBarraVida()[Megaman.vida].getIcon());
		add(megaman.getMegaman());
		add(megaman.getScore());
		add(megaman.getRostoMegaman());
		add(megaman.getBarraVidaMegaman());
	}

	// Adicionando os morcegos na fase
	public void inicializarMorcego() {
		morcegos = new ArrayList<Morcego>();

		for (int i = 0; i < qtdMorcegos; i++) { // Inicializando cada morcego no ArrayList
			morcegos.add(new Morcego(megaman));
		}

		// Adicionando os morcegos de vários tipos na panel
		for (int i = 0; i < 10; i++) {
			add(morcegos.get(i).getMorcegoLaranja());
			morcegos.get(i).getMorcegoLaranja().setVisible(true);
		}
		for (int i = 10; i < 20; i++) {
			add(morcegos.get(i).getMorcegoVermelho());
			morcegos.get(i).getMorcegoVermelho().setVisible(true);
		}
		for (int i = 20; i < 30; i++) {
			add(morcegos.get(i).getMorcegoPreto());
			morcegos.get(i).getMorcegoPreto().setVisible(true);
		}
	}

	// Removendo o morcego que foi destruído da lista de morcegos e da panel
	public void removerMorcego(int pos) {
		morcegos.get(pos).setVivo(false);
		morcegos.get(pos).interrupt();
		remove(morcegos.get(pos).getMorcegoLaranja());
		remove(morcegos.get(pos).getMorcegoVermelho());
		remove(morcegos.get(pos).getMorcegoPreto());
		morcegos.remove(pos);
	}

	// Encerrando a thread de todos os morcegos da fase
	public void encerrarThreadMorcegos() {
		for (Morcego morcego : morcegos) {
			morcego.setVivo(false);
			morcego.interrupt();
			remove(morcego.getMorcegoLaranja()); // Removendo todos os morcegos da panel
			remove(morcego.getMorcegoVermelho());
			remove(morcego.getMorcegoPreto());
		}
		morcegos.clear();
	}

	// Adicionando os morcegos na fase
	public void inicializarPassaroRobo() {
		passaros = new ArrayList<PassaroRobo>();

		for (int i = 0; i < qtdPassaros; i++) { // Inicializando cada morcego no ArrayList
			passaros.add(new PassaroRobo(megaman));
		}

		// Adicionando os morcegos de vários tipos na panel
		for (int i = 0; i < qtdPassaros; i++) {
			add(passaros.get(i).getPassaroRobo());
			add(passaros.get(i).getOvo());
			add(passaros.get(i).getOvoLadoEsq());
			add(passaros.get(i).getOvoLadoDir());
			passaros.get(i).getPassaroRobo().setVisible(true);
		}
	}

	// Removendo o morcego que foi destruído da lista de morcegos e da panel
	public void removerPassaro(int pos) {
		passaros.get(pos).setVivo(false);
		passaros.get(pos).interrupt();
		remove(passaros.get(pos).getPassaroRobo());
		passaros.remove(pos);
	}

	public void inicializarMegamanTiroFogo() {
		for (JLabel tiro : megaman.getTiroFogoDir()) {
			add(tiro);
		}
		for (JLabel tiro : megaman.getTiroFogoEsq()) {
			add(tiro);
		}
	}

	public void inicializarTirosFogoMengaman() {
		for (int i = 0; i < megaman.getQtdTiroFogo(); i++) {
			add(megaman.getTiroFogoDir().get(i));
			add(megaman.getTiroFogoEsq().get(i));
		}
	}

	public void inicializarEspadasMengaman() {
		for (int i = 0; i < megaman.getQtdEspadaAzul(); i++) {
			add(megaman.getListaEspadaAzulDir().get(i));
			add(megaman.getListaEspadaAzulEsq().get(i));
		}
	}

	// Quando a fase é encerrada ou o megaman morre, todas as labels de tiros são
	// removidas da panel
	public void removerTiros() {
		for (int i = 0; i < qtdMorcegos; i++) {
			remove(megaman.getTiroFogoDir().get(i));
			remove(megaman.getTiroFogoEsq().get(i));
		}
	}

	//Na lista tem vários vetores. Desa forma, adiciona todas labels de todos vetores na panel
	public void inicializarAtaque1Robo() {
		for (int i = 0; i < robo.getQtdFuracaoGrande(); i++) {
			for (JLabel ataque : robo.getDisparoFuracaoGrande().get(i)) {
				add(ataque);
			}
		}
	}

	public void inicializarAtaqueFuracaoPequenoRobo() {
		for (int i = 0; i < robo.getQtdFuracaoPequeno(); i++) {
			for (JLabel ataque : robo.getDisparoFuracaoPequeno().get(i)) {
				add(ataque);
			}
		}
	}

	public void morreMegaman() {
		Frame.frame.removeKeyListener(tecladoFase);
		remove(megaman.getMegaman());
		new Som(Som.gameOver).start();
		JOptionPane.showMessageDialog(null, "GAME OVER!!");
		encerrarThreads();
		robo = null;
		controladorRobo = null;
		direcionarMenuPrincipal();
		
		megaman.setMonstrosDestruidosFase(0);
		megaman.setMonstrosDestruidosTotal(0);
	}

	public void faseConcluida() {
		encerrarThreads();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		ControladorMenuPrincipal.jogoConcluido();
	}

	public void encerrarThreads() {
		removerTiros();
		encerrarThreadMorcegos();
		
		somCenario.encerrarMusica();
		somCenario.interrupt();
		
		robo.interrupt();
		controladorRobo.interrupt();
		
		System.out.println("Som: " + somCenario.isInterrupted()); // False/ Ok
		System.out.println("Robo: " + robo.isInterrupted()); // False/ Ok
		System.out.println("Controlador Robo: " + controladorRobo.isInterrupted()); // False
	}

	public void direcionarMenuPrincipal() {
		Frame.frame.setContentPane(visaoMenuPrincipal);
		Frame.frame.repaint();
		Frame.frame.validate();
		ControladorMenuPrincipal.som.continuousSound();
	}
}
