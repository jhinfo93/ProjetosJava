package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import view.Frame;
import view.PanelTabela;

public class ControladorTabela implements ActionListener, MouseListener {
	private Frame frame;
	private PanelTabela tabela;

	public ControladorTabela() {
	}

	public ControladorTabela(Frame frame, PanelTabela tabela) {
		this.frame = frame;
		this.tabela = tabela;
		addEventos();
	}

	// PADRÃO, VOCÊ JÁ SABE
	private void addEventos() {
		getPanelTabela().getBtnAtualizar().addActionListener(this);
		getPanelTabela().getBtnCadastrar().addActionListener(this);
		getPanelTabela().getBtnDeletar().addActionListener(this);
		getPanelTabela().getBtnLimpar().addActionListener(this);
		getPanelTabela().getTable().addMouseListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == getPanelTabela().getBtnCadastrar()) {
			if (getPanelTabela().getTextFieldIdade().getText().equals("")
					|| getPanelTabela().getTextFieldNome().getText().equals("")
					|| getPanelTabela().getTextFieldTelefone().getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Preencha todos os Campos");
			} else {
				// Entro na Tabela, e, pelo addRow, eu consigo adicionar uma linha ou várias
				// linhas. a linha é um Vetor de Objeto. COmo voce pode ver
				// eu crio o Objeto e coloco 3 valores nele (0,1,2) sendo respectivamente, field
				// nome, field telefone e field idade.
				getPanelTabela().DefautTableModel()
						.addRow(new Object[] { getPanelTabela().getTextFieldNome().getText(),
								getPanelTabela().getTextFieldTelefone().getText(),
								getPanelTabela().getTextFieldIdade().getText() });
				// limpando os campos, padrão também...
				getPanelTabela().limparCampos();
				JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
			}
		}

		/*
		 * Aqui é para deletar um valor da tabela Diferente de mexer direto no modelo da
		 * tabela que é o DefaultTableModel (CRIAR UM MODELO DE TABELA), para deletar um
		 * valor eu tenho que ir diretamente na tabela, ou seja, entrar no painel da
		 * tabela e pegar a tabela diretamente e não o modelo dela
		 */
		if (e.getSource() == getPanelTabela().getBtnDeletar()) {
			int i = getPanelTabela().getTable().getSelectedRow();// Selecionei a linha que eu desejo deletar
			if (i >= 0) {// Verificação para ver se esta selecionada a linha
				getPanelTabela().DefautTableModel().removeRow(i); // E agora sim, eu deleto do meu MODElo de tabela.
			} else {
				JOptionPane.showMessageDialog(null, "Escolha uma linha da tabela para ser removida!");
			}

		}
		/*
		 * Aqui é quase a mesma coisa que o delete
		 * 
		 */
		if (e.getSource() == getPanelTabela().getBtnAtualizar()) {
			int i = getPanelTabela().getTable().getSelectedRow();// Selecionei a linha para atualizar

			// faço uma validação para ver se a linha está selecionada e se todos os campos
			// estão preenchidos
			if (i >= 0 && !(getPanelTabela().getTextFieldIdade().getText().equals("")
					|| getPanelTabela().getTextFieldNome().getText().equals("")
					|| getPanelTabela().getTextFieldTelefone().getText().equals(""))) {

				getPanelTabela().DefautTableModel().removeRow(i);// Primeiro removo o que estava inserido na nossa
																	// tabela e depois adiciono do mesmo jeito com o
																	// DefaultTableMOdel
				getPanelTabela().DefautTableModel()
						.addRow(new Object[] { getPanelTabela().getTextFieldNome().getText(),
								getPanelTabela().getTextFieldTelefone().getText(),
								getPanelTabela().getTextFieldIdade().getText() });
				getPanelTabela().limparCampos();
				JOptionPane.showMessageDialog(null, "Atualizado com Sucesso!");

			} else {
				JOptionPane.showMessageDialog(null, "Escolha uma linha da tabela para ser Atualizada!");
			}

		}

	}

	public Frame getFrame() {
		if (frame == null)
			frame = new Frame();
		return frame;
	}

	public PanelTabela getPanelTabela() {
		if (tabela == null)
			tabela = new PanelTabela();
		return tabela;
	}

	@Override
	public void mouseClicked(MouseEvent e) {// Esse evento de mouse é para a nossa função ATUALIZAR.
		// Quando eu clicar em algum valor dentro da tabela, eu vou pegar o indice dela
		// e colocar em uma variável para eu conseguir coloar esses mesmos valores
		// dentro da nossa TextField
		if (e.getSource() == getPanelTabela().getTable()) {

			try {
				int i = getPanelTabela().getTable().getSelectedRow();
				getPanelTabela().getTextFieldNome()
						.setText(getPanelTabela().DefautTableModel().getValueAt(i, 0).toString());
				getPanelTabela().getTextFieldTelefone()
						.setText(getPanelTabela().DefautTableModel().getValueAt(i, 1).toString());
				getPanelTabela().getTextFieldIdade()
						.setText(getPanelTabela().DefautTableModel().getValueAt(i, 2).toString());

			} catch (Exception e2) {
				System.out.println(e2);
			}

		}
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
