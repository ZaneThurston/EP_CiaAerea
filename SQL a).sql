--PRIMEIRO CÓDIGO

SELECT * FROM voo 
WHERE rot_codigo IN 
	(SELECT rot_codigo FROM rota WHERE aer_icao_origem IN 
		(SELECT aer_icao FROM aeroporto WHERE aeroporto.aer_loc_cidade='São Paulo') AND aer_icao_destino IN 
			(SELECT aer_icao FROM aeroporto WHERE aeroporto.aer_loc_cidade='Rio de Janeiro')AND voo_data='01/03/2018');


--SEGUNDO CÓDIGO
SELECT pessoa.pes_cpf, sum(bag_peso) AS soma
            FROM bagagem, pessoa
            WHERE bagagem.pes_cpf = pessoa.pes_cpf
            GROUP BY pessoa.pes_cpf;


--TERCEIRO CÓDIGO
SELECT aeronave.avi_serial_number,
    aeronave.avi_matricula,
    aeronave.avi_mod_modelo,
    aeronave.avi_categoria,
    aeronave_modelo.avi_mod_capacidade,
    tecnico_manutencao.pes_cpf,
    tecnico_manutencao.tec_anac,
    tecnico_manutencao.tec_tipo_contrato,
    manutencao.man_nome,
    manutencao.man_desricao,
    reparo.rep_orcamento
   FROM aeronave,
    aeronave_modelo,
    reparo,
    tecnico_manutencao,
    manutencao
  WHERE aeronave_modelo.avi_mod_modelo = aeronave.avi_mod_modelo AND reparo.avi_serial_number = aeronave.avi_serial_number AND tecnico_manutencao.pes_cpf = reparo.tec_cpf AND manutencao.man_codigo = reparo.man_codigo;

