package View;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class PanelLogin extends JPanel {
	private JPanel panel;
	private JLabel label_user;
	private JPanel panel_1;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel labelFechar;
	private JPanel panel_entrar;
	private JLabel lblEntrar;
	private JLabel label_1;
	private JLabel lblNewLabel;
	private JLabel lblSiscad;

	public PanelLogin() {
		setBackground(new Color(102, 0, 102));
		setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setSize(720,426);
		setLayout(null);
		add(getPanel());
		add(getPanel_1());
		add(getLabelFechar());
		add(getPanel_entrar());
		add(getLblNewLabel());
		add(getLblSiscad());

	}
	public JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(new Color(255, 255, 255));
			panel.setBounds(222, 143, 260, 47);
			panel.setLayout(null);
			panel.add(getLabel_user());
			panel.add(getTextField());
		}
		return panel;
	}
	public JLabel getLabel_user() {
		if (label_user == null) {
			label_user = new JLabel("");
			label_user.setIcon(new ImageIcon(PanelLogin.class.getResource("/res/user_group_man_man_30px.png")));
			label_user.setBounds(220, 0, 30, 47);
		}
		return label_user;
	}
	public JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.setBackground(Color.WHITE);
			panel_1.setBounds(222, 203, 260, 47);
			panel_1.add(getPasswordField());
			panel_1.add(getLabel_1());
		}
		return panel_1;
	}
	public JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
			textField.setBorder(null);
			textField.setBounds(10, 0, 210, 47);
			textField.setColumns(10);
		}
		return textField;
	}
	public JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
			passwordField.setBorder(null);
			passwordField.setBounds(10, 0, 210, 47);
		}
		return passwordField;
	}
	public JLabel getLabelFechar() {
		if (labelFechar == null) {
			labelFechar = new JLabel("");
			labelFechar.setIcon(new ImageIcon(PanelLogin.class.getResource("/res/delete_sign_30px.png")));
			labelFechar.setBounds(680, 11, 30, 30);
		}
		return labelFechar;
	}
	public JPanel getPanel_entrar() {
		if (panel_entrar == null) {
			panel_entrar = new JPanel();
			panel_entrar.setBackground(new Color(255, 0, 102));
			panel_entrar.setBounds(222, 274, 260, 60);
			panel_entrar.setLayout(null);
			panel_entrar.add(getLblEntrar());
		}
		return panel_entrar;
	}
	public JLabel getLblEntrar() {
		if (lblEntrar == null) {
			lblEntrar = new JLabel("Entrar");
			lblEntrar.setForeground(new Color(0, 0, 0));
			lblEntrar.setBackground(new Color(204, 204, 204));
			lblEntrar.setHorizontalAlignment(SwingConstants.CENTER);
			lblEntrar.setFont(new Font("Tahoma", Font.BOLD, 44));
			lblEntrar.setBounds(0, 0, 260, 60);
		}
		return lblEntrar;
	}
	public JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("");
			label_1.setIcon(new ImageIcon(PanelLogin.class.getResource("/res/key_2_30px.png")));
			label_1.setBounds(220, 0, 48, 47);
		}
		return label_1;
	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(PanelLogin.class.getResource("/res/ruby_gemstone_100px.png")));
			lblNewLabel.setBounds(222, 45, 105, 87);
		}
		return lblNewLabel;
	}
	public JLabel getLblSiscad() {
		if (lblSiscad == null) {
			lblSiscad = new JLabel("SisCad");
			lblSiscad.setForeground(new Color(255, 255, 255));
			lblSiscad.setFont(new Font("Tahoma", Font.BOLD, 43));
			lblSiscad.setBounds(326, 59, 165, 52);
		}
		return lblSiscad;
	}
}
