-- ==============================
-- SCHEMA CORRIGIDO: APENAS PROFESSOR/USUARIO
-- ==============================

-- TABELA: tipo_usuario (Gerenciada aqui)
CREATE TABLE tipo_usuario (
    id_tipousuario SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

-- TABELA: usuario (Gerenciada aqui)
CREATE TABLE usuario (
    id_usuario SERIAL PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL,
    status BOOLEAN NOT NULL DEFAULT TRUE
);

-- RELAÇÃO N:N usuario <-> tipo_usuario (Gerenciada aqui)
CREATE TABLE usuario_tipousuario (
    id_usuario_tipousuario SERIAL PRIMARY KEY,
    id_usuario INT NOT NULL,
    id_tipousuario INT NOT NULL,
    CONSTRAINT fk_utu_usuario FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario) ON DELETE CASCADE,
    CONSTRAINT fk_utu_tipousuario FOREIGN KEY (id_tipousuario) REFERENCES tipo_usuario (id_tipousuario) ON DELETE CASCADE,
    CONSTRAINT uq_utu_usuario_tipo UNIQUE (id_usuario, id_tipousuario)
);

-- TABELA: escola (MINIMIZADA: Apenas para satisfazer a FK do Professor)
-- Na arquitetura ideal, esta tabela não deveria estar aqui, mas o modelo Professor copiado exige.
CREATE TABLE escola (
    id_escola SERIAL PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    status BOOLEAN NOT NULL DEFAULT TRUE,
    criacao_date DATE NOT NULL DEFAULT CURRENT_DATE
);

-- TABELA: professor (Gerenciada aqui)
CREATE TABLE professor (
    id_professor SERIAL PRIMARY KEY,
    id_usuario INT NOT NULL,
    id_escola INT NOT NULL, -- FK temporária, deve ser desacoplada
    registro_professor VARCHAR(50) UNIQUE NOT NULL,
    status_professor BOOLEAN NOT NULL DEFAULT TRUE,
    CONSTRAINT fk_professor_usuario FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario),
    CONSTRAINT fk_professor_escola FOREIGN KEY (id_escola) REFERENCES escola (id_escola)
);

-- TABELA: tipo_categoria (Formação Acadêmica - Gerenciada aqui)
CREATE TABLE tipo_categoria (
    id_tipo_categoria SERIAL PRIMARY KEY,
    nome_categoria VARCHAR(100) NOT NULL
);

-- TABELA: formacao_academica (Gerenciada aqui)
CREATE TABLE formacao_academica (
    id_formacao_academica SERIAL PRIMARY KEY,
    id_professor INT NOT NULL,
    id_tipo_categoria INT NOT NULL,
    nome_curso VARCHAR(150) NOT NULL,
    nome_instituicao_formacao VARCHAR(150) NOT NULL,
    ano_conclusao INT,
    CONSTRAINT fk_formacao_professor FOREIGN KEY (id_professor) REFERENCES professor (id_professor) ON DELETE CASCADE,
    CONSTRAINT fk_formacao_categoria FOREIGN KEY (id_tipo_categoria) REFERENCES tipo_categoria (id_tipo_categoria)
);

-- AS OUTRAS TABELAS (semestre, disciplina, horario_padrao, disponibilidade, professor_disciplina, turma)
-- FORAM REMOVIDAS, POIS PERTENCEM AO MS-ESCOLA!