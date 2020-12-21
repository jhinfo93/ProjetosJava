package controller;

import view.Frame;
import view.PanelTabela;

public class Main {
	
	private static Frame frame;
	private static PanelTabela tabela;
	
	private static ControladorTabela controladorTabela;
	
	public static void main(String[] args) {
		getFrame().trocarTela(getTabela());
		getControladorTabela();
	}

	public static Frame getFrame() {
	if( frame == null)
		frame = new Frame();
	return frame;}

	public static PanelTabela getTabela() {
	if( tabela == null)
		tabela = new PanelTabela();
	return tabela;}

	public static ControladorTabela getControladorTabela() {
	if( controladorTabela == null)
		controladorTabela = new ControladorTabela(getFrame(), getTabela());
	return controladorTabela;}
	
	
	

}
