package Controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import View.Frame;
import View.PanelLogin;
import View.TelaPrincipal;

public class ControladorTelaLogin implements MouseListener {

	private PanelLogin panelLogin;
	private TelaPrincipal telaPrincipal;
	private Frame frame;

	private ControladorTelaPrincipal controladorTelaPrincipal;

	public ControladorTelaLogin() {
	}
	
	public ControladorTelaLogin(PanelLogin panelLogin, Frame frame) {
		super();
		this.panelLogin = panelLogin;
		this.frame = frame;
		addEventos();
	}



	private void addEventos() {
		getPanelLogin().getLabel_user().addMouseListener(this);
		getPanelLogin().getLblEntrar().addMouseListener(this);

	}

	public PanelLogin getPanelLogin() {
		if (panelLogin == null) {
			panelLogin = new PanelLogin();
		}
		return panelLogin;
	}

	public Frame getFrame() {
		if (frame == null) {
			frame = new Frame();
		}
		return frame;
	}

	public TelaPrincipal getTelaPrincipal() {
		if (telaPrincipal == null) {
			telaPrincipal = new TelaPrincipal();
		}
		return telaPrincipal;
	}

	public ControladorTelaPrincipal getControladorTelaPrincipal() {
		if (controladorTelaPrincipal == null) {
			controladorTelaPrincipal = new ControladorTelaPrincipal(getFrame(),getTelaPrincipal());
		}
		return controladorTelaPrincipal;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == getPanelLogin().getLblEntrar()) {
			getFrame().trocar_tela(getTelaPrincipal());
			getControladorTelaPrincipal();
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == getPanelLogin().getLblEntrar()) {
			getPanelLogin().getPanel_entrar().setBackground(new Color(255, 255, 255));
		}

	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == getPanelLogin().getLblEntrar()) {
			getPanelLogin().getPanel_entrar().setBackground(new Color(255, 0, 102));
		}

	}

}
