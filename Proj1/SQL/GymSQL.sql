CREATE TABLE Funcionario (
    id_funcionario INT PRIMARY KEY GENERATED always as IDENTITY , 
    nome VARCHAR(100), 
    email VARCHAR(100), 
    telemovel VARCHAR(20), 
    nif VARCHAR(10), 
    dt_nascimento DATE, 
    salario_liquido DECIMAL(5,1),
    funcao VARCHAR(15)
);

CREATE TABLE Cliente (
    id_cliente INT PRIMARY KEY GENERATED always as IDENTITY , 
    nome VARCHAR(200), 
    idade INT, 
    email VARCHAR(100), 
    telemovel VARCHAR(20), 
    nif VARCHAR(10),
    dt_nascimento DATE,
    cod_postal VARCHAR(10) 
);

CREATE TABLE Subscricao (
    num_subscricao INT PRIMARY KEY GENERATED always as IDENTITY , 
    duracao VARCHAR(200), 
    data_ini DATE, 
    data_fim DATE, 
    valor DECIMAL(5,2), 
    modalidade INT,
    estado VARCHAR(10),
    id_cliente INT REFERENCES Cliente(id_cliente)
);

CREATE TABLE Pagamento (
    num_pagamento INT PRIMARY KEY GENERATED always as IDENTITY , 
    valor DECIMAL(5,2), 
    estado VARCHAR(200), 
    data_pagamento DATE, 
    metodo VARCHAR(15), 
    referencia VARCHAR(12),
    entidade VARCHAR(6),
    num_subscricao INT REFERENCES Subscricao(num_subscricao)
);

CREATE TABLE Sala (
    id_sala INT PRIMARY KEY GENERATED always as IDENTITY ,
    sala VARCHAR(50)
);

CREATE TABLE Aulagrupo (
    num_aula INT PRIMARY KEY GENERATED always as IDENTITY , 
    data_aula DATE, 
    tipo_aula VARCHAR(50), 
    vagas INT, 
    vagas_disp INT,
    duracao INT,
    id_sala INT REFERENCES Sala(id_sala), 
    id_funcionario INT REFERENCES Funcionario(id_funcionario)
);

CREATE TABLE Linhaparticipante (
    id_linhaPart INT PRIMARY KEY GENERATED always as IDENTITY ,
    num_aula INT REFERENCES Aulagrupo(num_aula), 
    id_cliente INT REFERENCES Cliente(id_cliente)
);

CREATE TABLE Equipamento ( 
    id_equipamento INT PRIMARY KEY GENERATED always as IDENTITY ,
    nome VARCHAR(100)
);

CREATE TABLE Exercicio (
    id_exercicio INT PRIMARY KEY GENERATED always as IDENTITY ,
    nome VARCHAR(20),
    id_equipamento INT REFERENCES Equipamento(id_equipamento)
);

CREATE TABLE Planotreino (
    num_plano INT PRIMARY KEY GENERATED always as IDENTITY , 
    dt_criacao DATE, 
    estado VARCHAR(20), 
    id_funcionario INT REFERENCES Funcionario(id_funcionario),
    id_cliente INT REFERENCES Cliente(id_cliente)
); 

CREATE TABLE Linhaexercicio (
    id_linhaEx INT PRIMARY KEY GENERATED always as IDENTITY ,
    id_exercicio INT REFERENCES Exercicio(id_exercicio),
    num_plano INT REFERENCES Planotreino(num_plano),
    peso DECIMAL(4,1),
    sets INT,
    reps INT,
    velocidade INT,
    duracao DECIMAL(4,2)
);