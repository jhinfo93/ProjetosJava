package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import model.Arquivo;
import model.Atendimento;
import model.Endereco;
import model.Medico;
import model.Paciente;
import visao.VisaoAtendimento;
import visao.VisaoTelaInicial;

public class ControladorAtendimento implements ActionListener {
	
	private VisaoAtendimento visaoAtendimento;
	private VisaoTelaInicial visaoTelaInicial;
	private ControladorTelaInicial controladorTelaInicial;
	public static List <Atendimento> listaAtendimentos = new ArrayList<>();
	private String caminho = "D:/ws-eclipse/Samu/Atendimento.txt";
	
	public ControladorAtendimento(VisaoAtendimento visaoAtendimento) {
		visaoTelaInicial = new VisaoTelaInicial();
		controladorTelaInicial = new ControladorTelaInicial(visaoTelaInicial);
		
		this.visaoAtendimento = visaoAtendimento;
		addEventos();
	}
	
	private void addEventos() {
		visaoAtendimento.getJButtonVoltar().addActionListener(this);
		visaoAtendimento.getJButtonCadastrar().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == visaoAtendimento.getJButtonVoltar()) {
			ControladorFrame.frame.setContentPane(visaoTelaInicial);
			ControladorFrame.frame.repaint();
			ControladorFrame.frame.validate();
		}
		else if (e.getSource() == visaoAtendimento.getJButtonCadastrar()) {
			
			String nome = visaoAtendimento.getJTextfieldNome().getText();
			String cpf = visaoAtendimento.getJFormattedTextfieldCpf().getText();
			String telefone = visaoAtendimento.getJFormattedTextfieldTelefone().getText();
			String rua = visaoAtendimento.getJTextfieldRua().getText();
			String bairro = visaoAtendimento.getJTextfieldBairro().getText();
			String numeroCasa = visaoAtendimento.getJTextfieldNumeroCasa().getText();
			String cep = visaoAtendimento.getJFormattedTextfieldCep().getText();
			String estado = visaoAtendimento.getJTextFieldEstado().getText();
			String cidade = visaoAtendimento.getJTextFieldCidade().getText();
			String complemento = visaoAtendimento.getJTextFieldComplemento().getText();
			String sexo = (String) visaoAtendimento.getJComboBoxSexo().getSelectedItem();
			String apelidoOcorrencia = visaoAtendimento.getJTextFieldApelidoOcorrencia().getText();
			String pontoReferencia = visaoAtendimento.getJTextFieldPontoReferencia().getText();
			String motivoLigacao = visaoAtendimento.getJTextFieldMotivoLigacao().getText();
			String idadeAparente = visaoAtendimento.getJTextFieldIdadeAparente().getText();
			String tipoLigacao = (String) visaoAtendimento.getJComboBoxTipoLigacao().getSelectedItem();
			String origemLigacao = (String) visaoAtendimento.getJComboBoxOrigemLigacao().getSelectedItem();

    		if (VerificaPreenchimentoCampo(nome, cpf, telefone, rua, bairro, numeroCasa, cidade, estado, cep, complemento, pontoReferencia, apelidoOcorrencia, motivoLigacao, idadeAparente)) {
    		}    		   		
    		else if (verficaCampoLetras (nome, cidade, estado, apelidoOcorrencia)) {
    		}
    		else if (verficaCampoNumeros(numeroCasa, idadeAparente)) {
    		} 
    		else if (verficaPreenchimentoComboBox(tipoLigacao, origemLigacao)) {
    		}
    		else if (veficiaCPF(cpf)) {
    		}
    		else {
    			JOptionPane.showMessageDialog (null, "Atendimento cadastrado com sucesso!");		
    			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    			Date data = new Date();
    			String dataAtendimento = sdf.format(data);
    			Endereco endereco = new Endereco(rua, Integer.parseInt(numeroCasa), complemento, bairro, cidade, estado, cep, telefone);
    			Atendimento Atendimento = new Atendimento(nome, apelidoOcorrencia, endereco, pontoReferencia, sexo, motivoLigacao, origemLigacao, tipoLigacao, Integer.parseInt(idadeAparente), dataAtendimento, cpf);
    			listaAtendimentos.add(Atendimento);
    			
    			String texto []=  new String [] {rua + ";" + numeroCasa + ";" + complemento  + ";" +  bairro + ";" + cidade + ";" + 
    			estado + ";" + cep + ";" + telefone + ";" + nome + ";" + apelidoOcorrencia + ";" + pontoReferencia + ";" + sexo + ";" + motivoLigacao + ";" +
				origemLigacao + ";" + tipoLigacao + ";" + idadeAparente + ";" + dataAtendimento + ";" + cpf};	
    			
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

	//Método para verifica se os campos estão preenchidos no memento de cadastrar o Atendimento
	public boolean VerificaPreenchimentoCampo (String nome, String cpf, String telefone, String rua, String bairro, 
			String numeroCasa, String cidade, String estado, String cep, String complemento, String pontoReferencia, String apelidoOcorrencia,
			String motivoLigacao, String idadeAparente) {
		
		if (nome.trim().isEmpty()){
			JOptionPane.showMessageDialog(null, "O campo Nome está vazio", "Atendimento", JOptionPane.WARNING_MESSAGE);
			visaoAtendimento.getJTextfieldNome().requestFocus();
			return true;
		}
		else if (cpf.equals("   .   .   -  ")){
			JOptionPane.showMessageDialog(null, "O campo CPF está vazio", "Atendimento", JOptionPane.WARNING_MESSAGE);
			visaoAtendimento.getJFormattedTextfieldCpf().requestFocus();
			return true;
		}
		else if (apelidoOcorrencia.trim().isEmpty()){
			JOptionPane.showMessageDialog(null, "O campo Apelido de Ocorrência está vazio", "Atendimento", JOptionPane.WARNING_MESSAGE);
			visaoAtendimento.getJTextFieldApelidoOcorrencia().requestFocus();
			return true;
		}
		else if (telefone.equals("(  )      -    ")){
			JOptionPane.showMessageDialog(null, "O campo Telefone está vazio", "Atendimento", JOptionPane.WARNING_MESSAGE);
			visaoAtendimento.getJFormattedTextfieldTelefone().requestFocus();
			return true;
		}
		else if (motivoLigacao.trim().isEmpty()){
			JOptionPane.showMessageDialog(null, "O campo Motivo da Ligação está vazio", "Atendimento", JOptionPane.WARNING_MESSAGE);
			visaoAtendimento.getJTextFieldMotivoLigacao().requestFocus();
			return true;
		}
		else if (rua.trim().isEmpty()){
			JOptionPane.showMessageDialog(null, "O campo Rua está vazio", "Atendimento", JOptionPane.WARNING_MESSAGE);
			visaoAtendimento.getJTextfieldRua().requestFocus();
			return true;
		}
		else if (bairro.trim().isEmpty()){
			JOptionPane.showMessageDialog(null, "O campo Bairro está vazio", "Atendimento", JOptionPane.WARNING_MESSAGE);
			visaoAtendimento.getJTextfieldBairro().requestFocus();
			return true;
		}
		else if (idadeAparente.trim().isEmpty()){
			JOptionPane.showMessageDialog(null, "O campo Idade Aparente está vazio", "Atendimento", JOptionPane.WARNING_MESSAGE);
			visaoAtendimento.getJTextFieldIdadeAparente().requestFocus();
			return true;
		}
		else if (cep.trim().length() < 9){
			JOptionPane.showMessageDialog(null, "O campo CEP está vazio", "Atendimento", JOptionPane.WARNING_MESSAGE);
			visaoAtendimento.getJFormattedTextfieldCep().requestFocus();
			return true;
		}
		else if (numeroCasa.trim().isEmpty()){
			JOptionPane.showMessageDialog(null, "O campo Número da Casa está vazio", "Atendimento", JOptionPane.WARNING_MESSAGE);
			visaoAtendimento.getJTextfieldNumeroCasa().requestFocus();
			return true;
		}
		else if (cidade.trim().isEmpty()){
			JOptionPane.showMessageDialog(null, "O campo Cidade está vazio", "Atendimento", JOptionPane.WARNING_MESSAGE);
			visaoAtendimento.getJTextFieldCidade().requestFocus();
			return true;
		}
		else if (estado.trim().isEmpty()){
			JOptionPane.showMessageDialog(null, "O campo Estado está vazio", "Atendimento", JOptionPane.WARNING_MESSAGE);
			visaoAtendimento.getJTextFieldEstado().requestFocus();
			return true;
		}
		else if (complemento.trim().isEmpty()){
			JOptionPane.showMessageDialog(null, "O campo Complemento está vazio", "Atendimento", JOptionPane.WARNING_MESSAGE);
			visaoAtendimento.getJTextFieldComplemento().requestFocus();
			return true;
		}	
		else if (pontoReferencia.trim().isEmpty()){
			JOptionPane.showMessageDialog(null, "O campo Ponto de Referência está vazio", "Atendimento", JOptionPane.WARNING_MESSAGE);
			visaoAtendimento.getJTextFieldPontoReferencia().requestFocus();
			return true;
		}
		return false;
	}
	
	//Método para verificar se uma palavra contém apenas letras
	public boolean verificaLetras(String str) {
		return str.matches("[a-zA-ZçãáéíóúâêôÇÃÁÉÍÓÚ ]+");
	}
	
	//Verificando se o campo tem apenas letras
	public boolean verficaCampoLetras (String nome, String cidade, String estado, String apelidoOcorrencia) {
	
		if (!verificaLetras(nome)) {
			JOptionPane.showMessageDialog(null, "No campo Nome é permitido apenas letras. Digite novmente", "Atendimento", JOptionPane.WARNING_MESSAGE);
			return true;
		}
		else if (!verificaLetras(cidade)) {
			JOptionPane.showMessageDialog(null, "No campo Cidade é permitido apenas letras. Digite novmente", "Atendimento", JOptionPane.WARNING_MESSAGE);
			return true;
		}
		else if (!verificaLetras(estado)) {
			JOptionPane.showMessageDialog(null, "No campo Estado é permitido apenas letras. Digite novmente", "Atendimento", JOptionPane.WARNING_MESSAGE);
			return true;
		}
		else if (!verificaLetras(apelidoOcorrencia)) {
			JOptionPane.showMessageDialog(null, "No campo Apelido de Ocorrência é permitido apenas letras. Digite novmente", "Atendimento", JOptionPane.WARNING_MESSAGE);
			return true;
		}
		return false;
	}
	
	//Verificando se o campo tem apenas números
	public boolean verficaCampoNumeros (String numeroCasa, String idadeAparente) {
		
		try {
			int numero = Integer.parseInt(numeroCasa);
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No campo Número da Casa é permitido apenas números. Digite novmente", "Atendimento", JOptionPane.WARNING_MESSAGE);
			visaoAtendimento.getJTextfieldNumeroCasa().requestFocus();
			return true;
		}
		try {
			int idade = Integer.parseInt(idadeAparente);
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No campo Idade Aparente é permitido apenas números. Digite novmente", "Atendimento", JOptionPane.WARNING_MESSAGE);
			visaoAtendimento.getJTextFieldIdadeAparente().requestFocus();
			return true;
		}
		return false;
	}
	
	//Verificando se o tipo sanguíneo foi selecionado, se não, não poderá cadastrar o Atendimento
	public boolean verficaPreenchimentoComboBox (String tipoLigacao, String origem) {
		
		if (tipoLigacao == "Selecione") {
			JOptionPane.showMessageDialog(null, "O Tipo de Ligação não foi selecionado", "Atendimento", JOptionPane.WARNING_MESSAGE);
			visaoAtendimento.getJComboBoxTipoLigacao().requestFocus();
			return true;
		}
		else if (origem == "Selecione") {
			JOptionPane.showMessageDialog(null, "A origem da Ligação não foi selecionada", "Atendimento", JOptionPane.WARNING_MESSAGE);
			visaoAtendimento.getJComboBoxOrigemLigacao().requestFocus();
			return true;
		}
		return false;
	}

	//Método para não possibilitar o cadastro de mais de uma pessoa com o mesmo CPF
	public boolean veficiaCPF (String cpf) {
		
		//Fazendo a busca do CPF de cada Atendimento
		for (Paciente paciente: ControladorCadastroPaciente.listaPaciente) {
			if (paciente.getCpf().equals(cpf)) {
				JOptionPane.showMessageDialog(null, "Já existe uma pessoa cadastrada no sistema com este CPF", "Atendimento", JOptionPane.WARNING_MESSAGE);
				visaoAtendimento.getJFormattedTextfieldCpf().requestFocus();
				return true;
			}
		}
		
		//Fazendo a busca do CPF e RG de cada médico
		for (Medico medico: ControladorCadastroMedico.listaMedico) {
			if (medico.getCpf().equals(cpf)) {
				JOptionPane.showMessageDialog(null, "Já existe uma pessoa cadastrada no sistema com este CPF", "Atendimento", JOptionPane.WARNING_MESSAGE);
				visaoAtendimento.getJFormattedTextfieldCpf().requestFocus();
				return true;
			}
		}
		return false;
	}
	
	//Limpando todos os campos JTextField e JFormattedTextField
	public void limpaCampos() {
		visaoAtendimento.getJTextfieldNome().setText("");
		visaoAtendimento.getJFormattedTextfieldCpf().setText("");
		visaoAtendimento.getJFormattedTextfieldTelefone().setText("");
		visaoAtendimento.getJTextfieldRua().setText("");
		visaoAtendimento.getJTextfieldBairro().setText("");
		visaoAtendimento.getJTextfieldNumeroCasa().setText("");
		visaoAtendimento.getJFormattedTextfieldCep().setText("");
		visaoAtendimento.getJTextFieldEstado().setText("");
		visaoAtendimento.getJTextFieldCidade().setText("");
		visaoAtendimento.getJTextFieldComplemento().setText("");
		visaoAtendimento.getJTextFieldApelidoOcorrencia().setText("");
		visaoAtendimento.getJTextFieldPontoReferencia().setText("");
		visaoAtendimento.getJTextFieldMotivoLigacao().setText("");
		visaoAtendimento.getJTextFieldIdadeAparente().setText("");
	}
	
	//Colocando os dados importados no ArrayList e sobreescrevendo
	public static void importaDados (ArrayList<Atendimento> array) {
		
		listaAtendimentos.addAll(array);
	}
}