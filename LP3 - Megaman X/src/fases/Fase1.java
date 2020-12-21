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
import controlador.ControladorPalhaco;
import menu.Frame;
import menu.Som;
import personagens.Megaman;
import personagens.Morcego;
import personagens.Palhaco;
import visao.VisaoMenuPrincipal;
import visao.VisaoTituloFase;

public class Fase1 extends JPanel {

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

	private Palhaco palhaco;
	private ControladorPalhaco controladorPalhaco;
	private int qtdMorcegos = 40;
	private int totalMonstrosFase1 = qtdMorcegos;
	private List<Morcego> morcegos;
	private int morcegoIconeEspecial;

	private ColisaoTiro colisaoTiro;

	public Fase1(VisaoMenuPrincipal visaoMenuPrincipal, Megaman megaman, ControladorMegaman controladorMegaman) {
		this.visaoMenuPrincipal = visaoMenuPrincipal;
		this.megaman = megaman;
		this.controladorMegaman = controladorMegaman;

		somCenario = new Som(Som.narutoShippuden);
		icone = new Icone(megaman);
		palhaco = new Palhaco(megaman);
		controladorPalhaco = new ControladorPalhaco(palhaco);
		tecladoFase = new TecladoFase();
		Frame.frame.addKeyListener(tecladoFase);
		ControladorMenuPrincipal.totalMonstrosFase = totalMonstrosFase1;

		setLayout(null);
		inicializarCenario();
		inicializarMegaman();
		inicializarMorcego();
		inicializarTirosFogoMengaman();
		inicializarAtaquePalhaco();

		add(palhaco.getPalhaco());
		add(icone.getVida());
		add(icone.getVidaLvl2());
		add(icone.getVidaMaxima());

		// IconePoder
		add(imagemCenario);
//		icone.new IconeVida().start();
//		icone.new IconeVidaLvl2().start();
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
			boolean inicializaBoss  = false;		

			while (Megaman.vida > 0) {

				if (ControladorMenuPrincipal.totalMonstrosFase > 0) {
					// Se um tiro for visível, compara ele com cada morcego que ainda está vivo
					for (int i = 0; i < megaman.getQtdTiroFogo(); i++) {
						if (megaman.getTiroFogoDir().get(i).isVisible()
								|| megaman.getTiroFogoEsq().get(i).isVisible()) {

							formaTiroDir = megaman.getTiroFogoDir().get(i).getBounds();
							formaTiroEsq = megaman.getTiroFogoEsq().get(i).getBounds();

							//A quantidade vai diminuindo a cada morcego que é morto
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
						}
					}
				}
				else if(!inicializaBoss){		// O Boss é inicializado quando todas os inimigos passarem pelo cenário
					inicializaBoss  = true;
					palhaco.start();
					palhaco.getPalhaco().setVisible(true);
					controladorPalhaco.start();
				}
				else if(Palhaco.vida == 0){		//Quando o boss é derrotado, encerra o loop
					break;
				}
				System.out.println();
			}
			palhaco.interrupt();
			controladorPalhaco.interrupt();
			
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
		ImageIcon imgCenario = new ImageIcon(getClass().getResource("./Cenario/Garou - Mark of Wolves.gif"));
		imgCenario.setImage((imgCenario).getImage().getScaledInstance(largura, altura, hints));
		imagemCenario = new JLabel();
		imagemCenario.setIcon(imgCenario);
		imagemCenario.setBounds(0, 0, largura, altura);
	}
	
	public void inicializarMegaman() {
		megaman.getMegaman().setVisible(true);
		Megaman.vida = 5;
		add(megaman.getMegaman());
		add(megaman.getScore());
		add(megaman.getRostoMegaman());
		add(megaman.getBarraVidaMegaman());
	}

