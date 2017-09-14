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
public class viewVoo extends JPanel{
	// WIP -------- criaï¿½ï¿½o da interface para consulta de funcionï¿½rios
	private JTable table;
	private String[] cabecalhoTabl = {"Voo_Data",
							            "Horário Saída",
							            "Horário Chegada",
							            "Origem",
							            "Destino",
							            "Avião Matrícula",
							            "Modelo",
							            "Passageiro CPF",
							            "Passageiro Nome",
							            "Passageiro e-mail",
							            "Passageiro passaporte",
							            "Necessidades especiais",
							            "Passagem Data Compra",
							            "Passagem Coluna",
							            "Passagem Fileira"};
	private DefaultTableModel model;
	private JScrollPane barraRol;
	private JButton voltar;
	private viewVoo thisPanel = this;
	
	public viewVoo(final UserInterface window, final JPanel ant) {
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
		model.addColumn(cabecalhoTabl[11]);
		model.addColumn(cabecalhoTabl[12]);
		model.addColumn(cabecalhoTabl[13]);
		model.addColumn(cabecalhoTabl[14]);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(9).setPreferredWidth(200);
	}
	
	void preencheTabela() {
		ResultSet lista = null;
		model.setNumRows(0);
		lista = BdConnector.VooView();
		try{
			while (lista.next()) {
				model.addRow(new Object[] {lista.getDate(1), lista.getTime(2), lista.getTime(3), lista.getString(4), lista.getString(5),
											lista.getString(6), lista.getString(7), lista.getInt(8), lista.getString(9), lista.getString(10),lista.getString(11),
											lista.getString(12),lista.getDate(13),lista.getString(14),lista.getString(15)});
			}
			lista.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
