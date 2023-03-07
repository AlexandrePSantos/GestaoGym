--Funcao
insert into Funcao (idFuncao, descricao)
values (1, 'Rececionista'), (2, 'Instrutor'), (3, 'Nutricionista');

--PisoSala
insert into PisoSala (idLocal, piso, sala)
values (1, 'Rececionista'), (2, 'Instrutor'), (3, 'Nutricionista');

--Funcionario
insert into Funcionario (idFuncionario, idFuncao, nome, email, telemóvel, NIF, dtNascimento, salario)
values (), (), ();

--PlanoTreino
insert into PlanoTreino (numPlano, dtCriacao, descricao, idFuncionario) 
values (), ();

--Cliente
insert into Cliente (idLocal, piso, idade, email, telemóvel, dtNascimento, NIF, numPlano) 
values (), (), (), ();

--HistoricoNutricao
insert into HistoricoNutricao (idCliente, peso, IMC, massaGorda, massaMagra) 
values (

--AulaGrupo
insert into AulaGrupo (numAula, dataAula, idLocal, tipoAula, vagas, duracao, idFuncionario) 
values (

--Consulta
insert into Consulta (numConsulta, dataConsulta, idLocal, idFuncionario, idCliente) 
values (

--Subscricao
insert into Subscricao (idCliente, duracao, dataIni, valMensal, valTotal, dataFim, totEmFalta, totPago, estado) 
values (

--linhaParticipante
insert into linhaParticipante (numAula, idCliente) 
values (

--Relatorio
insert into Relatorio (numConsulta, dataEmissao, descricao) 
values (

--RestricaoSaude
insert into RestricaoSaude (idRestricao, descricao) 
values (

--LinhaRestricao
insert into LinhaRestricao (idRestricao, idCliente) 
values (

--Pagamento
insert into Pagamento (numPagamento, valor, estado, dataLimite, dataEfetuado, idCliente) 
values (
