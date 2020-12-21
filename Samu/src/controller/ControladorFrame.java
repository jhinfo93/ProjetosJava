/*
 * Autor - Raul Gonçalves, Saullo Benevides, Francisco Anacreonte, e Marcus Cardoso
 * 2019
 * Controlador da tela inicial. É nessa classe que a main se encontra e inicializa o 
 *programa
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import visao.Frame;
import visao.VisaoAtendimento;
import visao.VisaoCadastroMedico;
import visao.VisaoCadastroPaciente;
import visao.VisaoCadastroPatologia;
import visao.VisaoConsultaMedico;
import visao.VisaoConsultaPaciente;
import visao.VisaoHistoricoAtendimento;
import visao.VisaoMedicamento;
import visao.VisaoTelaInicial;


public class ControladorFrame implements ActionListener {
	
	public static Frame frame = new Frame();
	private VisaoTelaInicial visaoTelaInicial;
	private ControladorTelaInicial controladorTelaInicial;
	private VisaoCadastroMedico visaoCadastroMedico;
	private ControladorCadastroMedico controladorCadastroMedico;
	private VisaoCadastroPaciente visaoCadastroPaciente;
	private ControladorCadastroPaciente controladorCadastroPaciente;
	private VisaoCadastroPatologia visaoCadastroPatologia;
	private ControladorCadastroPatologia controladorCadastroPatologia;
	private VisaoConsultaMedico visaoConsultaMedico;
	private ControladorConsultaMedico controladorConsultaMedico;
	private VisaoConsultaPaciente visaoConsultaPaciente;
	private ControladorConsultaPaciente controladorConsultaPaciente;
	private VisaoMedicamento visaoMedicamento;
	private ControladorMedicamento controladorMedicamento;
	private VisaoAtendimento visaoAtendimento;
	private ControladorAtendimento controladorAtendimento;
	private VisaoHistoricoAtendimento visaoHistoricoAtendimento;
	private ControladorHistoricoAtendimento controladorHistoricoAtendimento;
	
	public ControladorFrame() {
		 
		visaoTelaInicial = new VisaoTelaInicial();
		controladorTelaInicial = new ControladorTelaInicial(visaoTelaInicial);
		visaoCadastroMedico = new VisaoCadastroMedico();
		controladorCadastroMedico = new ControladorCadastroMedico(visaoCadastroMedico);
		visaoCadastroPaciente = new VisaoCadastroPaciente();
		controladorCadastroPaciente = new ControladorCadastroPaciente(visaoCadastroPaciente);
		visaoCadastroPatologia = new VisaoCadastroPatologia();
		controladorCadastroPatologia = new ControladorCadastroPatologia(visaoCadastroPatologia);
		visaoConsultaMedico = new VisaoConsultaMedico();
		controladorConsultaMedico = new ControladorConsultaMedico(visaoConsultaMedico);
		visaoConsultaPaciente = new VisaoConsultaPaciente();
		controladorConsultaPaciente = new ControladorConsultaPaciente(visaoConsultaPaciente);
		visaoMedicamento = new VisaoMedicamento();
		controladorMedicamento = new ControladorMedicamento(visaoMedicamento); 
		visaoAtendimento = new VisaoAtendimento();
		controladorAtendimento = new ControladorAtendimento(visaoAtendimento);
		visaoHistoricoAtendimento = new VisaoHistoricoAtendimento();
		controladorHistoricoAtendimento = new ControladorHistoricoAtendimento(visaoHistoricoAtendimento);
		
		frame.setContentPane(visaoTelaInicial);
		frame.repaint();
		frame.validate();
		addEventos();
	}

	public static void main(String[] args) {
		new ControladorFrame();
	}

	public void addEventos() {
		frame.getJMenuItemMenu().addActionListener(this);
		frame.getJMenuItemCadastroMedico().addActionListener(this);
		frame.getJMenuItemCadastroPaciente().addActionListener(this);
		frame.getJMenuItemCadastroMedicamento().addActionListener(this);
		frame.getJMenuItemCadastroPatologia().addActionListener(this);
		frame.getJMenuItemCadastroMedicamento().addActionListener(this);
		frame.getJMenuItemConsultaMedico().addActionListener(this);
		frame.getJMenuItemConsultaPaciente().addActionListener(this);
		frame.getJMenuItemAtendimentosAtendimento().addActionListener(this);
		frame.getJMenuItemAtendimentosHistrico().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == frame.getJMenuItemMenu()) {
			frame.setContentPane(visaoTelaInicial);
			frame.repaint();
			frame.validate();
		}
		else if (e.getSource() == frame.getJMenuItemCadastroMedico()) {
			frame.setContentPane(visaoCadastroMedico);
			frame.repaint();
			frame.validate();
		}
		else if (e.getSource() == frame.getJMenuItemCadastroPaciente()) {
			frame.setContentPane(visaoCadastroPaciente);
			visaoCadastroPaciente.atualizaComboBoxTipoSanguineo();
			frame.repaint();
			frame.validate();
		}
		else if (e.getSource() == frame.getJMenuItemCadastroPatologia()) {
			frame.setContentPane(visaoCadastroPatologia);
			visaoCadastroPatologia.limpaCampos();
			frame.repaint();
			frame.validate();
		}
		else if (e.getSource() == frame.getJMenuItemCadastroMedicamento()) {
			frame.setContentPane(visaoMedicamento);
			visaoMedicamento.limpaCampos();
			visaoMedicamento.atualizaComboBoxTipoSanguineo();
			frame.repaint();
			frame.validate();
		}
		else if (e.getSource() == frame.getJMenuItemAtendimentosAtendimento()) {
			frame.setContentPane(visaoAtendimento);
			visaoAtendimento.atualizaComboBoxMotivoLigacao();
			visaoAtendimento.atualizaComboBoxOrigemLigacao();
			frame.repaint();
			frame.validate();
		}
		else if (e.getSource() == frame.getJMenuItemAtendimentosHistrico()) {
			frame.setContentPane(visaoHistoricoAtendimento);
			visaoHistoricoAtendimento.limpaCampos();
			visaoHistoricoAtendimento.atualizaComboBoxSolicitante();
			frame.repaint();
			frame.validate();
		}
		else if (e.getSource() == frame.getJMenuItemConsultaMedico()) {
			frame.setContentPane(visaoConsultaMedico);
			visaoConsultaMedico.atualizaComboBoxMedico();
			visaoConsultaMedico.limpaCampos();
			frame.repaint();
			frame.validate();
		}
		else if (e.getSource() == frame.getJMenuItemConsultaPaciente()) {
			frame.setContentPane(visaoConsultaPaciente);
			visaoConsultaPaciente.limpaCampos();
			visaoConsultaPaciente.atualizaComboBoxPaciente();
			visaoConsultaPaciente.atualizaComboBoxPatologia();
			frame.repaint();
			frame.validate();
		}
	}
}