package model;

public class Patologia {

	private String nome;
	private String dataDiagnostico;
	private String cronica;
	
	public Patologia () {
		
	}
	
	public Patologia(String nome, String dataDiagnostico, String cronica) {
		this.nome = nome;
		this.dataDiagnostico = dataDiagnostico;
		this.cronica = cronica;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataDiagnostico() {
		return dataDiagnostico;
	}
	public void setDataDiagnostico(String dataDiagnostico) {
		this.dataDiagnostico = dataDiagnostico;
	}
	public String getCronica() {
		return cronica;
	}
	public void setCronica(String cronica) {
		this.cronica = cronica;
	}
}
