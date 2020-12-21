package Main;

import Classes.Administrador;
import Classes.Empregado;
import Classes.Fornecedor;
import Classes.Operario;
import Classes.Pessoa;

public class Main {
	
	public static void main(String args[]) {
		String nome = "Jackson Henrique";
		String endereco = "Rua JJ de Oliveira";
		String telefone = "073 9 98597032";
		
		Pessoa p = new Pessoa("Jackson Henrique", "Rua JJ de Oliveira","073 9 98597032");
		System.out.println("Nome: " + p.getNome()+
						   "\nEndere�o: " + p.getEndere�o()+
						   "\nTelefone: "+ p.getTelefone());
		
		
		System.out.println("------------------------------");
		Fornecedor p2 = new Fornecedor("Alex", "Argos, 10, 5s", "073 9 99118673", 55.0, 22.4);
		System.out.println("Nome: " + p2.getNome()+
				   		   "\nEndere�o: " + p2.getEndere�o()+
				   		   "\nTelefone: "+ p2.getTelefone());
		System.out.println("Valor do Saldo: " + p2.obterSaldo());
		
		
		System.out.println("------------------------------");
		
		Empregado p3 = new Empregado(nome, endereco, telefone, 0001, 1500, 0.07);
		System.out.println("Nome: " + p3.getNome()+
						   "\nEndere�o: " + p3.getEndere�o()+
						   "\nTelefone: "+ p3.getTelefone()+
						   "\nSalario Bruto: "+p3.getSalarioBase()+
						   "\nImposto: "+ p3.getImposto());
		
		System.out.println("Salario real (Descontando Imposto):" + p3.calcularSalario());
		
		System.out.println("------------------------------");

		Administrador p4 = new Administrador(nome, endereco, telefone, 0001, 2500, 0.07, 138.87);
		
		System.out.println("Nome: " + p4.getNome()+
				   "\nEndere�o: " + p4.getEndere�o()+
				   "\nTelefone: "+ p4.getTelefone()+
				   "\nSalario Bruto: "+p4.getSalarioBase()+
				   "\nImposto: "+ p4.getImposto()+
				   "\nAjuda de Custo: "+ p4.getAjudaCusto());

		System.out.println("Salario real (Descontando Imposto):" + p4.salarioADM());
				
		System.out.println("------------------------------");
		
		Operario p5 = new Operario(nome, endereco, telefone, 0001, 900, 0.06, 879.66,0.02);
		
		System.out.println("Nome: " + p5.getNome()+
				   "\nEndere�o: " + p5.getEndere�o()+
				   "\nTelefone: "+ p5.getTelefone()+
				   "\nSalario Bruto: "+p5.getSalarioBase()+
				   "\nValor de Produ��o: "+ p5.getValorProdu��o()+
				   "\nAjuda de Custo: "+ p5.getComissao());
		
		System.out.println("Valor do sal�rio: " + p5.calcularSalario());
		
		
	}
}
