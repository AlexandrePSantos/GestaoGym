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
    idFuncao INT REFERENCES Funcao(idFuncao), 
    nome VARCHAR(100), 
    email VARCHAR(50), 
    telemóvel INT, 
    NIF INT, 
    dtNascimento DATE, 
    salario DECIMAL(7,2)
)

CREATE TABLE PlanoTreino (
    numPlano INT PRIMARY KEY, 
    dtCriacao DATE, 
    descricao VARCHAR(200), 
    idFuncionario INT REFERENCES Funcionario(idFuncionario)
)-- constraint -> funcionario tem de ter funcao instrutor

CREATE TABLE Cliente (
    idCliente INT PRIMARY KEY, 
    nome VARCHAR(200), 
    idade INT, 
    email VARCHAR(100), 
    telemóvel INT, 
    dtNascimento DATE, 
    NIF INT, 
    numPlano INT REFERENCES PlanoTreino(numPlano)
)

CREATE TABLE HistoricoNutricao (
    idCliente INT REFERENCES Cliente(idCliente), 
    peso DECIMAL(4,1), 
    IMC DECIMAL(3,1), 
    massaGorda INT, 
    massaMagra INT
);

CREATE TABLE AulaGrupo (
    numAula INT PRIMARY KEY, 
    dataAula DATE, 
    idLocal INT REFERENCES PisoSala(idLocal), 
    tipoAula VARCHAR(1), 
    vagas INT, 
    duracao TIME,
    idFuncionario INT REFERENCES Funcionario(idFuncionario)
)

CREATE TABLE Consulta (
    numConsulta INT PRIMARY KEY, 
    dataConsulta DATE, 
    idLocal INT REFERENCES PisoSala(idLocal), 
    idFuncionario INT REFERENCES Funcionario(idFuncionario), 
    idCliente INT REFERENCES Cliente(idCliente)
)

CREATE TABLE Subscricao (
    idCliente INT REFERENCES Cliente(idCliente), 
    duracao INT, 
    dataIni DATE, 
    dataFim DATE,
    valMensal DECIMAL(5,2), 
    valTotal DECIMAL(5,2), 
    totEmFalta DECIMAL(5,2), 
    totPago DECIMAL(5,2), 
    estado VARCHAR(50)
);

CREATE TABLE linhaParticipante (
    numAula INT REFERENCES AulaGrupo(numAula), 
    idCliente INT REFERENCES Cliente(idCliente)
)

CREATE TABLE Relatorio (
    numConsulta INT REFERENCES Consulta(numConsulta), 
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
    valor decimal(5,2), 
    estado VARCHAR(20), 
    dataLimite DATE, 
    dataEfetuado DATE, 
    idCliente INT REFERENCES CLiente(idCliente)
);