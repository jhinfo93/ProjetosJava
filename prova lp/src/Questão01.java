import java.util.Scanner;

public class Quest�o01 {

	public static void main(String[] args) {
		
		int quantidade;
		
		Scanner ler = new Scanner(System.in);
		System.out.print("Digite a quantidade de sal�rio: ");
		quantidade = ler.nextInt();
		int salario[] = new int [quantidade];
		
		for(int i = 0 ; i < quantidade; i++) {
			System.out.print("Agora digite o sal�rio do "+ i + " Funcion�rio: ");
			salario[i] = ler.nextInt();
		}
		
		int comparar [] = new int[quantidade];
	
		for(int i = 0 ; i<quantidade;i++) {
			comparar [i] = salario[i];
		}
		
		for(int i = 0; i< quantidade; i++) {
			int cont = 0;
			for (int j = i+1 ; j<quantidade; j++) {
				if(salario[i] == comparar[j]) {
					cont++;
				}
				
			}
			if(cont>1)
				System.out.println(cont + " Cargos recebem " + salario[i]);
			else
				System.out.println(cont + "Cargo recebe " + salario[i]);
		}
	}

}
