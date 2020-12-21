package View;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Component;
import javax.swing.border.TitledBorder;

import javax.swing.border.EtchedBorder;

import javax.swing.JPasswordField;
import java.awt.Font;

public class TelaLogin extends JPanel {
	private ImageIcon logo = new ImageIcon(getClass().getResource("img1.png"));
	private JLabel lblNewLabel;
	private JTextField textFieldEmail;
	private JButton btnEntrar;
	private JPasswordField passwordField;

	public TelaLogin() {
		setBackground(Color.WHITE);
		setSize(500, 400);
		setLayout(null);
		add(getLabel_1());
		add(getTextFieldEmail());
		add(getBtnEntrar());
		add(getPasswordField());
	}	

	public JLabel getLabel_1() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel(logo);
			lblNewLabel.setBounds(56, 30, 356, 170);
		}
		return lblNewLabel;
	}

	public JTextField getTextFieldEmail() {
		if (textFieldEmail == null) {
			textFieldEmail = new JTextField();
			textFieldEmail.setFont(new Font("Dialog", Font.BOLD, 15));
			textFieldEmail.setBackground(Color.WHITE);
			textFieldEmail.setBorder(
					new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(0, 255, 0)),
							"Email", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			textFieldEmail.setAlignmentX(Component.RIGHT_ALIGNMENT);
			textFieldEmail.setBounds(56, 222, 379, 40);
			textFieldEmail.setColumns(10);
		}
		return textFieldEmail;
	}

	public JButton getBtnEntrar() {
		if (btnEntrar == null) {
			btnEntrar = new JButton("Entrar");
			btnEntrar.setBackground(Color.WHITE);
			btnEntrar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, Color.GREEN));
			btnEntrar.setBounds(154, 339, 206, 23);
		}
		return btnEntrar;
	}

	public JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setFont(new Font("Dialog", Font.BOLD, 15));
			passwordField.setBackground(Color.WHITE);
			passwordField.setBorder(
					new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 0), new Color(0, 255, 0)),
							"Senha", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			passwordField.setEchoChar('*');
			passwordField.setBounds(56, 274, 379, 40);
		}
		return passwordField;
	}
}
