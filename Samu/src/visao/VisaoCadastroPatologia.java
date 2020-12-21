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

public class VisaoCadastroPatologia extends JPanel {
    	
    private JTextField jTextFieldDoenca;
    private JLabel labelNome;
    private JFormattedTextField jFormattedTextFieldCPF;
    private MaskFormatter mascaraCpf;
    private MaskFormatter mascaraDataNascimento;
    private JFormattedTextField jFormattedTextFieldDataDiagnostico;
    private JLabel labelDataNascimento;
    private JLabel labelSessao;
    
    private Color painelFundo = new Color (185,247,166);
    private Font fonte = new Font("Serif", Font.BOLD, 20);
    private JLabel labelRg;
    private JComboBox jComboBoxDoencaCronica;
    private JButton jButtonEncerrar;
    private JButton jButtonAdicionar;
    private JTextField jTextFieldPaciente;
    private JLabel lblPaciente;
    private JLabel lblCpf;
    
    public VisaoCadastroPatologia () {
    
        this.setVisible(true);               
        this.setLayout(null);
        this.add(getJLabelSessao ());
        //Buttons e Imagens
        this.add(getJTextfieldDoenca());
        this.add(getJLabelNome());
        this.add(getJFormattedTextfieldDataDiagnostico());
        this.add(getJLabelDataNascimento());
        this.setBackground(painelFundo);
        add(getLabelRg());
        add(getJComboBoxDoencaCronica());
        add(getJButtonEncerrar());
        add(getJButtonAdicionar());
        add(getJTextFieldPaciente());
        add(getLblPaciente());
        add(getJFormattedTextfieldCPF());
        add(getLblCpf());
    }
    
    //JLabel e JTextfield
    public JLabel getJLabelSessao ( ) {
    	
    	if (labelSessao == null) {
    		
    		labelSessao = new JLabel ("Patologia do Paciente");
    		labelSessao.setBounds(30, 10, 210, 20);
    		labelSessao.setForeground(Color.black);
    		labelSessao.setFont(fonte);
    	}   	
    	return labelSessao;
    } 
  
    //Campo do Nome
    public JTextField getJTextfieldDoenca () {    
        
        if (jTextFieldDoenca == null) {
         
            jTextFieldDoenca = new JTextField();
            jTextFieldDoenca.setBounds (20, 70, 180, 20);
        }
        return jTextFieldDoenca;
    }
    
    public JLabel getJLabelNome() {    
        
        if (labelNome == null) {
       
           labelNome = new JLabel("Doen\u00E7a");
           labelNome.setBounds (20, 50, 140, 20);
           labelNome.setForeground(Color.black);
        }
        return labelNome;
    }
    
    //Campo da Data de Nascimento
    public JFormattedTextField getJFormattedTextfieldDataDiagnostico () {    
        
        if (jFormattedTextFieldDataDiagnostico == null) {
        	try {
    	    	mascaraDataNascimento = new MaskFormatter ("##/##/####");
    	    }
    	    catch (ParseException e) {
    	    }
        	jFormattedTextFieldDataDiagnostico = new JFormattedTextField(mascaraDataNascimento);
        	jFormattedTextFieldDataDiagnostico.setBounds (20, 118, 180, 20);
        }
        return jFormattedTextFieldDataDiagnostico;
    }
    
    public JLabel getJLabelDataNascimento () {    
        
        if (labelDataNascimento == null) {
       
           labelDataNascimento = new JLabel("Data do Diagn\u00F3stico");
           labelDataNascimento.setBounds (20, 100, 140, 20);
           labelDataNascimento.setForeground(Color.black);
        }
        return labelDataNascimento;
    }
	public JLabel getLabelRg() {
		if (labelRg == null) {
			labelRg = new JLabel("Doen\u00E7a Cr\u00F4nica");
			labelRg.setForeground(Color.BLACK);
			labelRg.setBounds(20, 150, 140, 20);
		}
		return labelRg;
	}
	public JComboBox getJComboBoxDoencaCronica() {
		if (jComboBoxDoencaCronica == null) {
			jComboBoxDoencaCronica = new JComboBox();
			jComboBoxDoencaCronica.setBounds(20, 169, 90, 21);
			jComboBoxDoencaCronica.addItem("Não");
			jComboBoxDoencaCronica.addItem("Sim");
		}
		return jComboBoxDoencaCronica;
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
		getJTextfieldDoenca().setText("");
		getJTextFieldPaciente().setText("");
		getJFormattedTextfieldCPF().setText("");
		getJFormattedTextfieldDataDiagnostico().setText("");
	}
}