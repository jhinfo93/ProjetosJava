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
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.text.MaskFormatter;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;

public class VisaoCadastroMedico extends JPanel {
    private ButtonGroup grupoSexo = new ButtonGroup();
    	
    private JTextField nome;
    private JLabel labelNome;
    private MaskFormatter mascaraCpf;
    private JFormattedTextField jFormattedTextFieldCpf;
    private JLabel labelCpf;
    private MaskFormatter mascaraDataNascimento;
    private JFormattedTextField jFormattedTextFieldDataNascimento;
    private JLabel labelDataNascimento;
    private MaskFormatter mascaraTelefone;
    private JFormattedTextField jFormattedTextFieldTelefone;
    private JLabel labelTelefone;
    private JTextField jTextFieldRua;
    private JLabel labelRua;
    private JTextField jTextFieldBairro;
    private JLabel labelBairro;
    private JTextField jTextFieldNumeroCasa;
    private JLabel labelNumeroCasa;
    private MaskFormatter mascaraCep;
    private JFormattedTextField jFormattedTextFieldCep;
    private JLabel labelCep;
    private JLabel labelSexo;
    private JLabel labelSessao;
    
    private Color painelFundo = new Color (185,247,166);
    private Font fonte = new Font("Serif", Font.BOLD, 20);
    private JTextField jTextFieldEstado;
    private JLabel labelCidade;
    private JTextField jTextFieldCidade;
    private JLabel labelComplemento;
    private JTextField jTextFieldComplemento;
    private MaskFormatter mascaraRg;
    private JFormattedTextField jFormattedTextFieldRg;
    private JLabel labelRg;
    private JComboBox jComboBoxSexo;
    private JTextField jTextFieldAreaAtuacao;
    private JTextField jTextFieldEspecialidade;
    private JLabel lblEspecialidade;
    private JLabel lblreaDeAtuao;
    private JLabel lblCrm;
    private JFormattedTextField jFormattedTextFieldCRM;
    private MaskFormatter mascaraCRM;
    private JButton jButtonVoltar;
    private JButton jButtonCadastrar;
    
    public VisaoCadastroMedico () {
    
        this.setVisible(true);               
        this.setLayout(null);
        this.add(getJLabelSessao ());
        //Buttons e Imagens
        this.add(getJTextfieldNome());
        this.add(getJLabelNome());
        this.add(getJLabelSexo());
        this.add(getJFormattedTextfieldCpf ());
        this.add(getJLabelCpf());
        this.add(getJFormattedTextfieldDataNascimento ());
        this.add(getJLabelDataNascimento());
        this.add(getJFormattedTextfieldTelefone ());
        this.add(getJLabelTelefone ());
        this.add(getJTextfieldRua ());
        this.add(getJLabelRua ());
        this.add(getJTextfieldBairro ());
        this.add(getJLabelBairro ());
        this.add(getJTextfieldNumeroCasa ());
        this.add(getJLabelNumeroCasa ());
        this.add(getJFormattedTextfieldCep ());
        this.add(getJLabelCep ());
        this.setBackground(painelFundo);
        
        JLabel labelEstado = new JLabel("Estado");
        labelEstado.setForeground(Color.BLACK);
        labelEstado.setBounds(250, 300, 140, 20);
        add(labelEstado);
        add(getJTextFieldEstado());
        add(getLabelCidade());
        add(getJTextFieldCidade());
        add(getLabelComplemento());
        add(getJTextFieldComplemento());
        add(getJFormattedTextFieldRg());
        add(getLabelRg());
        add(getJComboBoxSexo());
        add(getJTextFieldAreaAtuacao());
        add(getJTextFieldEspecialidade());
        add(getLblEspecialidade());
        add(getLblreaDeAtuao());
        add(getLblCrm());
        add(getJFormattedTextFieldCRM());
        add(getJButtonVoltar());
        add(getJButtonCadastrar());
    }
    
