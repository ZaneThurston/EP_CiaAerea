/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Marcos
 */
import java.sql.Statement;
import java.time.LocalDate;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class BdConnector {
   static String url = "jdbc:postgresql://zane-linhas-aereas.postgres.database.azure.com/cia_aerea?ssl=true";
   static Connection con;
    BdConnector() {
    	
    }
    
    
    public static int Connect(String user, String password) {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
        	JOptionPane.showMessageDialog(null, "Nao foi possivel logar no banco de dados, usuario e/ou senha invalido(s).", "Erro", JOptionPane.OK_OPTION); //mostra uma caixa de dialogo
            return 0;
            
        }
        return 1;
    }
    
    public static int CloseConnection() {
         try {
            if (!con.isClosed()) con.close();
         } catch (SQLException e) {
             System.out.println("Nao foi possivel fechar a conexao com o banco de dados.");
             return 1;
         }
         return 0;
    }
    
//-----------------------------CADASTROS------------------------------------

    static void insere_comissario_linguas(int com_lin_cpf, String com_lin_lingua) {
		String sql = "INSERT INTO comissario_linguas (com_lin_cpf,com_lin_lingua) VALUES ('"+com_lin_cpf+
				"','"+com_lin_lingua+"');";
		
		try {
			Statement stm = con.createStatement();
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Nao foi possivel salvar os valores", "Erro", JOptionPane.OK_OPTION); //mostra uma caixa de dialogo
		}
		
	}
	
	static void insere_voo(Date voo_data, String voo_horario_saida, String voo_horario_chegada, int avi_serial_number, int rot_codigo, int  pes_cpf) {
		int id;
		String sql = "INSERT INTO voo (voo_id, voo_data, voo_horario_saida, voo_horario_chegada, avi_serial_number, rot_codigo, pes_cpf) VALUES (?, ?, ?, ?, ?, ?, ?);",
			   pk = "SELECT COUNT(*) FROM voo";
		
		try {
			Statement cont = con.createStatement();
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet newpk = cont.executeQuery(pk);
			id = newpk.getInt(1);
			stm.setInt(1, id+1);
			stm.setDate(2, voo_data);
			stm.setString(3, voo_horario_saida);
			stm.setString(4, voo_horario_chegada);
			stm.setInt(5, avi_serial_number);
			stm.setInt(6, rot_codigo);
			stm.setInt(7, pes_cpf);
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Nao foi possivel salvar os valores", "Erro", JOptionPane.OK_OPTION); //mostra uma caixa de dialogo
		}
		
	}
	
	static void insere_reparo(int tec_cpf, String man_codigo, int avi_serial_number, Date rep_date_inicial, Date rep_date_final, float rep_orcamento) {
        String sql = "INSERT INTO reparo (tec_cpf,man_codigo, avi_serial_number, rep_data_ini, rep_data_fim, rep_orcamento) VALUES ('"+tec_cpf+
                "','"+man_codigo+"','"+avi_serial_number+"','"+rep_date_inicial+"','"+rep_date_final+"','"+rep_orcamento+"');";
		
		try {
			Statement stm = con.createStatement();
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e, "Erro", JOptionPane.OK_OPTION); //mostra uma caixa de dialogo
		}
		
	}

	static void insere_rota(int rot_codigo, String aer_icao_origem, String aer_icao_destino, String rot_frequencia) {
		String sql = "INSERT INTO rota (rot_codigo,aer_icao_origem,aer_icao_destino,rot_frequencia) VALUES ('"+rot_codigo+
				"','"+aer_icao_origem+"','"+aer_icao_destino+"','"+rot_frequencia+"');";
		
		try {
			Statement stm = con.createStatement();
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Nao foi possivel salvar os valores", "Erro", JOptionPane.OK_OPTION); //mostra uma caixa de dialogo
		}
		
	}
 
    static void insere_aeroporto_portoes(String  aer_icao, String aer_por_portao) {
		String sql = "INSERT INTO aeroporto_portoes (aer_icao,aer_por_portao,pas_classe) VALUES ('"+aer_icao+"','"+aer_por_portao+"');";
		
		try {
			Statement stm = con.createStatement();
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Nao foi possivel salvar os valores", "Erro", JOptionPane.OK_OPTION); //mostra uma caixa de dialogo
		}
		
	}
	
	static void insere_manutencao(int man_codigo , String man_nome, String man_desricao) {
		String sql = "INSERT INTO manutencao(man_codigo ,man_nome,man_descricao,pas_classe) VALUES ('"+man_codigo +"','"+man_nome+"','"+man_desricao+"');";
		
		try {
			Statement stm = con.createStatement();
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Nao foi possivel salvar os valores", "Erro", JOptionPane.OK_OPTION); //mostra uma caixa de dialogo
		}
		
	}
		
	static void insere_passagem(String pas_coluna, String pas_fileira,int voo_id,String pas_classe, Date pas_data_compra) {
		String sql = "INSERT INTO passagem (pas_coluna,pas_fileira) VALUES ('"+pas_coluna+"','"+pas_fileira+"','"+voo_id+"','"+pas_classe+"','"+pas_data_compra+"','"+pas_coluna+"');";
		
		try {
			Statement stm = con.createStatement();
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Nao foi possivel salvar os valores", "Erro", JOptionPane.OK_OPTION); //mostra uma caixa de dialogo
		}
		
	}

	static void insere_aeroporto(String aer_icao, String aer_nome, String aer_cidade, String aer_estado, boolean aer_oficina, int aer_hub, String aer_park) {
		String sql = "INSERT INTO aeroporto (aer_icao,aer_nome,aer_cidade,aer_estado,aer_oficina,aer_hub,aer_park) VALUES ('"+aer_icao+
				"','"+aer_nome+"','"+aer_cidade+"','"+aer_estado+"','"+aer_oficina+"','"+aer_hub+"','"+aer_park+"');";
		
		try {
			Statement stm = con.createStatement();
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Nao foi possivel salvar os valores", "Erro", JOptionPane.OK_OPTION); //mostra uma caixa de dialogo
		}
		
	}

	static void insere_comissario(int pes_cpf, String com_cht) {
		String sql = "INSERT INTO comissario (pes_cpf,com_cht) VALUES ('"+pes_cpf+
				"','"+com_cht+"');";
		
		try {
			Statement stm = con.createStatement();
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Nao foi possivel salvar os valores", "Erro", JOptionPane.OK_OPTION); //mostra uma caixa de dialogo
		}
		
	}

	static void insere_habilitacoes(int pil_hab_cpf, String pil_hab_habilitacao) {
		String sql = "INSERT INTO piloto_habilitacoes (pil_hab_cpf,pil_hab_habilitacao) VALUES ('"+pil_hab_cpf+
				"','"+pil_hab_habilitacao+"');";
		
		try {
			Statement stm = con.createStatement();
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Nao foi possivel salvar os valores", "Erro", JOptionPane.OK_OPTION); //mostra uma caixa de dialogo
		}
		
	}

	static void insere_tecnico(int pes_cpf, String tec_anac, String tec_tipo_contrato) {
		String sql = "INSERT INTO tecnico_manutencao (pes_cpf,tec_anac,tec_tipo_contrato) VALUES ('"+pes_cpf+
				"','"+tec_anac+"','"+tec_tipo_contrato+"');";
		
		try {
			Statement stm = con.createStatement();
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Nao foi possivel salvar os valores", "Erro", JOptionPane.OK_OPTION); //mostra uma caixa de dialogo
		}
		
	}	

	static void insere_aeronave(int avi_serial_number, String avi_matricula, String avi_modelo, String avi_categoria, int avi_capacidade) {
		String sql1 = "INSERT INTO aeronave (avi_serial_number,avi_matricula,avi_modelo,avi_categoria) VALUES (?, ?, ?, ?);";
		
		try {
			PreparedStatement stm = con.prepareStatement(sql1);
			stm.setInt(1, avi_serial_number);
			stm.setString(2, avi_matricula);
			stm.setString(3, avi_modelo);
			stm.setString(4, avi_categoria);
			stm.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Nao foi possivel salvar os valores", "Erro", JOptionPane.OK_OPTION); //mostra uma caixa de dialogo
		}
		
	}	

	static void insere_bagagem(int bag_numero, int bag_peso, int pes_cpf) {
		String sql = "INSERT INTO bagagem (bag_numero,bag_peso,pes_cpf) VALUES ('"+bag_numero+
				"','"+bag_peso+"','"+pes_cpf+"');";
		
		try {
			Statement stm = con.createStatement();
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro", "Nao foi possivel salvar os valores", JOptionPane.OK_OPTION); //mostra uma caixa de dialogo
		}
		
	}	

	static void insere_piloto(int pes_cpf, String pil_breve, int pil_horas_voo) {
		String sql = "INSERT INTO piloto (pes_cpf,pil_breve,pil_horas_voo) VALUES ('"+pes_cpf+
				"','"+pil_breve+"','"+pil_horas_voo+"');";
		
		try {
			Statement stm = con.createStatement();
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro", "Nao foi possivel salvar os valores", JOptionPane.OK_OPTION); //mostra uma caixa de dialogo
		}
		
	}

	static void insere_pessoa(int pes_cpf,
									 String pes_nome,
									 char pes_sexo,
									 Date pes_bday,
									 String pes_mail,
									 String pes_rua,
									 int pes_numero,
									 String pes_bairro,
									 String pes_complemento,
									 boolean pes_flag_cliente,
									 boolean pes_flag_empregado,
									 int pes_cod_func,
									 String pes_tipo_func,
									 String pes_passaporte,
									 String pes_necessidades_especiais) {
		String sql = "INSERT INTO pessoa"
				+" (pes_cpf, pes_nome, pes_sexo, pes_bday, pes_mail, pes_rua, pes_numero, pes_bairro, pes_complemento, pes_flag_cliente, pes_flag_empregado," 
				+" pes_cod_func, pes_tipo_func, pes_passaporte, pes_necessidades_especiais)"
				+" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; // n�o importa que tenha os '?', eles ser�o substituidos ao setar os campos no preparedStatement
		
		try {
			
			// PreparedStatement, uma forma mais "bonita" pra executar uma query
			PreparedStatement stm = con.prepareStatement(sql); // prepara o statement com uma string generalizada do comando SQL
			stm.setInt(1, pes_cpf); 						// �ndice de par�metros come�a no 1, passa o cpf como int
			stm.setString(2, pes_nome);						// 2, passa o nome como String
			stm.setString(3, Character.toString(pes_sexo));	// 3, passa o sexo como String (convers�o pra char fica a cargo da API)
			stm.setDate(4, pes_bday);						// 4, etc.
			stm.setString(5, pes_mail);
			stm.setString(6, pes_rua);
			stm.setInt(7, pes_numero);
			stm.setString(8, pes_bairro);
			stm.setString(9, pes_complemento);
			stm.setBoolean(10, pes_flag_cliente);
			stm.setBoolean(11, pes_flag_empregado);
			stm.setInt(12, pes_cod_func);
			stm.setString(13, pes_tipo_func);
			stm.setString(14, pes_passaporte);
			stm.setString(15, pes_necessidades_especiais);
			
			stm.executeUpdate();	// executa o comando, n�o precisa passar a string como par�metro pois j� foi passada antes
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro", "Nao foi possivel salvar os valores", JOptionPane.OK_OPTION); //mostra uma caixa de dialogo
		}
		
	}
 
	
