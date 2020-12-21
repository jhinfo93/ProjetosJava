package Classes;

public class Administrador extends Empregado {
	
	private double ajudaCusto;

	public Administrador() {
		super();
	}
	
	public Administrador(String nome, String endereço, String telefone, int codigoSetor, double salarioBase,
			double imposto, double ajudaCusto) {
		super(nome, endereço, telefone, codigoSetor, salarioBase, imposto);
		this.ajudaCusto = ajudaCusto;
	}

	public double getAjudaCusto() {
		return ajudaCusto;
	}

	public void setAjudaCusto(double ajudaCusto) {
		this.ajudaCusto = ajudaCusto;
	}
	
	public double salarioADM() {
		return calcularSalario() + ajudaCusto; 
	}
	
	
}