    public VisaoCadastroMedico getVisaoRegistroVendedor() {  
        return this;
    }

    //JLabel e JTextfield
    public JLabel getJLabelSessao ( ) {
    	
    	if (labelSessao == null) {
    		
    		labelSessao = new JLabel ("Cadastro do M\u00E9dico");
    		labelSessao.setBounds(30, 10, 210, 20);
    		labelSessao.setForeground(Color.black);
    		labelSessao.setFont(fonte);
    	}   	
    	return labelSessao;
    } 
  
    //Campo do Nome
    public JTextField getJTextfieldNome () {    
        
        if (nome == null) {
         
            nome = new JTextField();
            nome.setBounds (20, 70, 180, 20);
        }
        return nome;
    }
    
    public JLabel getJLabelNome() {    
        
        if (labelNome == null) {
       
           labelNome = new JLabel("Nome");
           labelNome.setBounds (20, 50, 140, 20);
           labelNome.setForeground(Color.black);
        }
        return labelNome;
    }
    
    //Campo do Sexo
    public JLabel getJLabelSexo() {    
        
        if (labelSexo == null) {
       
           labelSexo = new JLabel("Sexo");
           labelSexo.setBounds (250, 50, 140, 20);
           labelSexo.setForeground(Color.BLACK);
        }
        return labelSexo;
    }
    
    //Campo do CPF
    public JFormattedTextField getJFormattedTextfieldCpf () {    
        
        if (jFormattedTextFieldCpf == null) {
        	try {
        		mascaraCpf = new MaskFormatter("###.###.###-##");
        	}
        	catch (Exception e) {
        	}
            jFormattedTextFieldCpf = new JFormattedTextField(mascaraCpf);
            jFormattedTextFieldCpf.setBounds (20, 120, 180, 20);
        }
        return jFormattedTextFieldCpf;
    }
    
    public JLabel getJLabelCpf () {    
        
        if (labelCpf == null) {
       
           labelCpf = new JLabel("CPF");
           labelCpf.setBounds (20, 100, 140, 20);
           labelCpf.setForeground(Color.black);
        }
        return labelCpf;
    }
    
    //Campo da Data de Nascimento
    public JFormattedTextField getJFormattedTextfieldDataNascimento () {    
        
        if (jFormattedTextFieldDataNascimento == null) {
        	try {
    	    	mascaraDataNascimento = new MaskFormatter ("##/##/####");
    	    }
    	    catch (ParseException e) {
    	    }
        	jFormattedTextFieldDataNascimento = new JFormattedTextField(mascaraDataNascimento);
        	jFormattedTextFieldDataNascimento.setBounds (250, 120, 180, 20);
        //	mfDataNascimento.setValidCharacters("0123456789");
        //	dataNascimento.setColumns(6);
        }
        return jFormattedTextFieldDataNascimento;
    }
    
    public JLabel getJLabelDataNascimento () {    
        
        if (labelDataNascimento == null) {
       
           labelDataNascimento = new JLabel("Data de Nascimento");
           labelDataNascimento.setBounds (250, 100, 140, 20);
           labelDataNascimento.setForeground(Color.black);
        }
        return labelDataNascimento;
    }
    
    //Campo do Telefone
    public JFormattedTextField getJFormattedTextfieldTelefone () {    
        
        if (jFormattedTextFieldTelefone == null) {
        	try {
    	    	mascaraTelefone = new MaskFormatter ("(##) #####-####");
    	    }
    	    catch (ParseException e) {
    	    }
        	jFormattedTextFieldTelefone = new JFormattedTextField(mascaraTelefone);
        	jFormattedTextFieldTelefone.setBounds (250, 170, 180, 20);
        }
        return jFormattedTextFieldTelefone;
    }
    
    public JLabel getJLabelTelefone () {    
        
        if (labelTelefone == null) {
       
           labelTelefone = new JLabel("Telefone");
           labelTelefone.setBounds (250, 150, 140, 20);
           labelTelefone.setForeground(Color.black);
        }
        return labelTelefone;
    }
    