// -------------------------- CONSULTAS -----------------------------------------------------
	
	//cria a view de manuten��o
	static ResultSet ManuView(){
		ResultSet view = null;
		String sql = " SELECT aeronave.avi_serial_number, aeronave.avi_matricula, aeronave.avi_mod_modelo,aeronave.avi_categoria, aeronave_modelo.avi_mod_capacidade, tecnico_manutencao.pes_cpf, tecnico_manutencao.tec_anac, tecnico_manutencao.tec_tipo_contrato, manutencao.man_nome, manutencao.man_desricao, reparo.rep_orcamento FROM aeronave, aeronave_modelo, reparo, tecnico_manutencao, manutencao WHERE aeronave_modelo.avi_mod_modelo = aeronave.avi_mod_modelo AND reparo.avi_serial_number = aeronave.avi_serial_number AND tecnico_manutencao.pes_cpf = reparo.tec_cpf AND manutencao.man_codigo = reparo.man_codigo;";
		
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			view = stm.executeQuery();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e+"\nNao foi possivel recuperar os dados", "Erro", JOptionPane.OK_OPTION);
		}
		
		return view;
	}
	
	//cria a view de manuten��o
		static ResultSet VooView(){
			ResultSet view = null;
			String sql = "SELECT voo.voo_data, voo.voo_horario_saida, voo.voo_horario_chegada, rota.aer_icao_origem, rota.aer_icao_destino, aeronave.avi_matricula,"+
    "aeronave.avi_mod_modelo, pessoa.pes_cpf, pessoa.pes_nome, pessoa.pes_mail, pessoa.pes_passaporte, pessoa.pes_necessidades_especiais, passagem.pas_data_compra,"+
    "passagem.ass_coluna, passagem.ass_fileira FROM voo, aeronave, piloto, rota, passagem, pessoa WHERE voo.voo_id = passagem.voo_id AND "+
    "voo.avi_serial_number = aeronave.avi_serial_number AND voo.rot_codigo = rota.rot_codigo AND voo.pes_cpf = piloto.pes_cpf AND passagem.pes_cpf = pessoa.pes_cpf;";
			
			try {
				PreparedStatement stm = con.prepareStatement(sql);
				view = stm.executeQuery();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e+"\nNao foi possivel recuperar os dados", "Erro", JOptionPane.OK_OPTION);
			}
			
			return view;
		}
	
	// lista os funcionarios de um cargo selecionado, ou todos
	static ResultSet listaFuncionarios(String param) {
		ResultSet results = null;
		String sql = "SELECT * FROM pessoa WHERE pes_flag_empregado=true;",
		       sql2 = sql.replace(';', ' ') + "AND pes_tipo_func=?;";
		
		try {
			
			PreparedStatement stm;
			switch (param) {
			case "Piloto":
				stm = con.prepareStatement(sql2);
				stm.setString(1, "Piloto");
				break;
			case "Comiss�rio":
				stm = con.prepareStatement(sql2);
				stm.setString(1, "Comiss�rio");
				break;
			/*(case "Mec�nico":
				stm = con.prepareStatement(sql2);
				stm.setString(1, "Mec�nico");
				break;*/
			case "Administra��o":
				stm = con.prepareStatement(sql2);
				stm.setString(1, "Administra��o");
				break;
			default:
				stm = con.prepareStatement(sql);
				break;
			}
			results = stm.executeQuery();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Dados nao encontrados.", "Erro", JOptionPane.OK_OPTION);
		}
		
		return results;
	}
	
	
	
	// lista a frota de aeronaves em posse da cia
	static ResultSet listaFrota() {
		ResultSet fleet = null;
		String sql = "SELECT * FROM aeronave";
		
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			fleet = stm.executeQuery();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Nao foi possivel recuperar os dados", "Erro", JOptionPane.OK_OPTION);
		}
		
		return fleet;
	}
	
	// lista os reparos de uma aeronave dado o seu numero de serie
	static ResultSet listaReparos(int serial) {
		ResultSet res = null;
		String sql = "SELECT * FROM reparo",
			   sql2 = sql + " WHERE avi_serial_number=?";
		
		try {
			PreparedStatement stm;
			if (serial < 1) stm = con.prepareStatement(sql);
			else {
				stm = con.prepareStatement(sql2);
				stm.setInt(1, serial);
			}
			res = stm.executeQuery();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Nao foi possivel recuperar os dados", "Erro", JOptionPane.OK_OPTION);
		}
		
		return res;
	}
	
	// lista os voos realizados dados a origem, o destino, e uma data
	static ResultSet listaVoos(String orig, String dest, LocalDate data) {
		ResultSet res = null;
		String sql = "SELECT * FROM voo "+
					 "WHERE rot_codigo IN (SELECT rot_codigo FROM rota WHERE aer_icao_origem "+
					 "IN (SELECT aer_icao FROM aeroporto WHERE aeroporto.aer_loc_cidade=?) " +
					 "AND aer_icao_destino IN (SELECT aer_icao FROM aeroporto WHERE aeroporto.aer_loc_cidade=?) " +
					 "AND voo_data=?);";
		try {
			PreparedStatement stm;
			stm = con.prepareStatement(sql);
			stm.setString(1, orig);
			stm.setString(2, dest);
			stm.setDate(3, Date.valueOf(data));
			res = stm.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Nao foi possivel recuperar os dados", "Erro", JOptionPane.OK_OPTION);
		}
		
		return res;
	}
	
	// soma os valores dos custos dos reparos de uma aeronave dado o seu numero de serie
	static ResultSet total_rep_orcamento_oficina(int serial) {
		ResultSet res = null;
		String sql = 	"SELECT sum(rep_orcamento) FROM reparo",
			   sql2 = sql + " WHERE avi_serial_number= ?"; 
		
		try {
			PreparedStatement stm;
			if (serial >0) {
				stm = con.prepareStatement(sql2);
				stm.setInt(1, serial);
			} else stm = con.prepareStatement(sql);
			res = stm.executeQuery();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Nao foi possivel recuperar os dados", "Erro", JOptionPane.OK_OPTION);
		}
		
		return res;
	}
	
	// retorna uma listagem de voos realizado por um comissario dado um intervalo de tempo
	static ResultSet listaVoosComiss(String cpf, LocalDate data1, LocalDate data2) {
		ResultSet res = null;
		String sql = "select * from voo, voo_comissarios " +
					 "where voo.voo_id=voo_comissarios.voo_id "+
					 "and voo_comissarios.com_cpf=? " +
					 "and voo.voo_data between ? and ?;";
		try {
			PreparedStatement stm;
			stm = con.prepareStatement(sql);
			stm.setLong(1, Long.parseLong(cpf));
			stm.setDate(2, Date.valueOf(data1));
			stm.setDate(3, Date.valueOf(data2));
			res = stm.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Nao foi possivel recuperar os dados", "Erro", JOptionPane.OK_OPTION);
		}
		return res;
	}
	
	static void listaPassagens() {
		String sql = "SELECT * FROM passagem";
		
		try {
			Statement stm = con.createStatement();
			ResultSet consulta = stm.executeQuery(sql);
			while(consulta.next()) {
				int coluna= consulta.getInt("pas_coluna");
				String pas_fileira = consulta.getString("pas_fileira");
				int voo_id = consulta.getInt("voo_id");
				String classe = consulta.getString("pas_classe");
				Date data_compra = consulta.getDate("pas_data_compra");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Nao foi possivel salvar os valores", "Erro", JOptionPane.OK_OPTION); //mostra uma caixa de dialogo
		}
		
	}
	
	static void listaRotas() {
		String sql = "SELECT * FROM rota";
			
		try {
			Statement stm = con.createStatement();
			ResultSet consulta = stm.executeQuery(sql);
			while(consulta.next()) {
				int codigo = consulta.getInt("rot_codigo");
				String  origem = consulta.getString("aer_icao_origem");
				String  destino = consulta.getString("aer_icao_destino");
				String  frequencia = consulta.getString("rot_frequencia");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Nao foi possivel salvar os valores", "Erro", JOptionPane.OK_OPTION); //mostra uma caixa de dialogo
		}
		
	}
	
	

}
