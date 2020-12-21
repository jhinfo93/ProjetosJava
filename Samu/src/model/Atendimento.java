package model;

public class Atendimento {

	private String solicitante;
	private String apelidoOcorrencia;
	private Endereco localizacaoOcorrencia;
	private String pontoReferencia;
	private String sexoAtendido;
	private String motivo;	 		//Motivo da ligação ou queixa
	private String origem;			//Origem da ligação
	private String tipoLigacao;		//Trote, regulação, engano, informações
	private int idadeAparente;
	private String dataLigacao;
	private String cpf;

	public Atendimento () {
		
	}
	
	public Atendimento(String solicitante, String apelidoOcorrencia, Endereco localizacaoOcorrencia,
			String pontoReferencia, String sexoAtendido, String motivo, String origem, String tipoLigacao,
			int idadeAparente, String dataLigacao, String cpf) {
		
		this.solicitante = solicitante;
		this.apelidoOcorrencia = apelidoOcorrencia;
		this.localizacaoOcorrencia = localizacaoOcorrencia;
		this.pontoReferencia = pontoReferencia;
		this.sexoAtendido = sexoAtendido;
		this.motivo = motivo;
		this.origem = origem;
		this.tipoLigacao = tipoLigacao;
		this.idadeAparente = idadeAparente;
		this.dataLigacao = dataLigacao;
		this.cpf = cpf;
	}

	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}

	public String getApelidoOcorrencia() {
		return apelidoOcorrencia;
	}

	public void setApelidoOcorrencia(String apelidoOcorrencia) {
		this.apelidoOcorrencia = apelidoOcorrencia;
	}

	public Endereco getLocalizacaoOcorrencia() {
		return localizacaoOcorrencia;
	}

	public void setLocalizacaoOcorrencia(Endereco localizacaoOcorrencia) {
		this.localizacaoOcorrencia = localizacaoOcorrencia;
	}

	public String getPontoReferencia() {
		return pontoReferencia;
	}

	public void setPontoReferencia(String pontoReferencia) {
		this.pontoReferencia = pontoReferencia;
	}

	public String getSexoAtendido() {
		return sexoAtendido;
	}

	public void setSexoAtendido(String sexoAtendido) {
		this.sexoAtendido = sexoAtendido;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getTipoLigacao() {
		return tipoLigacao;
	}

	public void setTipoLigacao(String tipoLigacao) {
		this.tipoLigacao = tipoLigacao;
	}

	public int getIdadeAparente() {
		return idadeAparente;
	}

	public void setIdadeAparente(int idadeAparente) {
		this.idadeAparente = idadeAparente;
	}

	public String getDataLigacao() {
		return dataLigacao;
	}

	public void setDataLigacao(String dataLigacao) {
		this.dataLigacao = dataLigacao;
	}
}
