insert into Funcionario (idFuncionario, nome, email, telemovel, NIF, dtNascimento, salarioLiquido, funcao) values (1, 'Malinde Sacher', 'msacher0@businessweek.com', '9631938249', '228379888', '1985-12-30', 900, 'Rececionista');
insert into Funcionario (idFuncionario, nome, email, telemovel, NIF, dtNascimento, salarioLiquido, funcao) values (2, 'Auguste Gammet', 'agammet1@bloglovin.com', '9618851470', '873192434', '1983-03-17', 1200, 'Instrutor');
insert into Funcionario (idFuncionario, nome, email, telemovel, NIF, dtNascimento, salarioLiquido, funcao) values (3, 'Almeida Garret', 'meidabarreto@hotmail.com', '9687534273', '973122334', '1990-05-27', 1250, 'Instrutor');

insert into Cliente (idCliente, nome, email, telemovel, NIF, dtNascimento, cPostal) values (1, 'Britney Gration', 'bgration0@drupal.org', '4267301704', 332629286, '1961-08-27', '4900-123');
insert into Cliente (idCliente, nome, email, telemovel, NIF, dtNascimento, cPostal) values (2, 'Agnella Botha', 'abotha1@netvibes.com', '1383149027', 430641665, '1979-12-12', '4900-333');
insert into Cliente (idCliente, nome, email, telemovel, NIF, dtNascimento, cPostal) values (3, 'Grayce Peron', 'gperon2@hubpages.com', '3199679764', 402387390, '1978-9-24', '4926-236');
insert into Cliente (idCliente, nome, email, telemovel, NIF, dtNascimento, cPostal) values (4, 'Pier Flott', 'pflott3@omniture.com', '4765926623', 467863723, '1970-10-5', '4925-654');

insert into RestricaoSaude (idRestricao, descricao) values (1, 'Escoliose');
insert into RestricaoSaude (idRestricao, descricao) values (2, 'Asma');

insert into LinhaRestricao (idRestricao, idCliente) values (1, 1);
insert into LinhaRestricao (idRestricao, idCliente) values (2, 2);

insert into Sala (idSala, sala) values (1, 'S1.1');
insert into Sala (idSala, sala) values (2, 'S1.2');
insert into Sala (idSala, sala) values (3, 'S1.3');
insert into Sala (idSala, sala) values (4, 'S2.1');
insert into Sala (idSala, sala) values (5, 'S2.2');
insert into Sala (idSala, sala) values (6, 'S2.3');
insert into Sala (idSala, sala) values (7, 'S3.1');
insert into Sala (idSala, sala) values (8, 'S3.2');
insert into Sala (idSala, sala) values (9, 'S3.3');

insert into AulaGrupo (numAula, dataAula, tipoAula, vagas, vagasDisp, duracao, idSala, idFuncionario) values (1, '2021-12-22', 'Musculacao', 14, 10, 50, 1, 2);
insert into AulaGrupo (numAula, dataAula, tipoAula, vagas, vagasDisp, duracao, idSala, idFuncionario) values (2, '2021-12-23', 'Cycling', 14, 10, 25, 4, 3);
insert into AulaGrupo (numAula, dataAula, tipoAula, vagas, vagasDisp, duracao, idSala, idFuncionario) values (3, '2022-10-04', 'Yoga', 10, 8, 30, 3, 2);

insert into linhaParticipante (numAula, idCliente) values (1, 1);
insert into linhaParticipante (numAula, idCliente) values (1, 2);
insert into linhaParticipante (numAula, idCliente) values (1, 3);
insert into linhaParticipante (numAula, idCliente) values (1, 4);
insert into linhaParticipante (numAula, idCliente) values (2, 1);
insert into linhaParticipante (numAula, idCliente) values (2, 2);
insert into linhaParticipante (numAula, idCliente) values (2, 3);
insert into linhaParticipante (numAula, idCliente) values (2, 4);
insert into linhaParticipante (numAula, idCliente) values (3, 1);
insert into linhaParticipante (numAula, idCliente) values (3, 2);

insert into Subscricao (numSubscricao, idCliente, dataIni, dataFim, valEmFalta, valTotal, estado) values (1, 1, '2022-08-09', '2023-08-09', 45, 60, 'ativa');
insert into Subscricao (numSubscricao, idCliente, dataIni, dataFim, valEmFalta, valTotal, estado) values (2, 2, '2022-05-11', '2023-05-11', 20, 60, 'ativa');
insert into Subscricao (numSubscricao, idCliente, dataIni, dataFim, valEmFalta, valTotal, estado) values (3, 3, '2022-11-04', '2023-11-04', 30, 60, 'ativa');
insert into Subscricao (numSubscricao, idCliente, dataIni, dataFim, valEmFalta, valTotal, estado) values (4, 4, '2022-11-11', '2023-11-11', 40, 60, 'ativa');

