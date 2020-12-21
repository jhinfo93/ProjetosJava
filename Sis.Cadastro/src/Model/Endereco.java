package Model;

public class Endereco {

	String cidade;
	String bairro;
	int cep;
	String pa�s;
	String estado;
	
	
	public Endereco() {}
	
	public Endereco(String cidade, String bairro, int cep, String pa�s, String estado) {
		this.cidade = cidade;
		this.bairro = bairro;
		this.cep = cep;
		this.pa�s = pa�s;
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public String getPa�s() {
		return pa�s;
	}

	public void setPa�s(String pa�s) {
		this.pa�s = pa�s;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	
	
}
