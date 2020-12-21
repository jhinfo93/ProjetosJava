/*É possível acessar essa classe passando como parâmetro um dos áudios disponíveis no jogo
 *Como os áudios estão como variáveis static, facilita o acesso e a escolha do som
 
 Fazer - a musica do cenário precisa ser um loop
 */

package menu;

import java.io.File;

import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;

public class Som extends Thread {

	private Clip clip;
	public static File narutoShippuden = new File("Sons/Next eps.wav");
	public static File pulo = new File("Sons/Pulo.wav");
	public static File tiroFogo = new File("Sons/TheLibrarybyMTC_Robo_LaserBlast.wav");
	public static File coinPontos = new File("Sons/CoinPoints.wav");
	public static File testeFogo = new File("Sons/TesteFogo.wav");
	public static File gameOver = new File("Sons/GAME OVER 3 - 277403__landlucky__game-over-sfx-and-voice.wav");
	
	public Som(File som) {
		try {
			clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(som));
		} catch (Exception e) {
		}
	}

	@Override
	public void run() {
		try {
			clip.start();
			Thread.sleep(clip.getMicrosecondLength() / 1000);
			clip.flush();		//Limpa a memória evitando o acúmulo
		} catch (Exception e) {
		}
		interrupt();
	}
	
	public void continuousSound() {
		clip.stop();		//Para a musica que já tinha sido inicada e recomeça com um loop
		clip.loop(Clip.LOOP_CONTINUOUSLY);		//Toca continuamente
	}
	
	public void stopSound() {
		clip.stop();
	}
	
	public void encerrarMusica() {
		clip.stop();
		clip.flush();
		clip = null;
	}
}