insert into Pagamento (numPagamento, valor, estado, dataLimite, dataEfetuado, metodoPag, numSubscricao) values (1, 15, 'Pago', '2022-08-28', '2022-08-26', 'Débito', 1);
insert into Pagamento (numPagamento, valor, estado, dataLimite, dataEfetuado, metodoPag, numSubscricao) values (2, 20, 'Pago', '2022-05-13', '2022-05-11', 'Crédito', 2);
insert into Pagamento (numPagamento, valor, estado, dataLimite, dataEfetuado, metodoPag, numSubscricao) values (3, 20, 'Pago', '2022-05-17', '2022-05-15', 'MBway', 2);
insert into Pagamento (numPagamento, valor, estado, dataLimite, dataEfetuado, metodoPag, numSubscricao) values (4, 10, 'Pago', '2022-12-12', '2022-12-10', 'Paypal', 3);
insert into Pagamento (numPagamento, valor, estado, dataLimite, dataEfetuado, metodoPag, numSubscricao) values (5, 10, 'Pago', '2022-12-23', '2022-12-21', 'Débito', 3);
insert into Pagamento (numPagamento, valor, estado, dataLimite, dataEfetuado, metodoPag, numSubscricao) values (6, 10, 'Pago', '2022-01-22', '2022-01-20', 'Crédito', 3);
insert into Pagamento (numPagamento, valor, estado, dataLimite, dataEfetuado, metodoPag, numSubscricao) values (7, 15, 'Pago', '2022-12-19', '2022-12-17', 'MBway', 4);
insert into Pagamento (numPagamento, valor, estado, dataLimite, dataEfetuado, metodoPag, numSubscricao) values (8, 5, 'Pago', '2022-01-29', '2022-01-27', 'Paypal', 4);

insert into Equipamento (idEquipamento, nome) values (1, 'Halteres');
insert into Equipamento (idEquipamento, nome) values (2, 'Passadeira');
insert into Equipamento (idEquipamento, nome) values (3, 'Bicicleta');

insert into Exercicio (idExercicio, nome, idEquipamento) values (1, 'Bench-press', 1);
insert into Exercicio (idExercicio, nome, idEquipamento) values (2, 'Corrida', 2);
insert into Exercicio (idExercicio, nome, idEquipamento) values (3, 'Cycling', 3);

insert into PlanoTreino (numPlano, dtCriacao, estado, idFuncionario, idCliente) values (1, '2022-08-03', 'inativo', 2, 1);
insert into PlanoTreino (numPlano, dtCriacao, estado, idFuncionario, idCliente) values (2, '2023-02-20', 'ativo', 2, 1);
insert into PlanoTreino (numPlano, dtCriacao, estado, idFuncionario, idCliente) values (3, '2022-11-07', 'ativo', 2, 2);
insert into PlanoTreino (numPlano, dtCriacao, estado, idFuncionario, idCliente) values (4, '2022-11-13', 'ativo', 2, 3);
insert into PlanoTreino (numPlano, dtCriacao, estado, idFuncionario, idCliente) values (5, '2022-12-13', 'ativo', 2, 4);

insert into LinhaExercicio (idExercicio, numplano, peso, sets, reps, velocidade, duracao) values (1, 1, 20, 3, 12, NULL, NULL);
insert into LinhaExercicio (idExercicio, numplano, peso, sets, reps, velocidade, duracao) values (1, 2, 30, 4, 10, NULL, NULL);
insert into LinhaExercicio (idExercicio, numplano, peso, sets, reps, velocidade, duracao) values (2, 2, NULL, 1, NULL, 7, 30);
insert into LinhaExercicio (idExercicio, numplano, peso, sets, reps, velocidade, duracao) values (2, 3, NULL, 1, NULL, 12, 25);
insert into LinhaExercicio (idExercicio, numplano, peso, sets, reps, velocidade, duracao) values (2, 4, NULL, 2, NULL, 10, 30);
insert into LinhaExercicio (idExercicio, numplano, peso, sets, reps, velocidade, duracao) values (3, 5, NULL, 1, NULL, 20, 45);
