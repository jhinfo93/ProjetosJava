/*
 * Autor - Francisco Anacreonte, Marcus, Raul Gonçalves, Saullo Benevides
 * 2019
 */
package visao;

import java.awt.Color;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.text.MaskFormatter;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;

public class VisaoMedicamento extends JPanel {
    	
    private JTextField jTextFieldNomeMedicamento;
    private JLabel labelNome;
    private JFormattedTextField jFormattedTextFieldCPF;
    private MaskFormatter mascaraCpf;
    private MaskFormatter mascaraDataNascimento;
    private JLabel labelDataNascimento;
    private JLabel labelSessao;
    
    private Color painelFundo = new Color (185,247,166);
    private Font fonte = new Font("Serif", Font.BOLD, 20);
    private JLabel labelRg;
    private JComboBox jComboBoxIndicacaoMendicamento;
    private JButton jButtonEncerrar;
    private JButton jButtonAdicionar;
    private JTextField jTextFieldPaciente;
    private JLabel lblPaciente;
    private JLabel lblCpf;
    private JTextField jTextFieldTipoMedicamento;
    private JLabel lblGerarPatologias;
    private JButton jButtonPesquisaPatologia;
    
    public VisaoMedicamento () {
    
        this.setVisible(true);               
        this.setLayout(null);
        this.add(getJLabelSessao ());
        this.add(getJTextfieldNomeMedicamento());
        this.add(getJLabelNome());
        this.add(getJLabelDataNascimento());
        this.setBackground(painelFundo);
        add(getLabelRg());
        add(getJComboBoxIndicacaoMendicamento());
        add(getJButtonEncerrar());
        add(getJButtonAdicionar());
        add(getJTextFieldPaciente());
        add(getLblPaciente());
        add(getJFormattedTextfieldCPF());
        add(getLblCpf());
        add(getJTextFieldTipoMedicamento());
        add(getLblGerarPatologias());
        add(getJButtonPesquisaPatologia());
    }
    
    //JLabel e JTextfield
    public JLabel getJLabelSessao ( ) {
    	
    	if (labelSessao == null) {
    		
    		labelSessao = new JLabel ("Medicamento");
    		labelSessao.setBounds(30, 10, 210, 20);
    		labelSessao.setForeground(Color.black);
    		labelSessao.setFont(fonte);
    	}   	
    	return labelSessao;
    } 
  
    //Campo do Nome
    public JTextField getJTextfieldNomeMedicamento () {    
        
        if (jTextFieldNomeMedicamento == null) {
         
            jTextFieldNomeMedicamento = new JTextField();
            jTextFieldNomeMedicamento.setBounds (20, 70, 180, 20);
        }
        return jTextFieldNomeMedicamento;
    }
    
    public JLabel getJLabelNome() {    
        
        if (labelNome == null) {
       
           labelNome = new JLabel("Nome do Medicamento");
           labelNome.setBounds (20, 50, 140, 20);
           labelNome.setForeground(Color.black);
        }
        return labelNome;
    }
    
    public JLabel getJLabelDataNascimento () {    
        
        if (labelDataNascimento == null) {
       
           labelDataNascimento = new JLabel("Tipo");
           labelDataNascimento.setBounds (20, 100, 140, 20);
           labelDataNascimento.setForeground(Color.black);
        }
        return labelDataNascimento;
    }
	public JLabel getLabelRg() {
		if (labelRg == null) {
			labelRg = new JLabel("Indica\u00E7\u00E3o");
			labelRg.setForeground(Color.BLACK);
			labelRg.setBounds(20, 150, 140, 20);
		}
		return labelRg;
	}
	public JComboBox getJComboBoxIndicacaoMendicamento() {
		if (jComboBoxIndicacaoMendicamento == null) {
			jComboBoxIndicacaoMendicamento = new JComboBox();
			jComboBoxIndicacaoMendicamento.setFont(new Font("Tahoma", Font.PLAIN, 14));
			jComboBoxIndicacaoMendicamento.setBounds(20, 169, 90, 21);
			jComboBoxIndicacaoMendicamento.addItem("Selecione");
		}
		return jComboBoxIndicacaoMendicamento;
	}
	public JButton getJButtonEncerrar() {
		if (jButtonEncerrar == null) {
			jButtonEncerrar = new JButton("Encerrar");
			jButtonEncerrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
			jButtonEncerrar.setBounds(20, 448, 85, 21);
		}
		return jButtonEncerrar;
	}
	public JButton getJButtonAdicionar() {
		if (jButtonAdicionar == null) {
			jButtonAdicionar = new JButton("Adicionar");
			jButtonAdicionar.setFont(new Font("Tahoma", Font.PLAIN, 14));
			jButtonAdicionar.setBounds(125, 448, 108, 21);
		}
		return jButtonAdicionar;
	}
	public JTextField getJTextFieldPaciente() {
		if (jTextFieldPaciente == null) {
			jTextFieldPaciente = new JTextField();
			jTextFieldPaciente.setBounds(252, 70, 180, 20);
		}
		return jTextFieldPaciente;
	}
	public JLabel getLblPaciente() {
		if (lblPaciente == null) {
			lblPaciente = new JLabel("Paciente");
			lblPaciente.setForeground(Color.BLACK);
			lblPaciente.setBounds(252, 50, 140, 20);
		}
		return lblPaciente;
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
            jFormattedTextFieldCPF.setBounds (252, 118, 180, 20);
        }
        return jFormattedTextFieldCPF;
    }
	public JLabel getLblCpf() {
		if (lblCpf == null) {
			lblCpf = new JLabel("CPF");
			lblCpf.setForeground(Color.BLACK);
			lblCpf.setBounds(252, 100, 140, 20);
		}
		return lblCpf;
	}
	
	public void limpaCampos () {
		getJTextfieldNomeMedicamento().setText("");
		getJTextFieldPaciente().setText("");
		getJFormattedTextfieldCPF().setText("");
		getJTextFieldTipoMedicamento().setText("");
	}
	public JTextField getJTextFieldTipoMedicamento() {
		if (jTextFieldTipoMedicamento == null) {
			jTextFieldTipoMedicamento = new JTextField();
			jTextFieldTipoMedicamento.setBounds(20, 120, 180, 20);
		}
		return jTextFieldTipoMedicamento;
	}
	public JLabel getLblGerarPatologias() {
		if (lblGerarPatologias == null) {
			lblGerarPatologias = new JLabel("Gerar Patologias");
			lblGerarPatologias.setForeground(Color.BLACK);
			lblGerarPatologias.setBounds(252, 150, 140, 20);
		}
		return lblGerarPatologias;
	}
	public JButton getJButtonPesquisaPatologia() {
		if (jButtonPesquisaPatologia == null) {
			jButtonPesquisaPatologia = new JButton("Pesquisar");
			jButtonPesquisaPatologia.setFont(new Font("Tahoma", Font.PLAIN, 14));
			jButtonPesquisaPatologia.setBounds(252, 171, 97, 21);
		}
		return jButtonPesquisaPatologia;
	}
	
	public void atualizaComboBoxTipoSanguineo () {
		
		getJComboBoxIndicacaoMendicamento().removeAllItems();
		getJComboBoxIndicacaoMendicamento().addItem("Selecione");
	}
}