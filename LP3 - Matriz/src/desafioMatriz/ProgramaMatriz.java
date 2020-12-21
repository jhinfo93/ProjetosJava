package desafioMatriz;

public class ProgramaMatriz {

	public static void main(String[] args) {
		
		int lin = 100;		//500 - 24s sem thread
		int col = 100;		//50 (com - 33 ex)		(sem - 116 ex)
		float [][] matriz = new float [lin][col];
		float [][] matrizInicial = new float [lin][col];
		float [][] matrizThread = new float [lin][col];
		float [][] matrizThreadInicial = new float [lin][col];
		
		CalculaMatriz calculaMatriz = new CalculaMatriz(matriz, matrizInicial, matrizThread, matrizThreadInicial, lin, col); 
		calculaMatriz.preencheMatriz();					//Preenche as 4 matrizes de forma aleatória
		
		//calculaMatriz.calculaTempo(matrizInicial, lin, col);		//Imprime a matriz
		
		Teste novo = new Teste(matrizThread, matrizThreadInicial, lin, col);
		novo.calculaTempo(matrizThread, lin, col);
		
	}
}
