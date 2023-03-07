CREATE VIEW clientes_ativos as CLIATIV
SELECT c.nome, c.email
FROM Cliente as c
WHERE Subscricao.idCliente = Cliente.idCliente AND Subscricao.Estado = 'Ativa';

CREATE VIEW clientes_planos as CLIPLA
SELECT c.nome, c.email, p.numPlano
FROM Cliente as c AND 