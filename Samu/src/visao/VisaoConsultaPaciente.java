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

import controller.ControladorCadastroPaciente;
//import controller.ControladorCadastroMedico;
import model.Medico;
import model.Paciente;

import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

public class VisaoConsultaPaciente extends JPanel {
	private JComboBox jComboBoxVendedor;
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
	private JTextField jTextFieldFiliacao;
	private Color painelFundo = new Color(185,247,166);
	private JButton jButtonPesquisar;
	private MaskFormatter mascaraCpf;
    private JLabel lblCpf;
    private JTextField jTextFieldTipoSanguineo;
    private JFormattedTextField jFormattedTextFieldCPF;
    private JTextField jTextFieldDataDiagnostico;
    private JTextField jTextFieldDoencaCronica;
    private JComboBox jComboBoxDoenca;
    private JLabel lblPatologia;
    private JButton jButtonPesquisarPatologia;
    private JButton jButtonMedicamento;
    private JButton jButtonImportar;
	
	public VisaoConsultaPaciente() {
		setLayout(null);
		setBackground(painelFundo);
		add(getLblConsultaPaciente());
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
		add(getJTextFieldFiliacao());
		add(getJButtonPesquisar());
		add(getLblCpf());
		add(getJTextFieldTipoSanguineo());
		add(getJFormattedTextfieldCPF());
		add(getJComboBoxPaciente());
		add(getJTextFieldDataDiagnostico());
		add(getJTextFieldDoencaCronica());
		add(getJComboBoxDoenca());
		add(getLblPatologia());
		add(getJButtonPesquisarPatologia());
		add(getJButtonMedicamento());
		add(getJButtonImportar());
	}
	public JLabel getLblConsultaPaciente() {
		if (lblConsultaDeVendedor == null) {
			lblConsultaDeVendedor = new JLabel("Consulta do Paciente");
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
			lblBusca = new JLabel("Busca do Paciente");
			lblBusca.setForeground(Color.BLACK);
			lblBusca.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblBusca.setBounds(776, 85, 122, 13);
		}
		return lblBusca;
	}
	public JTextField getJTextFieldFiliacao() {
		if (jTextFieldFiliacao == null) {
			jTextFieldFiliacao = new JTextField();
			jTextFieldFiliacao.setBackground(Color.WHITE);
			jTextFieldFiliacao.setEditable(false);
			jTextFieldFiliacao.setFont(new Font("Tahoma", Font.PLAIN, 14));
			jTextFieldFiliacao.setColumns(10);
			jTextFieldFiliacao.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Filia\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			jTextFieldFiliacao.setBounds(399, 320, 162, 38);
		}
		return jTextFieldFiliacao;
	}
	
