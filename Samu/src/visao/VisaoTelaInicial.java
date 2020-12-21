package visao;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class VisaoTelaInicial extends JPanel {
	
	private ImageIcon imgSamu = new ImageIcon(getClass().getResource("samu_imagem.jpg"));
	private JLabel imagemSamu;
    private Color painelFundo = new Color (185,247,166);
    private JLabel lblSamu;
	
	public VisaoTelaInicial() {
		setBackground(painelFundo);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(62)
					.addComponent(getLblSamu(), GroupLayout.PREFERRED_SIZE, 347, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(167, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addComponent(getLblSamu(), GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(348, Short.MAX_VALUE))
		);
		add(getJLabelImagem());
		setLayout(groupLayout);
	}
	
	public JLabel getJLabelImagem() {
		if (imagemSamu == null) {
			imagemSamu = new JLabel(imgSamu);
			imagemSamu.setBounds(470, 35, 600, 500);
		}
		return imagemSamu;
	}
	public JLabel getLblSamu() {
		if (lblSamu == null) {
			lblSamu = new JLabel("SAMU 192");
			lblSamu.setForeground(new Color(255, 0, 0));
			lblSamu.setFont(new Font("Stencil", Font.PLAIN, 50));
		}
		return lblSamu;
	}
}
