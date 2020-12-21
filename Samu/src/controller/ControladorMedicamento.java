package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Arquivo;
import model.Medicamento;
import model.Paciente;
import visao.VisaoMedicamento;
import visao.VisaoTelaInicial;

public class ControladorMedicamento implements ActionListener{

	private VisaoMedicamento visaoMedicamento;
	private VisaoTelaInicial visaoTelaInicial;
	private ControladorTelaInicial controladorTelaInicial;
	private String caminho = "D:/ws-eclipse/Samu/Medicamento.txt";
	
	public ControladorMedicamento(VisaoMedicamento visaoMedicamento) {
		visaoTelaInicial = new VisaoTelaInicial();
		controladorTelaInicial = new ControladorTelaInicial(visaoTelaInicial);
		
		this.visaoMedicamento = visaoMedicamento;
		addEventos();
	}

	private void addEventos() {
		visaoMedicamento.getJButtonEncerrar().addActionListener(this);
		visaoMedicamento.getJButtonAdicionar().addActionListener(this);
		visaoMedicamento.getJButtonPesquisaPatologia().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == visaoMedicamento.getJButtonEncerrar()) {
			
			int op = JOptionPane.showConfirmDialog(null, "Deseja Sair ?");
			
			if (op == 0) {
				ControladorFrame.frame.setContentPane(visaoTelaInicial);
				ControladorFrame.frame.repaint();
				ControladorFrame.frame.validate();
			}
		}
		else if (e.getSource() == visaoMedicamento.getJButtonPesquisaPatologia()) {
			
			String nomePaciente = visaoMedicamento.getJTextFieldPaciente().getText();
			String cpf = visaoMedicamento.getJFormattedTextfieldCPF().getText();
			
			if (VerificaPreenchimentoCampo(nomePaciente, cpf)) {	
			}
			else if (verficaCampoLetras(nomePaciente)) {
			}
			else {
				pesquisaPatologia(nomePaciente, cpf);
			}
		}
		else if (e.getSource() == visaoMedicamento.getJButtonAdicionar()) {
			
			String nomeMedicamento = visaoMedicamento.getJTextfieldNomeMedicamento().getText();
			String nomePaciente = visaoMedicamento.getJTextFieldPaciente().getText();
			String tipoMedicamento = visaoMedicamento.getJTextFieldTipoMedicamento().getText();
			String cpf = visaoMedicamento.getJFormattedTextfieldCPF().getText();
			String indicacao = visaoMedicamento.getJComboBoxIndicacaoMendicamento().getSelectedItem().toString();
			
			Medicamento medicamento = new Medicamento(nomeMedicamento, tipoMedicamento, indicacao);
			
			if (VerificaPreenchimentoCampo(nomeMedicamento, nomePaciente, tipoMedicamento, cpf)) {	
			}
			else if (verficaCampoLetras(nomePaciente)) {
			}
			else if (verificaIndicacao(indicacao)) {
			}
			else if (dadosPaciente(nomePaciente, cpf, medicamento)) {
				JOptionPane.showMessageDialog(null, "Dados do medicamento foram inseridos no histórico paciente", "Medicamento", JOptionPane.INFORMATION_MESSAGE);
				limpaCampos();
				
				String texto []=  new String [] {nomeMedicamento+ ";" + tipoMedicamento + ";" + indicacao};
				
				if(Arquivo.writeAdicionaFinal(caminho, texto)){
				}
				else {
				}
			}
		}
	}

	//Método para verifica se o campo foi preenchido
	public boolean VerificaPreenchimentoCampo (String nomeMedicamento, String nomePaciente, String tipoMedicamento, String cpf ) {
		if (nomeMedicamento.trim().isEmpty()){
			JOptionPane.showMessageDialog(null, "O campo Nome do Medicamento está vazio", "Medicamento", JOptionPane.WARNING_MESSAGE);
			visaoMedicamento.getJTextfieldNomeMedicamento().requestFocus();
			return true;
		}
		else if (nomePaciente.trim().isEmpty()){
			JOptionPane.showMessageDialog(null, "O campo Paciente está vazio", "Medicamento", JOptionPane.WARNING_MESSAGE);
			visaoMedicamento.getJTextFieldPaciente().requestFocus();
			return true;
		}
		else if (tipoMedicamento.trim().isEmpty()){
			JOptionPane.showMessageDialog(null, "O campo Tipo de Medicamento está vazio", "Medicamento", JOptionPane.WARNING_MESSAGE);
			visaoMedicamento.getJTextFieldTipoMedicamento().requestFocus();
			return true;
		}
		else if (cpf.equals("   .   .   -  ")){
			JOptionPane.showMessageDialog(null, "O campo CPF está vazio", "Medicamento", JOptionPane.WARNING_MESSAGE);
			visaoMedicamento.getJFormattedTextfieldCPF().requestFocus();
			return true;
		}
		return false;
	}
	
	//Método para verifica se o campo foi preenchido
	public boolean VerificaPreenchimentoCampo (String nomePaciente, String cpf ) {
		if (nomePaciente.trim().isEmpty()){
			JOptionPane.showMessageDialog(null, "O campo Paciente está vazio", "Medicamento", JOptionPane.WARNING_MESSAGE);
			visaoMedicamento.getJTextFieldPaciente().requestFocus();
			return true;
		}
		else if (cpf.equals("   .   .   -  ")){
			JOptionPane.showMessageDialog(null, "O campo CPF está vazio", "Medicamento", JOptionPane.WARNING_MESSAGE);
			visaoMedicamento.getJFormattedTextfieldCPF().requestFocus();
			return true;
		}
		return false;
	}
	
	//Verificando se existe os dados do paciente para pode adicionar o medicamento
	public boolean dadosPaciente (String nomepaciente, String cpf, Medicamento medicamento) {
		
		for (Paciente paciente: ControladorCadastroPaciente.listaPaciente) {

			if (paciente.getNome().equals(nomepaciente) && paciente.getCpf().equals(cpf)) {
				paciente.historicoMedicamentos.add(medicamento);
				return true;
			}
		}	

		JOptionPane.showMessageDialog(null, "Os dados do Paciente não foram encontrados!", "Paciente", JOptionPane.WARNING_MESSAGE);
		return false;
	}
	
	//Verificando se existe os dados do paciente
	public boolean pesquisaPatologia (String nomepaciente, String cpf) {
		
		for (Paciente paciente: ControladorCadastroPaciente.listaPaciente) {

			if (paciente.getNome().equals(nomepaciente) && paciente.getCpf().equals(cpf)) {
				
				visaoMedicamento.atualizaComboBoxTipoSanguineo();
				
				if (paciente.historicoDoenca.size() == 0) {
					JOptionPane.showMessageDialog(null, "O paciente não possui doenças em seu histórico", "Paciente", JOptionPane.INFORMATION_MESSAGE);
				}
				
				for (int i = 0; i < paciente.historicoDoenca.size(); i++) {
					visaoMedicamento.getJComboBoxIndicacaoMendicamento().addItem(paciente.getHistoricoDoenca().get(i).getNome());
				}
				ControladorFrame.frame.setContentPane(visaoMedicamento);
				ControladorFrame.frame.repaint();
				ControladorFrame.frame.validate();
				return false;
			}
		}	

		JOptionPane.showMessageDialog(null, "Os dados do Paciente não foram encontrados!", "Paciente", JOptionPane.WARNING_MESSAGE);
		return true;
	}
	
	//Método para verificar se uma palavra contém apenas letras
	public boolean verificaLetras(String str) {
		return str.matches("[a-zA-ZçãáéíóúâêôÇÃÁÉÍÓÚ ]+");
	}
	
	//Verificando se o campo tem apenas letras
	public boolean verficaCampoLetras (String nomePaciente) {
	
		if (!verificaLetras(nomePaciente)) {
			JOptionPane.showMessageDialog(null, "No campo Paciente é permitido apenas letras. Digite novmente", "Medicamento", JOptionPane.WARNING_MESSAGE);
			visaoMedicamento.getJTextFieldPaciente().requestFocus();
			return true;
		}
		return false;
	}
	
	//Limpando os campos
	public void limpaCampos () {
		visaoMedicamento.getJTextfieldNomeMedicamento().setText("");
		visaoMedicamento.getJTextFieldTipoMedicamento().setText("");
	}
	
	public boolean verificaIndicacao (String indicacao) {
		
		if (indicacao == "Selecione") {
	    	JOptionPane.showMessageDialog(null, "Escolha a indicação", "Medicamento", JOptionPane.WARNING_MESSAGE);
			visaoMedicamento.getJTextFieldTipoMedicamento().requestFocus();
			return true;
		}
		return false;
	}
}
