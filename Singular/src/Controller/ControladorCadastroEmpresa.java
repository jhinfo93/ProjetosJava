package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.Empresa;
import Model.Listas;
import View.CadastroEmpresa;
import View.Frame;
import View.PrimeiraTela;

public class ControladorCadastroEmpresa implements ActionListener {

	private Listas arrays;

	private Frame frame;
	private CadastroEmpresa cadastroEmpresa;
	private PrimeiraTela primeiraTela;
	private ControladorPrimeiraTela controladorPrimeiraTela;

	public ControladorCadastroEmpresa(Frame frame, CadastroEmpresa cadastroEmpresa) {
		this.frame = frame;
		this.cadastroEmpresa = cadastroEmpresa;
		addEventos();
	}

	private void addEventos() {
		getCadastroEmpresa().getBtnAvancar().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == getCadastroEmpresa().getBtnAvancar()) {
			Empresa empresa = new Empresa();
			empresa.setNome_empresa(getCadastroEmpresa().getTextFieldNomeEmpresa().getText());
			empresa.setPro_labore(Float.parseFloat(getCadastroEmpresa().getTextFieldProlabore().getText()));
			empresa.setQtd_funcionarios(Integer.parseInt(getCadastroEmpresa().getTextFieldQTDFuncionários().getText()));
			empresa.setSalario_funcionario(Float.parseFloat(getCadastroEmpresa().getTextFieldSalarioFuncionario().getText()));
			Listas.getEmpresa().add(empresa);
			System.out.println("Tem "+Listas.getEmpresa().size()+" Empresas");
			System.out.println("Os campos da nova empresa é: ");
			System.out.println("Nome: "+ Listas.getEmpresa().get(Listas.getEmpresa().size()-1).getNome_empresa());
			System.out.println("Pró Labore: " +Listas.getEmpresa().get(Listas.getEmpresa().size()-1).getPro_labore());
			System.out.println("Quantidade de FUncionários: "+Listas.getEmpresa().get(Listas.getEmpresa().size()-1).getQtd_funcionarios());
			System.out.println("Salário do Funcionário:  "+Listas.getEmpresa().get(Listas.getEmpresa().size()-1).getSalario_funcionario());
			System.out.println();
			
			JOptionPane.showMessageDialog(null, "EmpresaCadastrada!");
			getFrame().setContentPane(getPrimeiraTela());
			getControladorPrimeiraTela();

		}

	}

	public Frame getFrame() {
		if (frame == null) {
			frame = new Frame();
		}
		return frame;
	}

	public CadastroEmpresa getCadastroEmpresa() {
		if (cadastroEmpresa == null) {
			cadastroEmpresa = new CadastroEmpresa();
		}
		return cadastroEmpresa;
	}

	public PrimeiraTela getPrimeiraTela() {
		if (primeiraTela == null) {
			primeiraTela = new PrimeiraTela();
		}
		return primeiraTela;
	}

	public ControladorPrimeiraTela getControladorPrimeiraTela() {
		if (controladorPrimeiraTela == null) {
			controladorPrimeiraTela = new ControladorPrimeiraTela(getFrame(), getPrimeiraTela());
		}
		return controladorPrimeiraTela;
	}


}
