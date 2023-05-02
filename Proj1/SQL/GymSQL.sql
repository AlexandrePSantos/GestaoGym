CREATE TABLE Funcionario (
    idFuncionario INT PRIMARY KEY, 
    nome VARCHAR(100), 
    email VARCHAR(100), 
    telemovel VARCHAR(10), 
    NIF VARCHAR(10), 
    dtNascimento DATE, 
    salarioLiquido DECIMAL(5,1),
    funcao VARCHAR(50)
);

CREATE TABLE Cliente (
    idCliente INT PRIMARY KEY, 
    nome VARCHAR(200), 
    idade INT, 
    email VARCHAR(100), 
    telemovel VARCHAR(10), 
    NIF VARCHAR(10),
    dtNascimento DATE,
    cPostal VARCHAR(8) 
);

CREATE TABLE Sala (
    idSala INT PRIMARY KEY,
    sala VARCHAR(50)
);

CREATE TABLE AulaGrupo (
    numAula INT PRIMARY KEY, 
    dataAula DATE, 
    tipoAula VARCHAR(50), 
    vagas INT, 
    vagasDisp INT,
    duracao INT,
    idSala INT REFERENCES Sala(idSala), 
    idFuncionario INT REFERENCES Funcionario(idFuncionario)
);

CREATE TABLE linhaParticipante (
    id_linhaPart INT PRIMARY KEY,
    numAula INT REFERENCES AulaGrupo(numAula), 
    idCliente INT REFERENCES Cliente(idCliente)
);

CREATE TABLE Subscricao (
    numSubscricao INT PRIMARY KEY,
    idCliente INT REFERENCES Cliente(idCliente),
    duracao INT,
    dataIni DATE, 
    dataFim DATE,
    valEmFalta DECIMAL(5,2), 
    valTotal DECIMAL(5,2), 
    estado VARCHAR(50)
);

CREATE TABLE Pagamento (
    numPagamento INT PRIMARY KEY,
    valor decimal(5,2), 
    estado VARCHAR(20), 
    dataLimite DATE, 
    dataEfetuado DATE,
    metodoPag VARCHAR(100),
    referencia VARCHAR(10),
    entidade VARCHAR(6),
    numSubscricao INT REFERENCES Subscricao(numSubscricao)
);

CREATE TABLE Equipamento ( 
    idEquipamento INT PRIMARY KEY,
    nome VARCHAR(100)
);

CREATE TABLE Exercicio (
    idExercicio INT PRIMARY KEY,
    nome VARCHAR(20),
    idEquipamento INT REFERENCES Equipamento(idEquipamento)
);

CREATE TABLE PlanoTreino (
    numPlano INT PRIMARY KEY, 
    dtCriacao DATE, 
    estado VARCHAR(20), 
    idFuncionario INT REFERENCES Funcionario(idFuncionario),
    idCliente INT REFERENCES Cliente(idCliente)
); 

CREATE TABLE linhaExercicio (
    id_linhaEx INT PRIMARY KEY,
    idExercicio INT REFERENCES Exercicio(idExercicio),
    numPlano INT REFERENCES PlanoTreino(numPlano),
    peso DECIMAL(4,1),
    sets INT,
    reps INT,
    velocidade INT,
    duracao INT
);