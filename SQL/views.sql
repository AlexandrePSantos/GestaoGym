-- 1 Mostrar todos os clientes ativos
CREATE VIEW clientes_ativos as CLIATIV
SELECT c.nome, c.email
FROM Cliente as c
WHERE Subscricao.idCliente = Cliente.idCliente AND Subscricao.Estado = 'Ativa';

--Corrigida
-- 1 Mostrar todos os clientes ativos
CREATE VIEW CLIATIV as 
SELECT c.nome, c.email
FROM Cliente as c, Subscricao as s
WHERE s.idCliente = c.idCliente AND s.Estado = 'Ativa';

-- 2 Mostrar todos os clientes que tem um plano
CREATE VIEW CLIENTEPLANO as 
SELECT c.nome, c.email, p.numPlano
FROM Cliente as c AND PlanoTreino as peso
WHERE Cliente.numPlano = PlanoTreino.numPlano;

-- 3 Mostrar as aulas e horarios de cada sala
CREATE VIEW aulaHorarioSala as
SELECT a.tipoAula, a.dataAula, a.duracao, a.idLocal
FROM AulaGrupo as a
GROUP BY a.idLocal;

-- 4 Mostrar clientes que tem 1 mes para renovar
CREATE VIEW clientesParaRenovar as CLIRENOVAR
SELECT *
FROM CLiente
WHERE Subscricao.idCliente = Cliente.idCliente AND Subscricao.Estado = 'Para renovar'

-- 5 mostrar aulas de certo tipo
-- TODO where tipoAula e' o cliente que mete (fazer em java)
CREATE VIEW aulasCertoTipo as AULASTIPO
SELECT *
FROM AulaGrupo

-- 6 mostrar todos os planos
CREATE VIEW planos AS PLANOS
SELECT numPlano, descricao
FROM PlanoTreino

-- 7 mostrar clientes que ainda nao pagaram
CREATE VIEW clientesParaPagar AS CLIEPAGAR
SELECT *
FROM Cliente
WHERE Subscricao.idCliente = Cliente.idCliente AND Subscricao.Estado = 'Para pagar'

-- 8 mostrar uma certa consulta para um cliente
-- where idCliente e' o cliente que mete (fazer em java)
CREATE VIEW consulta as ConsultaCli
SELECT *
FROM Consulta

-- 9 mostrar restricoes de saude de um cliente para um nutricionista
-- where idCliente e' o cliente que mete (fazer em java)
CREATE VIEW restricoes
SELECT *
FROM RestricaoSaude