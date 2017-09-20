
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Date;
import java.time.LocalDate;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Marcos
 */
@SuppressWarnings("serial")
public class PanelCadFuncionario extends JPanel {
    static private JLabel lblNome,
              lblCPF,
              lblEndereco,
              lblNiver,
              lblSexo,
              lblEmail,
              lblRua,
              lblNum,
              lblBairro,
              lblCompl,
              lblPassaport,
              lblSpclNecess,
              lblPersoData;
    
    static private JTextField Nome,
                    Email,
                    Rua,
                    Numero,
                    Bairro,
                    Compl,
                    Passaport;
    
    static private JFormattedTextField CPF,
                        Niver,
                        CodFunc;

    @SuppressWarnings("rawtypes")
	static private JComboBox Sexo,
              SpclNecess;

    static private JSeparator jSeparator2,
                    jSeparator3;

    
    static private JButton jButtonVoltar,
                jButtonSave,
                jButtonClean;
    
    PanelCadFuncionario thisPanel = this;
    static private JLabel lblCargo,
    					  lblPiloto,
    					  lblNmAnac,
    					  lblHabAeronaves,
    					  lblHorasDeVoo,
    					  lblComissrio,
    					  lblTcnicoDeManuteno,
    					  lblChtCom,
    					  lblIdiomas,
    					  lblChtTec,
    					  lblTipoDeContrato;
    static private JFormattedTextField ANAC;
    static private JTextField HabAeronavs;
    static private JFormattedTextField HorasVoo;
    static private JTextField ChtCom,
    						  Idiomas,
    						  ChtTec;
    @SuppressWarnings("rawtypes")
	static private JComboBox Contrato,
                             Cargo;
    
    public void LimpaCampos() {
    	Nome.setText("");
    	Email.setText("");
    	CPF.setText("");
    	Rua.setText("");
    	Numero.setText("");
    	Bairro.setText("");
    	Compl.setText("");
    	Passaport.setText("");
    	Niver.setText("");
    	ANAC.setValue(null);
    	ChtCom.setText("");
    	ChtTec.setText("");
    	Idiomas.setText("");
    	HabAeronavs.setText("");
    	HorasVoo.setValue(null);
    }
    