	// Adicionando os morcegos na fase
	public void inicializarMorcego() {
		morcegos = new ArrayList<Morcego>();
		morcegoIconeEspecial = (int) (Math.random() * qtdMorcegos);

		for (int i = 0; i < qtdMorcegos; i++) { // Inicializando cada morcego no ArrayList
			morcegos.add(new Morcego(megaman));
		}

		// Adicionando um ícone especial à um morcego aleatório na fase
		morcegos.get(morcegoIconeEspecial).setIconeEspecial(true);

		// Adicionando os morcegos de vários tipos na panel
		for (int i = 0; i < 10; i++) {
			add(morcegos.get(i).getMorcegoRoxo());
			morcegos.get(i).getMorcegoRoxo().setVisible(true);
		}
		for (int i = 10; i < 20; i++) {
			add(morcegos.get(i).getMorcegoCinza());
			morcegos.get(i).getMorcegoCinza().setVisible(true);
		}
		for (int i = 20; i < 30; i++) {
			add(morcegos.get(i).getMorcegoVerde());
			morcegos.get(i).getMorcegoVerde().setVisible(true);
		}
		for (int i = 30; i < 40; i++) {
			add(morcegos.get(i).getMorcegoPreto());
			morcegos.get(i).getMorcegoPreto().setVisible(true);
		}
	}

	// Removendo o morcego que foi destrído da lista de morcegos e da panel
	public void removerMorcego(int pos) {
		morcegos.get(pos).setVivo(false);
		morcegos.get(pos).interrupt();
		remove(morcegos.get(pos).getMorcegoRoxo());
		remove(morcegos.get(pos).getMorcegoCinza());
		remove(morcegos.get(pos).getMorcegoVerde());
		remove(morcegos.get(pos).getMorcegoPreto());
		morcegos.remove(pos);
	}

	// Encerrando a thread de todos os morcegos da fase
	public void encerrarThreadMorcegos() {
		for (Morcego morcego : morcegos) {
			morcego.setVivo(false);
			morcego.interrupt();
			remove(morcego.getMorcegoRoxo()); // Removendo todos os morcegos da panel
			remove(morcego.getMorcegoCinza());
			remove(morcego.getMorcegoVerde());
			remove(morcego.getMorcegoPreto());
		}
		morcegos.clear();
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

	// Quando a fase é encerrada ou o megaman morre, todas as labels de tiros são removidas da panel
	public void removerTiros() {
		for (int i = 0; i < qtdMorcegos; i++) {
			remove(megaman.getTiroFogoDir().get(i));
			remove(megaman.getTiroFogoEsq().get(i));
		}
	}

	// Na lista tem vários vetores. Desa forma, adiciona todas labels de todos  vetores na panel
	public void inicializarAtaquePalhaco() {
		for (int i = 0; i < palhaco.getQtdBola(); i++) {
			for (JLabel ataque : palhaco.getListaBolas().get(i)) {
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
		palhaco = null;
		controladorPalhaco = null;
		direcionarMenuPrincipal();
		
		megaman.setMonstrosDestruidosFase(0);
		megaman.setMonstrosDestruidosTotal(0);
	}

	public void faseConcluida() {
		encerrarThreads();
		direcionarProximaFase();
	}

	public void encerrarThreads() {
		removerTiros();
		encerrarThreadMorcegos();
		
		somCenario.encerrarMusica();
		somCenario.interrupt();
		
		palhaco.interrupt();
		controladorPalhaco.interrupt();
		
		System.out.println("Som: " + somCenario.isInterrupted()); // False/ Ok
		System.out.println("Palhaco: " + palhaco.isInterrupted()); // False/ Ok
		System.out.println("ControladorPalhaco: " + controladorPalhaco.isInterrupted()); // False
	}

	public void direcionarProximaFase() {
		Frame.frame.removeKeyListener(tecladoFase);
		megaman.new FinalizandoFase().start();
		
		try {
			Thread.sleep(2000);
			ControladorMenuPrincipal.som.continuousSound();
			
			VisaoTituloFase visaoTituloFase1 = new VisaoTituloFase("2");
			Frame.frame.setContentPane(visaoTituloFase1);
			Frame.frame.repaint();
			Frame.frame.validate();
			Thread.sleep(5000);				//Tempo de duração do logo antes de inicializar próxima fase
			ControladorMenuPrincipal.som.encerrarMusica();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Frame.frame.setContentPane(new Fase2(visaoMenuPrincipal, megaman, controladorMegaman));
		Frame.frame.repaint();
		Frame.frame.validate();
	}

	public void direcionarMenuPrincipal() {
		Frame.frame.setContentPane(visaoMenuPrincipal);
		Frame.frame.repaint();
		Frame.frame.validate();
		ControladorMenuPrincipal.som.continuousSound();
	}
}
