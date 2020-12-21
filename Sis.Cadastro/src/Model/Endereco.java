package Model;

public class Endereco {

	String cidade;
	String bairro;
	int cep;
	String país;
	String estado;
	
	
	public Endereco() {}
	
	public Endereco(String cidade, String bairro, int cep, String país, String estado) {
		this.cidade = cidade;
		this.bairro = bairro;
		this.cep = cep;
		this.país = país;
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

	public String getPaís() {
		return país;
	}

	public void setPaís(String país) {
		this.país = país;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	
	
}
