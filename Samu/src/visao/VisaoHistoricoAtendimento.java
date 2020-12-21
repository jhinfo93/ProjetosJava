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

import controller.ControladorAtendimento;
import controller.ControladorCadastroPaciente;
import model.Atendimento;
import model.Paciente;

import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;

public class VisaoHistoricoAtendimento extends JPanel {
	
    private ButtonGroup grupoSexo = new ButtonGroup();    	
    private JTextField jTextFieldSolicitante;
    private JLabel labelNome;
    private MaskFormatter mascaraCpf;
    private JLabel labelCpf;
    private JLabel labelDataNascimento;
    private MaskFormatter mascaraTelefone;
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
    private JTextField jTextFieldMotivoLigacao;
    private JLabel lblEspecialidade;
    private JLabel lblreaDeAtuao;
    private MaskFormatter mascaraCRM;
    private JTextField jTextFieldApelidoOcorrencia;
    private JLabel lblMotivoDaLigao;
    private JTextField jTextFieldIdadeAparente;
    private JLabel lblIdadeAparente;
    private JTextField jTextFieldEstado;
    private JLabel lblEstado;
    private JTextField jTextFieldSexo;
    private JTextField jTextFieldTipoLigacao;
    private JTextField jTextFieldOrigem;
    private JTextField jTextFieldCPF;
    private JTextField jTextFieldTelefone;
    private JTextField jTextFieldHorarioAtendimento;
    private JLabel lblHorrioDoAtendimento;
    private JTextField jTextFieldCEP;
    private JLabel lblBuscaPeloSolicitante;
    private JComboBox jComboBoxSolicitante;
    private JLabel label_1;
    private JFormattedTextField formattedTextField;
    private JButton jButtonPesquisar;
    private JFormattedTextField jFormattedTextFieldCPF;
    private JButton jButtonImportar;
    
