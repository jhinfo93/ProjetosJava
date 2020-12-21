package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class PanelTabela extends JPanel {
	private JScrollPane scrollPane;
	private JTable table;
	private JPanel panel;
	private JTextField textFieldNome;
	private JTextField textFieldTelefone;
	private JTextField textFieldIdade;
	private JButton btnCadastrar;
	private JButton btnLimpar;
	private JButton btnAtualizar;
	private JButton btnDeletar;
	private DefaultTableModel defaultTableModel;

	public PanelTabela() {
		setBackground(new Color(192, 192, 192));
		setSize(713, 410);
		setLayout(null);
		add(getScrollPane());
		add(getPanel());
	}
	// ScrollPane eu acho que é obrigatório para uma Tabela, então sempre que você
	// for colocar uma tabela por uma Panel, você primeiro abre uma scrollPane e
	// coloca a tabela dentro da scrollpane.

	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBackground(new Color(192, 192, 192));
			scrollPane.setBounds(10, 132, 678, 267);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}

	// Aqui você está criando uma Modelo seu de Tabela e nao o do Eclipse.
	// Depois de fazer esse Default, você coloca ela dentro da tabela, como no
	// exemplo do JTABLE
	public DefaultTableModel DefautTableModel() {
		if (defaultTableModel == null) {
			defaultTableModel = new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "Telefone", "Idade" }) {
				public boolean isCellEditable(int row, int column) {// essa função aqui dentro é para não deixar a
																	// pessoa editar os vlores diretamente da tabela
					return false;

				}
			};
		}
		return defaultTableModel;
	}

	public JTable getTable() {
		if (table == null) {
			table = new JTable(DefautTableModel());// Instancia a JTable passando o DefautTableModel. e pronto.. A parte
													// da tabela já está pronto
			table.setForeground(new Color(0, 0, 0));
			table.setBackground(new Color(192, 192, 192));

		}
		return table;
	}

	public JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(new Color(192, 192, 192));
			panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Dados",TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
			panel.setBounds(10, 11, 678, 110);
			panel.setLayout(null);
			panel.add(getTextFieldNome());
			panel.add(getTextFieldTelefone());
			panel.add(getTextFieldIdade());
			panel.add(getBtnCadastrar());
			panel.add(getBtnLimpar());
			panel.add(getBtnAtualizar());
			panel.add(getBtnDeletar());
		}
		return panel;
	}

	public JTextField getTextFieldNome() {
		if (textFieldNome == null) {
			textFieldNome = new JTextField();
			textFieldNome.setBackground(new Color(192, 192, 192));
			textFieldNome.setCaretColor(Color.BLACK);
			textFieldNome.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 128), 2, true), "Nome",
					TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			textFieldNome.setBounds(10, 16, 243, 36);
			textFieldNome.setColumns(10);
		}
		return textFieldNome;
	}

	public JTextField getTextFieldTelefone() {
		if (textFieldTelefone == null) {
			textFieldTelefone = new JTextField();
			textFieldTelefone.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 128), 2, true), "Telefone",
					TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			textFieldTelefone.setBackground(new Color(192, 192, 192));
			textFieldTelefone.setColumns(10);
			textFieldTelefone.setBounds(10, 63, 243, 36);
		}
		return textFieldTelefone;
	}

	public JTextField getTextFieldIdade() {
		if (textFieldIdade == null) {
			textFieldIdade = new JTextField();
			textFieldIdade.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 128), 2, true), "Idade",
					TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			textFieldIdade.setBackground(new Color(192, 192, 192));
			textFieldIdade.setColumns(10);
			textFieldIdade.setBounds(263, 16, 71, 36);
		}
		return textFieldIdade;
	}

	public JButton getBtnCadastrar() {
		if (btnCadastrar == null) {
			btnCadastrar = new JButton("Cadastrar");
			btnCadastrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnCadastrar.setBorder(new LineBorder(new Color(128, 128, 128), 2, true));
			btnCadastrar.setBounds(372, 27, 98, 26);
		}
		return btnCadastrar;
	}

	public JButton getBtnLimpar() {
		if (btnLimpar == null) {
			btnLimpar = new JButton("Limpar");
			btnLimpar.setBorder(new LineBorder(new Color(128, 128, 128), 2, true));
			btnLimpar.setBounds(482, 63, 98, 26);
		}
		return btnLimpar;
	}

	public JButton getBtnAtualizar() {
		if (btnAtualizar == null) {
			btnAtualizar = new JButton("Atualizar");
			btnAtualizar.setBounds(372, 63, 98, 26);
		}
		return btnAtualizar;
	}

	public JButton getBtnDeletar() {
		if (btnDeletar == null) {
			btnDeletar = new JButton("Deletar");
			btnDeletar.setBounds(482, 27, 98, 26);
		}
		return btnDeletar;
	}

	public void limparCampos() {
		textFieldIdade.setText("");
		textFieldNome.setText("");
		textFieldTelefone.setText("");
	}

}
