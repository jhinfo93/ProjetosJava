package Controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import View.Frame;
import View.PanelInserir;

public class ControladorTelaInserir implements MouseListener{
	
	private PanelInserir panelInserir;
	private Frame frame;
	
	public ControladorTelaInserir(PanelInserir panelInserir, Frame frame) {
		super();
		this.panelInserir = panelInserir;
		this.frame = frame;
		addEventos();
	}

	private void addEventos() {
		getPanelInserir().getPanelSalvar().addMouseListener(this);
		getPanelInserir().getPanelLimpar().addMouseListener(this);
		getPanelInserir().getPanelVoltar().addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
		if(e.getSource() == getPanelInserir().getPanelSalvar()) {
			getPanelInserir().getPanelSalvar().setBackground(new Color(204,51,204));
		}
		
		if(e.getSource() == getPanelInserir().getPanelVoltar()) {
			getPanelInserir().getPanelVoltar().setBackground(new Color(204,51,204));
		}
		if(e.getSource() == getPanelInserir().getPanelLimpar()) {
			getPanelInserir().getPanelLimpar().setBackground(new Color(204,51,204));
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource() == getPanelInserir().getPanelSalvar()) {
			getPanelInserir().getPanelSalvar().setBackground(new Color(102, 0, 102));
		}		
		if(e.getSource() == getPanelInserir().getPanelVoltar()) {
			getPanelInserir().getPanelVoltar().setBackground(new Color(102, 0, 102));
		}
		if(e.getSource() == getPanelInserir().getPanelLimpar()) {
			getPanelInserir().getPanelLimpar().setBackground(new Color(102, 0, 102));
		}
	}

	public PanelInserir getPanelInserir() {
	if(panelInserir == null){
		panelInserir = new PanelInserir();
	}
	return panelInserir;}

	public Frame getFrame() {
	if(frame == null){
		frame = new Frame();
	}
	return frame;}
	
	
	
	
}