    //Campo da Rua
    public JTextField getJTextfieldRua () {    
        
        if (jTextFieldRua == null) {
         
        	jTextFieldRua = new JTextField();
        	jTextFieldRua.setBounds (20, 220, 180, 20);
        }
        return jTextFieldRua;
    }
    
    public JLabel getJLabelRua () {    
        
        if (labelRua == null) {
       
           labelRua = new JLabel("Rua");
           labelRua.setBounds (20, 200, 140, 20);
           labelRua.setForeground(Color.black);
        }
        return labelRua;
    }
    
    //Campo do Bairro
    public JTextField getJTextfieldBairro () {    
        
        if (jTextFieldBairro == null) {
         
        	jTextFieldBairro = new JTextField();
        	jTextFieldBairro.setBounds (250, 220, 180, 20);
        }
        return jTextFieldBairro;
    }
    
    public JLabel getJLabelBairro () {    
        
        if (labelBairro == null) {
       
           labelBairro = new JLabel("Bairro");
           labelBairro.setBounds (250, 200, 140, 20);
           labelBairro.setForeground(Color.black);
        }
        return labelBairro;
    }
    
    //Campo do número da casa
    public JTextField getJTextfieldNumeroCasa () {    
        
        if (jTextFieldNumeroCasa == null) {
         
        	jTextFieldNumeroCasa = new JTextField();
        	jTextFieldNumeroCasa.setBounds (250, 270, 50, 20);
        }
        return jTextFieldNumeroCasa;
    }
    
    public JLabel getJLabelNumeroCasa () {    
        
        if (labelNumeroCasa == null) {
       
           labelNumeroCasa = new JLabel("Número da casa");
           labelNumeroCasa.setBounds (250, 250, 180, 20);
           labelNumeroCasa.setForeground(Color.black);
        }
        return labelNumeroCasa;
    }
    
    //Campo do Cep
    public JFormattedTextField getJFormattedTextfieldCep () {    
        
        if (jFormattedTextFieldCep == null) {
        	try {
    	    	mascaraCep = new MaskFormatter ("#####-###");
    	    }
    	    catch (ParseException e) {
    	    }
        	jFormattedTextFieldCep = new JFormattedTextField(mascaraCep);
        	jFormattedTextFieldCep.setBounds (20, 270, 180, 20);
        }
        return jFormattedTextFieldCep;
    }
    
    public JLabel getJLabelCep () {    
        
        if (labelCep == null) {
       
           labelCep = new JLabel("CEP");
           labelCep.setBounds (20, 250, 140, 20);
           labelCep.setForeground(Color.black);
        }
        return labelCep;
    }
    
    //Campo do Estado
    public JTextField getJTextFieldEstado() {
		if (jTextFieldEstado == null) {
			jTextFieldEstado = new JTextField();
			jTextFieldEstado.setBounds(250, 320, 180, 20);
		}
		return jTextFieldEstado;
	}
	
    public JLabel getLabelCidade() {
		if (labelCidade == null) {
			labelCidade = new JLabel("Cidade");
			labelCidade.setForeground(Color.BLACK);
			labelCidade.setBounds(20, 300, 140, 20);
		}
		return labelCidade;
	}
	
	public JTextField getJTextFieldCidade() {
		if (jTextFieldCidade == null) {
			jTextFieldCidade = new JTextField();
			jTextFieldCidade.setBounds(20, 320, 180, 20);
		}
		return jTextFieldCidade;
	}
	
	public JLabel getLabelComplemento() {
		if (labelComplemento == null) {
			labelComplemento = new JLabel("Complemento");
			labelComplemento.setForeground(Color.BLACK);
			labelComplemento.setBounds(20, 350, 90, 20);
		}
		return labelComplemento;
	}
	
