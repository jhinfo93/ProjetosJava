package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.Frame;
import View.PrimeiraTela;
import View.TelaLogin;

public class ControladorTelaLogin implements ActionListener {
	private Frame frame;
	private TelaLogin login;
	private PrimeiraTela primeiraTela;
	private ControladorPrimeiraTela controladorPrimeiraTela;

	public ControladorTelaLogin(Frame frame, TelaLogin login) {

		this.frame = frame;
		this.login = login;
		addEventos();

	}

	private void addEventos() {
		getLogin().getBtnEntrar().addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == getLogin().getBtnEntrar()) {
			getFrame().TrocarTela(getPrimeiraTela());
			getControladorPrimeiraTela();
		}

	}

	public Frame getFrame() {
		if (frame == null) {
			frame = new Frame();
		}
		return frame;
	}

	public TelaLogin getLogin() {
		if (login == null) {
			login = new TelaLogin();
		}
		return login;
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
