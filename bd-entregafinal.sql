CREATE DATABASE IF NOT EXISTS Proj_Estacionamento;

USE Proj_Estacionamento;

CREATE TABLE IF NOT EXISTS Veiculos (
    placa VARCHAR(15),
    cor VARCHAR(20),
    modelo VARCHAR(20),

    PRIMARY KEY(placa)
);

CREATE TABLE IF NOT EXISTS Clientes (
    cpf VARCHAR(15),
    nome VARCHAR(50),
    email VARCHAR(100),
    placa_veiculo VARCHAR(15),

    PRIMARY KEY (cpf),
    CONSTRAINT fk1 FOREIGN KEY(placa_veiculo) REFERENCES Veiculos(placa)
);

CREATE TABLE IF NOT EXISTS Vagas (
    num  INT,
    disponivel tinyint,
    placa_veiculo VARCHAR(15),

    PRIMARY KEY (num),
    CONSTRAINT fk2 FOREIGN KEY(placa_veiculo) REFERENCES Veiculos(placa)
);

CREATE TABLE IF NOT EXISTS Funcionario (
  cpf VARCHAR(20),
  nome VARCHAR(50) NULL,
  email VARCHAR(100) NULL,

  PRIMARY KEY (cpf)
);

CREATE TABLE IF NOT EXISTS Vagas_has_Funcionario (
  num_vaga INT,
  cpf_funcionario VARCHAR(20),

  PRIMARY KEY (num_vaga, cpf_funcionario),
  CONSTRAINT fk3 FOREIGN KEY(num_vaga) REFERENCES Vagas(num),
  CONSTRAINT fk4 FOREIGN KEY(cpf_funcionario) REFERENCES Funcionario(cpf)
);