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
)

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
    peso DECIMAL(3,2), 
    IMC DECIMAL(2,1), 
    massaGorda INT, 
    massaMagra INT
)

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
    idCliente INT PRIMARY KEY REFERENCES Cliente(idCliente), 
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
    numAula INT PRIMARY KEY REFERENCES AulaGrupo(numAula), 
    idCliente INT PRIMARY KEY REFERENCES Cliente(idCliente)
)

CREATE TABLE Relatorio (
    numConsulta INT PRIMARY KEY REFERENCES Consulta(numConsulta), 
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
    idCliente INT REFERENCES CLiente(idCliente)
)
