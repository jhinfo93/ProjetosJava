package View;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class GerenciamentoEmpresa extends JPanel {
	private JLabel lblEmpresasListadas;
	private JComboBox comboBox;

	/**
	 * Create the panel.
	 */
	public GerenciamentoEmpresa() {
		setLayout(null);
		add(getLblEmpresasListadas());
		add(getComboBox());

	}

	public JLabel getLblEmpresasListadas() {
		if (lblEmpresasListadas == null) {
			lblEmpresasListadas = new JLabel("Empresas  Listadas");
			lblEmpresasListadas.setBounds(10, 11, 93, 14);
		}
		return lblEmpresasListadas;
	}
	public JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBounds(113, 7, 113, 22);
		}
		return comboBox;
	}
}
