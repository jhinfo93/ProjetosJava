/*
 * Autor - Raul Gonçalves e Saullo Benevides
 * 2019
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import model.Arquivo;
import model.Paciente;
import visao.VisaoConsultaPaciente;

public class ControladorConsultaPaciente implements ActionListener{

	private VisaoConsultaPaciente visaoConsultaPaciente;
	
	public ControladorConsultaPaciente(VisaoConsultaPaciente visaoConsultaPaciente) {
		this.visaoConsultaPaciente = visaoConsultaPaciente;
		addEventos();
	}

	private void addEventos() {
		visaoConsultaPaciente.getJButtonPesquisar().addActionListener(this);
		visaoConsultaPaciente.getJButtonImportar().addActionListener(this);
		visaoConsultaPaciente.getJButtonPesquisarPatologia().addActionListener(this);
		visaoConsultaPaciente.getJButtonMedicamento().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String nomePaciente = visaoConsultaPaciente.getJComboBoxPaciente().getSelectedItem().toString();
		String cpf = visaoConsultaPaciente.getJFormattedTextfieldCPF().getText();
		
		if (e.getSource() == visaoConsultaPaciente.getJButtonPesquisar()) {
			
			if (nomePaciente == "Selecione") {
				limpaDados();
				visaoConsultaPaciente.atualizaComboBoxPatologia();
			}
			else if (VerificaPreenchimentoCampo(cpf)) {		
			}
			else if (dadosPaciente(nomePaciente, cpf)){
				atualizaComboBoxDoenca(nomePaciente, cpf);
			}
		}
		else if (e.getSource() == visaoConsultaPaciente.getJButtonPesquisarPatologia()) {
			
			String patologia = visaoConsultaPaciente.getJComboBoxDoenca().getSelectedItem().toString();
			
			if (patologia == "Selecione") {
				JOptionPane.showMessageDialog(null, "Escolha uma patologia", "Paciente", JOptionPane.WARNING_MESSAGE);
				visaoConsultaPaciente.getJComboBoxDoenca().requestFocus();
			}
			else {
				preencheCamposPatologia(cpf, patologia);
			}
		}
		else if (e.getSource() == visaoConsultaPaciente.getJButtonMedicamento()) {
		
			String patologia = visaoConsultaPaciente.getJComboBoxDoenca().getSelectedItem().toString();
			
			if (patologia == "Selecione") {
				JOptionPane.showMessageDialog(null, "Escolha uma patologia para fazer a pesquisa do medicamento", "Paciente", JOptionPane.WARNING_MESSAGE);
			}
			else {
				pesquisaMedicamentos(cpf, patologia);
			}
		}
		else if (e.getSource() == visaoConsultaPaciente.getJButtonImportar()) {
			
			Arquivo.carregarPacientes();
			ControladorFrame.frame.setContentPane(visaoConsultaPaciente);
			visaoConsultaPaciente.atualizaComboBoxPaciente();
			ControladorFrame.frame.repaint();
			ControladorFrame.frame.validate();
		}
	}

//Preenchendo os campos JTextField com os dados que foram encontrados durante a pesquisa	
	public boolean dadosPaciente (String nome, String cpf) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		for (Paciente paciente: ControladorCadastroPaciente.listaPaciente) {
			
			if (paciente.getNome().equals(nome) && paciente.getCpf().equals(cpf)) {
				
				visaoConsultaPaciente.getJTextFieldNome().setText(paciente.getNome());
				visaoConsultaPaciente.getJTextFieldBairro().setText(paciente.getEndereco().getBairro());
				visaoConsultaPaciente.getJTextFieldRua().setText(paciente.getEndereco().getLogradouro());
				visaoConsultaPaciente.getJTextFieldCEP().setText(paciente.getEndereco().getCep());
				visaoConsultaPaciente.getJTextFieldCidade().setText(paciente.getEndereco().getCidade());
				visaoConsultaPaciente.getJTextFieldComplemento().setText(paciente.getEndereco().getComplemento());
				visaoConsultaPaciente.getJTextFieldEstado().setText(paciente.getEndereco().getEstado());
				visaoConsultaPaciente.getJTextFieldTelefone().setText(paciente.getEndereco().getTelefone());
				visaoConsultaPaciente.getJTextFieldNumeroCasa().setText(String.valueOf(paciente.getEndereco().getNumero()));
				visaoConsultaPaciente.getJTextFieldCPF().setText(paciente.getCpf());
				visaoConsultaPaciente.getJTextFieldRG().setText(paciente.getRg());
				visaoConsultaPaciente.getJTextFieldSexo().setText(paciente.getSexo());
				visaoConsultaPaciente.getJTextFieldDataNascimento().setText(sdf.format(paciente.getDataNascimento()));
				visaoConsultaPaciente.getJTextFieldTipoSanguineo().setText(paciente.getTipoSanguineo());
				visaoConsultaPaciente.getJTextFieldFiliacao().setText(paciente.getFiliacao());
				return true;
			}
		}
		JOptionPane.showMessageDialog(null, "Os dados do Paciente não foram encontrados!", "Paciente", JOptionPane.WARNING_MESSAGE);
		return false;
	}
	
	/*Se o usuário clicar em pesquisar na opção "Selecione", todos os JTextFields serão
	limpados*/	
	public void limpaDados () {
		visaoConsultaPaciente.getJTextFieldBairro().setText("");
		visaoConsultaPaciente.getJTextFieldCEP().setText("");
		visaoConsultaPaciente.getJTextFieldCidade().setText("");
		visaoConsultaPaciente.getJTextFieldComplemento().setText("");
		visaoConsultaPaciente.getJTextFieldCPF().setText("");
		visaoConsultaPaciente.getJTextFieldDataNascimento().setText("");
		visaoConsultaPaciente.getJTextFieldEstado().setText("");
		visaoConsultaPaciente.getJTextFieldNome().setText("");
		visaoConsultaPaciente.getJTextFieldNumeroCasa().setText("");
		visaoConsultaPaciente.getJTextFieldRG().setText("");
		visaoConsultaPaciente.getJTextFieldRua().setText("");
		visaoConsultaPaciente.getJTextFieldSexo().setText("");
		visaoConsultaPaciente.getJTextFieldTelefone().setText("");
		visaoConsultaPaciente.getJTextFieldTipoSanguineo().setText("");
		visaoConsultaPaciente.getJTextFieldFiliacao().setText("");
		visaoConsultaPaciente.getJTextFieldDataDiagnostico().setText("");
		visaoConsultaPaciente.getJTextFieldDoencaCronica().setText("");
	}
	
	//Método para verifica se campo foi preenchido
	public boolean VerificaPreenchimentoCampo (String cpf) {
		
		if (cpf.equals("   .   .   -  ")){
			JOptionPane.showMessageDialog(null, "O campo CPF está vazio", "Paciente", JOptionPane.WARNING_MESSAGE);
			visaoConsultaPaciente.getJFormattedTextfieldCPF().requestFocus();
			return true;
		}
		return false;
	}
	
	//Alterando o ComboBox da Patologia de acordo com as doenças do paciente pesquisado
	public void atualizaComboBoxDoenca(String nomePaciente, String cpf) {
		
		visaoConsultaPaciente.atualizaComboBoxPatologia();;
		
		for (Paciente paciente: ControladorCadastroPaciente.listaPaciente) {
			//Procurando o paciente pelo nome e CPF
			if (paciente.getNome().equals(nomePaciente) && paciente.getCpf().equals(cpf)) {
				for (int i = 0; i < paciente.historicoDoenca.size(); i++) {	
					//Preenchendo o ComoBox com todas doenças do paciente
					visaoConsultaPaciente.getJComboBoxDoenca().addItem(paciente.historicoDoenca.get(i).getNome());
				}
			}
		}
	}
	
	public void preencheCamposPatologia (String nomePaciente, String cpf, String doenca) {

		for (Paciente paciente: ControladorCadastroPaciente.listaPaciente) {
			
			if (paciente.getNome().equals(nomePaciente) && paciente.getCpf().equals(cpf)) {
				for (int i = 0; i < paciente.historicoDoenca.size(); i++) {	
					
					//Preenchendo os campos JTextField com os dados de acordo com a doença pesquisada
					if (paciente.historicoDoenca.get(i).getNome() == doenca) {
						visaoConsultaPaciente.getJTextFieldDataDiagnostico().setText(paciente.historicoDoenca.get(i).getDataDiagnostico());
						visaoConsultaPaciente.getJTextFieldDoencaCronica().setText(paciente.historicoDoenca.get(i).getCronica());
						break;
					}
				}
			}
		}
	}	
	
	//Sobrecarga de Métodos
	public void preencheCamposPatologia (String cpf, String doenca) {

		for (Paciente paciente: ControladorCadastroPaciente.listaPaciente) {
			
			if (paciente.getCpf().equals(cpf)) {
				for (int i = 0; i < paciente.historicoDoenca.size(); i++) {	
					
					//Preenchendo os campos JTextField com os dados de acordo com a doença pesquisada
					if (paciente.historicoDoenca.get(i).getNome() == doenca) {
						visaoConsultaPaciente.getJTextFieldDataDiagnostico().setText(paciente.historicoDoenca.get(i).getDataDiagnostico());
						visaoConsultaPaciente.getJTextFieldDoencaCronica().setText(paciente.historicoDoenca.get(i).getCronica());
						break;
					}
				}
			}
		}
	}
	
	//Pesquisando o histórico de medicamentos do paciente relacionado a uma determinada doença
	public void pesquisaMedicamentos (String cpf, String doenca) {

		ArrayList<String> informacoesMedicamentos = new ArrayList<>();
		int achou = 0;
		
		for (Paciente paciente: ControladorCadastroPaciente.listaPaciente) {
			
			if (paciente.getCpf().equals(cpf)) {
				
				for (int i = 0; i < paciente.historicoMedicamentos.size(); i++) {	
					
					if (paciente.historicoMedicamentos.get(i).getIndicacao() == doenca) {
						informacoesMedicamentos.add("Medicamento: " + paciente.historicoMedicamentos.get(i).getNome() +
						"\nTipo: " + paciente.historicoMedicamentos.get(i).getTipo() + "\n\n");
						achou++;
					}
				}
			}
		}
		
		if (achou == 0) {
			JOptionPane.showMessageDialog(null, "O paciente ainda não possui medicamentos para " + doenca, "Paciente", JOptionPane.INFORMATION_MESSAGE);
		}
		
		for (String medicamentos: informacoesMedicamentos) {
			JOptionPane.showMessageDialog(null, medicamentos);
		}
	}
}
