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

import model.Paciente;
import model.Arquivo;
import model.Endereco;
import model.Medico;
import visao.VisaoCadastroPaciente;
import visao.VisaoCadastroPatologia;
import visao.VisaoTelaInicial;

public class ControladorCadastroPaciente implements ActionListener {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private VisaoCadastroPaciente visaoCadastroPaciente;
	private VisaoTelaInicial visaoTelaInicial;
	private ControladorTelaInicial controladorTelaInicial;
	private VisaoCadastroPatologia visaoCadastroPatologia;
	private ControladorCadastroPatologia controladorCadastroPatologia;
	public static List <Paciente> listaPaciente = new ArrayList<>();
	private String caminho = "D:/ws-eclipse/Samu/Paciente.txt";
	
	public ControladorCadastroPaciente(VisaoCadastroPaciente visaoCadastroPaciente) {
		visaoTelaInicial = new VisaoTelaInicial();
		controladorTelaInicial = new ControladorTelaInicial(visaoTelaInicial);
		visaoCadastroPatologia = new VisaoCadastroPatologia();
		controladorCadastroPatologia = new ControladorCadastroPatologia(visaoCadastroPatologia);
		
		this.visaoCadastroPaciente = visaoCadastroPaciente;
		addEventos();
	}
	
	private void addEventos() {
		visaoCadastroPaciente.getJButtonVoltar().addActionListener(this);
		visaoCadastroPaciente.getJButtonCadastrar().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == visaoCadastroPaciente.getJButtonVoltar()) {
		
			ControladorFrame.frame.setContentPane(visaoTelaInicial);
			ControladorFrame.frame.repaint();
			ControladorFrame.frame.validate();
		}
		else if (e.getSource() == visaoCadastroPaciente.getJButtonCadastrar()) {
			
			String nome = visaoCadastroPaciente.getJTextfieldNome().getText();
			String cpf = visaoCadastroPaciente.getJFormattedTextfieldCpf().getText();
			String rg = visaoCadastroPaciente.getJFormattedTextFieldRg().getText();
			String dataNascimento = visaoCadastroPaciente.getJFormattedTextfieldDataNascimento().getText();
			String telefone = visaoCadastroPaciente.getJFormattedTextfieldTelefone().getText();
			String rua = visaoCadastroPaciente.getJTextfieldRua().getText();
			String bairro = visaoCadastroPaciente.getJTextfieldBairro().getText();
			String numeroCasa = visaoCadastroPaciente.getJTextfieldNumeroCasa().getText();
			String cep = visaoCadastroPaciente.getJFormattedTextfieldCep().getText();
			String estado = visaoCadastroPaciente.getJTextFieldEstado().getText();
			String cidade = visaoCadastroPaciente.getJTextFieldCidade().getText();
			String complemento = visaoCadastroPaciente.getJTextFieldComplemento().getText();
			String sexo = (String) visaoCadastroPaciente.getJComboBoxSexo().getSelectedItem();
			String filiacao = visaoCadastroPaciente.getJTextFieldFiliacao().getText();
			String tipoSanguineo = (String) visaoCadastroPaciente.getJComboBoxTipoSanguineo().getSelectedItem();
			
    		if (VerificaPreenchimentoCampo(nome, cpf, rg, dataNascimento, telefone, 
    			rua, bairro, numeroCasa, cidade, estado, cep, complemento, filiacao)) {
    		}    		   		
    		else if (verficaCampoLetras (nome, cidade, estado, filiacao)) {
    		}
    		else if (verficaCampoNumeros(numeroCasa)) {
    		} 
    		else if (verficaTipoSanguineo(tipoSanguineo)) {
    		}
    		else if (veficiaCPF(cpf, rg)) {
    		}
    		else if (validaData(dataNascimento)) {
    		}
    		else {
    			JOptionPane.showMessageDialog (null, "Paciente cadastrado com sucesso!");		
    			Integer numCasa = Integer.parseInt(numeroCasa);
    			Date data= new Date();
    			
    			try {
    				data = sdf.parse(dataNascimento);
    			}
    			catch (Exception ex) {
    			}
    			
    			Endereco endereco = new Endereco(rua, numCasa, complemento, bairro, cidade, estado, cep, telefone);
    			Paciente Paciente = new Paciente(nome, cpf, rg, endereco, data, sexo, tipoSanguineo, filiacao);
    			listaPaciente.add(Paciente);
    			
    			String texto []=  new String [] {rua + ";" + numCasa + ";" + complemento  + ";" +  bairro + ";" + cidade + ";" + 
    			estado + ";" + cep + ";" + telefone + ";" + nome + ";" + cpf + ";" + rg + ";" + String.valueOf(sdf.format(data)) + ";" + sexo + ";" +
    			tipoSanguineo + ";" + filiacao};
				
				if(Arquivo.writeAdicionaFinal(caminho, texto)){
				}
				else {
				}
    			
    			limpaCampos();
    			ControladorFrame.frame.setContentPane(visaoCadastroPatologia);
    			visaoCadastroPatologia.getJTextFieldPaciente().setText(nome);
    			visaoCadastroPatologia.getJFormattedTextfieldCPF().setText(cpf);
    			visaoCadastroPatologia.getJTextfieldDoenca().setText("");
    			visaoCadastroPatologia.getJFormattedTextfieldDataDiagnostico().setText("");
    			ControladorFrame.frame.repaint();
    			ControladorFrame.frame.validate();
    		}
    	}
	}

	//Método para verifica se os campos estão preenchidos no memento de cadastrar o Paciente
	public boolean VerificaPreenchimentoCampo (String nome, String cpf, String rg,
			String dataNascimento, String telefone, String rua, String bairro, String numeroCasa, 
			String cidade, String estado, String cep, String complemento, String filiacao) {
		
		if (nome.trim().isEmpty()){
			JOptionPane.showMessageDialog(null, "O campo Nome está vazio", "Paciente", JOptionPane.WARNING_MESSAGE);
			visaoCadastroPaciente.getJTextfieldNome().requestFocus();
			return true;
		}
		else if (cpf.equals("   .   .   -  ")){
			JOptionPane.showMessageDialog(null, "O campo CPF está vazio", "Paciente", JOptionPane.WARNING_MESSAGE);
			visaoCadastroPaciente.getJFormattedTextfieldCpf().requestFocus();
			return true;
		}
		else if (dataNascimento.equals("  /  /    ")){
			JOptionPane.showMessageDialog(null, "O campo Data de Nascimento está vazio", "Paciente", JOptionPane.WARNING_MESSAGE);
			visaoCadastroPaciente.getJFormattedTextfieldDataNascimento().requestFocus();
			return true;
		}
		else if (rg.equals("  .   .   -  ")){
			JOptionPane.showMessageDialog(null, "O campo RG está vazio", "Paciente", JOptionPane.WARNING_MESSAGE);
			visaoCadastroPaciente.getJFormattedTextFieldRg().requestFocus();
			return true;
		}
		else if (telefone.equals("(  )      -    ")){
			JOptionPane.showMessageDialog(null, "O campo Telefone está vazio", "Paciente", JOptionPane.WARNING_MESSAGE);
			visaoCadastroPaciente.getJFormattedTextfieldTelefone().requestFocus();
			return true;
		}
		else if (rua.trim().isEmpty()){
			JOptionPane.showMessageDialog(null, "O campo Rua está vazio", "Paciente", JOptionPane.WARNING_MESSAGE);
			visaoCadastroPaciente.getJTextfieldRua().requestFocus();
			return true;
		}
		else if (bairro.trim().isEmpty()){
			JOptionPane.showMessageDialog(null, "O campo Bairro está vazio", "Paciente", JOptionPane.WARNING_MESSAGE);
			visaoCadastroPaciente.getJTextfieldBairro().requestFocus();
			return true;
		}
		else if (cep.trim().length() < 9){
			JOptionPane.showMessageDialog(null, "O campo CEP está vazio", "Paciente", JOptionPane.WARNING_MESSAGE);
			visaoCadastroPaciente.getJFormattedTextfieldCep().requestFocus();
			return true;
		}
		else if (numeroCasa.trim().isEmpty()){
			JOptionPane.showMessageDialog(null, "O campo Número da Casa está vazio", "Paciente", JOptionPane.WARNING_MESSAGE);
			visaoCadastroPaciente.getJTextfieldNumeroCasa().requestFocus();
			return true;
		}
		else if (cidade.trim().isEmpty()){
			JOptionPane.showMessageDialog(null, "O campo Cidade está vazio", "Paciente", JOptionPane.WARNING_MESSAGE);
			visaoCadastroPaciente.getJTextFieldCidade().requestFocus();
			return true;
		}
		else if (estado.trim().isEmpty()){
			JOptionPane.showMessageDialog(null, "O campo Estado está vazio", "Paciente", JOptionPane.WARNING_MESSAGE);
			visaoCadastroPaciente.getJTextFieldEstado().requestFocus();
			return true;
		}
		else if (complemento.trim().isEmpty()){
			JOptionPane.showMessageDialog(null, "O campo Complemento está vazio", "Paciente", JOptionPane.WARNING_MESSAGE);
			visaoCadastroPaciente.getJTextFieldComplemento().requestFocus();
			return true;
		}	
		else if (filiacao.trim().isEmpty()){
			JOptionPane.showMessageDialog(null, "O campo Filiação está vazio", "Paciente", JOptionPane.WARNING_MESSAGE);
			visaoCadastroPaciente.getJTextFieldFiliacao().requestFocus();
			return true;
		}
		return false;
	}
	
	//Método para verificar se uma palavra contém apenas letras
	public boolean verificaLetras(String str) {
		return str.matches("[a-zA-ZçãáéíóúâêôÇÃÁÉÍÓÚ ]+");
	}
	
	//Verificando se o campo tem apenas letras
	public boolean verficaCampoLetras (String nome, String cidade, String estado, String filiacao) {
	
		if (!verificaLetras(nome)) {
			JOptionPane.showMessageDialog(null, "No campo Nome é permitido apenas letras. Digite novmente", "Paciente", JOptionPane.WARNING_MESSAGE);
			return true;
		}
		else if (!verificaLetras(cidade)) {
			JOptionPane.showMessageDialog(null, "No campo Cidade é permitido apenas letras. Digite novmente", "Paciente", JOptionPane.WARNING_MESSAGE);
			return true;
		}
		else if (!verificaLetras(estado)) {
			JOptionPane.showMessageDialog(null, "No campo Estado é permitido apenas letras. Digite novmente", "Paciente", JOptionPane.WARNING_MESSAGE);
			return true;
		}
		else if (!verificaLetras(filiacao)) {
			JOptionPane.showMessageDialog(null, "No campo Filiação é permitido apenas letras. Digite novmente", "Paciente", JOptionPane.WARNING_MESSAGE);
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
			JOptionPane.showMessageDialog(null, "No campo Número da Casa é permitido apenas números. Digite novmente", "Paciente", JOptionPane.WARNING_MESSAGE);
			visaoCadastroPaciente.getJTextfieldNumeroCasa().requestFocus();
			return true;
		}
		return false;
	}
	
	//Verificando se o tipo sanguíneo foi selecionado, se não, não poderá cadastrar o paciente
	public boolean verficaTipoSanguineo (String tipoSanguineo) {
		
		if (tipoSanguineo == "Selecione") {
			JOptionPane.showMessageDialog(null, "O Tipo Saguíneo não foi selecionado", "Paciente", JOptionPane.WARNING_MESSAGE);
			visaoCadastroPaciente.getJComboBoxTipoSanguineo().requestFocus();
			return true;
		}
		return false;
	}

	//Método para não possibilitar o cadastro de mais de uma pessoa com o mesmo CPF
	public boolean veficiaCPF (String cpf, String rg) {
		
		//Fazendo a busca do CPF e RG de cada paciente
		for (Paciente paciente: ControladorCadastroPaciente.listaPaciente) {
			if (paciente.getCpf().equals(cpf)) {
				JOptionPane.showMessageDialog(null, "Já existe uma pessoa cadastrada no sistema com este CPF", "Paciente", JOptionPane.WARNING_MESSAGE);
				visaoCadastroPaciente.getJFormattedTextfieldCpf().requestFocus();
				return true;
			}
			else if (paciente.getRg().equals(rg)) {
				JOptionPane.showMessageDialog(null, "Já existe uma pessoa cadastrada no sistema com este RG", "Paciente", JOptionPane.WARNING_MESSAGE);
				visaoCadastroPaciente.getJFormattedTextFieldRg().requestFocus();
				return true;
			}
		}
		
		//Fazendo a busca do CPF e RG de cada médico
		for (Medico medico: ControladorCadastroMedico.listaMedico) {
			if (medico.getCpf().equals(cpf)) {
				JOptionPane.showMessageDialog(null, "Já existe uma pessoa cadastrada no sistema com este CPF", "Paciente", JOptionPane.WARNING_MESSAGE);
				visaoCadastroPaciente.getJFormattedTextfieldCpf().requestFocus();
				return true;
			}
			else if (medico.getRg().equals(rg)) {
				JOptionPane.showMessageDialog(null, "Já existe uma pessoa cadastrada no sistema com este RG", "Paciente", JOptionPane.WARNING_MESSAGE);
				visaoCadastroPaciente.getJFormattedTextFieldRg().requestFocus();
				return true;
			}
		}
		return false;
	}
	
	//Limpando todos os campos JTextField e JFormattedTextField
	public void limpaCampos() {
		visaoCadastroPaciente.getJTextfieldNome().setText("");
		visaoCadastroPaciente.getJFormattedTextfieldCpf().setText("");
		visaoCadastroPaciente.getJFormattedTextfieldDataNascimento().setText("");
		visaoCadastroPaciente.getJFormattedTextfieldTelefone().setText("");
		visaoCadastroPaciente.getJTextfieldRua().setText("");
		visaoCadastroPaciente.getJTextfieldBairro().setText("");
		visaoCadastroPaciente.getJTextfieldNumeroCasa().setText("");
		visaoCadastroPaciente.getJFormattedTextfieldCep().setText("");
		visaoCadastroPaciente.getJTextFieldEstado().setText("");
		visaoCadastroPaciente.getJTextFieldCidade().setText("");
		visaoCadastroPaciente.getJTextFieldComplemento().setText("");
		visaoCadastroPaciente.getJFormattedTextFieldRg().setText("");
		visaoCadastroPaciente.getJTextFieldFiliacao().setText("");
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
	    	
	    	JOptionPane.showMessageDialog(null, "A data inserida é inválida", "Paciente", JOptionPane.WARNING_MESSAGE);
			visaoCadastroPaciente.getJFormattedTextfieldDataNascimento().requestFocus();
	    	return true;
	    } 
	}
	
	//Colocando os dados importados no ArrayList e sobreescrevendo
	public static void importaDados (ArrayList<Paciente> array) {
		
		listaPaciente.addAll(array);
	}
}
