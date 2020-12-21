/*
 * Autor - Francisco Anacreonte, Marcus, Raul Gonçalves e Saullo Benevides
 * 2019
 */
package visao;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

//import controller.ControladorCadastroMedico;
import model.Medico;

import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

public class VisaoConsultaMedico extends JPanel {
	private JComboBox jComboBoxMedico;
	private JLabel lblConsultaDeVendedor;
	private JTextField jTextFieldNome;
	private JTextField jTextFieldCPF;
	private JTextField jTextFieldRG;
	private JTextField jTextFieldRua;
	private JTextField jTextFieldCEP;
	private JTextField jTextFieldCidade;
	private JTextField jTextFieldComplemento;
	private JTextField jTextFieldSexo;
	private JTextField jTextFieldDataNascimento;
	private JTextField jTextFieldTelefone;
	private JTextField jTextFieldBairro;
	private JTextField jTextFieldNumeroCasa;
	private JTextField jTextFieldEstado;
	private JLabel lblBusca;
	private JTextField jTextFieldEspecialidade;
	private JTextField jTextFieldAreaAtuacao;
	private Color painelFundo = new Color(185,247,166);
	private JButton jButtonPesquisar;
	private JTextField jTextFieldCRM;
	private MaskFormatter mascaraCpf;
    private JLabel lblCpf;
    private JFormattedTextField jformattedTextFieldCRM;
    private MaskFormatter mascaraCRM;
    private JButton jButtonImportar;
	
