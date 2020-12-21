package personagens;

import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import controlador.ControladorMenuPrincipal;
import menu.Frame;

public class Morcego extends Thread{

	private Megaman megaman;
	private JLabel morcegoRoxo = new JLabel();
	private JLabel morcegoCinza = new JLabel();
	private JLabel morcegoLaranja = new JLabel();
	private JLabel morcegoPreto = new JLabel();
	private JLabel morcegoVerde = new JLabel();
	private JLabel morcegoVerdeClaro = new JLabel();
	private JLabel morcegoVermelho = new JLabel();
	
	//Cada morcego instanciado aparecerá em uma posição diferente de forma aleatória
	private int posMorcegoX = (int) (Math.random() * 8000) + 1100;	//Valor aleatório entre (1/8000) + 1100
	private int posMorcegoY = (int) (Math.random() * 400) + 60;		//valor aleatório entre (1/400) + 20
	private int posMorcegoLargura = 40;
	private int posMorcegoAltura = 40;
	private int posMorcegoPretoLargura = 40;
	private int posMorcegoPretoAltura = 40;
	private int larguraMorcego = 30;
	private int alturaMorcego = 30;
	private int hintsMorcego = 30;
	private int deslocamentoMorcego = 15;
	private boolean vivo = true;
	private boolean iconeEspecial = false;

	private int tMorcego = 3;
	private JLabel[] morcegoRoxoMovimento = new JLabel[tMorcego];
	private JLabel[] morcegoCinzaMovimento = new JLabel[tMorcego];
	private JLabel[] morcegoLaranjaMovimento = new JLabel[tMorcego];
	private JLabel[] morcegoPretoMovimento = new JLabel[tMorcego];
	private JLabel[] morcegoVerdeMovimento = new JLabel[tMorcego];
	private JLabel[] morcegoVerdeClaroMovimento = new JLabel[tMorcego];
	private JLabel[] morcegoVermelhoMovimento = new JLabel[tMorcego];
	private int tMorcegoExplosao = 5;
	private JLabel[] morcegoExplosao = new JLabel[tMorcegoExplosao];
	
	public Morcego(Megaman megaman) {
		this.megaman = megaman;
		
		preencheSpritsMorcego();
		getMorcegoRoxo().setBounds(posMorcegoX, posMorcegoY, posMorcegoLargura, posMorcegoAltura);
		getMorcegoCinza().setBounds(posMorcegoX, posMorcegoY, posMorcegoLargura, posMorcegoAltura);
		getMorcegoLaranja().setBounds(posMorcegoX, posMorcegoY, posMorcegoLargura, posMorcegoAltura);
		getMorcegoPreto().setBounds(posMorcegoX, posMorcegoY, posMorcegoPretoLargura, posMorcegoPretoAltura);
		getMorcegoVerde().setBounds(posMorcegoX, posMorcegoY, posMorcegoLargura, posMorcegoAltura);
		getMorcegoVerdeClaro().setBounds(posMorcegoX, posMorcegoY, posMorcegoLargura, posMorcegoAltura);
		getMorcegoVermelho().setBounds(posMorcegoX, posMorcegoY, posMorcegoLargura, posMorcegoAltura);;
		start();
	}

	public int getPosMorcegoX() {
		return posMorcegoX;
	}

	public void setPosMorcegoX(int posMorcegoX) {
		this.posMorcegoX = posMorcegoX;
	}

	public int getPosMorcegoY() {
		return posMorcegoY;
	}

	public void setPosMorcegoY(int posMorcegoY) {
		this.posMorcegoY = posMorcegoY;
	}
	
	public JLabel getMorcegoRoxo() {
		return morcegoRoxo;
	}
	
	public JLabel getMorcegoCinza() {
		return morcegoCinza;
	}

	public JLabel getMorcegoLaranja() {
		return morcegoLaranja;
	}

	public JLabel getMorcegoPreto() {
		return morcegoPreto;
	}

	public JLabel getMorcegoVerde() {
		return morcegoVerde;
	}

	public JLabel getMorcegoVerdeClaro() {
		return morcegoVerdeClaro;
	}

	public JLabel getMorcegoVermelho() {
		return morcegoVermelho;
	}

	public int getDeslocamentoMorcego() {
		return deslocamentoMorcego;
	}

