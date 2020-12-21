package Contrller;

import java.util.Scanner;

import Model.Cadastro;

public class Main {
	
	public static Cadastro cadastro = new Cadastro();
	public static Scanner ler = new Scanner(System.in);
	public static int numeroConta;
	public static String  nome;
	public static float valor;
	public static char escolha;
	
	public static void main(String[] args) {
		
		System.out.println("Digite a Conta do banco");
		numeroConta = ler.nextInt();
		System.out.println("Digite o nome da Conta");
		nome = ler.nextLine();
		System.out.println("Deseja realizar um primeiro depósito na Conta? y/n");
		if(escolha == 'n') {
			valor = 0;
			cadastro.setValor(valor);
		}	if(escolha == 'y') {
			System.out.println("Digite o valor a ser depositado");
			valor = ler.nextFloat();
			cadastro.setValor(valor);
		}
		
		
		
		cadastro.setNome(nome);
		cadastro.setNumeroConta(numeroConta);
		cadastro.setValor(valor);
		
		Boolean rodar = true;
		while(rodar) {
			System.out.println("Nome da Conta: "+ cadastro.getNome());
			System.out.println("Número da Conta: " + cadastro.getNumeroConta());
			int op = 0;
			System.out.println("Digite 1 para ver Saldo da conta");
			System.out.println("Digite 2 para realizar um saque");
			System.out.println("Digite 3 para sair");
			switch(op) {
			case 1:
				System.out.println("Valor da Conta: "+ cadastro.getValor());
				
			case 2:
				
				

			}
		}
				
	}

}
