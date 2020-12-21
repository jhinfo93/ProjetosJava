package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

import javax.swing.JOptionPane;

import model.Arquivo;
import model.Paciente;
import model.Patologia;
import visao.VisaoCadastroPatologia;
import visao.VisaoTelaInicial;

public class ControladorCadastroPatologia implements ActionListener{

	private VisaoCadastroPatologia visaoCadastroPatologia;
	private VisaoTelaInicial visaoTelaInicial;
	private ControladorTelaInicial controladorTelaInicial;
	private String caminho = "D:/ws-eclipse/Samu/Patologia.txt";
	
	public ControladorCadastroPatologia(VisaoCadastroPatologia visaoCadastroPatologia) {
		visaoTelaInicial = new VisaoTelaInicial();
		controladorTelaInicial = new ControladorTelaInicial(visaoTelaInicial);
		
		this.visaoCadastroPatologia = visaoCadastroPatologia;
		addEventos();
	}

	private void addEventos() {
		visaoCadastroPatologia.getJButtonEncerrar().addActionListener(this);
		visaoCadastroPatologia.getJButtonAdicionar().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == visaoCadastroPatologia.getJButtonEncerrar()) {
			
			int op = JOptionPane.showConfirmDialog(null, "Deseja Sair ?");
			
			if (op == 0) {
				ControladorFrame.frame.setContentPane(visaoTelaInicial);
				ControladorFrame.frame.repaint();
				ControladorFrame.frame.validate();
			}
		}
		else if (e.getSource() == visaoCadastroPatologia.getJButtonAdicionar()) {
			
			String nomeDoenca = visaoCadastroPatologia.getJTextfieldDoenca().getText();
			String nomePaciente = visaoCadastroPatologia.getJTextFieldPaciente().getText();
			String doencaCronica = visaoCadastroPatologia.getJComboBoxDoencaCronica().getSelectedItem().toString();
			String cpf = visaoCadastroPatologia.getJFormattedTextfieldCPF().getText();
			String dataDiagnostico = visaoCadastroPatologia.getJFormattedTextfieldDataDiagnostico().getText();
		
			Patologia patologia = new Patologia(nomeDoenca, dataDiagnostico, doencaCronica);
			
			if (VerificaPreenchimentoCampo(nomeDoenca, nomePaciente, dataDiagnostico, cpf)) {	
			}
			else if (verficaCampoLetras(nomeDoenca, nomePaciente)) {
			}
			else if (dadosPaciente(nomePaciente, cpf)) {
			}
			else if (validaData(dataDiagnostico)) {
			}
			else if (verificaPatologia(nomeDoenca, cpf, patologia)) {
			}
			else {			
				JOptionPane.showMessageDialog(null, "Dados da patologia inseridos no paciente", "Paciente", JOptionPane.INFORMATION_MESSAGE);
				limpaCampos();
				
				String texto []=  new String [] {nomeDoenca+ ";" + dataDiagnostico + ";" + doencaCronica};
				
				if(Arquivo.writeAdicionaFinal(caminho, texto)){
				}
				else {
				}
			}
		}
	}

	//MÈtodo para verifica se campo foi preenchido
	public boolean VerificaPreenchimentoCampo (String doenca, String paciente, String dataDiagnostico, String cpf) {
		if (doenca.trim().isEmpty()){
			JOptionPane.showMessageDialog(null, "O campo DoenÁa est· vazio", "Patologia", JOptionPane.WARNING_MESSAGE);
			visaoCadastroPatologia.getJTextfieldDoenca().requestFocus();
			return true;
		}
		if (paciente.trim().isEmpty()){
			JOptionPane.showMessageDialog(null, "O campo Paciente est· vazio", "Patologia", JOptionPane.WARNING_MESSAGE);
			visaoCadastroPatologia.getJTextFieldPaciente().requestFocus();
			return true;
		}
		else if (dataDiagnostico.equals("  /  /    ")){
			JOptionPane.showMessageDialog(null, "O campo Data do DiagnÛstico est· vazio", "Patologia", JOptionPane.WARNING_MESSAGE);
			visaoCadastroPatologia.getJFormattedTextfieldDataDiagnostico().requestFocus();
			return true;
		}
		else if (cpf.equals("   .   .   -  ")){
			JOptionPane.showMessageDialog(null, "O campo CPF est· vazio", "Patologia", JOptionPane.WARNING_MESSAGE);
			visaoCadastroPatologia.getJFormattedTextfieldCPF().requestFocus();
			return true;
		}
		return false;
	}
	
	//Verificando se existe os dados do paciente
	public boolean dadosPaciente (String nomepaciente, String cpf) {
		
		for (Paciente paciente: ControladorCadastroPaciente.listaPaciente) {

			if (paciente.getNome().equals(nomepaciente) && paciente.getCpf().equals(cpf)) {
				return false;
			}
		}	

		JOptionPane.showMessageDialog(null, "Os dados do Paciente n„o foram encontrados!", "Paciente", JOptionPane.WARNING_MESSAGE);
		return true;
	}
	
	//MÈtodo para verificar se uma palavra contÈm apenas letras
	public boolean verificaLetras(String str) {
		return str.matches("[a-zA-ZÁ„·ÈÌÛ˙‚ÍÙ«√¡…Õ”⁄ ]+");
	}
	
	//Verificando se o campo tem apenas letras
	public boolean verficaCampoLetras (String nomeDoenca, String nomePaciente) {
	
		if (!verificaLetras(nomeDoenca)) {
			JOptionPane.showMessageDialog(null, "No campo DoenÁa È permitido apenas letras. Digite novmente", "Patologia", JOptionPane.WARNING_MESSAGE);
			visaoCadastroPatologia.getJTextfieldDoenca().requestFocus();
			return true;
		}
		else if (!verificaLetras(nomePaciente)) {
			JOptionPane.showMessageDialog(null, "No campo Paciente È permitido apenas letras. Digite novmente", "Patologia", JOptionPane.WARNING_MESSAGE);
			visaoCadastroPatologia.getJTextFieldPaciente().requestFocus();
			return true;
		}
		return false;
	}
	
	//Verificando para que o usu·rio n„o adicione a mesma patologia no paciente mais de uma vez
	public boolean verificaPatologia (String nomeDoenca, String cpf, Patologia patologia) {
		for (Paciente paciente: ControladorCadastroPaciente.listaPaciente) {
			
			if (paciente.getCpf().equals(cpf)) {	//Procurando o paciente pelo CPF
				
				//Quando encontrar, vai verificar o seu histÛrico de doenÁa
				for (int i = 0; i < paciente.historicoDoenca.size(); i++) {
					
					//Se entrar na condiÁ„o significa que o paciente j· possui a doenÁa
					if (paciente.historicoDoenca.get(i).getNome().equals(nomeDoenca)) {
						JOptionPane.showMessageDialog(null, "O paciente j· possui esta doenÁa no seu histÛrico", "Patologia", JOptionPane.INFORMATION_MESSAGE);
						return true;
					}
				}
				paciente.historicoDoenca.add(patologia);
			}
		}
		return false;
	}
	
	//Limpando os campos
	public void limpaCampos () {
		visaoCadastroPatologia.getJTextfieldDoenca().setText("");
		visaoCadastroPatologia.getJFormattedTextfieldDataDiagnostico().setText("");
	}
	
	//Verificando se a data inserida È valida
	public boolean validaData (String dataDiagnostico) {
	    String formatoData = "dd/MM/uuuu";
	
	    DateTimeFormatter dateTimeFormatter = DateTimeFormatter
	    .ofPattern(formatoData).withResolverStyle(ResolverStyle.STRICT);
	    
	    try {
	        LocalDate data = LocalDate.parse(dataDiagnostico, dateTimeFormatter);
	        return false;
	    } catch (DateTimeParseException e) {
	    	
	    	JOptionPane.showMessageDialog(null, "A data inserida È inv·lida", "Patologia", JOptionPane.WARNING_MESSAGE);
			visaoCadastroPatologia.getJFormattedTextfieldDataDiagnostico().requestFocus();
	    	return true;
	    } 
	}
}
