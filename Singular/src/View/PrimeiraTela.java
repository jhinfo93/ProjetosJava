package View;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrimeiraTela extends JPanel {

//Variavéis	

	private JButton btnGerenciamentoEmpresa;
	private JButton btnCadastroEmpresa;

	// -------------------------------------------------------------

//Construtor
	public PrimeiraTela() {
		setBackground(Color.WHITE);
		setSize(500, 400);
		setLayout(null);
		add(getBtnGerenciamentoEmpresa());
		add(getBtnCadastroEmpresa());
	}

	// -------------------------------------------------------------
	public JButton getBtnGerenciamentoEmpresa() {
		if (btnGerenciamentoEmpresa == null) {
			btnGerenciamentoEmpresa = new JButton("Ger. de \r\nEmpresa");
			btnGerenciamentoEmpresa.setBounds(12, 207, 181, 47);
		}
		return btnGerenciamentoEmpresa;
	}

	public JButton getBtnCadastroEmpresa() {
		if (btnCadastroEmpresa == null) {
			btnCadastroEmpresa = new JButton("Cadastro de Empresa");
			btnCadastroEmpresa.setBounds(12, 148, 181, 47);
		}
		return btnCadastroEmpresa;
	}
}
