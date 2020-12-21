package Model;

public class Cadastro {
	private int numeroConta;
	private String nome;
	private float valor;
	
	public Cadastro() {}
	
	public Cadastro(int numeroConta, String nome, float valor) {
		this.numeroConta = numeroConta;
		this.nome = nome;
		this.valor = valor;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
	
	
	public Boolean deposito(float valor) {
		if(valor <0)
			return false;
		
		this.valor += valor;
		return true;
	}
	
	public Boolean saque(float valor) {
		if(valor > this.valor) {
			System.out.println("Valor excede o limite");
			return false;
		}
		this.valor -= valor;
		return true;
	}
	
	
	
}
