package Controller;

import View.Frame;
import View.PanelLogin;

public class ControladorMain {

	private static Frame frame;
	private static PanelLogin login;
	private static ControladorTelaLogin controladorTelaLogin;

	public static void main(String[] args) {
		getFrame().trocar_tela(getLogin());
		getControladorTelaLogin();
	}

	public static Frame getFrame() {
		if (frame == null) {
			frame = new Frame();
		}
		return frame;
	}

	public static PanelLogin getLogin() {
		if (login == null) {
			login = new PanelLogin();
		}
		return login;
	}

	public static ControladorTelaLogin getControladorTelaLogin() {
		if (controladorTelaLogin == null) {
			controladorTelaLogin = new ControladorTelaLogin(getLogin(), getFrame());
		}
		return controladorTelaLogin;
	}

}
