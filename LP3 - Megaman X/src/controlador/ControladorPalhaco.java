package controlador;

import personagens.Megaman;
import personagens.Palhaco;

public class ControladorPalhaco extends Thread {

	private Palhaco palhaco;
	
	public ControladorPalhaco (Palhaco palhaco) {
		this.palhaco = palhaco;
	}
	
	@Override
	public void run() {

		//O Palhaço realiza seus ataques enquanto ele e o megaman estiverem vivos
		while (Palhaco.vida > 0 && Megaman.vida > 0) {
			try {
				
			/*Verifica a vida do Megaman e do inimigo a cada ataque para evitar do inimigo continuar atacando 
			 depois do megaman já está morto*/
				if (Palhaco.vida > 0 && Megaman.vida > 0) {
					ataqueBola();
				}
				sleep(2000);
				
				if (Palhaco.vida > 0 && Megaman.vida > 0) {
					pular();
				}
				sleep(2000);
				
				if (Palhaco.vida > 0 && Megaman.vida > 0) {
					ataqueBola();
				}
				sleep(3000);
				
				if (Palhaco.vida > 0 && Megaman.vida > 0) {
					ataqueBola();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		interrupt();
	}
	
	public void andar() {
		if (palhaco.direcaoAtaque()) {
			palhaco.new AndandoEsq().start();
		}
		else {
			palhaco.new AndandoDir().start();
		}
	}
	
	public void correr() {
		if (palhaco.direcaoAtaque()) {
			palhaco.new CorrendoEsq().start();
		}
		else {
			palhaco.new CorrendoDir().start();
		}
	}
	
	public void pular() {
		if (palhaco.direcaoAtaque()) {
			palhaco.new PuloEsq().start();
		}
		else {
			palhaco.new PuloDir().start();
		}
	}
	
	public void ataqueBola() {
		if (palhaco.direcaoAtaque()) {
			palhaco.new AtaqueBolaEsq().start();
		}
		else {
			palhaco.new AtaqueBolaDir().start();
		}
	}
}
