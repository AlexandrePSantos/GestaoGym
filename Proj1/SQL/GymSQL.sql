CREATE TABLE Funcionario (
    idFuncionario INT PRIMARY KEY GENERATED always as IDENTITY , 
    nome VARCHAR(100), 
    email VARCHAR(100), 
    telemovel VARCHAR(20), 
    NIF VARCHAR(10), 
    dtNascimento DATE, 
    salarioLiquido DECIMAL(5,1),
    funcao VARCHAR(15)
);

CREATE TABLE Cliente (
    idCliente INT PRIMARY KEY GENERATED always as IDENTITY , 
    nome VARCHAR(200), 
    idade INT, 
    email VARCHAR(100), 
    telemovel VARCHAR(20), 
    NIF VARCHAR(10),
    dtNascimento DATE,
    cPostal VARCHAR(10) 
);

CREATE TABLE Subscricao (
    numSubscricao INT PRIMARY KEY GENERATED always as IDENTITY , 
    duracao VARCHAR(200), 
    dataIni DATE, 
    dataFim DATE, 
    valor DECIMAL(5,2), 
    modalidade INT,
    estado VARCHAR(10),
    idCliente INT REFERENCES Cliente(idCliente)
);

CREATE TABLE Pagamento (
    numPagamento INT PRIMARY KEY GENERATED always as IDENTITY , 
    valor DECIMAL(5,2), 
    estado VARCHAR(200), 
    dataPagamento DATE, 
    metodo VARCHAR(15), 
    referencia VARCHAR(12),
    entidade VARCHAR(6),
    numSubscricao INT REFERENCES Subscricao(numSubscricao)
);

CREATE TABLE Sala (
    idSala INT PRIMARY KEY GENERATED always as IDENTITY ,
    sala VARCHAR(50)
);

CREATE TABLE AulaGrupo (
    numAula INT PRIMARY KEY GENERATED always as IDENTITY , 
    dataAula DATE, 
    tipoAula VARCHAR(50), 
    vagas INT, 
    vagasDisp INT,
    duracao INT,
    idSala INT REFERENCES Sala(idSala), 
    idFuncionario INT REFERENCES Funcionario(idFuncionario)
);

CREATE TABLE linhaparticipante (
    id_linhaPart INT PRIMARY KEY GENERATED always as IDENTITY ,
    numAula INT REFERENCES Aulagrupo(numAula), 
    idCliente INT REFERENCES Cliente(idCliente)
);

CREATE TABLE Equipamento ( 
    idEquipamento INT PRIMARY KEY GENERATED always as IDENTITY ,
    nome VARCHAR(100)
);

CREATE TABLE Exercicio (
    idExercicio INT PRIMARY KEY GENERATED always as IDENTITY ,
    nome VARCHAR(20),
    idEquipamento INT REFERENCES Equipamento(idEquipamento)
);

CREATE TABLE PlanoTreino (
    numPlano INT PRIMARY KEY GENERATED always as IDENTITY , 
    dtCriacao DATE, 
    estado VARCHAR(20), 
    idFuncionario INT REFERENCES Funcionario(idFuncionario),
    idCliente INT REFERENCES Cliente(idCliente)
); 

CREATE TABLE linhaExercicio (
    id_linhaEx INT PRIMARY KEY GENERATED always as IDENTITY ,
    idExercicio INT REFERENCES Exercicio(idExercicio),
    numPlano INT REFERENCES PlanoTreino(numPlano),
    peso DECIMAL(4,1),
    sets INT,
    reps INT,
    velocidade INT,
    duracao INT
);