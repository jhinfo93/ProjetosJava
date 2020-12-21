/*
 * Autor - Raul Gonçalves e Saullo Benevides
 * 2019
 */
package model;

import java.util.Date;

import model.Endereco;

public abstract class ModeloPessoa {
	
    private String nome;
    private String cpf;
    private String rg;
    private Endereco endereco;
    private Date dataNascimento;
    private String sexo;
    
    public ModeloPessoa () {
    
    }
    
    public ModeloPessoa (String nome, String cpf, String rg, Endereco endereco, Date dataNascimento, String sexo) {  
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
}