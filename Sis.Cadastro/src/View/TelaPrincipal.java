package View;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class TelaPrincipal extends JPanel {
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblSiscad;
	private JLabel lblNewLabel_1;
	private JPanel panel_Inserir;
	private JPanel panel_Editar;
	private JPanel panel_Sair;
	private JPanel panel_Pesquisar;
	private JLabel lblInserir;
	private JLabel lblPesquisar;
	private JLabel lblEditar;
	private JLabel lblInserir_3;
	private JLabel labelMensagem;
	private JPanel panel_Deletar;
	private JLabel lblDeletar;
	private JLabel labelMensagem_1;
	private JLabel labelMensagem_2;
	private JLabel labelMensagem_3;
	private JLabel labelMensagem_4;

	/**
	 * Create the panel.
	 */
	public TelaPrincipal() {
		setBackground(new Color(102, 0, 102));
		setSize(720,426);
		setLayout(null);
		add(getPanel());
		add(getLblNewLabel());
		add(getLblSiscad());
		add(getLabelMensagem());
		add(getLabelMensagem_1());
		add(getLabelMensagem_2());
		add(getLabelMensagem_3());
		add(getLabelMensagem_4());


	}

	public JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(new Color(204, 51, 204));
			panel.setBounds(0, 0, 204, 426);
			panel.setLayout(null);
			panel.add(getLblNewLabel_1());
			panel.add(getPanel_Inserir());
			panel.add(getPanel_Editar());
			panel.add(getPanel_Sair());
			panel.add(getPanel_Pesquisar());
			panel.add(getPanel_Deletar());
		}
		return panel;
	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/res/ruby_gemstone_100px.png")));
			lblNewLabel.setBounds(293, 11, 105, 87);
		}
		return lblNewLabel;
	}
	public JLabel getLblSiscad() {
		if (lblSiscad == null) {
			lblSiscad = new JLabel("SisCad");
			lblSiscad.setForeground(Color.WHITE);
			lblSiscad.setFont(new Font("Tahoma", Font.BOLD, 43));
			lblSiscad.setBounds(397, 25, 165, 52);
		}
		return lblSiscad;
	}
	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/res/ruby_gemstone_100px.png")));
			lblNewLabel_1.setBounds(41, 11, 105, 87);
		}
		return lblNewLabel_1;
	}
	public JPanel getPanel_Inserir() {
		if (panel_Inserir == null) {
			panel_Inserir = new JPanel();
			panel_Inserir.setBackground(new Color(204, 51, 204));
			panel_Inserir.setBounds(0, 113, 204, 52);
			panel_Inserir.setLayout(null);
			panel_Inserir.add(getLblInserir_3());
		}
		return panel_Inserir;
	}
	public JPanel getPanel_Editar() {
		if (panel_Editar == null) {
			panel_Editar = new JPanel();
			panel_Editar.setBackground(new Color(204, 51, 204));
			panel_Editar.setBounds(0, 176, 204, 52);
			panel_Editar.setLayout(null);
			panel_Editar.add(getLblEditar());
		}
		return panel_Editar;
	}
	public JPanel getPanel_Sair() {
		if (panel_Sair == null) {
			panel_Sair = new JPanel();
			panel_Sair.setBackground(new Color(204, 51, 204));
			panel_Sair.setBounds(0, 363, 204, 52);
			panel_Sair.setLayout(null);
			panel_Sair.add(getLblInserir());
		}
		return panel_Sair;
	}
	public JPanel getPanel_Pesquisar() {
		if (panel_Pesquisar == null) {
			panel_Pesquisar = new JPanel();
			panel_Pesquisar.setBackground(new Color(204, 51, 204));
			panel_Pesquisar.setBounds(0, 239, 204, 52);
			panel_Pesquisar.setLayout(null);
			panel_Pesquisar.add(getLblPesquisar());
		}
		return panel_Pesquisar;
	}
	public JLabel getLblInserir() {
		if (lblInserir == null) {
			lblInserir = new JLabel("Sair");
			lblInserir.setForeground(new Color(255, 255, 255));
			lblInserir.setBounds(0, 0, 204, 52);
			lblInserir.setHorizontalAlignment(SwingConstants.CENTER);
			lblInserir.setFont(new Font("Tahoma", Font.BOLD, 38));
		}
		return lblInserir;
	}
	public JLabel getLblPesquisar() {
		if (lblPesquisar == null) {
			lblPesquisar = new JLabel("Pesquisar");
			lblPesquisar.setForeground(new Color(255, 255, 255));
			lblPesquisar.setBounds(0, 0, 204, 52);
			lblPesquisar.setHorizontalAlignment(SwingConstants.CENTER);
			lblPesquisar.setFont(new Font("Tahoma", Font.BOLD, 38));
		}
		return lblPesquisar;
	}
	public JLabel getLblEditar() {
		if (lblEditar == null) {
			lblEditar = new JLabel("Editar");
			lblEditar.setForeground(new Color(255, 255, 255));
			lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
			lblEditar.setFont(new Font("Tahoma", Font.BOLD, 38));
			lblEditar.setBounds(0, 0, 204, 52);
		}
		return lblEditar;
	}
	public JLabel getLblInserir_3() {
		if (lblInserir_3 == null) {
			lblInserir_3 = new JLabel("Inserir");
			lblInserir_3.setForeground(new Color(255, 255, 255));
			lblInserir_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblInserir_3.setFont(new Font("Tahoma", Font.BOLD, 38));
			lblInserir_3.setBounds(0, 0, 204, 52);
		}
		return lblInserir_3;
	}
	public JLabel getLabelMensagem() {
		if (labelMensagem == null) {
			labelMensagem = new JLabel("");
			labelMensagem.setHorizontalAlignment(SwingConstants.CENTER);
			labelMensagem.setForeground(new Color(255, 255, 255));
			labelMensagem.setFont(new Font("Tahoma", Font.BOLD, 35));
			labelMensagem.setBounds(212, 111, 496, 52);
		}
		return labelMensagem;
	}
	public JPanel getPanel_Deletar() {
		if (panel_Deletar == null) {
			panel_Deletar = new JPanel();
			panel_Deletar.setLayout(null);
			panel_Deletar.setBackground(new Color(204, 51, 204));
			panel_Deletar.setBounds(0, 302, 204, 52);
			panel_Deletar.add(getLblDeletar());
		}
		return panel_Deletar;
	}
	public JLabel getLblDeletar() {
		if (lblDeletar == null) {
			lblDeletar = new JLabel("Deletar");
			lblDeletar.setForeground(new Color(255, 255, 255));
			lblDeletar.setHorizontalAlignment(SwingConstants.CENTER);
			lblDeletar.setFont(new Font("Tahoma", Font.BOLD, 38));
			lblDeletar.setBounds(0, 0, 204, 52);
		}
		return lblDeletar;
	}
	public JLabel getLabelMensagem_1() {
		if (labelMensagem_1 == null) {
			labelMensagem_1 = new JLabel("");
			labelMensagem_1.setHorizontalAlignment(SwingConstants.CENTER);
			labelMensagem_1.setForeground(new Color(255, 255, 255));
			labelMensagem_1.setFont(new Font("Tahoma", Font.BOLD, 35));
			labelMensagem_1.setBounds(212, 177, 496, 52);
		}
		return labelMensagem_1;
	}
	public JLabel getLabelMensagem_2() {
		if (labelMensagem_2 == null) {
			labelMensagem_2 = new JLabel("");
			labelMensagem_2.setHorizontalAlignment(SwingConstants.CENTER);
			labelMensagem_2.setForeground(new Color(255, 255, 255));
			labelMensagem_2.setFont(new Font("Tahoma", Font.BOLD, 35));
			labelMensagem_2.setBounds(216, 242, 496, 52);
		}
		return labelMensagem_2;
	}
	public JLabel getLabelMensagem_3() {
		if (labelMensagem_3 == null) {
			labelMensagem_3 = new JLabel("");
			labelMensagem_3.setHorizontalAlignment(SwingConstants.CENTER);
			labelMensagem_3.setForeground(new Color(255, 255, 255));
			labelMensagem_3.setFont(new Font("Tahoma", Font.BOLD, 35));
			labelMensagem_3.setBounds(212, 307, 496, 52);
		}
		return labelMensagem_3;
	}
	public JLabel getLabelMensagem_4() {
		if (labelMensagem_4 == null) {
			labelMensagem_4 = new JLabel("");
			labelMensagem_4.setHorizontalAlignment(SwingConstants.CENTER);
			labelMensagem_4.setForeground(new Color(255, 255, 255));
			labelMensagem_4.setFont(new Font("Tahoma", Font.BOLD, 35));
			labelMensagem_4.setBounds(212, 361, 496, 52);
		}
		return labelMensagem_4;
	}
}
