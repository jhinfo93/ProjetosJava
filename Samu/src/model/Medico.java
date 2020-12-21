package model;

import java.util.Date;

public class Medico extends ModeloPessoa{

	private int crm;
	private String especialidade;
	private String areaAtuacao;
	
	public Medico () {
		
	}
	
	public Medico(String nome, String cpf, String rg, Endereco endereco, Date dataNascimento, String sexo, int crm,
			String especialidade, String areaAtuacao) {
		super(nome, cpf, rg, endereco, dataNascimento, sexo);
		this.crm = crm;
		this.especialidade = especialidade;
		this.areaAtuacao = areaAtuacao;
	}

	public int getCrm() {
		return crm;
	}

	public void setCrm(int crm) {
		this.crm = crm;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public String getAreaAtuacao() {
		return areaAtuacao;
	}

	public void setAreaAtuacao(String areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
	}
}
