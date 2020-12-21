package controlador;

import java.awt.event.KeyEvent;

import menu.Som;
import personagens.Megaman;

public class ControladorMegaman {

	private Megaman megaman;
	private int pos;

	public ControladorMegaman (Megaman megaman) {
		this.megaman = megaman;
	}
	
	public int getPos() {
		return pos;
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		int posMegamanX = megaman.getPosMegamanX();
		int posMegamanY = megaman.getPosMegamanY();
		
		megaman.getMegaman().setIcon(megaman.getMegamanAndaDir()[5].getIcon());
		
		if (key == KeyEvent.VK_UP) {		
			if (megaman.isDirecaoDireita()) {
				megaman.new PuloDir().start();
			}
			else {
				megaman.new PuloEsq().start();
			}
			new Som(Som.pulo).start();
		}
		
		else if (key == KeyEvent.VK_DOWN) {
			if (megaman.isDirecaoDireita()) {
				megaman.new DashDir().start();
			}
			else {
				megaman.new DashEsq().start();
			}
		}
		
		else if (key == KeyEvent.VK_LEFT) {	
			//Mudando a direção do Megaman para a esquerda
			megaman.setDirecaoDireita(false);
			megaman.new MovimentoEsquerda().start();
		}
		
		else if (key == KeyEvent.VK_RIGHT) {
			//Mudando a direção do Megaman para a direita
			megaman.setDirecaoDireita(true);
			megaman.new MovimentoDireita().start();
		}
		
		else if (key == KeyEvent.VK_SPACE) {
			pos = (int)(Math.random() * megaman.getQtdTiroFogo());
			
			if (megaman.isDirecaoDireita()) {
				Runnable atirarFogoDir = megaman.new AtirarFogoDir(pos);
				new Thread(atirarFogoDir).start();
			}
			else {
				Runnable atirarFogoEsq = megaman.new AtirarFogoEsq(pos);
				new Thread(atirarFogoEsq).start();
			}
			//new Som(Megaman.tiroFogo).start();
		}
		else if (key == KeyEvent.VK_W) {
			pos = (int)(Math.random() * megaman.getQtdEspadaAzul());
			
			if (megaman.isDirecaoDireita()) {
				Runnable espadaAzulDir = megaman.new EspadaAzulDir(pos);
				new Thread(espadaAzulDir).start();
			}
			else {
				Runnable espadaAzulEsq = megaman.new EspadaAzulEsq(pos);
				new Thread(espadaAzulEsq).start();
			}
		}
		megaman.getMegaman().setBounds(posMegamanX, posMegamanY, 100, 100);
	}

	public void keyReleased(KeyEvent e) {
		if (megaman.isDirecaoDireita()) {
			megaman.getMegaman().setIcon(megaman.getMegamanAndaDir()[7].getIcon());
		}
		else {
			megaman.getMegaman().setIcon(megaman.getMegamanAndaEsq()[7].getIcon());
		}
	}
}
