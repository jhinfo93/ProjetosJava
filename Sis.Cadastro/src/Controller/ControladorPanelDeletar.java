package Controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import View.Frame;
import View.PanelDeletar;
import View.TelaPrincipal;

public class ControladorPanelDeletar implements MouseListener{
	
	private Frame frame;
	private PanelDeletar panelDeletar;
	
	
	private TelaPrincipal telaPrincipal;
	private ControladorTelaPrincipal controladorTelaPrincipal;
	
	
	
	
	public ControladorPanelDeletar() {}
	public ControladorPanelDeletar(Frame frame, PanelDeletar panelDeletar) {
		this.frame = frame;
		this.panelDeletar = panelDeletar;
		addEventos();
	}
	private void addEventos() {
		getPanelDeletar().getPanel_Excluir().addMouseListener(this);		
		getPanelDeletar().getPanel_Voltar().addMouseListener(this);		

	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == getPanelDeletar().getPanel_Excluir()) {
			JOptionPane.showMessageDialog(getFrame(), "Deletar Usuário");
		}
		
		if(e.getSource() == getPanelDeletar().getPanel_Voltar()) {
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
		if(e.getSource() == getPanelDeletar().getPanel_Excluir()) {
			getPanelDeletar().getPanel_Excluir().setBackground(new Color(255,255,255));
		}
		
		if(e.getSource() == getPanelDeletar().getPanel_Voltar()) {
			getPanelDeletar().getPanel_Voltar().setBackground(new Color(255,255,255));
		}
	}
	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource() == getPanelDeletar().getPanel_Excluir()) {
			getPanelDeletar().getPanel_Excluir().setBackground(new Color(255, 0, 51));
		}
		
		if(e.getSource() == getPanelDeletar().getPanel_Voltar()) {
			getPanelDeletar().getPanel_Voltar().setBackground(new Color(255, 0, 51));
		}
	}
	
	
	public Frame getFrame() {
	if(frame == null){
		frame = new Frame();
	}
	return frame;}
	
	
	public PanelDeletar getPanelDeletar() {
	if(panelDeletar == null){
		panelDeletar = new PanelDeletar();
	}
	return panelDeletar;}
	public TelaPrincipal getTelaPrincipal() {
	if(telaPrincipal == null){
		telaPrincipal = new TelaPrincipal();
	}
	return telaPrincipal;}
	public ControladorTelaPrincipal getControladorTelaPrincipal() {
	if(controladorTelaPrincipal == null){
		controladorTelaPrincipal = new ControladorTelaPrincipal(getFrame(), getTelaPrincipal());
	}
	return controladorTelaPrincipal;}
	
	
	
	
	

}