	public VisaoConsultaMedico() {
		setLayout(null);
		setBackground(painelFundo);
		add(getJComboBoxMedico());
		add(getLblConsultaDeVendedor());
		add(getJTextFieldNome());
		add(getJTextFieldCPF());
		add(getJTextFieldRG());
		add(getJTextFieldRua());
		add(getJTextFieldCEP());
		add(getJTextFieldCidade());
		add(getJTextFieldComplemento());
		add(getJTextFieldSexo());
		add(getJTextFieldDataNascimento());
		add(getJTextFieldTelefone());
		add(getJTextFieldBairro());
		add(getJTextFieldNumeroCasa());
		add(getJTextFieldEstado());
		add(getLblBusca());
		add(getJTextFieldEspecialidade());
		add(getJTextFieldAreaAtuacao());
		add(getJButtonPesquisar());
		add(getJTextFieldCRM());
		add(getLblCpf());
		add(getFormattedTextFieldCRM());
		add(getJButtonImportar());
	}
	public JComboBox getJComboBoxMedico() {
		if (jComboBoxMedico == null) {
			jComboBoxMedico = new JComboBox();
			jComboBoxMedico.setFont(new Font("Tahoma", Font.PLAIN, 14));
			jComboBoxMedico.setBounds(638, 107, 107, 21);
		}
		return jComboBoxMedico;
	}
	public JLabel getLblConsultaDeVendedor() {
		if (lblConsultaDeVendedor == null) {
			lblConsultaDeVendedor = new JLabel("Consulta do M\u00E9dico");
			lblConsultaDeVendedor.setForeground(Color.BLACK);
			lblConsultaDeVendedor.setFont(new Font("Serif", Font.BOLD, 20));
			lblConsultaDeVendedor.setBounds(164, 30, 209, 21);
		}
		return lblConsultaDeVendedor;
	}
	public JTextField getJTextFieldNome() {
		if (jTextFieldNome == null) {
			jTextFieldNome = new JTextField();
			jTextFieldNome.setBackground(Color.WHITE);
			jTextFieldNome.setEditable(false);
			jTextFieldNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
			jTextFieldNome.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Nome", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			jTextFieldNome.setBounds(23, 107, 162, 38);
			jTextFieldNome.setColumns(10);
		}
		return jTextFieldNome;
	}
	public JTextField getJTextFieldCPF() {
		if (jTextFieldCPF == null) {
			jTextFieldCPF = new JTextField();
			jTextFieldCPF.setBackground(Color.WHITE);
			jTextFieldCPF.setEditable(false);
			jTextFieldCPF.setFont(new Font("Tahoma", Font.PLAIN, 14));
			jTextFieldCPF.setColumns(10);
			jTextFieldCPF.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "CPF", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			jTextFieldCPF.setBounds(211, 107, 162, 38);
		}
		return jTextFieldCPF;
	}
	public JTextField getJTextFieldRG() {
		if (jTextFieldRG == null) {
			jTextFieldRG = new JTextField();
			jTextFieldRG.setBackground(Color.WHITE);
			jTextFieldRG.setEditable(false);
			jTextFieldRG.setFont(new Font("Tahoma", Font.PLAIN, 14));
			jTextFieldRG.setColumns(10);
			jTextFieldRG.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "RG", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			jTextFieldRG.setBounds(399, 107, 162, 38);
		}
		return jTextFieldRG;
	}
	public JTextField getJTextFieldRua() {
		if (jTextFieldRua == null) {
			jTextFieldRua = new JTextField();
			jTextFieldRua.setBackground(Color.WHITE);
			jTextFieldRua.setEditable(false);
			jTextFieldRua.setFont(new Font("Tahoma", Font.PLAIN, 14));
			jTextFieldRua.setColumns(10);
			jTextFieldRua.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Rua", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			jTextFieldRua.setBounds(399, 155, 162, 38);
		}
		return jTextFieldRua;
	}
	public JTextField getJTextFieldCEP() {
		if (jTextFieldCEP == null) {
			jTextFieldCEP = new JTextField();
			jTextFieldCEP.setBackground(Color.WHITE);
			jTextFieldCEP.setEditable(false);
			jTextFieldCEP.setFont(new Font("Tahoma", Font.PLAIN, 14));
			jTextFieldCEP.setColumns(10);
			jTextFieldCEP.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "CEP", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			jTextFieldCEP.setBounds(211, 155, 162, 38);
		}
		return jTextFieldCEP;
	}
	public JTextField getJTextFieldCidade() {
		if (jTextFieldCidade == null) {
			jTextFieldCidade = new JTextField();
			jTextFieldCidade.setBackground(Color.WHITE);
			jTextFieldCidade.setEditable(false);
			jTextFieldCidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
			jTextFieldCidade.setColumns(10);
			jTextFieldCidade.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Cidade", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			jTextFieldCidade.setBounds(211, 210, 162, 38);
		}
		return jTextFieldCidade;
	}
	public JTextField getJTextFieldComplemento() {
		if (jTextFieldComplemento == null) {
			jTextFieldComplemento = new JTextField();
			jTextFieldComplemento.setBackground(Color.WHITE);
			jTextFieldComplemento.setEditable(false);
			jTextFieldComplemento.setFont(new Font("Tahoma", Font.PLAIN, 14));
			jTextFieldComplemento.setColumns(10);
			jTextFieldComplemento.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Complemento", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			jTextFieldComplemento.setBounds(211, 272, 162, 38);
		}
		return jTextFieldComplemento;
	}
	public JTextField getJTextFieldSexo() {
		if (jTextFieldSexo == null) {
			jTextFieldSexo = new JTextField();
			jTextFieldSexo.setBackground(Color.WHITE);
			jTextFieldSexo.setEditable(false);
			jTextFieldSexo.setFont(new Font("Tahoma", Font.PLAIN, 14));
			jTextFieldSexo.setColumns(10);
			jTextFieldSexo.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Sexo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			jTextFieldSexo.setBounds(399, 272, 162, 38);
		}
		return jTextFieldSexo;
	}
	public JTextField getJTextFieldDataNascimento() {
		if (jTextFieldDataNascimento == null) {
			jTextFieldDataNascimento = new JTextField();
			jTextFieldDataNascimento.setBackground(Color.WHITE);
			jTextFieldDataNascimento.setEditable(false);
			jTextFieldDataNascimento.setFont(new Font("Tahoma", Font.PLAIN, 14));
			jTextFieldDataNascimento.setColumns(10);
			jTextFieldDataNascimento.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Data de Nascimento", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			jTextFieldDataNascimento.setBounds(23, 320, 162, 38);
		}
		return jTextFieldDataNascimento;
	}
	public JTextField getJTextFieldTelefone() {
		if (jTextFieldTelefone == null) {
			jTextFieldTelefone = new JTextField();
			jTextFieldTelefone.setBackground(Color.WHITE);
			jTextFieldTelefone.setEditable(false);
			jTextFieldTelefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
			jTextFieldTelefone.setColumns(10);
			jTextFieldTelefone.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Telefone", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			jTextFieldTelefone.setBounds(23, 155, 162, 38);
		}
		return jTextFieldTelefone;
	}
	public JTextField getJTextFieldBairro() {
		if (jTextFieldBairro == null) {
			jTextFieldBairro = new JTextField();
			jTextFieldBairro.setBackground(Color.WHITE);
			jTextFieldBairro.setEditable(false);
			jTextFieldBairro.setFont(new Font("Tahoma", Font.PLAIN, 14));
			jTextFieldBairro.setColumns(10);
			jTextFieldBairro.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Bairro", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			jTextFieldBairro.setBounds(23, 210, 162, 38);
		}
		return jTextFieldBairro;
	}
	public JTextField getJTextFieldNumeroCasa() {
		if (jTextFieldNumeroCasa == null) {
			jTextFieldNumeroCasa = new JTextField();
			jTextFieldNumeroCasa.setBackground(Color.WHITE);
			jTextFieldNumeroCasa.setEditable(false);
			jTextFieldNumeroCasa.setFont(new Font("Tahoma", Font.PLAIN, 14));
			jTextFieldNumeroCasa.setColumns(10);
			jTextFieldNumeroCasa.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "N\u00B0 da Casa", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			jTextFieldNumeroCasa.setBounds(23, 272, 162, 38);
		}
		return jTextFieldNumeroCasa;
	}
	public JTextField getJTextFieldEstado() {
		if (jTextFieldEstado == null) {
			jTextFieldEstado = new JTextField();
			jTextFieldEstado.setEditable(false);
			jTextFieldEstado.setBackground(Color.WHITE);
			jTextFieldEstado.setFont(new Font("Tahoma", Font.PLAIN, 14));
			jTextFieldEstado.setColumns(10);
			jTextFieldEstado.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Estado", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			jTextFieldEstado.setBounds(399, 210, 162, 38);
		}
		return jTextFieldEstado;
	}
	
