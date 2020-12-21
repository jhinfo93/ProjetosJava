package Model;

public class Empresa {

	private String nome_empresa;
	private float pro_labore;
	private int qtd_funcionarios;
	private float salario_funcionario;

	public Empresa() {

	}

	public Empresa(String nome_empresa, float pro_labore, int qtd_funcionarios, float salario_funcionario) {
		this.nome_empresa = nome_empresa;
		this.pro_labore = pro_labore;
		this.qtd_funcionarios = qtd_funcionarios;
		this.salario_funcionario = salario_funcionario;
	}

	public String getNome_empresa() {
		return nome_empresa;
	}

	public void setNome_empresa(String nome_empresa) {
		this.nome_empresa = nome_empresa;
	}

	public float getPro_labore() {
		return pro_labore;
	}

	public void setPro_labore(float pro_labore) {
		this.pro_labore = pro_labore;
	}

	public int getQtd_funcionarios() {
		return qtd_funcionarios;
	}

	public void setQtd_funcionarios(int qtd_funcionarios) {
		this.qtd_funcionarios = qtd_funcionarios;
	}

	public float getSalario_funcionario() {
		return salario_funcionario;
	}

	public void setSalario_funcionario(float salario_funcionario) {
		this.salario_funcionario = salario_funcionario;
	}

}
