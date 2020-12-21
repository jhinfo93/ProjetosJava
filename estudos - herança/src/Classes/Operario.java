package Classes;

public class Operario extends Empregado {
	
	private double valorProdução;
	private double comissao;
	
	public Operario() {
		super();
	}

	public Operario(String nome, String endereço, String telefone, int codigoSetor, double salarioBase, double imposto,
			double valorProdução, double comissao) {
		super(nome, endereço, telefone, codigoSetor, salarioBase, imposto);
		this.valorProdução = valorProdução;
		this.comissao = comissao;
	}

	public double getValorProdução() {
		return valorProdução;
	}

	public void setValorProdução(double valorProdução) {
		this.valorProdução = valorProdução;
	}

	public double getComissao() {
		return comissao;
	}

	public void setComissao(double comissao) {
		this.comissao = comissao;
	}
	
	public double calcularSalario() {
		return super.calcularSalario() + (valorProdução*comissao);
	}
		
	
}
