package desafioMatriz;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TreeSet;

public class Novo {

	private float matrizThread[][];
	private float matrizThreadInicial[][];
	private int lin;
	private int col;
	private boolean terminaThread1 = true;
	private boolean terminaThread2 = true;
	private boolean terminaThread3 = true;
	private boolean terminaThread4 = true;
	private boolean encerraCalculo = false;
	private long inicioExecucao;
	private long fimExecucao;

	private Thread thread1 = new Thread1();
	private Thread thread2 = new Thread2();
	private Thread thread3 = new Thread3();
	private Thread thread4 = new Thread4();

	public Novo(float matrizThread[][], float matrizThreadInicial[][], int lin, int col) {
		this.matrizThread = matrizThread;
		this.matrizThreadInicial = matrizThreadInicial;
		this.lin = lin;
		this.col = col;
	}

	public void calculaTempo(float matrizThreadInicial[][], int lin, int col) {
		inicializaThread();
		inicioExecucao = System.currentTimeMillis();

	}

	public void inicializaThread() {
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
	}

	public class Thread1 extends Thread {
		@Override
		public void run() {
			calculaMatriz1();
			interrupt();
		}
	}

	
	public Thread getThread1() {
		if(thread1 == null) {
			thread1 = 
		}
		return thread1;
	}

	public void setThread1(Thread thread1) {
		this.thread1 = thread1;
	}

	public void calculaMatriz1() {
		float valor, esq, dir, cima, baixo;

		for (int i = 1; i < (lin / 2); i++) {

			for (int j = 1; j <= col; j++) {
				
				matrizThreadInicial[i][j] = matrizThread[i][j] + matrizThread[i][j - 1] + matrizThread[i][j + 1]
						+ matrizThread[i + 1][j] + matrizThread[i - 1][j];

				
			}
		}
		terminaThread1 = false; // Marca que terminou a rodada dess thread
		if (!terminaThread1 && !terminaThread2) {
			atualizaMatriz(); // Se todas threads terminaram a rodada de cálculo, as matrizes são atualizadas
		}
	}

	// Thread2 - Calcula a parte do meio para cima e do meio para a direita matriz
	public class Thread2 extends Thread {
		@Override
		public void run() {
			calculaMatriz2();
			interrupt();
		}
	}

	public void calculaMatriz2() {
		float valor, esq, dir, cima, baixo;

		for (int i = (lin / 2); i <= lin; i++) {

			for (int j = 1; j <= col; j++) {

				valor = matrizThread[i][j];
				esq = matrizThread[i][j - 1];
				dir = matrizThread[i][j + 1];
				cima = matrizThread[i + 1][j];
				baixo = matrizThread[i - 1][j];

				matrizThreadInicial[i][j] = calculaMedia(valor, esq, dir, cima, baixo);
			}
		}
		terminaThread2 = false;
		if (!terminaThread1 && !terminaThread2) {
			atualizaMatriz(); // Se todas threads terminaram a rodada de cálculo, as matrizes são atualizadas
		}
	}

	// Thread3 - Calcula a parte do meio para baixo e do meio para a esquerda matriz
	public class Thread3 extends Thread {
		@Override
		public void run() {
			calculaMatriz3();
			interrupt();
		}
	}

	public void calculaMatriz3() {
		float valor, esq, dir, cima, baixo;

		for (int i = (lin / 2); i < lin - 1; i++) {

			for (int j = 1; j < (col / 2); j++) {
				valor = matrizThread[i][j];
				esq = matrizThread[i][j - 1];
				dir = matrizThread[i][j + 1];
				cima = matrizThread[i + 1][j];
				baixo = matrizThread[i - 1][j];

				matrizThreadInicial[i][j] = calculaMedia(valor, esq, dir, cima, baixo);
			}
		}
		terminaThread3 = false;
		if (!terminaThread1 && !terminaThread2 && !terminaThread3 && !terminaThread4) {
			atualizaMatriz(); // Se todas threads terminaram a rodada de cálculo, as matrizes são atualizadas
		}
	}

	// Thread4 - Calcula a parte do meio para baixo e do meio para a direitas matriz
	public class Thread4 extends Thread {
		@Override
		public void run() {
			calculaMatriz4();
			interrupt();
		}
	}

	public void calculaMatriz4() {
		float valor, esq, dir, cima, baixo;

		for (int i = (lin / 2); i < lin - 1; i++) {

			for (int j = (col / 2); j < col - 1; j++) {

				valor = matrizThread[i][j];
				esq = matrizThread[i][j - 1];
				dir = matrizThread[i][j + 1];
				cima = matrizThread[i + 1][j];
				baixo = matrizThread[i - 1][j];
				matrizThreadInicial[i][j] = calculaMedia(valor, esq, dir, cima, baixo);
			}
		}
		terminaThread4 = false;
		if (!terminaThread1 && !terminaThread2 && !terminaThread3 && !terminaThread4) {
			atualizaMatriz(); // Se todas threads terminaram a rodada de cálculo, as matrizes são atualizadas
		}
	}

	public float calculaMedia(float valor, float esq, float dir, float cima, float baixo) {
		float media = (valor + esq + dir + cima + baixo) / 5;
		return media;
	}

	// Atualizando a matriz a cada vez que preencher ela completamente
	public void atualizaMatriz() {
		for (int i = 1; i < lin - 1; i++) {
			for (int j = 1; j < col - 1; j++) {
				matrizThread[i][j] = matrizThreadInicial[i][j];
			}
		}

		terminaThread1 = true;
		terminaThread2 = true;
		terminaThread3 = true;
		terminaThread4 = true;

		if (confereMatriz()) {
			fimExecucao = System.currentTimeMillis();
			encerraCalculo = true;

			System.out.println(fimExecucao - inicioExecucao);
			System.out.println("Matriz Com Threads - Tempo de execução (mm:ss): "
					+ new SimpleDateFormat("mm:ss").format(new Date(fimExecucao - inicioExecucao)));

		} else {
			new Thread1().start();
			new Thread2().start();
			new Thread3().start();
			new Thread4().start();
		}
	}

	// Conferindo de todos os valores internos estão maiores que 500
	public boolean confereMatriz() {
		for (int i = 1; i < lin - 1; i++) {
			for (int j = 1; j < col - 1; j++) {
				if (matrizThreadInicial[i][j] < 500) {
					return false;
				}
			}
		}
		return true; // Significa que todos valores são >= 500
	}

}