	public boolean getVivo() {
		return vivo;
	}

	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}
	
	public boolean isIconeEspecial() {
		return iconeEspecial;
	}

	public void setIconeEspecial(boolean iconeEspecial) {
		this.iconeEspecial = iconeEspecial;
	}

	public int getTMorcegoExplosao() {
		return tMorcegoExplosao;
	}

	public JLabel[] getMorcegoExplosao() {
		return morcegoExplosao;
	}

	//Preenchendo todos os vetores com os sprites para os movimentos
	public void preencheSpritsMorcego() {
		movimentoPreenche();
		explosaoPreeche();
	}
	
	public void movimentoPreenche() {
		ImageIcon img;

		//Movimentos do morcego roxo
		for (int i = 0; i < morcegoRoxoMovimento.length; i++) {
			img = new ImageIcon(getClass().getResource("./Inimigos/Morcego/Movimento/MorcegoRoxo_" + (i + 1) + ".png"));
			img.setImage((img).getImage().getScaledInstance(larguraMorcego, alturaMorcego, hintsMorcego));
			morcegoRoxoMovimento[i] = new JLabel(img);
		}
		
		//Movimentos do morcego cinza
		for (int i = 0; i < morcegoCinzaMovimento.length; i++) {
			img = new ImageIcon(getClass().getResource("./Inimigos/Morcego/Movimento/MorcegoCinza_" + (i + 1) + ".png"));
			img.setImage((img).getImage().getScaledInstance(larguraMorcego, alturaMorcego, hintsMorcego));
			morcegoCinzaMovimento[i] = new JLabel(img);
		}
		
		//Movimentos do morcego laranja
		for (int i = 0; i < morcegoLaranjaMovimento.length; i++) {
			img = new ImageIcon(getClass().getResource("./Inimigos/Morcego/Movimento/MorcegoLaranja_" + (i + 1) + ".png"));
			img.setImage((img).getImage().getScaledInstance(larguraMorcego, alturaMorcego, hintsMorcego));
			morcegoLaranjaMovimento[i] = new JLabel(img);
		}
		
		//Movimentos do morcego preto
		for (int i = 0; i < morcegoPretoMovimento.length; i++) {
			img = new ImageIcon(getClass().getResource("./Inimigos/Morcego/Movimento/MorcegoPreto_" + (i + 1) + ".png"));
			img.setImage((img).getImage().getScaledInstance(posMorcegoPretoLargura, posMorcegoPretoAltura, hintsMorcego));
			morcegoPretoMovimento[i] = new JLabel(img);
		}
		
		//Movimentos do morcego verde
		for (int i = 0; i < morcegoVerdeMovimento.length; i++) {
			img = new ImageIcon(getClass().getResource("./Inimigos/Morcego/Movimento/MorcegoVerde_" + (i + 1) + ".png"));
			img.setImage((img).getImage().getScaledInstance(larguraMorcego, alturaMorcego, hintsMorcego));
			morcegoVerdeMovimento[i] = new JLabel(img);
		}
		
		//Movimentos do morcego verde claro
		for (int i = 0; i < morcegoVerdeClaroMovimento.length; i++) {
			img = new ImageIcon(getClass().getResource("./Inimigos/Morcego/Movimento/MorcegoVerdeClaro_" + (i + 1) + ".png"));
			img.setImage((img).getImage().getScaledInstance(larguraMorcego, alturaMorcego, hintsMorcego));
			morcegoVerdeClaroMovimento[i] = new JLabel(img);
		}
		
		//Movimentos do morcego verde vermelho
		for (int i = 0; i < morcegoVermelhoMovimento.length; i++) {
			img = new ImageIcon(getClass().getResource("./Inimigos/Morcego/Movimento/MorcegoVermelho_" + (i + 1) + ".png"));
			img.setImage((img).getImage().getScaledInstance(larguraMorcego, alturaMorcego, hintsMorcego));
			morcegoVermelhoMovimento[i] = new JLabel(img);
		}
	}
	
	public void explosaoPreeche() {
		ImageIcon img;

		for (int i = 0; i < morcegoExplosao.length; i++) {
			img = new ImageIcon(getClass().getResource("./Explosão/Explosao_" + (i + 1) + ".png"));
			img.setImage((img).getImage().getScaledInstance(larguraMorcego, alturaMorcego, hintsMorcego));
			morcegoExplosao[i] = new JLabel(img);
		}
	}
	
	//Método para pegar o tamanho da dimensão do personagem
	public Rectangle getBounds() {
		return new Rectangle(posMorcegoX, posMorcegoY, posMorcegoLargura, posMorcegoAltura);
	}
	
	@Override
	public void run() {
		
		while (posMorcegoX > -30) {
			int velocidade = posMorcegoX;	//Ponto de íncio do morcego na fase
			
			//Fazendo o movimento de todos os tipos de morcegos
			for (int i = 0; i < tMorcego; i++) {
				
				if (posMorcegoX < (Frame.larguraPanel + 100) && vivo) {
					new MorcegoColisao().start();
				}
				
				morcegoRoxo.setIcon(morcegoRoxoMovimento[i].getIcon());
				morcegoCinza.setIcon(morcegoCinzaMovimento[i].getIcon());
				morcegoLaranja.setIcon(morcegoLaranjaMovimento[i].getIcon());
				morcegoPreto.setIcon(morcegoPretoMovimento[i].getIcon());
				morcegoVerde.setIcon(morcegoVerdeMovimento[i].getIcon());
				morcegoVerdeClaro.setIcon(morcegoVerdeClaroMovimento[i].getIcon());
				morcegoVermelho.setIcon(morcegoVermelhoMovimento[i].getIcon());
				posMorcegoX -= deslocamentoMorcego;
				velocidade -= 40;
				
				morcegoRoxo.setBounds(posMorcegoX, posMorcegoY, posMorcegoLargura, posMorcegoAltura);
				morcegoCinza.setBounds(posMorcegoX, posMorcegoY, posMorcegoLargura, posMorcegoAltura);
				morcegoLaranja.setBounds(posMorcegoX, posMorcegoY, posMorcegoLargura, posMorcegoAltura);
				morcegoPreto.setBounds(velocidade, posMorcegoY, posMorcegoPretoLargura, posMorcegoPretoAltura);
				morcegoVerde.setBounds(posMorcegoX, posMorcegoY, posMorcegoLargura, posMorcegoAltura);
				morcegoVerdeClaro.setBounds(posMorcegoX, posMorcegoY, posMorcegoLargura, posMorcegoAltura);
				morcegoVermelho.setBounds(posMorcegoX, posMorcegoY, posMorcegoLargura, posMorcegoAltura);
		
				try {
					sleep(150);
				} catch (InterruptedException e) {
				}
			}
		}
		morcegoRoxo.setVisible(false);
		morcegoCinza.setVisible(false);
		morcegoLaranja.setVisible(false);
		morcegoPreto.setVisible(false);
		morcegoVerde.setVisible(false);
		morcegoVerdeClaro.setVisible(false);
		morcegoVermelho.setVisible(false);
		vivo = false;		//Para que não seja possível matar o morcego depois que ele passou da tela
		ControladorMenuPrincipal.totalMonstrosFase--;
		interrupt();
	}
	
	public class MorcegoColisao extends Thread {

		@Override
		public void run() {
			Rectangle formaMegaman = megaman.getBounds();
			Rectangle formaMorcego = morcegoRoxo.getBounds();
			
			if (formaMorcego.intersects(formaMegaman) && vivo && Megaman.vida>0) {
				megaman.new Morrendo().start();
				Megaman.vida--;
				new Explosao().start();
				vivo = false;
				//Atualizando a barra de vida do megaman de acordo com a sua quantidade de vida
				megaman.getBarraVidaMegaman().setIcon(megaman.getBarraVida()[Megaman.vida].getIcon());
			}
			interrupt();
		}
	}
	
	public class Explosao extends Thread{
		@Override
		public void run() {
			
			for (int i = 0; i < tMorcego; i++) {
				morcegoRoxo.setIcon(morcegoExplosao[i].getIcon());
				morcegoCinza.setIcon(morcegoExplosao[i].getIcon());
				morcegoLaranja.setIcon(morcegoExplosao[i].getIcon());
				morcegoPreto.setIcon(morcegoExplosao[i].getIcon());
				morcegoVerde.setIcon(morcegoExplosao[i].getIcon());
				morcegoVerdeClaro.setIcon(morcegoExplosao[i].getIcon());
				morcegoVermelho.setIcon(morcegoExplosao[i].getIcon());
				
				try {
					sleep(350);
				} catch (Exception e) {
				}
			}
			morcegoRoxo.setVisible(false);  //Quando um morcego morre, ele deixa de ser visível na panel
			morcegoCinza.setVisible(false);
			morcegoLaranja.setVisible(false);
			morcegoPreto.setVisible(false);
			morcegoVerde.setVisible(false);
			morcegoVerdeClaro.setVisible(false);
			morcegoVermelho.setVisible(false);
			setVivo(false);
			interrupt();
		}
	}
}
