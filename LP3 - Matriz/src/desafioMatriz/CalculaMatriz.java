package desafioMatriz;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CalculaMatriz {

	private float matriz[][];
	private float matrizInicial[][];
	private float matrizThread[][];
	private float matrizThreadInicial[][];
	private int lin; 
	private int col;
	
	public CalculaMatriz (float matriz[][], float matrizInicial[][], float matrizThread[][], float matrizThreadInicial[][], 
			int lin, int col) {
		this.matriz = matriz;
		this.matrizInicial = matrizInicial;
		this.matrizThread = matrizThread;
		this.matrizThreadInicial = matrizThreadInicial;
		this.lin = lin;
		this.col = col;
	}
	
/*As matrizes são preenchidas com valores aleatórios entre 0 e 100. As bordas são reenchidas com 1000*/
	public void preencheMatriz () {
		for (int i = 0; i < lin; i++) {
			
			for (int j = 0; j < col; j++) {
				matriz[i][j] = (int) (Math.random() * 101);
				matrizInicial[i][j] = matriz[i][j];
				matrizThread[i][j] = matriz[i][j];
				matrizThreadInicial[i][j] = matriz[i][j];
			}
			
			matriz[i][0] = 1000;
			matriz[i][lin-1] = 1000;
			matrizInicial[i][0] = 1000;
			matrizInicial[i][lin-1] = 1000;
			matrizThread[i][0] = 1000;
			matrizThread[i][lin-1] = 1000;
			matrizThreadInicial[i][0] = 1000;
			matrizThreadInicial[i][lin-1] = 1000;
		}
		
		for (int i = 0; i < col; i++) {
			matriz[0][i] = 1000;
			matriz[lin-1][i] = 1000;
			matrizInicial[0][i] = 1000;
			matrizInicial[lin-1][i] = 1000;
			matrizThread[0][i] = 1000;
			matrizThread[lin-1][i] = 1000;
			matrizThreadInicial[0][i] = 1000;
			matrizThreadInicial[lin-1][i] = 1000;
		}
	}
	
	public void calculaTempo (float matrizInicial[][], int lin, int col) {
		long inicioExecucao = System.currentTimeMillis();
		
		while (!confereMatriz()) {
			percorreMatriz(matrizInicial, lin, col);
		}
		
		long fimExecucao = System.currentTimeMillis();
		
		System.out.println(fimExecucao - inicioExecucao);
		System.out.println("Matriz sem Threads - Tempo de execução (mm:ss): " + new SimpleDateFormat("mm:ss").format(new Date (fimExecucao - inicioExecucao)));
	}
	
	//Matriz inicial sempre terá seus valores mais atualizados primeiro
	public void percorreMatriz (float matrizInicial[][], int lin, int col) {
		float valor, esq, dir,cima, baixo;
		
		for (int i = 1; i < lin-1; i++) {
			
			for (int j = 1; j < col-1; j++) {
				valor = matriz[i][j];
				esq = matriz[i][j-1];
				dir = matriz[i][j+1];
				cima = matriz[i+1][j];
				baixo = matriz[i-1][j];
				
				matrizInicial[i][j] = calculaMedia(valor, esq, dir, cima, baixo);
			}
		}
		atualizaMatriz();	//A próxima matriz se torna a atual. Atualiza os valores da primeira matriz
	}
	
	public float calculaMedia (float valor, float esq, float dir, float cima, float baixo) {
		float media = (valor + esq + dir + cima + baixo)/5;
		return media;
	}
	
	//Atualizando a matriz a cada vez que preencher ela completamente
	public void atualizaMatriz() {
		for (int i = 1; i < lin-1; i++) {
			for (int j = 1; j < col-1; j++) {
				matriz[i][j] = matrizInicial[i][j];
			}
		}
	}
	
	//Conferindo de todos os valores internos estão maiores que 500
	public boolean confereMatriz() {
		for (int i = 1; i < lin-1; i++) {
			for (int j = 1; j < col-1; j++) {
				if (matrizInicial[i][j] < 500) {
					return false;
				}
			}
		}
		return true;		//Significa que todos valores são >= 500
	}
	
}
