package controlador;

import personagens.Megaman;
import personagens.Robo;

public class ControladorRobo extends Thread {

	private Robo robo;
	
	public ControladorRobo (Robo robo) {
		this.robo = robo;
	}
	
	@Override
	public void run() {

		//O Robô realiza seus ataques enquanto ele e o megaman estiverem vivos
		while (Robo.vida > 0 && Megaman.vida > 0) {
			try {
				if (Robo.vida > 0 && Megaman.vida > 0) {
					furacaoPequeno();
				}
				sleep(3000);
				
				if (Robo.vida > 0 && Megaman.vida > 0) {
					furacaoPequeno();
				}
				sleep(4000);
				
				if (Robo.vida > 0 && Megaman.vida > 0) {
					furacaoGrande();
				}
				sleep(5000);
				
				if (Robo.vida > 0 && Megaman.vida > 0) {
					ultimate();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		interrupt();
	}
	
	public void furacaoPequeno() {
		if (robo.direcaoAtaque()) {
			robo.new FuracaoPequenoEsquerda().start();
		}
		else {
			robo.new FuracaoPequenoDireita().start();
		}
	}
	
	public void furacaoGrande() {
		if (robo.direcaoAtaque()) {
			robo.new FuracaoGrandeEsquerda().start();
		}
		else {
			robo.new FuracaoGrandeDireita().start();
		}
	}
	
	public void ultimate() {
		if (robo.direcaoAtaque()) {
			robo.new AtaquePuloEsquerda().start();
		}
		else {
			robo.new AtaquePuloDireita().start();
		}
	}
}
