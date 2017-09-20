import javax.swing.JPanel;
import javax.swing.JScrollPane;

import net.miginfocom.swing.MigLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class viewManu extends JPanel{
	// WIP -------- criaï¿½ï¿½o da interface para consulta de funcionï¿½rios
	private JTable table;
	private String[] cabecalhoTabl = {"Serial",
									"Matricula",
						            "Modelo",
						            "Categoria",
						            "Capacidade",
						            "Tecnico_CPF",
						            "ANAC",
						            "Contrato",
						            "Nome Manutenção",
						            "Descrição Manutenção",
						            "Orçamento"};
	private DefaultTableModel model;
	private JScrollPane barraRol;
	private JButton voltar;
	private viewManu thisPanel = this;
	
	public viewManu(final UserInterface window, final JPanel ant) {
		setLayout(new MigLayout("", "[grow][grow]", "[][grow]"));
		model = new DefaultTableModel();
		table = new JTable(model);
		barraRol = new JScrollPane(table);
		voltar = new JButton("Voltar");
		add(barraRol, "cell 0 1 2 1,grow");
		add(voltar, "cell 0 2, alignx left");
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thisPanel.setVisible(false);
                window.atualiza(thisPanel, ant);
            }
        });
		criaTabela();
		model.setNumRows(0);
		preencheTabela();
		
	}
	

	void criaTabela() {
		table.setModel(model);
		model.addColumn(cabecalhoTabl[0]);
		model.addColumn(cabecalhoTabl[1]);
		model.addColumn(cabecalhoTabl[2]);
		model.addColumn(cabecalhoTabl[3]);
		model.addColumn(cabecalhoTabl[4]);
		model.addColumn(cabecalhoTabl[5]);
		model.addColumn(cabecalhoTabl[6]);
		model.addColumn(cabecalhoTabl[7]);
		model.addColumn(cabecalhoTabl[8]);
		model.addColumn(cabecalhoTabl[9]);
		model.addColumn(cabecalhoTabl[10]);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(9).setPreferredWidth(200);
	}
	
	void preencheTabela() {
		ResultSet lista = null;
		model.setNumRows(0);
		lista = BdConnector.ManuView();
		try{
			while (lista.next()) {
				model.addRow(new Object[] {lista.getInt(1), lista.getString(2), lista.getString(3), lista.getString(4), lista.getInt(5),
											lista.getInt(6), lista.getString(7), lista.getString(8), lista.getString(9), lista.getString(10),lista.getFloat(11)});
			}
			lista.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