	public JTextField getJTextFieldComplemento() {
		if (jTextFieldComplemento == null) {
			jTextFieldComplemento = new JTextField();
			jTextFieldComplemento.setBounds(20, 370, 180, 20);
		}
		return jTextFieldComplemento;
	}
	public JFormattedTextField getJFormattedTextFieldRg() {
		if (jFormattedTextFieldRg == null) {
			try {
				mascaraRg = new MaskFormatter ("##.###.###-##");
			}
			catch (Exception e) {
			}
			jFormattedTextFieldRg = new JFormattedTextField(mascaraRg);
			jFormattedTextFieldRg.setBounds(20, 170, 180, 20);
		}
		return jFormattedTextFieldRg;
	}
	public JLabel getLabelRg() {
		if (labelRg == null) {
			labelRg = new JLabel("RG");
			labelRg.setForeground(Color.BLACK);
			labelRg.setBounds(20, 150, 140, 20);
		}
		return labelRg;
	}
	public JComboBox getJComboBoxSexo() {
		if (jComboBoxSexo == null) {
			jComboBoxSexo = new JComboBox();
			jComboBoxSexo.setBounds(250, 69, 90, 21);
			jComboBoxSexo.addItem("Masculino");
			jComboBoxSexo.addItem("Feminino");
		}
		return jComboBoxSexo;
	}
	public JTextField getJTextFieldAreaAtuacao() {
		if (jTextFieldAreaAtuacao == null) {
			jTextFieldAreaAtuacao = new JTextField();
			jTextFieldAreaAtuacao.setBounds(480, 170, 180, 20);
		}
		return jTextFieldAreaAtuacao;
	}
	public JTextField getJTextFieldEspecialidade() {
		if (jTextFieldEspecialidade == null) {
			jTextFieldEspecialidade = new JTextField();
			jTextFieldEspecialidade.setBounds(480, 120, 180, 20);
		}
		return jTextFieldEspecialidade;
	}
	public JLabel getLblEspecialidade() {
		if (lblEspecialidade == null) {
			lblEspecialidade = new JLabel("Especialidade");
			lblEspecialidade.setForeground(Color.BLACK);
			lblEspecialidade.setBounds(480, 100, 140, 20);
		}
		return lblEspecialidade;
	}
	public JLabel getLblreaDeAtuao() {
		if (lblreaDeAtuao == null) {
			lblreaDeAtuao = new JLabel("\u00C1rea de Atua\u00E7\u00E3o");
			lblreaDeAtuao.setForeground(Color.BLACK);
			lblreaDeAtuao.setBounds(480, 154, 140, 20);
		}
		return lblreaDeAtuao;
	}
	public JLabel getLblCrm() {
		if (lblCrm == null) {
			lblCrm = new JLabel("CRM");
			lblCrm.setForeground(Color.BLACK);
			lblCrm.setBounds(480, 200, 140, 20);
		}
		return lblCrm;
	}
	public JFormattedTextField getJFormattedTextFieldCRM() {
		if (jFormattedTextFieldCRM == null) {
			try {
				mascaraCRM = new MaskFormatter("#######");
			} catch (Exception e) {
			}
			jFormattedTextFieldCRM = new JFormattedTextField(mascaraCRM);
			jFormattedTextFieldCRM.setBounds(480, 220, 85, 20);
		}
		return jFormattedTextFieldCRM;
	}
	public JButton getJButtonVoltar() {
		if (jButtonVoltar == null) {
			jButtonVoltar = new JButton("Voltar");
			jButtonVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
			jButtonVoltar.setBounds(20, 448, 85, 21);
		}
		return jButtonVoltar;
	}
	public JButton getJButtonCadastrar() {
		if (jButtonCadastrar == null) {
			jButtonCadastrar = new JButton("Cadastrar");
			jButtonCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
			jButtonCadastrar.setBounds(125, 448, 108, 21);
		}
		return jButtonCadastrar;
	}
}