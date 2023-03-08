insert into Funcao (idFuncao, descricao)
values  (1, 'Rececionista'), 
        (2, 'Instrutor'), 
        (3, 'Nutricionista');

insert into PisoSala (idLocal, piso, sala)
values  (1, 1, 1), (2, 1, 2), (3, 1, 3), (4, 1, 4), 
        (5, 1, 5), (6, 2, 1), (7, 2, 2), (8, 2, 3),
        (9, 2, 4), (10, 2, 5);

insert into Funcionario (idFuncionario, idFuncao, nome, email, telemóvel, NIF, dtNascimento, salario)
values  (1, 1,'Dwain Snaden', 'dsnaden0@fc2.com', '9638680740', '2276607035', '21/03/1976', '€934,36' ), 
        (2, 1, 'Emylee Grene', 'egrene1@tmall.com', '9677286053', '8733475878', '28/05/1981', '€934,36'), 
        (3, 2, 'Cos Rayne', 'crayne2@instagram.com', '9693503520', '2667036947', '06/02/1971', '€2177,38'), 
        (4, 2, 'Cammi Hellwing', 'chellwing3@mashable.com', '9642097925', '2259291286', '19/11/1999', '€2209,50'), 
        (5, 3, 'Morton Kagan', 'mkagan4@topsy.com', '9618831303', '8601579633', '23/06/1990', '€2430,86'), 
        (6, 3, 'Iosep Rosin', 'irosin5@illinois.edu', '9626521598', '2619357632', '09/12/1998', '€1617,60');

insert into PlanoTreino (numPlano, dtCriacao, descricao, idFuncionario) 
values  (1, '09/11/2020', 'Plano focado em Cardio para redução de massa gorda.', 3), 
        (2, '19/02/2021', 'Plano focado em Musculação para aumento de massa magra.', 4);

insert into Cliente (idCliente, nome, email, telemóvel, dtNascimento, NIF, numPlano) 
values  (1, 'Alejandro Magnay', 'amagnay0@ibm.com', '964156411', '02/08/1995', '759500619', 2), 
        (2, 'Maurine Thumann', 'mthumann1@etsy.com', '964948514', '16/06/2000', '869975297', 1), 
        (3, 'Cosette Pleass', 'cpleass2@ed.gov', '964572474', '30/08/1962', '892590437', 1), 
        (4, 'Elaina Fairholm', 'efairholm3@japanpost.jp', '967020440', '26/02/1986', '410472625', 2),
        (5, 'Verine Axcell', 'vaxcell4@psu.edu', '969662198', '12/10/1994', '456072561', 1), 
        (6, 'Ax Mosby', 'amosby5@intel.com', '964659222', '11/05/1967', '236224630', 1), 
        (7, 'Ashli Yellop', 'ayellop6@deliciousdays.com', '967568243', '25/05/1998', '991264043', 2), 
        (8, 'Emily Groom', 'egroom7@sakura.ne.jp', '961976264', '16/04/1963', '861422027', 2),
        (9, 'Zandra Arbon', 'zarbon8@dmoz.org', '967333674', '12/04/1975', '421877824', 2),
        (10, 'Hildagard Busain', 'hbusain9@hp.com', '966467363', '11/11/1979', '103649512', 1);

insert into HistoricoNutricao (idCliente, peso, IMC, massaGorda, massaMagra) 
values  (2, 90.2, 20, 22, 17), (1, 55, 30, 19, 24), (4, 77, 37.1, 21, 18), 
        (3, 56, 34, 19, 28), (6, 55, 36.3, 19, 25), (5, 84, 27, 31, 29), 
        (8, 46.9, 31.2, 26, 20), (7, 79.5, 20.5, 19, 26), (9, 56, 27, 29, 29),
        (10, 51, 30, 16, 24);

insert into AulaGrupo (numAula, dataAula, idLocal, tipoAula, vagas, duracao, idFuncionario) 
values  (1, '27/12/2022', 4, 'Musculação', 10, 1, 3),
        (2, '23/12/2021', 4, 'Cycling', 20, 1, 4),
        (3, '20/07/2021', 1, 'Boxing', 15, 2, 3),
        (4, '01/05/2022', 2, 'Crossfit', 30, 3, 4);

insert into Consulta (numConsulta, dataConsulta, idLocal, idFuncionario, idCliente) 
values  (1, '27/11/2022', 7, 5, 2),
        (2, '23/02/2021', 6, 5, 4),
        (3, '20/01/2021', 9, 6, 6),
        (4, '01/12/2022', 10, 6, 8);

insert into Subscricao (idCliente, duracao, dataIni, dataFim, valMensal, valTotal, totEmFalta, totPago, estado) 
values  (1, 6, '10/01/2022', '10/06/2022', 8, 48, 40, 8, 'Ativa'),
        (2, 6, '01/01/2022', '01/06/2022', 8, 48, 0, 48, 'Cancelada'),
        (3, 3, '04/01/2022', '04/03/2022', 15, 45, 0, 45, 'Ativa'),
        (4, 12, '06/01/2022', '06/01/2023', 7, 84, 0, 84, 'Ativa'),
        (5, 12, '03/01/2022', '03/01/2023', 7, 84, 7, 77, 'Ativa'),
        (6, 12, '01/01/2022', '01/01/2023', 7, 84, 0, 84, 'Ativa'),
        (7, 6, '04/01/2022', '04/06/2022', 8, 48, 40, 8, 'Ativa'),
        (8, 6, '03/01/2022', '03/06/2022', 8, 48, 40, 8, 'Cancelada'),
        (9, 3, '05/01/2022', '05/03/2022', 15, 45, 15, 30, 'Ativa'),
        (10, 3, '07/01/2022', '07/03/2022', 15, 45, 0, 45, 'Ativa');

insert into linhaParticipante (numAula, idCliente) 
values  (2, 8), (2, 6), (4, 4), (1, 7), (2, 10), (4, 7), (2, 4), (3, 5),
        (3, 7), (3, 8), (3, 8), (2, 8), (4, 1), (2, 1), (4, 10), (3, 8),
        (1, 6), (4, 8), (4, 4), (1, 1);

insert into Relatorio (numConsulta, dataEmissao, descricao) 
values  (1, '27/11/2022', 'Peso aumentou 2 kg, ganhou massa magra, perdeu massa gorda.'),
        (2, '23/02/2021', 'Peso reduziu 3 kg, manteve massa magra, perdeu massa gorda.'),
        (3, '20/01/2021', 'Peso aumentou 6 kg, ganhou massa magra, ganhou massa gorda.'),
        (4, '01/12/2022', 'Peso reduziu 1 kg, perdeu massa magra, manteve massa gorda.');

insert into RestricaoSaude (idRestricao, descricao) 
values  (1, 'Asma'), (2, 'Alergias'), (3, 'Diabetes');

insert into LinhaRestricao (idRestricao, idCliente) 
values  (1, 3), (2, 6), (3, 2);

insert into Pagamento (numPagamento, valor, estado, dataLimite, dataEfetuado, idCliente) 
values  (1, 20, 'pago', '27/11/2022', '27/11/2022', 2),
        (2, 55.1, 'pendente', '05/01/2022', NULL, 3),
        (3, 34, 'pago', '17/12/2021', '16/12/2021', 6);  
