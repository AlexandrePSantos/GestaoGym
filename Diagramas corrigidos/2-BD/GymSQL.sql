CREATE DATABASE gymManagement;


CREATE TABLE Funcao (
    idFuncao INT PRIMARY KEY NOT_NULL,
    descricao VARCHAR(100)
)

CREATE TABLE PisoSala (
    idLocal INT PRIMARY KEY NOT_NULL,
    piso VARCHAR(1),
    sala VARCHAR(2)
)

CREATE TABLE Funcionario (
    idFuncionario INT PRIMARY KEY NOT_NULL, 
    idFuncao INT, 
    nome VARCHAR(100), 
    email VARCHAR(50), 
    telemóvel INT, 
    NIF INT, 
    dtNascimento DATE, 
    salario DECIMAL(7,2)
)

CREATE TABLE PlanoTreino (
    numPlano INT PRIMARY KEY NOT_NULL, 
    dtCriacao DATE, 
    descricao VARCHAR(200), 
    idFuncionario INT
)

CREATE TABLE Cliente (
    idCliente INT PRIMARY KEY NOT_NULL, 
    nome VARCHAR(200), 
    idade INT, 
    email VARCHAR(100), 
    telemóvel INT, 
    dtNascimento DATE, 
    NIF INT, 
    numPlano INT
)

CREATE TABLE HistoricoNutricao (
    idCliente INT, 
    peso DECIMAL(3,2), 
    IMC DECIMAL(2,1), 
    massaGorda INT, 
    massaMagra INT
)

CREATE TABLE AulaGrupo (
    numAula INT PRIMARY KEY NOT_NULL, 
    dataAula DATE, 
    idLocal INT, 
    tipoAula VARCHAR(1), 
    vagas INT, 
    duracao TIME, /*TODO Procurar*/ 
    idFuncionario INT
)

CREATE TABLE Consulta (
    numConsulta INT PRIMARY KEY NOT_NULL, 
    dataConsulta DATE, 
    idLocal INT, 
    idFuncionario INT, 
    idCliente INT
)

CREATE TABLE Subscricao (
    idCliente INT, 
    duracao TIME, 
    dataIni DATE, 
    valMensal DECIMAL(3,2), 
    valTotal DECIMAL(3,2), 
    dataFim DATE, 
    totEmFalta DECIMAL(3,2), 
    totPago DECIMAL(4,2), 
    estado VARCHAR(20)
)

CREATE TABLE linhaParticipante (
    numAula INT, 
    idCliente INT
)

CREATE TABLE Relatorio (
    numConsulta INT, 
    dataEmissao DATE, 
    descricao VARCHAR(200)
)

CREATE TABLE RestricaoSaude (
    idRestricao INT PRIMARY KEY, 
    descricao VARCHAR(200)
)

CREATE TABLE LinhaRestricao (
    idRestricao INT REFERENCES RestricaoSaude(idRestricao), 
    idCliente INT REFERENCES Cliente(idCliente)
)

CREATE TABLE Pagamento (
    numPagamento INT PRIMARY KEY, 
    valor decimal(3,2), 
    estado VARCHAR(20), 
    dataLimite DATE, 
    dataEfetuado DATE, 
    idCliente INT
)
