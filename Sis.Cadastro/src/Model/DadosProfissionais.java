package Model;

public class DadosProfissionais {
	
	String escolaridade;
	String profiss�o;
	String empresa;
	String cargo;
	Float renda;
	
	public DadosProfissionais() {}

	public DadosProfissionais(String escolaridade, String profiss�o, String empresa, String cargo, Float renda) {
		this.escolaridade = escolaridade;
		this.profiss�o = profiss�o;
		this.empresa = empresa;
		this.cargo = cargo;
		this.renda = renda;
	}

	public String getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}

	public String getProfiss�o() {
		return profiss�o;
	}

	public void setProfiss�o(String profiss�o) {
		this.profiss�o = profiss�o;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Float getRenda() {
		return renda;
	}

	public void setRenda(Float renda) {
		this.renda = renda;
	}
	
	
	
	

}
