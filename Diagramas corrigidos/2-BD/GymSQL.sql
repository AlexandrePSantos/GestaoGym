CREATE DATABASE gymManagement;


CREATE TABLE Funcao (
    idFuncao INT PRIMARY KEY,
    descricao VARCHAR(100)
)

CREATE TABLE PisoSala (
    idLocal INT PRIMARY KEY,
    piso VARCHAR(1),
    sala VARCHAR(2)
)

CREATE TABLE Funcionario (
    idFuncionario INT PRIMARY KEY, 
    idFuncao, 
    nome, 
    email, 
    telemóvel, 
    NIF, 
    dtNascimento DATE, 
    salario
)

CREATE TABLE PlanoTreino (
    numPlano INT PRIMARY KEY, 
    dtCriacao DATE, 
    descricao , 
    idFuncionario
)

CREATE TABLE Cliente (
    idCliente INT PRIMARY KEY, 
    nome, 
    idade, 
    email, 
    telemóvel, 
    dtNascimento DATE, 
    NIF, 
    numPlano INT
)

CREATE TABLE HistoricoNutricao (
    idCliente, 
    peso, 
    IMC, 
    massaGorda, 
    massaMagra
)

CREATE TABLE AulaGrupo (
    numAula INT PRIMARY KEY, 
    dataAula DATE, 
    idLocal, 
    tipoAula, 
    vagas, 
    duracao, 
    idFuncionario
)

CREATE TABLE Consulta (
    numConsulta INT PRIMARY KEY, 
    dataConsulta DATE, 
    idLocal, 
    idFuncionario, 
    idCliente
)

CREATE TABLE Subscricao (
    idCliente, 
    duracao, 
    dataIni DATE, 
    valMensal , 
    valTotal, 
    dataFim, 
    totEmFalta, 
    totPago, 
    estado
)

CREATE TABLE linhaParticipante (
    numAula , 
    idCliente
)

CREATE TABLE Relatorio (
    numConsulta, 
    dataEmissao DATE, 
    descricao
)

CREATE TABLE RestricaoSaude (
    idRestricao INT PRIMARY KEY, 
    descricao
)

CREATE TABLE LinhaRestricao (
    idRestricao INT REFERENCES RestricaoSaude(idRestricao), 
    idCliente INT REFERENCES Cliente(idCliente)
)

CREATE TABLE Pagamento (
    numPagamento INT PRIMARY KEY, 
    valor, 
    estado, 
    dataLimite, 
    dataEfetuado, 
    idCliente
)