	public JButton getJButtonPesquisar() {
		if (jButtonPesquisar == null) {
			jButtonPesquisar = new JButton("Pesquisar");
			jButtonPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 14));
			jButtonPesquisar.setBounds(776, 199, 107, 21);
		}
		return jButtonPesquisar;
	}
	
	public void limpaCampos () {
		getJTextFieldNome().setText("");
		getJTextFieldCPF().setText("");
		getJTextFieldRG().setText("");
		getJTextFieldTelefone().setText("");
		getJTextFieldCEP().setText("");
		getJTextFieldRua().setText("");
		getJTextFieldBairro().setText("");
		getJTextFieldCidade().setText("");
		getJTextFieldEstado().setText("");
		getJTextFieldNumeroCasa().setText("");
		getJTextFieldComplemento().setText("");
		getJTextFieldSexo().setText("");
		getJTextFieldDataNascimento().setText("");
		getJTextFieldTipoSanguineo().setText("");
		getJTextFieldFiliacao().setText("");
		getJFormattedTextfieldCPF().setText("");
		getJTextFieldDataDiagnostico().setText("");
		getJTextFieldDoencaCronica().setText("");
	}
	public JLabel getLblCpf() {
		if (lblCpf == null) {
			lblCpf = new JLabel("CPF");
			lblCpf.setForeground(Color.BLACK);
			lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblCpf.setBounds(776, 148, 46, 13);
		}
		return lblCpf;
	}
	public JTextField getJTextFieldTipoSanguineo() {
		if (jTextFieldTipoSanguineo == null) {
			jTextFieldTipoSanguineo = new JTextField();
			jTextFieldTipoSanguineo.setFont(new Font("Tahoma", Font.PLAIN, 14));
			jTextFieldTipoSanguineo.setEditable(false);
			jTextFieldTipoSanguineo.setColumns(10);
			jTextFieldTipoSanguineo.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Tipo Sangu\u00EDneo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			jTextFieldTipoSanguineo.setBackground(Color.WHITE);
			jTextFieldTipoSanguineo.setBounds(211, 320, 162, 38);
		}
		return jTextFieldTipoSanguineo;
	}
	//Campo do CPF
    public JFormattedTextField getJFormattedTextfieldCPF () {    
        
        if (jFormattedTextFieldCPF == null) {
        	try {
        		mascaraCpf = new MaskFormatter("###.###.###-##");
        	}
        	catch (Exception e) {
        	}
            jFormattedTextFieldCPF = new JFormattedTextField(mascaraCpf);
            jFormattedTextFieldCPF.setBounds (776, 171, 107, 20);
        }
        return jFormattedTextFieldCPF;
    }
    
    public JComboBox getJComboBoxPaciente() {
		if (jComboBoxVendedor == null) {
			jComboBoxVendedor = new JComboBox();
			jComboBoxVendedor.setFont(new Font("Tahoma", Font.PLAIN, 14));
			jComboBoxVendedor.setBounds(776, 107, 107, 21);
		}
		return jComboBoxVendedor;
	}
    
    public void atualizaComboBoxPaciente () {
		
		getJComboBoxPaciente().removeAllItems();
		getJComboBoxPaciente().addItem("Selecione");
		
		for (Paciente paciente: ControladorCadastroPaciente.listaPaciente) {
			getJComboBoxPaciente().addItem(paciente.getNome());
		}
	}
	public JTextField getJTextFieldDataDiagnostico() {
		if (jTextFieldDataDiagnostico == null) {
			jTextFieldDataDiagnostico = new JTextField();
			jTextFieldDataDiagnostico.setFont(new Font("Tahoma", Font.PLAIN, 14));
			jTextFieldDataDiagnostico.setEditable(false);
			jTextFieldDataDiagnostico.setColumns(10);
			jTextFieldDataDiagnostico.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Data do Diagn\u00F3stico", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			jTextFieldDataDiagnostico.setBackground(Color.WHITE);
			jTextFieldDataDiagnostico.setBounds(23, 374, 162, 38);
		}
		return jTextFieldDataDiagnostico;
	}
	public JTextField getJTextFieldDoencaCronica() {
		if (jTextFieldDoencaCronica == null) {
			jTextFieldDoencaCronica = new JTextField();
			jTextFieldDoencaCronica.setFont(new Font("Tahoma", Font.PLAIN, 14));
			jTextFieldDoencaCronica.setEditable(false);
			jTextFieldDoencaCronica.setColumns(10);
			jTextFieldDoencaCronica.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Doen\u00E7a Cr\u00F4nica", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			jTextFieldDoencaCronica.setBackground(Color.WHITE);
			jTextFieldDoencaCronica.setBounds(211, 374, 162, 38);
		}
		return jTextFieldDoencaCronica;
	}
	public JComboBox getJComboBoxDoenca() {
		if (jComboBoxDoenca == null) {
			jComboBoxDoenca = new JComboBox();
			jComboBoxDoenca.setFont(new Font("Tahoma", Font.PLAIN, 14));
			jComboBoxDoenca.setBounds(399, 387, 107, 21);
			jComboBoxDoenca.addItem("Selecione");
		}
		return jComboBoxDoenca;
	}
	public JLabel getLblPatologia() {
		if (lblPatologia == null) {
			lblPatologia = new JLabel("Patologia");
			lblPatologia.setForeground(Color.BLACK);
			lblPatologia.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblPatologia.setBounds(399, 368, 70, 13);
		}
		return lblPatologia;
	}
	
	 public void atualizaComboBoxPatologia() {
		
		getJComboBoxDoenca().removeAllItems();
		getJComboBoxDoenca().addItem("Selecione");
	}
	public JButton getJButtonPesquisarPatologia() {
		if (jButtonPesquisarPatologia == null) {
			jButtonPesquisarPatologia = new JButton("Pesquisar");
			jButtonPesquisarPatologia.setFont(new Font("Tahoma", Font.PLAIN, 14));
			jButtonPesquisarPatologia.setBounds(399, 418, 107, 21);
		}
		return jButtonPesquisarPatologia;
	}
	public JButton getJButtonMedicamento() {
		if (jButtonMedicamento == null) {
			jButtonMedicamento = new JButton("Medicamento");
			jButtonMedicamento.setFont(new Font("Tahoma", Font.PLAIN, 14));
			jButtonMedicamento.setBounds(540, 387, 127, 21);
		}
		return jButtonMedicamento;
	}
	public JButton getJButtonImportar() {
		if (jButtonImportar == null) {
			jButtonImportar = new JButton("Importar");
			jButtonImportar.setFont(new Font("Tahoma", Font.PLAIN, 14));
			jButtonImportar.setBounds(776, 237, 107, 21);
		}
		return jButtonImportar;
	}
}
