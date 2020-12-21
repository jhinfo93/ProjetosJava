package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.CadastroEmpresa;
import View.Frame;
import View.GerenciamentoEmpresa;
import View.PrimeiraTela;

public class ControladorPrimeiraTela implements ActionListener {

	private Frame frame;
	private PrimeiraTela primeiraTela;
	private CadastroEmpresa cadastroEmpresa;
	private GerenciamentoEmpresa gerenciamentoEmpresa;
	private ControladorCadastroEmpresa cadastroEmpresa2;

	public ControladorPrimeiraTela(Frame frame, PrimeiraTela primeiraTela) {
		super();
		this.frame = frame;
		this.primeiraTela = primeiraTela;
		addEventos();
	}

	private void addEventos() {
		getPrimeiraTela().getBtnCadastroEmpresa().addActionListener(this);
		getPrimeiraTela().getBtnGerenciamentoEmpresa().addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == getPrimeiraTela().getBtnGerenciamentoEmpresa()) {
			getFrame().TrocarTela(getGerenciamentoEmpresa());

		}
		
		if (e.getSource() == getPrimeiraTela().getBtnCadastroEmpresa()) {
			getFrame().TrocarTela(getCadastroEmpresa());
			getCadastroEmpresa2();
		}

	}

	public Frame getFrame() {
		if (frame == null) {
			frame = new Frame();
		}
		return frame;
	}

	public PrimeiraTela getPrimeiraTela() {
		if (primeiraTela == null) {
			primeiraTela = new PrimeiraTela();
		}
		return primeiraTela;
	}

	public CadastroEmpresa getCadastroEmpresa() {
		if (cadastroEmpresa == null) {
			cadastroEmpresa = new CadastroEmpresa();
		}
		return cadastroEmpresa;
	}

	public ControladorCadastroEmpresa getCadastroEmpresa2() {
		if (cadastroEmpresa2 == null) {
			cadastroEmpresa2 = new ControladorCadastroEmpresa(getFrame(), getCadastroEmpresa());
		}
		return cadastroEmpresa2;
	}

	public GerenciamentoEmpresa getGerenciamentoEmpresa() {
		if (gerenciamentoEmpresa == null) {
			gerenciamentoEmpresa = new GerenciamentoEmpresa();
		}
		return gerenciamentoEmpresa;
	}

}
