package Classes;

public class Operario extends Empregado {
	
	private double valorProdu��o;
	private double comissao;
	
	public Operario() {
		super();
	}

	public Operario(String nome, String endere�o, String telefone, int codigoSetor, double salarioBase, double imposto,
			double valorProdu��o, double comissao) {
		super(nome, endere�o, telefone, codigoSetor, salarioBase, imposto);
		this.valorProdu��o = valorProdu��o;
		this.comissao = comissao;
	}

	public double getValorProdu��o() {
		return valorProdu��o;
	}

	public void setValorProdu��o(double valorProdu��o) {
		this.valorProdu��o = valorProdu��o;
	}

	public double getComissao() {
		return comissao;
	}

	public void setComissao(double comissao) {
		this.comissao = comissao;
	}
	
	public double calcularSalario() {
		return super.calcularSalario() + (valorProdu��o*comissao);
	}
		
	
}
