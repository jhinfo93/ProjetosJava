package Classes;

public class Fornecedor extends Pessoa {
	
	private double valorCredito, valorDivida;
	
	public Fornecedor() {
		super();
	}
	
	public Fornecedor(String nome, String endereço, String telefone, double valorCredito, double valorDivida) {
		super(nome, endereço, telefone);
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
