package Controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import View.Frame;
import View.PanelDeletar;
import View.PanelInserir;
import View.TelaPrincipal;

public class ControladorTelaPrincipal implements MouseListener {

	private TelaPrincipal telaPrincipal;
	private Frame frame;
	
	private PanelDeletar panelDeletar;
	private ControladorPanelDeletar controladorPanelDeletar; 

	private PanelInserir panelInserir;
	private ControladorTelaInserir controladorTelaInserir;
	
	public ControladorTelaPrincipal() {
	}

	public ControladorTelaPrincipal(Frame frame , TelaPrincipal telaPrincipal) {
		this.telaPrincipal = telaPrincipal;
		this.frame = frame;
		addEventos();
	}

	private void addEventos() {
		getTelaPrincipal().getPanel_Deletar().addMouseListener(this);
		getTelaPrincipal().getPanel_Inserir().addMouseListener(this);
		getTelaPrincipal().getPanel_Pesquisar().addMouseListener(this);
		getTelaPrincipal().getPanel_Sair().addMouseListener(this);
		getTelaPrincipal().getPanel_Editar().addMouseListener(this);

	}
	
	

	public PanelInserir getPanelInserir() {
	if(panelInserir == null){
		panelInserir = new PanelInserir();
	}
	return panelInserir;}

	public ControladorTelaInserir getControladorTelaInserir() {
	if(controladorTelaInserir == null){
		controladorTelaInserir = new ControladorTelaInserir(getPanelInserir(), getFrame());
	}
	return controladorTelaInserir;}

	public ControladorPanelDeletar getControladorPanelDeletar() {
	if(controladorPanelDeletar == null){
		controladorPanelDeletar = new ControladorPanelDeletar(getFrame(), getPanelDeletar());
	}
	return controladorPanelDeletar;}

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

	public PanelDeletar getPanelDeletar() {
		if (panelDeletar == null) {
			panelDeletar = new PanelDeletar();
		}
		return panelDeletar;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		if (e.getSource() == getTelaPrincipal().getPanel_Deletar()) {
			getFrame().trocar_tela(getPanelDeletar());
			getControladorPanelDeletar();
			
		}
		if (e.getSource() == getTelaPrincipal().getPanel_Inserir()) {
			getFrame().trocar_tela(getPanelInserir());
			getControladorTelaInserir();
		}
		if (e.getSource() == getTelaPrincipal().getPanel_Pesquisar()) {
			JOptionPane.showMessageDialog(null, "Pesquisar");

		}
		if (e.getSource() == getTelaPrincipal().getPanel_Sair()) {
			JOptionPane.showConfirmDialog(null, "Deseja Mesmo sair?");

		}
		if (e.getSource() == getTelaPrincipal().getPanel_Editar()) {
			JOptionPane.showConfirmDialog(null, "Editar um usuário");

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

		if (e.getSource() == getTelaPrincipal().getPanel_Deletar()) {
			getTelaPrincipal().getPanel_Deletar().setBackground(new Color(102, 0, 102));
			getTelaPrincipal().getLabelMensagem_3().setText("Deletar um usuário");
		}
		if (e.getSource() == getTelaPrincipal().getPanel_Inserir()) {
			getTelaPrincipal().getPanel_Inserir().setBackground(new Color(102, 0, 102));
			getTelaPrincipal().getLabelMensagem().setText("Inserir um novo usuário");

		}
		if (e.getSource() == getTelaPrincipal().getPanel_Pesquisar()) {
			getTelaPrincipal().getPanel_Pesquisar().setBackground(new Color(102, 0, 102));
			getTelaPrincipal().getLabelMensagem_2().setText("Pesquisar sobre um usuário");

		}
		if (e.getSource() == getTelaPrincipal().getPanel_Sair()) {
			getTelaPrincipal().getPanel_Sair().setBackground(new Color(102, 0, 102));
			getTelaPrincipal().getLabelMensagem_4().setText("Sair do programa");

		}
		if (e.getSource() == getTelaPrincipal().getPanel_Editar()) {
			getTelaPrincipal().getPanel_Editar().setBackground(new Color(102, 0, 102));
			getTelaPrincipal().getLabelMensagem_1().setText("Editar um cadastro");

		}

	}

	@Override
	public void mouseExited(MouseEvent e) {

		if (e.getSource() == getTelaPrincipal().getPanel_Deletar()) {
			getTelaPrincipal().getPanel_Deletar().setBackground(new Color(204,51,204));
			getTelaPrincipal().getLabelMensagem_3().setText("");

		}
		if (e.getSource() == getTelaPrincipal().getPanel_Inserir()) {
			getTelaPrincipal().getPanel_Inserir().setBackground(new Color(204,51,204));
			getTelaPrincipal().getLabelMensagem().setText("");

		}
		if (e.getSource() == getTelaPrincipal().getPanel_Pesquisar()) {
			getTelaPrincipal().getPanel_Pesquisar().setBackground(new Color(204,51,204));
			getTelaPrincipal().getLabelMensagem_2().setText("");

		}
		if (e.getSource() == getTelaPrincipal().getPanel_Sair()) {
			getTelaPrincipal().getPanel_Sair().setBackground(new Color(204,51,204));
			getTelaPrincipal().getLabelMensagem_4().setText("");

		}
		if (e.getSource() == getTelaPrincipal().getPanel_Editar()) {
			getTelaPrincipal().getPanel_Editar().setBackground(new Color(204,51,204));
			getTelaPrincipal().getLabelMensagem_1().setText("");

		}

	}

}
