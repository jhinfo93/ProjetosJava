package View;

import javax.swing.JPanel;
import java.awt.Color;
import java.text.ParseException;

import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;

public class PanelInserir extends JPanel {
	private JPanel panelDadosPessoais;
	private JLabel lblNome;
	private JLabel lblNewLabel;
	private JLabel lblCpf;
	private JLabel lblRg;
	private JTextField textFieldNome;
	private JTextField textFieldSobrenome;
	private JTextField textFieldRG;
	private JLabel lblSexo;
	private JLabel lblAltura;
	private JLabel lblDataDeNascimento;
	private JTextField textFieldAltura;
	private JLabel lblEstadoCivil;
	private JTextField textFieldEstCivil;
	private JPanel panelEndereco;
	private JLabel lblRua;
	private JLabel lblBairro;
	private JLabel lblCep;
	private JLabel lblPas;
	private JLabel lblEstado;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel lblRua_1;
	private JTextField textField_5;
	private JPanel panelDadosProfissionais;
	private JFormattedTextField formattedTextFieldSexo;
	private JFormattedTextField formattedTextFieldDataNasc;
	private JFormattedTextField formattedTextFieldCPF;
	private JFormattedTextField formattedTextField;
	private JPanel panelSalvar;
	private JPanel panelVoltar;
	private JPanel panelLimpar;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_1_2;

