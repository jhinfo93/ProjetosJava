package model;

public class Medicamento {

	private String nome;
	private String tipo;	//Comprimido, Xarope, injeção, pomada...
	private String indicacao;
	
	public Medicamento () {
		
	}
	
	public Medicamento(String nome, String tipo, String indicacao) {
		this.nome = nome;
		this.tipo = tipo;
		this.indicacao = indicacao;
	}
	
	public String getIndicacao() {
		return indicacao;
	}

	public void setIndicacao(String indicacao) {
		this.indicacao = indicacao;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}	
}
