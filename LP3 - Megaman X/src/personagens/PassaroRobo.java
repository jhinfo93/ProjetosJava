package personagens;

import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import controlador.ControladorMenuPrincipal;
import menu.Frame;

public class PassaroRobo extends Thread{

	private Megaman megaman;
	private JLabel passaroRobo = new JLabel();
	
	//Cada pássaro instanciado aparecerá em uma posição diferente de forma aleatória
	private int posPassaroX = (int) (Math.random() * 2000) + 1100;
	private int posPassaroY = (int) (Math.random() * 150) + 20;		
	private int posPassaroLargura = 40;
	private int posPassaroAltura = 40;
	private int larguraPassaro = 30;
	private int alturaPassaro = 30;
	private int hintsPassaro = 30;
	private int deslocamentoPassaro = 15;
	private boolean vivo = true;
	
	private int tPassaro = 10;
	private JLabel[] passaroMovimento = new JLabel[tPassaro];
	
	private int tPassaroExplosao = 5;
	private JLabel[] passaroExplosao = new JLabel[tPassaroExplosao];
	
	private JLabel ovo;
	private JLabel ovoLadoEsq;
	private JLabel ovoLadoDir;
	
	public PassaroRobo(Megaman megaman) {
		this.megaman = megaman;
		
		preencheSpritsPassaro();
		getPassaroRobo().setBounds(posPassaroX, posPassaroY, posPassaroLargura, posPassaroAltura);
		start();
	}

	public int getPosPassaroX() {
		return posPassaroX;
	}

	public void setPosPassaroX(int posPassaroX) {
		this.posPassaroX = posPassaroX;
	}

	public int getPosPassaroY() {
		return posPassaroY;
	}

	public void setPosPassaroY(int posPassaroY) {
		this.posPassaroY = posPassaroY;
	}
	
	public JLabel getPassaroRobo() {
		return passaroRobo;
	}
	
	public JLabel getOvo() {
		return ovo;
	}
	
	public JLabel getOvoLadoEsq() {
		return ovoLadoEsq;
	}
	
	public JLabel getOvoLadoDir() {
		return ovoLadoDir;
	}

	public int getDeslocamentoPassaro() {
		return deslocamentoPassaro;
	}
	