	/**
	 * Create the panel.
	 */
	public PanelInserir() {
		setBackground(new Color(102, 0, 102));
		setSize(720,426);
		setLayout(null);
		add(getPanelDadosPessoais());
		add(getPanelEndereco());
		add(getPanelDadosProfissionais());
		add(getPanelSalvar());
		add(getPanelVoltar());
		add(getPanelLimpar());

	}
	public JPanel getPanelDadosPessoais() {
		if (panelDadosPessoais == null) {
			panelDadosPessoais = new JPanel();
			panelDadosPessoais.setBackground(new Color(102, 0, 102));
			panelDadosPessoais.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), " Dados Pessoais", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
			panelDadosPessoais.setBounds(10, 42, 384, 174);
			panelDadosPessoais.setLayout(null);
			panelDadosPessoais.add(getLblNome());
			panelDadosPessoais.add(getLblNewLabel());
			panelDadosPessoais.add(getLblCpf());
			panelDadosPessoais.add(getLblRg());
			panelDadosPessoais.add(getTextFieldNome());
			panelDadosPessoais.add(getTextFieldSobrenome());
			panelDadosPessoais.add(getTextFieldRG());
			panelDadosPessoais.add(getLblSexo());
			panelDadosPessoais.add(getLblAltura());
			panelDadosPessoais.add(getLblDataDeNascimento());
			panelDadosPessoais.add(getTextFieldAltura());
			panelDadosPessoais.add(getLblEstadoCivil());
			panelDadosPessoais.add(getTextFieldEstCivil());
			panelDadosPessoais.add(getFormattedTextFieldSexo());
			panelDadosPessoais.add(getFormattedTextFieldDataNasc());
			panelDadosPessoais.add(getFormattedTextFieldCPF());
		}
		return panelDadosPessoais;
	}
	public JLabel getLblNome() {
		if (lblNome == null) {
			lblNome = new JLabel("Nome");
			lblNome.setHorizontalAlignment(SwingConstants.LEFT);
			lblNome.setForeground(new Color(255, 255, 255));
			lblNome.setBounds(10, 25, 54, 14);
		}
		return lblNome;
	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Sobrenome");
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setBounds(145, 25, 67, 14);
		}
		return lblNewLabel;
	}
	public JLabel getLblCpf() {
		if (lblCpf == null) {
			lblCpf = new JLabel("CPF");
			lblCpf.setForeground(new Color(255, 255, 255));
			lblCpf.setBounds(247, 59, 48, 14);
		}
		return lblCpf;
	}
	public JLabel getLblRg() {
		if (lblRg == null) {
			lblRg = new JLabel("RG");
			lblRg.setForeground(new Color(255, 255, 255));
			lblRg.setBounds(247, 84, 21, 14);
		}
		return lblRg;
	}
	public JTextField getTextFieldNome() {
		if (textFieldNome == null) {
			textFieldNome = new JTextField();
			textFieldNome.setBounds(54, 22, 89, 20);
			textFieldNome.setColumns(10);
		}
		return textFieldNome;
	}
	public JTextField getTextFieldSobrenome() {
		if (textFieldSobrenome == null) {
			textFieldSobrenome = new JTextField();
			textFieldSobrenome.setColumns(10);
			textFieldSobrenome.setBounds(217, 22, 155, 20);
		}
		return textFieldSobrenome;
	}
	public JTextField getTextFieldRG() {
		if (textFieldRG == null) {
			textFieldRG = new JTextField();
			textFieldRG.setColumns(10);
			textFieldRG.setBounds(271, 81, 96, 20);
		}
		return textFieldRG;
	}
	public JLabel getLblSexo() {
		if (lblSexo == null) {
			lblSexo = new JLabel("Sexo");
			lblSexo.setForeground(new Color(255, 255, 255));
			lblSexo.setHorizontalAlignment(SwingConstants.LEFT);
			lblSexo.setBounds(10, 59, 30, 14);
		}
		return lblSexo;
	}
	public JLabel getLblAltura() {
		if (lblAltura == null) {
			lblAltura = new JLabel("Altura");
			lblAltura.setForeground(new Color(255, 255, 255));
			lblAltura.setBounds(128, 59, 49, 14);
		}
		return lblAltura;
	}
	public JLabel getLblDataDeNascimento() {
		if (lblDataDeNascimento == null) {
			lblDataDeNascimento = new JLabel("Data de Nascimento");
			lblDataDeNascimento.setForeground(new Color(255, 255, 255));
			lblDataDeNascimento.setBounds(10, 87, 116, 14);
		}
		return lblDataDeNascimento;
	}
	public JTextField getTextFieldAltura() {
		if (textFieldAltura == null) {
			textFieldAltura = new JTextField();
			textFieldAltura.setColumns(10);
			textFieldAltura.setBounds(189, 56, 48, 20);
		}
		return textFieldAltura;
	}
	public JLabel getLblEstadoCivil() {
		if (lblEstadoCivil == null) {
			lblEstadoCivil = new JLabel("Estado CIvil");
			lblEstadoCivil.setForeground(new Color(255, 255, 255));
			lblEstadoCivil.setBounds(10, 123, 73, 14);
		}
		return lblEstadoCivil;
	}
	public JTextField getTextFieldEstCivil() {
		if (textFieldEstCivil == null) {
			textFieldEstCivil = new JTextField();
			textFieldEstCivil.setColumns(10);
			textFieldEstCivil.setBounds(84, 120, 96, 20);
		}
		return textFieldEstCivil;
	}
	public JPanel getPanelEndereco() {
		if (panelEndereco == null) {
			panelEndereco = new JPanel();
			panelEndereco.setBackground(new Color(102, 0, 102));
			panelEndereco.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Endere\u00E7o", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
			panelEndereco.setBounds(404, 42, 306, 174);
			panelEndereco.setLayout(null);
			panelEndereco.add(getLblRua());
			panelEndereco.add(getLblBairro());
			panelEndereco.add(getLblCep());
			panelEndereco.add(getLblPas());
			panelEndereco.add(getLblEstado());
			panelEndereco.add(getTextField());
			panelEndereco.add(getTextField_2());
			panelEndereco.add(getTextField_3());
			panelEndereco.add(getTextField_4());
			panelEndereco.add(getLblRua_1());
			panelEndereco.add(getTextField_5());
			panelEndereco.add(getFormattedTextField());
		}
		return panelEndereco;
	}
	public JLabel getLblRua() {
		if (lblRua == null) {
			lblRua = new JLabel("Rua");
			lblRua.setHorizontalAlignment(SwingConstants.RIGHT);
			lblRua.setBounds(10, 34, 34, 14);
			lblRua.setForeground(Color.WHITE);
		}
		return lblRua;
	}
	public JLabel getLblBairro() {
		if (lblBairro == null) {
			lblBairro = new JLabel("Bairro");
			lblBairro.setBounds(10, 91, 47, 14);
			lblBairro.setForeground(Color.WHITE);
			lblBairro.setHorizontalAlignment(SwingConstants.LEFT);
		}
		return lblBairro;
	}
	public JLabel getLblCep() {
		if (lblCep == null) {
			lblCep = new JLabel("Cep");
			lblCep.setBounds(188, 64, 23, 14);
			lblCep.setForeground(Color.WHITE);
		}
		return lblCep;
	}
	public JLabel getLblPas() {
		if (lblPas == null) {
			lblPas = new JLabel("Pa\u00EDs");
			lblPas.setBounds(10, 118, 34, 14);
			lblPas.setForeground(Color.WHITE);
			lblPas.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return lblPas;
	}
	public JLabel getLblEstado() {
		if (lblEstado == null) {
			lblEstado = new JLabel("Estado");
			lblEstado.setBounds(10, 146, 47, 14);
			lblEstado.setForeground(Color.WHITE);
		}
		return lblEstado;
	}
	public JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(54, 31, 187, 20);
			textField.setColumns(10);
		}
		return textField;
	}
	public JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setBounds(54, 115, 96, 20);
			textField_2.setColumns(10);
		}
		return textField_2;
	}
	public JTextField getTextField_3() {
		if (textField_3 == null) {
			textField_3 = new JTextField();
			textField_3.setBounds(54, 143, 96, 20);
			textField_3.setColumns(10);
		}
		return textField_3;
	}
	public JTextField getTextField_4() {
		if (textField_4 == null) {
			textField_4 = new JTextField();
			textField_4.setBounds(54, 87, 96, 20);
			textField_4.setColumns(10);
		}
		return textField_4;
	}
	public JLabel getLblRua_1() {
		if (lblRua_1 == null) {
			lblRua_1 = new JLabel("Cidade");
			lblRua_1.setBounds(10, 62, 47, 14);
			lblRua_1.setForeground(Color.WHITE);
		}
		return lblRua_1;
	}
	public JTextField getTextField_5() {
		if (textField_5 == null) {
			textField_5 = new JTextField();
			textField_5.setBounds(54, 61, 96, 20);
			textField_5.setColumns(10);
		}
		return textField_5;
	}
	public JPanel getPanelDadosProfissionais() {
		if (panelDadosProfissionais == null) {
			panelDadosProfissionais = new JPanel();
			panelDadosProfissionais.setBorder(new TitledBorder(null, "Dados Profissionais", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
			panelDadosProfissionais.setBackground(new Color(102, 0, 102));
			panelDadosProfissionais.setBounds(10, 227, 384, 174);
			panelDadosProfissionais.setLayout(null);
		}
		return panelDadosProfissionais;
	}
	public JFormattedTextField getFormattedTextFieldSexo() {
		if (formattedTextFieldSexo == null) {
			try {
				formattedTextFieldSexo = new JFormattedTextField(new MaskFormatter("?"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			formattedTextFieldSexo.setBounds(43, 56, 21, 20);
		}
		return formattedTextFieldSexo;
	}
	public JFormattedTextField getFormattedTextFieldDataNasc() {
		if (formattedTextFieldDataNasc == null) {
			try {
				formattedTextFieldDataNasc = new JFormattedTextField(new MaskFormatter("##/##/##"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			formattedTextFieldDataNasc.setBounds(138, 81, 61, 20);
		}
		return formattedTextFieldDataNasc;
	}
	public JFormattedTextField getFormattedTextFieldCPF() {
		if (formattedTextFieldCPF == null) {
			try {
				formattedTextFieldCPF = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			formattedTextFieldCPF.setBounds(271, 56, 96, 20);
		}
		return formattedTextFieldCPF;
	}
	public JFormattedTextField getFormattedTextField() {
		if (formattedTextField == null) {
			try {
				formattedTextField = new JFormattedTextField(new MaskFormatter("#####-###"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			formattedTextField.setBounds(223, 59, 71, 20);
		}
		return formattedTextField;
	}
	public JPanel getPanelSalvar() {
		if (panelSalvar == null) {
			panelSalvar = new JPanel();
			panelSalvar.setBorder(new LineBorder(new Color(204, 51, 204)));
			panelSalvar.setBackground(new Color(102, 0, 102));
			panelSalvar.setBounds(441, 238, 78, 71);
			panelSalvar.setLayout(null);
			panelSalvar.add(getLblNewLabel_1());
		}
		return panelSalvar;
	}
	public JPanel getPanelVoltar() {
		if (panelVoltar == null) {
			panelVoltar = new JPanel();
			panelVoltar.setBorder(new LineBorder(new Color(204, 51, 204)));
			panelVoltar.setBackground(new Color(102, 0, 102));
			panelVoltar.setBounds(552, 238, 78, 71);
			panelVoltar.setLayout(null);
			panelVoltar.add(getLblNewLabel_1_2());
		}
		return panelVoltar;
	}
	public JPanel getPanelLimpar() {
		if (panelLimpar == null) {
			panelLimpar = new JPanel();
			panelLimpar.setBorder(new LineBorder(new Color(204, 51, 204)));
			panelLimpar.setBackground(new Color(102, 0, 102));
			panelLimpar.setBounds(441, 330, 78, 71);
			panelLimpar.setLayout(null);
			panelLimpar.add(getLblNewLabel_1_1());
		}
		return panelLimpar;
	}
	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setBounds(0, 0, 78, 71);
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setIcon(new ImageIcon(PanelInserir.class.getResource("/res/save_40px.png")));
		}
		return lblNewLabel_1;
	}
	public JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("");
			lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1.setIcon(new ImageIcon(PanelInserir.class.getResource("/res/trash_40px.png")));
			lblNewLabel_1_1.setBounds(0, 0, 78, 71);
		}
		return lblNewLabel_1_1;
	}
	public JLabel getLblNewLabel_1_2() {
		if (lblNewLabel_1_2 == null) {
			lblNewLabel_1_2 = new JLabel("");
			lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_2.setIcon(new ImageIcon(PanelInserir.class.getResource("/res/back_40px.png")));
			lblNewLabel_1_2.setBounds(0, 0, 78, 71);
		}
		return lblNewLabel_1_2;
	}
}
