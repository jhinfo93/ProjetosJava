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
import java.util.Date;

import javax.swing.JOptionPane;

import model.Arquivo;
import model.Medico;
import visao.VisaoConsultaMedico;

public class ControladorConsultaMedico implements ActionListener{

	private VisaoConsultaMedico visaoConsultaMedico;
	
	public ControladorConsultaMedico(VisaoConsultaMedico visaoConsultaMedico) {
		this.visaoConsultaMedico = visaoConsultaMedico;
		addEventos();
	}

	private void addEventos() {
		visaoConsultaMedico.getJButtonPesquisar().addActionListener(this);
		visaoConsultaMedico.getJButtonImportar().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == visaoConsultaMedico.getJButtonPesquisar()) {
			
			String nome = visaoConsultaMedico.getJComboBoxMedico().getSelectedItem().toString();
			String crm = visaoConsultaMedico.getFormattedTextFieldCRM().getText();
			
			if (nome == "Selecione") {
				limpaDados();
			}
			else if (VerificaPreenchimentoCampo(crm)) {
				
			}
			else {
				dadosMedico(nome, Integer.parseInt(crm));				
			}
		}
		else if (e.getSource() == visaoConsultaMedico.getJButtonImportar()) {
			
			Arquivo.carregarMedicos();
			ControladorFrame.frame.setContentPane(visaoConsultaMedico);
			visaoConsultaMedico.atualizaComboBoxMedico();
			ControladorFrame.frame.repaint();
			ControladorFrame.frame.validate();
		}
	}
	
//Preenchendo os campos JTextField com os dados que foram encontrados durante a pesquisa	
	public void dadosMedico (String nome, int crm) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		int achou = 0;
		
		for (Medico medico: ControladorCadastroMedico.listaMedico) {
			if (medico.getNome() == nome && medico.getCrm() == crm) {
				visaoConsultaMedico.getJTextFieldNome().setText("Dr." + medico.getNome());
				visaoConsultaMedico.getJTextFieldBairro().setText(medico.getEndereco().getBairro());
				visaoConsultaMedico.getJTextFieldRua().setText(medico.getEndereco().getLogradouro());
				visaoConsultaMedico.getJTextFieldCEP().setText(medico.getEndereco().getCep());
				visaoConsultaMedico.getJTextFieldCidade().setText(medico.getEndereco().getCidade());
				visaoConsultaMedico.getJTextFieldComplemento().setText(medico.getEndereco().getComplemento());
				visaoConsultaMedico.getJTextFieldEstado().setText(medico.getEndereco().getEstado());
				visaoConsultaMedico.getJTextFieldTelefone().setText(medico.getEndereco().getTelefone());
				visaoConsultaMedico.getJTextFieldNumeroCasa().setText(String.valueOf(medico.getEndereco().getNumero()));
				visaoConsultaMedico.getJTextFieldCPF().setText(medico.getCpf());
				visaoConsultaMedico.getJTextFieldRG().setText(medico.getRg());
				visaoConsultaMedico.getJTextFieldSexo().setText(medico.getSexo());
				visaoConsultaMedico.getJTextFieldAreaAtuacao().setText(medico.getAreaAtuacao());
				visaoConsultaMedico.getJTextFieldEspecialidade().setText(medico.getEspecialidade());
				visaoConsultaMedico.getJTextFieldDataNascimento().setText(sdf.format(medico.getDataNascimento()));
				visaoConsultaMedico.getJTextFieldCRM().setText(String.valueOf(medico.getCrm()));
				achou = 1;
				break;
			}
		}
		if (achou == 0) {
			JOptionPane.showMessageDialog(null, "Os dados do Médico não foram encontrados!", "Médico", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	/*Se o usuário clicar em pesquisar na opção "Selecione", todos os JTextFields serão
	limpados*/	
	public void limpaDados () {
		visaoConsultaMedico.getJTextFieldBairro().setText("");
		visaoConsultaMedico.getJTextFieldCEP().setText("");
		visaoConsultaMedico.getJTextFieldCidade().setText("");
		visaoConsultaMedico.getJTextFieldEspecialidade().setText("");
		visaoConsultaMedico.getJTextFieldComplemento().setText("");
		visaoConsultaMedico.getJTextFieldCPF().setText("");
		visaoConsultaMedico.getJTextFieldDataNascimento().setText("");
		visaoConsultaMedico.getJTextFieldEstado().setText("");
		visaoConsultaMedico.getJTextFieldNome().setText("");
		visaoConsultaMedico.getJTextFieldNumeroCasa().setText("");
		visaoConsultaMedico.getJTextFieldAreaAtuacao().setText("");
		visaoConsultaMedico.getJTextFieldRG().setText("");
		visaoConsultaMedico.getJTextFieldRua().setText("");
		visaoConsultaMedico.getJTextFieldCRM().setText("");
		visaoConsultaMedico.getJTextFieldSexo().setText("");
		visaoConsultaMedico.getJTextFieldTelefone().setText("");
	}
	
	//Método para verifica se campo foi preenchido
	public boolean VerificaPreenchimentoCampo (String crm) {
		
		if (crm.trim().isEmpty()){
			JOptionPane.showMessageDialog(null, "O campo CRM está vazio", "Médico", JOptionPane.WARNING_MESSAGE);
			visaoConsultaMedico.getFormattedTextFieldCRM().requestFocus();
			return true;
		}
		return false;
	}
}
