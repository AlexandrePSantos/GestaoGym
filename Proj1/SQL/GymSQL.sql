CREATE DATABASE gymManagement;

USE gymManagement;

CREATE TABLE Funcao (
    idFuncao INT PRIMARY KEY,
    descricao VARCHAR(100)
);

CREATE TABLE PisoSala (
    idLocal INT PRIMARY KEY,
    piso VARCHAR(1),
    sala VARCHAR(2)
);

CREATE TABLE Funcionario (
    idFuncionario INT PRIMARY KEY, 
    idFuncao INT REFERENCES Funcao(idFuncao), 
    nome VARCHAR(100), 
    email VARCHAR(100), 
    telemóvel VARCHAR(10), 
    NIF VARCHAR(10), 
    dtNascimento DATE, 
    salario DECIMAL(7,2)
);

CREATE TABLE Cliente (
    idCliente INT PRIMARY KEY, 
    nome VARCHAR(200), 
    email VARCHAR(100), 
    telemóvel VARCHAR(10), 
    dtNascimento DATE, 
    NIF VARCHAR(10)
);

CREATE TABLE Equipamento ( 
    idEquipamento INT PRIMARY KEY,
    nome VARCHAR(100)
);

CREATE TABLE PlanoTreino (
    numPlano INT PRIMARY KEY, 
    dtCriacao DATE, 
    descricao VARCHAR(200), 
    idFuncionario INT REFERENCES Funcionario(idFuncionario),
    idCliente INT REFERENCES Cliente(idCliente)
);-- constraint -> funcionario tem de ter funcao instrutor

CREATE TABLE Exercicio (
    idExercicio INT PRIMARY KEY,
    sets INT,
    repeticoes INT,
    duracao DECIMAL(4,2),
    idEquipamento INT REFERENCES Equipamento(idEquipamento)
);

CREATE TABLE linhaExercicio (
    idExercicio INT REFERENCES Exercicio(idExercicio),
    numPlano INT REFERENCES PlanoTreino(numPlano),
    peso DECIMAL(4,1),
    velocidade DECIMAL(4,2),
    sets INT,
    reps INT
);

CREATE TABLE HistoricoNutricao (
    nrHist INT PRIMARY KEY,
    idCliente INT REFERENCES Cliente(idCliente), 
    data Date,
    peso DECIMAL(4,1), 
    IMC DECIMAL(3,1), 
    massaGorda INT, 
    massaMagra INT
);

CREATE TABLE AulaGrupo (
    numAula INT PRIMARY KEY, 
    dataAula DATE, 
    tipoAula VARCHAR(50), 
    vagas INT, 
    vagasDisp INT,
    duracao DECIMAL(4,2),
    idLocal INT REFERENCES PisoSala(idLocal), 
    idFuncionario INT REFERENCES Funcionario(idFuncionario)
);

CREATE TABLE Consulta (
    numConsulta INT PRIMARY KEY, 
    dataConsulta DATE, 
    idLocal INT REFERENCES PisoSala(idLocal), 
    idFuncionario INT REFERENCES Funcionario(idFuncionario), 
    idCliente INT REFERENCES Cliente(idCliente)
);

CREATE TABLE Subscricao (
    numSubscricao INT PRIMARY KEY,
    idCliente INT REFERENCES Cliente(idCliente), 
    duracao DECIMAL(4,2), 
    dataIni DATE, 
    dataFim DATE,
    totEmFalta DECIMAL(5,2), 
    totPago DECIMAL(5,2), 
    estado VARCHAR(50)
);

CREATE TABLE linhaParticipante (
    numAula INT REFERENCES AulaGrupo(numAula), 
    idCliente INT REFERENCES Cliente(idCliente)
);

CREATE TABLE Relatorio (
    numConsulta INT REFERENCES Consulta(numConsulta), 
    dataEmissao DATE, 
    descricao VARCHAR(200)
);

CREATE TABLE RestricaoSaude (
    idRestricao INT PRIMARY KEY,
    descricao VARCHAR(200)
);

CREATE TABLE LinhaRestricao (
    idRestricao INT REFERENCES RestricaoSaude(idRestricao), 
    idCliente INT REFERENCES Cliente(idCliente)
);

CREATE TABLE Pagamento (
    numPagamento INT PRIMARY KEY,
    valor decimal(5,2), 
    estado VARCHAR(20), 
    dataLimite DATE, 
    dataEfetuado DATE,
    metodoPag VARCHAR(100),
    numSubscricao INT REFERENCES Subscricao(numSubscricao)
);
