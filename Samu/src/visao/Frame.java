package visao;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Frame extends JFrame{
	private JMenuBar menuBar;
	private JMenu jMenuMenu;
	private JMenu jMenuCadastro;
	private JMenu jMenuAtendimentos;
	private JMenu jMenuConsulta;
	private JMenuItem jMenuItemCadastroMedico;
	private JMenuItem jMenuItemCadastroPaciente;
	private JMenuItem jMenuItemCadastroMedicamento;
	private JMenuItem jMenuItemCadastroPatologia;
	private JMenuItem jMenuItemAtendimentosHistrico;
	private JMenuItem jMenuItemConsultaMedico;
	private JMenuItem jMenuItemConsultaPaciente;
	private JMenuItem jMenuItemMenu;
	private JMenuItem jMenuItemAtendimentosAtendimento;
	public Frame() {
		
		setVisible(true);
		setSize(798, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 436, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 264, Short.MAX_VALUE)
		);
		getContentPane().setLayout(groupLayout);
		setJMenuBar(getMenuBar_1());
	}

	public JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getJMenuMenu());
			menuBar.add(getJMenuCadastro());
			menuBar.add(getJMenuAtendimentos());
			menuBar.add(getJMenuConsulta());
		}
		return menuBar;
	}
	public JMenu getJMenuMenu() {
		if (jMenuMenu == null) {
			jMenuMenu = new JMenu("Menu");
			jMenuMenu.add(getJMenuItemMenu());
		}
		return jMenuMenu;
	}
	public JMenu getJMenuCadastro() {
		if (jMenuCadastro == null) {
			jMenuCadastro = new JMenu("Cadastro");
			jMenuCadastro.add(getJMenuItemCadastroMedico());
			jMenuCadastro.add(getJMenuItemCadastroPaciente());
			jMenuCadastro.add(getJMenuItemCadastroMedicamento());
			jMenuCadastro.add(getJMenuItemCadastroPatologia());
		}
		return jMenuCadastro;
	}
	public JMenu getJMenuAtendimentos() {
		if (jMenuAtendimentos == null) {
			jMenuAtendimentos = new JMenu("Atendimentos");
			jMenuAtendimentos.add(getJMenuItemAtendimentosAtendimento());
			jMenuAtendimentos.add(getJMenuItemAtendimentosHistrico());
		}
		return jMenuAtendimentos;
	}
	public JMenu getJMenuConsulta() {
		if (jMenuConsulta == null) {
			jMenuConsulta = new JMenu("Consulta");
			jMenuConsulta.add(getJMenuItemConsultaMedico());
			jMenuConsulta.add(getJMenuItemConsultaPaciente());
		}
		return jMenuConsulta;
	}
	public JMenuItem getJMenuItemCadastroMedico() {
		if (jMenuItemCadastroMedico == null) {
			jMenuItemCadastroMedico = new JMenuItem("M\u00E9dico");
		}
		return jMenuItemCadastroMedico;
	}
	public JMenuItem getJMenuItemCadastroPaciente() {
		if (jMenuItemCadastroPaciente == null) {
			jMenuItemCadastroPaciente = new JMenuItem("Paciente");
		}
		return jMenuItemCadastroPaciente;
	}
	public JMenuItem getJMenuItemCadastroMedicamento() {
		if (jMenuItemCadastroMedicamento == null) {
			jMenuItemCadastroMedicamento = new JMenuItem("Medicamento");
		}
		return jMenuItemCadastroMedicamento;
	}
	public JMenuItem getJMenuItemCadastroPatologia() {
		if (jMenuItemCadastroPatologia == null) {
			jMenuItemCadastroPatologia = new JMenuItem("Patologia");
		}
		return jMenuItemCadastroPatologia;
	}
	public JMenuItem getJMenuItemAtendimentosHistrico() {
		if (jMenuItemAtendimentosHistrico == null) {
			jMenuItemAtendimentosHistrico = new JMenuItem("Hist\u00F3rico");
		}
		return jMenuItemAtendimentosHistrico;
	}
	public JMenuItem getJMenuItemConsultaMedico() {
		if (jMenuItemConsultaMedico == null) {
			jMenuItemConsultaMedico = new JMenuItem("M\u00E9dico");
		}
		return jMenuItemConsultaMedico;
	}
	public JMenuItem getJMenuItemConsultaPaciente() {
		if (jMenuItemConsultaPaciente == null) {
			jMenuItemConsultaPaciente = new JMenuItem("Paciente");
		}
		return jMenuItemConsultaPaciente;
	}
	public JMenuItem getJMenuItemMenu() {
		if (jMenuItemMenu == null) {
			jMenuItemMenu = new JMenuItem("Menu");
		}
		return jMenuItemMenu;
	}
	public JMenuItem getJMenuItemAtendimentosAtendimento() {
		if (jMenuItemAtendimentosAtendimento == null) {
			jMenuItemAtendimentosAtendimento = new JMenuItem("Atendimento");
		}
		return jMenuItemAtendimentosAtendimento;
	}
}
