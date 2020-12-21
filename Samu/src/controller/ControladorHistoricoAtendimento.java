/*
 * É registrado todo o histórico de atendimento da SAMU
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
import model.Atendimento;
import model.Paciente;
import visao.VisaoConsultaPaciente;
import visao.VisaoHistoricoAtendimento;

public class ControladorHistoricoAtendimento implements ActionListener{

	private VisaoHistoricoAtendimento visaoHistoricoAtendimento;
	
	public ControladorHistoricoAtendimento(VisaoHistoricoAtendimento visaoHistoricoAtendimento) {
		this.visaoHistoricoAtendimento = visaoHistoricoAtendimento;
		addEventos();
	}

	private void addEventos() {
		visaoHistoricoAtendimento.getJButtonPesquisar().addActionListener(this);
		visaoHistoricoAtendimento.getJButtonImportar().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String solicitante = visaoHistoricoAtendimento.getJComboBoxSocicitante().getSelectedItem().toString();
		String cpf = visaoHistoricoAtendimento.getJFormattedTextfieldCPF().getText();
		
		if (e.getSource() == visaoHistoricoAtendimento.getJButtonPesquisar()) {
			
			if (solicitante  == "Selecione") {
				limpaDados();
			}
			else if (VerificaPreenchimentoCampo(cpf)) {		
			}
			else if (dadosAtendimento(solicitante, cpf)){
			}
		}
		else if (e.getSource() == visaoHistoricoAtendimento.getJButtonImportar()) {
			
			Arquivo.carregarAtendimentos();
			ControladorFrame.frame.setContentPane(visaoHistoricoAtendimento);
			visaoHistoricoAtendimento.atualizaComboBoxSolicitante();
			ControladorFrame.frame.repaint();
			ControladorFrame.frame.validate();
		}
	}

//Preenchendo os campos JTextField com os dados que foram encontrados durante a pesquisa	
	public boolean dadosAtendimento(String nome, String cpf) {
		
		for (Atendimento atendimento: ControladorAtendimento.listaAtendimentos){
			
			if (atendimento.getSolicitante().equals(nome) && atendimento.getCpf().equals(cpf)) {
				
				visaoHistoricoAtendimento.getJTextfieldSolicitante().setText(atendimento.getSolicitante());
				visaoHistoricoAtendimento.getJTextfieldBairro().setText(atendimento.getLocalizacaoOcorrencia().getBairro());
				visaoHistoricoAtendimento.getJTextfieldRua().setText(atendimento.getLocalizacaoOcorrencia().getLogradouro());
				visaoHistoricoAtendimento.getJTextFieldCEP().setText(atendimento.getLocalizacaoOcorrencia().getCep());
				visaoHistoricoAtendimento.getJTextFieldCidade().setText(atendimento.getLocalizacaoOcorrencia().getCidade());
				visaoHistoricoAtendimento.getJTextFieldComplemento().setText(atendimento.getLocalizacaoOcorrencia().getComplemento());
				visaoHistoricoAtendimento.getJTextFieldEstado().setText(atendimento.getLocalizacaoOcorrencia().getEstado());
				visaoHistoricoAtendimento.getJTextFieldTelefone().setText(atendimento.getLocalizacaoOcorrencia().getTelefone());
				visaoHistoricoAtendimento.getJTextfieldNumeroCasa().setText(String.valueOf(atendimento.getLocalizacaoOcorrencia().getNumero()));
				visaoHistoricoAtendimento.getJTextFieldCPF().setText(atendimento.getCpf());
				visaoHistoricoAtendimento.getJTextFieldPontoReferencia().setText(atendimento.getPontoReferencia());
				visaoHistoricoAtendimento.getJTextFieldSexo().setText(atendimento.getSexoAtendido());
				visaoHistoricoAtendimento.getJTextFieldOrigem().setText(atendimento.getOrigem());
				visaoHistoricoAtendimento.getJTextFieldApelidoOcorrencia().setText(atendimento.getApelidoOcorrencia());
				visaoHistoricoAtendimento.getJTextFieldTipoLigacao().setText(atendimento.getTipoLigacao());
				visaoHistoricoAtendimento.getJTextFieldMotivoLigacao().setText(atendimento.getMotivo());
				visaoHistoricoAtendimento.getJTextFieldIdadeAparente().setText(String.valueOf(atendimento.getIdadeAparente()));
				visaoHistoricoAtendimento.getJTextFieldHorarioAtendimento().setText(atendimento.getDataLigacao());
				return true;
			}
		}
		JOptionPane.showMessageDialog(null, "Os dados do Solicitante não foram encontrados!", "Histórico de Atendimento", JOptionPane.WARNING_MESSAGE);
		return false;
	}
	
	/*Se o usuário clicar em pesquisar na opção "Selecione", todos os JTextFields serão
	limpados*/	
	public void limpaDados () {
		visaoHistoricoAtendimento.getJTextfieldSolicitante().setText("");
		visaoHistoricoAtendimento.getJTextFieldCPF().setText("");
		visaoHistoricoAtendimento.getJTextFieldTelefone().setText("");
		visaoHistoricoAtendimento.getJTextFieldCEP().setText("");
		visaoHistoricoAtendimento.getJTextfieldRua().setText("");
		visaoHistoricoAtendimento.getJTextfieldBairro().setText("");
		visaoHistoricoAtendimento.getJTextFieldCidade().setText("");
		visaoHistoricoAtendimento.getJTextFieldEstado().setText("");
		visaoHistoricoAtendimento.getJTextfieldNumeroCasa().setText("");
		visaoHistoricoAtendimento.getJTextFieldComplemento().setText("");
		visaoHistoricoAtendimento.getJTextFieldSexo().setText("");
		visaoHistoricoAtendimento.getJFormattedTextfieldCPF().setText("");
		visaoHistoricoAtendimento.getJTextFieldApelidoOcorrencia().setText("");
		visaoHistoricoAtendimento.getJTextFieldPontoReferencia().setText("");
		visaoHistoricoAtendimento.getJTextFieldTipoLigacao().setText("");
		visaoHistoricoAtendimento.getJTextFieldOrigem().setText("");
		visaoHistoricoAtendimento.getJTextFieldMotivoLigacao().setText("");
		visaoHistoricoAtendimento.getJTextFieldIdadeAparente().setText("");
		visaoHistoricoAtendimento.getJTextFieldHorarioAtendimento().setText("");
	}
	
	//Método para verifica se campo foi preenchido
	public boolean VerificaPreenchimentoCampo (String cpf) {
		
		if (cpf.equals("   .   .   -  ")){
			JOptionPane.showMessageDialog(null, "O campo CPF está vazio", "Histório de Atendimento", JOptionPane.WARNING_MESSAGE);
			visaoHistoricoAtendimento.getJFormattedTextfieldCPF().requestFocus();
			return true;
		}
		return false;
	}
}
