package menu;

import javax.swing.JFrame;

import controlador.ControladorMenuPrincipal;
import visao.VisaoMenuPrincipal;

public class Frame extends JFrame{

	public static JFrame frame = new JFrame("Megaman");
	public static int largura = 1100;
	public static int altura = 600; 
	public static int larguraPanel = 1100;
	public static int alturaPanel = 600; 
	public static int chao = 400; 		//Local em que os personagens são posicionados
	private ControladorMenuPrincipal controladorMenuPrincipal;
	private VisaoMenuPrincipal visaoMenuPrincipal;
	
	public Frame() {
		frame.setSize(largura, altura);
		frame.setVisible(true);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setResizable(false);
		visaoMenuPrincipal = new VisaoMenuPrincipal();
		controladorMenuPrincipal = new ControladorMenuPrincipal(visaoMenuPrincipal);
		
		frame.setContentPane(visaoMenuPrincipal);
		frame.repaint();
		frame.validate();
	}

	public static void main(String[] args) {
		new Frame();
	}
}
