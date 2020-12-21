package Classes;

public class Fornecedor extends Pessoa {
	
	private double valorCredito, valorDivida;
	
	public Fornecedor() {
		super();
	}
	
	public Fornecedor(String nome, String endere�o, String telefone, double valorCredito, double valorDivida) {
		super(nome, endere�o, telefone);
		this.valorCredito = valorCredito;
		this.valorDivida = valorDivida;
	}

	public double getValorCredito() {
		return valorCredito;
	}

	public void setValorCredito(float valorCredito) {
		this.valorCredito = valorCredito;
	}

	public double getValorDivida() {
		return valorDivida;
	}

	public void setValorDivida(float valorDivida) {
		this.valorDivida = valorDivida;
	}
	
	
	public double obterSaldo() {
		return valorCredito - valorDivida;
	}
	
	

}
