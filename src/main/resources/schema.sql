-- Script de criação das tabelas para o MySQL

-- Tabela Beneficiarios
CREATE TABLE beneficiarios (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    data_nascimento DATE NOT NULL,
    data_inclusao DATE NOT NULL,
    data_atualizacao DATE NOT NULL
);

-- Tabela Documentos
CREATE TABLE documentos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    tipo_documento VARCHAR(255) NOT NULL,
    descricao TEXT NOT NULL,
    data_inclusao DATE NOT NULL,
    data_atualizacao DATE NOT NULL,
    beneficiario_id INT NOT NULL,
    FOREIGN KEY (beneficiario_id) REFERENCES beneficiarios(id)
);
