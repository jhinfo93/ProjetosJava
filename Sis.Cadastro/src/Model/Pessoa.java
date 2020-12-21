package Model;

import javax.xml.crypto.Data;

public class Pessoa {
	String Nome;
	int cpf;
	int rg;
	float altura;
	char sexo;
	Data data_nascimento;
	String estado_civil;
	Endereco endereco;
	DadosProfissionais dadosProfissionais;

	public Pessoa() {
	}

	public Pessoa(String nome, int cpf, int rg, float altura, char sexo, Data data_nascimento, String estado_civil,
			Endereco endereco, DadosProfissionais dadosProfissionais) {
		Nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.altura = altura;
		this.sexo = sexo;
		this.data_nascimento = data_nascimento;
		this.estado_civil = estado_civil;
		this.endereco = endereco;
		this.dadosProfissionais = dadosProfissionais;
	}

	public DadosProfissionais getDadosProfissionais() {
		return dadosProfissionais;
	}

	public void setDadosProfissionais(DadosProfissionais dadosProfissionais) {
		this.dadosProfissionais = dadosProfissionais;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public int getRg() {
		return rg;
	}

	public void setRg(int rg) {
		this.rg = rg;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public Data getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(Data data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public String getEstado_civil() {
		return estado_civil;
	}

	public void setEstado_civil(String estado_civil) {
		this.estado_civil = estado_civil;
	}

}