    @SuppressWarnings({ "rawtypes", "unchecked" })
	public PanelCadFuncionario(final UserInterface window, final InitialPanel init) {
        lblNome = new JLabel("Nome completo: ");
        lblCPF = new JLabel("CPF: ");
        lblEndereco = new JLabel("Endere\u00E7o ");
        lblNiver = new JLabel("Data de nascimento: ");
        lblSexo = new JLabel("Sexo(M ou F): ");
        lblEmail = new JLabel("E-mail: ");
        lblRua = new JLabel("Rua: ");
        lblNum = new JLabel("N�mero: ");
        lblBairro = new JLabel("Bairro: ");
        lblCompl = new JLabel("Complemento: ");
        lblPassaport = new JLabel("Passaporte: ");
        lblSpclNecess = new JLabel("Necessidades especiais? ");
        lblPersoData = new JLabel("Dados Pessoais");
        
        
        Nome = new JTextField();
        Email = new JTextField();
        Rua = new JTextField();
        Numero = new JTextField();
        Bairro = new JTextField();
        Compl = new JTextField();
        Passaport = new JTextField();
        
        CPF = new JFormattedTextField();
        Niver = new JFormattedTextField();
        
        Sexo = new JComboBox();
        SpclNecess = new JComboBox();
 
        jSeparator2 = new JSeparator();
        jSeparator3 = new JSeparator();
         
        jButtonVoltar = new javax.swing.JButton();
        jButtonSave = new javax.swing.JButton();
        jButtonClean = new javax.swing.JButton();

        lblEndereco.setFont(new Font("Dialog", Font.BOLD, 12)); // NOI18N
        lblPersoData.setFont(new Font("Dialog", Font.BOLD, 12)); // NOI18N
        Niver.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter()));
        SpclNecess.setModel(new DefaultComboBoxModel(new String[] {"N�o", "Sim"}));
        Sexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "F", "M" }));
        CPF.setFormatterFactory(new DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        
        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thisPanel.setVisible(false);
                window.atualiza(thisPanel, init);
            }
        });

        jButtonSave.setText("Salvar");
        jButtonSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SalvarDados(Cargo.getSelectedItem().toString());
			}
		});
        
        jButtonClean.setText("Limpar Campos");
        jButtonClean.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	LimpaCampos();
            }
        });
        
        JSeparator separator = new JSeparator();
        
        JSeparator separator_1 = new JSeparator();
        
        JLabel lblEmpresa = new JLabel("Corporativo");
        lblEmpresa.setFont(new Font("Tahoma", Font.BOLD, 12));
        
        lblCargo = new JLabel("Cargo:");
        Cargo = new JComboBox();
        
        Cargo.setModel(new DefaultComboBoxModel(new String[] {"Administracao", "Piloto", "Comissario", "Mecanico"}));
  
        
        JLabel lblNmFuncionrio = new JLabel("Num Funcionario:");
        
        CodFunc = new JFormattedTextField();
        CodFunc.setFormatterFactory(new DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        
        lblPiloto = new JLabel("Piloto");
        lblPiloto.setFont(new Font("Tahoma", Font.BOLD, 11));
        
        lblNmAnac = new JLabel("Num ANAC:");
        
        lblHabAeronaves = new JLabel("Hab. Aeronaves:");
        
        lblHorasDeVoo = new JLabel("Horas de voo:");
        
        ANAC = new JFormattedTextField();
        
        HabAeronavs = new JTextField();
        HabAeronavs.setColumns(10);
        
        HorasVoo = new JFormattedTextField();
        
        lblComissrio = new JLabel("Comissario");
        lblComissrio.setFont(new Font("Tahoma", Font.BOLD, 11));
        
        lblTcnicoDeManuteno = new JLabel("Tecnico de manutencao");
        lblTcnicoDeManuteno.setFont(new Font("Tahoma", Font.BOLD, 11));
        
        lblChtCom = new JLabel("CHT:");
        
        lblIdiomas = new JLabel("Idiomas:");
        
        ChtCom = new JTextField();
        ChtCom.setColumns(10);
        
        Idiomas = new JTextField();
        Idiomas.setColumns(10);
        
        lblChtTec = new JLabel("CHT:");
        
        ChtTec = new JTextField();
        ChtTec.setColumns(10);
        
        lblTipoDeContrato = new JLabel("Tipo de contrato:");
        
        Contrato = new JComboBox();
        Contrato.setModel(new DefaultComboBoxModel(new String[] {"Tempor�rio", "Efetivo"}));
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, 775, Short.MAX_VALUE)
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(lblNome)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(Nome, 441, 441, 441)
        							.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
        							.addComponent(lblCPF, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(CPF, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
        							.addGap(55))
        						.addGroup(layout.createSequentialGroup()
        							.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        								.addGroup(layout.createSequentialGroup()
        									.addComponent(lblPassaport)
        									.addPreferredGap(ComponentPlacement.RELATED)
        									.addComponent(Passaport))
        								.addGroup(layout.createSequentialGroup()
        									.addComponent(lblEmail)
        									.addPreferredGap(ComponentPlacement.RELATED)
        									.addComponent(Email, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)))
        							.addGroup(layout.createParallelGroup(Alignment.LEADING)
        								.addGroup(layout.createSequentialGroup()
        									.addPreferredGap(ComponentPlacement.RELATED, 204, Short.MAX_VALUE)
        									.addComponent(lblNiver)
        									.addPreferredGap(ComponentPlacement.RELATED)
        									.addComponent(Niver, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
        									.addGap(55))
        								.addGroup(layout.createSequentialGroup()
        									.addPreferredGap(ComponentPlacement.UNRELATED)
        									.addComponent(lblSpclNecess)
        									.addPreferredGap(ComponentPlacement.RELATED)
        									.addComponent(SpclNecess, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        									.addGap(0, 327, Short.MAX_VALUE))))
        						.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 759, GroupLayout.PREFERRED_SIZE)
        						.addGroup(layout.createSequentialGroup()
        							.addGroup(layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(lblPersoData)
        								.addGroup(layout.createSequentialGroup()
        									.addComponent(lblSexo)
        									.addPreferredGap(ComponentPlacement.RELATED)
        									.addComponent(Sexo, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
        								.addComponent(lblEndereco, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
        							.addGap(0, 656, Short.MAX_VALUE))
        						.addGroup(Alignment.LEADING, layout.createSequentialGroup()
        							.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        								.addGroup(layout.createSequentialGroup()
        									.addComponent(lblBairro)
        									.addPreferredGap(ComponentPlacement.RELATED)
        									.addComponent(Bairro, GroupLayout.PREFERRED_SIZE, 318, GroupLayout.PREFERRED_SIZE)
        									.addPreferredGap(ComponentPlacement.UNRELATED)
        									.addComponent(lblCompl)
        									.addPreferredGap(ComponentPlacement.RELATED)
        									.addComponent(Compl))
        								.addGroup(layout.createSequentialGroup()
        									.addComponent(lblRua)
        									.addPreferredGap(ComponentPlacement.RELATED)
        									.addComponent(Rua, GroupLayout.PREFERRED_SIZE, 577, GroupLayout.PREFERRED_SIZE)))
        							.addGap(18)
        							.addComponent(lblNum)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(Numero, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)))
        					.addContainerGap())
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 779, Short.MAX_VALUE)
        					.addGap(6))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(lblEmpresa)
        					.addContainerGap(703, Short.MAX_VALUE))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(lblHorasDeVoo)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(HorasVoo, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap())
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(lblPiloto)
        							.addGap(277)
        							.addComponent(lblComissrio)
        							.addPreferredGap(ComponentPlacement.RELATED, 125, Short.MAX_VALUE))
        						.addGroup(layout.createSequentialGroup()
        							.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        								.addGroup(Alignment.LEADING, layout.createSequentialGroup()
        									.addGroup(layout.createParallelGroup(Alignment.LEADING)
        										.addGroup(layout.createSequentialGroup()
        											.addComponent(lblNmAnac)
        											.addPreferredGap(ComponentPlacement.RELATED)
        											.addComponent(ANAC, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
        										.addGroup(layout.createSequentialGroup()
        											.addComponent(lblHabAeronaves)
        											.addPreferredGap(ComponentPlacement.RELATED)
        											.addComponent(HabAeronavs, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)))
        									.addGap(34)
        									.addGroup(layout.createParallelGroup(Alignment.LEADING)
        										.addGroup(layout.createSequentialGroup()
        											.addComponent(lblIdiomas)
        											.addPreferredGap(ComponentPlacement.RELATED)
        											.addComponent(Idiomas, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
        										.addGroup(layout.createSequentialGroup()
        											.addComponent(lblChtCom)
        											.addPreferredGap(ComponentPlacement.UNRELATED)
        											.addComponent(ChtCom, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))))
        								.addGroup(Alignment.LEADING, layout.createSequentialGroup()
        									.addComponent(lblCargo)
        									.addPreferredGap(ComponentPlacement.RELATED)
        									.addComponent(Cargo, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
        									.addPreferredGap(ComponentPlacement.UNRELATED)
        									.addComponent(lblNmFuncionrio)
        									.addPreferredGap(ComponentPlacement.RELATED)
        									.addComponent(CodFunc, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)))
        							.addGap(65)))
        					.addGap(16)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(layout.createSequentialGroup()
        							.addGap(30)
        							.addComponent(lblTcnicoDeManuteno)
        							.addGap(49))
        						.addGroup(layout.createParallelGroup(Alignment.LEADING)
        							.addGroup(layout.createSequentialGroup()
        								.addComponent(lblChtTec)
        								.addPreferredGap(ComponentPlacement.RELATED)
        								.addComponent(ChtTec, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
        							.addGroup(layout.createSequentialGroup()
        								.addComponent(lblTipoDeContrato)
        								.addPreferredGap(ComponentPlacement.RELATED)
        								.addComponent(Contrato, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))))
        					.addGap(98))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jButtonVoltar)
        					.addPreferredGap(ComponentPlacement.RELATED, 494, Short.MAX_VALUE)
        					.addComponent(jButtonClean)
        					.addGap(18)
        					.addComponent(jButtonSave)
        					.addGap(64))))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblPersoData)
        			.addGap(17)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblCPF)
        				.addComponent(CPF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(Nome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblNome))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblEmail)
        				.addComponent(Email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(Niver, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblNiver))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblSexo)
        				.addComponent(Sexo, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblPassaport)
        				.addComponent(Passaport, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblSpclNecess)
        				.addComponent(SpclNecess, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 7, GroupLayout.PREFERRED_SIZE)
        			.addGap(9)
        			.addComponent(lblEndereco)
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblRua)
        				.addComponent(Rua, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblNum)
        				.addComponent(Numero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblBairro)
        				.addComponent(Bairro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblCompl)
        				.addComponent(Compl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(separator, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(lblEmpresa)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lblCargo)
        						.addComponent(Cargo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblNmFuncionrio)
        						.addComponent(CodFunc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lblPiloto)
        						.addComponent(lblComissrio))
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lblNmAnac)
        						.addComponent(ANAC, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblChtCom)
        						.addComponent(ChtCom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lblHabAeronaves)
        						.addComponent(HabAeronavs, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblIdiomas)
        						.addComponent(Idiomas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(lblTcnicoDeManuteno)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lblChtTec)
        						.addComponent(ChtTec, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lblTipoDeContrato)
        						.addComponent(Contrato, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblHorasDeVoo)
        				.addComponent(HorasVoo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
        			.addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jButtonVoltar)
        				.addComponent(jButtonClean)
        				.addComponent(jButtonSave))
        			.addContainerGap())
        );
        this.setLayout(layout);
        
        setFuncType();
        
    }
    
    static void setFuncType(){
    	
    }
    
    static void SalvarDados(String cargo) {
    	LocalDate nascDate;
    	nascDate = LocalDate.parse(Niver.getText());
		BdConnector.insere_pessoa(Integer.parseInt(CPF.getText()),
				Nome.getText(),
				Sexo.getSelectedItem().toString().charAt(0),
				Date.valueOf(nascDate),
				Email.getText(),
				Rua.getText(),
				Integer.parseInt(Numero.getText()),
				Bairro.getText(),
				Compl.getText(),
				true,
				true,
				Integer.parseInt(CodFunc.getText()),
				cargo,
				Passaport.getText(),
				SpclNecess.getSelectedItem().toString());
		System.out.println(Niver.getText());
    	
		switch (cargo) {
    	case "Piloto":
    		BdConnector.insere_piloto(Integer.parseInt(CPF.getText()), ANAC.getText(), Integer.parseInt(HorasVoo.getText()));
    		BdConnector.insere_habilitacoes(Integer.parseInt(CPF.getText()), HabAeronavs.getText());
    		break;
    	case "Comissario":
    		BdConnector.insere_comissario(Integer.parseInt(CPF.getText()), ChtCom.getText());
    		BdConnector.insere_comissario_linguas(Integer.parseInt(CPF.getText()), Idiomas.getText());
    		break;
    	case "Mecanico":
    		BdConnector.insere_tecnico(Integer.parseInt(CPF.getText()), ChtTec.getText(), Contrato.getSelectedItem().toString());
    		break;
    	default:
    		break;	
    	}
		
    }
    
    
}