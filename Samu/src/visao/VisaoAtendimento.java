/*
 * Autor - Francisco Anacreonte, Marcus Cardoso, Raul Gonçalves, Saullo Benevides
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

import controller.ControladorCadastroPaciente;
import model.Paciente;

import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;

public class VisaoAtendimento extends JPanel {
	
    private ButtonGroup grupoSexo = new ButtonGroup();    	
    private JTextField jTextFieldSolicitante;
    private JLabel labelNome;
    private MaskFormatter mascaraCpf;
    private JFormattedTextField jFormattedTextFieldCpf;
    private JLabel labelCpf;
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
    private JTextField jTextFieldPontoReferencia;
    private JLabel labelCidade;
    private JTextField jTextFieldCidade;
    private JLabel labelComplemento;
    private JTextField jTextFieldComplemento;
    private MaskFormatter mascaraRg;
    private JComboBox jComboBoxSexo;
    private JTextField jTextFieldMotivoLigacao;
    private JLabel lblEspecialidade;
    private JLabel lblreaDeAtuao;
    private MaskFormatter mascaraCRM;
    private JButton jButtonVoltar;
    private JButton jButtonCadastrar;
    private JComboBox jComboBoxOrigemLigacao;
    private JTextField jTextFieldApelidoOcorrencia;
    private JComboBox jComboBoxTipoLigacao;
    private JLabel lblMotivoDaLigao;
    private JTextField jTextFieldIdadeAparente;
    private JLabel lblIdadeAparente;
    private JTextField jTextFieldEstado;
    private JLabel lblEstado;
    
    public VisaoAtendimento () {
    
        this.setVisible(true);               
        this.setLayout(null);
        this.add(getJLabelSessao ());
        //Buttons e Imagens
        this.add(getJTextfieldNome());
        this.add(getJLabelNome());
        this.add(getJLabelSexo());
        this.add(getJFormattedTextfieldCpf ());
        this.add(getJLabelCpf());
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
        
        JLabel labelEstado = new JLabel("Ponto de Refer\u00EAncia");
        labelEstado.setForeground(Color.BLACK);
        labelEstado.setBounds(20, 150, 140, 20);
        add(labelEstado);
        add(getJTextFieldPontoReferencia());
        add(getLabelCidade());
        add(getJTextFieldCidade());
        add(getLabelComplemento());
        add(getJTextFieldComplemento());
        add(getJComboBoxSexo());
        add(getJTextFieldMotivoLigacao());
        add(getLblEspecialidade());
        add(getLblreaDeAtuao());
        add(getJButtonVoltar());
        add(getJButtonCadastrar());
        add(getJComboBoxOrigemLigacao());
        add(getJTextFieldApelidoOcorrencia());
        add(getJComboBoxTipoLigacao());
        add(getLblMotivoDaLigao());
        add(getJTextFieldIdadeAparente());
        add(getLblIdadeAparente());
        add(getJTextFieldEstado());
        add(getLblEstado());
    }
    
    //JLabel e JTextfield
    public JLabel getJLabelSessao ( ) {
    	
    	if (labelSessao == null) {
    		
    		labelSessao = new JLabel ("Atendimento");
    		labelSessao.setBounds(30, 10, 210, 20);
    		labelSessao.setForeground(Color.black);
    		labelSessao.setFont(fonte);
    	}   	
    	return labelSessao;
    } 
  
    //Campo do Nome
    public JTextField getJTextfieldNome () {    
        
        if (jTextFieldSolicitante == null) {
         
            jTextFieldSolicitante = new JTextField();
            jTextFieldSolicitante.setBounds (20, 70, 180, 20);
        }
        return jTextFieldSolicitante;
    }
    
    public JLabel getJLabelNome() {    
        
        if (labelNome == null) {
       
           labelNome = new JLabel("Solicitante");
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
    
    public JLabel getJLabelDataNascimento () {    
        
        if (labelDataNascimento == null) {
       
           labelDataNascimento = new JLabel("Apelido de Ocorr\u00EAncia");
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
    public JTextField getJTextFieldPontoReferencia() {
		if (jTextFieldPontoReferencia == null) {
			jTextFieldPontoReferencia = new JTextField();
			jTextFieldPontoReferencia.setBounds(20, 170, 180, 20);
		}
		return jTextFieldPontoReferencia;
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
	public JComboBox getJComboBoxSexo() {
		if (jComboBoxSexo == null) {
			jComboBoxSexo = new JComboBox();
			jComboBoxSexo.setBounds(250, 69, 90, 21);
			jComboBoxSexo.addItem("Masculino");
			jComboBoxSexo.addItem("Feminino");
		}
		return jComboBoxSexo;
	}
	public JTextField getJTextFieldMotivoLigacao() {
		if (jTextFieldMotivoLigacao == null) {
			jTextFieldMotivoLigacao = new JTextField();
			jTextFieldMotivoLigacao.setBounds(480, 170, 180, 20);
		}
		return jTextFieldMotivoLigacao;
	}
	public JLabel getLblEspecialidade() {
		if (lblEspecialidade == null) {
			lblEspecialidade = new JLabel("Origem");
			lblEspecialidade.setForeground(Color.BLACK);
			lblEspecialidade.setBounds(480, 100, 140, 20);
		}
		return lblEspecialidade;
	}
	public JLabel getLblreaDeAtuao() {
		if (lblreaDeAtuao == null) {
			lblreaDeAtuao = new JLabel("Motivo da Liga\u00E7\u00E3o");
			lblreaDeAtuao.setForeground(Color.BLACK);
			lblreaDeAtuao.setBounds(480, 154, 140, 20);
		}
		return lblreaDeAtuao;
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
	public JComboBox getJComboBoxOrigemLigacao() {
		if (jComboBoxOrigemLigacao == null) {
			jComboBoxOrigemLigacao = new JComboBox();
			jComboBoxOrigemLigacao.setBounds(480, 119, 108, 21);
			jComboBoxOrigemLigacao.addItem("Selecione");
		}
		return jComboBoxOrigemLigacao;
	}
	
	public void atualizaComboBoxOrigemLigacao () {
		
		getJComboBoxOrigemLigacao().removeAllItems();
		getJComboBoxOrigemLigacao().addItem("Selecione");
		
		jComboBoxOrigemLigacao.addItem("Domicílio");
		jComboBoxOrigemLigacao.addItem("Trânsito Cidade");
		jComboBoxOrigemLigacao.addItem("Trânsito Rodovia");
		jComboBoxOrigemLigacao.addItem("Outros");
	}
	
	public void atualizaComboBoxMotivoLigacao () {
		
		getJComboBoxTipoLigacao().removeAllItems();
		getJComboBoxTipoLigacao().addItem("Selecione");
		
		jComboBoxTipoLigacao.addItem("Trote");
		jComboBoxTipoLigacao.addItem("Regulação");
		jComboBoxTipoLigacao.addItem("Engano");
		jComboBoxTipoLigacao.addItem("Informações");
	}
	
	public JTextField getJTextFieldApelidoOcorrencia() {
		if (jTextFieldApelidoOcorrencia == null) {
			jTextFieldApelidoOcorrencia = new JTextField();
			jTextFieldApelidoOcorrencia.setBounds(250, 120, 180, 20);
		}
		return jTextFieldApelidoOcorrencia;
	}
	public JComboBox getJComboBoxTipoLigacao() {
		if (jComboBoxTipoLigacao == null) {
			jComboBoxTipoLigacao = new JComboBox();
			jComboBoxTipoLigacao.setBounds(480, 69, 85, 21);
			jComboBoxTipoLigacao.addItem("Selecione");
		}
		return jComboBoxTipoLigacao;
	}
	public JLabel getLblMotivoDaLigao() {
		if (lblMotivoDaLigao == null) {
			lblMotivoDaLigao = new JLabel("Tipo da Liga\u00E7\u00E3o");
			lblMotivoDaLigao.setForeground(Color.BLACK);
			lblMotivoDaLigao.setBounds(480, 50, 140, 20);
		}
		return lblMotivoDaLigao;
	}
	public JTextField getJTextFieldIdadeAparente() {
		if (jTextFieldIdadeAparente == null) {
			jTextFieldIdadeAparente = new JTextField();
			jTextFieldIdadeAparente.setBounds(480, 220, 50, 20);
		}
		return jTextFieldIdadeAparente;
	}
	public JLabel getLblIdadeAparente() {
		if (lblIdadeAparente == null) {
			lblIdadeAparente = new JLabel("Idade Aparente");
			lblIdadeAparente.setForeground(Color.BLACK);
			lblIdadeAparente.setBounds(480, 204, 140, 20);
		}
		return lblIdadeAparente;
	}
	public JTextField getJTextFieldEstado() {
		if (jTextFieldEstado == null) {
			jTextFieldEstado = new JTextField();
			jTextFieldEstado.setBounds(250, 320, 180, 20);
		}
		return jTextFieldEstado;
	}
	public JLabel getLblEstado() {
		if (lblEstado == null) {
			lblEstado = new JLabel("Estado");
			lblEstado.setForeground(Color.BLACK);
			lblEstado.setBounds(250, 300, 140, 20);
		}
		return lblEstado;
	}
}