	public JLabel getLblBusca() {
		if (lblBusca == null) {
			lblBusca = new JLabel("Busca do M\u00E9dico");
			lblBusca.setForeground(Color.BLACK);
			lblBusca.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblBusca.setBounds(638, 83, 122, 13);
		}
		return lblBusca;
	}
	public JTextField getJTextFieldEspecialidade() {
		if (jTextFieldEspecialidade == null) {
			jTextFieldEspecialidade = new JTextField();
			jTextFieldEspecialidade.setBackground(Color.WHITE);
			jTextFieldEspecialidade.setEditable(false);
			jTextFieldEspecialidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
			jTextFieldEspecialidade.setColumns(10);
			jTextFieldEspecialidade.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Especialidade", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			jTextFieldEspecialidade.setBounds(211, 320, 162, 38);
		}
		return jTextFieldEspecialidade;
	}
	public JTextField getJTextFieldAreaAtuacao() {
		if (jTextFieldAreaAtuacao == null) {
			jTextFieldAreaAtuacao = new JTextField();
			jTextFieldAreaAtuacao.setBackground(Color.WHITE);
			jTextFieldAreaAtuacao.setEditable(false);
			jTextFieldAreaAtuacao.setFont(new Font("Tahoma", Font.PLAIN, 14));
			jTextFieldAreaAtuacao.setColumns(10);
			jTextFieldAreaAtuacao.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u00C1rea de Atua\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			jTextFieldAreaAtuacao.setBounds(399, 320, 162, 38);
		}
		return jTextFieldAreaAtuacao;
	}
	
	public void atualizaComboBoxMedico () {
		
		getJComboBoxMedico().removeAllItems();
		getJComboBoxMedico().addItem("Selecione");
		
		for (Medico medico: controller.ControladorCadastroMedico.listaMedico) {
			getJComboBoxMedico().addItem(medico.getNome());
		}
	}
	
	public JButton getJButtonPesquisar() {
		if (jButtonPesquisar == null) {
			jButtonPesquisar = new JButton("Pesquisar");
			jButtonPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 14));
			jButtonPesquisar.setBounds(638, 205, 107, 21);
		}
		return jButtonPesquisar;
	}
	
	public void limpaCampos () {
		getJTextFieldNome().setText("");
		getJTextFieldBairro().setText("");
		getJTextFieldRua().setText("");
		getJTextFieldCEP().setText("");
		getJTextFieldCidade().setText("");
		getJTextFieldComplemento().setText("");
		getJTextFieldEstado().setText("");
		getJTextFieldTelefone().setText("");
		getJTextFieldCPF().setText("");
		getJTextFieldRG().setText("");
		getJTextFieldSexo().setText("");
		getJTextFieldEspecialidade().setText("");
		getJTextFieldAreaAtuacao().setText("");
		getJTextFieldNumeroCasa().setText("");
		getJTextFieldCRM().setText("");
		getFormattedTextFieldCRM().setText("");
	}
	public JTextField getJTextFieldCRM() {
		if (jTextFieldCRM == null) {
			jTextFieldCRM = new JTextField();
			jTextFieldCRM.setFont(new Font("Tahoma", Font.PLAIN, 14));
			jTextFieldCRM.setEditable(false);
			jTextFieldCRM.setColumns(10);
			jTextFieldCRM.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "CRM", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			jTextFieldCRM.setBackground(Color.WHITE);
			jTextFieldCRM.setBounds(23, 368, 162, 38);
		}
		return jTextFieldCRM;
	}
	public JLabel getLblCpf() {
		if (lblCpf == null) {
			lblCpf = new JLabel("CRM");
			lblCpf.setForeground(Color.BLACK);
			lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblCpf.setBounds(638, 148, 46, 13);
		}
		return lblCpf;
	}

	public JFormattedTextField getFormattedTextFieldCRM() {
		if (jformattedTextFieldCRM == null) {
			try {
				mascaraCRM = new MaskFormatter("#######");
			} catch (Exception e) {
			}
			jformattedTextFieldCRM = new JFormattedTextField(mascaraCRM);
			jformattedTextFieldCRM.setBounds(638, 171, 85, 20);
		}
		return jformattedTextFieldCRM;
	}
	public JButton getJButtonImportar() {
		if (jButtonImportar == null) {
			jButtonImportar = new JButton("Importar");
			jButtonImportar.setFont(new Font("Tahoma", Font.PLAIN, 14));
			jButtonImportar.setBounds(638, 236, 107, 21);
		}
		return jButtonImportar;
	}
}
