package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Paciente extends ModeloPessoa {

	private String tipoSanguineo;
	private String filiacao;
	public List <Patologia> historicoDoenca = new ArrayList <>();
	public List <Medicamento> historicoMedicamentos = new ArrayList <>();
	
	public Paciente () {
		
	}
	
	public Paciente(String nome, String cpf, String rg, Endereco endereco, Date dataNascimento, String sexo,
			String tipoSanguineo, String filiacao) {
		super(nome, cpf, rg, endereco, dataNascimento, sexo);
		this.tipoSanguineo = tipoSanguineo;
		this.filiacao = filiacao;
	}

	public List<Medicamento> getHistoricoMedicamentos() {
		return historicoMedicamentos;
	}

	public void setHistoricoMedicamentos(List<Medicamento> historicoMedicamentos) {
		this.historicoMedicamentos = historicoMedicamentos;
	}

	public String getTipoSanguineo() {
		return tipoSanguineo;
	}

	public void setTipoSanguineo(String tipoSanguineo) {
		this.tipoSanguineo = tipoSanguineo;
	}

	public String getFiliacao() {
		return filiacao;
	}

	public void setFiliacao(String filiacao) {
		this.filiacao = filiacao;
	}

	public List<Patologia> getHistoricoDoenca() {
		return historicoDoenca;
	}

	public void setHistoricoDoenca(List<Patologia> historicoDoenca) {
		this.historicoDoenca = historicoDoenca;
	}
}