	public boolean isVivo() {
		return vivo;
	}

	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}
	
	public int getTPassaroExplosao() {
		return tPassaroExplosao;
	}

	public JLabel[] getPassaroxplosao() {
		return passaroExplosao;
	}
	
	//Preenchendo todos os vetores com os sprites para os movimentos
	public void preencheSpritsPassaro() {
		movimentoPreenche();
		ovoPreenche();
		explosaoPreeche();
	}
	
	public void movimentoPreenche() {
		ImageIcon img;

		for (int i = 0; i < passaroMovimento.length; i++) {
			img = new ImageIcon(getClass().getResource("./Inimigos/Passarinho/Passarinho_" + (i + 1) + ".png"));
			img.setImage((img).getImage().getScaledInstance(larguraPassaro, alturaPassaro, hintsPassaro));
			passaroMovimento[i] = new JLabel(img);
		}
	}
	
	public void ovoPreenche() {
		ImageIcon img;

		img = new ImageIcon(getClass().getResource("./Inimigos/Passarinho/Ovo_1.png"));
		img.setImage((img).getImage().getScaledInstance(30, 20, 30));
		ovo = new JLabel(img);
		
		img = new ImageIcon(getClass().getResource("./Inimigos/Passarinho/Ovo_2.png"));
		img.setImage((img).getImage().getScaledInstance(30, 20, 30));
		ovoLadoEsq = new JLabel(img);
		
		img = new ImageIcon(getClass().getResource("./Inimigos/Passarinho/Ovo_3.png"));
		img.setImage((img).getImage().getScaledInstance(30, 20, 30));
		ovoLadoDir = new JLabel(img);
		
		ovo.setVisible(false);
		ovoLadoEsq.setVisible(false);
		ovoLadoDir.setVisible(false);
	}
	
	public void explosaoPreeche() {
		ImageIcon img;

		for (int i = 0; i < passaroExplosao.length; i++) {
			img = new ImageIcon(getClass().getResource("./Explosão/Explosao_" + (i + 1) + ".png"));
			img.setImage((img).getImage().getScaledInstance(larguraPassaro, alturaPassaro, hintsPassaro));
			passaroExplosao[i] = new JLabel(img);
		}
	}
	
	//Método para pegar o tamanho da dimensão do personagem
	public Rectangle getBounds() {
		return new Rectangle(posPassaroX, posPassaroY, posPassaroLargura, posPassaroAltura);
	}
	
	@Override
	public void run() {
		boolean ataqueOvo = false;
		
		while (posPassaroX > -30) {
			//Fazendo o movimento de todos os tipos de Passaros
			for (int i = 0; i < tPassaro; i++) {
				
				if (posPassaroX < (Frame.larguraPanel + 100) && vivo) {
					new PassaroColisao().start();
					
			 //O passáro faz o seu ataque quando sua distância para o megaman é menor que 50 píxeis
					if (i == 7 && !ataqueOvo && (posPassaroX-megaman.getPosMegamanX() < 50)) {	
						ataqueOvo = true;			//Ataque feito apenas uma vez
						new AtaqueOvo().start();
					}
				}
				
				passaroRobo.setIcon(passaroMovimento[i].getIcon());
				posPassaroX -= deslocamentoPassaro;
				
				passaroRobo.setBounds(posPassaroX, posPassaroY, posPassaroLargura, posPassaroAltura);
		
				try {
					sleep(150);
				} catch (InterruptedException e) {
				}
			}
		}
		passaroRobo.setVisible(false);
		vivo = false;		//Para que não seja possível matar o pássaro depois que ele passou da tela
		ControladorMenuPrincipal.totalMonstrosFase--;
		interrupt();
	}
	
	public class PassaroColisao extends Thread {

		@Override
		public void run() {
			Rectangle formaMegaman = megaman.getBounds();
			Rectangle formaPassaro = passaroRobo.getBounds();
			
			if (formaPassaro.intersects(formaMegaman) && vivo && Megaman.vida>0) {
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
	
	public class AtaqueOvo extends Thread{
		
		@Override
		public void run() {
			int x = posPassaroX;
			int y = posPassaroY+20;
			
			ovo.setBounds(x, y, 30, 20);
			ovo.setVisible(true);
			
			Rectangle formaMegaman;
			Rectangle formaOvo;
			
			while (y < Frame.chao+50) {
				
				y+=20;
				ovo.setBounds(x, y, 30, 20);
				formaMegaman = megaman.getBounds();
				formaOvo = ovo.getBounds();
				
				try {
					sleep(100);
				}
				catch (Exception e) {
				}
				
				if (formaOvo.intersects(formaMegaman) && vivo && Megaman.vida>0) {
					megaman.new Morrendo().start();
					Megaman.vida--;
					new Explosao().start();
					vivo = false;
					//Atualizando a barra de vida do megaman de acordo com a sua quantidade de vida
					megaman.getBarraVidaMegaman().setIcon(megaman.getBarraVida()[Megaman.vida].getIcon());
					break;
				}
			}
			ovo.setVisible(false);
			ovoLadoEsq.setBounds((x-20), y, 30, 20);		//Obro quebra e se divide para os lados
			ovoLadoDir.setBounds((x+20), y, 30, 20);
			ovoLadoEsq.setVisible(true);
			ovoLadoDir.setVisible(true);
			interrupt();
		}
	}
	
	public class Explosao extends Thread{
		@Override
		public void run() {
			
			for (int i = 0; i < tPassaroExplosao; i++) {
				passaroRobo.setIcon(passaroExplosao[i].getIcon());
				
				try {
					sleep(350);
				} catch (Exception e) {
				}
			}
			passaroRobo.setVisible(false);  //Quando um pássaro morre, ele deixa de ser visível na panel
			setVivo(false);
			interrupt();
		}
	}
}
