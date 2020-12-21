package Controller;

import View.Frame;
import View.TelaLogin;

public class ControladorMain {

	private static Frame frame;
	private static TelaLogin telaLogin;
	private static ControladorTelaLogin controladorTelaLogin;

	public static void main(String[] args) {
		getFrame().TrocarTela(getTelaLogin());
		getControladorTelaLogin();
	}

	public static Frame getFrame() {
		if (frame == null) {
			frame = new Frame();
		}
		return frame;
	}

	



	public static TelaLogin getTelaLogin() {
	if(telaLogin == null){
		telaLogin = new TelaLogin();
	}
	return telaLogin;}

	public static ControladorTelaLogin getControladorTelaLogin() {
	if(controladorTelaLogin == null){
		controladorTelaLogin = new ControladorTelaLogin(getFrame(), getTelaLogin());
	}
	return controladorTelaLogin;}


	
}
