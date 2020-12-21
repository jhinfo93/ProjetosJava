package View;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CadastroEmpresa extends JPanel {
	private JLabel lblFuncionrios;
	private JLabel lblProlabore;
	private JButton btnAvancar;
	private JTextField textFieldQTDFuncionários;
	private JTextField textFieldProlabore;
	private JLabel lblSalrioFuncionrio;
	private JTextField textFieldSalarioFuncionario;
	private JTextField textFieldNomeEmpresa;
	private JLabel lblNomeDaEmpresa_1;

	/**
	 * Create the panel.
	 */
	public CadastroEmpresa() {
		setLayout(null);
		add(getLblFuncionrios());
		add(getLblProlabore());
		add(getBtnAvancar());
		add(getTextFieldQTDFuncionários());
		add(getTextFieldProlabore());
		add(getLblSalrioFuncionrio());
		add(getTextFieldSalarioFuncionario());
		add(getTextFieldNomeEmpresa());
		add(getLblNomeDaEmpresa_1());

	}
	public JLabel getLblFuncionrios() {
		if (lblFuncionrios == null) {
			lblFuncionrios = new JLabel("Qtd Funcion\u00E1rios");
			lblFuncionrios.setHorizontalAlignment(SwingConstants.RIGHT);
			lblFuncionrios.setBounds(27, 116, 108, 14);
		}
		return lblFuncionrios;
	}
	public JLabel getLblProlabore() {
		if (lblProlabore == null) {
			lblProlabore = new JLabel("ProLabore");
			lblProlabore.setHorizontalAlignment(SwingConstants.RIGHT);
			lblProlabore.setBounds(47, 89, 88, 14);
		}
		return lblProlabore;
	}
	public JButton getBtnAvancar() {
		if (btnAvancar == null) {
			btnAvancar = new JButton("Avan\u00E7ar");
			btnAvancar.setBounds(226, 240, 89, 23);
		}
		return btnAvancar;
	}
	public JTextField getTextFieldQTDFuncionários() {
		if (textFieldQTDFuncionários == null) {
			textFieldQTDFuncionários = new JTextField();
			textFieldQTDFuncionários.setColumns(10);
			textFieldQTDFuncionários.setBounds(147, 113, 96, 20);
		}
		return textFieldQTDFuncionários;
	}
	public JTextField getTextFieldProlabore() {
		if (textFieldProlabore == null) {
			textFieldProlabore = new JTextField();
			textFieldProlabore.setColumns(10);
			textFieldProlabore.setBounds(147, 88, 96, 20);
		}
		return textFieldProlabore;
	}
	public JLabel getLblSalrioFuncionrio() {
		if (lblSalrioFuncionrio == null) {
			lblSalrioFuncionrio = new JLabel("Sal\u00E1rio Funcion\u00E1rio");
			lblSalrioFuncionrio.setHorizontalAlignment(SwingConstants.RIGHT);
			lblSalrioFuncionrio.setBounds(12, 143, 123, 14);
		}
		return lblSalrioFuncionrio;
	}
	public JTextField getTextFieldSalarioFuncionario() {
		if (textFieldSalarioFuncionario == null) {
			textFieldSalarioFuncionario = new JTextField();
			textFieldSalarioFuncionario.setColumns(10);
			textFieldSalarioFuncionario.setBounds(147, 144, 96, 20);
		}
		return textFieldSalarioFuncionario;
	}
	public JTextField getTextFieldNomeEmpresa() {
		if (textFieldNomeEmpresa == null) {
			textFieldNomeEmpresa = new JTextField();
			textFieldNomeEmpresa.setColumns(10);
			textFieldNomeEmpresa.setBounds(147, 55, 96, 20);
		}
		return textFieldNomeEmpresa;
	}
	public JLabel getLblNomeDaEmpresa_1() {
		if (lblNomeDaEmpresa_1 == null) {
			lblNomeDaEmpresa_1 = new JLabel("Nome da Empresa");
			lblNomeDaEmpresa_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNomeDaEmpresa_1.setBounds(24, 58, 111, 14);
		}
		return lblNomeDaEmpresa_1;
	}
}
