package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import model.Medico;
import model.Paciente;
import model.Arquivo;
import model.Endereco;
import visao.VisaoCadastroMedico;
import visao.VisaoTelaInicial;

public class ControladorCadastroMedico implements ActionListener {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private VisaoCadastroMedico visaoCadastroMedico;
	private VisaoTelaInicial visaoTelaInicial;
	private ControladorTelaInicial controladorTelaInicial;
	public static List <Medico> listaMedico = new ArrayList<>();
	private String caminho = "D:/ws-eclipse/Samu/Médico.txt";
	
	public ControladorCadastroMedico(VisaoCadastroMedico visaoCadastroMedico) {
		visaoTelaInicial = new VisaoTelaInicial();
		controladorTelaInicial = new ControladorTelaInicial(visaoTelaInicial);
		this.visaoCadastroMedico = visaoCadastroMedico;
		addEventos();
	}
	
	private void addEventos() {
		visaoCadastroMedico.getJButtonVoltar().addActionListener(this);
		visaoCadastroMedico.getJButtonCadastrar().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == visaoCadastroMedico.getJButtonVoltar()) {
			
			ControladorFrame.frame.setContentPane(visaoTelaInicial);
			ControladorFrame.frame.repaint();
			ControladorFrame.frame.validate();
		}
		else if (e.getSource() == visaoCadastroMedico.getJButtonCadastrar()) {
			
			String nome = visaoCadastroMedico.getJTextfieldNome().getText();
			String cpf = visaoCadastroMedico.getJFormattedTextfieldCpf().getText();
			String rg = visaoCadastroMedico.getJFormattedTextFieldRg().getText();
			String dataNascimento = visaoCadastroMedico.getJFormattedTextfieldDataNascimento().getText();
			String telefone = visaoCadastroMedico.getJFormattedTextfieldTelefone().getText();
			String rua = visaoCadastroMedico.getJTextfieldRua().getText();
			String bairro = visaoCadastroMedico.getJTextfieldBairro().getText();
			String numeroCasa = visaoCadastroMedico.getJTextfieldNumeroCasa().getText();
			String cep = visaoCadastroMedico.getJFormattedTextfieldCep().getText();
			String estado = visaoCadastroMedico.getJTextFieldEstado().getText();
			String cidade = visaoCadastroMedico.getJTextFieldCidade().getText();
			String complemento = visaoCadastroMedico.getJTextFieldComplemento().getText();
			String sexo = (String) visaoCadastroMedico.getJComboBoxSexo().getSelectedItem();
			String areaAtuacao = visaoCadastroMedico.getJTextFieldAreaAtuacao().getText();
			String especialidade = visaoCadastroMedico.getJTextFieldEspecialidade().getText();
			String crm = visaoCadastroMedico.getJFormattedTextFieldCRM().getText();
			
    		if (VerificaPreenchimentoCampo(nome, cpf, rg, dataNascimento, telefone, 
    			rua, bairro, numeroCasa, cidade, estado, cep, complemento, crm, especialidade, areaAtuacao)) {
    		}    		   		
    		else if (verficaCampoLetras (nome, cidade, estado, especialidade, areaAtuacao)) {
    		}
    		else if (verficaCampoNumeros(numeroCasa)) {
    		} 
    		else if (verificaCRM(Integer.parseInt(crm))) {
			}
    		else if (veficiaCPF(cpf, rg)) {
    		}
    		else if (validaData(dataNascimento)) {
    		}
    		else {
    			JOptionPane.showMessageDialog (null, "Médico cadastrado com sucesso!");		
    			Integer numCasa = Integer.parseInt(numeroCasa);
    			Date data= new Date();
    			
    			try {
    				data = sdf.parse(dataNascimento);
    			}
    			catch (Exception ex) {
    			}
    			
    			Endereco endereco = new Endereco(rua, numCasa, complemento, bairro, cidade, estado, cep, telefone);
    			Medico medico = new Medico (nome, cpf, rg, endereco, data, sexo, Integer.parseInt(crm), especialidade, areaAtuacao);
    			listaMedico.add(medico);
    			
    			String texto []=  new String [] {rua + ";" + numCasa + ";" + complemento  + ";" +  bairro + ";" + cidade + ";" + 
    	    			estado + ";" + cep + ";" + telefone + ";" + nome + ";" + cpf + ";" + rg + ";" + String.valueOf(sdf.format(data)) + ";" + sexo + ";" +
    					crm + ";" + especialidade + ";" + areaAtuacao};				
				
    			if(Arquivo.writeAdicionaFinal(caminho, texto)){
				}
				else {
				}
    			
    			limpaCampos();
    			ControladorFrame.frame.setContentPane(visaoTelaInicial);
    			ControladorFrame.frame.repaint();
    			ControladorFrame.frame.validate();
    		}
    	}
	}

	//Método para verifica se os campos estão preenchidos no memento de cadastrar o Medico
	public boolean VerificaPreenchimentoCampo (String nome, String cpf, String rg,
			String dataNascimento, String telefone, String rua, String bairro, String numeroCasa, 
			String cidade, String estado, String cep, String complemento, String crm, String especialidade, 
			String areaAtuacao) {
		
		if (nome.trim().isEmpty()){
			JOptionPane.showMessageDialog(null, "O campo Nome está vazio", "Médico", JOptionPane.WARNING_MESSAGE);
			visaoCadastroMedico.getJTextfieldNome().requestFocus();
			return true;
		}
		else if (cpf.equals("   .   .   -  ")){
			JOptionPane.showMessageDialog(null, "O campo CPF está vazio", "Médico", JOptionPane.WARNING_MESSAGE);
			visaoCadastroMedico.getJFormattedTextfieldCpf().requestFocus();
			return true;
		}
		else if (dataNascimento.equals("  /  /    ")){
			JOptionPane.showMessageDialog(null, "O campo Data de Nascimento está vazio", "Médico", JOptionPane.WARNING_MESSAGE);
			visaoCadastroMedico.getJFormattedTextfieldDataNascimento().requestFocus();
			return true;
		}
		else if (rg.equals("  .   .   -  ")){
			JOptionPane.showMessageDialog(null, "O campo RG está vazio", "Médico", JOptionPane.WARNING_MESSAGE);
			visaoCadastroMedico.getJFormattedTextFieldRg().requestFocus();
			return true;
		}
		else if (telefone.equals("(  )      -    ")){
			JOptionPane.showMessageDialog(null, "O campo Telefone está vazio", "Médico", JOptionPane.WARNING_MESSAGE);
			visaoCadastroMedico.getJFormattedTextfieldTelefone().requestFocus();
			return true;
		}
		else if (rua.trim().isEmpty()){
			JOptionPane.showMessageDialog(null, "O campo Rua está vazio", "Médico", JOptionPane.WARNING_MESSAGE);
			visaoCadastroMedico.getJTextfieldRua().requestFocus();
			return true;
		}
		else if (bairro.trim().isEmpty()){
			JOptionPane.showMessageDialog(null, "O campo Bairro está vazio", "Médico", JOptionPane.WARNING_MESSAGE);
			visaoCadastroMedico.getJTextfieldBairro().requestFocus();
			return true;
		}
		else if (cep.trim().length() < 9){
			JOptionPane.showMessageDialog(null, "O campo CEP está vazio", "Médico", JOptionPane.WARNING_MESSAGE);
			visaoCadastroMedico.getJFormattedTextfieldCep().requestFocus();
			return true;
		}
		else if (numeroCasa.trim().isEmpty()){
			JOptionPane.showMessageDialog(null, "O campo Número da Casa está vazio", "Médico", JOptionPane.WARNING_MESSAGE);
			visaoCadastroMedico.getJTextfieldNumeroCasa().requestFocus();
			return true;
		}
		else if (cidade.trim().isEmpty()){
			JOptionPane.showMessageDialog(null, "O campo Cidade está vazio", "Médico", JOptionPane.WARNING_MESSAGE);
			visaoCadastroMedico.getJTextFieldCidade().requestFocus();
			return true;
		}
		else if (estado.trim().isEmpty()){
			JOptionPane.showMessageDialog(null, "O campo Estado está vazio", "Médico", JOptionPane.WARNING_MESSAGE);
			visaoCadastroMedico.getJTextFieldEstado().requestFocus();
			return true;
		}
		else if (complemento.trim().isEmpty()){
			JOptionPane.showMessageDialog(null, "O campo Complemento está vazio", "Médico", JOptionPane.WARNING_MESSAGE);
			visaoCadastroMedico.getJTextFieldComplemento().requestFocus();
			return true;
		}	
		else if (especialidade.trim().isEmpty()){
			JOptionPane.showMessageDialog(null, "O campo Especialidade está vazio", "Médico", JOptionPane.WARNING_MESSAGE);
			visaoCadastroMedico.getJTextFieldEspecialidade().requestFocus();
			return true;
		}
		else if (areaAtuacao.trim().isEmpty()){
			JOptionPane.showMessageDialog(null, "O campo Área de Atuação está vazio", "Médico", JOptionPane.WARNING_MESSAGE);
			visaoCadastroMedico.getJTextFieldAreaAtuacao().requestFocus();
			return true;
		}
		else if (crm.trim().isEmpty()){
			JOptionPane.showMessageDialog(null, "O campo CRM está vazio", "Médico", JOptionPane.WARNING_MESSAGE);
			visaoCadastroMedico.getJFormattedTextFieldCRM().requestFocus();
			return true;
		}
		return false;
	}
	
	//Método para verificar se uma palavra contém apenas letras
	public boolean verificaLetras(String str) {
		return str.matches("[a-zA-ZçãáéíóúâêôÇÃÁÉÍÓÚ ]+");
	}
	
	//Verificando se o campo tem apenas letras
	public boolean verficaCampoLetras (String nome, String cidade, String estado, String especialidade, String areaAtuacao) {
	
		if (!verificaLetras(nome)) {
			JOptionPane.showMessageDialog(null, "No campo Nome é permitido apenas letras. Digite novmente", "Médico", JOptionPane.WARNING_MESSAGE);
			return true;
		}
		else if (!verificaLetras(cidade)) {
			JOptionPane.showMessageDialog(null, "No campo Cidade é permitido apenas letras. Digite novmente", "Médico", JOptionPane.WARNING_MESSAGE);
			return true;
		}
		else if (!verificaLetras(estado)) {
			JOptionPane.showMessageDialog(null, "No campo Estado é permitido apenas letras. Digite novmente", "Médico", JOptionPane.WARNING_MESSAGE);
			return true;
		}
		else if (!verificaLetras(especialidade)) {
			JOptionPane.showMessageDialog(null, "No campo Especialidade é permitido apenas letras. Digite novmente", "Médico", JOptionPane.WARNING_MESSAGE);
			return true;
		}
		else if (!verificaLetras(areaAtuacao)) {
			JOptionPane.showMessageDialog(null, "No campo Área de Atuação é permitido apenas letras. Digite novmente", "Médico", JOptionPane.WARNING_MESSAGE);
			return true;
		}
		return false;
	}
	
	//Verificando se o campo tem apenas números
	public boolean verficaCampoNumeros (String numeroCasa) {
		
		try {
			int numero = Integer.parseInt(numeroCasa);
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No campo Número da Casa é permitido apenas números. Digite novmente", "Médico", JOptionPane.WARNING_MESSAGE);
			visaoCadastroMedico.getJTextfieldNumeroCasa().requestFocus();
			return true;
		}
		return false;
	}
	
	//Limpando todos os campos JTextField e JFormattedTextField
	public void limpaCampos() {
		visaoCadastroMedico.getJTextfieldNome().setText("");
		visaoCadastroMedico.getJFormattedTextfieldCpf().setText("");
		visaoCadastroMedico.getJFormattedTextfieldDataNascimento().setText("");
		visaoCadastroMedico.getJFormattedTextfieldTelefone().setText("");
		visaoCadastroMedico.getJTextfieldRua().setText("");
		visaoCadastroMedico.getJTextfieldBairro().setText("");
		visaoCadastroMedico.getJTextfieldNumeroCasa().setText("");
		visaoCadastroMedico.getJFormattedTextfieldCep().setText("");
		visaoCadastroMedico.getJTextFieldEstado().setText("");
		visaoCadastroMedico.getJTextFieldCidade().setText("");
		visaoCadastroMedico.getJTextFieldComplemento().setText("");
		visaoCadastroMedico.getJFormattedTextFieldRg().setText("");
		visaoCadastroMedico.getJTextFieldAreaAtuacao().setText("");
		visaoCadastroMedico.getJTextFieldEspecialidade().setText("");
		visaoCadastroMedico.getJFormattedTextFieldCRM().setText("");
	}
	
	//Verificando se já existe algum médico com o mesmo CRM
	public boolean verificaCRM (int crm) {
		
		for (Medico medico: listaMedico) {
			if (medico.getCrm() == crm) {
				JOptionPane.showMessageDialog(null, "Já existe algum médico com o CRM inserido", "Médico", JOptionPane.WARNING_MESSAGE);
				visaoCadastroMedico.getJFormattedTextFieldCRM().requestFocus();
				return true;
			}
		}
		return false;
	}
	
	//Método para não possibilitar o cadastro de mais de uma pessoa com o mesmo CPF ou RG
	public boolean veficiaCPF (String cpf, String rg) {
		
		//Fazendo a busca do CPF e RG de cada paciente
		for (Paciente paciente: ControladorCadastroPaciente.listaPaciente) {
			if (paciente.getCpf().equals(cpf)) {
				JOptionPane.showMessageDialog(null, "Já existe uma pessoa cadastrada no sistema com este CPF", "Médico", JOptionPane.WARNING_MESSAGE);
				visaoCadastroMedico.getJFormattedTextfieldCpf().requestFocus();
				return true;
			}
			else if (paciente.getRg().equals(rg)) {
				JOptionPane.showMessageDialog(null, "Já existe uma pessoa cadastrada no sistema com este RG", "Médico", JOptionPane.WARNING_MESSAGE);
				visaoCadastroMedico.getJFormattedTextFieldRg().requestFocus();
				return true;
			}
		}
		
		//Fazendo a busca do CPF e RG de cada médico
		for (Medico medico: ControladorCadastroMedico.listaMedico) {
			if (medico.getCpf().equals(cpf)) {
				JOptionPane.showMessageDialog(null, "Já existe uma pessoa cadastrada no sistema com este CPF", "Médico", JOptionPane.WARNING_MESSAGE);
				visaoCadastroMedico.getJFormattedTextfieldCpf().requestFocus();
				return true;
			}
			else if (medico.getRg().equals(rg)) {
				JOptionPane.showMessageDialog(null, "Já existe uma pessoa cadastrada no sistema com este RG", "Médico", JOptionPane.WARNING_MESSAGE);
				visaoCadastroMedico.getJFormattedTextFieldRg().requestFocus();
				return true;
			}
		}
		return false;
	}
	
	//Verificando se a data inserida é valida
	public boolean validaData (String dataNascimento) {
	    String formatoData = "dd/MM/uuuu";
	
	    DateTimeFormatter dateTimeFormatter = DateTimeFormatter
	    .ofPattern(formatoData).withResolverStyle(ResolverStyle.STRICT);
	    
	    try {
	        LocalDate data = LocalDate.parse(dataNascimento, dateTimeFormatter);
	        return false;
	    } catch (DateTimeParseException e) {
	    	
	    	JOptionPane.showMessageDialog(null, "A data inserida é inválida", "Médico", JOptionPane.WARNING_MESSAGE);
			visaoCadastroMedico.getJFormattedTextfieldDataNascimento().requestFocus();
	    	return true;
	    } 
	}
	
	//Colocando os dados importados no ArrayList e sobreescrevendo
	public static void importaDados (ArrayList<Medico> array) {
		
		listaMedico.addAll(array);
	}
}
