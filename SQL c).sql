--CÓDIGO ORIGINAL

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


--CÓDIGO NOVO

SELECT * FROM
    (SELECT aeronave.*
     FROM aeronave, aeronave_modelo
     WHERE aeronave_modelo.avi_mod_modelo = aeronave.avi_mod_modelo) AS aero INNER JOIN
    (SELECT tecnico_manutencao.*, manutencao.man_nome, manutencao.man_desricao, reparo.rep_orcamento, reparo.avi_serial_number
     FROM tecnico_manutencao, manutencao, reparo
     WHERE tecnico_manutencao.pes_cpf = reparo.tec_cpf AND manutencao.man_codigo = reparo.man_codigo)
     AS manu ON manu.avi_serial_number = aero.avi_serial_number;