    public VisaoHistoricoAtendimento () {
    
        this.setVisible(true);               
        this.setLayout(null);
        this.add(getJLabelSessao ());
        //Buttons e Imagens
        this.add(getJTextfieldSolicitante());
        this.add(getJLabelNome());
        this.add(getJLabelSexo());
        this.add(getJLabelCpf());
        this.add(getJLabelDataNascimento());
        this.add(getJLabelTelefone ());
        this.add(getJTextfieldRua ());
        this.add(getJLabelRua ());
        this.add(getJTextfieldBairro ());
        this.add(getJLabelBairro ());
        this.add(getJTextfieldNumeroCasa ());
        this.add(getJLabelNumeroCasa ());
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
        add(getJTextFieldMotivoLigacao());
        add(getLblEspecialidade());
        add(getLblreaDeAtuao());
        add(getJTextFieldApelidoOcorrencia());
        add(getLblMotivoDaLigao());
        add(getJTextFieldIdadeAparente());
        add(getLblIdadeAparente());
        add(getJTextFieldEstado());
        add(getLblEstado());
        add(getJTextFieldSexo());
        add(getJTextFieldTipoLigacao());
        add(getJTextFieldOrigem());
        add(getJTextFieldCPF());
        add(getJTextFieldTelefone());
        add(getJTextFieldHorarioAtendimento());
        add(getLblHorrioDoAtendimento());
        add(getJTextFieldCEP());
        add(getLblBuscaPeloSolicitante());
        add(getJComboBoxSocicitante());
        add(getLabel_1());
        add(getJFormattedTextfieldCPF());
        add(getJButtonPesquisar());
        add(getJButtonImportar());
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
    public JTextField getJTextfieldSolicitante () {    
        
        if (jTextFieldSolicitante == null) {
         
            jTextFieldSolicitante = new JTextField();
            jTextFieldSolicitante.setBounds (20, 70, 180, 20);
            jTextFieldSolicitante.setEditable(false);
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
        	jTextFieldRua.setEditable(false);
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
        	jTextFieldBairro.setEditable(false);
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
        	jTextFieldNumeroCasa.setEditable(false);
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
			jTextFieldPontoReferencia.setEditable(false);
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
			jTextFieldCidade.setEditable(false);
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
			jTextFieldComplemento.setEditable(false);
		}
		return jTextFieldComplemento;
	}
	public JTextField getJTextFieldMotivoLigacao() {
		if (jTextFieldMotivoLigacao == null) {
			jTextFieldMotivoLigacao = new JTextField();
			jTextFieldMotivoLigacao.setBounds(480, 170, 180, 20);
			jTextFieldMotivoLigacao.setEditable(false);
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
	
	public JTextField getJTextFieldApelidoOcorrencia() {
		if (jTextFieldApelidoOcorrencia == null) {
			jTextFieldApelidoOcorrencia = new JTextField();
			jTextFieldApelidoOcorrencia.setBounds(250, 120, 180, 20);
			jTextFieldApelidoOcorrencia.setEditable(false);
		}
		return jTextFieldApelidoOcorrencia;
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
			jTextFieldIdadeAparente.setEditable(false);
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
			jTextFieldEstado.setEditable(false);
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
	public JTextField getJTextFieldSexo() {
		if (jTextFieldSexo == null) {
			jTextFieldSexo = new JTextField();
			jTextFieldSexo.setBounds(250, 70, 180, 20);
			jTextFieldSexo.setEditable(false);
		}
		return jTextFieldSexo;
	}
	public JTextField getJTextFieldTipoLigacao() {
		if (jTextFieldTipoLigacao == null) {
			jTextFieldTipoLigacao = new JTextField();
			jTextFieldTipoLigacao.setBounds(480, 70, 180, 20);
			jTextFieldTipoLigacao.setEditable(false);
		}
		return jTextFieldTipoLigacao;
	}
	public JTextField getJTextFieldOrigem() {
		if (jTextFieldOrigem == null) {
			jTextFieldOrigem = new JTextField();
			jTextFieldOrigem.setBounds(480, 120, 180, 20);
			jTextFieldOrigem.setEditable(false);
		}
		return jTextFieldOrigem;
	}
	public JTextField getJTextFieldCPF() {
		if (jTextFieldCPF == null) {
			jTextFieldCPF = new JTextField();
			jTextFieldCPF.setBounds(20, 120, 180, 20);
			jTextFieldCPF.setEditable(false);
		}
		return jTextFieldCPF;
	}
	public JTextField getJTextFieldTelefone() {
		if (jTextFieldTelefone == null) {
			jTextFieldTelefone = new JTextField();
			jTextFieldTelefone.setBounds(250, 170, 180, 20);
			jTextFieldTelefone.setEditable(false);
		}
		return jTextFieldTelefone;
	}
	public JTextField getJTextFieldHorarioAtendimento() {
		if (jTextFieldHorarioAtendimento == null) {
			jTextFieldHorarioAtendimento = new JTextField();
			jTextFieldHorarioAtendimento.setBounds(480, 270, 180, 20);
			jTextFieldHorarioAtendimento.setEditable(false);
		}
		return jTextFieldHorarioAtendimento;
	}
	public JLabel getLblHorrioDoAtendimento() {
		if (lblHorrioDoAtendimento == null) {
			lblHorrioDoAtendimento = new JLabel("Hor\u00E1rio do Atendimento");
			lblHorrioDoAtendimento.setForeground(Color.BLACK);
			lblHorrioDoAtendimento.setBounds(480, 254, 140, 20);
		}
		return lblHorrioDoAtendimento;
	}
	public JTextField getJTextFieldCEP() {
		if (jTextFieldCEP == null) {
			jTextFieldCEP = new JTextField();
			jTextFieldCEP.setEditable(false);
			jTextFieldCEP.setBounds(20, 270, 180, 20);
		}
		return jTextFieldCEP;
	}
	public JLabel getLblBuscaPeloSolicitante() {
		if (lblBuscaPeloSolicitante == null) {
			lblBuscaPeloSolicitante = new JLabel("Busca pelo Solicitante");
			lblBuscaPeloSolicitante.setForeground(Color.BLACK);
			lblBuscaPeloSolicitante.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblBuscaPeloSolicitante.setBounds(776, 85, 140, 13);
		}
		return lblBuscaPeloSolicitante;
	}
	public JComboBox getJComboBoxSocicitante() {
		if (jComboBoxSolicitante == null) {
			jComboBoxSolicitante = new JComboBox();
			jComboBoxSolicitante.setFont(new Font("Tahoma", Font.PLAIN, 14));
			jComboBoxSolicitante.setBounds(776, 107, 107, 21);
		}
		return jComboBoxSolicitante;
	}
	public JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("CPF");
			label_1.setForeground(Color.BLACK);
			label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			label_1.setBounds(776, 148, 46, 13);
		}
		return label_1;
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

	public JButton getJButtonPesquisar() {
		if (jButtonPesquisar == null) {
			jButtonPesquisar = new JButton("Pesquisar");
			jButtonPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 14));
			jButtonPesquisar.setBounds(776, 199, 107, 21);
		}
		return jButtonPesquisar;
	}
	
	public void atualizaComboBoxSolicitante () {
		
		getJComboBoxSocicitante().removeAllItems();
		getJComboBoxSocicitante().addItem("Selecione");
		
		for (Atendimento antementos: ControladorAtendimento.listaAtendimentos) {
			getJComboBoxSocicitante().addItem(antementos.getSolicitante());
		}
	}
	public void limpaCampos () {
		getJTextfieldSolicitante().setText("");
		getJTextFieldCPF().setText("");
		getJTextFieldTelefone().setText("");
		getJTextFieldCEP().setText("");
		getJTextfieldRua().setText("");
		getJTextfieldBairro().setText("");
		getJTextFieldCidade().setText("");
		getJTextFieldEstado().setText("");
		getJTextfieldNumeroCasa().setText("");
		getJTextFieldComplemento().setText("");
		getJTextFieldSexo().setText("");
		getJFormattedTextfieldCPF().setText("");
		getJTextFieldApelidoOcorrencia().setText("");
		getJTextFieldPontoReferencia().setText("");
		getJTextFieldTipoLigacao().setText("");
		getJTextFieldOrigem().setText("");
		getJTextFieldMotivoLigacao().setText("");
		getJTextFieldIdadeAparente().setText("");
		getJTextFieldHorarioAtendimento().setText("");
	}
	public JButton getJButtonImportar() {
		if (jButtonImportar == null) {
			jButtonImportar = new JButton("Importar");
			jButtonImportar.setFont(new Font("Tahoma", Font.PLAIN, 14));
			jButtonImportar.setBounds(776, 236, 107, 21);
		}
		return jButtonImportar;
	}
}