--ORIGINAL

SELECT * FROM voo
WHERE rot_codigo IN
    (SELECT rot_codigo FROM rota WHERE aer_icao_origem IN
        (SELECT aer_icao FROM aeroporto WHERE aeroporto.aer_loc_cidade='São Paulo') AND aer_icao_destino IN
            (SELECT aer_icao FROM aeroporto WHERE aeroporto.aer_loc_cidade='Rio de Janeiro')AND voo_data='01/03/2018');


--NOVO


SELECT * FROM voo, rota INNER JOIN aeroporto AS aOrigem
    ON(rota.aer_icao_origem = aOrigem.aer_icao) INNER JOIN aeroporto AS aDestino
    ON(rota.aer_icao_destino = aDestino.aer_icao)
    WHERE voo_data = '01/03/2018'
      AND aOrigem.aer_loc_cidade = 'São Paulo'
      AND aDestino.aer_loc_cidade = 'Rio de Janeiro';
