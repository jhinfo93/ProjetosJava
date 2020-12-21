package controlador;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.JOptionPane;

import fases.Fase1;
import menu.Frame;
import menu.Som;
import personagens.Megaman;
import visao.VisaoMenuPrincipal;
import visao.VisaoTituloFase;

public class ControladorMenuPrincipal implements MouseListener {

	private Megaman megaman;
	private ControladorMegaman controladorMegaman;
	private VisaoMenuPrincipal visaoMenuPrincipal;
	public File selecaoOpcao = new File("Sons/Seleção de opção.wav");
	public static File musicaMenuPrincipal = new File("Sons/Música do Menu Principal.wav");
	//Mudar a música
	public static File musicaJogoConcluido = new File("Sons/Música do Menu Principal.wav");
	public static Som som = new Som(musicaMenuPrincipal);
	public static Som somJogoConcluido = new Som(musicaMenuPrincipal);
	public static int totalMonstrosFase = 0;

	public ControladorMenuPrincipal(VisaoMenuPrincipal visaoMenuPrincipal) {
		this.visaoMenuPrincipal = visaoMenuPrincipal;
		
		megaman = new Megaman();
		controladorMegaman = new ControladorMegaman(megaman);
		som.start();
		som.continuousSound();
		addEventos();
	}
	
	private void addEventos() {
		getPanel().getJLabelNovoJogo().addMouseListener(this);
		getPanel().getJLabelCreditos().addMouseListener(this);
		getPanel().getJLabelSair().addMouseListener(this);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override			//Opções do menu principal
	public void mouseReleased(MouseEvent e) {
		if (e.getSource() == getPanel().getJLabelNovoJogo()) {
			direcionarProximaFase();
			inicializarMegaman();
			som.stopSound();
		}
		else if (e.getSource() == getPanel().getJLabelCreditos()) {
			String credito = "Obrigado por jogar Megaman X! O jogo foi desenovido pela equipe: ";
			credito += "Jackson, Marcus, Raul e Saullo.\n\n";
			credito += "Comandos:\n";
			credito += "Seta para esquerda e direita: Anda\nSeta para cima: Pula\nSeta para baixo: Dash\n";
			credito += "Espaço: Atira";
			
			JOptionPane.showMessageDialog(null, credito);
		}
		else if (e.getSource() == getPanel().getJLabelSair()) {
			som.interrupt();
			System.exit(0);
		}
	}
	/*Esse método é utilizado pois quando o megaman morre e volta para o Menu Principal, ele 
	 * precisa ter suas váriaveis restauradas*/
	public void inicializarMegaman() {
		megaman.setMonstrosDestruidosFase(0);
		megaman.setMonstrosDestruidosTotal(0);
		megaman.setPosMegamanX(100);
		megaman.setMonstrosDestruidosFase(0);
		megaman.setMonstrosDestruidosTotal(0);
		
		//Preechen a vida do megaman para 5 novamente
		megaman.vida = 5;
		megaman.getBarraVidaMegaman().setIcon(megaman.getBarraVida()[Megaman.vida].getIcon());
	}
	
	public void direcionarProximaFase() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Fase1 fase1 = new Fase1(visaoMenuPrincipal, megaman, controladorMegaman);
//		Fase2 fase2  = new Fase2(visaoMenuPrincipal, megaman, controladorMegaman);
//		TesteBoss testeBoss = new TesteBoss(visaoMenuPrincipal, megaman, controladorMegaman);
		Frame.frame.setContentPane(fase1);
		Frame.frame.repaint();
		Frame.frame.validate();
	}
	
	//Mostra imagem dando parabéns ao concluir o jogo
	//Tentar passar uma String em vez de número - criar um método com string na classe VisaoTituloFase
	public static void jogoConcluido() {
		VisaoTituloFase visaoTituloFase1 = new VisaoTituloFase("Jogo concluido");
		Frame.frame.setContentPane(visaoTituloFase1);
		Frame.frame.repaint();
		Frame.frame.validate();
		
		somJogoConcluido.start();
		somJogoConcluido.continuousSound();
	}

	public VisaoMenuPrincipal getPanel() {
		if (visaoMenuPrincipal == null) {
			visaoMenuPrincipal = new VisaoMenuPrincipal();
		}
		return visaoMenuPrincipal;
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == getPanel().getJLabelNovoJogo()) {
			getPanel().getJLabelNovoJogo().setForeground(new Color(255, 173, 65));
			getPanel().getJLabelIconeMegaman().setBounds(visaoMenuPrincipal.getPosX()-50, visaoMenuPrincipal.getNovoJogoY(), 50, 50);
			new Som(selecaoOpcao).start();
		}
		if (e.getSource() == getPanel().getJLabelCreditos()) {
			getPanel().getJLabelCreditos().setForeground(new Color(255, 173, 65));
			getPanel().getJLabelIconeMegaman().setBounds(visaoMenuPrincipal.getPosX()-50, visaoMenuPrincipal.getCreditosY(), 50, 50);
			new Som(selecaoOpcao).start();
		}
		if (e.getSource() == getPanel().getJLabelSair()) {
			getPanel().getJLabelSair().setForeground(new Color(255, 173, 65));
			getPanel().getJLabelIconeMegaman().setBounds(visaoMenuPrincipal.getPosX()-50, visaoMenuPrincipal.getSairY(), 50, 50);
			new Som(selecaoOpcao).start();
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == getPanel().getJLabelNovoJogo()) {
			getPanel().getJLabelNovoJogo().setForeground(Color.LIGHT_GRAY);
		}
		if (e.getSource() == getPanel().getJLabelCreditos()) {
			getPanel().getJLabelCreditos().setForeground(Color.LIGHT_GRAY);
		}
		if (e.getSource() == getPanel().getJLabelSair()) {
			getPanel().getJLabelSair().setForeground(Color.LIGHT_GRAY);
		}
	}
}
