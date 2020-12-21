package View;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.JFormattedTextField;

public class PanelDeletar extends JPanel {
	private JPanel panel;
	private JPanel panel_Excluir;
	private JLabel lblExcluir;
	private JPanel panel_Voltar;
	private JLabel lblVoltar;
	private JFormattedTextField formattedTextFieldCPF;

	/**
	 * Create the panel.
	 */
	public PanelDeletar() {
		setBackground(new Color(102, 0, 102));
		setSize(720,426);
		setLayout(null);
		add(getPanel());
		add(getPanel_Excluir());
		add(getPanel_Voltar());

	}
	public JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(new Color(255, 255, 255));
			panel.setBorder(new TitledBorder(null, "Digite o CPF", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
			panel.setBounds(211, 129, 291, 55);
			panel.setLayout(null);
			panel.add(getFormattedTextFieldCPF());
		}
		return panel;
	}
	public JPanel getPanel_Excluir() {
		if (panel_Excluir == null) {
			panel_Excluir = new JPanel();
			panel_Excluir.setBackground(new Color(255, 0, 51));
			panel_Excluir.setBounds(211, 214, 126, 36);
			panel_Excluir.setLayout(null);
			panel_Excluir.add(getLblExcluir());
		}
		return panel_Excluir;
	}
	public JLabel getLblExcluir() {
		if (lblExcluir == null) {
			lblExcluir = new JLabel("Excluir");
			lblExcluir.setForeground(new Color(0, 0, 0));
			lblExcluir.setHorizontalAlignment(SwingConstants.CENTER);
			lblExcluir.setFont(new Font("Tahoma", Font.PLAIN, 23));
			lblExcluir.setBounds(10, 0, 106, 36);
		}
		return lblExcluir;
	}
	public JPanel getPanel_Voltar() {
		if (panel_Voltar == null) {
			panel_Voltar = new JPanel();
			panel_Voltar.setBackground(new Color(255, 0, 51));
			panel_Voltar.setLayout(null);
			panel_Voltar.setBounds(376, 214, 126, 36);
			panel_Voltar.add(getLblVoltar());
		}
		return panel_Voltar;
	}
	public JLabel getLblVoltar() {
		if (lblVoltar == null) {
			lblVoltar = new JLabel("Voltar");
			lblVoltar.setForeground(new Color(0, 0, 0));
			lblVoltar.setHorizontalAlignment(SwingConstants.CENTER);
			lblVoltar.setFont(new Font("Tahoma", Font.PLAIN, 23));
			lblVoltar.setBounds(10, 0, 106, 36);
		}
		return lblVoltar;
	}
	public JFormattedTextField getFormattedTextFieldCPF() {
		if (formattedTextFieldCPF == null) {
			try {
				formattedTextFieldCPF = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			formattedTextFieldCPF.setForeground(new Color(0, 0, 0));
			formattedTextFieldCPF.setBorder(null);
			formattedTextFieldCPF.setBounds(12, 22, 267, 20);
		}
		return formattedTextFieldCPF;
	}
}
